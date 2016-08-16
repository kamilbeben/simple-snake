package com.beben.simplesnake;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.beben.simplesnake.Screens.GameOverScreen;
import com.beben.simplesnake.Screens.MenuScreen;

public class SnakeGame extends Game {

	public SpriteBatch batch;
	public static final int V_WIDTH = 240;
	public static final int V_HEIGHT = 400;
	public static final int BORDER = 6;
	public static final int ARENA_WIDTH = 228;
	public GameConfig config;
	public Assets assets;

	@Override
	public void create () {
		assets = new Assets();
		config = new GameConfig();
		assets.setStyle(config.theme.value);
		batch = new SpriteBatch();
		setScreen(new GameOverScreen(this, 100));

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
