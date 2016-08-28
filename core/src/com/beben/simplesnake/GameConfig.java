package com.beben.simplesnake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.beben.simplesnake.Options.Difficulty;
import com.beben.simplesnake.Options.GameTheme;
import com.beben.simplesnake.Options.OptionsMap;

/**
 * Created by bezik on 09.08.16.
 */
public class GameConfig {

    private Preferences preferences;
    private static final String PREFERENCES_vibrations = "vibrations";
    private static final String PREFERENCES_difficulty = "difficulty";
    private static final String PREFERENCES_theme = "value";
    private static final String PREFERENCES_map = "map";

    public boolean vibrations;
    public GameTheme theme;
    public OptionsMap map;
    public Difficulty difficulty;

    public GameConfig() {
        preferences = Gdx.app.getPreferences("config");
        initializeValues();
        loadPreferences();
    }

    private void initializeValues() {
        theme = new GameTheme();
        map = new OptionsMap();
        difficulty = new Difficulty();
    }

    public void loadPreferences() {
        theme.update(preferences.getString(PREFERENCES_theme, "default/"));
        map.update(preferences.getString(PREFERENCES_map, "classic_walls"));
        difficulty.update(preferences.getString(PREFERENCES_difficulty, "medium"));
        vibrations = preferences.getBoolean(PREFERENCES_vibrations, true);
    }

    public void savePreferences() {
        preferences.putString(PREFERENCES_theme, theme.value);
        preferences.putString(PREFERENCES_map, map.getMapNameString());
        preferences.putString(PREFERENCES_difficulty, difficulty.getDifficultyString());
        preferences.putBoolean(PREFERENCES_vibrations, vibrations);
        preferences.flush();
    }

    public void switchVibrations() {
        if (vibrations) vibrations = false;
        else vibrations = true;
    }
}
