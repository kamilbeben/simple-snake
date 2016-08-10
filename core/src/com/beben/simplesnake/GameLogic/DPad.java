package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by bezik on 09.08.16.
 */
public class DPad {

    public DPadArrow left;
    public DPadArrow right;
    public DPadArrow up;
    public DPadArrow down;

    public DPad(Stage stage) {
        up = new DPadArrow(stage, new Position(105, 100), "dpad/up.png");
        left = new DPadArrow(stage, new Position(58, 68), "dpad/left.png");
        right = new DPadArrow(stage, new Position(134, 68), "dpad/right.png");
        down = new DPadArrow(stage, new Position(105, 23), "dpad/down.png");
    }


}
