package org.mkw.game;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import org.nk.engine.*;
import org.nk.engine.Graphics;

public class Credits extends Game{

	GameContainer gc;
	Input input;
	Font font;
	AffineTransform affinetransform = new AffineTransform();
	FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
	
	public Credits(GameContainer launch, Input input) {
		super(launch);
		this.gc = launch;
		this.input = input;
	}

	@Override
	public void init() {
		setStateName("Play");
		gc.setTitle("Nuclear Kittens | Credits");
		font = new Font("OCR A Extended", Font.PLAIN, 40);
	}

	@Override
	public void update() {
	}

	@Override
	public void render(Graphics g) {
		g.fillRect(0, 0, gc.getWidth(), gc.getHeight());
		g.setColor(Color.PINK);
		g.fillRect(0, 0, gc.getWidth(), gc.getHeight());
		
	}

	@Override
	public int getID() {
		return 6;
	}


}
