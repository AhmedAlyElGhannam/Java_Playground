import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;
import java.util.Date;

public class DispDate extends Applet implements Runnable {
	Thread th;
	int x;
	int y;
	public void init(){
		x = getWidth();
		y = getHeight();
		th = new Thread(this);
		th.start();
	}
	public void paint(Graphics g){
		Date d = new Date();
		g.drawString(d.toString(), x, y);
	}
	public void run(){
		while(true){
			try{
				repaint();
				Thread.sleep(1000); 
			}catch(InterruptedException ie){ie.printStackTrace();}
		}
	}
}
