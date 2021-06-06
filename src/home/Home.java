package home;

import javax.swing.*;
import java.awt.*;

public class Home {
    /**
     * 设置坦克基地的默认位置
     */
    static int x = 290;
    static int y = 250;
    /**
     * 全局静态变量长宽
     */
    public static  final int HOME_WIDTH = 35;
    public static  final int HOME_LENGTH = 35;
    static boolean Alive = true;

    Image HomeImage = new ImageIcon("images/home.gif").getImage();

    /**
     * 判断是否游戏失败
     * @return 返回基地是否存活
     */
    public boolean IsAlive(){
        return Alive;
    }

    /**
     * 设置基地存活，重新开始游戏
     */
    public static void SetAlive(){
        Alive = true;
    }

    /**
     * 构造函数，给基地的参数赋值
     * @param x 基地的横坐标
     * @param y 基地的纵坐标
     */
    public static void SetHomeLocation(int x,int y){
        Home.x = x;
        Home.y = y;
    }

    public void draw(Graphics graphics){
        if(Alive){
            graphics.drawImage(HomeImage,x,y,null);
        }

    }





}
