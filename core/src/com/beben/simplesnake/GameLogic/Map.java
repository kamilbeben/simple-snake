package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;
import com.beben.simplesnake.SnakeGame;

import java.util.List;

/**
 * Created by bezik on 18.08.16.
 */
public class Map {

    private SnakeGame game;
    private static Texture brick_texture;
    private Brick[] bricks;

    public Map(SnakeGame game) {
        this.game = game;
        brick_texture = game.assets.textureHolder.game_BRICK;
        checkConfigAndGenerateMap();
    }

    private void checkConfigAndGenerateMap() {
        if (game.config.map.isClassicWALLS() || game.config.map.isClassicNOWALLS()) {
            initializeClassic();
        } else if (game.config.map.isMiddleSquareWALLS() || game.config.map.isMiddleSquareNOWALLS()) {
            initializeMiddleSquare();
        }
    }

    private void initializeClassic() {

    }

    private void initializeMiddleSquare() {
        bricks = new Brick[1];
        bricks[0] = new Brick(brick_texture, new Position(66, SnakeGame.V_HEIGHT - 66));
    }

    public void draw(Batch batch) {
        try {
            for (Brick tmp : bricks) {
                tmp.draw(batch);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private boolean checkForCollision(Position object) {
        try {
            for (int i=0; i<bricks.length; i++) {
                if (bricks[i].getPosition().equals(object)) {
                    System.out.println("Collision with map");
                    return true;
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

}
