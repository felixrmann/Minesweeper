package Minesweeper.View;

import Minesweeper.Controller.MenueController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-03
 */

public class MenuView extends JPanel {
    private MainFrame mainFrame;
    private JPanel buttonPanel, titlePanel, sizePanel, sizeYPanel, sizeXPanel;
    private JButton playButton, exitButton;
    private DefaultListCellRenderer listCellRenderer;
    private JComboBox<String> sizeSelect;
    private JTextField ySizeSelect, xSizeSelect;

    public MenuView(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        buttonPanel = new JPanel();
        titlePanel = new JPanel();
        sizePanel = new JPanel();
        sizeYPanel = new JPanel();
        sizeXPanel = new JPanel();
        playButton = new JButton("Play");
        exitButton = new JButton("Exit");
        listCellRenderer = new DefaultListCellRenderer();
        listCellRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        String[] sizes = new String[]{"9x9 Easy", "16x16 Hard", "30x16 Hard", "Custom"};
        sizeSelect = new JComboBox<>(sizes);
        sizeSelect.setRenderer(listCellRenderer);
        ySizeSelect = new JTextField(5);
        xSizeSelect = new JTextField(5);

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

        playButton.setFont(new Font("Arial", Font.PLAIN, 30));
        sizeSelect.setFont(new Font("Arial", Font.PLAIN, 30));
        exitButton.setFont(new Font("Arial", Font.PLAIN, 30));

        playButton.addActionListener(e -> MenueController.playButtonController(getYWide(), getXWide()));
        exitButton.addActionListener(e -> MenueController.exitButtonController());
        sizeSelect.addActionListener(e -> {
            if (sizeSelect.getSelectedIndex() == 3){
                grid.setRows(4);
                grid.setVgap(30);

                GridLayout grid1 = new GridLayout(1,2);
                grid1.setHgap(30);
                sizePanel.setLayout(grid1);
                sizePanel.setBackground(new Color(67, 73, 78));
                sizePanel.add(sizeYPanel);
                sizePanel.add(sizeXPanel);

                JLabel yLabel = new JLabel(" Y: ");
                yLabel.setFont(new Font("Arial", Font.PLAIN, 25));
                yLabel.setForeground(Color.WHITE);
                sizeYPanel.setLayout(new BorderLayout(10,10));
                sizeYPanel.setBackground(new Color(51, 52, 56));
                sizeYPanel.add(yLabel, BorderLayout.WEST);
                sizeYPanel.add(ySizeSelect, BorderLayout.CENTER);

                ySizeSelect.setBorder(BorderFactory.createEmptyBorder(10,0,10,10));
                ySizeSelect.setFont(new Font("Arial", Font.PLAIN, 25));

                JLabel xLabel = new JLabel(" X: ");
                xLabel.setFont(new Font("Arial", Font.PLAIN, 25));
                xLabel.setForeground(Color.WHITE);
                sizeXPanel.setLayout(new BorderLayout(10,10));
                sizeXPanel.setBackground(new Color(51, 52, 56));
                sizeXPanel.add(xLabel, BorderLayout.WEST);
                sizeXPanel.add(xSizeSelect, BorderLayout.CENTER);

                xSizeSelect.setBorder(BorderFactory.createEmptyBorder(10,0,10,10));
                xSizeSelect.setFont(new Font("Arial", Font.PLAIN, 25));

                buttonPanel.removeAll();
                buttonPanel.add(playButton);
                buttonPanel.add(sizeSelect);
                buttonPanel.add(sizePanel);

                ySizeSelect.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        String value = ySizeSelect.getText();
                        int l = value.length();
                        ySizeSelect.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || KeyEvent.VK_BACK_SPACE == e.getKeyCode());
                    };
                });

                xSizeSelect.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        String value = xSizeSelect.getText();
                        int l = value.length();
                        xSizeSelect.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || KeyEvent.VK_BACK_SPACE == e.getKeyCode());
                    };
                });
            } else {
                grid.setRows(3);
                grid.setVgap(50);
                buttonPanel.removeAll();
                buttonPanel.add(playButton);
                buttonPanel.add(sizeSelect);
            }
            buttonPanel.add(exitButton);
            buttonPanel.revalidate();
        });
    }

    private int getXWide(){
        return 0;
    }

    private int getYWide(){
        return 0;
    }
}
