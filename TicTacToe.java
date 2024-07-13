import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tictactoe extends JFrame implements ActionListener {
    // Constants for game configuration
    private static final int BOARD_SIZE = 3;
    private static final String PLAYER_X = "X";
    private static final String PLAYER_O = "O";
    // Game state
    private String currentPlayer;
    private JButton[][] buttons;
    private boolean gameWon;

    public tictactoe() {
        // Initialize the game window
        setTitle("Tic-Tac-Toe Game");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        // Initialize game variables
        currentPlayer = PLAYER_X;
        buttons = new JButton[BOARD_SIZE][BOARD_SIZE];
        gameWon = false;

        // Create and add buttons to the grid
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                buttons[row][col] = new JButton("");
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[row][col].setFocusPainted(false);
                buttons[row][col].addActionListener(this);
                add(buttons[row][col]);
            }
        }

        // Make the window visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        JButton buttonClicked = (JButton) e.getSource();

        // Check if the button is already marked or the game is won
        if (!buttonClicked.getText().equals("") || gameWon) {
            return;
        }
