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


public class DrawLines extends Applet {

	final byte MAX_LINE_COUNT = 3;
	Line[] drawnLines;
	byte lineCounter = 0;

	Line dumDumLine;

	public void init() {
		
		drawnLines = new Line[MAX_LINE_COUNT]; // only allocates space for references
		
		dumDumLine = new Line();
		
		addMouseListener(
				new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						if (lineCounter < MAX_LINE_COUNT) {
							dumDumLine.x1 = e.getX();
							dumDumLine.y1 = e.getY();
							dumDumLine.isDragged = false;	
						}
					}
					public void mouseReleased(MouseEvent e) {
						if ((dumDumLine.isDragged) && (lineCounter < MAX_LINE_COUNT))
						{
							drawnLines[lineCounter] = new Line(dumDumLine.x1, dumDumLine.y1, e.getX(), e.getY()); // have to create an object
							lineCounter++;
							dumDumLine.isDragged = false;	
							repaint();
						}
						
					}
				});

		addMouseMotionListener(
				new MouseAdapter() {
					public void mouseDragged(MouseEvent e) {
						if (lineCounter < MAX_LINE_COUNT) {
							dumDumLine.x2 = e.getX();
							dumDumLine.y2 = e.getY();
							dumDumLine.isDragged = true;
							repaint();
						}
					}
				});
	}
	public void paint(Graphics g) {
		if (dumDumLine.isDragged) {
			g.drawLine(dumDumLine.x1, dumDumLine.y1, dumDumLine.x2, dumDumLine.y2);
		}

		for (int iter = 0; iter < lineCounter; iter++) {
			if (drawnLines[iter] != null) { 
                g.drawLine(drawnLines[iter].x1, drawnLines[iter].y1, drawnLines[iter].x2, drawnLines[iter].y2);
            }
		}
	}
	
	class Line {
		int x1;
		int x2;
		int y1;
		int y2;
		boolean isDragged;

		Line() {}
		Line(int _x1, int _y1, int _x2, int _y2) {
			x1 = _x1;
			x2 = _x2;
			y1 = _y1;
			y2 = _y2;
			isDragged = true;
		}
	}
}