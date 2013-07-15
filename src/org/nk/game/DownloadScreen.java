package org.nk.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import org.nk.engine.Game;
import org.nk.engine.GameContainer;
import org.nk.engine.Graphics;
import org.nk.engine.Input;

public class DownloadScreen extends Game{
	
	GameContainer gc;
	Input input;
	AffineTransform affinetransform = new AffineTransform();
	FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
	Font fonta;
	Font fontb;
	static int percent = 0;
	static String file = "Initiating";

	public DownloadScreen(GameContainer launch, Input input) {
		super(launch);
		this.gc = launch;
		this.input = input;
	}

	@Override
	public void init() {
		setStateName("Update");
		fonta = new Font("Arial", Font.PLAIN, 30);
		fontb = new Font("Arial", Font.PLAIN, 20);
	}

	@Override
	public void update() {
		if (percent > 100) {
			gc.enterState(2);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(0, 0, gc.getWidth(), gc.getHeight());
		g.setColor(Color.GRAY);
		g.fillRect(gc.getWidth() / 2 - 200, gc.getHeight() / 2 - 20, percent * 4, 40);
		g.setColor(Color.BLACK);
		g.drawString("Downloading", (int) (gc.getWidth() / 2 - (fonta.getStringBounds("Downloading", frc).getWidth() / 2)), gc.getHeight() / 3, fonta);
		g.drawString(file, (int) (gc.getWidth() / 2 - (fontb.getStringBounds(file, frc).getWidth() / 2)), gc.getHeight() / 3 * 2, fontb);
	}

	@Override
	public int getID() {
		return 1;
	}

}
