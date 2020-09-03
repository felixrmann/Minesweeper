package Minesweeper.Main;

import Minesweeper.View.MainFrame;
import Minesweeper.View.MenuView;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-03
 */

public class Minesweeper {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setContent(new MenuView(mainFrame));
    }
}
