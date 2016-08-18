package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.beben.simplesnake.SnakeGame;

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
        if (game.config.map.isClassicWALLS()) {
            initializeClassicWalls();
        } else if (game.config.map.isClassicNOWALLS()) {
            initializeClassicNowalls();
        } else if (game.config.map.isMiddleSquareWALLS()) {
            initializeMiddleSquareWalls();
        } else if (game.config.map.isMiddleSquareNOWALLS()) {
            initializeMiddleSquareNoWalls();
        }
    }

    private void initializeClassicWalls() {

    }

    private void initializeClassicNowalls() {

    }

    private void initializeMiddleSquareWalls() {
        bricks = new Brick[1];
        bricks[0] = new Brick(brick_texture, new Position(66, SnakeGame.V_HEIGHT - 66));
    }

    private void initializeMiddleSquareNoWalls() {

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

    public boolean isCollidingWith(Position object) {
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
