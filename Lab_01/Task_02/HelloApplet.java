import java.applet.Applet;
import java.awt.Graphics;

public class HelloApplet extends Applet {
	public void paint(Graphics g) {
		String passedName = new String(getParameter("passname"));
		g.drawString(passedName, 50, 100);	
	}
}
