package missile;

import home.Home;
import land.HardWall;
import land.Wall;
import pve.TankPlayer1;
import pve.TankPlayer2;
import tank.Tank;
import explode.Explode;
import ui.GameFrame;
import utils.MusicUtils;

import java.awt.*;
import java.util.List;

/**
 * 普通导弹类
 */
public class Missile {
    public static final int WIDTH = 4;
    public static final int HEIGHT = 4;
    private static int hurt = 20; // 子弹伤害
    private static int speed = 4;
    private static int botSpeed = 4;
    private static int missileColor = 0;
    private static int count = 0; // 击毁坦克数量
    Tank.Direction towardDirection;
    // 位置
    private int x;
    private int y;
    private boolean good; // 敌我坦克
    private boolean alive = true;

    /**
     * 导弹的构造方法
     *
     * @param x               导弹的x坐标
     * @param y               导弹的y坐标
     * @param good            导弹的属性
     * @param towardDirection 导弹的方向
     */
    public Missile(int x, int y, Boolean good, Tank.Direction towardDirection) {
        this.x = x;
        this.y = y;
        this.good = good;
        this.towardDirection = towardDirection;
    }

    public static void setMissileColor(int missileColor) {
        Missile.missileColor = missileColor;
    }

    /**
     * 获得击毁的坦克的数量
     *
     * @return 返回击毁的坦克的数量
     */
    public static int getCount() {
        return count;
    }

    /**
     * 设置击毁坦克数量
     *
     * @param count 传入击毁的坦克数量参数
     */
    public static void setCount(int count) {
        Missile.count = count;
    }

    /**
     * 设置导弹的速度
     *
     * @param botSpeed 导弹的新速度
     */
    public static void setBotSpeed(int botSpeed) {
        Missile.botSpeed = botSpeed;
    }

    /**
     * 获取导弹的伤害
     *
     * @return 返回导弹的伤害
     */
    public static int getHurt() {
        return hurt;
    }

    /**
     * 设置导弹的伤害
     *
     * @param hurt 导弹的新伤害
     */
    public static void setHurt(int hurt) {
        Missile.hurt = hurt;
    }

    /**
     * 返回导弹是否存活
     *
     * @return 返回导弹是否存活
     */
    public boolean isAlive() {
        return alive;
    }

    public void draw(Graphics g) {
        if (!alive) {
            return;
        } else if (good) {
            g.setColor(Color.WHITE);
            g.fillOval(x, y, WIDTH, HEIGHT);
        } else if (missileColor == 0) {
            g.setColor(Color.yellow);
            g.fillOval(x, y, WIDTH, HEIGHT);
        } else if (missileColor == 1) {
            g.setColor(new Color(184, 134, 11));
            g.fillOval(x, y, WIDTH, HEIGHT);
        } else if (missileColor == 2) {
            g.setColor(new Color(125, 56, 125));
            g.fillOval(x, y, WIDTH, HEIGHT);
        } else if (missileColor == 3) {
            g.setColor(Color.green);
            g.fillOval(x, y, WIDTH, HEIGHT);
        }
        move(); // 移动子弹
    }

    /**
     * 子弹移动
     */
    public void move() {
        if (!good) {
            speed = botSpeed;
        } else {
            speed = 5;
        }
        switch (towardDirection) {
            case U:
                y -= speed;
                break;
            case D:
                y += speed;
                break;
            case L:
                x -= speed;
                break;
            case R:
                x += speed;
                break;
            case STOP:
                break;
        }
        // 飞出屏幕就消失
        if (x < 0 || y < 0 || x > 800 || y > 600) {
            alive = false;
        }
    }

    /**
     * 获得导弹的轮廓
     *
     * @return 返回导弹的轮廓
     */
    public Rectangle getRect() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    /**
     * 击中玩家一坦克
     * @param t 需要击中的坦克
     * @return 返回是否击毁
     */
    public boolean hitTank(Tank t) {
        if (this.alive && this.getRect().intersects(t.getRect()) && t.isAlive() && this.good != t.isGood()) {
            if (t.isGood()) {//玩家被击中减血
                t.setLife(t.getLife() - hurt);
                if (t.getLife() <= 0) {
                    t.setLife(0);
                    t.setAlive(false);
                }
            } else {//敌方直接死
                t.setAlive(false);
                count++;
            }
            this.alive = false;
            new Thread(new MusicUtils(MusicUtils.PLAY_EXPLODE)).start();
            Explode e = new Explode(x, y);
            GameFrame.explodeList.add(e);
            return true;
        }
        return false;
    }

    /**
     * 击中玩家二坦克
     * @param t 需要击中的坦克
     * @return 返回是否击毁
     */
    public boolean hitTank2(TankPlayer2 t) {
        if (this.alive && this.getRect().intersects(t.getRect()) && t.isAlive() && this.good != t.isGood()) {
            if (t.isGood()) {//玩家被击中减血
                t.setLife(t.getLife() - hurt);
                if (t.getLife() <= 0) {
                    t.setLife(0);
                    t.setAlive(false);
                }
            } else {//敌方直接死
                t.setAlive(false);
                count++;
            }
            this.alive = false;
            new Thread(new MusicUtils(MusicUtils.PLAY_EXPLODE)).start();
            Explode e = new Explode(x, y);
            GameFrame.explodeList.add(e);
            return true;
        }
        return false;
    }

    /**
     * 击中一堆坦克
     *
     * @param tanks 坦克集合
     */
    public void hitTanks(List<Tank> tanks) {
        tanks.removeIf(this::hitTank);
    }

    /**
     * 击中墙壁
     *
     * @param w 击中的墙壁
     */
    public void hitWalls(Wall w) { // 子弹打到普通墙上
        if (this.alive && this.getRect().intersects(w.getRect())) {
            this.alive = false;//子弹消失
            GameFrame.wallList.remove(w); // 子弹打到墙上时则移除此击中墙
        }
    }

    /**
     * 击中金属墙
     *
     * @param hw 击中的金属墙
     */
    public void hitWalls(HardWall hw) {
        if (this.alive && this.getRect().intersects(hw.getRect())) {
            this.alive = false;//子弹消失
        }
    }

    /**
     * 击中基地
     */
    public void hitHome() { // 当子弹打到家时
        if (this.alive && this.getRect().intersects(GameFrame.home.getRect())) {
            this.alive = false;
            Home.setAlive(false); // 基地接受一枪就死亡
        }
    }
}
