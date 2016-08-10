package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.Gdx;

/**
 * Created by bezik on 10.08.16.
 */
public class Timer {

    public float time;
    public float lastMove;
    public float moveInterval;
    public float frozenMoveInterwal;
    public float lastDirectionChange;
    public float nitro;
    public boolean nitroBool = false;

    public Timer() {
        time = 0;
        lastMove = 0;
        moveInterval = 0.1f;
        lastDirectionChange = 0;
        nitro = 0;
    }

    public void update() {
        time += Gdx.graphics.getDeltaTime();
    }
    
    public void increaseSpeedIfTimeIsRight(int points) {
        if (!nitroBool) {
            if (points < 50) moveInterval = 0.1f;
            else if (points < 150) moveInterval = 0.090f;
            else if (points < 250) moveInterval = 0.080f;
            else if (points < 350) moveInterval = 0.075f;
            else if (points < 450) moveInterval = 0.070f;
            else if (points < 550) moveInterval = 0.065f;
            else if (points < 650) moveInterval = 0.060f;
            else if (points < 750) moveInterval = 0.055f;
            else if (points < 850) moveInterval = 0.050f;
        } else handleNitro(points);
    }

    private void handleNitro(int points) {
        if (points < 450) {
            nitro += Gdx.graphics.getDeltaTime();
            moveInterval = frozenMoveInterwal - 0.03f;
            if (nitro > 0.6f) {
                nitroBool = false;
            }
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

    public boolean isItTimeToChangeDirection() {
        if (time - lastDirectionChange > moveInterval + 0.05f) {
            lastDirectionChange = time;
            return true;
        } else return false;
    }
}
