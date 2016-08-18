package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.beben.simplesnake.TextureHolder;

/**
 * Created by bezik on 18.08.16.
 */
public class Brick extends Sprite{

    public Brick(Texture texture, Position position) {
        super(texture);
        setPosition(position.x, position.y);
    }

    public Position getPosition() {
        return new Position(getX(), getY());
    }


}
