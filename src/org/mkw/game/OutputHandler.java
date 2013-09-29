package org.mkw.game;

import java.io.IOException;
import java.io.OutputStream;

import org.mkw.engine.GameContainer;

public class OutputHandler {
	
	static GameContainer gc;
	
	public OutputHandler(GameContainer gc) {
		OutputHandler.gc = gc;
	}

	static OutputStream out = new OutputStream() {
		@Override
		public void write(final int b) throws IOException {
			DevConsole.add(String.valueOf((char) b));
		}

		@Override
		public void write(byte[] b, int off, int len) throws IOException {
			DevConsole.add(new String(b, off, len));
		}

		@Override
		public void write(byte[] b) throws IOException {
			write(b, 0, b.length);
		}
	};
}
