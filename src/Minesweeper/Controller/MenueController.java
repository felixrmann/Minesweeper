package Minesweeper.Controller;

import Minesweeper.View.GameView;
import Minesweeper.View.MainFrame;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-04
 */

public class MenueController {

    /*
        This Class controlls the MenueButton inputs
     */

    public static void playButtonController(MainFrame mainFrame, int yWide, int xWide, int minesAmount){
        mainFrame.setContent(new GameView(yWide, xWide, minesAmount));
        mainFrame.setMaxSize();
    }

    public static void exitButtonController(){
        System.exit(0);
    }
}
