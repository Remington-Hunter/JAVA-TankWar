package score;

import java.io.*;

public class HighestScore {
    static String MaxString;
    static String filename = "txt/maxScore.txt";
    static File file = new File(filename);
    static String Mode = "体验模式";

    /**
     * 最高分数构造方法
     * @param Mode 传入模式名字
     */
    public static void setModeName(String Mode){
        HighestScore.Mode = Mode;
    }

    /**
     * 读取本地保存最高分数，如果没有文件，则重新创建一个文件
     * @return 返回最高分数
     */
    public static String readText(){
        BufferedReader bufferedReader = null;
        try{
            if(!file.exists()){
                if(!file.createNewFile()) {
                    throw new IOException();
                }
                write(0);
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            String temp = null;
            while((temp=bufferedReader.readLine())!=null){
                MaxString = temp;
            }
            bufferedReader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(bufferedReader!=null){
                try{
                    bufferedReader.close();
                }
                catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        }
        return MaxString;
    }

    /**
     * 在文件中写入函数
     * @param score 传入分数参数
     */
    public static void write(int score){
        String ScoreString =  ""+score;  //StartFrame.getUserName()这里后面还要调用StartFrame类方法
        try{
            PrintStream printStream = new PrintStream(new FileOutputStream(file));
            printStream.println("nmsl");//这里要该
            printStream.append(ScoreString).append("\n");
            printStream.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
