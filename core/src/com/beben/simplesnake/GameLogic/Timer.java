package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.Gdx;

/**
 * Created by bezik on 10.08.16.
 */
public class Timer {

    public float lastMove;
    public float moveInterval;
    public float frozenMoveInterwal;
    public float lastDirectionChange;
    public float nitro;
    public boolean nitroBool = false;

    public Timer() {
        lastMove = 0;
        moveInterval = 0.1f;
        lastDirectionChange = 0;
        nitro = 0;

    }
    
    public void increaseSpeedIfTimeIsRight(int points) {
        if (!nitroBool) {
            if (points < 50) moveInterval = 0.1f;
            else if (points < 100) moveInterval = 0.090f;
            else if (points < 150) moveInterval = 0.080f;
            else if (points < 200) moveInterval = 0.075f;
            else if (points < 250) moveInterval = 0.070f;
            else if (points < 300) moveInterval = 0.065f;
            else if (points < 350) moveInterval = 0.060f;
            else if (points < 400) moveInterval = 0.055f;
            else if (points < 500) moveInterval = 0.050f;
        } else handleNitro();
    }

    private void handleNitro() {
        nitro += Gdx.graphics.getDeltaTime();
        moveInterval = frozenMoveInterwal - 0.06f;
        if (nitro > 0.6f) {
            nitroBool = false;
        }
    }

    public void startNitro() {
        nitro = 0;
        nitroBool = true;
        frozenMoveInterwal = moveInterval;
    }

    public boolean isItTimeToMove() {
        lastMove += Gdx.graphics.getDeltaTime();
        if (lastMove > moveInterval) {
            lastMove = 0;
            return true;
        } else return false;
    }
}
