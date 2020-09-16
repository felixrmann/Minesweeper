package Minesweeper.Main;

import Minesweeper.View.GameView;
import Minesweeper.View.MainFrame;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-05
 */

public class gameStart {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setContent(new GameView(9,9, 20));
        mainFrame.setMaxSize();
    }
}
