package com.beben.simplesnake.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 09.08.16.
 */
public class AboutScreen implements Screen { //TODO ABOUT

    private SnakeGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    public Stage stage;


    public AboutScreen(SnakeGame game) {
        this.game = game;

        camera = new OrthographicCamera(game.V_WIDTH, game.V_HEIGHT);
        camera.translate(camera.viewportWidth/2, camera.viewportHeight/2);
        viewport = new FitViewport(game.V_WIDTH, game.V_HEIGHT, camera);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        initializeStage();
    }

    private void initializeStage() {

    }


    public void handleUserInput() { //TODO USER INPUT

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        handleUserInput();

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();

        stage.draw();

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
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
