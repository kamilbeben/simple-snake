package com.beben.simplesnake.Options;

/**
 * Created by bezik on 28.08.16.
 */
public class Difficulty {

    enum VALUE {
        easy, medium, hard
    }

    private VALUE value;

    public Difficulty() {
        value = VALUE.medium;
    }

    public boolean isEasy() {
        if (value == VALUE.easy) {
            return true;
        } else return false;
    }

    public boolean isMedium() {
        if (value == VALUE.medium) {
            return true;
        } else return false;
    }

    public boolean isHard() {
        if (value == VALUE.hard) {
            return true;
        } else return false;
    }

    public void switchDifficulty() {
        if (value == VALUE.hard) {
            value = VALUE.easy;
        } else if (value == VALUE.easy) {
            value = VALUE.medium;
        } else if (value == VALUE.medium) {
            value = VALUE.hard;
        }
    }

    public void update(String preference) {
        if (preference.equals("easy")) {
            value = VALUE.easy;
        } else if (preference.equals("medium")) {
            value = VALUE.medium;
        } else if (preference.equals("hard")) {
            value = VALUE.hard;
        }
    }

    public String getDifficultyString() {
        if (value == VALUE.easy) {
            return "easy";
        } else if (value == VALUE.medium) {
            return "medium";
        } else if (value == VALUE.hard) {
            return "hard";
        } else return "medium";
    }
}
