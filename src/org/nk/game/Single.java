package org.nk.game;

import java.awt.Color;
import java.io.IOException;
import org.nk.engine.Game;
import org.nk.engine.GameContainer;
import org.nk.engine.Graphics;
import org.nk.engine.Input;

public class Single extends Game {

	static GameContainer gc;
	Input input;
	public static PlayerEntity player;
	TileHandler tiles;

	public Single(GameContainer launch, Input input) {
		gc = launch;
		player = new PlayerEntity(gc);
		this.input = input;
		try {
			tiles = new TileHandler(gc, player);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void init() {
		setStateName("Play");
		gc.setTitle("Nuclear Kittens | Singleplayer");
	}
	
	@Override
	public void update() {
		tiles.update();
		player.update(this);
	}

	@Override
	public void render(Graphics g) {
		tiles.render(g);
		player.render(g);
		g.setColor(Color.BLACK);
	}
	
	public static void exit() {
		gc.enterState(Launch.Menu);
	}

	@Override
	public int getID() {
		return 3;
	}
}