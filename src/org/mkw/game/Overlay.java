package org.mkw.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.nk.engine.Game;
import org.nk.engine.Graphics;

public abstract class Overlay {

	boolean doPause;
	private boolean vis = false;
	Game state;

	public Overlay(boolean doPause, Game state) {
		this.doPause = doPause;
		this.state = state;
	}

	public void setVisible(boolean vis) {
		this.vis = vis;

		if (doPause) {
			state.setPaused(vis);
		}
	}

	public boolean isVisble() {
		return vis;
	}

	void renderTransparentRectangle(Graphics gr, int x, int y, int width, int height, float alpha, int r, int g, int b) {
		Color color = new Color(r, g, b, alpha);
		((Graphics2D) gr.getGraphics()).setPaint(color);
		((Graphics2D) gr.getGraphics()).fill(new Rectangle(x, y, width, height));
	}

	void renderInit(Graphics g) {
		if (vis) {
			render(g);
		}
	}

	public abstract void render(Graphics g);

}
