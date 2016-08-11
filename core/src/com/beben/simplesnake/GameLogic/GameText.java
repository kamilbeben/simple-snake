package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 05.08.16.
 */
public class GameText {


    private BitmapFont font;
    private CharSequence timer;
    private CharSequence points;
    private float timeHelper;
    private boolean gameOver;
    private boolean pause;

    public GameText(BitmapFont bitmapFont) {
        font = bitmapFont;
        gameOver = false;
        pause = false;
        timeHelper = 0;
        this.timer = new String("00");
        this.points = new String("0");
    }

    public void update(int points, GameState state) {
        if (state.isContinue()) {
            timeHelper += Gdx.graphics.getDeltaTime();
            this.timer = new String(Integer.toString((int) timeHelper));
            this.points = new String(Integer.toString(points));
            pause = false;
        } else if (state.isOver()) {
            gameOver = true;
        } else if (state.isPause()) {
            pause = true;
        }
    }

    public void render(Batch batch) {
        font.draw(batch, points, 10, 156);
        font.draw(batch, timer, calculatePositionX(timer.toString()), 156);
        if (gameOver) {
            font.draw(batch, "Game over!", center("Game over!"),
                    SnakeGame.V_HEIGHT - 106);
            font.draw(batch, "Try again", center("Try again"),
                    SnakeGame.V_HEIGHT - 121);
        }
        if (pause) {
            font.draw(batch, "Pause", center("Pause"),
                SnakeGame.V_HEIGHT - 106);
        }
    }

    private int calculatePositionX(String string) {
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, string);
        return SnakeGame.V_WIDTH - ((int) glyphLayout.width + 8);
    }

    private int center(String string) {
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, string);
        return SnakeGame.V_WIDTH/2 - (int) glyphLayout.width/2;
    }

}
