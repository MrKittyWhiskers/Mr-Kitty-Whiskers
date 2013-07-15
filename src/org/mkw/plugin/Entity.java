package org.mkw.plugin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.nk.engine.Graphics;

public class Entity {
	
	static BufferedImage img = null;
	static int x;
	static int y;
	
	public Entity(String path) {
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public static void render(Graphics g) {
		g.drawImage(img, x, y);
	}
}
