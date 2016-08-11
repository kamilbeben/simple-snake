package com.beben.simplesnake.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.beben.simplesnake.Menu.MenuButton;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 09.08.16.
 */
public class OptionsScreen implements Screen { //TODO OPTIONS

    private SnakeGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    public Stage stage;
    private Sprite background;
    private MenuButton buttonVibrations;


    public OptionsScreen(SnakeGame game) {
        this.game = game;
        game.assets.loadOptionsAssets();
        background = new Sprite(game.assets.textureHolder.options_BACKGROUND);
        initializeStage();
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
        buttonVibrations = new MenuButton(stage, 300,
                game.assets.textureHolder.options_VIBRATION_ON);
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
        background.draw(game.batch);
        game.batch.end();
        stage.draw();
    }

    public void handleUserInput() {
        if ( buttonVibrations.isClicked() ) {
            switchVibrations();
        }
    }
    
    private void switchVibrations() { //TODO LOAD DEFAULT ICON IN DEPENDENCE OF GAME.CONFIG.VIBRATION
        System.out.println("Switch");
        if ( game.config.vibrations ) {
            buttonVibrations.setTexture(stage, game.assets.textureHolder.options_VIBRATION_OFF);
        } else {
            buttonVibrations.setTexture(stage, game.assets.textureHolder.options_VIBRATION_ON);
        }
        game.config.switchVibrations();
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
