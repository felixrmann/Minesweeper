package Minesweeper.Controller;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-05
 */

public class ColorController {
    public static Color getColor(char color){
        switch (color){
            case ' ':
                //leer
                return new Color(10,10,10);
            case 'e':
                //empty
                return new Color(54, 132, 129);
            case 'm':
                //mine
                return new Color(255, 0,0);
            case 'a':
                //attention
                return new Color(208, 190, 46);
            case '?':
                //is there mine?
                return new Color(150, 226, 72);
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
                return new Color(255, 255, 255);
            default:
                return null;
        }
    }

    public static JLabel getImagePanel(char color){
        URL path;
        switch (color){
            case ' ':
                path = ColorController.class.getResource("../img/black.png");
                break;
            case 'e':
                path = ColorController.class.getResource("../img/black.png");
                break;
            case 'm':
                path = ColorController.class.getResource("../img/m.png");
                break;
            case 'a':
                path = ColorController.class.getResource("../img/black.png");
                break;
            case '?':
                path = ColorController.class.getResource("../img/black.png");
                break;
            case '1':
                path = ColorController.class.getResource("../img/1.jpg");
                break;
            case '2':
                path = ColorController.class.getResource("../img/2.jpg");
                break;
            case '3':
                path = ColorController.class.getResource("../img/3.jpg");
                break;
            case '4':
                path = ColorController.class.getResource("../img/4.jpg");
                break;
            case '5':
                path = ColorController.class.getResource("../img/black.png");
                break;
            case '6':
                path = ColorController.class.getResource("../img/black.png");
                break;
            case '7':
                path = ColorController.class.getResource("../img/black.png");
                break;
            case '8':
                path = ColorController.class.getResource("../img/black.png");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + color);
        }
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();
        int size = MapPrinter.getPixelSize();
        Image newImg = image.getScaledInstance(size, size, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);
        JLabel img = new JLabel();
        img.setIcon(icon);
        return img;
    }
}
