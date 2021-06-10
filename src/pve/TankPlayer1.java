package pve;

import home.Home;
import land.HardWall;
import land.River;
import land.Wall;
import missile.Missile;
import tank.Tank;
import ui.GameFrame;
import utils.ImageUtils;
import utils.MusicUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Random;

/**
 * 坦克类
 */
public class TankPlayer1 extends Tank implements KeyListener {
    private int x; // 坐标
    private int y;
    private int oldX; // 原来的坐标
    private int oldY;

    /**
     * 坦克初始速度
     */
    public static final int TANK_SPEED = 3;

    /**
     * 坦克的宽度
     */
    public static final int TANK_WIDTH = 35;

    /**
     * 坦克的高度
     */
    public static final int TANK_HEIGHT = 35;

    private static int speed = TANK_SPEED;
    private static int botSpeed = TANK_SPEED;

    private static int tankColor = 0; // 坦克颜色

    private int life = 100; // 初始生命值为100
    private boolean alive = true;
    private boolean good; // 敌我

    private static Random random = new Random(); // 用于产生随机数
    private int step; // 通过random生成，产生坦克的数量

    boolean bU = false, bD = false, bL = false, bR = false;

    private Tank.Direction direction = Tank.Direction.STOP;
    private Direction towardDirection = Direction.U;


    /**
     * 设置x坐标
     *
     * @param x 新x坐标
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 获得x坐标
     *
     * @return x坐标
     */
    public int getX() {
        return x;
    }

    /**
     * 设置y坐标
     *
     * @param y 新y坐标
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 获得y坐标
     *
     * @return y坐标
     */
    public int getY() {
        return y;
    }

    /**
     * 设置新的坐标
     *
     * @param x 新x坐标
     * @param y 新y坐标
     */
    public void setXY(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * 设置坦克的颜色
     *
     * @param tankColor 坦克的新颜色
     */
    public static void setTankColor(int tankColor) {
        TankPlayer1.tankColor = tankColor;
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

    /**
     * 获得坦克的生命值
     *
     * @return 坦克的生命值
     */
    public int getLife() {
        return life;
    }

    /**
     * 设置坦克的生命值
     *
     * @param life 坦克的新生命值
     */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     * 坦克是否存活
     *
     * @return 坦克是否存活
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * 设置坦克是否存活
     *
     * @param alive 坦克是否存活
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * 坦克好坏
     *
     * @return 坦克好坏
     */
    public boolean isGood() {
        return good;
    }

    /**
     * 设置坦克好坏
     *
     * @param good 坦克好坏
     */
    public void setGood(boolean good) {
        this.good = good;
    }

    /**
     * 设置敌方坦克速度
     *
     * @param botSpeed 机器人的新速度
     */
    public static void setBotSpeed(int botSpeed) {
        TankPlayer1.botSpeed = botSpeed;
    }

    /**
     * 获得坦克的轮廓
     *
     * @return 坦克的轮廓
     */
    public Rectangle getRect() {
        return new Rectangle(x, y, TANK_WIDTH, TANK_HEIGHT);
    }

    /**
     * 坦克的构造方法
     *
     * @param x    坦克的x坐标
     * @param y    坦克的y坐标
     * @param good 坦克的属性
     */
    public TankPlayer1(int x, int y, boolean good) {
        this.x = x;
        this.y = y;
        this.good = good;
        this.oldX = x;
        this.oldY = y;
    }

    /**
     * 坦克的构造方法
     *
     * @param x         坦克的x坐标
     * @param y         坦克的y坐标
     * @param good      坦克的属性
     * @param direction 坦克的方向
     */
    public TankPlayer1(int x, int y, boolean good, Direction direction) {
        this(x, y, good);
        this.direction = direction;
    }

    /**
     * 绘制坦克
     *
     * @param g Graphics类用于绘图
     */
    public void draw(Graphics g) {
        if (alive && good) {
            switch (towardDirection) {
                case U:
                    g.drawImage(ImageUtils.TANK_U, x, y, null);
                    break;
                case D:
                    g.drawImage(ImageUtils.TANK_D, x, y, null);
                    break;
                case L:
                    g.drawImage(ImageUtils.TANK_L, x, y, null);
                    break;
                case R:
                    g.drawImage(ImageUtils.TANK_R, x, y, null);
                    break;
            }
        } else if (alive && tankColor == 0) {
            switch (towardDirection) {
                case U:
                    g.drawImage(ImageUtils.E_TANK_U, x, y, null);
                    break;
                case D:
                    g.drawImage(ImageUtils.E_TANK_D, x, y, null);
                    break;
                case L:
                    g.drawImage(ImageUtils.E_TANK_L, x, y, null);
                    break;
                case R:
                    g.drawImage(ImageUtils.E_TANK_R, x, y, null);
                    break;
            }
        } else if (alive && tankColor == 1) {
            switch (towardDirection) {
                case U:
                    g.drawImage(ImageUtils.E1_TANK_U, x, y, null);
                    break;
                case D:
                    g.drawImage(ImageUtils.E1_TANK_D, x, y, null);
                    break;
                case L:
                    g.drawImage(ImageUtils.E1_TANK_L, x, y, null);
                    break;
                case R:
                    g.drawImage(ImageUtils.E1_TANK_R, x, y, null);
                    break;
            }
        } else if (alive && tankColor == 2) {
            switch (towardDirection) {
                case U:
                    g.drawImage(ImageUtils.E2_TANK_U, x, y, null);
                    break;
                case D:
                    g.drawImage(ImageUtils.E2_TANK_D, x, y, null);
                    break;
                case L:
                    g.drawImage(ImageUtils.E2_TANK_L, x, y, null);
                    break;
                case R:
                    g.drawImage(ImageUtils.E2_TANK_R, x, y, null);
                    break;
            }
        } else if (alive && tankColor == 3) {
            switch (towardDirection) {
                case U:
                    g.drawImage(ImageUtils.E3_TANK_U, x, y, null);
                    break;
                case D:
                    g.drawImage(ImageUtils.E3_TANK_D, x, y, null);
                    break;
                case L:
                    g.drawImage(ImageUtils.E3_TANK_L, x, y, null);
                    break;
                case R:
                    g.drawImage(ImageUtils.E3_TANK_R, x, y, null);
                    break;
            }


        }
        move();
    }

    /**
     * 坦克移动
     */
    public void move() {
        this.oldX = x;
        this.oldY = y;
        if (!good) {
            speed = botSpeed;
        } else {
            speed = 3;
        }
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
        // 改变坦克的方向
        if (this.direction != Direction.STOP) {
            this.towardDirection = this.direction;
        }
        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (x > 758) x = 758;
        if (y > 511) y = 511;

        if (!good) {
            Direction[] directions = Direction.values();
            if (step == 0) {
                step = random.nextInt(20) + 20; // 一步
                int rn = random.nextInt(4);
                direction = directions[rn];
            }
            step--;
            if (random.nextInt(40) > 36) {
                this.fire();
            }
        }
    }

    /**
     * 发射一枚导弹
     *
     * @return 返回产生的导弹
     */
    public Missile fire() {
        int x = this.x + 15;
        int y = this.y + 15;
        Missile m = new Missile(x, y, good, towardDirection);
        GameFrame.missileList.add(m);
        return m;
    }

    /**
     * 设置坦克的反向
     */
    public void setDirection() {
        if (bL && !bU && !bR && !bD) direction = Direction.L;
        else if (!bL && bU && !bR && !bD) direction = Direction.U;
        else if (!bL && !bU && bR && !bD) direction = Direction.R;
        else if (!bL && !bU && !bR && bD) direction = Direction.D;
        else if (!bL && !bU && !bR) direction = Direction.STOP;
    }

    /**
     * 存放撞击前的坐标
     */
    private void changToOldDirection() {
        this.x = oldX;
        this.y = oldY;
    }

    /**
     * 判断坦克是否撞击普通墙
     *
     * @param w 判定的墙体
     * @return 返回判定结果
     */
    public boolean collideWithWall(Wall w) {
        if (this.alive && this.getRect().intersects(w.getRect())) {
            this.changToOldDirection();
            return true;
        }
        return false;
    }

    /**
     * 判断坦克是否撞击基地
     *
     * @param home 基地
     * @return 返回判定结果
     */
    public boolean collideWithHome(Home home) {
        if (this.alive && this.getRect().intersects(home.getRect())) {
            this.changToOldDirection();
            return true;
        }
        return false;
    }

    /**
     * 判断坦克是否撞击金属墙
     *
     * @param hw 需要判定的金属墙
     * @return 返回判定结果
     */
    public boolean collideWithHardWall(HardWall hw) {
        if (this.alive && this.getRect().intersects(hw.getRect())) {
            this.changToOldDirection();
            return true;
        }
        return false;
    }

    /**
     * 判断坦克是否撞击河流
     *
     * @param river 需要判定的河流
     * @return 返回判定结果
     */
    public boolean collideWithRiver(River river) {
        if (this.alive && this.getRect().intersects(river.getRect())) {
            this.changToOldDirection();
            return true;
        }
        return false;
    }

    /**
     * 判断坦克是否撞击坦克
     *
     * @param tanks 需要判定的坦克
     * @return 返回判定结果
     */
    public boolean collideWithTanks(List<TankPlayer1> tanks) {
        for (TankPlayer1 t : tanks) {
            if (this != t) {
                if (this.alive && t.isAlive() && this.getRect().intersects(t.getRect())) {
                    this.changToOldDirection();
                    t.changToOldDirection();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
                bU = true;
                break;
            case KeyEvent.VK_S:
                bD = true;
                break;
            case KeyEvent.VK_A:
                bL = true;
                break;
            case KeyEvent.VK_D:
                bR = true;
                break;
            case KeyEvent.VK_G:
                fire();
                new Thread(new MusicUtils(MusicUtils.PLAY_FIRE)).start();// 开火的音效
                break;
            case KeyEvent.VK_R:
                if (alive)
                    setLife(100);
                break;
        }
        setDirection();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
                bU = false;
                break;
            case KeyEvent.VK_S:
                bD = false;
                break;
            case KeyEvent.VK_A:
                bL = false;
                break;
            case KeyEvent.VK_D:
                bR = false;
                break;
        }
        setDirection();
    }
}
