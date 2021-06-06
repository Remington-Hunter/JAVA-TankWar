package land;

import javax.swing.*;
import java.awt.*;

/**
 * 硬墙
 */
public class HardWall {
    public static final int HARD_WALL_WIDTH = 33;
    public static final int HARD_WALL_LENGTH = 33;
    private int x,y;
    Image hWallImag = new ImageIcon("images/hWall.gif").getImage();

    /**
     * HardWall的构造方法
     * @param x 传递要构造的长度
     * @param y 传递要构造的宽度
     */
    public HardWall(int x,int y){
        this.x = x;
        this.y = y;
    }

    /**
     * 画金属墙
     * @param g 定义Graphics对象进行绘图
     */
    public void draw(Graphics g){
        g.drawImage(hWallImag,x,y,null);
    }

    /**
     *  绘制金属墙长方形
     * @return 返回长方形对象
     */
    public Rectangle getRect(){
        return new Rectangle(x,y,HARD_WALL_WIDTH,HARD_WALL_LENGTH);
    }
}
