package ui;

import explode.Explode;
import pvp.MissilePlayer1;
import pvp.MissilePlayer2;
import prop.Supply;
import pvp.TankPlayer1;
import pvp.TankPlayer2;
import utils.ImageUtils;
import utils.MusicUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DoubleFrame extends JFrame implements Runnable, ActionListener {
    public static final int DOUBLE_FRAME_WIDTH = 800;
    public static final int DOUBLE_FRAME_HEIGHT = 600;

    public static TankPlayer1 tankPlayer1 = new TankPlayer1(150, 200, TankPlayer1.Direction.STOP);
    public static TankPlayer2 tankPlayer2 = new TankPlayer2(590, 200, TankPlayer2.Direction.STOP);

    public static List<MissilePlayer1> missilePlayer1List = new ArrayList<MissilePlayer1>(0);
    public static List<MissilePlayer2> missilePlayer2List = new ArrayList<MissilePlayer2>(0);

    public static List<Explode> explodeList = new ArrayList<Explode>(0);
    public static Boolean musicSwitch = false;//决定音乐开启与关闭
    Supply supply = new Supply();//实例化一个补给对象

    public DoubleFrame() {
        this.createMenu();

        this.addKeyListener(tankPlayer1);
        this.addKeyListener(tankPlayer2);

        this.setTitle("坦克大战");
        this.setSize(DOUBLE_FRAME_WIDTH, DOUBLE_FRAME_HEIGHT);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//添加关闭操作
        this.setLocationRelativeTo(null);//将此窗口将置于屏幕的中央
        this.setIconImage(ImageUtils.ICON);

        JPanel jPanel = new JPanel() {
            {
                setBackground(Color.gray);//设置背景颜色
            }

            /**
             * 绘制双人对战界面
             * @param g
             */
            public void paint(Graphics g) {
                super.paint(g);
                g.drawString("玩家一的攻击力：" + MissilePlayer1.getHurt(), 10, 30);
                g.drawString("玩家一的血量：" + tankPlayer1.getLife(), 10, 60);//玩家一属性
                //绘制玩家一血量条
                g.drawRect(10, 80, 200, 15);
                g.fillRect(10, 80, tankPlayer1.getLife(), 15);

                g.drawString("玩家二的攻击力：" + MissilePlayer2.getHurt(), 675, 30);
                g.drawString("玩家二的血量：" + tankPlayer2.getLife(), 680, 60);//玩家二属性
                //绘制玩家二血量条
                g.drawRect(580, 80, 200, 15);
                g.fillRect(580 + (200 - tankPlayer2.getLife()), 80, tankPlayer2.getLife(), 15);

                tankPlayer1.draw(g);//绘制玩家一
                tankPlayer1.eat(supply);//玩家一吃到补给
                tankPlayer1.collideWithTank(tankPlayer2);//玩家一撞到玩家二

                tankPlayer2.draw(g);//绘制玩家二
                tankPlayer2.eat(supply);//玩家二吃到补给
                tankPlayer2.collideWithTank(tankPlayer1);//玩家二撞到玩家一

                supply.draw(g);//绘制补给


                //绘制坦克一的子弹
                for (int i = 0; i < missilePlayer1List.size(); i++) {
                    MissilePlayer1 missilePlayer1 = missilePlayer1List.get(i);
                    missilePlayer1.draw(g);
                    missilePlayer1.hitTank(tankPlayer2);
                }

                //绘制坦克二的子弹
                for (int i = 0; i < missilePlayer2List.size(); i++) {
                    MissilePlayer2 missilePlayer2 = missilePlayer2List.get(i);
                    missilePlayer2.draw(g);
                    missilePlayer2.hitTank(tankPlayer1);
                }

            }
        };

        add(jPanel);
        Thread thread = new Thread(this);
        thread.start();
    }

    public static void main(String[] args) {
        new DoubleFrame();
    }

    /**
     * 创建双人对战菜单栏
     */
    public void createMenu() {
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

    /**
     * 启动线程
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 为菜单栏添加事件函数功能
     *
     * @param e ActionEvent类添加函数功能
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("music")) {
            if (!musicSwitch) {
                MusicUtils.playMusic();
            } else {
                MusicUtils.stopMusic();
            }
            musicSwitch = !musicSwitch;
        }
        if (e.getActionCommand().equals("help")) {
            JOptionPane.showMessageDialog(null, "玩家1操作：W、向上，A、向下，S、向下，D、向上，J、发射炮弹" + "\n" + "玩家2操作：↑、向上，↓、向下，←、向左，→、向右，P、发射炮弹" + "", "提示", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getActionCommand().equals("back")) {
            Object[] options = {"确定", "取消"};
            int response = JOptionPane.showOptionDialog(this, "您确认要返回到主界面！", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (response == 0) {
                this.dispose();
                EventQueue.invokeLater(StartFrame::new);
            }
        }
    }
}
