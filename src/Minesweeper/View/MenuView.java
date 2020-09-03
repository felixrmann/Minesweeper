package Minesweeper.View;

import javax.swing.*;
import java.awt.*;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-03
 */

public class MenuView extends JPanel {
    private MainFrame mainFrame;
    private JPanel buttonPanel, titlePanel;
    private JButton playButton, exitButton;
    private JComboBox<String> sizeSelect;

    public MenuView(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        buttonPanel = new JPanel();
        titlePanel = new JPanel();
        playButton = new JButton("Play");
        exitButton = new JButton("Exit");
        String[] sizes = new String[]{"9x9 Easy", "16x16 Hard", "30x16 Hard", "Custom"};
        sizeSelect = new JComboBox<>(sizes);

        init();
    }

    private void init() {
        setLayout(new GridLayout(2,1));
        setBackground(new Color(67, 73, 78));

        add(titlePanel);
        add(buttonPanel);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(new Color(67, 73, 78));
        //TODO a image for the menue

        GridLayout grid = new GridLayout(3,1);
        grid.setVgap(50);
        buttonPanel.setLayout(grid);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,40,10,40));
        buttonPanel.setBackground(new Color(67, 73, 78));
        buttonPanel.add(playButton);
        buttonPanel.add(sizeSelect);
        buttonPanel.add(exitButton);
    }
}
