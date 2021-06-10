package utils;

import tank.Tank;

import javax.swing.*;
import java.awt.*;

public class ImageUtils {
    //玩家一坦克
    public static final Image TANK_U = new ImageIcon("images/tankU.gif").getImage();
    public static final Image TANK_D = new ImageIcon("images/tankD.gif").getImage();
    public static final Image TANK_L = new ImageIcon("images/tankL.gif").getImage();
    public static final Image TANK_R = new ImageIcon("images/tankR.gif").getImage();
    //玩家二坦克二
    public static final Image W_TANK_U = new ImageIcon("images/WtankU.gif").getImage();
    public static final Image W_TANK_D = new ImageIcon("images/WtankD.gif").getImage();
    public static final Image W_TANK_L = new ImageIcon("images/WtankL.gif").getImage();
    public static final Image W_TANK_R = new ImageIcon("images/WtankR.gif").getImage();
    // 敌方坦克
    public static final Image E_TANK_U = new ImageIcon("images/EtankU.png").getImage();
    public static final Image E_TANK_D = new ImageIcon("images/EtankD.png").getImage();
    public static final Image E_TANK_L = new ImageIcon("images/EtankL.png").getImage();
    public static final Image E_TANK_R = new ImageIcon("images/EtankR.png").getImage();
    // 难度1
    public static final Image E1_TANK_U = new ImageIcon("images/E1tankU.png").getImage();
    public static final Image E1_TANK_D = new ImageIcon("images/E1tankD.png").getImage();
    public static final Image E1_TANK_L = new ImageIcon("images/E1tankL.png").getImage();
    public static final Image E1_TANK_R = new ImageIcon("images/E1tankR.png").getImage();
    // 难度2
    public static final Image E2_TANK_U = new ImageIcon("images/E2tankU.png").getImage();
    public static final Image E2_TANK_D = new ImageIcon("images/E2tankD.png").getImage();
    public static final Image E2_TANK_L = new ImageIcon("images/E2tankL.png").getImage();
    public static final Image E2_TANK_R = new ImageIcon("images/E2tankR.png").getImage();
    // 难度3
    public static final Image E3_TANK_U = new ImageIcon("images/E3tankU.png").getImage();
    public static final Image E3_TANK_D = new ImageIcon("images/E3tankD.png").getImage();
    public static final Image E3_TANK_L = new ImageIcon("images/E3tankL.png").getImage();
    public static final Image E3_TANK_R = new ImageIcon("images/E3tankR.png").getImage();
    //基地图片
    public static final Image HOME_IMAGE = new ImageIcon("images/home.gif").getImage();
    //普通墙图片
    public static final Image WALL_IMAGE = new ImageIcon("images/wall.gif").getImage();
    //金属墙图片
    public static final Image HARD_WALL_IMAGE = new ImageIcon("images/hWall.gif").getImage();
    //河流图片
    public static final Image RIVER_IMAGE = new ImageIcon("images/river.gif").getImage();
    //丛林图片
    public static final Image TREE_IMAGE = new ImageIcon("images/tree.gif").getImage();
    //补给图片
    public static final Image SUPPLY_IMAGE = new ImageIcon("images/arm1.png").getImage();
    //创建开始游戏的一些图片对象
    public static final ImageIcon IMAGE_BACK = new ImageIcon("images/back.jpg");
    public static final ImageIcon IMAGE_SELECT = new ImageIcon("images/select.jpg");
    public static final ImageIcon IMAGE_BUTTON_1 = new ImageIcon("images/bf1.jpg");
    public static final ImageIcon IMAGE_BUTTON_2 = new ImageIcon("images/bf2.jpg");
    public static final ImageIcon RUN_TANK_1 = new ImageIcon("images/runTank11.png");
    public static final ImageIcon RUN_Tank_2 = new ImageIcon("images/runTank12.png");
    private ImageUtils() {
    }
}
