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
}
