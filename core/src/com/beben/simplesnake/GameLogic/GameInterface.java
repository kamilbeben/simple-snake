package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.scenes.scene2d.Stage;
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
    public MenuButton returnButton;

    public GameInterface(Stage stage, Assets assets) {
        this.stage = stage;
        dPad = new DPad(stage, assets);
        pauseButton = new MenuButton(stage, new Position(SnakeGame.V_WIDTH - 40, 8),
                assets.textureHolder.game_button_PAUSE);
        returnButton = new MenuButton(stage, new Position(8, 8),
                assets.textureHolder.game_button_RETURN);
    }

    public void render() {
        stage.draw();
    }

}
