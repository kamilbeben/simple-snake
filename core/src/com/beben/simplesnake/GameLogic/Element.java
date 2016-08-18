package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.beben.simplesnake.SnakeGame;
import com.beben.simplesnake.TextureHolder;

/**
 * Created by bezik on 05.08.16.
 */
public class Element extends Sprite {
    private Texture bodyTexture;
    private Texture endTexture;

    public Element(TextureHolder textureHolder) {
        super(textureHolder.snake_HEAD);
        bodyTexture = textureHolder.snake_BODY;
        endTexture = textureHolder.snake_END;
        hide();
    }

    private void hide() {
        setPosition(SnakeGame.V_WIDTH + 10, SnakeGame.V_HEIGHT + 10);
    }

    public void setPositionAndRotation(Position position) {
        setPosition(position.x, position.y);
        setRotation(position.rotation);
    }

    public void move(float x, float y) {
        setPosition(getX() + x, getY() + y);
    }

    public void isLast(boolean isLast) {
        if (isLast) {
            setTexture(endTexture);
        } else setTexture(bodyTexture);
    }

    public boolean isCollidingWith (Position position) {
        if (getX() == position.x && getY() == position.y) return true;
        else return false;
    }

    public Position getPosition() {
        return new Position(getX(), getY());
    }
}
