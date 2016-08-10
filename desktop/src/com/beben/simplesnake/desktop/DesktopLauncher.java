package com.beben.simplesnake.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.beben.simplesnake.SnakeGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 455;
		config.height = 700;
		config.resizable = true;
		new LwjglApplication(new SnakeGame(), config);
	}
}
