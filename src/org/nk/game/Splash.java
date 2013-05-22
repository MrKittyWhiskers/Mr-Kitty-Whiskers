package org.nk.game;

import java.awt.Color;
import java.awt.Font;

import org.nk.engine.Game;
import org.nk.engine.GameContainer;
import org.nk.engine.Graphics;
import org.nk.engine.Input;

public class Splash extends Game {

	GameContainer gc;
	Input input;

	public Splash(GameContainer launch, Input input) {
		this.gc = launch;
		this.input = input;
	}

	@Override
	public void init() {
		setStateName("Splash");
	}

	@Override
	public void update() {
		System.out.println("SPLASH");
	}

	int i = 0;

	@Override
	public void render(Graphics g) {
		Font font = new Font("Arial", Font.PLAIN, 20);
		g.drawString("Splash", gc.getWidth() / 2, gc.getHeight() / 2, font);
	}

	@Override
	public int getID() {
		return 0;
	}

}
