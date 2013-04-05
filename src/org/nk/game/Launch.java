package org.nk.game;

import org.nc.engine.GameContainer;
import org.nc.engine.Input;

public class Launch extends GameContainer {

	public static void main(String[] args) {
		Launch l = new Launch();
		l.start();
	}

	public void start() {
		Input input = new Control();
		enterState(new Menu(this, input), input);
	}
}
