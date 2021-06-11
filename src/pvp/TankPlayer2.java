package pvp;

import home.Home;
import land.HardWall;
import land.River;
import land.Wall;
import prop.Supply;
import tank.Tank;
import ui.DoubleFrame;
import utils.ImageUtils;
import utils.MusicUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Random;

/**
 * pvp模式下玩家二坦克类
 */
public class TankPlayer2 extends Tank implements KeyListener {
    static int speed = 4;//坦克初始速度
    boolean bU = false, bD = false, bL = false, bR = false;
    private int x;
    private int y;//坦卡坐标
    private int oldX;
    private int oldY;//坦克上一步坐标
    private int life = 200;//坦克生命值
    private boolean alive = true;//坦克存活状态
    public static final int TANK1_WIDTH = 40;
    public static final int TANK1_HEIGHT = 40;
    private Direction direction = Direction.STOP;
    private Direction towardDirection = Direction.U;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isAlive() {
        return alive;
    }

    /**
     * 设置坦克的位置和方向
     *
     * @param x         坦克的新x坐标
     * @param y         坦克的新y坐标
     * @param direction 坦克的新方向
     */
    public void setTankLocation(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public boolean isGood() {
        return false;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public void changToOldDirection() {

    }

    /**
     * 判断子弹是否进入坦克范围
     */
    public Rectangle getRect() {
        return new Rectangle(x, y, TANK1_WIDTH, TANK1_HEIGHT);
    }

    /**
     * 玩家二坦克的构造方法
     *
     * @param x 初始横坐标参数
     * @param y 初始纵坐标位置
     */
    public TankPlayer2(int x, int y) {
        this.x = x;
        this.y = y;
        this.oldX = x;
        this.oldY = y;
    }

    /**
     * 玩家二坦克的构造方法
     *
     * @param x         初始横坐标参数
     * @param y         初始纵坐标位置
     * @param direction 初始坦克方向
     */
    public TankPlayer2(int x, int y, Direction direction) {
        this(x, y);
        this.direction = direction;
    }

    /**
     * 绘制玩家二的坦克
     *
     * @param g Graphics类用于绘图
     */
    public void draw(Graphics g) {
        if (alive) {
            switch (towardDirection) {
                case U:
                    g.drawImage(ImageUtils.W_TANK_U, x, y, null);
                    break;
                case D:
                    g.drawImage(ImageUtils.W_TANK_D, x, y, null);
                    break;
                case L:
                    g.drawImage(ImageUtils.W_TANK_L, x, y, null);
                    break;
                case R:
                    g.drawImage(ImageUtils.W_TANK_R, x, y, null);
                    break;
            }
        }
        move();
    }

    @Override
    public boolean collideWithWall(Wall w) {
        return false;
    }

    @Override
    public boolean collideWithHardWall(HardWall w) {
        return false;
    }

    @Override
    public boolean collideWithRiver(River r) {
        return false;
    }

    @Override
    public boolean collideWithTanks(List<Tank> l) {
        return false;
    }

    @Override
    public boolean collideWithHome(Home h) {
        return false;
    }

    /**
     * 坦克移动
     */
    public void move() {
        this.oldX = x;
        this.oldY = y;
        switch (direction) {
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
        }
        //改变坦克方向
        if (this.direction != Direction.STOP) {
            this.towardDirection = this.direction;
        }
        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (x > 758) x = 758;
        if (y > 511) y = 511;
    }

    /**
     * 玩家发射子弹方法，并将子弹加入玩家一子弹列表中
     */
    public void fire() {
        int x = this.x + 15;
        int y = this.y + 15;
        MissilePlayer2 missilePlayer2 = new MissilePlayer2(x, y, towardDirection);
        DoubleFrame.missilePlayer2List.add(missilePlayer2);
    }

    /**
     * 玩家一坦克移动方向
     */
    public void setDirection() {
        if (bL && !bU && !bR && !bD) direction = Direction.L;
        else if (!bL && bU && !bR && !bD) direction = Direction.U;
        else if (!bL && !bU && bR && !bD) direction = Direction.R;
        else if (!bL && !bU && !bR && bD) direction = Direction.D;
        else if (!bL && !bU && !bR) direction = Direction.STOP;
    }

    /**
     * 撞击后复位
     */
    public void changeToOldDirection() {
        this.x = oldX;
        this.y = oldY;
    }

    /**
     * 判断坦克是否相撞
     *
     * @param tankPlayer1 玩家一的坦克
     */
    public void collideWithTank(TankPlayer1 tankPlayer1) {
        if (this.alive && tankPlayer1.isAlive() && this.getRect().intersects(tankPlayer1.getRect())) {
            this.changeToOldDirection();
        }
    }

    public void eat(Supply supply) {
        if (this.alive && this.getRect().intersects(supply.getRect())) {
            if (this.life <= 100) {
                this.life += 100; //吃下补给，增加100生命点
            } else {
                this.life = 200;
            }
            new Thread(new MusicUtils(MusicUtils.PLAY_EAT)).start();
            MissilePlayer2.setHurt(40);//增加导弹威力
            Random random = new Random();
            Supply.setSupplyPosition(random.nextInt(300) + 200, random.nextInt(300) + 200);
        }
    }

    /**
     * 为玩家二坦克绑定键盘键位
     *
     * @param e KeyEvent类设置键位
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch ((e.getKeyCode())) {
            case KeyEvent.VK_UP:
                bU = true;
                break;
            case KeyEvent.VK_DOWN:
                bD = true;
                break;
            case KeyEvent.VK_LEFT:
                bL = true;
                break;
            case KeyEvent.VK_RIGHT:
                bR = true;
                break;
            case KeyEvent.VK_P:
                if (!alive) return;
                fire();
                new Thread(new MusicUtils(MusicUtils.PLAY_FIRE)).start();// 开火的音效
                break;
            case KeyEvent.VK_R:
                break;
        }
        setDirection();
    }

    /**
     * 键盘键位被弹起后的行为
     *
     * @param e KeyEvent类设置键位
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
        }
        setDirection();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //TODO
    }

}
