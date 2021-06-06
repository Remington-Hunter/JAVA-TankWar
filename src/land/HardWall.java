package land;

import javax.swing.*;
import java.awt.*;

/**
 * 硬墙
 */
public class HardWall {
    /**
     * 金属墙图标的宽度与长度
     */
    public static final int HARD_WALL_WIDTH = 33;
    public static final int HARD_WALL_LENGTH = 33;
    /**
     * 金属墙图标的坐标
     */
    private final int x;
    private final int y;

    Image hWallImag = new ImageIcon("images/hWall.gif").getImage();

    /**
     * 金属标图标的构造方法
     * @param x 传递构造的横坐标参数
     * @param y 传递构造的纵坐标参数
     */
    public HardWall(int x,int y){
        this.x = x;
        this.y = y;
    }

    /**
     * 绘制金属标图标
     * @param g 传入Graphics实例对象进行绘图
     */
    public void draw(Graphics g){
        g.drawImage(hWallImag,x,y,null);
    }

    /**
     *  为金属墙图标绘制一片区域
     * @return 返回指定参数的一个长方形实例对象
     */
    public Rectangle getRect(){
        return new Rectangle(x,y,HARD_WALL_WIDTH,HARD_WALL_LENGTH);
    }
}
