import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	final int PANEL_WIDTH = 700;
	final int PANEL_HEIGHT = 500;
	Image duck;
	Timer timer;
	int xVelocity = 1;
	int yVelocity = 1;
	int x = 0;
	int y = 0;
	
	GamePanel() {
		this.setPreferredSize(new Dimension(700, 500));
		
		duck = new ImageIcon("duck.png").getImage();
		
		timer = new Timer(5, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D)g;
		g2D.drawImage(duck, x, y, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (x >= PANEL_WIDTH - duck.getWidth(null) || x < 0) {
			xVelocity = xVelocity * -1;
		}
		x = x + xVelocity;
		if (y >= PANEL_HEIGHT - duck.getHeight(null) || y < 0) {
			yVelocity = yVelocity * -1;
		}
		y = y + yVelocity;
		repaint();
	}

}
