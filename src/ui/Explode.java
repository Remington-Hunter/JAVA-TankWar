package ui;

import utils.ImageUtils;

import java.awt.*;

public class Explode {
    /**
     * 爆炸位置
     *
     *
     */
    int x;
    int y;
    /**
     * 判断是否爆炸
     *
     *
     */
    private boolean alive = true;
    /**
     * 爆炸事件控制
     */
    int step = 0;
    /**
     * 爆炸范围
     */
    public static final Image [] DIAMETER = new Image[]{
            ImageUtils.BOOM_1,ImageUtils.BOOM_2,ImageUtils.BOOM_3,
            ImageUtils.BOOM_4,ImageUtils.BOOM_5,ImageUtils.BOOM_6,
            ImageUtils.BOOM_7,ImageUtils.BOOM_8,ImageUtils.BOOM_9,
            ImageUtils.BOOM_10,ImageUtils.BOOM_8,ImageUtils.BOOM_6,
            ImageUtils.BOOM_4,ImageUtils.BOOM_2,ImageUtils.BOOM_1,
    };

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
        if(!alive) return;

        if(step==DIAMETER.length){
            alive = false;
            step = 0;
            GameFrame.explodeList.remove(this);
            return;
        }
        g.drawImage(DIAMETER[step],x,y,null);
        //g.fillOval(x,y,DIAMETER[step].getWidth(null),DIAMETER[step].getHeight(null));
        step++;
    }
}
