package com.beben.simplesnake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.beben.simplesnake.Options.GameTheme;
import com.beben.simplesnake.Options.OptionsMap;

/**
 * Created by bezik on 09.08.16.
 */
public class GameConfig {

    private Preferences preferences;
    private static final String PREFERENCES_VIBRATIONS = "vibrations";
    private static final String PREFERENCES_theme = "value";
    private static final String PREFERENCES_map = "map";

    public boolean vibrations;
    public GameTheme theme;
    public OptionsMap map;

    public GameConfig() {
        preferences = Gdx.app.getPreferences("config");
        initializeValues();
        loadPreferences();
    }

    private void initializeValues() {
        theme = new GameTheme();
        map = new OptionsMap();
        vibrations = false;
    }

    private void loadPreferences() {
        theme.update(preferences.getString(PREFERENCES_theme, "default/"));
        map.update(preferences.getString(PREFERENCES_map, "classic_nowalls"));
        vibrations = preferences.getBoolean(PREFERENCES_VIBRATIONS, true);
    }

    public void savePreferences() {
        preferences.putString(PREFERENCES_theme, theme.value);
        preferences.putString(PREFERENCES_map, map.getMapNameString());
        preferences.putBoolean(PREFERENCES_VIBRATIONS, vibrations);
        preferences.flush();
    }

    public void switchVibrations() {
        if (vibrations) vibrations = false;
        else vibrations = true;
    }
}
