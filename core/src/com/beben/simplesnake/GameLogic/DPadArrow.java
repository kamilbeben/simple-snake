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
    private Texture texture;
    public boolean clicked = false;

    public DPadArrow(Stage stage, Position position, Texture texture) {
        this.texture = texture;
        setButtonStyleAndPosition( generateButtonSkinFromTexture(), position);
        setButtonListener();
        stage.addActor(button);
    }

    private Skin generateButtonSkinFromTexture() {
//        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Skin skin = new Skin();
        skin.add("texture", texture);
        return skin;
    }

    private void setButtonStyleAndPosition(Skin skin, Position position) {
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = skin.getDrawable("texture");

        button = new Button(style);

        button.setPosition(position.x, position.y);
        button.setWidth(texture.getWidth());
        button.setHeight(texture.getHeight());
    }

    private void setButtonListener() {
        button.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                clicked = true;
                System.out.println("dPad Arrow");
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
