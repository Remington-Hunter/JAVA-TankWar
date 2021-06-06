package ui;

import java.awt.*;

public class Explode {
    /**
     * 爆炸位置
     */
    int x;
    int y;
    /**
     * 判断是否爆炸
     */
    private boolean Alive = true;
    /**
     * 爆炸事件控制
     */
    int Step = 0;
    /**
     * 爆炸范围
     */
    public static final int [] DIAMETER = new int[]{4,7,12,18,26,32,49,56,65,77,80,50,40,30,14,6};

    /**
     * 爆炸构造方法
     * @param x 传入爆炸横坐标
     * @param y 传入爆炸纵坐标
     */
    public Explode(int x,int y){
        this.x = x;
        this.y = y;
    }

    /**
     * 绘制爆炸状态
     * @param g 定义Graphics对象进行绘图
     */
    public void draw(Graphics g){
        if(!Alive) return;

        if(Step==DIAMETER.length){
            Alive = false;
            Step = 0;
            GameFrame.explodeList.remove(this);
            return;
        }

        Color color = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,DIAMETER[Step],DIAMETER[Step]);
        g.setColor(color);
        Step++;
    }
}
