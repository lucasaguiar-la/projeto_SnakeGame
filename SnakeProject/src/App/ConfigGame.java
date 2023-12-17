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
	final int y[] = new int [GAME_UNITS];
	int bodyParts = 4;
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
		this.addKeyListener(new MyKeysAdapter());
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
			
			// Corpo e cabeça da cobrinha
			for(int i = 0; i < bodyParts; i++) {
				if(i == 0) {
					g.setColor(new Color(129, 199, 132));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				} else {
					g.setColor(new Color(46, 125, 50));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
			
			// Placar no jogo (score)
			g.setColor(new Color(114, 154, 211));
			g.setFont(new Font("Roboto",Font.ITALIC, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: " + appleEatens, (SCREEN_WIDTH - metrics.stringWidth("Score: " + appleEatens))/2, g.getFont().getSize());	
		} else {
			gameOver(g);
		}
		
	}
	
	public void newApple() {
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
	}
	
	public void move() {
		
		for(int i = bodyParts; i > 0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(direction){
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
		
	}
	
	public void checkApple() {
		if((x[0] == appleX) && y[0] == appleY) {
			bodyParts++;
			appleEatens++;
			newApple();
		}
	}
	
	public void checkCollisions() {
		
		// Colissão com a própria cabeça
		for(int i = bodyParts; i > 0; i--) {
			if((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
			}
		}
		// Colissão com a borda esquerda
		if(x[0] < 0) {
			running = false;
		}
		// Collisão com a borda direita
		if(x[0] > SCREEN_WIDTH) {
			running = false;
		}
		// Colissão com o topo
		if(y[0] < 0) {
			running = false;
		}
		// Colissão com a base
		if(y[0] > SCREEN_HEIGHT) {
			running = false;
		}
		// Caso haja colissão o timer para
		if(!running) {
			timer.stop();
		}
	}
	
	public void gameOver(Graphics g) {
		
		// Painel de Score
		g.setColor(new Color(0, 142, 130));
		g.setFont(new Font("Roboto",Font.ITALIC, 65));
		FontMetrics metricsScore = getFontMetrics(g.getFont());
		g.drawString("Score: " + appleEatens, (SCREEN_WIDTH - metricsScore.stringWidth("Score: " + appleEatens))/2, g.getFont().getSize());
		
		// Texto de GameOver
		g.setColor(new Color(0, 142, 130));
		g.setFont(new Font("Roboto", Font.ITALIC, 75));
		FontMetrics metricsGameOver = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metricsGameOver.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
		
	}
	
	public class MyKeysAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction != 'R') {
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction = 'D';
				}
				break;
			}
		}
	}
}



















