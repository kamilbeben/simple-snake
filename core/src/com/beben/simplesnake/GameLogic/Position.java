package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by bezik on 05.08.16.
 */
public class Position {

    public float x;
    public float y;
    public float rotation;

    public Position () {

    }

    public Position (float x, float y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Position position) {
        if (this.x == position.x && this.y == position.y) {
            return true;
        } else {
            return false;
        }
    }
}
