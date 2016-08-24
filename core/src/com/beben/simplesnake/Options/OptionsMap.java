package com.beben.simplesnake.Options;

/**
 * Created by bezik on 13.08.16.
 */
public class OptionsMap {

    private enum TYPE {
        classic_walls, classic_nowalls, middlesquare_walls, middlesquare_nowalls, equation, cage, heart, cave
    }

    private TYPE value;

    public OptionsMap() {
        value = TYPE.classic_nowalls;
    }

    public boolean isClassicNOWALLS() {
        if (value == TYPE.classic_nowalls) return true;
        else return false;
    }

    public boolean isClassicWALLS() {
        if (value == TYPE.classic_walls) return true;
        else return false;
    }

    public boolean isMiddleSquareWALLS() {
        if (value == TYPE.middlesquare_walls) return true;
        else return false;
    }

    public boolean isMiddleSquareNOWALLS() {
        if (value == TYPE.middlesquare_nowalls) return true;
        else return false;
    }

    public boolean isEquation() {
        if (value == TYPE.equation) return true;
        else return false;
    }

    public boolean isCage() {
        if (value == TYPE.cage) return true;
        else return false;
    }

    public boolean isHeart() {
        if (value == TYPE.heart) return true;
        else return false;
    }

    public boolean isCave() {
        if (value == TYPE.cave) return true;
        else return false;
    }

    public void switchRight() {
        if (value == TYPE.classic_walls) {
            value = TYPE.classic_nowalls;
        } else if (value == TYPE.classic_nowalls) {
            value = TYPE.middlesquare_walls;
        } else if (value == TYPE.middlesquare_walls) {
            value = TYPE.middlesquare_nowalls;
        } else if (value == TYPE.middlesquare_nowalls) {
            value = TYPE.equation;
        } else if (value == TYPE.equation) {
            value = TYPE.cage;
        } else if (value == TYPE.cage) {
            value = TYPE.heart;
        } else if (value == TYPE.heart) {
            value = TYPE.cave;
        } else if (value == TYPE.cave) {
            value = TYPE.classic_walls;
        }
    }

    public void switchLeft() {
        if (value == TYPE.cave) {
            value = TYPE.heart;
        } else if (value == TYPE.heart) {
            value = TYPE.cage;
        } else if (value == TYPE.cage) {
            value = TYPE.equation;
        } else if (value == TYPE.equation) {
            value = TYPE.middlesquare_nowalls;
        } else if (value == TYPE.middlesquare_nowalls) {
            value = TYPE.middlesquare_walls;
        } else if (value == TYPE.middlesquare_walls) {
            value = TYPE.classic_nowalls;
        } else if (value == TYPE.classic_nowalls) {
            value = TYPE.classic_walls;
        } else if (value == TYPE.classic_walls) {
            value = TYPE.cave;
        }
    }

    public void update(String map) {
        if (map.equals("classic_walls")) {
            value = TYPE.classic_walls;
        } else if (map.equals("classic_nowalls")) {
            value = TYPE.classic_nowalls;
        } else if (map.equals("middlesquare_walls")) {
            value = TYPE.middlesquare_walls;
        } else if (map.equals("middlesquare_nowalls")) {
            value = TYPE.middlesquare_nowalls;
        } else if (map.equals("equation")) {
            value = TYPE.equation;
        } else if (map.equals("cage")) {
            value = TYPE.cage;
        } else if (map.equals("heart")) {
            value = TYPE.heart;
        } else if (map.equals("cave")) {
            value = TYPE.cave;
        }
    }

    public String getMapNameString() {
        if (value == TYPE.classic_walls) {
            return "classic_walls";
        } else if (value == TYPE.classic_nowalls) {
            return "classic_nowalls";
        }  else if (value == TYPE.middlesquare_walls) {
            return "middlesquare_walls";
        }  else if (value == TYPE.middlesquare_nowalls) {
            return "middlesquare_nowalls";
        }  else if (value == TYPE.equation) {
            return "equation";
        }  else if (value == TYPE.cage) {
            return "cage";
        }  else if (value == TYPE.heart) {
            return "heart";
        }  else if (value == TYPE.cave) {
            return "cave";
        } else {
            return "classic_walls";
        }
    }

}
