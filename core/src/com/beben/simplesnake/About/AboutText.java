package com.beben.simplesnake.About;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 22.08.16.
 */
public class AboutText {

    private static final String fontCreator = "Joakin";
    private static final String fontName = "Pixel Square";

    private static final int padding = 12;
    private static final boolean textWrapping = true;

    private BitmapFont font;
    private String text;

    public AboutText(BitmapFont bitmapFont) {
        font = bitmapFont;
        addText();
    }

    private void addText() {
        text = "Simple Snake\n\n" +
                "My goal was to create a simple snake-based game without any annoying swipe controls, without " +
                "pretending to be an old nokia phone, but with simple graphics and good gameplay. \n" +
                "I think that i have achieved all this, so enjoy!\n\n" +
                "Created by Kamil Beben in 2016\n" +
                "using libGDX library.\n" +
                "Used font \"" + fontName + "\"" + " created by " + fontCreator + ".\n\n" +
                "Check out my website!\n" +
                "www.kamilbeben.pl";
    }

    public void render(Batch batch) {
        font.draw(batch, text, padding, centerVertical(),
                SnakeGame.V_WIDTH - padding, Align.left, textWrapping);
    }

    private float centerVertical() {
        GlyphLayout glyphLayout = new GlyphLayout(font, text, Color.BLACK, SnakeGame.V_WIDTH - padding,
                Align.left, true);
        return (SnakeGame.V_HEIGHT/2) + (glyphLayout.height/2);
    }

    public void dispose() {
        font.dispose();
    }
}
