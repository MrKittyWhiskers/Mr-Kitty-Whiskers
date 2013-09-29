package org.mkw.game;

import org.mkw.engine.Button;
import org.mkw.engine.Game;
import org.mkw.engine.GameContainer;
import org.mkw.engine.Graphics;
import org.mkw.engine.Input;

public class PauseScreen extends Overlay {
	
	Input input;
	Button restart;

	public PauseScreen(GameContainer gc, Game state, Input input) {
		super(true, state, gc);
		this.input = input;
		restart = new Button(Info.path + "/res/button.png", state.gc.getWidth() / 2, state.gc.getHeight() / 2 - 50, state, input, "Restart");
	}

	@Override
	public void render(Graphics g) {
//		renderTransparentRectangle(g, 0, 0, Single.gc.getWidth(), Single.gc.getHeight(), 0.40f, 1, 1, 1);
		restart.render(g);
	}

}
