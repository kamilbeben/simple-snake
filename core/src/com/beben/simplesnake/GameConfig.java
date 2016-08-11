package com.beben.simplesnake;

/**
 * Created by bezik on 09.08.16.
 */
public class GameConfig {

    public boolean walls;
    public boolean vibrations;
    public boolean nitro; //TODO nitro optional
    public String style;


    public GameConfig() {
        walls = false;
        vibrations = true;
        nitro = true;
        style = "default/";
    }

    public void switchVibrations() {
        if (vibrations) vibrations = false;
        else vibrations = true;
    }

}
