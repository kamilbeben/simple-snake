package com.beben.simplesnake;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by bezik on 11.08.16.
 */
public class TextureHolder {

    public Texture DPad_UP;
    public Texture DPad_DOWN;
    public Texture DPad_LEFT;
    public Texture DPad_RIGHT;
    public Texture button_PAUSE;
    public Texture button_RETURN;
    public Texture snake_HEAD;
    public Texture snake_BODY;
    public Texture snake_END;;
    public Texture snack_TIMEBOMB;
    public Texture snack_APPLE;
    public Texture game_BACKGROUND;
    public Texture game_AREA;


    public TextureHolder(Texture DPad_UP, Texture DPad_DOWN, Texture DPad_LEFT, Texture DPad_RIGHT, Texture button_PAUSE, Texture button_RETURN, Texture snake_HEAD, Texture snake_BODY, Texture snake_END, Texture snack_TIMEBOMB, Texture snack_APPLE, Texture game_BACKGROUND, Texture game_AREA) {
        this.DPad_UP = DPad_UP;
        this.DPad_DOWN = DPad_DOWN;
        this.DPad_LEFT = DPad_LEFT;
        this.DPad_RIGHT = DPad_RIGHT;
        this.button_PAUSE = button_PAUSE;
        this.button_RETURN = button_RETURN;
        this.snake_HEAD = snake_HEAD;
        this.snake_BODY = snake_BODY;
        this.snake_END = snake_END;
        this.snack_TIMEBOMB = snack_TIMEBOMB;
        this.snack_APPLE = snack_APPLE;
        this.game_BACKGROUND = game_BACKGROUND;
        this.game_AREA = game_AREA;
    }
}
