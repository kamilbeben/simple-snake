package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 10.08.16.
 */
public class Apple extends Sprite{

    public Position position;
    public float lifeTime;

    public Apple() {
        super(new Texture("default/" + "apple.png"));
        position = new Position();
        randomizePosition();
        lifeTime = 0;
    }

    public void randomizePosition() {
        lifeTime = 0;
        position.x = SnakeGame.BORDER + MathUtils.random(18) * getTexture().getHeight();
        position.y = SnakeGame.V_HEIGHT - SnakeGame.BORDER - getTexture().getHeight() -
                MathUtils.random(18) * getTexture().getHeight();
        setPosition(position.x, position.y);
    }

    public float liveLenght() {
        return 5;
    }

    public void update() {
        lifeTime += Gdx.graphics.getDeltaTime();
        if (lifeTime > liveLenght()) {
            randomizePosition();
            lifeTime = 0;
        }
        setTransparency();
    }

    private void setTransparency() {
        if (lifeTime < liveLenght() / 2) setAlpha(1);
        else if (lifeTime < liveLenght() / 1.5) setAlpha(0.5f);
    }
}
