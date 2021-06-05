package utils;

import javax.sound.sampled.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 播放音乐工具类
 */
public class MusicUtils implements Runnable {

    /**
     * 开火音乐文件地址
     */
    public final static String PLAY_FIRE = "music/fire.wav";

    /**
     * 获得补给音乐文件地址
     */
    public final static String PLAY_EAT = "music/eat.wav";

    /**
     * 光标移动文件地址
     */
    public final static String PLAY_CHOOSE = "music/choose.wav";

    /**
     * 爆炸音乐文件地址
     */
    public final static String PLAY_EXPLODE = "music/explode.wav";

    /**
     * 碰撞音效文件地址
     */
    public final static String PLAY_HIT = "music/hit.wav";

    /**
     * 背景音乐文件地址
     */
    public final static String PLAY_BACK_MUSIC = "music/backMusic.wav";

    /**
     * 胜利音乐文件地址
     */
    public final static String PLAY_WIN = "music/win.wav";

    /**
     * 失败音乐文件地址
     */
    public final static String PLAY_LOSE = "music/lose.wav";

    /**
     * 安放障碍物音乐文件地址
     */
    public final static String PLAY_SET = "music/set.wav";

    /**
     * 移除障碍物音乐文件地址
     */
    public final static String PLAY_SET_MOVE = "music/setMove.wav";

    // 音乐文件的路径
    private final String url;

    static URL url1;

    // 播放音乐
    static AudioClip audioClip;

    public MusicUtils(String url) {
        this.url = url;
    }

    static File bgm = new File("music/backMusic.wav");

    /**
     * 播放音乐
     */
    public static void playMusic() {
        try {
            url1 = bgm.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        audioClip = Applet.newAudioClip(url1);
        // 循环播放
        audioClip.loop();
    }

    /**
     * 关闭音乐
     */
    public static void stopMusic() {
        try {
            url1 = bgm.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        audioClip = Applet.newAudioClip(url1);
        audioClip.stop();
    }


    @Override
    public void run() {
        File musicFile = new File(url);
        AudioInputStream audioInputStream;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(musicFile);
        } catch (Exception e1) {
            e1.printStackTrace();
            return;
        }
        AudioFormat format = audioInputStream.getFormat();
        SourceDataLine sourceDataLine = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

        try {
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceDataLine.open(format);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        sourceDataLine.start();
        int bytesCount = 0;
        byte[] bytes = new byte[1024];

        try {
            while (bytesCount != -1) {
                bytesCount = audioInputStream.read(bytes, 0, 1024);
                if (bytesCount >= 0) {
                    sourceDataLine.write(bytes, 0, bytesCount);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sourceDataLine.drain();
            sourceDataLine.close();
        }
    }
}
