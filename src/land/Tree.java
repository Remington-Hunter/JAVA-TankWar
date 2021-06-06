package land;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Tree {
    public static final int Tree_WIDTH = 33;
    public static final int TREE_LENGTH = 33;
    int x, y;

    Image treeImag =  new ImageIcon("images/tree.gif").getImage();

    /**
     * Tree的构造方法
     * @param x 传递要构造的长度
     * @param y 传递要构造的宽度
     */
    public Tree(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 绘画界面树和丛林
     * @param g 定义Graphics对象进行绘图
     */
    public void draw(Graphics g) {
        g.drawImage(treeImag,x, y, null);
    }

    /**
     * 绘制界面树和丛林长方形
     * @return 返回指定参数的长方形实例
     */
    public Rectangle getRect() {
        return new Rectangle(x, y, Tree_WIDTH,TREE_LENGTH);
    }

}