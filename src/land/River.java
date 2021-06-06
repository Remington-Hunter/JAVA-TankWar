package land;

import javax.swing.*;
import java.awt.*;

public class River {
    public static final int RIVER_WIDTH = 33;
    public static final int RIVER_LENGTH = 33;
    private int x,y;
    Image riverImag = new ImageIcon("images/river.gif").getImage();

    /**
     * River的构造方法
     * @param x 传递要构造的长度
     * @param y 传递要构造的宽度
     */
    public River(int x,int y){
        this.x = x;
        this.y = y;
    }

    /**
     * 绘制画出河流
     * @param g 定义Graphics对象进行绘图
     */
    public void draw(Graphics g){
        g.drawImage(riverImag,x,y,null);
    }

    /**
     * 绘制河流长方形
     * @return 返回一个长方形对象
     */
    public Rectangle getRect(){
        return new Rectangle(x,y,RIVER_WIDTH,RIVER_LENGTH);
    }
}
