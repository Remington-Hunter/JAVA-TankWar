package prop;

import utils.ImageUtils;
import java.awt.*;
import java.util.Random;

/**
 * 补给类，pvp模式下两个玩家对战模式补给
 */
public class Supply{
    /**
     * 补给图标的宽度与长度
     */
    public static final int SUPPLY_WIDTH = 33;
    public static final int SUPPLY_LENGTH = 36;

    static Random random = new Random();
    /**
     * 补给的坐标
     */
    static int x = random.nextInt(300) + 200;
    static int y = random.nextInt(300) + 200;

    /**
     * 补给图标的构造方法
     *
     * @param x 传递构造的横坐标参数
     * @param y 传递构造的纵坐标参数
     */
    public static void setSupplyPosition(int x, int y) {
        Supply.x = x;
        Supply.y = y;
    }

    /**
     * 补给图标的绘制
     *
     * @param g 传入Graphics实例对象进行绘图
     */
    public void draw(Graphics g) {
        g.drawImage(ImageUtils.SUPPLY_IMAGE, x, y, null);
    }

    /**
     * 为补给图标绘制一片区域
     *
     * @return 返回指定参数的长方形实例对象
     */
    public Rectangle getRect() {
        return new Rectangle(x, y, SUPPLY_WIDTH, SUPPLY_LENGTH);
    }

}
