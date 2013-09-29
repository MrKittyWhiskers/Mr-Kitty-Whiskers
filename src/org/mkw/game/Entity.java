package org.mkw.game;

import java.util.ArrayList;

import org.mkw.engine.Game;
import org.mkw.engine.GameContainer;

public abstract class Entity {

	GameContainer gc;
	private float X = 0;
	private float Y = 0;
	private int imageWidth;
	private int imageHeight;
	float VX = 0;
	float VY = 0;
	int movement = -1;
	public ArrayList<Boolean> isBottomColliding = new ArrayList<Boolean>();
	public ArrayList<Boolean> isRightColliding = new ArrayList<Boolean>();
	public ArrayList<Boolean> isLeftColliding = new ArrayList<Boolean>();
	
	public abstract void update(Game game);
	
	public float getX() {
		return X;
	}

	public void setX(float x) {
		X = x;
	}

	public float getY() {
		return Y;
	}

	public void setY(float y) {
		Y = y;
	}
	
	public float getVY() {
		return VY;
	}

	public void setVY(float vy) {
		VY = vy;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}
}
