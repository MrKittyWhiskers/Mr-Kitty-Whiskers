package org.mkw.tiles;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.mkw.game.CollisionEvent;
import org.mkw.game.Tile;

public class Air extends Tile{

	public Air(int x, int y, int size) {
		super(0, size, x, y, 0, 0);
	}

	@Override
	public void onCollision(CollisionEvent e) {
		
	}
}
