package org.nk.game;

import java.awt.Color;
import java.awt.Font;

import org.nc.engine.Button;
import org.nc.engine.Game;
import org.nc.engine.GameContainer;
import org.nc.engine.Graphics;
import org.nc.engine.Input;

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
		stateName = "Play";
		gc.setTitle("Nuclear Kittens | Options");
		back = new Button("res/button.png", getWidth() / 2 - 125, 10, this, input, "Back");
	}

	@Override
	public void update() {
		if (back.isClicked()) {
			gc.enterState(new Menu(gc, input), input);
		}
	}

	@Override
	public void render(Graphics g) {
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.PINK);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.black);
		Font font = new Font("Arial", Font.PLAIN, 20);
		g.setFont(font);
		back.render(g);
	}
}