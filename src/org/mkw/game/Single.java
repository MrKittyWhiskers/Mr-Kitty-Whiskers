package org.mkw.game;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.mkw.plugin.PluginLoader;
import org.nk.engine.Game;
import org.nk.engine.GameContainer;
import org.nk.engine.Graphics;
import org.nk.engine.Input;

public class Single extends Game {

	static GameContainer gc;
	Input input;
	PauseScreen ps;
	DevConsole console;
	public static PlayerEntity player;
	TileHandler tiles;
	static int windowX;
	static int windowY;

	public Single(GameContainer launch, Input input) {
		super(launch);
		gc = launch;
		this.input = input;
	}

	@Override
	public void init() {
		setStateName("Play");
		player = new PlayerEntity(gc);
		try {
			new PluginLoader();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			tiles = new TileHandler(gc, player);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ps = new PauseScreen(this, input);
		console = new DevConsole(this);
	}

	@Override
	public void keyPress(KeyEvent e) {
		if (e.getKeyCode() == 87) {
			Single.player.jumping = true;
		}
		if (e.getKeyCode() == 68) {
			Single.player.movement = 2;
		} else if (e.getKeyCode() == 65) {
			Single.player.movement = 0;
		}
	}

	@Override
	public void keyRelease(KeyEvent e) {
		if ((e.getKeyCode() == 68) || (e.getKeyCode() == 65)) {
			Single.player.movement = -1;
		}
		if (e.getKeyCode() == 27) {
			ps.setVisible(!ps.isVisble());
		}
	}

	@Override
	public void update() {
		tiles.update();
		player.update(this);
		PluginLoader.update();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Info.Void);
		g.fillRect(0, 0, gc.getWidth(), gc.getHeight());
		tiles.render(g);
		player.render(g);
		ps.renderInit(g);
		console.render(g);
		g.setColor(Color.BLACK);
	}

	public static void exit() {
		gc.enterState(Info.Menu);
	}

	@Override
	public int getID() {
		return 3;
	}
}