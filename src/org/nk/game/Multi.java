package org.nk.game;

import java.awt.Color;
import org.nk.engine.Game;
import org.nk.engine.GameContainer;
import org.nk.engine.Graphics;
import org.nk.engine.Input;

public class Multi extends Game{
	
	GameContainer gc;
	Input input;

	public Multi(GameContainer launch, Input input) {
		this.gc = launch;
		this.input = input;
	}

	@Override
	public void init() {
		setStateName("Play");
		gc.setTitle("Nuclear Kittens | Multiplayer");
		
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
