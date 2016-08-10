package com.beben.simplesnake.Menu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.beben.simplesnake.GameLogic.Position;
import com.beben.simplesnake.Screens.PlayScreen;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 08.08.16.
 */
public class MenuButton {

    public static final int buttonHeight = 32;
    private Button button;
    private Texture texture;
    public boolean clicked = false;

    public MenuButton(Stage stage, Position position, Texture texture) {
        this.texture = texture;
        setMenuButtonStyleAndPosition( generateButtonSkinFromFile(), position);
        setButtonListener();
        stage.addActor(button);
    }

    public MenuButton(Stage stage, float positionY, Texture texture) {
        this.texture = texture;
        setMenuButtonStyleAndPosition( generateButtonSkinFromFile(), positionY);
        setButtonListener();
        stage.addActor(button);
    }

    public MenuButton(Stage stage, Texture texture) {
        this.texture = texture;
        setInfoButtonStyleAndPosition( generateButtonSkinFromFile() );
        setButtonListener();
        stage.addActor(button);
    }

    private void setButtonListener() {
        button.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                clicked = true;
                return true;
            }
        });
    }

    private void setMenuButtonStyleAndPosition(Skin skin, float positionY) {
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = skin.getDrawable("texture");

        button = new Button(style);

        button.setPosition((SnakeGame.V_WIDTH / 2) - (texture.getWidth() / 2), positionY);
        button.setWidth(texture.getWidth());
        button.setHeight(texture.getHeight());
    }

    private void setMenuButtonStyleAndPosition(Skin skin, Position position) {
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = skin.getDrawable("texture");

        button = new Button(style);

        button.setPosition(position.x, position.y);
        button.setWidth(texture.getWidth());
        button.setHeight(texture.getHeight());
    }

    private Skin generateButtonSkinFromFile() {
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        Skin skin = new Skin();
        skin.add("texture", texture);
        return skin;
    }

    private void setInfoButtonStyleAndPosition(Skin skin) {
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = skin.getDrawable("texture");

        button = new Button(style);

        button.setPosition(SnakeGame.V_WIDTH - texture.getWidth() - 4, SnakeGame.V_HEIGHT - texture.getHeight() - 4);
        button.setWidth(texture.getWidth());
        button.setHeight(texture.getHeight());
    }

    public boolean isClicked() {
        if (clicked) {
            clicked = false;
            return true;
        } else return false;
    }

}
