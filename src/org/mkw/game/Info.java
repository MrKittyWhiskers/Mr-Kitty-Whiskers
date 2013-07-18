package org.mkw.game;

import java.awt.Color;

public class Info {
	public static final String name = "Mr Kitty Whiskers";
	public static final String ver = "0";
	
	public static final String path = System.getenv("APPDATA") + "/.MKW";
	
	public static final int Splash = 0;
	public static final int DownloadScreen = 1;
	public static final int Menu = 2;
	public static final int Single = 3;
	public static final int Multi = 4;
	public static final int Options = 5;
	public static final int Credits = 6;
	
	public static final Color Void = Color.GREEN;
	
	public static int worldLength = 0;
}
