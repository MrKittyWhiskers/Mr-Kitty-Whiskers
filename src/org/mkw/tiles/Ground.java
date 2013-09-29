package org.mkw.tiles;

import java.awt.Image;

import org.mkw.game.CollisionEvent;
import org.mkw.game.Tile;

public class Ground extends Tile {

	public Ground(int x, int y, int size) {
		super(1, size, x, y, 1, 0);
	}

	@Override
	public void onCollision(CollisionEvent e) {
		e.getEntity().setY(getY() - e.getEntity().getImageHeight() - getSize());
		e.getEntity().setVY(0);
		e.getEntity().isBottomColliding.add(true);
	}
}
