package org.nk.game;

import org.nk.engine.Game;
import org.nk.engine.GameContainer;
import org.nk.engine.Graphics;
import org.nk.engine.Input;

public class Splash extends Game {

	GameContainer gc;
	Input input;

	public Splash(GameContainer launch, Input input) {
		super(launch);
		this.gc = launch;
		this.input = input;
	}

	@Override
	public void init() {
		setStateName("Splash");
	}

	@Override
	public void update() {
	}

	@Override
	public void render(Graphics g) {
		g.fillRect(0, 0, gc.getWidth(), gc.getHeight());
		int scale = (int) (gc.getHeight() / 29);
		g.drawResizeImage(PlayerEntity.image, gc.getWidth() / 2 - (16 * scale) / 2, 0, 16 * scale, 28 * scale);
	}

	@Override
	public int getID() {
		return 0;
	}

}
