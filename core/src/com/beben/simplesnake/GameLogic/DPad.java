package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.beben.simplesnake.Assets;

/**
 * Created by bezik on 09.08.16.
 */
public class DPad {

    public DPadArrow left;
    public DPadArrow right;
    public DPadArrow up;
    public DPadArrow down;

    public DPad(Stage stage, Assets assets) {
        up = new DPadArrow(stage, new Position(70, 84), assets.textureHolder.DPadUP_UP,
                assets.textureHolder.DPadDOWN_UP);
        left = new DPadArrow(stage, new Position(6, 6), assets.textureHolder.DPadUP_LEFT,
                assets.textureHolder.DPadDOWN_LEFT);
        right = new DPadArrow(stage, new Position(171, 6), assets.textureHolder.DPadUP_RIGHT,
                assets.textureHolder.DPadDOWN_RIGHT);
        down = new DPadArrow(stage, new Position(70, 6), assets.textureHolder.DPadUP_DOWN,
                assets.textureHolder.DPadDOWN_DOWN);
    }


}
