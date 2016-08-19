package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by bezik on 09.08.16.
 */
public class DPadArrow {

    private Button button;
    private Texture textureUp;
    private Texture textureDown;
    public boolean clicked = false;

    public DPadArrow(Stage stage, Position position, Texture textureUp, Texture textureDown) {
        this.textureUp = textureUp;
        this.textureDown = textureDown;
        setButtonStyleAndPosition( generateButtonSkinFromTexture(), position);
        setButtonListener();
        stage.addActor(button);
    }

    private Skin generateButtonSkinFromTexture() {
//        textureUp.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Skin skin = new Skin();
        skin.add("textureUp", textureUp);
        skin.add("textureDown", textureDown);
        return skin;
    }

    private void setButtonStyleAndPosition(Skin skin, Position position) {
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = skin.getDrawable("textureUp");
        style.down = skin.getDrawable("textureDown");

        button = new Button(style);

        button.setPosition(position.x, position.y);
        button.setWidth(textureUp.getWidth());
        button.setHeight(textureUp.getHeight());
    }

    private void setButtonListener() {
        button.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                clicked = true;
                return true;
            }
        });
    }

    public boolean isClicked() {
        if (clicked) {
            clicked = false;
            return true;
        } else return false;
    }
}
