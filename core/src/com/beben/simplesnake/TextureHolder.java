package com.beben.simplesnake;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by bezik on 11.08.16.
 */
public class TextureHolder {

    public Texture DPadUP_UP;
    public Texture DPadUP_DOWN;
    public Texture DPadUP_LEFT;
    public Texture DPadUP_RIGHT;
    public Texture DPadDOWN_UP;
    public Texture DPadDOWN_DOWN;
    public Texture DPadDOWN_LEFT;
    public Texture DPadDOWN_RIGHT;
    public Texture game_button_PAUSE;
    public Texture snake_HEAD;
    public Texture snake_BODY;
    public Texture snake_END;;
    public Texture snack_TIMEBOMB;
    public Texture snack_APPLE;
    public Texture game_BACKGROUND;
    public Texture game_AREA;
    public Texture game_BRICK;

    public Texture menu_BACKGROUND;
    public Texture menu_PLAY;
    public Texture menu_OPTIONS;
    public Texture menu_INFO;

    public Texture options_BACKGROUND;
    public Texture options_VIBRATION_ON;
    public Texture options_VIBRATION_OFF;
    public Texture options_stylePreview_MODERN;
    public Texture options_stylePreview_DEFAULT;
    public Texture options_switch_RIGHT;
    public Texture options_switch_LEFT;
    public Texture options_button_RETURN;
    public Texture options_mapPreview_CLASSIC_WALLS;
    public Texture options_mapPreview_CLASSIC_NOWALLS;
    public Texture options_mapPreview_MIDDLESQUARE_WALLS;
    public Texture options_mapPreview_MIDDLESQUARE_NOWALLS;
    public Texture options_mapPreview_DICK_NOWALLS;

    public Texture over_BACKGROUND;
    public Texture over_NEWGAME;
    public Texture over_RETURN;





    public TextureHolder(Texture menu_BACKGROUND, Texture menu_PLAY, Texture menu_OPTIONS, Texture menu_INFO) {
        this.menu_BACKGROUND = menu_BACKGROUND;
        this.menu_PLAY = menu_PLAY;
        this.menu_OPTIONS = menu_OPTIONS;
        this.menu_INFO = menu_INFO;
    }

    public TextureHolder(Texture options_BACKGROUND, Texture options_VIBRATION_ON, Texture options_VIBRATION_OFF, Texture options_stylePreview_MODERN, Texture options_stylePreview_DEFAULT, Texture options_switch_RIGHT, Texture options_switch_LEFT, Texture options_button_RETURN, Texture options_mapPreview_CLASSIC_WALLS, Texture options_mapPreview_CLASSIC_NOWALLS, Texture options_mapPreview_MIDDLESQUARE_WALLS, Texture options_mapPreview_MIDDLESQUARE_NOWALLS, Texture options_mapPreview_DICK_NOWALLS) {
        this.options_BACKGROUND = options_BACKGROUND;
        this.options_VIBRATION_ON = options_VIBRATION_ON;
        this.options_VIBRATION_OFF = options_VIBRATION_OFF;
        this.options_stylePreview_MODERN = options_stylePreview_MODERN;
        this.options_stylePreview_DEFAULT = options_stylePreview_DEFAULT;
        this.options_switch_RIGHT = options_switch_RIGHT;
        this.options_switch_LEFT = options_switch_LEFT;
        this.options_button_RETURN = options_button_RETURN;
        this.options_mapPreview_CLASSIC_WALLS = options_mapPreview_CLASSIC_WALLS;
        this.options_mapPreview_CLASSIC_NOWALLS = options_mapPreview_CLASSIC_NOWALLS;
        this.options_mapPreview_MIDDLESQUARE_WALLS = options_mapPreview_MIDDLESQUARE_WALLS;
        this.options_mapPreview_MIDDLESQUARE_NOWALLS = options_mapPreview_MIDDLESQUARE_NOWALLS;
        this.options_mapPreview_DICK_NOWALLS = options_mapPreview_DICK_NOWALLS;
    }

    public TextureHolder(Texture over_BACKGROUND, Texture over_NEWGAME, Texture over_RETURN) {
        this.over_BACKGROUND = over_BACKGROUND;
        this.over_NEWGAME = over_NEWGAME;
        this.over_RETURN = over_RETURN;
    }

    public TextureHolder(Texture DPadUP_UP, Texture DPadUP_DOWN, Texture DPadUP_LEFT, Texture DPadUP_RIGHT, Texture DPadDOWN_UP, Texture DPadDOWN_DOWN, Texture DPadDOWN_LEFT, Texture DPadDOWN_RIGHT, Texture game_button_PAUSE, Texture snake_HEAD, Texture snake_BODY, Texture snake_END, Texture snack_TIMEBOMB, Texture snack_APPLE, Texture game_BACKGROUND, Texture game_AREA, Texture game_BRICK) {
        this.DPadUP_UP = DPadUP_UP;
        this.DPadUP_DOWN = DPadUP_DOWN;
        this.DPadUP_LEFT = DPadUP_LEFT;
        this.DPadUP_RIGHT = DPadUP_RIGHT;
        this.DPadDOWN_UP = DPadDOWN_UP;
        this.DPadDOWN_DOWN = DPadDOWN_DOWN;
        this.DPadDOWN_LEFT = DPadDOWN_LEFT;
        this.DPadDOWN_RIGHT = DPadDOWN_RIGHT;
        this.game_button_PAUSE = game_button_PAUSE;
        this.snake_HEAD = snake_HEAD;
        this.snake_BODY = snake_BODY;
        this.snake_END = snake_END;
        this.snack_TIMEBOMB = snack_TIMEBOMB;
        this.snack_APPLE = snack_APPLE;
        this.game_BACKGROUND = game_BACKGROUND;
        this.game_AREA = game_AREA;
        this.game_BRICK = game_BRICK;
    }
}
