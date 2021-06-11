package score;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ScoreFrame extends JFrame {
    static JTextArea Jta = new JTextArea(11, 34);
    JPanel jPanel = new JPanel();
    JLabel jLabel = new JLabel("玩家历史成绩");
    JScrollPane Jsp = new JScrollPane(Jta);

    public ScoreFrame() throws IOException {
        setLayout(new BorderLayout());
        jPanel.add(jLabel);
        jLabel.setFont(new Font("宋体", Font.BOLD, 20));
        jPanel.setLayout(new FlowLayout());

        Jta.setEditable(false);
        add(jPanel, BorderLayout.NORTH);
        add(Jsp, BorderLayout.CENTER);

        FileReader fileReader = new FileReader("txt/Score.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        ArrayList<String> ScoreList = new ArrayList<String>();
        String string;
        while ((string = bufferedReader.readLine()) != null) {
            ScoreList.add(string);
        }

        for (String str : ScoreList) {
            Jta.append(str + "\n");
        }

}
