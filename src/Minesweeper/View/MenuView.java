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
    private final JPanel minesAmountPanel;
    private final JButton playButton;
    private final JButton exitButton;
    private final JComboBox<String> sizeSelect;
    private final JTextField ySizeSelect;
    private final JTextField xSizeSelect;
    private final JTextField minesAmountSelect;

    public MenuView(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        buttonPanel = new JPanel();
        titlePanel = new JPanel();
        sizePanel = new JPanel();
        sizeYPanel = new JPanel();
        sizeXPanel = new JPanel();
        minesAmountPanel = new JPanel();
        playButton = new JButton("Play");
        exitButton = new JButton("Exit");
        DefaultListCellRenderer listCellRenderer = new DefaultListCellRenderer();
        listCellRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        String[] sizes = new String[]{"9x9 Easy", "16x16 Hard", "30x16 Hard", "Custom"};
        sizeSelect = new JComboBox<>(sizes);
        sizeSelect.setRenderer(listCellRenderer);
        ySizeSelect = new JTextField(5);
        xSizeSelect = new JTextField(5);
        minesAmountSelect = new JTextField(5);


        init();
    }

    private void init() {
        setLayout(new GridLayout(2, 1));
        setBackground(new Color(67, 73, 78));

        add(titlePanel);
        add(buttonPanel);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(new Color(67, 73, 78));
        //TODO a image for the menu

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

        playButton.addActionListener(e -> {
            if (ySizeSelect.getText().equals("") || xSizeSelect.getText().equals("") || minesAmountSelect.getText().equals("")){
                if (ySizeSelect.getText().equals("")){
                    ySizeSelect.setText("Leer!");
                    java.util.Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            ySizeSelect.setText("");
                        }
                    }, 1500);
                }
                if (xSizeSelect.getText().equals("")){
                    xSizeSelect.setText("Leer!");
                    java.util.Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            xSizeSelect.setText("");
                        }
                    }, 1500);
                }
                if (minesAmountSelect.getText().equals("")){
                    minesAmountSelect.setText("Leer!");
                    java.util.Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            minesAmountSelect.setText("");
                        }
                    }, 1500);
                }
            } else {
                MenueController.playButtonController(mainFrame, getYWide(), getXWide(), getMinesAmount());
            }
        });
        exitButton.addActionListener(e -> MenueController.exitButtonController());
        sizeSelect.addActionListener(e -> {
            //TODO fix custom Size
            if (sizeSelect.getSelectedIndex() == 3) {
                grid.setRows(4);
                grid.setVgap(30);

                GridLayout grid1 = new GridLayout(1, 3);
                grid1.setHgap(30);
                sizePanel.setLayout(grid1);
                sizePanel.setBackground(new Color(67, 73, 78));
                sizePanel.add(sizeYPanel);
                sizePanel.add(sizeXPanel);
                sizePanel.add(minesAmountPanel);

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

                JLabel amountLabel = new JLabel(" Mines: ");
                amountLabel.setFont(new Font("Arial", Font.PLAIN, 17));
                amountLabel.setForeground(Color.WHITE);
                minesAmountPanel.setLayout(new BorderLayout(10,10));
                minesAmountPanel.setBackground(new Color(51, 52, 56));
                minesAmountPanel.add(amountLabel, BorderLayout.WEST);
                minesAmountPanel.add(minesAmountSelect, BorderLayout.CENTER);

                minesAmountSelect.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
                minesAmountSelect.setFont(new Font("Arial", Font.PLAIN, 25));
                minesAmountSelect.setHorizontalAlignment(JTextField.CENTER);

                buttonPanel.removeAll();
                buttonPanel.add(playButton);
                buttonPanel.add(sizeSelect);
                buttonPanel.add(sizePanel);

                ySizeSelect.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        try {
                            if (Integer.parseInt(ySizeSelect.getText()) >= 40 || Integer.parseInt(ySizeSelect.getText()) <= 3) {
                                ySizeSelect.setText("max 40, min 3");
                                ySizeSelect.setEditable(false);
                                ySizeSelect.setEnabled(false);
                                ySizeSelect.setFont(new Font("Arial", Font.PLAIN, 15));
                                java.util.Timer timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        ySizeSelect.setText("");
                                        ySizeSelect.setEditable(true);
                                        ySizeSelect.setEnabled(true);
                                        ySizeSelect.grabFocus();
                                        ySizeSelect.setFont(new Font("Arial", Font.PLAIN, 25));
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
                            if (Integer.parseInt(xSizeSelect.getText()) >= 40 || Integer.parseInt(xSizeSelect.getText()) <= 3) {
                                xSizeSelect.setText("max 40, min 3");
                                xSizeSelect.setEditable(false);
                                xSizeSelect.setEnabled(false);
                                xSizeSelect.setFont(new Font("Arial", Font.PLAIN, 15));
                                java.util.Timer timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        xSizeSelect.setText("");
                                        xSizeSelect.setEditable(true);
                                        xSizeSelect.setEnabled(true);
                                        xSizeSelect.grabFocus();
                                        xSizeSelect.setFont(new Font("Arial", Font.PLAIN, 25));
                                    }
                                }, 1500);
                            }
                        } catch (NumberFormatException ignored) {}
                        xSizeSelect.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || KeyEvent.VK_BACK_SPACE == e.getKeyCode());
                    }
                });

                minesAmountSelect.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        try {
                            int minMines = 1;
                            int maxMines;
                            if (xSizeSelect.getText().equals("") && ySizeSelect.getText().equals("")){
                                maxMines = 8;
                            } else {
                                maxMines = (Integer.parseInt(xSizeSelect.getText()) * Integer.parseInt(ySizeSelect.getText())) - 1;
                            }
                            if (Integer.parseInt(minesAmountSelect.getText()) >= maxMines || Integer.parseInt(minesAmountSelect.getText()) <= minMines){
                                minesAmountSelect.setText("max " + maxMines + ", min 1");
                                minesAmountSelect.setEditable(false);
                                minesAmountSelect.setEnabled(false);
                                minesAmountSelect.setFont(new Font("Arial", Font.PLAIN, 13));
                                java.util.Timer timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        minesAmountSelect.setText("");
                                        minesAmountSelect.setEditable(true);
                                        minesAmountSelect.setEnabled(true);
                                        minesAmountSelect.grabFocus();
                                        minesAmountSelect.setFont(new Font("Arial", Font.PLAIN, 25));
                                    }
                                }, 1500);
                            }
                        } catch (NumberFormatException ignored){}
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

    private int getMinesAmount(){
        switch (sizeSelect.getSelectedIndex()){
            case 0:
                return 10;
            case 1:
                return 40;
            case 2:
                return 99;
            case 3:
                return Integer.parseInt(minesAmountSelect.getText());
            default:
                return 0;
        }
    }
}
