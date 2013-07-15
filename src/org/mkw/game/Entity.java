package org.mkw.game;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.nk.engine.Graphics;

public class Entity {

	PlayerEntity player;
	ArrayList<Rectangle> CB = new ArrayList<Rectangle>();
	String[] abcd = new String[1];
	float a, b, c, d;
	Rectangle rect;
	BufferedReader reader;
	String line;
	boolean isDone = false;
	int lines;

	public Entity(PlayerEntity player) {
		this.player = player;
		try {
			reader = new BufferedReader(new FileReader(System.getenv("APPDATA") + "\\.NuclearKittens\\res\\coords.txt"));
			line = reader.readLine();
			while (!isDone) {
				count();
			}
		} catch (IOException e) {
			System.out.println("Coordinate file not found!");
		}
	}

	public void update() {
		player.isBottomColliding.clear();
		player.isRightColliding.clear();
		player.isLeftColliding.clear();

		for (int i = 0; i < CB.size(); i++) {
			if (CB.get(i).intersects(player.Bottom)) {
				player.VY = 0;
				player.Y = CB.get(i).y - 49;
				player.isBottomColliding.add(true);
				break;
			} else {
				player.isBottomColliding.add(false);
			}
		}

		for (int i = 0; i < CB.size(); i++) {
			if (CB.get(i).intersects(player.Right)) {
				if (!CB.get(i).intersects(player.Bottom)) {
					player.VY = 0;
					player.X = CB.get(i).x - 49;
					player.isRightColliding.add(true);
					break;
				}
			} else {
				player.isRightColliding.add(false);
			}
		}

		for (int i = 0; i < CB.size(); i++) {
			if (CB.get(i).intersects(player.Left)) {
				if (!CB.get(i).intersects(player.Bottom)) {
					player.VY = 0;
					player.X = CB.get(i).x + CB.get(i).width - 1;
					player.isLeftColliding.add(true);
					break;
				}
			} else {
				player.isLeftColliding.add(false);
			}
		}
	}

	public void setVar() {
		try {
			reader = new BufferedReader(new FileReader(System.getenv("APPDATA") + "\\.NuclearKittens\\res\\coords.txt"));
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
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void count() {
		try {
			line = reader.readLine();
			if (!line.equals("###")) {
				lines++;
			} else {
				isDone = true;
				setVar();
			}
		} catch (IOException ioe) {
		} catch (NullPointerException npe) {
		}
	}

	public void render(Graphics g) {
		for (int box = 0; box < CB.size(); box++) {
			g.drawShape(CB.get(box));
		}
	}
}
