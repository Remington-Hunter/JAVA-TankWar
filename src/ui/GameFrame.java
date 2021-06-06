package ui;

import home.Home;
import land.HardWall;
import land.River;
import land.Tree;
import land.Wall;
import utils.MapUtils;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class GameFrame extends JFrame implements ActionListener, Runnable {
    /**
     * 敌人坦克初始数量
     */
    static int EnemyCount = 1;
    /**
     * 战斗轮数
     */
    static int Round = 1;
    /**
     * 默认地图难度
     */
    static int Difficulty = 0;

    {
        MapUtils.ChangeMap(Difficulty);
    }

    /**
     * 存储普通墙的列表
     */
    public static List<Wall> wallList = new ArrayList<Wall>(0);
    /**
     * 存储金属墙的列表
     */
    public static List<HardWall>hardWallList = new ArrayList<HardWall>(0);
    /**
     * 存储河流的列表
     */
    public static List<River> riverList = new ArrayList<River>(0);
    /**
     * 存储界面输的列表
     */
    public static List<Tree>treeList = new ArrayList<Tree>(0);
    /**
     * 存储爆炸的列表
     */
    public static List<Explode> explodeList = new ArrayList<Explode>(0);
    /**
     * 实例化一个基地对象
     */
    public Home home = new Home();

}
