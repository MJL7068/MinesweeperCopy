package minesweepercopy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class ButtonListener implements ActionListener {

    private int y;
    private int x;
    private JButton[][] squares;
    private Minesweeper game;
    private JButton button;

    public ButtonListener(int y, int x, JButton[][] squares, Minesweeper game) {
        this.y = y;
        this.x = x;
        this.squares = squares;
        this.game = game;
        this.button = squares[y][x];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (game.getValue(x, y) == -1) {
//            button.setText("x");
//        } else {
//            int value = game.calculateValue(y, x);
//            if (value == 0) {
//                
//            }
//            if (value != 0) {
//                button.setText("" + game.calculateValue(y, x));
//            }
//        }
//        button.setEnabled(false);
        handleButton(y, x);
    }

    public void handleButton(int y, int x) {
        ArrayList<String> surroundingSquares = game.getSurroundingSquares(y, x);
        game.addToUsedSquares(y + ":" + x);
        JButton button = squares[y][x];
        if (game.getValue(x, y) == -1) {
            button.setText("x");
        } else {
            int value = game.calculateValue(y, x);
            if (value == 0) {
                for (String square : surroundingSquares) {
                    if (!game.getUsedSquares().contains(square)) {
                        String[] coords = square.split(":");
                        handleButton(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
                    }
                }
            }
            if (value != 0) {
                button.setText("" + game.calculateValue(y, x));
            }
        }
        button.setEnabled(false);
    }

}
