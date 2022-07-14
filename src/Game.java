import javax.swing.JFrame;

public class Game extends JFrame{
	
	Game() {
		GamePanel panel = new GamePanel();
		
		this.setTitle("Duck Hunter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
