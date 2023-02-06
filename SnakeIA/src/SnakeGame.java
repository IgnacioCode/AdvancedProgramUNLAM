import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeGame extends JFrame implements KeyListener, Runnable {
   private static final long serialVersionUID = 1L;
   
   private ArrayList<Point> snake;
   private Point fruit;
   private Random random;
   
   private final int blockSize = 20;
   private final int width = 20;
   private final int height = 20;
   
   private final int offsetX = 0;
   private final int offsetY = 0;
   
   private int direction = KeyEvent.VK_RIGHT;
   private boolean running = false;
   
   int dx = 1;
   int dy = 0;
   
   public SnakeGame() {
      random = new Random();
      snake = new ArrayList<Point>();
      snake.add(new Point(3, 3));
      fruit = new Point(random.nextInt(width), random.nextInt(height));
      
      this.setSize(width * blockSize, height * blockSize);
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
      Point punto = snake.get(0);
      System.out.println(punto);
      for (Point p : snake) {
         g.fillRect(p.x * blockSize + offsetX, p.y * blockSize + offsetY, blockSize, blockSize);
      }

      g.setColor(Color.GREEN);
      g.fillRect(fruit.x * blockSize + offsetX, fruit.y * blockSize + offsetY, blockSize, blockSize);
   }

   @Override
   public void keyPressed(KeyEvent e) {
	   direction=e.getExtendedKeyCode();
	   switch(this.direction) {
		   case KeyEvent.VK_UP:
			   changeDirection(0, -1);
			   break;
		   case KeyEvent.VK_DOWN:
			   changeDirection(0, 1);
			   break;
		   case KeyEvent.VK_LEFT:
			   changeDirection(-1, 0);
			   break;
		   case KeyEvent.VK_RIGHT:
			   changeDirection(1, 0);
			   break; 
   }
   }

   @Override
   public void keyReleased(KeyEvent e) {
   }

   @Override
   public void keyTyped(KeyEvent e) {
   }

   @Override
   public void run() {
	   running = true;
	   while (running) {
		   
		   update();
		   repaint();
		   try {
			   Thread.sleep(300);
		   } catch (InterruptedException e) {
			   e.printStackTrace();
		   }
	   }
   }

   private void update() {
	   move();
	   Point head = snake.get(0);
	   if(head.x == fruit.x && head.y == fruit.y) {
		   snake.add(new Point(head.x, head.y));
		   fruit = new Point(random.nextInt(width), random.nextInt(height));
	   }
   }

   public void move() {
	   
	   
	   Point head = snake.get(0);
	   int x = head.x + dx;
	   int y = head.y + dy;
	   
	   if (x >= width) {
		   x = 0;
		} else if (x < 0) {
		   x = width - 1;
		}

		if (y >= height) {
		   y = 0;
		} else if (y < 0) {
		   y = height - 1;
		}
	   
	   for (int i = snake.size() - 1; i > 0; i--) {
		   snake.set(i, snake.get(i - 1));
	   }

	   snake.set(0, new Point(x, y));
   }

   public void changeDirection(int dx, int dy) {
	   this.dx = dx;
	   this.dy = dy;
   }

   public static void main(String[] args) {
      SnakeGame game = new SnakeGame();
      new Thread(game).start();
   }
}
