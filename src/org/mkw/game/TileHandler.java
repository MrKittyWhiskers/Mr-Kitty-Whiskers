package org.mkw.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.mkw.tiles.Air;
import org.mkw.tiles.Ground;
import org.mkw.tiles.Kill;
import org.nk.engine.GameContainer;
import org.nk.engine.Graphics;

public class TileHandler {

	int size = 15;
	ArrayList<String> lines = new ArrayList<>();
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	PlayerEntity player;
	GameContainer gc;
	private int width = 0;

	public TileHandler(GameContainer gc, PlayerEntity player) throws IOException {
		this.player = player;
		this.gc = gc;
		BufferedReader in = new BufferedReader(new FileReader(Info.path + "/res/TEST.txt"));

		String line;
		int linenumber = 0;

		line = in.readLine();
		while (line != null) {
			linenumber++;
			lines.add(line);
			line = in.readLine();
		}

		in.close();

		Tile.setImage(Info.path + "/res/Terrain.png");

		for (int y = 0; y < linenumber; y++) {
			for (int x = 0; x < lines.get(y).length(); x++) {
				if (lines.get(y).substring(x, x + 1).equals("0")) {
					tiles.add(new Air((x + 1) * size - size, (y + 1) * size - size, size));
				} else if (lines.get(y).substring(x, x + 1).equals("1")) {
					tiles.add(new Ground((x + 1) * size - size, (y + 1) * size - size, size));
				} else if (lines.get(y).substring(x, x + 1).equals("2")) {
					tiles.add(new Kill((x + 1) * size - size, (y + 1) * size - size, size));
				}
			}
		}

		width = lines.get(0).length() - 1;
	}

	public void update() {
		player.isBottomColliding.clear();
		player.isRightColliding.clear();
		player.isLeftColliding.clear();

		for (Tile t : tiles) {
			if (t.intersects(player.Bottom)) {
				player.VY = 0;
				player.Y = t.getY() - (player.imageHeight - 1) - size;
				player.isBottomColliding.add(true);
//					try {
//						new BufferedReader(new FileReader(new File("C:/potato"))).readLine();
//					} catch (FileNotFoundException e) {
//						e.printStackTrace();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
					System.out.println(1/0);
				break;
			} else {
				player.isBottomColliding.add(false);
			}
		}

		for (Tile t : tiles) {
			if (t.intersects(player.Right)) {
				if (!t.intersects(player.Bottom)) {
					player.VY = 0;
					player.X = t.getX() - 49;
					player.isRightColliding.add(true);
					break;
				}
			} else {
				player.isRightColliding.add(false);
			}
		}

		for (Tile t : tiles) {
			if (t.intersects(player.Left)) {
				if (!t.intersects(player.Bottom)) {
					player.VY = 0;
					player.X = t.getX() - 1;
					player.isLeftColliding.add(true);
					break;
				}
			} else {
				player.isLeftColliding.add(false);
			}
		}

		for (Tile t : tiles) {
			if (t.intersectsKillTile(player.player)) {
				player.die();
			}
		}

		for (Tile t : tiles) {
			t.windowX = Single.windowX;
			t.windowY = Single.windowY;
			t.update();
		}
	}

	public int getTile(int line, int square) {
		return width * line + square + line;
	}

	public void render(Graphics g) {
		for (int i = 0; i < tiles.size(); i++) {
			tiles.get(i).render(g);
			// if (gc.isDebugVis) {
			// g.drawShape(tiles.get(i).tile);
			// }
		}

		
		try {
		if (gc.isDebugVis) {
			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 4; y++) {
					g.drawShape(tiles.get(getTile((int) ((player.Y - Single.windowY) / 15) + y, (int) ((player.X - Single.windowX) / 15) + x)).tile);
				}
			}
		}
		}catch(IndexOutOfBoundsException e) {
			
		}
	}
}
