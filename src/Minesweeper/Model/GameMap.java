package Minesweeper.Model;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-04
 */

public class GameMap {
    private int ySize, xSize;
    private char[][] backgroundMap, visualMap;


    public GameMap(int ySize, int xSize){
        this.ySize = ySize;
        this.xSize = xSize;

        backgroundMap = new char[ySize][xSize];
        visualMap = new char[ySize][xSize];

        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                backgroundMap[y][x] = 'e';
                visualMap[y][x] = ' ';
            }
        }
        //TODO fill backgroundMap
    }

    public void setPixelBackMap(int yPos, int xPos, char color){
        backgroundMap[yPos][xPos] = color;
    }

    public void setPixelVisualMap(int yPos, int xPos, char color) {
        visualMap[yPos][xPos] = color;
    }

    public char getPixelBackMap(int yPos, int xPos){
        return backgroundMap[yPos][xPos];
    }

    public char getPixelVisualMap(int yPos, int xPos){
        return visualMap[yPos][xPos];
    }

    public char[][] getBackgroundMap() {
        return backgroundMap;
    }

    public char[][] getVisualMap() {
        return visualMap;
    }
}
