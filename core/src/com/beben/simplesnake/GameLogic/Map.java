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
        bricks = new Brick[72];
        bricks[0] = new Brick(brick_texture, new Position(6, 166));
        bricks[1] = new Brick(brick_texture, new Position(6, 178));
        bricks[2] = new Brick(brick_texture, new Position(6, 190));
        bricks[3] = new Brick(brick_texture, new Position(6, 202));
        bricks[4] = new Brick(brick_texture, new Position(6, 214));
        bricks[5] = new Brick(brick_texture, new Position(6, 226));
        bricks[6] = new Brick(brick_texture, new Position(6, 238));
        bricks[7] = new Brick(brick_texture, new Position(6, 250));
        bricks[8] = new Brick(brick_texture, new Position(6, 262));
        bricks[9] = new Brick(brick_texture, new Position(6, 274));
        bricks[10] = new Brick(brick_texture, new Position(6, 286));
        bricks[11] = new Brick(brick_texture, new Position(6, 298));
        bricks[12] = new Brick(brick_texture, new Position(6, 310));
        bricks[13] = new Brick(brick_texture, new Position(6, 322));
        bricks[14] = new Brick(brick_texture, new Position(6, 334));
        bricks[15] = new Brick(brick_texture, new Position(6, 346));
        bricks[16] = new Brick(brick_texture, new Position(6, 358));
        bricks[17] = new Brick(brick_texture, new Position(6, 370));
        bricks[18] = new Brick(brick_texture, new Position(6, 382));
        bricks[19] = new Brick(brick_texture, new Position(18, 166));
        bricks[20] = new Brick(brick_texture, new Position(18, 382));
        bricks[21] = new Brick(brick_texture, new Position(30, 166));
        bricks[22] = new Brick(brick_texture, new Position(30, 382));
        bricks[23] = new Brick(brick_texture, new Position(42, 166));
        bricks[24] = new Brick(brick_texture, new Position(42, 382));
        bricks[25] = new Brick(brick_texture, new Position(54, 166));
        bricks[26] = new Brick(brick_texture, new Position(54, 382));
        bricks[27] = new Brick(brick_texture, new Position(66, 166));
        bricks[28] = new Brick(brick_texture, new Position(66, 382));
        bricks[29] = new Brick(brick_texture, new Position(78, 166));
        bricks[30] = new Brick(brick_texture, new Position(78, 382));
        bricks[31] = new Brick(brick_texture, new Position(90, 166));
        bricks[32] = new Brick(brick_texture, new Position(90, 382));
        bricks[33] = new Brick(brick_texture, new Position(102, 166));
        bricks[34] = new Brick(brick_texture, new Position(102, 382));
        bricks[35] = new Brick(brick_texture, new Position(114, 166));
        bricks[36] = new Brick(brick_texture, new Position(114, 382));
        bricks[37] = new Brick(brick_texture, new Position(126, 166));
        bricks[38] = new Brick(brick_texture, new Position(126, 382));
        bricks[39] = new Brick(brick_texture, new Position(138, 166));
        bricks[40] = new Brick(brick_texture, new Position(138, 382));
        bricks[41] = new Brick(brick_texture, new Position(150, 166));
        bricks[42] = new Brick(brick_texture, new Position(150, 382));
        bricks[43] = new Brick(brick_texture, new Position(162, 166));
        bricks[44] = new Brick(brick_texture, new Position(162, 382));
        bricks[45] = new Brick(brick_texture, new Position(174, 166));
        bricks[46] = new Brick(brick_texture, new Position(174, 382));
        bricks[47] = new Brick(brick_texture, new Position(186, 166));
        bricks[48] = new Brick(brick_texture, new Position(186, 382));
        bricks[49] = new Brick(brick_texture, new Position(198, 166));
        bricks[50] = new Brick(brick_texture, new Position(198, 382));
        bricks[51] = new Brick(brick_texture, new Position(210, 166));
        bricks[52] = new Brick(brick_texture, new Position(210, 382));
        bricks[53] = new Brick(brick_texture, new Position(222, 166));
        bricks[54] = new Brick(brick_texture, new Position(222, 178));
        bricks[55] = new Brick(brick_texture, new Position(222, 190));
        bricks[56] = new Brick(brick_texture, new Position(222, 202));
        bricks[57] = new Brick(brick_texture, new Position(222, 214));
        bricks[58] = new Brick(brick_texture, new Position(222, 226));
        bricks[59] = new Brick(brick_texture, new Position(222, 238));
        bricks[60] = new Brick(brick_texture, new Position(222, 250));
        bricks[61] = new Brick(brick_texture, new Position(222, 262));
        bricks[62] = new Brick(brick_texture, new Position(222, 274));
        bricks[63] = new Brick(brick_texture, new Position(222, 286));
        bricks[64] = new Brick(brick_texture, new Position(222, 298));
        bricks[65] = new Brick(brick_texture, new Position(222, 310));
        bricks[66] = new Brick(brick_texture, new Position(222, 322));
        bricks[67] = new Brick(brick_texture, new Position(222, 334));
        bricks[68] = new Brick(brick_texture, new Position(222, 346));
        bricks[69] = new Brick(brick_texture, new Position(222, 358));
        bricks[70] = new Brick(brick_texture, new Position(222, 370));
        bricks[71] = new Brick(brick_texture, new Position(222, 382));
    }

    private void initializeClassicNowalls() {
        bricks = new Brick[0];
    }

    private void initializeMiddleSquareWalls() {
        bricks = new Brick[97];
        bricks[0] = new Brick(brick_texture, new Position(6, 166));
        bricks[1] = new Brick(brick_texture, new Position(6, 178));
        bricks[2] = new Brick(brick_texture, new Position(6, 190));
        bricks[3] = new Brick(brick_texture, new Position(6, 202));
        bricks[4] = new Brick(brick_texture, new Position(6, 214));
        bricks[5] = new Brick(brick_texture, new Position(6, 226));
        bricks[6] = new Brick(brick_texture, new Position(6, 238));
        bricks[7] = new Brick(brick_texture, new Position(6, 250));
        bricks[8] = new Brick(brick_texture, new Position(6, 262));
        bricks[9] = new Brick(brick_texture, new Position(6, 274));
        bricks[10] = new Brick(brick_texture, new Position(6, 286));
        bricks[11] = new Brick(brick_texture, new Position(6, 298));
        bricks[12] = new Brick(brick_texture, new Position(6, 310));
        bricks[13] = new Brick(brick_texture, new Position(6, 322));
        bricks[14] = new Brick(brick_texture, new Position(6, 334));
        bricks[15] = new Brick(brick_texture, new Position(6, 346));
        bricks[16] = new Brick(brick_texture, new Position(6, 358));
        bricks[17] = new Brick(brick_texture, new Position(6, 370));
        bricks[18] = new Brick(brick_texture, new Position(6, 382));
        bricks[19] = new Brick(brick_texture, new Position(18, 166));
        bricks[20] = new Brick(brick_texture, new Position(18, 382));
        bricks[21] = new Brick(brick_texture, new Position(30, 166));
        bricks[22] = new Brick(brick_texture, new Position(30, 382));
        bricks[23] = new Brick(brick_texture, new Position(42, 166));
        bricks[24] = new Brick(brick_texture, new Position(42, 382));
        bricks[25] = new Brick(brick_texture, new Position(54, 166));
        bricks[26] = new Brick(brick_texture, new Position(54, 382));
        bricks[27] = new Brick(brick_texture, new Position(66, 166));
        bricks[28] = new Brick(brick_texture, new Position(66, 238));
        bricks[29] = new Brick(brick_texture, new Position(66, 250));
        bricks[30] = new Brick(brick_texture, new Position(66, 262));
        bricks[31] = new Brick(brick_texture, new Position(66, 274));
        bricks[32] = new Brick(brick_texture, new Position(66, 286));
        bricks[33] = new Brick(brick_texture, new Position(66, 298));
        bricks[34] = new Brick(brick_texture, new Position(66, 310));
        bricks[35] = new Brick(brick_texture, new Position(66, 382));
        bricks[36] = new Brick(brick_texture, new Position(78, 166));
        bricks[37] = new Brick(brick_texture, new Position(78, 238));
        bricks[38] = new Brick(brick_texture, new Position(78, 310));
        bricks[39] = new Brick(brick_texture, new Position(78, 382));
        bricks[40] = new Brick(brick_texture, new Position(90, 166));
        bricks[41] = new Brick(brick_texture, new Position(90, 238));
        bricks[42] = new Brick(brick_texture, new Position(90, 310));
        bricks[43] = new Brick(brick_texture, new Position(90, 382));
        bricks[44] = new Brick(brick_texture, new Position(102, 166));
        bricks[45] = new Brick(brick_texture, new Position(102, 238));
        bricks[46] = new Brick(brick_texture, new Position(102, 382));
        bricks[47] = new Brick(brick_texture, new Position(114, 166));
        bricks[48] = new Brick(brick_texture, new Position(114, 238));
        bricks[49] = new Brick(brick_texture, new Position(114, 382));
        bricks[50] = new Brick(brick_texture, new Position(126, 166));
        bricks[51] = new Brick(brick_texture, new Position(126, 238));
        bricks[52] = new Brick(brick_texture, new Position(126, 382));
        bricks[53] = new Brick(brick_texture, new Position(138, 166));
        bricks[54] = new Brick(brick_texture, new Position(138, 238));
        bricks[55] = new Brick(brick_texture, new Position(138, 310));
        bricks[56] = new Brick(brick_texture, new Position(138, 382));
        bricks[57] = new Brick(brick_texture, new Position(150, 166));
        bricks[58] = new Brick(brick_texture, new Position(150, 238));
        bricks[59] = new Brick(brick_texture, new Position(150, 310));
        bricks[60] = new Brick(brick_texture, new Position(150, 382));
        bricks[61] = new Brick(brick_texture, new Position(162, 166));
        bricks[62] = new Brick(brick_texture, new Position(162, 238));
        bricks[63] = new Brick(brick_texture, new Position(162, 250));
        bricks[64] = new Brick(brick_texture, new Position(162, 262));
        bricks[65] = new Brick(brick_texture, new Position(162, 274));
        bricks[66] = new Brick(brick_texture, new Position(162, 286));
        bricks[67] = new Brick(brick_texture, new Position(162, 298));
        bricks[68] = new Brick(brick_texture, new Position(162, 310));
        bricks[69] = new Brick(brick_texture, new Position(162, 382));
        bricks[70] = new Brick(brick_texture, new Position(174, 166));
        bricks[71] = new Brick(brick_texture, new Position(174, 382));
        bricks[72] = new Brick(brick_texture, new Position(186, 166));
        bricks[73] = new Brick(brick_texture, new Position(186, 382));
        bricks[74] = new Brick(brick_texture, new Position(198, 166));
        bricks[75] = new Brick(brick_texture, new Position(198, 382));
        bricks[76] = new Brick(brick_texture, new Position(210, 166));
        bricks[77] = new Brick(brick_texture, new Position(210, 382));
        bricks[78] = new Brick(brick_texture, new Position(222, 166));
        bricks[79] = new Brick(brick_texture, new Position(222, 178));
        bricks[80] = new Brick(brick_texture, new Position(222, 190));
        bricks[81] = new Brick(brick_texture, new Position(222, 202));
        bricks[82] = new Brick(brick_texture, new Position(222, 214));
        bricks[83] = new Brick(brick_texture, new Position(222, 226));
        bricks[84] = new Brick(brick_texture, new Position(222, 238));
        bricks[85] = new Brick(brick_texture, new Position(222, 250));
        bricks[86] = new Brick(brick_texture, new Position(222, 262));
        bricks[87] = new Brick(brick_texture, new Position(222, 274));
        bricks[88] = new Brick(brick_texture, new Position(222, 286));
        bricks[89] = new Brick(brick_texture, new Position(222, 298));
        bricks[90] = new Brick(brick_texture, new Position(222, 310));
        bricks[91] = new Brick(brick_texture, new Position(222, 322));
        bricks[92] = new Brick(brick_texture, new Position(222, 334));
        bricks[93] = new Brick(brick_texture, new Position(222, 346));
        bricks[94] = new Brick(brick_texture, new Position(222, 358));
        bricks[95] = new Brick(brick_texture, new Position(222, 370));
        bricks[96] = new Brick(brick_texture, new Position(222, 382));
    }

    private void initializeMiddleSquareNoWalls() {
        bricks = new Brick[25];
        bricks[0] = new Brick(brick_texture, new Position(66, 238));
        bricks[1] = new Brick(brick_texture, new Position(66, 250));
        bricks[2] = new Brick(brick_texture, new Position(66, 262));
        bricks[3] = new Brick(brick_texture, new Position(66, 274));
        bricks[4] = new Brick(brick_texture, new Position(66, 286));
        bricks[5] = new Brick(brick_texture, new Position(66, 298));
        bricks[6] = new Brick(brick_texture, new Position(66, 310));
        bricks[7] = new Brick(brick_texture, new Position(78, 238));
        bricks[8] = new Brick(brick_texture, new Position(78, 310));
        bricks[9] = new Brick(brick_texture, new Position(90, 238));
        bricks[10] = new Brick(brick_texture, new Position(90, 310));
        bricks[11] = new Brick(brick_texture, new Position(102, 238));
        bricks[12] = new Brick(brick_texture, new Position(114, 238));
        bricks[13] = new Brick(brick_texture, new Position(126, 238));
        bricks[14] = new Brick(brick_texture, new Position(138, 238));
        bricks[15] = new Brick(brick_texture, new Position(138, 310));
        bricks[16] = new Brick(brick_texture, new Position(150, 238));
        bricks[17] = new Brick(brick_texture, new Position(150, 310));
        bricks[18] = new Brick(brick_texture, new Position(162, 238));
        bricks[19] = new Brick(brick_texture, new Position(162, 250));
        bricks[20] = new Brick(brick_texture, new Position(162, 262));
        bricks[21] = new Brick(brick_texture, new Position(162, 274));
        bricks[22] = new Brick(brick_texture, new Position(162, 286));
        bricks[23] = new Brick(brick_texture, new Position(162, 298));
        bricks[24] = new Brick(brick_texture, new Position(162, 310));
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
