package ui;

import missile.MissilePlayer1;
import tank.TankPlayer1;
import tank.TankPlayer2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DoubleFrame extends JFrame implements Runnable, ActionListener {
    public static TankPlayer1 tankPlayer1 = new TankPlayer1(150,200, TankPlayer1.Direction.STOP);
    public static TankPlayer2 tankPlayer2 = new TankPlayer2(590,200, TankPlayer2.Direction.STOP);

    public static List<MissilePlayer1> missilePlayer1List1 = new ArrayList<MissilePlayer1>(0);

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO
    }

    @Override
    public void run() {
        //TODO
    }
}
