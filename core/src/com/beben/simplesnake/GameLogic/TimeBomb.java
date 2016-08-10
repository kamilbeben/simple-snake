package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 05.08.16.
 */
public class TimeBomb extends Sprite {

    public Position position;
    private boolean alive;
    public float lifeTime;

    public TimeBomb() {
        super(new Texture("default/" + "timebomb.png"));
        position = new Position();
        randomizePosition();
        alive = false;
        lifeTime = 0;
    }

    public void randomizePosition() {
        alive = true;
        position.x = SnakeGame.BORDER + MathUtils.random(18) * getTexture().getHeight();
        position.y = SnakeGame.V_HEIGHT - SnakeGame.BORDER - getTexture().getHeight() -
                MathUtils.random(18) * getTexture().getHeight();
        setPosition(position.x, position.y);
    }

    public float liveLenght() {
        return 5;
    }

    public float interval() { // IN SECONDS
        return 30;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isDead() {
        return !alive;
    }

    public void dissapear() {
        alive = false;
        lifeTime = 0;
    }

    public void drawIfAlive (Batch batch) {
        if (alive) draw(batch);
    }

    public void lifeTimer(boolean gameIsNotOverYet) {
        if (gameIsNotOverYet) {
            lifeTime += Gdx.graphics.getDeltaTime();
            if ((isDead() && lifeTime > interval())) {
                randomizePosition();
                lifeTime = 0;
            } else if (isAlive() && lifeTime > liveLenght()) {
                dissapear();
            }

        }
        setTransparency();
    }

    private void setTransparency() {
        if (lifeTime < liveLenght() / 2) setAlpha(1);
        else if (lifeTime < liveLenght() / 1.5) setAlpha(0.5f);
    }
}
