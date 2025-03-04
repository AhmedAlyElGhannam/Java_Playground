import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;
import java.awt.Color;
public class Lamp extends Applet {

	public void paint(Graphics g) {
		
		//drawUpperOval
		g.setColor(Color.YELLOW);
		g.fillOval(150, 75, 150, 70);	
		// other ovals
		g.fillOval(200, 150, 50, 65);
		g.fillOval(165, 170, 25, 45);
		g.fillOval(265, 170, 25, 45);
		// drawRightLine
		g.setColor(Color.BLACK);
		g.drawLine(350, 300, 300, 110);
		// drawLeftLine
		g.drawLine(100, 300, 150, 110);		
		// drawLowerArc
		g.drawArc(100, 280, 250, 40, 0, -180);
		// drawLowerLeftLine
		g.drawLine(250, 350, 230, 320);	
		// drawLowerRightLine
		g.drawLine(200, 350, 220, 320);	
		// drawRectBase
		g.drawRect(150, 350, 150, 25);
	}
}
