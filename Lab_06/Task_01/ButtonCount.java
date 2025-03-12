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

public class ButtonCount extends Applet {
	
	int x;
	Button inc;
	Button dec;

	public void init(){
		inc = new Button("++");
		inc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				x++;
				repaint();
			}		
		});

		dec = new Button("--");
		dec.addActionListener(new MyButtonListener());

		add(inc);
		add(dec);
	}

	public void paint(Graphics g){
		g.drawString("Click Count is: " + x, getWidth()/2, getHeight()/2);
	}	

	class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			x--;
			repaint();
		}
	}
}
