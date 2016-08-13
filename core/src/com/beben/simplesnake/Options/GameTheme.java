package com.beben.simplesnake.Options;

import com.badlogic.gdx.Game;

/**
 * Created by bezik on 13.08.16.
 */
public class GameTheme {

    private static final String style_DEFAULT = "default/";
    private static final String style_MODERN = "modern/";
    private String theme;

    public GameTheme() {
        theme = style_DEFAULT; //TODO loading from file
    }

    public void switchStyles() {
        if (theme.equals(style_DEFAULT)) {
            theme = style_MODERN;
        } else if (theme.equals(style_MODERN)) {
            theme = style_DEFAULT;
        }
    }

    public boolean isDefault() {
        if (theme.equals(style_DEFAULT)) {
            return true;
        } else return false;
    }

    public boolean isModern() {
        if (theme.equals(style_MODERN)) {
            return true;
        } else return false;
    }

    public String getStyle() {
        return theme;
    }
}
