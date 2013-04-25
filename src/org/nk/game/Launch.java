package org.nk.game;

import org.nk.engine.GameContainer;
import org.nk.engine.Input;

public class Launch extends GameContainer{
	
	public static int Splash = 0;
	public static int DownloadScreen = 1;
	public static int Menu = 2;
	public static int Single = 3;
	public static int Options = 5;
	public static int Multi = 4;
	public static int Credits = 6;

	public static void main(String[] args) {
		new Launch().start(args);
	}
	
	public void start(String[] args) {
		setTitle("Nuclear Kittens");
		setSize(900, 600);
		isDebugVis = false;
		
		Input input = new Control();
		initInput(input);
		
		addState(new Splash(this, input));
		addState(new DownloadScreen(this, input));
		addState(new Menu(this, input));
		addState(new Single(this, input));
		addState(new Options(this, input));
		addState(new Multi(this, input));
		addState(new Credits(this, input));
		try {
			new Update(Boolean.parseBoolean(args[0]), this, input);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Missing argument: update (true / false)");
		}
	}
}