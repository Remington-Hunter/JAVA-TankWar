package tank;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 坦克类
 */
public class Tank implements KeyListener {
    private int x; // 坐标
    private int y;
    private int oldX; // 原来的坐标
    private int oldY;

    /**
     * 坦克速度
     */
    public static final int SPEED = 3;
    public static final int N_SPEED = 3;

    private static int tankColor = 0; // 坦克颜色

    public static void setTankColor(int tankColor) {
        Tank.tankColor = tankColor;
    }

    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
