import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {

    private JButton[][] buttons = new JButton[3][3];
    private boolean xTurn = true;

    public TicTacToe() {
        super("Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 75));
                buttons[i][j].addActionListener(new ButtonListener());
                add(buttons[i][j]);
            }
        }

        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setText(xTurn ? "X" : "O");
            button.setEnabled(false);
            if (checkForWin()) {
                JOptionPane.showMessageDialog(TicTacToe.this, xTurn ? "X Wins!" : "O Wins!", "We have a winner!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            xTurn = !xTurn;
        }
    }

    private boolean checkForWin() {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(i, 0, i, 1, i, 2)) {
                return true;
            }
        }

        // check columns
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(0, i, 1, i, 2, i)) {
                return true;
            }
        }

        // check diagonals
        if (checkRowCol(0, 0, 1, 1, 2, 2)) {
            return true;
        }
        if (checkRowCol(0, 2, 1, 1, 2, 0)) {
            return true;
        }

        return false;
    }

    private boolean checkRowCol(int r1, int c1, int r2, int c2, int r3, int c3) {
        if (buttons[r1][c1].getText().equals(buttons[r2][c2].getText()) && buttons[r2][c2].getText().equals(buttons[r3][c3].getText()) && !buttons[r1][c1].getText().equals("")) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        new TicTacToe();
    }
}
