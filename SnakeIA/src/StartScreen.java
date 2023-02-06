import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartScreen extends JFrame {

   private static final long serialVersionUID = 1L;

   public StartScreen() {
      JPanel panel = new JPanel();
      panel.setPreferredSize(new Dimension(400, 200));
      panel.setLayout(new BorderLayout());
      
      JButton startButton = new JButton("Start");
      startButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            startGame();
         }
      });
      panel.add(startButton, BorderLayout.CENTER);
      
      add(panel);
      pack();
      setTitle("Start Screen");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      setVisible(true);
   }
   
   private void startGame() {
      SnakeGame game = new SnakeGame();
      new Thread(game).start();
      setVisible(false);
   }
   
   public static void main(String[] args) {
      StartScreen startScreen = new StartScreen();
   }
}
