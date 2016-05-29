package minesweepercopy;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        Minesweeper game = new Minesweeper(15, 15, 0.1);
        GraphicalUserinterface gui = new GraphicalUserinterface(game);
        
        SwingUtilities.invokeLater(gui);
    }
    
}
