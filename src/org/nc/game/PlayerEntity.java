package org.nc.game;

import java.awt.Rectangle;

import org.nc.engine.Game;
import org.nc.engine.GameContainer;
import org.nc.engine.Graphics;
import org.nc.engine.Sprite;

public class PlayerEntity {

	GameContainer gc;
	float squareX;
	float squareY;
	// = 248
	float VX = 0;
	float VY = 0;
	int movement = -1;
	boolean isColliding;
	boolean jumping;
	boolean isJumping;

	Rectangle player = new Rectangle(0, 0, 50, 50);

	public PlayerEntity() {
	}

	public void init() {

	}
	
	int i;

	public void update(Game game) {
		if (movement == 0) {
			VX = -0.2f * game.delta();
		} else if (movement == 2) {
			VX = 0.2f * game.delta();
		} else {
			VX = 0;
		}

		if (jumping) {
			if (i < 50) {
				System.out.println(i);
				i++;
				if (isColliding) {
					VY =- 100f;
					isJumping = true;
				}
				if (isJumping) {
					VY =- 20f;
				}
			}
			if (i >= 50) {
				i = 0;
				jumping = false;
				isJumping = false;
			}
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
