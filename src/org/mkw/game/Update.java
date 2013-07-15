package org.mkw.game;

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
			Info.path + "/res/",
			"button.png",
			""),
		TEST(
			Info.path + "/res/",
			"TEST.txt",
			""),
		TERRAINPNG(
			Info.path + "/res/",
			"terrain.png",
			""),
		PLAYER(
			Info.path + "/res/",
			"player.gif",
			"skins/");

	String path;
	String name;
	String subDir;

	private filesEnum(String path, String name, String subDir) {
		this.path = path;
		this.name = name;
		this.subDir = subDir;
	}
	}

	public void download(String file, String subDir, String path) {
		try {
			URL url = new URL("https://dl.dropboxusercontent.com/u/49046656/MKW/" + subDir + file);
			URLConnection con = url.openConnection();
			DataInputStream dis = new DataInputStream(con.getInputStream());
			byte[] fileData = new byte[con.getContentLength()];
			for (int x = 0; x < fileData.length; x++) {
				fileData[x] = dis.readByte();
			}
			dis.close();
			File folder = new File(path + file).getParentFile();
			if (!folder.exists()) {
				System.out.println(folder.getPath());
				folder.mkdir();
			}
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
		File folder = new File(Info.path + "/res/");
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
		new File(Info.path + "/plugins/").mkdir();
		for (filesEnum file : filesEnum.values()) {
			if (!new File(file.path, file.name).exists()) {
				DownloadScreen.percent = (int) (100 / filesEnum.values().length * file.ordinal()) + 100 / filesEnum.values().length;
				DownloadScreen.file = file.name();
				download(file.name, file.subDir, file.path);
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
