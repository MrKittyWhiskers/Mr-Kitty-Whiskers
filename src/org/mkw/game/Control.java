package org.mkw.game;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import org.mkw.engine.*;

public class Control extends Input {

	public Control() {
	}

	@Override
	public void keyPress(KeyEvent e, Game game) {
		game.keyPress(e);
	}

	@Override
	public void keyRelease(KeyEvent e, Game game) {
		game.keyRelease(e);
	}

	@Override
	public void keyType(KeyEvent e, Game game) {
	}

	@Override
	public void mouseClick(MouseEvent e, Game game) {

	}
}
