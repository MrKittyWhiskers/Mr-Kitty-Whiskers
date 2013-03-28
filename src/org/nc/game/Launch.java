package org.nc.game;

import java.awt.event.KeyEvent;
import org.nc.engine.Game;
import org.nc.engine.GameContainer;
import org.nc.engine.Graphics;
import org.nc.engine.Input;

public class Launch extends GameContainer {

	public static void main(String[] args) {
		Launch l = new Launch();
		l.start();
	}

	public void start() {
		
	}

	public void keyPress(KeyEvent e, Game game) {
		if (e.getKeyCode() == 32) {
			Input input = null;
			enterState(new Menu(this, input), input);
		}
	}
	
	public void render(Graphics g) {

	}

}
