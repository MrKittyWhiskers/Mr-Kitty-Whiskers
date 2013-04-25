package org.nk.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import org.nk.engine.*;

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
		gc.setTitle("Nuclear Kittens | Alpha 0.0.1");
		single = new Button(System.getenv("APPDATA") + "\\.NuclearKittens\\res\\button.png", gc.getWidth() / 2 - 125, 100, this, input, "Singleplayer");
		multi = new Button(System.getenv("APPDATA") + "\\.NuclearKittens\\res\\button.png", gc.getWidth() / 2 - 125, 200, this, input, "Multiplayer");
		options = new Button(System.getenv("APPDATA") + "\\.NuclearKittens\\res\\button.png", gc.getWidth() / 2 - 125, 300, this, input, "Options");
		credits = new Button(System.getenv("APPDATA") + "\\.NuclearKittens\\res\\button.png", gc.getWidth() / 2 - 125, 400, this, input, "Credits");
		font = new Font("OCR A Extended", Font.PLAIN, 40);
		version = new Font("Arial", Font.PLAIN, 20);
	}

	@Override
	public void update() {
		if (single.isClicked()) {
			gc.enterState(Launch.Single);
			System.out.println("Singleplayer");
		}
		if (multi.isClicked()) {
			gc.enterState(Launch.Multi);
			System.out.println("Multiplayer");
		}
		if (options.isClicked()) {
			gc.enterState(Launch.Options);
			System.out.println("Options");
		}
		if (credits.isClicked()) {
			gc.enterState(Launch.Credits);
			System.out.println("Credits");
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(0, 0, gc.getWidth(), gc.getHeight());
		g.setColor(Color.BLACK);
		g.drawString("Nuclear Kittens", gc.getWidth() / 2 - (int) (font.getStringBounds("Nuclear Kittens", frc).getWidth()) / 2, 50, font);
		g.drawString("Alpha 0.0.1", 0, (int) (gc.getHeight() - version.getStringBounds("Alpha 0.0.1", frc).getHeight() * 1.35), version);
		single.render(g);
		multi.render(g);
		options.render(g);
		credits.render(g);
	}

	@Override
	public int getID() {
		return 2;
	}
}
