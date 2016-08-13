package com.beben.simplesnake;

import com.beben.simplesnake.Options.GameTheme;
import com.beben.simplesnake.Options.OptionsMap;

/**
 * Created by bezik on 09.08.16.
 */
public class GameConfig {

    //TODO create some map enum, class or whatever

    public boolean vibrations;
    public GameTheme theme;
    public OptionsMap map;


    public GameConfig() {
        theme = new GameTheme();
        map = new OptionsMap();
        vibrations = false;
    }

    public void switchVibrations() {
        if (vibrations) vibrations = false;
        else vibrations = true;
    }
}
