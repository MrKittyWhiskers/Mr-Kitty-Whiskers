package org.mkw.game;

import java.io.PrintStream;
import org.mkw.engine.GameContainer;
import org.mkw.engine.Input;

public class Launch extends GameContainer{
	
	public static void main(String[] args) {
		new Launch().start(args);
	}
	
	public void start(String[] args) {
		setTitle(Info.name);
		setSize(900, 600);
		
		Input input = new Control();
		initInput(input);
		
//		setErrorScreenEnabled(true, "An error occurred. Please copy this page to a new bug report on our Github page (https://github.com/MrKittyWhiskers/Mr-Kitty-Whiskers/issues/new)");
		
//		System.setOut(new PrintStream(OutputHandler.out, true));
		
		addState(new Splash(this, input));

		enterState(Info.Splash);
		
		addState(new DownloadScreen(this, input));
		addState(new Menu(this, input));
		addState(new Single(this, input));
		addState(new Options(this, input));
		addState(new Multi(this, input));
		addState(new Credits(this, input));
		
		init();
		
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
	}
}