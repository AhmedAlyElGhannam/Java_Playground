import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;

public class ListOfFonts extends Applet {
	private String[] strArr;
	private String[] strArrDep;
	public void init() {
		Toolkit t= Toolkit.getDefaultToolkit();
		strArrDep = t.getFontList();
		strArr = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	}
	
	public void paint(Graphics g) {
	
		int x = 0;
		int y = 50;
		for (int iter = 0; iter < strArr.length; iter++) {
			Font f = new Font(strArr[iter], Font.BOLD, 10);
			g.setFont(f);
			g.drawString(strArr[iter], x, y);
			y += 50;
			if (y == 1000) {
				y = 0;
				x = 200;
			}
		}

		x = 500;
		y = 50;
		for (int iter2 = 0; iter2 < strArrDep.length; iter2++) {
			Font f = new Font(strArrDep[iter2], Font.BOLD, 10);
			g.setFont(f);
			g.drawString(strArrDep[iter2], x, y);
			y += 50;
		}
	}
}
