package Minesweeper.Model;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-04
 */

public class GameMap {
    private final char[][] backgroundMap;
    private final char[][] visualMap;

    public GameMap(int ySize, int xSize){

        backgroundMap = new char[ySize][xSize];
        visualMap = new char[ySize][xSize];

        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                backgroundMap[y][x] = 'e';
                visualMap[y][x] = ' ';
            }
        }
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
}
