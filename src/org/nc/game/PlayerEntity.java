package org.nc.game;

import java.awt.Rectangle;
import java.util.ArrayList;

import org.nc.engine.Game;
import org.nc.engine.GameContainer;
import org.nc.engine.Graphics;
import org.nc.engine.Sprite;

public class PlayerEntity {

	GameContainer gc;
	float squareX;
	float squareY;
	float VX = 0;
	float VY = 0;
	int movement = -1;
	ArrayList<Boolean> isColliding = new ArrayList<Boolean>();
//	boolean[] isColliding;
	boolean jumping;

	Rectangle player = new Rectangle(0, 0, 50, 50);

	public void update(Game game) {
		if (movement == 0) {
			VX = -0.2f * game.delta();
		} else if (movement == 2) {
			VX = 0.2f * game.delta();
		} else {
			VX = 0;
		}
		
		if (isColliding.contains(true)) {
			if (jumping) {
				squareY -= 50;
				jumping = false;
			}
		} else {
			VY += 0.01f * game.delta();
		}
		player.setBounds((int) squareX, (int) squareY, 50, 50);
		squareX += VX;
		squareY += VY;
	}

	public void render(Graphics g) {
		new Sprite();
		g.drawImage(Sprite.getSprite("res/textures.png", 1, 50, 50), squareX, squareY);
	}

}
