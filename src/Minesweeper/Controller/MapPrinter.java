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
    private GameMap gameMap;
    private int ySize, xSize, pixelSize;

    public MapPrinter(GameMap gameMap, int ySize, int xSize){
        this.gameMap = gameMap;
        this.ySize = ySize;
        this.xSize = xSize;

        pixelSize = 35;

        //TODO change pixel size relative to amount (x and y)
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(pixelSize * ySize, pixelSize * xSize);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(pixelSize * ySize, pixelSize * xSize);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(pixelSize * ySize, pixelSize * xSize);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int margin = 10;
        Dimension dim = getSize();
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
    }
}
