package com.beben.simplesnake;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.beben.simplesnake.Screens.GameOverScreen;
import com.beben.simplesnake.Screens.MenuScreen;
import com.beben.simplesnake.Screens.PlayScreen;

public class SnakeGame extends Game {

	public SpriteBatch batch;
	public static final int V_WIDTH = 240;
	public static final int V_HEIGHT = 400;
	public static final int BORDER = 6;
	public static final int ARENA_WIDTH = 228;
	public GameConfig config;
	public Assets assets;
	boolean toggle;

	@Override
	public void create () {
		assets = new Assets();
		config = new GameConfig();
		assets.setStyle(config.theme.value);
		batch = new SpriteBatch();
		setScreen(new MenuScreen(this));

	}

	public void enableAndroidBackKey() {
		Gdx.input.setCatchBackKey(true);
	}

	public void disableAndroidBackKey() {
		Gdx.input.setCatchBackKey(false);
	}


	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
		assets.dispose();
	}
}
