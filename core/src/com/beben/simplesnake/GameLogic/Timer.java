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
    public boolean nitroBoolean = false;
    public boolean isHardModeEnabled;

    public Timer(boolean isHardModeEnabled) {
        time = 0;
        lastMove = 0;
        lastDirectionChange = 0;
        nitro = 0;
        this.isHardModeEnabled = isHardModeEnabled;
    }

    public void update(int points) {
        time += Gdx.graphics.getDeltaTime();
        updatePlayerSpeed(points);
    }
    
    private void updatePlayerSpeed(int points) {
        if (!nitroBoolean) {
            if (isHardModeEnabled) {
                updateSpeedHardMode(points);
            } else {
                updateSpeedEasyMode(points);
            }
        } else handleNitro(points);
    }

    private void updateSpeedEasyMode(int points) {
        if (points < 50) moveInterval = 0.135f;
        else if (points < 100) moveInterval = 0.115f;
        else if (points < 150) moveInterval = 0.1f;
        else if (points < 250) moveInterval = 0.09f;
        else if (points < 350) moveInterval = 0.08f;
        else if (points < 450) moveInterval = 0.07f;
        else if (points < 550) moveInterval = 0.065f;
        else if (points < 650) moveInterval = 0.06f;
        else if (points < 750) moveInterval = 0.055f;
    }


    private void updateSpeedHardMode(int points) {
        if (points < 50) moveInterval = 0.12f;
        else if (points < 150) moveInterval = 0.11f;
        else if (points < 250) moveInterval = 0.10f;
        else if (points < 350) moveInterval = 0.09f;
        else if (points < 450) moveInterval = 0.08f;
        else if (points < 550) moveInterval = 0.07f;
        else if (points < 650) moveInterval = 0.060f;
        else if (points < 750) moveInterval = 0.055f;
        else if (points < 850) moveInterval = 0.050f;
    }

    private void handleNitro(int points) {
        if (points < 450) {
            nitro += Gdx.graphics.getDeltaTime();
            moveInterval = frozenMoveInterwal - 0.03f;
            if (nitro > 0.6f) {
                nitroBoolean = false;
            }
        }
    }

    public void startNitro() {
        nitro = 0;
        nitroBoolean = true;
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
