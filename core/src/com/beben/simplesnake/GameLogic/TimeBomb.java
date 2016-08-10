package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 05.08.16.
 */
public class TimeBomb extends Sprite {

    public Position position;

    public TimeBomb() {
        super(new Texture("default/" + "timebomb.png"));
        position = new Position();
        randomizePosition();
    }

    public void randomizePosition() {
        position.x = SnakeGame.BORDER + MathUtils.random(18) * getTexture().getHeight();
        position.y = SnakeGame.V_HEIGHT - SnakeGame.BORDER - getTexture().getHeight() -
                MathUtils.random(18) * getTexture().getHeight();
        setPosition(position.x, position.y);
    }

    public float lifeTime() { // IN SECONDS
        return 5;
    }
}
