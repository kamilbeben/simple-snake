package com.beben.simplesnake;

/**
 * Created by bezik on 09.08.16.
 */
public class GameConfig {

    private static final String style_DEFAULT   = "default/";
    private static final String style_MODERN    = "modern/";
    //TODO create some map enum, class or whatever

    public boolean walls;
    public boolean vibrations;
    public String style;


    public GameConfig() {
        walls = false;
        vibrations = false;
        style = style_DEFAULT; //default and modern
    }

    public void switchVibrations() {
        if (vibrations) vibrations = false;
        else vibrations = true;
    }

    public void switchStyles() {
        if (style.equals(style_DEFAULT)) {
            style = style_MODERN;
        } else if (style.equals(style_MODERN)) {
            style = style_DEFAULT;
        }
    }

    public boolean isDefault() {
        if (style.equals(style_DEFAULT)) {
            return true;
        } else return false;
    }

}
