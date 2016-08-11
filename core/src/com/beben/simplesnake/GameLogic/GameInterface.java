package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.beben.simplesnake.Assets;
import com.beben.simplesnake.Menu.MenuButton;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 09.08.16.
 */
public class GameInterface {

    private Stage stage;
    public DPad dPad;
    public MenuButton pauseButton;

    public GameInterface(Stage stage, Assets assets) {
        this.stage = stage;
        dPad = new DPad(stage, assets);
        pauseButton = new MenuButton(stage, new Position(SnakeGame.V_WIDTH - 40, 8),
                assets.textureHolder.button_PAUSE);
    }

    public void render() {
        stage.draw();
    }

}
