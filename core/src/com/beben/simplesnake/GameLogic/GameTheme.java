package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.beben.simplesnake.SnakeGame;
import com.beben.simplesnake.TextureHolder;

/**
 * Created by bezik on 04.08.16.
 */
public class GameTheme {

    public Sprite gameBackground;
    public Sprite playArea;

    public GameTheme(TextureHolder textureHolder) {
        playArea = new Sprite(textureHolder.game_AREA);
        playArea.setPosition(SnakeGame.BORDER, SnakeGame.V_HEIGHT - playArea.getHeight() - SnakeGame.BORDER);
        gameBackground = new Sprite(textureHolder.game_BACKGROUND);
    }

    public void draw(Batch batch){
        gameBackground.draw(batch);
        playArea.draw(batch);
    }
}
