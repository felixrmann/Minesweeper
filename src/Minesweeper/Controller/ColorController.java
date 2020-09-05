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
                return new Color(10,10,10);
            case 'e':
                return new Color(20,20,20);
            case 'm':
                return new Color(255, 0,0);
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
