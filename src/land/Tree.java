package land;

import utils.ImageUtils;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * 树木地形
 */
public class Tree {
    /**
     * 丛林图标的宽度与长度
     */
    public static final int TREE_WIDTH = 33;
    public static final int TREE_LENGTH = 33;
    /**
     * 丛林图标的横坐标与纵坐标
     */
    private final int x;
    private final int y;


    /**
     * 丛林图标图标的构造方法
     *
     * @param x 传递要构造的横坐标
     * @param y 传递要构造的纵坐标
     */
    public Tree(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 绘画丛林图标
     *
     * @param g 传入Graphics对象进行绘图
     */
    public void draw(Graphics g) {
        g.drawImage(ImageUtils.TREE_IMAGE, x, y, null);
    }

    /**
     * 为丛林图标绘制一片区域
     *
     * @return 返回指定参数的长方形实例对象
     */
    public Rectangle getRect() {
        return new Rectangle(x, y, TREE_WIDTH, TREE_LENGTH);
    }

}