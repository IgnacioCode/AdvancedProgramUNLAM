import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

public class Main extends JFrame implements KeyListener {
   private static final long serialVersionUID = 1L;

   private ArrayList<Point> snake;
   private Point fruit;
   private Random random;

   private final int blockSize = 20;
   private final int width = 20;
   private final int height = 20;

   private int direction = KeyEvent.VK_RIGHT;

   public Main() {
      random = new Random();
      snake = new ArrayList<Point>();
      fruit = new Point(random.nextInt(width), random.nextInt(height));

      setSize(width * blockSize, height * blockSize);
      setTitle("Snake Game");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      setVisible(true);
      addKeyListener(this);
   }

   @Override
   public void paint(Graphics g) {
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, width * blockSize, height * blockSize);

      g.setColor(Color.RED);
      for (Point p : snake) {
         g.fillRect(p.x * blockSize, p.y * blockSize, blockSize, blockSize);
      }

      g.setColor(Color.GREEN);
      g.fillRect(fruit.x * blockSize, fruit.y * blockSize, blockSize, blockSize);
   }

   @Override
   public void keyPressed(KeyEvent e) {
      switch (e.getKeyCode()) {
         case KeyEvent.VK_UP:
            direction = KeyEvent.VK_UP;
            break;
         case KeyEvent.VK_DOWN:
            direction = KeyEvent.VK_DOWN;
            break;
         case KeyEvent.VK_LEFT:
            direction = KeyEvent.VK_LEFT;
            break;
         case KeyEvent.VK_RIGHT:
            direction = KeyEvent.VK_RIGHT;
            break;
      }
   }

   @Override
   public void keyReleased(KeyEvent e) {
   }

   @Override
   public void keyTyped(KeyEvent e) {
   }

   public static void main(String[] args) {
	   Main game = new Main();
   }
}
