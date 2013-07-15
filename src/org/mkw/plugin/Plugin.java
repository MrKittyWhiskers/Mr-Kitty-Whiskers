package org.mkw.plugin;

public abstract class Plugin {
	
	public abstract void onEnable();
	
	void enable() {
		onEnable();
	}
	
	public void update(){}

}
