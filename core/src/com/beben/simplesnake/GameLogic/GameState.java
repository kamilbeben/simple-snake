package com.beben.simplesnake.GameLogic;

/**
 * Created by bezik on 11.08.16.
 */
public class GameState {

    public enum STATE {
        OVER, PAUSED, CONTINUES
    }

    private STATE state;

    public GameState() {
        state = STATE.CONTINUES;
    }

    public void setOver(){
        state = STATE.OVER;
    }

    public void setPause(){
        state = STATE.PAUSED;
    }

    public void setContinue(){
        state = STATE.CONTINUES;
    }

    public boolean isOver() {
        if (state == STATE.OVER) return true;
        else return false;
    }

    public boolean isContinue() {
        if (state == STATE.CONTINUES) return true;
        else return false;
    }

    public boolean isPause() {
        if (state == STATE.PAUSED) return true;
        else return false;
    }

    public void switchPause() {
        if (state == STATE.PAUSED) {
            state = STATE.CONTINUES;
        }
        else if (state == STATE.CONTINUES){
            state = STATE.PAUSED;
        }
    }
}
