package org.mkw.game;

import java.awt.Color;
import java.io.OutputStream;
import java.util.ArrayList;
import org.nk.engine.Game;
import org.nk.engine.Graphics;

public class DevConsole extends Overlay {

	public static OutputStream out = null;
	static Game game;
	static ArrayList<String> text = new ArrayList<>();
	static int limit = 13;

	public DevConsole(Game state) {
		super(false, state);
		game = state;
		setVisible(true);
	}

	public static void add(String t) {
		text.add(t);
		if (text.size() / 2 > limit) {
			text.remove(0);
		}
	}

	
	@Override
	public void render(Graphics g) {
		System.out.println("test");
		renderTransparentRectangle(g, 0, 0, game.gc.getWidth(), game.gc.getHeight() / 3, 0.70f, 0, 0, 0);
		g.setColor(Color.WHITE);
		g.drawString(game.debuginfo, 5, 10, g.currentFont());
		for (int i = 0; i < text.size(); i++) {
			g.drawString(text.get(i), 5, (i + 1) * 7 + 13, g.currentFont());
		}
	}
}
