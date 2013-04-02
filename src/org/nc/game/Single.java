package org.nc.game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.nc.engine.Game;
import org.nc.engine.GameContainer;
import org.nc.engine.Graphics;
import org.nc.engine.Input;

public class Single extends Game {

	GameContainer gc;
	Input input;
	public static PlayerEntity player = new PlayerEntity();
	Entity entity = new Entity(player);

	public Single(GameContainer launch, Input input) {
		this.gc = launch;
		this.input = input;
	}
	
	@Override
	public void init() {
		stateName = "Play";
		gc.setTitle("Nuclear Kittens | Singleplayer");
	}

	@Override
	public void update() {
		entity.update();
		player.update(this);
	}

	@Override
	public void render(Graphics g) {
		BufferedImage i = null;
		try {
			i = ImageIO.read(new File("res/landscape.png"));
		} catch (IOException e) {
		}
		g.drawImage(i, 0, 0);
		entity.render(g);
		player.render(g);
	}

}