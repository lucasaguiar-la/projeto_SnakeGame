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
		newApple();
		running = true;
		timer = new Timer(DELAY,this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw (Graphics g) {
		
		if(running) {
			// Linhas guias para visualização do grid
			for(int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			}
			
			// Maças ocupando o espaço de 1 tale do grid
			g.setColor(new Color(239, 154, 154));
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
			
		}
		
	}
	
	public void newApple() {
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
	}
	
	public void move() {
		
	}
	
	public void checkApple() {
		
	}
	
	public void checkCollisions() {
		
	}
	
	public void gameOver() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}



















