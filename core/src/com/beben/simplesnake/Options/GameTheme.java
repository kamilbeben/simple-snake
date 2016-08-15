package com.beben.simplesnake.Options;

/**
 * Created by bezik on 13.08.16.
 */
public class GameTheme {

    private static final String style_DEFAULT = "default/";
    private static final String style_MODERN = "modern/";
    public String value;

    public GameTheme() {
        value = style_DEFAULT;
    }

    public void update(String theme) {
        if (theme.equals(style_DEFAULT) || theme.equals(style_MODERN)) {
            this.value = theme;
        }
    }

    public void switchStyles() {
        if (value.equals(style_DEFAULT)) {
            value = style_MODERN;
        } else if (value.equals(style_MODERN)) {
            value = style_DEFAULT;
        }
    }

    public boolean isDefault() {
        if (value.equals(style_DEFAULT)) {
            return true;
        } else return false;
    }

    public boolean isModern() {
        if (value.equals(style_MODERN)) {
            return true;
        } else return false;
    }
}
