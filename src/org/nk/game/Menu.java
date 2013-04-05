package org.nk.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import org.nc.engine.*;

public class Menu extends Game {

	GameContainer gc;

	Input input;
	Font font;
	Font version;
	AffineTransform affinetransform = new AffineTransform();
	FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
	Button single;
	Button multi;
	Button options;
	Button credits;

	public Menu(GameContainer launch, Input input) {
		this.gc = launch;
		this.input = input;
	}

	@Override
	public void init() {
		stateName = "Menu";
		System.out.println("Started");
		gc.isDebugVis = false;
		gc.setTitle("Nuclear Kittens | Alpha 0.0.1");
		gc.setSize(900, 600);
		single = new Button("res/button.png", width / 2 - 125, 100, this, input, "Singleplayer");
		multi = new Button("res/button.png", width / 2 - 125, 200, this, input, "Multiplayer");
		options = new Button("res/button.png", width / 2 - 125, 300, this, input, "Options");
		credits = new Button("res/button.png", width / 2 - 125, 400, this, input, "Credits");
		font = new Font("OCR A Extended", Font.PLAIN, 40);
		version = new Font("Arial", Font.PLAIN, 20);
	}

	@Override
	public void update() {
		if (single.isClicked()) {
			gc.enterState(new Single(gc, input), input);
			System.out.println("Singleplayer");
		}
		if (multi.isClicked()) {
			gc.enterState(new Multi(gc, input), input);
			System.out.println("Multiplayer");
		}
		if (options.isClicked()) {
			gc.enterState(new Options(gc, input), input);
			System.out.println("Options");
		}
		if (credits.isClicked()) {
			gc.enterState(new Credits(gc, input), input);
			System.out.println("Credits");
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		g.drawString("Nuclear Kittens", width / 2 - (int) (font.getStringBounds("Nuclear Kittens", frc).getWidth()) / 2, 50, font);
		g.drawString("Alpha 0.0.1", 0, (int) (getHeight() - version.getStringBounds("Alpha 0.0.1", frc).getHeight() * 2), version);
		single.render(g);
		multi.render(g);
		options.render(g);
		credits.render(g);
	}
}
