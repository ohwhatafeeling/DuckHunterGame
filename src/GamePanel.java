import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	JPanel sky;
	JPanel grass;
	JLabel scoreLabel;
	Image duck;
	Timer timer;
	final int PANEL_WIDTH = 700;
	final int PANEL_HEIGHT = 500;
	int xVelocity = 1;
	int yVelocity = 1;
	int x = 0;
	int y = 0;
	int score = 0;
	Rectangle imageBounds;
	
	GamePanel() {
		this.setPreferredSize(new Dimension(700, 500));
		this.setLayout(null);
		
		sky = new JPanel();
		sky.setBounds(0, 0, 700, 300);
		sky.setBackground(Color.BLUE);
		
		grass = new JPanel();
		grass.setBounds(0, 300, 700, 200);
		grass.setBackground(Color.GREEN);
		
		scoreLabel = new JLabel();
		scoreLabel.setBounds(0, 0, 100, 50);
		scoreLabel.setText("Score: " + score);
		scoreLabel.setFont(new Font(null, Font.BOLD, 20));
		scoreLabel.setForeground(Color.WHITE);
		
		duck = new ImageIcon("duck.png").getImage();
		
		imageBounds = new Rectangle(x, y, duck.getWidth(null), duck.getHeight(null));
		
		this.add(sky);
		this.add(grass);
		this.add(scoreLabel);
		this.setComponentZOrder(scoreLabel, 1);
		this.setComponentZOrder(sky, 2);
		this.setComponentZOrder(grass, 2);
		
		timer = new Timer(10, this);
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
		imageBounds = new Rectangle(x, y, duck.getWidth(null), duck.getHeight(null));
		repaint();
	}

}
