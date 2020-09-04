package Minesweeper.View;

import javax.swing.*;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-03
 */

public class GameView extends JPanel {
    private MainFrame mainFrame;
    private int ySize, xSize;

    public GameView(MainFrame mainFrame, int ySize, int xSize){
        this.mainFrame = mainFrame;
        this.ySize = ySize;
        this.xSize = xSize;


    }
}
