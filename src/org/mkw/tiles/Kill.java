package org.mkw.tiles;

import java.awt.Image;

import org.mkw.game.CollisionEvent;
import org.mkw.game.Tile;

public class Kill extends Tile{
	public Kill(int x, int y, int size) {
		super(2, size, x, y, 2, 0);
	}

	@Override
	public void onCollision(CollisionEvent e) {
		
	}
}
