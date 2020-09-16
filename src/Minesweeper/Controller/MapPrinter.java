package Minesweeper.Controller;

import Minesweeper.Model.GameMap;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-05
 */

public class MapPrinter extends JPanel {
    private final GameMap gameMap;
    private final int ySize;
    private final int xSize;
    private static int pixelSize;

    public MapPrinter(GameMap gameMap, int ySize, int xSize){
        this.gameMap = gameMap;
        this.ySize = ySize;
        this.xSize = xSize;

        pixelSize = 35;

        if (ySize < 10 && xSize < 10) pixelSize = 100;
        else if (ySize < 20 && xSize < 20) pixelSize = 60;

        setLayout(new GridLayout(ySize, xSize));
        setMinimumSize(new Dimension(pixelSize * ySize, pixelSize * xSize));
        setMaximumSize(new Dimension(pixelSize * ySize, pixelSize * xSize));
        setPreferredSize(new Dimension(pixelSize * ySize, pixelSize * xSize));
    }

    public JPanel printMap(){
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                JPanel panel1 = new JPanel();
                /*
                char text = gameMap.getPixelVisualMap(y,x);
                System.out.println(text);
                JLabel tempLabel = ColorController.getImagePanel(text);
                panel1.add(tempLabel);
                 */
                Color color = ColorController.getColor(gameMap.getPixelVisualMap(y,x));
                panel1.setBackground(color);
                add(panel1);
            }
        }
        return this;
    }

    public static int getPixelSize() {
        return pixelSize;
    }
}
