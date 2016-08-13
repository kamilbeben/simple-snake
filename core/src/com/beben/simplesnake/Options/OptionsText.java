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


    private BitmapFont font;
    private float mapPositionY;
    private float stylePositionY;
    private float vibrationsPositionY;

    public OptionsText(BitmapFont bitmapFont, float mapPositionY, float stylePositionY, float vibrationsPositionY) {
        font = bitmapFont;
        float padding = 3;
        this.mapPositionY = mapPositionY - padding;
        this.stylePositionY = stylePositionY - padding;
        this.vibrationsPositionY = vibrationsPositionY - padding;
    }

    public void render(Batch batch) {
        font.draw(batch, maps_DESCRIPTION, calculatePositionX(maps_DESCRIPTION), mapPositionY);
        font.draw(batch, style_DESCRIPTION, calculatePositionX(style_DESCRIPTION), stylePositionY);
        font.draw(batch, vibration_DESCRIPTION, calculatePositionX(vibration_DESCRIPTION), vibrationsPositionY);
    }

    private int calculatePositionX(String string) {
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, string);
        return SnakeGame.V_WIDTH/2 - ((int) glyphLayout.width )/2;
    }

}
