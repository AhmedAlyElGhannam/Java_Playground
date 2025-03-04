import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;
import java.util.Date;
import java.awt.Color;

public class AnimationBall extends Applet implements Runnable {
	Thread th;
	int x;
	int y;
	boolean direction; // true for left to right, false for right to left
	int width;
	int height;
	public boolean isGoingLeftToRight() {
		return (direction == true);
	}
	public boolean isGoingRightToLeft() {
		return (direction == false);
	}
	public void init(){
		x = 0;
		y = 0;
		width = 50;
		height = 50;
		direction = true;
		th = new Thread(this);
		th.start();
	}
	public void paint(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, width, height);
	}
	public void run(){
		while(true){
			try{
				if (isGoingLeftToRight()) {
					x++;
					if (x == getWidth() - width) {
						direction = false;
					}
				}
				else if (isGoingRightToLeft()) {
					x--;
					if (x == 0) {
						direction = true;
					}
				}
				
				repaint();
				Thread.sleep(1); 
			}catch(InterruptedException ie){ie.printStackTrace();}
		}
	}
}
