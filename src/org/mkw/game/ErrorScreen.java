package org.mkw.game;

import java.awt.Color;
import java.awt.Panel;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

import javax.swing.JTextArea;

import org.nk.engine.GameContainer;

public class ErrorScreen implements UncaughtExceptionHandler {

	GameContainer gc;

	public ErrorScreen(GameContainer gc) {
		this.gc = gc;
	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		try {
			JTextArea info = new JTextArea();
			ArrayList<String> text = new ArrayList<String>();
			text.add("An error occurred. Please copy this page to a new bug report on our Github page (https://github.com/MrKittyWhiskers/Mr-Kitty-Whiskers/issues/new)\n");
			text.add("\n");
			text.add(e.getMessage() + " in " + t.getName() + t.getId() + "\n");
			for (StackTraceElement element : e.getStackTrace()) {
				text.add(element.toString() + "\n");
			}
			
			gc.setPaused(true);
			gc.p.setVisible(true);
			gc.frame.add(info);
			for (String te : text) {
				info.append(te);
			}
			
			info.setEditable(true);
			info.setFocusable(true);
			
		} catch (NullPointerException npe) {
		}
	}

}
