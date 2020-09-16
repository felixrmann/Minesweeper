package Minesweeper.Controller;

import Minesweeper.Model.GameMap;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-05
 */

public class GameController {
    private int bombAmount, ySize, xSize;
    private GameMap gameMap;

    public GameController(int ySize, int xSize, int bombAmount, GameMap gameMap){
        this.ySize = ySize;
        this.xSize = xSize;
        this.bombAmount = bombAmount;
        this.gameMap = gameMap;
    }

    public void fillBackMap(){
        for (int amount = 0; amount < bombAmount; amount++) {
            int randomY = (int) (Math.random() * ySize + 1);
            int randomX = (int) (Math.random() * xSize + 1);
            if (gameMap.getPixelBackMap((randomY - 1), (randomX - 1)) == 'e'){
                gameMap.setPixelBackMap((randomY - 1), (randomX - 1), 'm');
            } else {
                amount--;
            }
        }

        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (!(gameMap.getPixelBackMap(y,x) == 'm')){
                    int mCnt = 0;
                    if (!(y - 1 < 0)){
                        if (!(x - 1 < 0)) if (gameMap.getPixelBackMap(y - 1,x - 1) == 'm') mCnt++;
                        if (gameMap.getPixelBackMap(y - 1, x) == 'm') mCnt++;
                        if (!(x + 1 >= xSize)) if (gameMap.getPixelBackMap(y - 1, x + 1) == 'm')mCnt++;
                    }
                    if (!(x - 1 < 0) && gameMap.getPixelBackMap(y, x - 1) == 'm') mCnt++;
                    if (!(x + 1 >= xSize) && gameMap.getPixelBackMap(y, x + 1) == 'm') mCnt++;
                    if (y + 1 < ySize){
                        if (!(x - 1 < 0)) if (gameMap.getPixelBackMap(y + 1, x - 1) == 'm')mCnt++;
                        if (gameMap.getPixelBackMap(y + 1, x) == 'm') mCnt++;
                        if (!(x + 1 >= xSize)) if (gameMap.getPixelBackMap(y + 1, x + 1) == 'm')mCnt++;
                    }
                    if (!(mCnt == 0)){
                        gameMap.setPixelBackMap(y, x, (char) mCnt);
                    }
                }
            }
        }
    }
}
