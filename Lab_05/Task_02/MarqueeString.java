import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;
import java.util.Date;

public class MarqueeString extends Applet implements Runnable {
	Thread th;
	int x;
	int y;
	public void init(){
		x = 0;
		y = 50;
		th = new Thread(this);
		th.start();
	}
	public void paint(Graphics g){
		g.drawString("Za Warudo!", x, y);
	}
	public void run(){
		while(true){
			try{
				x++;
				if (x == getWidth()) {
					x = 0;
				}
				repaint();
				Thread.sleep(5); 
			}catch(InterruptedException ie){ie.printStackTrace();}
		}
	}
}
