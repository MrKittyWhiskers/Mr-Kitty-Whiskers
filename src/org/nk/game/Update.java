package org.nk.game;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.nk.engine.GameContainer;
import org.nk.engine.Input;

public class Update {

	boolean update;
	GameContainer gc;
	Input input;

	public Update(boolean forceUpdate, GameContainer gc, Input input) {
		this.update = forceUpdate;
		this.gc = gc;
		this.input = input;
		check();
	}

	private enum filesEnum {

		BUTTONPNG(
			System.getenv("APPDATA") + "\\.NuclearKittens\\res\\",
			"button.png"),
		COORDS(
			System.getenv("APPDATA") + "\\.NuclearKittens\\res\\",
			"coords.txt"),
		LANDSCAPEPNG(
			System.getenv("APPDATA") + "\\.NuclearKittens\\res\\",
			"landscape.png"),
		TEXTURESPNG(
			System.getenv("APPDATA") + "\\.NuclearKittens\\res\\",
			"textures.png"),
		TEST(
			System.getenv("APPDATA") + "\\.NuclearKittens\\res\\",
			"TEST.txt");

	String path;
	String name;

	private filesEnum(String path, String name) {
		this.path = path;
		this.name = name;
	}
	}

	public void download(String file, String path) {
		try {
			URL url = new URL("https://dl.dropbox.com/u/49046656/NK/" + file);
			URLConnection con = url.openConnection();
			DataInputStream dis = new DataInputStream(con.getInputStream());
			byte[] fileData = new byte[con.getContentLength()];
			for (int x = 0; x < fileData.length; x++) {
				fileData[x] = dis.readByte();
			}
			dis.close();
			FileOutputStream fos = new FileOutputStream(path + file);
			fos.write(fileData);
			fos.close();
		} catch (IOException io) {
		}
	}

	public void check() {
		boolean exists = true;
		for (filesEnum f : filesEnum.values()) {
			File file = new File(f.path + f.name);
			if (!file.exists() || update) {
				exists = false;
				break;
			}
		}
		if (!exists) {
			gc.enterState(1);
			if (update) {
				deleteFolder();
			}
			createFiles();
		} else {
			DownloadScreen.percent = 101;
			gc.enterState(2);
		}
	}

	private void deleteFolder() {
		File folder = new File(System.getenv("APPDATA") + "\\.NuclearKittens\\res");
		if (update) {
			File[] files = folder.listFiles();
			if (files != null) {
				for (File f : files) {
					f.delete();
				}
			}
		}
		createFiles();
	}

	private void createFiles() {
		for (filesEnum file : filesEnum.values()) {
			if (!new File(file.path, file.name).exists()) {
				DownloadScreen.percent = (int) (100 / filesEnum.values().length * file.ordinal()) + 100 / filesEnum.values().length;
				DownloadScreen.file = file.name();
				download(file.name, file.path);
			}
		}

		DownloadScreen.percent = 100;
		DownloadScreen.file = "Complete";
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		DownloadScreen.percent = 101;
	}
}
