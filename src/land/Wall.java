package land;

import javax.swing.*;
import java.awt.*;

public class Wall {
    public static final int WALL_WIDTH = 33;
    public static final int WALL_LENGTH = 33;
    int x,y;
    Image wallImag = new ImageIcon("images/wall.gif").getImage();

    /**
     * Wall的构造方法
     * @param x 传递要构造的长度
     * @param y 传递要构造的宽度
     */
    public Wall(int x,int y){
        this.x = x;
        this.y = y;
    }

    /**
     * 画出普通墙
     * @param g 定义Graphics对象进行绘图
     */
    public void draw(Graphics g){
        g.drawImage(wallImag,x,y,null);
    }

    /**
     * 绘制普通墙长方形
     * @return 返回一个长方形对象
     */
    public Rectangle getRect(){
        return new Rectangle(x,y,WALL_WIDTH,WALL_LENGTH);
    }
}
