package Minesweeper.View;

import Minesweeper.Controller.MapPrinter;
import Minesweeper.Model.GameMap;

import javax.swing.*;
import java.awt.*;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-03
 */

public class GameView extends JPanel {
    private MainFrame mainFrame;
    private int ySize, xSize;
    private GameMap gameMap;
    private JPanel mapPanel;

    public GameView(MainFrame mainFrame, int ySize, int xSize){
        this.mainFrame = mainFrame;
        this.ySize = ySize;
        this.xSize = xSize;

        gameMap = new GameMap(ySize, xSize);

        init();
    }

    private void init() {
        setLayout(new BorderLayout(10,10));

        Box box = new Box(BoxLayout.Y_AXIS);
        box.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        box.add(Box.createVerticalGlue());
        box.add(new MapPrinter(gameMap, ySize, xSize), BorderLayout.CENTER);
        box.add(Box.createVerticalGlue());
        add(box, BorderLayout.CENTER);
    }
}
