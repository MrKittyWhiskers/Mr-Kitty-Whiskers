package org.mkw.game;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import org.nk.engine.Game;
import org.nk.engine.GameContainer;
import org.nk.engine.Graphics;

public class PlayerEntity {

	GameContainer gc;
	float X = 0;
	float Y = 0;
	float VX = 0;
	float VY = 0;
	int movement = -1;
	ArrayList<Boolean> isBottomColliding = new ArrayList<Boolean>();
	ArrayList<Boolean> isRightColliding = new ArrayList<Boolean>();
	ArrayList<Boolean> isLeftColliding = new ArrayList<Boolean>();
	boolean jumping;
	Rectangle Bottom = new Rectangle();
	Rectangle Right = new Rectangle();
	Rectangle Left = new Rectangle();
	Rectangle player = new Rectangle();
	int margin = 175;
	static BufferedImage image;
	double scale = 1.6;
	int imageWidth;
	int imageHeight;

	public PlayerEntity(GameContainer gc) {
		this.gc = gc;
		try {
			image = ImageIO.read(new File(Info.path + "/res/player.gif"));
			imageWidth = image.getWidth();
			imageHeight = image.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update(Game game) {
		
		
		if (movement == 0) {
			if (X < margin) {
				float preX = X;
				Single.windowX += 0.2f * game.delta();
				VX = 0;
				X = preX;
			} else {
				if (!isLeftColliding.contains(true)) {
					VX = -0.2f * game.delta();
				} else {
					VX = 0;
				}
			}
		} else if (movement == 2) {
			if (X > gc.getWidth() - margin) {
				float preX = X;
				Single.windowX -= 0.2f * game.delta();
				VX = 0;
				X = preX;
			} else {
				if (!isRightColliding.contains(true)) {
					VX = 0.2f * game.delta();
				} else {
					VX = 0;
				}
			}
		} else if (movement != 1) {
			VX = 0;
		}

		if (isBottomColliding.contains(true)) {
			if (jumping) {
				Y -= 50;
				jumping = false;
			}
		} else {
			VY += 0.01f * game.delta();
		}

		X += VX;
		Y += VY;

		Bottom.setBounds((int) (X + imageWidth * scale - imageWidth / 2), (int) (Y + imageHeight * scale - 11), imageWidth, 10);
		Right.setBounds((int) X + 8, (int) Y + 14, 20, 27);
		Left.setBounds((int) X - 1, (int) Y + 14, 20, 27);
		player.setBounds((int) X, (int) Y, (int) (imageWidth * scale), (int) (imageHeight * scale));
	}

	public void render(Graphics g) {
		g.drawResizeImage(image, (int) X, (int) Y, (int) (imageWidth * scale), (int) (imageHeight * scale));
		if (gc.isDebugVis) {
			g.setColor(Color.BLUE);
			g.drawShape(Bottom);
//			g.drawShape(Right);
//			g.drawShape(Left);
//			g.drawShape(player);
		}
	}
	
	public void die() {
		System.out.println("You dead!");
		Single.windowX = Single.windowY = 0;
		X = Y = 0;
	}
}
