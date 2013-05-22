package org.nk.game;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.nk.engine.Graphics;

public class Tile {

	private int ID;
	private int x;
	private int y;
	private int setX;
	private int setY;
	int windowX;
	int windowY;
	private int size;
	private static BufferedImage img;
	private int spriteX;
	private int spriteY;
	private Rectangle tile = new Rectangle();
	private boolean solid;
	private boolean kill;

	public Tile(int ID, int size, int x, int y, int spriteX, int spriteY, boolean solid, boolean kill) {
		this.ID = ID;
		this.setX = x;
		this.setY = y;
		this.spriteX = spriteX;
		this.spriteY = spriteY;
		this.size = size;
		this.solid = solid;
		this.kill = kill;

		tile.x = x;
		tile.y = y;
		tile.width = tile.height = size;

	}

	public static void setImage(String image) throws IOException {
		img = ImageIO.read(new File(image));
	}

	public void render(Graphics g) {
		g.drawImage(img.getSubimage(spriteX * 10, spriteY * 10, 10, 10), getX(), getY(), size, size);
	}
	
	public void update() {
		x = setX + windowX;
		y = setY + windowY;
	}

	public int getID() {
		return ID;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean intersectsKillTile(Rectangle shape) {
		if (kill) {
			if (tile.intersects(shape)) {
				return true;
			}
		}
		return false;
	}

	public boolean intersects(Rectangle shape) {
		tile.x = x;
		tile.y = y;
		if (solid) {
			if (tile.intersects(shape)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
