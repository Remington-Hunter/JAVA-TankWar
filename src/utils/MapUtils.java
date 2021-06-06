package utils;

import land.HardWall;
import land.River;
import land.Tree;
import land.Wall;
import ui.GameFrame;

public class MapUtils {
    /**
     * 根据地图难度进行选择改变地图形状
     * @param Difficulty 传入地图难度参数
     */
    public static void ChangeMap(int Difficulty){
        switch (Difficulty){
            case 0:
                for(int i=0;i<10;i++){
                    GameFrame.wallList.add(new Wall(50+30*i,300));
                    GameFrame.wallList.add(new Wall(250,50+30*i));
                    GameFrame.wallList.add(new Wall(350+30*i,100));
                    GameFrame.wallList.add(new Wall(500,180+30*i));
                }
                for(int i=0;i<6;i++){
                    GameFrame.hardWallList.add(new HardWall(340,240+30*i));
                    GameFrame.hardWallList.add(new HardWall(20+30*i,200));
                }
                break;
            case 1:
                GameFrame.wallList.clear();
                GameFrame.hardWallList.clear();
                GameFrame.riverList.clear();
                GameFrame.treeList.clear();
                int[][] SimpleMap = {
                        {0,0,0,4,0,0,0,2,2,2,2,2,2,0,0,0,0,0,0,},
                        {0,0,0,0,1,1,0,0,0,2,2,0,0,1,1,0,0,0,0,},
                        {0,0,0,1,1,1,1,0,0,0,4,0,1,1,1,1,0,0,0,},
                        {0,3,3,0,0,0,0,0,4,0,0,0,0,0,0,0,4,3,3,},
                        {0,3,0,0,0,4,0,0,0,0,0,0,0,0,0,0,4,0,3,},
                        {0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,},
                        {0,3,4,0,0,0,4,0,4,0,4,4,4,0,0,0,4,0,3,},
                        {0,3,0,0,0,0,4,4,4,4,0,0,4,0,0,0,0,0,3,},
                        {0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,3,},
                        {0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,},
                        {0,3,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,3,},
                        {4,0,0,0,0,4,1,1,1,1,1,1,1,4,0,0,0,0,0,},
                        {0,0,0,0,0,4,1,1,0,0,0,1,1,4,0,0,0,4,0,},
                        {0,0,0,0,0,4,1,1,0,0,0,1,1,4,0,0,0,0,0,},
                };
                for(int i=0;i<SimpleMap.length;i++){
                    for(int j=0;j< SimpleMap[i].length;j++){
                        if(SimpleMap[i][j]==1){
                            GameFrame.wallList.add(new Wall(100+30*j,127+31*i));
                        }
                        if(SimpleMap[i][j]==2){
                            GameFrame.hardWallList.add(new HardWall(90+30*j,33*i));
                        }
                        if(SimpleMap[i][j]==3){
                            GameFrame.riverList.add(new River(82+30*j,33*i));
                        }
                        if(SimpleMap[i][j]==4){
                            GameFrame.treeList.add(new Tree(98+30*j,127+32*i));
                        }
                    }
                }
                break;
            case 2:
                GameFrame.wallList.clear();
                GameFrame.hardWallList.clear();
                GameFrame.riverList.clear();
                GameFrame.treeList.clear();
                int[][] MediumMap = {
                        {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,4,4,4,0,},
                        {0,0,1,1,1,1,0,0,0,0,0,0,0,0,4,0,1,1,0,},
                        {0,0,0,0,1,0,0,0,2,2,2,2,0,0,0,0,0,1,0,},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
                        {0,3,0,0,0,0,0,2,2,0,0,2,2,0,0,0,4,0,3,},
                        {0,3,0,0,0,0,0,2,0,0,0,0,2,0,0,0,4,0,3,},
                        {0,3,0,0,0,0,4,1,0,0,0,0,1,4,0,0,4,0,3,},
                        {0,3,0,0,0,0,4,1,1,1,1,1,1,4,0,0,0,0,3,},
                        {0,3,0,0,0,4,4,4,4,4,4,4,4,4,4,0,0,0,3,},
                        {0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,},
                        {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,},
                        {0,0,1,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,0,},
                        {0,0,4,4,4,0,0,0,0,0,0,0,0,0,4,0,1,0,4,},
                };
                for(int i=0;i<MediumMap.length;i++){
                    for(int j=0;j< MediumMap[i].length;j++){
                        if(MediumMap[i][j]==1){
                            GameFrame.wallList.add(new Wall(90+30*j,48+31*i));
                        }
                        if(MediumMap[i][j]==2){
                            GameFrame.hardWallList.add(new HardWall(90+30*j,33+33*i));
                        }
                        if(MediumMap[i][j]==3){
                            GameFrame.riverList.add(new River(90+30*j,33*i));
                        }
                        if(MediumMap[i][j]==4){
                            GameFrame.treeList.add(new Tree(90+30*j,40+32*i));
                        }
                    }
                }
                break;
            case 3:
                GameFrame.wallList.clear();
                GameFrame.hardWallList.clear();
                GameFrame.riverList.clear();
                GameFrame.treeList.clear();
                int[][] HellMap = {
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
                        {0,1,1,1,1,4,4,4,4,4,4,4,4,4,1,1,1,1,0,},
                        {0,1,0,0,0,0,0,0,4,4,4,4,0,0,0,0,0,1,0,},
                        {0,1,0,0,0,0,0,0,4,4,4,4,0,0,0,0,0,1,0,},
                        {0,1,0,0,0,0,1,1,4,4,4,4,1,1,0,0,0,1,0,},
                        {0,4,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,4,0,},
                        {0,4,4,4,4,4,4,1,0,0,0,0,1,4,4,4,4,4,0,},
                        {0,4,4,4,4,4,4,1,0,0,0,0,1,4,4,4,4,4,0,},
                        {0,4,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,4,0,},
                        {0,1,0,0,0,0,1,1,4,4,4,4,1,1,0,0,0,1,0,},
                        {0,1,0,0,0,0,0,0,4,4,4,4,0,0,0,0,0,1,0,},
                        {0,1,0,0,0,0,0,0,4,4,4,4,0,0,0,0,0,1,0,},
                        {0,1,1,1,1,4,4,4,4,4,4,4,4,4,1,1,1,1,0,},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},
                };
                for(int i=0;i<HellMap.length;i++){
                    for(int j=0;j< HellMap[i].length;j++){
                        if(HellMap[i][j]==1){
                            GameFrame.wallList.add(new Wall(110+30*j,50+31*i));
                        }
                        if(HellMap[i][j]==2){
                            GameFrame.hardWallList.add(new HardWall(100+30*j,33*i));
                        }
                        if(HellMap[i][j]==3){
                            GameFrame.riverList.add(new River(80+30*j,33*i));
                        }
                        if(HellMap[i][j]==4){
                            GameFrame.treeList.add(new Tree(109+30*j,42+32*i));
                        }
                    }
                }
                break;
            default:
                break;
        }
    }
}
