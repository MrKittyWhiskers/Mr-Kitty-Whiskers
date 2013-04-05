package org.nk.game;

import java.awt.Color;
import org.nc.engine.Game;
import org.nc.engine.GameContainer;
import org.nc.engine.Graphics;
import org.nc.engine.Input;

public class Multi extends Game{
	
	GameContainer gc;
	Input input;

	public Multi(GameContainer launch, Input input) {
		this.gc = launch;
		this.input = input;
	}

	@Override
	public void init() {
		stateName = "Play";
		gc.setTitle("Nuclear Kittens | Multiplayer");
		
	}

	@Override
	public void update() {
	
		
	}

	@Override
	public void render(Graphics g) {
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.PINK);
		g.fillRect(0, 0, width, height);
	}

}
