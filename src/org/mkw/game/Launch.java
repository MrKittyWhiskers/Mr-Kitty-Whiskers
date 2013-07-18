package org.mkw.game;

import java.io.PrintStream;

import javax.swing.JPanel;

import org.nk.engine.GameContainer;
import org.nk.engine.Input;

public class Launch extends GameContainer{
	
	public static void main(String[] args) {
		new Launch().start(args);
	}
	
	public static JPanel p = new JPanel();
	
	public void start(String[] args) {
		setTitle(Info.name);
		setSize(900, 600);
		
		p.setVisible(false);
		frame.add(p);
		
		Input input = new Control();
		initInput(input);
		
		Thread.setDefaultUncaughtExceptionHandler(new ErrorScreen(this));
//		System.setOut(new PrintStream(OutputHandler.out, true));
		
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