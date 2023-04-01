package PartIV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RollDice extends JFrame {


    private static final int FRAME_WIDTH = 450;
    private static final int FRAME_HEIGHT = 800;

    int dice1;
    int dice2;

    public RollDice() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        ImagePanel topImagePanel = new ImagePanel("die1.png");
        topImagePanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.add(topImagePanel, BorderLayout.NORTH);

        Grid grid = new Grid();
        grid.setBackground(Color.WHITE);
        mainPanel.add(grid, BorderLayout.CENTER);
        mainPanel.add(new ImagePanel("die1.png"), BorderLayout.SOUTH);

        BottomPanel bottomPanel = new BottomPanel();
        bottomPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.add(mainPanel);
    }

    public static void main(String[] args) {
        RollDice rollDice = new RollDice();
        rollDice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rollDice.setVisible(true);

    }

    class BottomPanel extends JPanel {

        private JButton button;
        private JLabel resultLabel;
        int result;
        int dice1;
        int dice2;

        public BottomPanel() {
            // Use instance fields for components
            resultLabel = new JLabel("Result: ");
            result = 0;
            dice1 = 0;
            dice2 = 0;
            createButton();
            createPanel();

        }

        public void createButton() {
            button = new JButton("Roll Dice");

            class AddInterestListener implements ActionListener {
                public void actionPerformed(ActionEvent event) {
                    dice1 = (int) (Math.random() * 6 + 1);
                    dice2 = (int) (Math.random() * 6 + 1);
                    result = dice1 + dice2;
                    resultLabel.setText("Result: " + result);
//                    imageUpdate();
                }
            }

            button.addActionListener(new AddInterestListener());
        }

        public void createPanel() {
            JPanel controlPanel = new JPanel();
            controlPanel.setLayout(new GridLayout(2, 1));

            JPanel componentPanel = new JPanel();
            componentPanel.add(resultLabel);
            componentPanel.setBackground(Color.LIGHT_GRAY);
            controlPanel.add(componentPanel);

            componentPanel = new JPanel();
            componentPanel.setBackground(Color.LIGHT_GRAY);
            componentPanel.add(button);
            controlPanel.add(componentPanel);

//        this.add(dataPanel, BorderLayout.NORTH);
//        this.add(controlPanel, BorderLayout.SOUTH);
            this.add(controlPanel);
            //this.add(panel);
        }
    }

    class Grid extends JPanel {

        int currentPosition;

        int numberOfRows = 5;
        int numberOfCols = 5;

        static final int originX = 15;
        static final int originY = 30;
        static final int side = 80;

        public Grid() {
            currentPosition = 1;
            setPreferredSize(new Dimension(400, 200));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (int i = 0; i < numberOfRows + 1; i++) {
                g.drawLine(originX, originY + i * side,
                        originX + numberOfCols * side, originY + i * side);
            }

            for (int i = 0; i < numberOfCols + 1; i++) {
                g.drawLine(originX + i * side, originY,
                        originX + i * side, originY + numberOfRows * side);
            }

            g.fillOval((side)/2 + originX, (side)/2 + originY,15,15);
        }

    }
}
