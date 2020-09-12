package Minesweeper.Controller;

import Minesweeper.Model.GameMap;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-05
 */

public class GameController {
    private int bombAmount;
    private GameMap gameMap;

    public GameController(int bombAmount, GameMap gameMap){
        this.bombAmount = bombAmount;
        this.gameMap = gameMap;


    }
}
