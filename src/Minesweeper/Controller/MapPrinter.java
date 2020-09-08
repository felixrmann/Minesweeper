package Minesweeper.Controller;

import Minesweeper.Model.GameMap;

import javax.swing.*;
import java.awt.*;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-05
 */

public class MapPrinter extends JPanel {
    private final GameMap gameMap;
    private final int ySize;
    private final int xSize;
    private int pixelSize;

    public MapPrinter(GameMap gameMap, int ySize, int xSize){
        this.gameMap = gameMap;
        this.ySize = ySize;
        this.xSize = xSize;

        pixelSize = 35;

        if (ySize < 10 && xSize < 10) pixelSize = 100;
        else if (ySize < 20 && xSize < 20) pixelSize = 60;

        //TODO change pixel size relative to amount (x and y)
    }

    /*
    public int getSelectedPanel(int ){

    }

     */

    public JPanel printMap(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(ySize, xSize));
        panel.setMinimumSize(new Dimension(pixelSize * ySize, pixelSize * xSize));
        panel.setMaximumSize(new Dimension(pixelSize * ySize, pixelSize * xSize));
        panel.setPreferredSize(new Dimension(pixelSize * ySize, pixelSize * xSize));

        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                JPanel panel1 = new JPanel();
                panel1.setBackground(ColorController.getColor(gameMap.getPixelBackMap(y,x)));
                //TODO fill text with amount of mines
                panel.add(panel1);
            }
        }

        return panel;
    }
}
