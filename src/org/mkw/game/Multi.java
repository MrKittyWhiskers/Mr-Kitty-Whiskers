package org.mkw.game;

import java.awt.Color;

import org.mkw.engine.Game;
import org.mkw.engine.GameContainer;
import org.mkw.engine.Graphics;
import org.mkw.engine.Input;

public class Multi extends Game{
	
	GameContainer gc;
	Input input;

	public Multi(GameContainer launch, Input input) {
		super(launch);
		this.gc = launch;
		this.input = input;
	}

	@Override
	public void init() {
		setStateName("Play");
		
	}

	@Override
	public void update() {
	
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(0, 0, gc.getWidth(), gc.getHeight());
	}

	@Override
	public int getID() {
		return 4;
	}

}
