package com.beben.simplesnake.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.beben.simplesnake.SnakeGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 240;
		config.height = 400;
		config.resizable = true;
		new LwjglApplication(new SnakeGame(), config);
	}
}
