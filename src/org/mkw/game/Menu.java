package org.mkw.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import org.mkw.engine.*;

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
		super(launch);
		this.gc = launch;
		this.input = input;
		single = new Button(Info.path + "/res/button.png", gc.getWidth() / 2 - 125, 100, this, input, "Singleplayer");
		multi = new Button(Info.path + "/res/button.png", gc.getWidth() / 2 - 125, 200, this, input, "Multiplayer");
		options = new Button(Info.path + "/res/button.png", gc.getWidth() / 2 - 125, 300, this, input, "Options");
		credits = new Button(Info.path + "/res/button.png", gc.getWidth() / 2 - 125, 400, this, input, "Credits");
		font = new Font("OCR A Extended", Font.PLAIN, 40);
		version = new Font("Arial", Font.PLAIN, 20);
	}

	@Override
	public void init() {
		setStateName("Menu");
	}

	@Override
	public void update() {
		if (single.isClicked()) {
			gc.enterState(Info.Single);
			System.out.println("Singleplayer");
		}
		if (multi.isClicked()) {
			gc.enterState(Info.Multi);
			System.out.println("Multiplayer");
		}
		if (options.isClicked()) {
			gc.enterState(Info.Options);
			System.out.println("Options");
		}
		if (credits.isClicked()) {
			gc.enterState(Info.Credits);
			System.out.println("Credits");
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(0, 0, gc.getWidth(), gc.getHeight());
		g.setColor(Color.BLACK);
		g.drawString(Info.name, gc.getWidth() / 2 - (int) (font.getStringBounds(Info.name, frc).getWidth()) / 2, 50, font);
		g.drawString(Info.ver, 0, (int) (gc.getHeight() - version.getStringBounds(Info.ver, frc).getHeight() * 1.35), version);
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
