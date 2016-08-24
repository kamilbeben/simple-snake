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
        } else if (game.config.map.isEquation()) {
            initializeEquation();
        } else if (game.config.map.isCage()) {
            initializeCage();
        } else if (game.config.map.isHeart()) {
            initializeHeart();
        } else if (game.config.map.isCave()) {
            initializeCave();
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

    private void initializeCage() {
        bricks = new Brick[86];
        bricks[0] = new Brick(brick_texture, new Position(6, 166));
        bricks[1] = new Brick(brick_texture, new Position(6, 178));
        bricks[2] = new Brick(brick_texture, new Position(6, 190));
        bricks[3] = new Brick(brick_texture, new Position(6, 202));
        bricks[4] = new Brick(brick_texture, new Position(6, 214));
        bricks[5] = new Brick(brick_texture, new Position(6, 226));
        bricks[6] = new Brick(brick_texture, new Position(6, 238));
        bricks[7] = new Brick(brick_texture, new Position(6, 310));
        bricks[8] = new Brick(brick_texture, new Position(6, 322));
        bricks[9] = new Brick(brick_texture, new Position(6, 334));
        bricks[10] = new Brick(brick_texture, new Position(6, 346));
        bricks[11] = new Brick(brick_texture, new Position(6, 358));
        bricks[12] = new Brick(brick_texture, new Position(6, 370));
        bricks[13] = new Brick(brick_texture, new Position(6, 382));
        bricks[14] = new Brick(brick_texture, new Position(18, 166));
        bricks[15] = new Brick(brick_texture, new Position(18, 238));
        bricks[16] = new Brick(brick_texture, new Position(18, 310));
        bricks[17] = new Brick(brick_texture, new Position(18, 382));
        bricks[18] = new Brick(brick_texture, new Position(30, 166));
        bricks[19] = new Brick(brick_texture, new Position(30, 238));
        bricks[20] = new Brick(brick_texture, new Position(30, 310));
        bricks[21] = new Brick(brick_texture, new Position(30, 382));
        bricks[22] = new Brick(brick_texture, new Position(42, 166));
        bricks[23] = new Brick(brick_texture, new Position(42, 238));
        bricks[24] = new Brick(brick_texture, new Position(42, 250));
        bricks[25] = new Brick(brick_texture, new Position(42, 262));
        bricks[26] = new Brick(brick_texture, new Position(42, 274));
        bricks[27] = new Brick(brick_texture, new Position(42, 286));
        bricks[28] = new Brick(brick_texture, new Position(42, 298));
        bricks[29] = new Brick(brick_texture, new Position(42, 310));
        bricks[30] = new Brick(brick_texture, new Position(42, 382));
        bricks[31] = new Brick(brick_texture, new Position(54, 166));
        bricks[32] = new Brick(brick_texture, new Position(54, 382));
        bricks[33] = new Brick(brick_texture, new Position(66, 166));
        bricks[34] = new Brick(brick_texture, new Position(66, 382));
        bricks[35] = new Brick(brick_texture, new Position(78, 166));
        bricks[36] = new Brick(brick_texture, new Position(78, 178));
        bricks[37] = new Brick(brick_texture, new Position(78, 190));
        bricks[38] = new Brick(brick_texture, new Position(78, 202));
        bricks[39] = new Brick(brick_texture, new Position(78, 346));
        bricks[40] = new Brick(brick_texture, new Position(78, 358));
        bricks[41] = new Brick(brick_texture, new Position(78, 370));
        bricks[42] = new Brick(brick_texture, new Position(78, 382));
        bricks[43] = new Brick(brick_texture, new Position(90, 346));
        bricks[44] = new Brick(brick_texture, new Position(102, 346));
        bricks[45] = new Brick(brick_texture, new Position(114, 346));
        bricks[46] = new Brick(brick_texture, new Position(126, 346));
        bricks[47] = new Brick(brick_texture, new Position(138, 346));
        bricks[48] = new Brick(brick_texture, new Position(150, 166));
        bricks[49] = new Brick(brick_texture, new Position(150, 178));
        bricks[50] = new Brick(brick_texture, new Position(150, 190));
        bricks[51] = new Brick(brick_texture, new Position(150, 202));
        bricks[52] = new Brick(brick_texture, new Position(150, 346));
        bricks[53] = new Brick(brick_texture, new Position(150, 358));
        bricks[54] = new Brick(brick_texture, new Position(150, 370));
        bricks[55] = new Brick(brick_texture, new Position(150, 382));
        bricks[56] = new Brick(brick_texture, new Position(162, 166));
        bricks[57] = new Brick(brick_texture, new Position(162, 382));
        bricks[58] = new Brick(brick_texture, new Position(174, 166));
        bricks[59] = new Brick(brick_texture, new Position(174, 382));
        bricks[60] = new Brick(brick_texture, new Position(186, 166));
        bricks[61] = new Brick(brick_texture, new Position(186, 238));
        bricks[62] = new Brick(brick_texture, new Position(186, 310));
        bricks[63] = new Brick(brick_texture, new Position(186, 382));
        bricks[64] = new Brick(brick_texture, new Position(198, 166));
        bricks[65] = new Brick(brick_texture, new Position(198, 238));
        bricks[66] = new Brick(brick_texture, new Position(198, 310));
        bricks[67] = new Brick(brick_texture, new Position(198, 382));
        bricks[68] = new Brick(brick_texture, new Position(210, 166));
        bricks[69] = new Brick(brick_texture, new Position(210, 238));
        bricks[70] = new Brick(brick_texture, new Position(210, 310));
        bricks[71] = new Brick(brick_texture, new Position(210, 382));
        bricks[72] = new Brick(brick_texture, new Position(222, 166));
        bricks[73] = new Brick(brick_texture, new Position(222, 178));
        bricks[74] = new Brick(brick_texture, new Position(222, 190));
        bricks[75] = new Brick(brick_texture, new Position(222, 202));
        bricks[76] = new Brick(brick_texture, new Position(222, 214));
        bricks[77] = new Brick(brick_texture, new Position(222, 226));
        bricks[78] = new Brick(brick_texture, new Position(222, 238));
        bricks[79] = new Brick(brick_texture, new Position(222, 310));
        bricks[80] = new Brick(brick_texture, new Position(222, 322));
        bricks[81] = new Brick(brick_texture, new Position(222, 334));
        bricks[82] = new Brick(brick_texture, new Position(222, 346));
        bricks[83] = new Brick(brick_texture, new Position(222, 358));
        bricks[84] = new Brick(brick_texture, new Position(222, 370));
        bricks[85] = new Brick(brick_texture, new Position(222, 382));
    }

    private void initializeHeart() {
        bricks = new Brick[40];
        bricks[0] = new Brick(brick_texture, new Position(6, 322));
        bricks[1] = new Brick(brick_texture, new Position(18, 322));
        bricks[2] = new Brick(brick_texture, new Position(30, 322));
        bricks[3] = new Brick(brick_texture, new Position(42, 322));
        bricks[4] = new Brick(brick_texture, new Position(54, 322));
        bricks[5] = new Brick(brick_texture, new Position(66, 166));
        bricks[6] = new Brick(brick_texture, new Position(66, 178));
        bricks[7] = new Brick(brick_texture, new Position(66, 190));
        bricks[8] = new Brick(brick_texture, new Position(66, 202));
        bricks[9] = new Brick(brick_texture, new Position(66, 214));
        bricks[10] = new Brick(brick_texture, new Position(66, 226));
        bricks[11] = new Brick(brick_texture, new Position(66, 238));
        bricks[12] = new Brick(brick_texture, new Position(66, 250));
        bricks[13] = new Brick(brick_texture, new Position(66, 262));
        bricks[14] = new Brick(brick_texture, new Position(66, 274));
        bricks[15] = new Brick(brick_texture, new Position(66, 322));
        bricks[16] = new Brick(brick_texture, new Position(78, 322));
        bricks[17] = new Brick(brick_texture, new Position(90, 322));
        bricks[18] = new Brick(brick_texture, new Position(102, 322));
        bricks[19] = new Brick(brick_texture, new Position(114, 226));
        bricks[20] = new Brick(brick_texture, new Position(114, 322));
        bricks[21] = new Brick(brick_texture, new Position(126, 226));
        bricks[22] = new Brick(brick_texture, new Position(138, 226));
        bricks[23] = new Brick(brick_texture, new Position(150, 226));
        bricks[24] = new Brick(brick_texture, new Position(162, 226));
        bricks[25] = new Brick(brick_texture, new Position(162, 274));
        bricks[26] = new Brick(brick_texture, new Position(162, 286));
        bricks[27] = new Brick(brick_texture, new Position(162, 298));
        bricks[28] = new Brick(brick_texture, new Position(162, 310));
        bricks[29] = new Brick(brick_texture, new Position(162, 322));
        bricks[30] = new Brick(brick_texture, new Position(162, 334));
        bricks[31] = new Brick(brick_texture, new Position(162, 346));
        bricks[32] = new Brick(brick_texture, new Position(162, 358));
        bricks[33] = new Brick(brick_texture, new Position(162, 370));
        bricks[34] = new Brick(brick_texture, new Position(162, 382));
        bricks[35] = new Brick(brick_texture, new Position(174, 226));
        bricks[36] = new Brick(brick_texture, new Position(186, 226));
        bricks[37] = new Brick(brick_texture, new Position(198, 226));
        bricks[38] = new Brick(brick_texture, new Position(210, 226));
        bricks[39] = new Brick(brick_texture, new Position(222, 226));
    }

    private void initializeCave() {
        bricks = new Brick[135];
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
        bricks[20] = new Brick(brick_texture, new Position(18, 178));
        bricks[21] = new Brick(brick_texture, new Position(18, 190));
        bricks[22] = new Brick(brick_texture, new Position(18, 202));
        bricks[23] = new Brick(brick_texture, new Position(18, 214));
        bricks[24] = new Brick(brick_texture, new Position(18, 226));
        bricks[25] = new Brick(brick_texture, new Position(18, 322));
        bricks[26] = new Brick(brick_texture, new Position(18, 334));
        bricks[27] = new Brick(brick_texture, new Position(18, 346));
        bricks[28] = new Brick(brick_texture, new Position(18, 358));
        bricks[29] = new Brick(brick_texture, new Position(18, 370));
        bricks[30] = new Brick(brick_texture, new Position(18, 382));
        bricks[31] = new Brick(brick_texture, new Position(30, 166));
        bricks[32] = new Brick(brick_texture, new Position(30, 178));
        bricks[33] = new Brick(brick_texture, new Position(30, 190));
        bricks[34] = new Brick(brick_texture, new Position(30, 202));
        bricks[35] = new Brick(brick_texture, new Position(30, 214));
        bricks[36] = new Brick(brick_texture, new Position(30, 334));
        bricks[37] = new Brick(brick_texture, new Position(30, 346));
        bricks[38] = new Brick(brick_texture, new Position(30, 358));
        bricks[39] = new Brick(brick_texture, new Position(30, 370));
        bricks[40] = new Brick(brick_texture, new Position(30, 382));
        bricks[41] = new Brick(brick_texture, new Position(42, 166));
        bricks[42] = new Brick(brick_texture, new Position(42, 178));
        bricks[43] = new Brick(brick_texture, new Position(42, 190));
        bricks[44] = new Brick(brick_texture, new Position(42, 202));
        bricks[45] = new Brick(brick_texture, new Position(42, 346));
        bricks[46] = new Brick(brick_texture, new Position(42, 358));
        bricks[47] = new Brick(brick_texture, new Position(42, 370));
        bricks[48] = new Brick(brick_texture, new Position(42, 382));
        bricks[49] = new Brick(brick_texture, new Position(54, 166));
        bricks[50] = new Brick(brick_texture, new Position(54, 178));
        bricks[51] = new Brick(brick_texture, new Position(54, 190));
        bricks[52] = new Brick(brick_texture, new Position(54, 358));
        bricks[53] = new Brick(brick_texture, new Position(54, 370));
        bricks[54] = new Brick(brick_texture, new Position(54, 382));
        bricks[55] = new Brick(brick_texture, new Position(66, 166));
        bricks[56] = new Brick(brick_texture, new Position(66, 178));
        bricks[57] = new Brick(brick_texture, new Position(66, 370));
        bricks[58] = new Brick(brick_texture, new Position(66, 382));
        bricks[59] = new Brick(brick_texture, new Position(78, 166));
        bricks[60] = new Brick(brick_texture, new Position(78, 178));
        bricks[61] = new Brick(brick_texture, new Position(78, 370));
        bricks[62] = new Brick(brick_texture, new Position(78, 382));
        bricks[63] = new Brick(brick_texture, new Position(90, 166));
        bricks[64] = new Brick(brick_texture, new Position(90, 178));
        bricks[65] = new Brick(brick_texture, new Position(90, 370));
        bricks[66] = new Brick(brick_texture, new Position(90, 382));
        bricks[67] = new Brick(brick_texture, new Position(102, 166));
        bricks[68] = new Brick(brick_texture, new Position(102, 178));
        bricks[69] = new Brick(brick_texture, new Position(102, 382));
        bricks[70] = new Brick(brick_texture, new Position(114, 166));
        bricks[71] = new Brick(brick_texture, new Position(114, 178));
        bricks[72] = new Brick(brick_texture, new Position(114, 382));
        bricks[73] = new Brick(brick_texture, new Position(126, 166));
        bricks[74] = new Brick(brick_texture, new Position(126, 178));
        bricks[75] = new Brick(brick_texture, new Position(126, 382));
        bricks[76] = new Brick(brick_texture, new Position(138, 166));
        bricks[77] = new Brick(brick_texture, new Position(138, 178));
        bricks[78] = new Brick(brick_texture, new Position(138, 382));
        bricks[79] = new Brick(brick_texture, new Position(150, 166));
        bricks[80] = new Brick(brick_texture, new Position(150, 178));
        bricks[81] = new Brick(brick_texture, new Position(150, 382));
        bricks[82] = new Brick(brick_texture, new Position(162, 166));
        bricks[83] = new Brick(brick_texture, new Position(162, 178));
        bricks[84] = new Brick(brick_texture, new Position(162, 370));
        bricks[85] = new Brick(brick_texture, new Position(162, 382));
        bricks[86] = new Brick(brick_texture, new Position(174, 166));
        bricks[87] = new Brick(brick_texture, new Position(174, 178));
        bricks[88] = new Brick(brick_texture, new Position(174, 358));
        bricks[89] = new Brick(brick_texture, new Position(174, 370));
        bricks[90] = new Brick(brick_texture, new Position(174, 382));
        bricks[91] = new Brick(brick_texture, new Position(186, 166));
        bricks[92] = new Brick(brick_texture, new Position(186, 178));
        bricks[93] = new Brick(brick_texture, new Position(186, 190));
        bricks[94] = new Brick(brick_texture, new Position(186, 346));
        bricks[95] = new Brick(brick_texture, new Position(186, 358));
        bricks[96] = new Brick(brick_texture, new Position(186, 370));
        bricks[97] = new Brick(brick_texture, new Position(186, 382));
        bricks[98] = new Brick(brick_texture, new Position(198, 166));
        bricks[99] = new Brick(brick_texture, new Position(198, 178));
        bricks[100] = new Brick(brick_texture, new Position(198, 190));
        bricks[101] = new Brick(brick_texture, new Position(198, 334));
        bricks[102] = new Brick(brick_texture, new Position(198, 346));
        bricks[103] = new Brick(brick_texture, new Position(198, 358));
        bricks[104] = new Brick(brick_texture, new Position(198, 370));
        bricks[105] = new Brick(brick_texture, new Position(198, 382));
        bricks[106] = new Brick(brick_texture, new Position(210, 166));
        bricks[107] = new Brick(brick_texture, new Position(210, 178));
        bricks[108] = new Brick(brick_texture, new Position(210, 190));
        bricks[109] = new Brick(brick_texture, new Position(210, 202));
        bricks[110] = new Brick(brick_texture, new Position(210, 322));
        bricks[111] = new Brick(brick_texture, new Position(210, 334));
        bricks[112] = new Brick(brick_texture, new Position(210, 346));
        bricks[113] = new Brick(brick_texture, new Position(210, 358));
        bricks[114] = new Brick(brick_texture, new Position(210, 370));
        bricks[115] = new Brick(brick_texture, new Position(210, 382));
        bricks[116] = new Brick(brick_texture, new Position(222, 166));
        bricks[117] = new Brick(brick_texture, new Position(222, 178));
        bricks[118] = new Brick(brick_texture, new Position(222, 190));
        bricks[119] = new Brick(brick_texture, new Position(222, 202));
        bricks[120] = new Brick(brick_texture, new Position(222, 214));
        bricks[121] = new Brick(brick_texture, new Position(222, 226));
        bricks[122] = new Brick(brick_texture, new Position(222, 238));
        bricks[123] = new Brick(brick_texture, new Position(222, 250));
        bricks[124] = new Brick(brick_texture, new Position(222, 262));
        bricks[125] = new Brick(brick_texture, new Position(222, 274));
        bricks[126] = new Brick(brick_texture, new Position(222, 286));
        bricks[127] = new Brick(brick_texture, new Position(222, 298));
        bricks[128] = new Brick(brick_texture, new Position(222, 310));
        bricks[129] = new Brick(brick_texture, new Position(222, 322));
        bricks[130] = new Brick(brick_texture, new Position(222, 334));
        bricks[131] = new Brick(brick_texture, new Position(222, 346));
        bricks[132] = new Brick(brick_texture, new Position(222, 358));
        bricks[133] = new Brick(brick_texture, new Position(222, 370));
        bricks[134] = new Brick(brick_texture, new Position(222, 382));
    }

    private void initializeEquation() {
        bricks = new Brick[60];
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
        bricks[19] = new Brick(brick_texture, new Position(54, 226));
        bricks[20] = new Brick(brick_texture, new Position(54, 322));
        bricks[21] = new Brick(brick_texture, new Position(66, 226));
        bricks[22] = new Brick(brick_texture, new Position(66, 322));
        bricks[23] = new Brick(brick_texture, new Position(78, 226));
        bricks[24] = new Brick(brick_texture, new Position(78, 322));
        bricks[25] = new Brick(brick_texture, new Position(90, 226));
        bricks[26] = new Brick(brick_texture, new Position(90, 322));
        bricks[27] = new Brick(brick_texture, new Position(102, 226));
        bricks[28] = new Brick(brick_texture, new Position(102, 322));
        bricks[29] = new Brick(brick_texture, new Position(114, 226));
        bricks[30] = new Brick(brick_texture, new Position(114, 322));
        bricks[31] = new Brick(brick_texture, new Position(126, 226));
        bricks[32] = new Brick(brick_texture, new Position(126, 322));
        bricks[33] = new Brick(brick_texture, new Position(138, 226));
        bricks[34] = new Brick(brick_texture, new Position(138, 322));
        bricks[35] = new Brick(brick_texture, new Position(150, 226));
        bricks[36] = new Brick(brick_texture, new Position(150, 322));
        bricks[37] = new Brick(brick_texture, new Position(162, 226));
        bricks[38] = new Brick(brick_texture, new Position(162, 322));
        bricks[39] = new Brick(brick_texture, new Position(174, 226));
        bricks[40] = new Brick(brick_texture, new Position(174, 322));
        bricks[41] = new Brick(brick_texture, new Position(222, 166));
        bricks[42] = new Brick(brick_texture, new Position(222, 178));
        bricks[43] = new Brick(brick_texture, new Position(222, 190));
        bricks[44] = new Brick(brick_texture, new Position(222, 202));
        bricks[45] = new Brick(brick_texture, new Position(222, 214));
        bricks[46] = new Brick(brick_texture, new Position(222, 226));
        bricks[47] = new Brick(brick_texture, new Position(222, 238));
        bricks[48] = new Brick(brick_texture, new Position(222, 250));
        bricks[49] = new Brick(brick_texture, new Position(222, 262));
        bricks[50] = new Brick(brick_texture, new Position(222, 274));
        bricks[51] = new Brick(brick_texture, new Position(222, 286));
        bricks[52] = new Brick(brick_texture, new Position(222, 298));
        bricks[53] = new Brick(brick_texture, new Position(222, 310));
        bricks[54] = new Brick(brick_texture, new Position(222, 322));
        bricks[55] = new Brick(brick_texture, new Position(222, 334));
        bricks[56] = new Brick(brick_texture, new Position(222, 346));
        bricks[57] = new Brick(brick_texture, new Position(222, 358));
        bricks[58] = new Brick(brick_texture, new Position(222, 370));
        bricks[59] = new Brick(brick_texture, new Position(222, 382));
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
