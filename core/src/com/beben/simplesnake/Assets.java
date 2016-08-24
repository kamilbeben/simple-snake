package com.beben.simplesnake;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by bezik on 10.08.16.
 */
public class Assets implements Disposable {

    public AssetManager manager = new AssetManager();
    private String style;
    public TextureHolder textureHolder;

    public Assets() {
        style = "default/";
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void loadOptionsAssets() {
        manager.clear();
        manager.load("fonts/font.fnt", BitmapFont.class);
        manager.load("menu/menu_background.png", Texture.class);
        manager.load("menu/options_vibrations_ON.png", Texture.class);
        manager.load("menu/options_vibrations_OFF.png", Texture.class);
        manager.load("menu/options_easyMode.png", Texture.class);
        manager.load("menu/options_hardMode.png", Texture.class);
        manager.load("menu/style_preview_modern.png", Texture.class);
        manager.load("menu/style_preview_retro.png", Texture.class);
        manager.load("menu/switch_right.png", Texture.class);
        manager.load("menu/switch_left.png", Texture.class);
        manager.load("menu/return_button.png", Texture.class);
        manager.load("preview_maps/classic_walls.png", Texture.class);
        manager.load("preview_maps/classic_nowalls.png", Texture.class);
        manager.load("preview_maps/middlesquare_walls.png", Texture.class);
        manager.load("preview_maps/middlesquare_nowalls.png", Texture.class);
        manager.load("preview_maps/equation.png", Texture.class);
        manager.load("preview_maps/cage.png", Texture.class);
        manager.load("preview_maps/heart.png", Texture.class);
        manager.load("preview_maps/cave.png", Texture.class);
        waitForLoadingToComplete();
        textureHolder = new TextureHolder(
                manager.get("menu/menu_background.png", Texture.class),
                manager.get("menu/options_vibrations_ON.png", Texture.class),
                manager.get("menu/options_vibrations_OFF.png", Texture.class),
                manager.get("menu/options_easyMode.png", Texture.class),
                manager.get("menu/options_hardMode.png", Texture.class),
                manager.get("menu/style_preview_modern.png", Texture.class),
                manager.get("menu/style_preview_retro.png", Texture.class),
                manager.get("menu/switch_right.png", Texture.class),
                manager.get("menu/switch_left.png", Texture.class),
                manager.get("menu/return_button.png", Texture.class),
                manager.get("preview_maps/classic_walls.png", Texture.class),
                manager.get("preview_maps/classic_nowalls.png", Texture.class),
                manager.get("preview_maps/middlesquare_walls.png", Texture.class),
                manager.get("preview_maps/middlesquare_nowalls.png", Texture.class),
                manager.get("preview_maps/equation.png", Texture.class),
                manager.get("preview_maps/cage.png", Texture.class),
                manager.get("preview_maps/heart.png", Texture.class),
                manager.get("preview_maps/cave.png", Texture.class)
        );
    }
    public void loadMenuAssets() {
        manager.clear();
        manager.load("menu/menu_background.png", Texture.class);
        manager.load("menu/play_button.png", Texture.class);
        manager.load("menu/options_button.png", Texture.class);
        manager.load("menu/info_button.png", Texture.class);
        waitForLoadingToComplete();
        textureHolder = new TextureHolder(
                manager.get("menu/menu_background.png", Texture.class),
                manager.get("menu/play_button.png", Texture.class),
                manager.get("menu/options_button.png", Texture.class),
                manager.get("menu/info_button.png", Texture.class)
        );
    }

    public void loadGameAssets() {
        manager.clear();
        manager.load("fonts/font.fnt", BitmapFont.class);
        manager.load(style + "pause_button.png", Texture.class);
        manager.load("dpad/up.png", Texture.class);
        manager.load("dpad/left.png", Texture.class);
        manager.load("dpad/right.png", Texture.class);
        manager.load("dpad/down.png", Texture.class);
        manager.load("dpad/up_down.png", Texture.class);
        manager.load("dpad/left_down.png", Texture.class);
        manager.load("dpad/right_down.png", Texture.class);
        manager.load("dpad/down_down.png", Texture.class);
        manager.load(style + "snake_head_texture.png", Texture.class);
        manager.load(style + "snake_body_texture.png", Texture.class);
        manager.load(style + "snake_end_texture.png", Texture.class);
        manager.load(style + "apple.png", Texture.class);
        manager.load(style + "timebomb.png", Texture.class);
        manager.load(style + "game_background.png", Texture.class);
        manager.load(style + "game_area.png", Texture.class);
        manager.load(style + "brick.png", Texture.class);
        waitForLoadingToComplete();
        textureHolder = new TextureHolder(
                manager.get("dpad/up.png", Texture.class),
                manager.get("dpad/down.png", Texture.class),
                manager.get("dpad/left.png", Texture.class),
                manager.get("dpad/right.png", Texture.class),
                manager.get("dpad/up_down.png", Texture.class),
                manager.get("dpad/left_down.png", Texture.class),
                manager.get("dpad/right_down.png", Texture.class),
                manager.get("dpad/down_down.png", Texture.class),
                manager.get(style + "pause_button.png", Texture.class),
                manager.get(style + "snake_head_texture.png", Texture.class),
                manager.get(style + "snake_body_texture.png", Texture.class),
                manager.get(style + "snake_end_texture.png", Texture.class),
                manager.get(style + "timebomb.png", Texture.class),
                manager.get(style + "apple.png", Texture.class),
                manager.get(style + "game_background.png", Texture.class),
                manager.get(style + "game_area.png", Texture.class),
                manager.get(style + "brick.png", Texture.class)
        );
    }

    public void loadGameOverAssets() {
        manager.clear();
        manager.load("fonts/font.fnt", BitmapFont.class);
        manager.load(style + "gameover_background.png", Texture.class);
        manager.load(style + "newgame_transparent.png", Texture.class);
        manager.load(style + "return_transparent.png", Texture.class);
        waitForLoadingToComplete();
        textureHolder = new TextureHolder(
                manager.get(style + "gameover_background.png", Texture.class),
                manager.get(style + "newgame_transparent.png", Texture.class),
                manager.get(style + "return_transparent.png", Texture.class)
        );
    }

    public void loadAboutAssets() {
        manager.clear();
        manager.load("fonts/font.fnt", BitmapFont.class);
        manager.load("menu/menu_background.png", Texture.class);
        manager.load("menu/return_button.png", Texture.class);
        waitForLoadingToComplete();
        textureHolder = new TextureHolder(
                manager.get("menu/menu_background.png", Texture.class),
                manager.get("menu/return_button.png", Texture.class)
        );
    }

    private void waitForLoadingToComplete() {
        while (!manager.update()) {
        }
    }

    @Override
    public void dispose() {
        manager.dispose();
    }
}
