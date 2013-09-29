package org.mkw.game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.mkw.engine.EngineImage;
import org.mkw.engine.Game;
import org.mkw.engine.GameContainer;
import org.mkw.engine.Graphics;
import org.mkw.engine.Input;

public class Splash extends Game {

	GameContainer gc;
	Input input;
	Image image;
	int scale;

	public Splash(GameContainer launch, Input input) {
		super(launch);
		this.gc = launch;
		this.input = input;
		scale = (int) (gc.getHeight() / 29);
		try {
			image = EngineImage.resizeImage(ImageIO.read(new File(Info.path + "/res/Player.gif")), 16 * scale, 28 * scale);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		g.drawImage(PlayerEntity.image, gc.getWidth() / 2 - (16 * scale) / 2, 0);
	}

	@Override
	public int getID() {
		return 0;
	}

}
