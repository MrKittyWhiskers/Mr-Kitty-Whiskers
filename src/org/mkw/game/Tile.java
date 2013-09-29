package org.mkw.game;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.mkw.engine.EngineImage;
import org.mkw.engine.Graphics;

public abstract class Tile {

	private int ID;
	private int x;
	private int y;
	private int setX;
	private int setY;
	int windowX;
	int windowY;
	private int size;
	private Image img;
	private int spriteX;
	private int spriteY;
	Rectangle tile = new Rectangle();

	public Tile(int ID, int size, int x, int y, int spriteX, int spriteY) {
		this.ID = ID;
		this.setX = x;
		this.setY = y;
		this.spriteX = spriteX;
		this.spriteY = spriteY;
		this.size = size;

		tile.x = x;
		tile.y = y;
		tile.width = tile.height = size;

		try {
			getImage(Info.path + "/res/Terrain.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getSize() {
		return size;
	}

	public Image getImage(String imageLoc) throws IOException {
		img = ImageIO.read(new File(imageLoc));
		img = ((BufferedImage) img).getSubimage(spriteX * 10, spriteY * 10, 10, 10);
		img = EngineImage.resizeImage(img, size, size);
		return img;
	}
	
	public final void render(Graphics g) {
		g.drawImage(img, getX(), getY());
		// g.drawSubImage(img.getSubimage(spriteX * 10, spriteY * 10, 10, 10), getX(), getY(), size, size);
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

	public abstract void onCollision(CollisionEvent e);
}
