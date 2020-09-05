package Minesweeper.View;

import Minesweeper.Controller.MenueController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-03
 */

public class MenuView extends JPanel {
    private final MainFrame mainFrame;
    private final JPanel buttonPanel;
    private final JPanel titlePanel;
    private final JPanel sizePanel;
    private final JPanel sizeYPanel;
    private final JPanel sizeXPanel;
    private final JButton playButton;
    private final JButton exitButton;
    private final JComboBox<String> sizeSelect;
    private final JTextField ySizeSelect;
    private final JTextField xSizeSelect;

    public MenuView(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        buttonPanel = new JPanel();
        titlePanel = new JPanel();
        sizePanel = new JPanel();
        sizeYPanel = new JPanel();
        sizeXPanel = new JPanel();
        playButton = new JButton("Play");
        exitButton = new JButton("Exit");
        DefaultListCellRenderer listCellRenderer = new DefaultListCellRenderer();
        listCellRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        String[] sizes = new String[]{"9x9 Easy", "16x16 Hard", "30x16 Hard", "Custom"};
        sizeSelect = new JComboBox<>(sizes);
        sizeSelect.setRenderer(listCellRenderer);
        ySizeSelect = new JTextField(5);
        xSizeSelect = new JTextField(5);

        init();
    }

    private void init() {
        setLayout(new GridLayout(2, 1));
        setBackground(new Color(67, 73, 78));

        add(titlePanel);
        add(buttonPanel);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(new Color(67, 73, 78));
        //TODO a image for the menue

        GridLayout grid = new GridLayout(3, 1);
        grid.setVgap(50);
        buttonPanel.setLayout(grid);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        buttonPanel.setBackground(new Color(67, 73, 78));
        buttonPanel.add(playButton);
        buttonPanel.add(sizeSelect);
        buttonPanel.add(exitButton);

        playButton.setFont(new Font("Arial", Font.PLAIN, 30));
        sizeSelect.setFont(new Font("Arial", Font.PLAIN, 30));
        exitButton.setFont(new Font("Arial", Font.PLAIN, 30));

        playButton.addActionListener(e -> MenueController.playButtonController(mainFrame, getYWide(), getXWide()));
        exitButton.addActionListener(e -> MenueController.exitButtonController());
        sizeSelect.addActionListener(e -> {
            if (sizeSelect.getSelectedIndex() == 3) {
                grid.setRows(4);
                grid.setVgap(30);

                GridLayout grid1 = new GridLayout(1, 2);
                grid1.setHgap(30);
                sizePanel.setLayout(grid1);
                sizePanel.setBackground(new Color(67, 73, 78));
                sizePanel.add(sizeYPanel);
                sizePanel.add(sizeXPanel);

                JLabel yLabel = new JLabel(" Y: ");
                yLabel.setFont(new Font("Arial", Font.PLAIN, 25));
                yLabel.setForeground(Color.WHITE);
                sizeYPanel.setLayout(new BorderLayout(10, 10));
                sizeYPanel.setBackground(new Color(51, 52, 56));
                sizeYPanel.add(yLabel, BorderLayout.WEST);
                sizeYPanel.add(ySizeSelect, BorderLayout.CENTER);

                ySizeSelect.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
                ySizeSelect.setFont(new Font("Arial", Font.PLAIN, 25));
                ySizeSelect.setHorizontalAlignment(JTextField.CENTER);

                JLabel xLabel = new JLabel(" X: ");
                xLabel.setFont(new Font("Arial", Font.PLAIN, 25));
                xLabel.setForeground(Color.WHITE);
                sizeXPanel.setLayout(new BorderLayout(10, 10));
                sizeXPanel.setBackground(new Color(51, 52, 56));
                sizeXPanel.add(xLabel, BorderLayout.WEST);
                sizeXPanel.add(xSizeSelect, BorderLayout.CENTER);

                xSizeSelect.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
                xSizeSelect.setFont(new Font("Arial", Font.PLAIN, 25));
                xSizeSelect.setHorizontalAlignment(JTextField.CENTER);

                buttonPanel.removeAll();
                buttonPanel.add(playButton);
                buttonPanel.add(sizeSelect);
                buttonPanel.add(sizePanel);

                ySizeSelect.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        try {
                            if (Integer.parseInt(ySizeSelect.getText()) >= 40 || Integer.parseInt(ySizeSelect.getText()) <= 0) {
                                ySizeSelect.setText("max 40, min 1");
                                ySizeSelect.setEditable(false);
                                ySizeSelect.setEnabled(false);
                                java.util.Timer timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        ySizeSelect.setText("");
                                        ySizeSelect.setEditable(true);
                                        ySizeSelect.setEnabled(true);
                                        ySizeSelect.grabFocus();
                                    }
                                }, 1500);
                            }
                        } catch (NumberFormatException ignored) {}
                        ySizeSelect.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || KeyEvent.VK_BACK_SPACE == e.getKeyCode());
                    }
                });

                xSizeSelect.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        try {
                            if (Integer.parseInt(xSizeSelect.getText()) >= 40 || Integer.parseInt(xSizeSelect.getText()) <= 0) {
                                xSizeSelect.setText("max 40, min 1");
                                xSizeSelect.setEditable(false);
                                xSizeSelect.setEnabled(false);
                                java.util.Timer timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        xSizeSelect.setText("");
                                        xSizeSelect.setEditable(true);
                                        xSizeSelect.setEnabled(true);
                                        xSizeSelect.grabFocus();
                                    }
                                }, 1500);
                            }
                        } catch (NumberFormatException ignored) {}
                        xSizeSelect.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || KeyEvent.VK_BACK_SPACE == e.getKeyCode());
                    }
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

    private int getYWide() {
        switch (sizeSelect.getSelectedIndex()) {
            case 0:
                return 9;
            case 1:
            case 2:
                return 16;
            case 3:
                return Integer.parseInt(ySizeSelect.getText());
            default:
                return 0;
        }
    }

    private int getXWide() {
        switch (sizeSelect.getSelectedIndex()) {
            case 0:
                return 9;
            case 1:
                return 16;
            case 2:
                return 30;
            case 3:
                return Integer.parseInt(xSizeSelect.getText());
            default:
                return 0;
        }
    }
}
