package org.mkw.game;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.mkw.engine.EngineImage;
import org.mkw.engine.Game;
import org.mkw.engine.GameContainer;
import org.mkw.engine.Graphics;

public class PlayerEntity extends Entity {

	boolean jumping;
//	Rectangle Bottom = new Rectangle();
//	Rectangle Right = new Rectangle();
//	Rectangle Left = new Rectangle();
//	Rectangle player = new Rectangle();
	int margin = 175;
	static Image image;
	double scale = 1.6;
	Game game;

	public PlayerEntity(GameContainer gc, Game g) {
		this.gc = gc;
		this.game = g;
		try {
			image = ImageIO.read(new File(Info.path + "/res/player.gif"));
			setImageWidth(image.getWidth(null));
			setImageHeight(image.getHeight(null));
			image = EngineImage.resizeImage(image,(int) (getImageWidth() * scale), (int) (getImageHeight() * scale));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Game game) {
		// if (movement == 0) {
		// if (getX() < margin) {
		// float preX = getX();
		// Single.windowX += 0.2f * game.delta();
		// VX = 0;
		// setX(preX);
		// } else {
		// if (!isLeftColliding.contains(true)) {
		// VX = -0.2f * game.delta();
		// } else {
		// VX = 0;
		// }
		// }
		// } else if (movement == 2) {
		// if (getX() > gc.getWidth() - margin) {
		// float preX = getX();
		// Single.windowX -= 0.2f * game.delta();
		// VX = 0;
		// setX(preX);
		// } else {
		// if (!isRightColliding.contains(true)) {
		// VX = 0.2f * game.delta();
		// } else {
		// VX = 0;
		// }
		// }
		// } else if (movement != 1) {
		// VX = 0;
		// }
		//
		// if (isBottomColliding.contains(true)) {
		// if (jumping) {
		// setY(getY() - 50);
		// jumping = false;
		// }
		// } else {
		// VY += 0.01f * game.delta();
		// }

		if (movement == -1 && VY < 9) {
			VY += 0.15;
		}
		if (movement == 1) {
			System.out.println(1);
		} else if (movement == 2) {
			System.out.println(2);
		}

		setX(getX() + VX);
		setY(getY() + VY);

//		Bottom.setBounds((int) (getX() + getImageWidth() * scale - getImageWidth() / 2), (int) (getY() + getImageHeight() * scale - 11), getImageWidth(), 10);
//		Right.setBounds((int) getX() + 8, (int) getY() + 14, 20, 27);
//		Left.setBounds((int) getX() - 1, (int) getY() + 14, 20, 27);
//		player.setBounds((int) getX(), (int) getY(), (int) (getImageWidth() * scale), (int) (getImageHeight() * scale));
	}

	public void render(Graphics g) {
		g.drawImage(image, (int) getX(), (int) getY());
		if (gc.isDebugVis) {
			g.setColor(Color.BLUE);
//			g.drawShape(Bottom);
//			g.drawShape(Right);
//			g.drawShape(Left);
//			g.drawShape(player);
		}
	}

	public void die() {
		System.out.println("You dead!");
		Single.windowX = Single.windowY = 0;
		setX(0);
		setY(0);
	}

	public void jump() {
		for (int i = 0; i < 100; i++) {
			setY(-getY() + 0.5f);
		}
	}

	public void left() {
		if (VX < 1) {
			VX += 0.05 * game.delta();
		}
		System.out.println(VX);
	}

	public void right() {
		if (VX > -1) {
			VX -= 0.05 * game.delta();
		}
		System.out.println(VX);
	}
}
