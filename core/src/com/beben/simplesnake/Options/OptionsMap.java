package com.beben.simplesnake.Options;

/**
 * Created by bezik on 13.08.16.
 */
public class OptionsMap {

    private enum TYPE {
        classic_walls, classic_nowalls
    }

    private TYPE value;
    private boolean walls;

    public OptionsMap() {
        value = TYPE.classic_nowalls;
        setProperties();
    }

    private void setProperties() {
        if (isClassicNOWALLS()) walls = false;
        else if (isClassicWALLS()) walls = true;
    }

    public boolean areThereWalls() {
        return walls;
    }

    public boolean isClassicNOWALLS() {
        if (value == TYPE.classic_nowalls) return true;
        else return false;
    }

    public boolean isClassicWALLS() {
        if (value == TYPE.classic_walls) return true;
        else return false;
    }

    public void switchRight() {
        if (value == TYPE.classic_walls) {
            value = TYPE.classic_nowalls;
        } else if (value == TYPE.classic_nowalls) {
            value = TYPE.classic_walls;
        }
        setProperties();
    }

    public void switchLeft() {
        if (value == TYPE.classic_nowalls) {
            value = TYPE.classic_walls;
        } else if (value == TYPE.classic_walls) {
            value = TYPE.classic_nowalls;
        }
        setProperties();
    }

    public void update(String map) {
        if (map.equals("classic_walls")) {
            value = TYPE.classic_walls;
        } else if (map.equals("classic_nowalls")) {
            value = TYPE.classic_nowalls;
        }
    }

    public String saveMapToPreferences() {
        if (value == TYPE.classic_walls) {
            return "classic_walls";
        } else if (value == TYPE.classic_nowalls) {
            return "classic_nowalls";
        } else {
            return "classic_walls";
        }
    }

}
