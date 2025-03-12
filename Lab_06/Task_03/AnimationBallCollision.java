import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;
import java.util.Date;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AnimationBallCollision extends Applet implements Runnable {
	Thread th;
	int x1;
	int y1;
	int x2;
	int y2;
	
	final int LEFT = 0;
	final int UP = 1;
	final int RIGHT = 2;
	final int DOWN = 3;
	int directionX;
        int directionY;	
	int width;
	int height;

	Button stopAnimation;
	Button resumeAnimation;

	boolean isStarted = true;

	public void init(){
		x1 = 0;
		y1 = getHeight() / 2;
		width = 50;
		height = 50;
		directionY = DOWN;
		directionX = RIGHT;
		th = new Thread(this);

		stopAnimation = new Button("Stop");
		resumeAnimation = new Button("Start");

		resumeAnimation.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if (isStarted) {
							th.start();
							isStarted = false;
						} else {
							th.resume();
						}
					}
				});

		stopAnimation.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						th.suspend();
						repaint();
					}
				});

		add(stopAnimation);
		add(resumeAnimation);
	}
	public void paint(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillOval(x1, y1, width, height);
	}
	public void run(){
		while(true){
			try{
				if (x1 >= (getWidth() - width)){
					directionX = LEFT;
				}
				
				if (x1 <= 0) {
					directionX = RIGHT;
				}

				if (y1 >= (getHeight() - (height))) {
					directionY = UP;
				}

				if (y1 <= 0) {
					directionY = DOWN;
				}

				if (directionX == RIGHT) {
					x1++;
				}	
				else if (directionX == LEFT) {
					x1--;
				}			

				if (directionY == UP) {
					y1--;
				}
				else if (directionY == DOWN) {
					y1++;
				}

				repaint();
				Thread.sleep(1); 
			} catch(InterruptedException ie) { ie.printStackTrace(); }
		}
	}
}
