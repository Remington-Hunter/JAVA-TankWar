package ui;

import utils.ImageUtils;
import utils.MusicUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartFrame extends JFrame implements KeyListener {


    //创建标签存放图片
    JLabel jlBack = new JLabel(ImageUtils.IMAGE_BACKGROUND);//背景
    JLabel jlSelect = new JLabel(ImageUtils.IMAGE_SELECT);//鼠标选择
    JLabel jlButton1 = new JLabel(ImageUtils.IMAGE_BUTTON_1);//开始游戏
    JLabel jlButton2 = new JLabel(ImageUtils.IMAGE_BUTTON_2);//双人模式

    JLabel jlRunTank1 = new JLabel(ImageUtils.RUN_TANK_1);
    JLabel jlRunTank2 = new JLabel(ImageUtils.RUN_Tank_2);

    private static int choose;//选择模式属性
    private static String userName;//用户名

    /**
     * get方法获取用户名
     *
     * @return 返回用户名
     */
    public static String getUserName() {
        return userName;
    }

    public StartFrame() {
        jlSelect.setFocusable(true);//控制键盘可以获得按钮的焦点
        jlSelect.addKeyListener(this);//添加键盘监听事件

        //设置标签位置，添加鼠标监听器
        jlButton1.setBounds(330, 370, 140, 40);
        jlButton1.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                new Thread(new MusicUtils(MusicUtils.PLAY_CHOOSE)).start();
                jlSelect.setBounds(260, 368, 70, 40);
            }

            public void mousePressed(MouseEvent e) {
                String username = JOptionPane.showInputDialog("请输入玩家姓名：");
                if ("".equals(username) || username == null) {
                    userName = "匿名玩家";
                } else {
                    userName = username;
                }
                dispose();
                MusicUtils.stopMusic();
                new GameFrame();
            }
        });

        jlButton2.setBounds(331, 450, 140, 40);
        jlButton2.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                new Thread(new MusicUtils(MusicUtils.PLAY_CHOOSE)).start();
                jlSelect.setBounds(260, 448, 70, 40);
            }

            public void mousePressed(MouseEvent e) {
                dispose();
                MusicUtils.stopMusic();
                new DoubleFrame();
            }
        });

        add(jlSelect);
        add(jlButton1);
        add(jlButton2);

        add(jlRunTank1);
        add(jlRunTank2);
        //设置图片铺满整个面板
        this.getContentPane().add(jlBack);
        jlBack.setBounds(60, 20, ImageUtils.IMAGE_BACKGROUND.getIconWidth(), ImageUtils.IMAGE_BACKGROUND.getIconHeight());
        //把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        ((JPanel) this.getContentPane()).setOpaque(false);
        // 把背景图片添加到分层窗格的最底作为背景
        this.getLayeredPane().add(jlBack, new Integer(Integer.MIN_VALUE));

        setBackground(Color.BLACK);
        setLayout(null);
        setTitle("坦克大战");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        Thread tankRun = new Thread(new Runnable() {
            int xLeft = -481;
            final int yLeft = 5; //向左滚动条的初始位置
            int xRight = 800;
            final int yRight = 5;//向右滚动条的初始位置
            boolean dir = true;//决定方向

            @Override
            public void run() {
                while (true) {
                    if (dir) {
                        xLeft += 5;
                        jlRunTank1.setBounds(xLeft, yLeft, 481, 90);
                    }
                    if (xLeft > 770) {
                        dir = false;
                        xLeft = -481;
                    }
                    if (!dir) {
                        xRight -= 5;
                        jlRunTank2.setBounds(xRight, yRight, 481, 90);
                    }
                    if (xRight < -481) {
                        dir = true;
                        xRight = 800;
                    }
                    try {
                        Thread.sleep(30);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
        });
        tankRun.start();
    }

    public static void main(String[] args) {
        MusicUtils.playMusic();
        new StartFrame();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //TODO
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            new Thread(new MusicUtils(MusicUtils.PLAY_CHOOSE)).start();
            jlSelect.setBounds(260, 368, 70, 40);
            choose = 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            new Thread(new MusicUtils(MusicUtils.PLAY_CHOOSE)).start();
            jlSelect.setBounds(260, 448, 70, 40);
            choose = 2;
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER && choose == 1) {
            new Thread(new MusicUtils(MusicUtils.PLAY_CHOOSE)).start();
            userName = JOptionPane.showInputDialog("请输入玩家姓名：");
            dispose();
            MusicUtils.stopMusic();
            new GameFrame();
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER && choose == 2) {
            dispose();
            MusicUtils.stopMusic();
            new DoubleFrame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //TODO
    }
}
