package ui;

import utils.MusicUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartFrame extends JFrame implements KeyListener {
    //创建开始游戏的一些图片对象
    ImageIcon imageBack = new ImageIcon("images/back.jpg");
    ImageIcon imageSelect = new ImageIcon("images/select.jpg");
    ImageIcon imageButton1 = new ImageIcon("images/bf1.jpg");
    ImageIcon imageButton2 = new ImageIcon("images/bf2.jpg");
    ImageIcon runTank1 = new ImageIcon("images/runTank11.png");
    ImageIcon runTank2 = new ImageIcon("images/runTank12.png");

    //创建标签存放图片
    JLabel jlBack = new JLabel(imageBack);//背景
    JLabel jlSelect = new JLabel(imageSelect);//鼠标选择
    JLabel jlButton1 = new JLabel(imageButton1);//开始游戏
    JLabel jlButton2 = new JLabel(imageButton2);//双人模式
    JLabel jlRunTank1 = new JLabel(runTank1);
    JLabel jlRunTank2 = new JLabel(runTank2);

    private static int choose;//选择模式属性
    private static String userName;//用户名
    /**
     * get方法获取用户名
     * @return 返回用户名
     */
    public static String getUserName() {
        return userName;
    }
    JButton jButton = new JButton(imageButton1);
    public StartFrame(){
        jlSelect.setFocusable(true);//控制键盘可以获得按钮的焦点
        jlSelect.addKeyListener(this);//添加键盘监听事件

        //设置标签位置，添加鼠标监听器
        jlButton1.setBounds(330,370,140,40);
        jlButton1.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                new Thread(new MusicUtils(MusicUtils.PLAY_CHOOSE)).start();
                jlSelect.setBounds(260,368,70,40);
            }
            public void mousePressed(MouseEvent e){
                String username = JOptionPane.showInputDialog("请输入玩家姓名：");
                if(username.equals("")){
                    userName = "匿名玩家";
                }
                else {
                    userName = username;
                }
                dispose();
                MusicUtils.stopMusic();
                new GameFrame();
            }
        });

        jlButton2.setBounds(331,450,140,40);
        jlButton2.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                new Thread(new MusicUtils(MusicUtils.PLAY_CHOOSE)).start();
            }
            public void mousePressed(MouseEvent e){
                dispose();
                MusicUtils.stopMusic();
                //new DoubleFrame
            }
        });

        add(jlSelect);
        add(jlButton1);
        add(jlButton2);

        add(jlRunTank1);
        add(jlRunTank2);
        //设置图片铺满整个面板
        this.getContentPane().add(jlBack);
        jlBack.setBounds(60,20,imageBack.getIconWidth(),imageBack.getIconHeight());
        //把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        ((JPanel)this.getContentPane()).setOpaque(false);
        // 把背景图片添加到分层窗格的最底作为背景
        this.getLayeredPane().add(jlBack,new Integer(Integer.MIN_VALUE));

        setBackground(Color.BLACK);
        setLayout(null);
        setTitle("坦克大战");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
}
