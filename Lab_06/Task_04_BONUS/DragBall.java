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
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;


public class DragBall extends Applet {

	Oval drawnOval;

	public void init() {
		
		drawnOval = new Oval(getWidth() / 2, getHeight() / 2);
		
		addMouseListener(
				new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						drawnOval.x = e.getX();
						drawnOval.y = e.getY();
					}
					public void mouseReleased(MouseEvent e) {
						drawnOval.x = e.getX();
						drawnOval.y = e.getY();
						repaint();						
					}
				});

		addMouseMotionListener(
				new MouseAdapter() {
					public void mouseDragged(MouseEvent e) {
							drawnOval.x = e.getX();
							drawnOval.y = e.getY();
							drawnOval.isDragged = true;
							repaint();
					}
				});
	}
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(drawnOval.x, drawnOval.y, drawnOval.radius, drawnOval.radius);
	}
	
	class Oval {
		int x;
		int y;
		int radius;
		boolean isDragged;

		Oval() {}
		Oval(int _x1, int _y1) {
			x = _x1;
			y = _y1;
			radius = 50;
			isDragged = true;
		}
	}
}