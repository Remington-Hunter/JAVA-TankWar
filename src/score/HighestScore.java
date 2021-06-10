package score;

import ui.StartFrame;

import java.io.*;

public class HighestScore {
    static String maxString;
    static String filename = "txt/maxScore.txt";
    static File file = new File(filename);
    static String mode = "体验模式";

    /**
     * 最高分数构造方法
     *
     * @param mode 传入模式名字
     */
    public static void setModeName(String mode) {
        HighestScore.mode = mode;
    }

    /**
     * 读取本地保存最高分数，如果没有文件，则重新创建一个文件
     *
     * @return 返回最高分数
     */
    public static String readText() {
        BufferedReader bufferedReader = null;
        try {
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    throw new IOException();
                }
                write(null, 0);
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            String temp = null;
            while ((temp = bufferedReader.readLine()) != null) {
                maxString = temp;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return maxString;
    }

    /**
     * 在文件中写入函数
     *
     * @param score 传入分数参数
     */
    public static void write(String username, int score) {
        String ScoreString = StartFrame.getUserName() + ":" + score;  //StartFrame.getUserName()这里后面还要调用StartFrame类方法
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(file));
            printStream.println("卷饼王");
            printStream.append(ScoreString).append("\n");
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
