package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.beben.simplesnake.Menu.MenuButton;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 09.08.16.
 */
public class GameInterface {

    private Stage stage;
    public DPad dPad;
    public MenuButton pauseButton;
    public MenuButton backButton;

    public GameInterface(Stage stage) {
        this.stage = stage;
        dPad = new DPad(stage);
        pauseButton = new MenuButton(stage, new Position(SnakeGame.V_WIDTH - 40, 8), "pause_button.png");
        backButton = new MenuButton(stage, new Position(8, 8), "back_button.png");
    }

    public void render() {
        stage.draw();
    }

}
