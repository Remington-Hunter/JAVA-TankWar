package tank;

import utils.ImageUtils;

import java.awt.*;
import java.awt.event.KeyListener;

public class TankPlayer1 implements KeyListener {
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

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public enum Direction {
        U, D, L, R, STOP
    }

    /**
     * 判断子弹是否进入坦克范围
     */
    public Rectangle getRect(){
        return new Rectangle(x,y,TANK1_WIDTH,TANK1_HEIGHT);
    }

    /**
     * 玩家一坦克的构造方法
     * @param x 初始横坐标参数
     * @param y 初始纵坐标位置
     */
    public TankPlayer1(int x,int y){
        this.x = x;
        this.y = y;
        this.oldX = x;
        this.oldY = y;
    }

    /**
     * 玩家一坦克的构造方法
     * @param x 初始横坐标参数
     * @param y 初始纵坐标位置
     * @param direction 初始坦克方向
     */
    public TankPlayer1(int x,int y,Direction direction){
        this(x,y);
        this.direction = direction;
    }

    /**
     * 绘制玩家一的坦克
     * @param g Graphics类用于绘图
     */
    public void draw(Graphics g){
        if(alive){
            switch (towardDirection){
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
        }
        move();
    }

    /**
     * 坦克移动
     */
    public void move(){
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

    public


}
