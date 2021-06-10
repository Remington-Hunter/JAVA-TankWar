package ui;

import home.Home;
import land.HardWall;
import land.River;
import land.Tree;
import land.Wall;
import pve.TankPlayer1;
import utils.ImageUtils;
import utils.MusicUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class DiyMapFrame extends JFrame implements Runnable, KeyListener, ActionListener {
    /**
     * 默认地图大小
     */
    public static final int DIY_MAP_WIDTH = 800;
    public static final int DIY_MAP_HEIGHT = 600;
    /**
     * 默认坦克的初始位置
     */
    TankPlayer1 tank = new TankPlayer1(350, 230, true, TankPlayer1.Direction.STOP);
    Home home = new Home();

    //默认家的位置
    {
        Home.setHomeLocation(-50, -50);
    }

    //判断能否添加地形
    boolean press = true;
    //判断坦克是否进入地形
    boolean enterWall = true, enterHardWall = true, enterRiver = true, enterTree = true, enterHome = true;
    Clear clear = new Clear();

    JMenuBar jMenuBar = new JMenuBar();
    JMenu jMenu1 = new JMenu("游戏");
    JMenu jMenu2 = new JMenu("帮助");
    JMenuItem jMenuItem1 = new JMenuItem("开始游戏");
    JMenuItem jMenuItem2 = new JMenuItem("关于自定义");
    JMenuItem jMenuItem3 = new JMenuItem("返回游戏");

    public DiyMapFrame() {
        this.setJMenuBar(jMenuBar);
        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem3);
        jMenu2.add(jMenuItem2);

        jMenuItem1.setActionCommand("start");
        jMenuItem1.addActionListener(this);
        jMenuItem1.setAccelerator(KeyStroke.getKeyStroke("F1"));//设置F1快捷键

        jMenuItem2.setActionCommand("diy");
        jMenuItem2.addActionListener(this);

        jMenuItem3.setActionCommand("back");
        jMenuItem3.addActionListener(this);
        jMenuItem3.setAccelerator(KeyStroke.getKeyStroke("F2"));//设置F2快捷键

        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);

        this.addKeyListener(tank);
        this.addKeyListener(this);
        this.setTitle("自定义地图");
        this.setSize(DIY_MAP_WIDTH, DIY_MAP_HEIGHT);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setIconImage(ImageUtils.ICON);

        Thread thread = new Thread(this);
        thread.start();
        JPanel jPanel = new JPanel() {
            {
                setBackground(Color.gray);//设置背景
            }

            public void paint(Graphics g) {
                super.paint(g);
                g.drawString("普通墙的个数：" + GameFrame.wallList.size(), 10, 20);
                g.drawString("金属墙的个数：" + GameFrame.hardWallList.size(), 10, 40);
                g.drawString("河流的个数：" + GameFrame.riverList.size(), 10, 60);
                g.drawString("草丛的个数：" + GameFrame.treeList.size(), 10, 80);
                //画普通墙
                for (Wall wall : GameFrame.wallList) {
                    wall.draw(g);
                }
                for (Wall wall : GameFrame.wallList) {
                    if (tank.getRect().intersects(wall.getRect())) {
                        enterWall = false;
                        clear.type(1, wall);
                        break;
                    } else {
                        enterWall = true;
                    }
                }
                if (!enterWall && GameFrame.wallList.size() == 0) {
                    enterWall = true;
                }

                //画金属墙
                for (HardWall hardWall : GameFrame.hardWallList) {
                    hardWall.draw(g);
                }
                for (HardWall hardWall : GameFrame.hardWallList) {
                    if (tank.getRect().intersects(hardWall.getRect())) {
                        enterHardWall = false;
                        clear.type(2, hardWall);
                        break;
                    } else {
                        enterHardWall = true;
                    }
                }
                if (!enterHardWall && GameFrame.hardWallList.size() == 0) {
                    enterHardWall = true;
                }

                //画出河流
                for (River river : GameFrame.riverList) {
                    river.draw(g);
                }
                for (River river : GameFrame.riverList) {
                    if (tank.getRect().intersects(river.getRect())) {
                        enterRiver = false;
                        clear.type(3, river);
                        break;
                    } else {
                        enterRiver = true;
                    }
                }
                if (!enterRiver && GameFrame.riverList.size() == 0) {
                    enterRiver = true;
                }

                //画出丛林
                for (Tree tree : GameFrame.treeList) {
                    tree.draw(g);
                }
                for (Tree tree : GameFrame.treeList) {
                    if (tank.getRect().intersects(tree.getRect())) {
                        enterTree = false;
                        clear.type(4, tree);
                        break;
                    } else {
                        enterTree = true;
                    }
                }
                if (!enterTree && GameFrame.treeList.size() == 0) {
                    enterTree = true;
                }

                //判断坦克是否进入家
                if (tank.getRect().intersects(home.getRect())) {
                    enterHome = false;
                    clear.type(5, home);
                } else {
                    enterHome = true;
                }
                press = enterWall && enterHardWall && enterRiver && enterTree && enterHome;

                home.draw(g);
                tank.draw(g);
            }
        };
        add(jPanel);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (Exception e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    public static void main(String[] args){
        EventQueue.invokeLater(DiyMapFrame::new);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //TODO
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_H && press) {
            GameFrame.wallList.add(new Wall(tank.getX(), tank.getY()));
            new Thread(new MusicUtils(MusicUtils.PLAY_SET)).start();
        }
        if (e.getKeyCode() == KeyEvent.VK_J && press) {
            GameFrame.hardWallList.add(new HardWall(tank.getX(), tank.getY()));
            new Thread(new MusicUtils(MusicUtils.PLAY_SET)).start();
        }
        if (e.getKeyCode() == KeyEvent.VK_K && press) {
            GameFrame.riverList.add(new River(tank.getX(), tank.getY()));
            new Thread(new MusicUtils(MusicUtils.PLAY_SET)).start();
        }
        if (e.getKeyCode() == KeyEvent.VK_L && press) {
            GameFrame.treeList.add(new Tree(tank.getX(), tank.getY()));
            new Thread(new MusicUtils(MusicUtils.PLAY_SET)).start();
        }
        if (e.getKeyCode() == KeyEvent.VK_G && press) {
            Home.setHomeLocation(tank.getX(), tank.getY());
            new Thread(new MusicUtils(MusicUtils.PLAY_SET)).start();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            new Thread(new MusicUtils(MusicUtils.PLAY_SET)).start();
            clear.removeTrash();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("start")) {
            this.dispose();
            GameFrame.setDifficulty(4);
            //如果玩家在自定义地图前死亡需要重置以下属性
            GameFrame.hero.setAlive(true);
            GameFrame.hero.setLife(100);
            GameFrame.threadSwitch = true;
            EventQueue.invokeLater(GameFrame::new);
        }
        if (e.getActionCommand().equals("back")) {
            this.dispose();
            Home.setHomeLocation(290, 250);// 重置老家位置
            EventQueue.invokeLater(GameFrame::new);
        }
        if (e.getActionCommand().equals("diy")) {
            JOptionPane.showMessageDialog(null, "G、家，H、普通墙，J、金属墙，K、河流，L、草地，空格清除", "提示", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}

class Clear {
    int type;
    Object object;

    public void type(int type, Object object) {
        this.type = type;
        this.object = object;
    }

    public void removeTrash() {
        switch (type) {
            case 1:
                GameFrame.wallList.remove(object);
                break;
            case 2:
                GameFrame.hardWallList.remove(object);
                break;
            case 3:
                GameFrame.riverList.remove(object);
                break;
            case 4:
                GameFrame.treeList.remove(object);
                break;
            case 5:
                Home.setHomeLocation(-50, -50);
                break;
            default:
                break;
        }
    }
}
