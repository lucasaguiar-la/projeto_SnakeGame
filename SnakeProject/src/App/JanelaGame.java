package App;

import javax.swing.JFrame;

public class JanelaGame extends JFrame{
	
	public JanelaGame() {
		
		this.add(new ConfigGame());
		this.setTitle("Snake Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
}
