package com.beben.simplesnake.Options;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 13.08.16.
 */
public class OptionsText {

    private static final String maps_DESCRIPTION = "Map";
    private static final String style_DESCRIPTION = "Style";
    private static final String vibration_DESCRIPTION = "Vibrations";
    private static final String difficulty_DESCRIPTION = "Difficulty";


    private BitmapFont font;
    private float mapPositionY;
    private float stylePositionY;
    private float vibrationsPositionY;
    private float difficultyPositionY;

    public OptionsText(BitmapFont bitmapFont, float mapPositionY, float stylePositionY, float vibrationsPositionY, float difficultyPositionY) {
        font = bitmapFont;
        float padding = 4;
        this.mapPositionY = mapPositionY - padding;
        this.stylePositionY = stylePositionY - padding;
        this.vibrationsPositionY = vibrationsPositionY - padding;
        this.difficultyPositionY = difficultyPositionY - padding;
    }

    public void render(Batch batch) {
        font.draw(batch, maps_DESCRIPTION, centerPositionX(maps_DESCRIPTION), mapPositionY);
        font.draw(batch, style_DESCRIPTION, centerPositionX(style_DESCRIPTION), stylePositionY);
        font.draw(batch, vibration_DESCRIPTION, centerPositionX(vibration_DESCRIPTION), vibrationsPositionY);
        font.draw(batch, difficulty_DESCRIPTION, centerPositionX(difficulty_DESCRIPTION), difficultyPositionY);
    }

    private int centerPositionX(String string) {
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, string);
        return SnakeGame.V_WIDTH/2 - ((int) glyphLayout.width )/2;
    }

}
