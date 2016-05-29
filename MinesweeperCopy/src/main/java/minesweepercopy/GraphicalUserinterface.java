package minesweepercopy;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class GraphicalUserinterface implements Runnable {
    private JFrame frame;
    private Minesweeper game;
    private JButton[][] squares;

    public GraphicalUserinterface(Minesweeper game) {       
        this.game = game;
        this.squares = new JButton[game.getHeight()][game.getWidht()];
    }

    @Override
    public void run() {
        this.frame = new JFrame("Minesweeper");
        frame.setPreferredSize(new Dimension((60 * game.getHeight()), (60 * game.getWidht())));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        container.setLayout(new GridLayout(game.getHeight(), game.getHeight()));
        
        for (int y = 0; y < game.getHeight(); y++) {
            for (int x = 0; x < game.getWidht(); x++) {
                JButton button = new JButton();
                squares[y][x] = button;
                button.addActionListener(new ButtonListener(y, x, squares, game));
                container.add(button);
            }
        }
    }
}
