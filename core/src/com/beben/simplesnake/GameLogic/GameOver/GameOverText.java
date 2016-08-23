package com.beben.simplesnake.GameLogic.GameOver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.beben.simplesnake.GameConfig;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 16.08.16.
 */
public class GameOverText {


    private BitmapFont font;
    private String yourPoints;
    private String bestScoreString;
    private SnakeGame game;

    private String highScore_KEY;
    private Preferences highScore;

    public GameOverText(BitmapFont bitmapFont, int playerScore, String highScore_KEY) {
        font = bitmapFont;
        this.highScore_KEY = highScore_KEY;
        yourPoints = "Your score: " + Integer.toString(playerScore);
        bestScoreString = "Best score: " + loadBestScore();
        compareWithBestScoreFromEachMap(playerScore);
    }

    private int loadBestScore() {
        highScore = Gdx.app.getPreferences("highscore");
        return highScore.getInteger(highScore_KEY, 0);
    }

    private void compareWithBestScoreFromEachMap(int playerScore) {
        if (playerScore > loadBestScore()) {
            highScore = Gdx.app.getPreferences("highscore");

            highScore.putInteger(highScore_KEY, playerScore);
            highScore.flush();
        }
    }

    public void render(Batch batch) {
        String newGame = "New game";
        String mainMenu = "Main menu";
        String gameOver = "Game over!";
        int spacing = 4;

        font.draw(batch, newGame, center(newGame),
                SnakeGame.V_HEIGHT - 100);

        font.draw(batch, mainMenu, center(mainMenu),
                100 - getTextHeight(mainMenu) );

        font.draw(batch, gameOver, center(gameOver),
                SnakeGame.V_HEIGHT/2 + getTextHeight(yourPoints) + spacing);

        font.draw(batch, yourPoints, center(yourPoints),
                SnakeGame.V_HEIGHT/2);

        font.draw(batch, bestScoreString, center(bestScoreString),
                SnakeGame.V_HEIGHT/2 - getTextHeight(bestScoreString) - spacing);
    }

    private int center(String string) {
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, string);
        return SnakeGame.V_WIDTH/2 - (int) glyphLayout.width/2;
    }

    private float getTextHeight(String string) {
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, string);
        return glyphLayout.height;
    }

    public void dispose() {
        font.dispose();
    }

}
