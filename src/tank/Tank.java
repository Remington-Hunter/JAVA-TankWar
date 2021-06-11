package tank;

import home.Home;
import land.HardWall;
import land.River;
import land.Wall;

import java.awt.*;
import java.util.List;

/**
 * 坦克类
 */
public abstract class Tank {
    public enum Direction { // 方向的枚举
        U, D, L, R, STOP
    }
    public abstract Rectangle getRect();
    public abstract boolean isAlive();
    public abstract boolean isGood();
    public abstract void setLife(int i);
    public abstract int getLife();
    public abstract void setAlive(boolean b);
    public abstract void changToOldDirection();
    public abstract void draw(Graphics g);
    public abstract boolean collideWithWall(Wall w);
    public abstract boolean collideWithHardWall(HardWall w);
    public abstract boolean collideWithRiver(River r);
    public abstract boolean collideWithTanks(List<Tank> l);
    public abstract boolean collideWithHome(Home h);

    /**
     * 坦克初始速度
     */
    public static final int TANK_SPEED = 3;

    /**
     * 坦克的宽度
     */
    public static final int TANK_WIDTH = 40;

    /**
     * 坦克的高度
     */
    public static final int TANK_HEIGHT = 40;
}
