package land;

import javax.swing.*;
import java.awt.*;

public class Wall {
    /**
     * 普通墙图标的宽度与长度
     */
    public static final int WALL_WIDTH = 33;
    public static final int WALL_LENGTH = 33;

     /**
     * 普通墙图标的横坐标与纵坐标
     */
    int x, y;
    Image wallImag = new ImageIcon("images/wall.gif").getImage();

    /**
     * 普通墙图标的构造方法
     *
     * @param x 传递要构造的横坐标参数
     * @param y 传递要构造的纵坐标参数
     */
    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 绘制普通墙图标
     * @param g 传入Graphics实例对象进行绘图
     */
    public void draw(Graphics g) {
        g.drawImage(wallImag, x, y, null);
    }

    /**
     * 为普通墙图标绘制一片区域
     * @return 返回指定参数长方形实例对象
     */
    public Rectangle getRect() {
        return new Rectangle(x, y, WALL_WIDTH, WALL_LENGTH);
    }
}
