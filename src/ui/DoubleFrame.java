package ui;

import missile.MissilePlayer1;
import missile.MissilePlayer2;
import prop.Supply;
import tank.TankPlayer1;
import tank.TankPlayer2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DoubleFrame extends JFrame implements Runnable, ActionListener {
    public static final int DOUBLE_FRAME_WIDTH = 800;
    public static final int DOUBLE_FRAME_HEIGHT = 600;

    public static TankPlayer1 tankPlayer1 = new TankPlayer1(150,200, TankPlayer1.Direction.STOP);
    public static TankPlayer2 tankPlayer2 = new TankPlayer2(590,200, TankPlayer2.Direction.STOP);

    public static List<MissilePlayer1> missilePlayer1List = new ArrayList<MissilePlayer1>(0);
    public static List<MissilePlayer2> missilePlayer2List = new ArrayList<MissilePlayer2>(0);

    public static List<Explode> explodeList = new ArrayList<Explode>(0);

    Supply supply = new Supply();//实例化一个对象补给

    public static Boolean musicSwitch = false;//决定音乐开启与关闭

    public DoubleFrame(){
        createMenu();

        addKeyListener(tankPlayer1);
        addKeyListener(tankPlayer2);

        setSize(DOUBLE_FRAME_WIDTH,DOUBLE_FRAME_HEIGHT);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//添加关闭操作
        
    }

    /**
     * 创建双人对战菜单栏
     */
    public void createMenu(){
        JMenuBar jMenuBar = new JMenuBar();

        JMenu jMenu1 = new JMenu("游戏");
        JMenu jMenu2 = new JMenu("帮助");

        JMenuItem jMenuItem1 = new JMenuItem("背景音乐开/关");
        JMenuItem jMenuItem2 = new JMenuItem("关于游戏");
        JMenuItem jMenuItem3 = new JMenuItem("返回到主界面");

        //添加菜单
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);

        //添加菜单项
        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem3);
        jMenu2.add(jMenuItem2);

        //为菜单项背景游戏的开关添加监听事件
        jMenuItem1.addActionListener(this);
        jMenuItem1.setActionCommand("music");

        //为关于游戏添加监听事件
        jMenuItem2.addActionListener(this);
        jMenuItem2.setActionCommand("help");

        //为返回到主页面添加监听事件
        jMenuItem3.addActionListener(this);
        jMenuItem3.setActionCommand("back");

        this.setJMenuBar(jMenuBar);//添加菜单栏


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO
    }

    @Override
    public void run() {
        //TODO
    }
}
