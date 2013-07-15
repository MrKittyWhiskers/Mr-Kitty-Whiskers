package org.nk.game;

import org.nk.engine.Button;
import org.nk.engine.Game;
import org.nk.engine.Graphics;
import org.nk.engine.Input;

public class PauseScreen extends Overlay {
	
	Input input;
	Button cont;

	public PauseScreen(Game state, Input input) {
		super(true, state);
		this.input = input;
		cont = new Button(Info.path + "/res/button.png", state.gc.getWidth() / 2, state.gc.getHeight() / 2 - 50, state, input, "Continue");
	}

	@Override
	public void render(Graphics g) {
//		renderTransparentRectangle(g, 0, 0, Single.gc.getWidth(), Single.gc.getHeight(), 0.40f, 1, 1, 1);
		cont.render(g);
	}

}
