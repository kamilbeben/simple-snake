package com.beben.simplesnake.About;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.beben.simplesnake.SnakeGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bezik on 22.08.16.
 */
public class AboutText {

    private List<String> text;

    private static final int paddingLeft = 8;
    private static final int spacingBetweenLines = 3;
    private BitmapFont font;

    public AboutText(BitmapFont bitmapFont) {
        font = bitmapFont;
        text = new ArrayList<String>();
        addText();
    }

    private void addText() {
        text.add("Simple Snake");
        text.add("My goal was to create");
        text.add("a simple snake based");
        text.add("game with no annoying");
        text.add("or fancy controls, and");
        text.add("simple graphics.");
        text.add("Enjoy.");
        text.add("");
        text.add("Created by Kamil Beben ");
        text.add("in 2016. ");
        text.add("'Used 8 Bit Wonder' font");
        text.add("created by Joiro Hatgaya.");
        text.add("");
        text.add("visit my website");
        text.add("kamilbeben(dot)pl");
    }

    public void render(Batch batch) {
        for (int i = 0; i<text.size(); i++) {
            font.draw(batch, text.get(i), paddingLeft, positionYOfNo(i));
        }
    }

    private float positionYOfNo(int no) {
        return SnakeGame.V_HEIGHT - positionOfFirstToCenter()
                - ( no * ( fontHeight() + spacingBetweenLines) );
    }

    private float positionOfFirstToCenter() {
        return ( SnakeGame.V_HEIGHT / 2 ) - ( (text.size() + 1 ) * (spacingBetweenLines + fontHeight() / 2) );
    }

    private float fontHeight() {
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, "Sample");
        return glyphLayout.height + 1;
    }

}
