package com.beben.simplesnake.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.beben.simplesnake.Menu.MenuButton;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 09.08.16.
 */
public class MenuScreen implements Screen {

    private SnakeGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    public Stage stage;


    private Sprite menuBackground;
    private static final int buttonSpacing = 16;
    private MenuButton buttonPlay;
    private MenuButton buttonOptions;
    private MenuButton infoButton;

    public MenuScreen(SnakeGame game) {
        this.game = game;

        menuBackground = new Sprite(new Texture("menu_background.png"));
        camera = new OrthographicCamera(game.V_WIDTH, game.V_HEIGHT);
        camera.translate(camera.viewportWidth/2, camera.viewportHeight/2);
        viewport = new FitViewport(game.V_WIDTH, game.V_HEIGHT, camera);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        initializeStage();
    }

    private void initializeStage() {
        buttonPlay = new MenuButton(stage, calculateButtonPositionY(1), "play_button.png");
        buttonOptions = new MenuButton(stage, calculateButtonPositionY(2), "options_button.png");
        infoButton = new MenuButton(stage);

    }

    private float calculateButtonPositionY(int buttonNumber) {
        return (SnakeGame.V_HEIGHT / 2) - buttonNumber * (buttonSpacing + MenuButton.buttonHeight);
    }

    public void handleUserInput() {
        if ( buttonPlay.clicked ) {
            game.setScreen(new PlayScreen(game));
            dispose();
        }
        if ( buttonOptions.clicked ) {
            game.setScreen(new OptionsScreen(game));
            dispose();
        }
        if ( infoButton.clicked ) {
            game.setScreen(new AboutScreen(game));
            dispose();
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        handleUserInput();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();

        menuBackground.draw(game.batch);

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
