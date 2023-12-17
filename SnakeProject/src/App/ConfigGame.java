package App;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class ConfigGame extends JPanel implements ActionListener{
	
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 35;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
	static final int DELAY = 75;
	final int x[] = new int[GAME_UNITS];
	final int t[] = new int [GAME_UNITS];
	int bodyParts = 3;
	int appleEatens;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean running = false;
	Timer timer;
	Random random;
	
	ConfigGame(){
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_HEIGHT, SCREEN_WIDTH));
		this.setBackground(new Color(186, 187, 189));
		this.setFocusable(true);
		start();
	}
	
	public void start() {
		
	}
	
	public void componentesPintura(Graphics g) {
		
	}
	
	public void Pintura (Graphics g) {
		
	}
	
	public void novaMaca() {
		
	}
	
	public void movimentos() {
		
	}
	
	public void verificarMaca() {
		
	}
	
	public void colissoes() {
		
	}
	
	public void gameOver() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}



















