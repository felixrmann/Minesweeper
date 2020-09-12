package Minesweeper.Controller;

import java.awt.*;

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
}
