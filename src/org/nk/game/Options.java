package org.nk.game;

import java.awt.Color;
import java.awt.Font;

import org.nk.engine.Button;
import org.nk.engine.Game;
import org.nk.engine.GameContainer;
import org.nk.engine.Graphics;
import org.nk.engine.Input;

public class Options extends Game{

	GameContainer gc;
	Input input;
	Button back;
	
	public Options(GameContainer launch, Input input) {
		this.gc = launch;
		this.input = input;
	}

	@Override
	public void init() {
		setStateName("Options");
		gc.setTitle("Nuclear Kittens | Options");
		back = new Button(System.getenv("APPDATA") + "\\.NuclearKittens\\res\\button.png", gc.getWidth() / 2 - 125, 10, this, input, "Back");
	}

	@Override
	public void update() {
		if (back.isClicked()) {
			gc.enterState(2);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(0, 0, gc.getWidth(), gc.getHeight());
		g.setColor(Color.black);
		Font font = new Font("Arial", Font.PLAIN, 20);
		g.setFont(font);
		back.render(g);
	}

	@Override
	public int getID() {
		return 5;
	}
}