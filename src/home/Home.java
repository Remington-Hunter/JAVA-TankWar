package home;

import utils.ImageUtils;
import java.awt.*;

/**
 * 基地类，玩家基地
 */
public class Home {
    /**
     * 设置坦克基地的默认位置
     */
    static int x = 290;
    static int y = 250;
    /**
     * 全局静态变量长宽
     */
    public static final int HOME_WIDTH = 35;
    public static final int HOME_LENGTH = 35;
    static boolean alive = true;


    /**
     * 判断是否游戏失败
     *
     * @return 返回基地是否存活
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * 设置基地存活，重新开始游戏
     */
    public static void setAlive(boolean alive) {
        Home.alive = alive;
    }

    /**
     * 构造函数，给基地的参数赋值
     *
     * @param x 基地的横坐标
     * @param y 基地的纵坐标
     */
    public static void setHomeLocation(int x, int y) {
        Home.x = x;
        Home.y = y;
    }

    /**
     * 绘制基地图形
     *
     * @param g 定义Graphics对象进行绘图
     */
    public void draw(Graphics g) {
        if (alive) {
            g.drawImage(ImageUtils.HOME_IMAGE, x, y, null);
        }
        //这里要加else，由于GameFrame没编写完，先留在这里
    }

    /**
     * 绘制基地长方形
     *
     * @return 返回一个长方形对象
     */
    public Rectangle getRect() {
        return new Rectangle(x, y, HOME_WIDTH, HOME_LENGTH);
    }
}
