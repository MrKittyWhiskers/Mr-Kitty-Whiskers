package org.nc.game;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import org.nc.engine.Game;
import org.nc.engine.GameContainer;
import org.nc.engine.Graphics;
import org.nc.engine.Input;

public class Single extends Game {

	GameContainer gc;
	Input input;
	public static PlayerEntity player = new PlayerEntity();
	ArrayList<Rectangle> CB = new ArrayList<Rectangle>();
	BufferedReader reader;
	String line;
	boolean isDone = false;

	String[] abcd = new String[1];
	float a, b, c, d;
	Rectangle rect;
	
	public Single(GameContainer launch, Input input) {
		this.gc = launch;
		this.input = input;

		try {
			reader = new BufferedReader(new FileReader("res/coords.txt"));
			line = reader.readLine();
			while (!isDone) {
				count();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	int lines;

	public void count() {
		try {
			line = reader.readLine();
			if (!line.equals("###")) {
				lines++;
			} else {
				isDone = true;
			}
		} catch (IOException ioe) {
		} catch (NullPointerException npe) {
		}
	}

	public void setVar() {
		try {
			reader.close();
			reader = new BufferedReader(new FileReader("res/coords.txt"));
			for (int i = 0; i <= lines; i++) {
				String line = reader.readLine().trim();
				abcd = line.split(" ");
				a = Float.parseFloat(abcd[0]);
				b = Float.parseFloat(abcd[1]);
				c = Float.parseFloat(abcd[2]);
				d = Float.parseFloat(abcd[3]);
				rect = new Rectangle((int) a, (int) b, (int) c, (int) d);
				CB.add(rect);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() {
		stateName = "Play";
		gc.setTitle("Nuclear Kittens | Singleplayer");
		setVar();
	}

	@Override
	public void update() {
//		System.out.println(mouseX() + ", "+ mouseY());
		for (int i = 0; i < CB.size(); i++) {
			if (CB.get(i).intersects(player.player)) {
				player.VY = 0;
				player.squareY = CB.get(i).y - 49;
				player.isColliding.add(true);
			} else {
				player.isColliding.add(false);
			}
			System.out.println(player.isColliding);
		}
		player.update(this);
		player.isColliding.clear();
	}

	@Override
	public void render(Graphics g) {
		BufferedImage i = null;
		try {
			i = ImageIO.read(new File("res/landscape.png"));
		} catch (IOException e) {
		}
		g.drawImage(i, 0, 0);
		player.render(g);
		for (int box = 0; box < CB.size(); box++) {
			g.drawShape(CB.get(box));
		}
	}

}