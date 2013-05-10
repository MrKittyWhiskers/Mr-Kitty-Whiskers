package org.nk.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.nk.engine.GameContainer;
import org.nk.engine.Graphics;
import org.nk.tiles.Air;
import org.nk.tiles.Ground;
import org.nk.tiles.Kill;

public class TileHandler {

	int size = 15;
	ArrayList<String> lines = new ArrayList<>();
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	PlayerEntity player;
	GameContainer gc;

	public TileHandler(GameContainer gc, PlayerEntity player) throws IOException {
		this.player = player;
		this.gc = gc;
		BufferedReader in = new BufferedReader(new FileReader("D:/Java/TEST.txt"));

		String line;
		int linenumber = 0;

		line = in.readLine();
		while (line != null) {
			linenumber++;
			lines.add(line);
			line = in.readLine();
		}

		in.close();

		Tile.setImage("D:/Java/terrain.png");

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
	}

	public void update() {
		player.isBottomColliding.clear();
		player.isRightColliding.clear();
		player.isLeftColliding.clear();

		for (int i = 0; i < tiles.size(); i++) {
			if (tiles.get(i).intersects(player.Bottom)) {
				player.VY = 0;
				player.squareY = tiles.get(i).getY() - 49;
				player.isBottomColliding.add(true);
				break;
			} else {
				player.isBottomColliding.add(false);
			}
		}

		for (int i = 0; i < tiles.size(); i++) {
			if (tiles.get(i).intersects(player.Right)) {
				if (!tiles.get(i).intersects(player.Bottom)) {
					player.VY = 0;
					player.squareX = tiles.get(i).getX() - 49;
					player.isRightColliding.add(true);
					break;
				}
			} else {
				player.isRightColliding.add(false);
			}
		}

		for (int i = 0; i < tiles.size(); i++) {
			if (tiles.get(i).intersects(player.Left)) {
				if (!tiles.get(i).intersects(player.Bottom)) {
					player.VY = 0;
					player.squareX = tiles.get(i).getX() + size - 1;
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
	}

	public void render(Graphics g) {
		for (int i = 0; i < tiles.size(); i++) {
			tiles.get(i).render(g);
			if (gc.isDebugVis) {
				// g.drawShape(tiles.get(i).tile);
			}
		}
	}
}
