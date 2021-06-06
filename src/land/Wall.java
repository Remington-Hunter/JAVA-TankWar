package land;

import javax.swing.*;
import java.awt.*;

public class Wall {
    /**
     * 普通墙图标的宽度与长度
     */
    public static final int WALL_WIDTH = 33;
    public static final int WALL_LENGTH = 33;
<<<<<<< HEAD
=======
    /**
     * 普通墙图标的横坐标与纵坐标
     */
>>>>>>> edbacf45cf2668c13bbbd2acb709768afeaa0093
    int x, y;
    Image wallImag = new ImageIcon("images/wall.gif").getImage();

    /**
<<<<<<< HEAD
     * Wall的构造方法
     *
     * @param x 传递要构造的长度
     * @param y 传递要构造的宽度
=======
     * 普通墙图标的构造方法
     *
     * @param x 传递要构造的横坐标参数
     * @param y 传递要构造的纵坐标参数
>>>>>>> edbacf45cf2668c13bbbd2acb709768afeaa0093
     */
    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
<<<<<<< HEAD
     * 画出普通墙
     *
     * @param g 定义Graphics对象进行绘图
=======
     * 绘制普通墙图标
     * @param g 传入Graphics实例对象进行绘图
>>>>>>> edbacf45cf2668c13bbbd2acb709768afeaa0093
     */
    public void draw(Graphics g) {
        g.drawImage(wallImag, x, y, null);
    }

    /**
<<<<<<< HEAD
     * 绘制普通墙长方形
     *
     * @return 返回一个长方形对象
=======
     * 为普通墙图标绘制一片区域
     * @return 返回指定参数长方形实例对象
>>>>>>> edbacf45cf2668c13bbbd2acb709768afeaa0093
     */
    public Rectangle getRect() {
        return new Rectangle(x, y, WALL_WIDTH, WALL_LENGTH);
    }
}
