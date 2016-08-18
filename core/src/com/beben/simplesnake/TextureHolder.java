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

    public Texture over_BACKGROUND;
    public Texture over_NEWGAME;
    public Texture over_RETURN;




    public TextureHolder(Texture DPad_UP, Texture DPad_DOWN, Texture DPad_LEFT, Texture DPad_RIGHT, Texture game_button_PAUSE, Texture snake_HEAD, Texture snake_BODY, Texture snake_END, Texture snack_TIMEBOMB, Texture snack_APPLE, Texture game_BACKGROUND, Texture game_AREA, Texture game_BRICK) {
        this.DPad_UP = DPad_UP;
        this.DPad_DOWN = DPad_DOWN;
        this.DPad_LEFT = DPad_LEFT;
        this.DPad_RIGHT = DPad_RIGHT;
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

    public TextureHolder(Texture menu_BACKGROUND, Texture menu_PLAY, Texture menu_OPTIONS, Texture menu_INFO) {
        this.menu_BACKGROUND = menu_BACKGROUND;
        this.menu_PLAY = menu_PLAY;
        this.menu_OPTIONS = menu_OPTIONS;
        this.menu_INFO = menu_INFO;
    }

    public TextureHolder(Texture options_BACKGROUND, Texture options_VIBRATION_ON, Texture options_VIBRATION_OFF, Texture options_stylePreview_MODERN, Texture options_stylePreview_DEFAULT, Texture options_switch_RIGHT, Texture options_switch_LEFT, Texture options_button_RETURN, Texture options_mapPreview_CLASSIC_WALLS, Texture options_mapPreview_CLASSIC_NOWALLS, Texture options_mapPreview_MIDDLESQUARE_WALLS, Texture options_mapPreview_MIDDLESQUARE_NOWALLS) {
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
    }

    public TextureHolder(Texture over_BACKGROUND, Texture over_NEWGAME, Texture over_RETURN) {
        this.over_BACKGROUND = over_BACKGROUND;
        this.over_NEWGAME = over_NEWGAME;
        this.over_RETURN = over_RETURN;
    }
}
