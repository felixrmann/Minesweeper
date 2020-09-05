package Minesweeper.View;

import Minesweeper.Controller.MapPrinter;
import Minesweeper.Model.GameMap;

import javax.swing.*;
import java.awt.*;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-03
 */

public class GameView extends JPanel {
    private MainFrame mainFrame;
    private MapPrinter mapPrinter;
    private int ySize, xSize;
    private GameMap gameMap;
    private JPanel mapPanel, leftPanel, pointsPanel, menuPanel;
    private JButton menuButton;

    public GameView(MainFrame mainFrame, int ySize, int xSize){
        this.mainFrame = mainFrame;
        this.ySize = ySize;
        this.xSize = xSize;

        gameMap = new GameMap(ySize, xSize);
        mapPrinter = new MapPrinter(gameMap, ySize, xSize);
        mapPanel = new JPanel();
        mapPanel = mapPrinter.printMap();
        leftPanel = new JPanel();
        pointsPanel = new JPanel();
        menuPanel = new JPanel();
        menuButton = new JButton("Menu");

        init();
    }

    private void init() {
        setLayout(new BorderLayout(10,10));

        Box box = new Box(BoxLayout.Y_AXIS);
        box.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        box.add(Box.createVerticalGlue());
        box.add(mapPanel, BorderLayout.CENTER);
        box.add(Box.createVerticalGlue());
        add(box, BorderLayout.CENTER);

        add(leftPanel, BorderLayout.WEST);

        leftPanel.setLayout(new BorderLayout(10,10));
        leftPanel.setPreferredSize(new Dimension(400,100));
        leftPanel.add(pointsPanel, BorderLayout.NORTH);
        leftPanel.add(new JPanel(), BorderLayout.CENTER);
        leftPanel.add(menuPanel, BorderLayout.SOUTH);

        pointsPanel.setBackground(Color.BLUE);

        menuPanel.setPreferredSize(new Dimension(400, 200));
        menuPanel.setLayout(new GridLayout(3,1));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10,80,10,80));
        menuPanel.add(new JPanel());
        menuPanel.add(menuButton);
        menuPanel.add(new JPanel());

        menuButton.setFont(new Font("Arial", Font.PLAIN, 40));

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}
