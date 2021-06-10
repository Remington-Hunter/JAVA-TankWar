package player2;

import palyer1.TankPlayer1;
import ui.DoubleFrame;
import ui.Explode;
import utils.MusicUtils;

import java.awt.*;

public class MissilePlayer2 {
    //子导弹大小
    public static final int WIDTH = 5;
    public static final int HEIGHT = 5;
    //导弹速度
    private static int speed = 5;
    // 导弹伤害
    private static int hurt = 20;
    TankPlayer2.Direction towardDirection;
    //导弹坐标
    private int x;
    private int y;
    //导弹存活
    private boolean alive = true;

    public boolean isAlive() {
        return alive;
    }

    public static int getHurt() {
        return hurt;
    }

    public static void setHurt(int hurt) {
        MissilePlayer2.hurt = hurt;
    }

    /**
     * 玩家一坦克导弹构造方法
     * @param x 导弹横坐标
     * @param y 导弹纵坐标
     * @param towardDirection 导弹方向
     */
    public MissilePlayer2(int x, int y, TankPlayer2.Direction towardDirection){
        this.x = x;
        this.y = y;
        this.towardDirection = towardDirection;
    }

    /**
     * 绘制玩家一的导弹
     * @param g Graphics类绘制导弹
     */
    public void draw(Graphics g){
        if(!alive){
            return;
        }
        if(hurt==20){
            g.setColor(Color.white);
            g.fillOval(x,y,WIDTH,HEIGHT);
        }
        else{
            g.setColor(Color.pink);
            g.fillOval(x-1,y-2,WIDTH+2,HEIGHT+2);
        }
        move();
    }

    /**
     * 导弹移动
     */
    public void move(){
        switch (towardDirection) {
            case U:
                y -= speed;
                break;
            case D:
                y += speed;
                break;
            case L:
                x -= speed;
                break;
            case R:
                x += speed;
                break;
            case STOP:
                break;
        }
        // 飞出屏幕就消失
        if (x < 0 || y < 0 || x > 800 || y > 600) {
            alive = false;
        }
    }

    /**
     * 获得导弹的轮廓
     * @return 返回导弹的轮廓
     */
    public Rectangle getRect(){
        return new Rectangle(x,y,WIDTH,HEIGHT);
    }

    /**
     * 判断导弹击中对方玩家
     * @param tankPlayer1 对方坦克
     */
    public void hitTank(TankPlayer1 tankPlayer1){//由于没有构建玩家二类，先用玩家一类代替
        if(this.alive&&this.getRect().intersects(tankPlayer1.getRect())&&tankPlayer1.isAlive()){
            this.alive = false;//击中后导弹消失
            new Thread(new MusicUtils(MusicUtils.PLAY_EXPLODE)).start();
            tankPlayer1.setLife(tankPlayer1.getLife()-getHurt());
            if(tankPlayer1.getLife()<=0){
                tankPlayer1.setLife(0);
                tankPlayer1.setAlive(false);
            }
            Explode explode = new Explode(x,y);
            DoubleFrame.explodeList.add(explode);
        }
    }
}
