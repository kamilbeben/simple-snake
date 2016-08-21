package com.beben.simplesnake.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.beben.simplesnake.About.AboutText;
import com.beben.simplesnake.GameLogic.Position;
import com.beben.simplesnake.Menu.MenuButton;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 09.08.16.
 */
public class AboutScreen implements Screen { //TODO ABOUT

    private SnakeGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    public Stage stage;

    private Sprite background;
    private MenuButton buttonReturn;

    private AboutText text;

    public AboutScreen(SnakeGame game) {
        this.game = game;
        game.assets.loadAboutAssets();
        initializeBackground();
        initializeStage();
        initializeText();
        game.enableAndroidBackKey();
    }

    private void initializeBackground() {
        background = new Sprite(game.assets.textureHolder.about_BACKGROUND);
    }

    private void initializeStage() {
        camera = new OrthographicCamera(game.V_WIDTH, game.V_HEIGHT);
        camera.translate(camera.viewportWidth/2, camera.viewportHeight/2);
        viewport = new FitViewport(game.V_WIDTH, game.V_HEIGHT, camera);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        addActors();
    }

    private void addActors() {
        initializeReturnButton();
    }

    private void initializeReturnButton() {
        buttonReturn = new MenuButton(stage, new Position(8, 8),
                game.assets.textureHolder.about_button_RETURN);
    }



    public void handleUserInput() {

        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            game.setScreen(new MenuScreen(game));
            dispose();
        } else if (buttonReturn.isClicked()) {
            game.setScreen(new MenuScreen(game));
            dispose();
        }

    }

    @Override
    public void show() {

    }

    private void initializeText() {
        text = new AboutText(game.assets.manager.get("fonts/font.fnt", BitmapFont.class));
    }

    @Override
    public void render(float delta) {
        handleUserInput();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();

        background.draw(game.batch);
        text.render(game.batch);
        game.batch.end();

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
