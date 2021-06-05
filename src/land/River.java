package land;

import javax.swing.*;
import java.awt.*;

public class River {
    public static final int riverWidth = 33;
    public static final int riverLength = 33;
    private int x,y;
    Image riverImag = new ImageIcon("images/river.gif").getImage();

    /**
     * River的构造方法
     * @param x 横坐标
     * @param y 纵坐标
     */
    public River(int x,int y){
        this.x = x;
        this.y = y;
    }

    /**
     * 对应的x，y位置画出河流
     * @param g 绘图对象
     */
    public void draw(Graphics g){
        g.drawImage(riverImag,x,y,null);
    }

    /**
     * 绘制长方形
     * @return 返回一个长方形对象
     */
    public Rectangle getRect(){
        return new Rectangle(x,y,riverWidth,riverLength);
    }
}
