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


public class DrawLine extends Applet {

	byte lineState;
	final byte INIT = 0;
	final byte DRAGGED = 1;
	final byte RELEASED = 2;
	final byte DONE = 3;
	Line drawnLine;

	public void init(){
		lineState = INIT;

		drawnLine = new Line();

		addMouseListener(
				new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						drawnLine.x1 = e.getX();
						drawnLine.y1 = e.getY();
						lineState = DRAGGED;	
						repaint();

					}
					public void mouseReleased(MouseEvent e) {
						drawnLine.x2 = e.getX();
						drawnLine.y2 = e.getY();
						lineState = RELEASED;
						repaint();
					}
				});

		addMouseMotionListener(
				new MouseAdapter() {
					public void mouseDragged(MouseEvent e) {
						if (lineState == DRAGGED) {
							drawnLine.x2 = e.getX();
							drawnLine.y2 = e.getY();
						}
						repaint();
					}
				});
	}
	public void paint(Graphics g){
		if (lineState != INIT) {
			g.drawLine(drawnLine.x1, drawnLine.y1, drawnLine.x2, drawnLine.y2);
		}
	}
	
	class Line {
		int x1;
		int x2;
		int y1;
		int y2;
	}
}
