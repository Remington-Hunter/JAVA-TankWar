package missile;

import tank.Tank;

/**
 * 普通导弹类
 */
public class Missile {
    // 位置
    private int x;
    private int y;
    public static final int HURT = 20; // 子弹伤害
    public static final int SPEED = 4;
    public static final int N_SPEED = 4;
    public static final int WIDTH = 4;
    public static final int HEIGHT = 4;

    private static int missileColor = 0;
    private static int count = 0; // 击毁坦克数量

    public static void setMissileColor(int missileColor) {
        Missile.missileColor = missileColor;
    }

    private boolean good; // 敌我坦克
    private boolean live = true;

    Tank.Direction = true;

}
