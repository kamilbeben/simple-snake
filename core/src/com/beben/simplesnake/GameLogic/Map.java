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
        bricks = new Brick[27];
        bricks[0] = new Brick(brick_texture, new Position(66, 238));
        bricks[1] = new Brick(brick_texture, new Position(66, 250));
        bricks[2] = new Brick(brick_texture, new Position(66, 262));
        bricks[3] = new Brick(brick_texture, new Position(66, 274));
        bricks[4] = new Brick(brick_texture, new Position(66, 286));
        bricks[5] = new Brick(brick_texture, new Position(66, 298));
        bricks[6] = new Brick(brick_texture, new Position(66, 310));
        bricks[7] = new Brick(brick_texture, new Position(66, 322));
        bricks[8] = new Brick(brick_texture, new Position(78, 238));
        bricks[9] = new Brick(brick_texture, new Position(78, 322));
        bricks[10] = new Brick(brick_texture, new Position(90, 238));
        bricks[11] = new Brick(brick_texture, new Position(90, 322));
        bricks[12] = new Brick(brick_texture, new Position(102, 238));
        bricks[13] = new Brick(brick_texture, new Position(114, 238));
        bricks[14] = new Brick(brick_texture, new Position(126, 238));
        bricks[15] = new Brick(brick_texture, new Position(138, 238));
        bricks[16] = new Brick(brick_texture, new Position(138, 322));
        bricks[17] = new Brick(brick_texture, new Position(150, 238));
        bricks[18] = new Brick(brick_texture, new Position(150, 322));
        bricks[19] = new Brick(brick_texture, new Position(162, 238));
        bricks[20] = new Brick(brick_texture, new Position(162, 250));
        bricks[21] = new Brick(brick_texture, new Position(162, 262));
        bricks[22] = new Brick(brick_texture, new Position(162, 274));
        bricks[23] = new Brick(brick_texture, new Position(162, 286));
        bricks[24] = new Brick(brick_texture, new Position(162, 298));
        bricks[25] = new Brick(brick_texture, new Position(162, 310));
        bricks[26] = new Brick(brick_texture, new Position(162, 322));
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
                    return true;
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

}
