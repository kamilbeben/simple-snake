package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 04.08.16.
 */
public class GameTheme {

    public Sprite gameBackground;
    public Sprite playArea;

    public GameTheme() {
        playArea = new Sprite(new Texture("default/" + "game_area.png"));
        playArea.setPosition(SnakeGame.BORDER, SnakeGame.V_HEIGHT - playArea.getHeight() - SnakeGame.BORDER);
        gameBackground = new Sprite(new Texture("default/" + "game_background.png"));
    }

    public void draw(Batch batch){
        gameBackground.draw(batch);
        playArea.draw(batch);
    }

    public void default_skin() {

    }

    public void retro_skin() {

    }
}
