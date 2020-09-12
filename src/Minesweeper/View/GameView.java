package Minesweeper.View;

import Minesweeper.Controller.GameController;
import Minesweeper.Controller.MapPrinter;
import Minesweeper.Model.GameMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-03
 */

public class GameView extends JPanel {
    private final MapPrinter mapPrinter;
    private final GameMap gameMap;
    private JPanel mapPanel;
    private final JPanel leftPanel, pointsPanel, menuPanel;
    private final JButton menuButton;
    private final GameController gameController;

    public GameView(int ySize, int xSize, int minesAmount){

        System.out.println(minesAmount);
        gameMap = new GameMap(ySize, xSize);
        mapPrinter = new MapPrinter(gameMap, ySize, xSize);
        mapPanel = new JPanel();
        mapPanel = mapPrinter.printMap();
        leftPanel = new JPanel();
        pointsPanel = new JPanel();
        menuPanel = new JPanel();
        menuButton = new JButton("Menu");
        gameController = new GameController(minesAmount, gameMap);

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
        //TODO fill text with amount of mines (and Time)

        menuPanel.setPreferredSize(new Dimension(400, 200));
        menuPanel.setLayout(new GridLayout(3,1));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10,80,10,80));
        menuPanel.add(new JPanel());
        menuPanel.add(menuButton);
        menuPanel.add(new JPanel());

        menuButton.setFont(new Font("Arial", Font.PLAIN, 40));
        menuButton.addActionListener(e -> {
            //TODO popup und dan ins menu
        });

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        mapPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int yPos = e.getY() / MapPrinter.getPixelSize();
                int xPos = e.getX() / MapPrinter.getPixelSize();

                switch (e.getModifiers()){
                    case MouseEvent.BUTTON1_MASK:
                        if (gameMap.getPixelVisualMap(yPos, xPos) == ' '){ //if visualMap is not revealed
                            if (!(gameMap.getPixelBackMap(yPos, xPos) == 'm')){
                                gameMap.setPixelVisualMap(yPos, xPos, gameMap.getPixelBackMap(yPos, xPos));
                                updateMap();
                            } else {
                                updateMap();
                                //TODO show score and finish game
                            }

                        }
                        break;
                    case MouseEvent.BUTTON3_MASK:
                        switch (gameMap.getPixelVisualMap(yPos, xPos)) {
                            case ' ':
                                gameMap.setPixelVisualMap(yPos, xPos, 'a');
                                updateMap();
                                break;
                            case 'a':
                                gameMap.setPixelVisualMap(yPos, xPos, '?');
                                updateMap();
                                break;
                            case '?':
                                gameMap.setPixelVisualMap(yPos, xPos, ' ');
                                updateMap();
                                break;
                        }
                        break;
                }
            }
        });
    }

    private void updateMap(){
        mapPanel.removeAll();
        mapPanel = mapPrinter.printMap();
        mapPanel.revalidate();
    }
}
