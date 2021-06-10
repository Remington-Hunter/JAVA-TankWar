package ui;

import utils.ImageUtils;

import javax.swing.*;
import java.awt.*;

public class EndFrame extends JFrame implements Runnable{

    public EndFrame(){
        setTitle("坦克大战");
        setVisible(true);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        JPanel jPanel = new JPanel(){
          public void paint(Graphics g){
              super.paint(g);
              g.drawImage(ImageUtils.GAME_OVER,0,0,null);
          }
        };
        add(jPanel);
    }

    /**
     * 启动线程
     */
    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(20);
                repaint();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
