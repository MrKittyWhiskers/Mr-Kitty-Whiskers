package org.mkw.game;

import org.nk.engine.GameContainer;
import org.nk.engine.Input;

public class Launch extends GameContainer{
	
	public static void main(String[] args) {
		new Launch().start(args);
	}
	
	public void start(String[] args) {
		setTitle(Info.name);
		setSize(900, 600);
		
		Input input = new Control();
		initInput(input);
		
		addState(new Splash(this, input));
		
		enterState(Info.Splash);
		
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
		
		try {
			isDebugVis = Boolean.parseBoolean(args[1]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Missing argument: debug (true / false)");
		}
		
		init();
	}
}