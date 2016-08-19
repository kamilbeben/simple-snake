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
import com.beben.simplesnake.GameLogic.GameOver.GameOverText;
import com.beben.simplesnake.GameLogic.Position;
import com.beben.simplesnake.Menu.MenuButton;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 16.08.16.
 */
public class GameOverScreen implements Screen {

    private SnakeGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    public Stage stage;

    private Sprite menuBackground;
    private MenuButton buttonNewGame;
    private MenuButton buttonReturn;

    private GameOverText gameOverText;
    private Float timer;

    public GameOverScreen(SnakeGame game, int playerScore) {
        timer = 0f;
        this.game = game;
        game.assets.loadGameOverAssets();
        gameOverText = new GameOverText(game.assets.manager.get("fonts/font_pixeled_gradient_lightgrey.fnt",
                BitmapFont.class), playerScore, game.config.map.getMapNameString());
        menuBackground = new Sprite(game.assets.textureHolder.over_BACKGROUND);
        initializeStage();
        vibrateIfEnabled();
        game.enableAndroidBackKey();
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
        buttonNewGame = new MenuButton(stage, new Position(0, SnakeGame.V_HEIGHT/2),
                game.assets.textureHolder.over_NEWGAME);

        buttonReturn = new MenuButton(stage, new Position(0, 0),
                game.assets.textureHolder.over_RETURN);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        timer += Gdx.graphics.getDeltaTime();
        if (secondsPassed(1.5f)) { //put in constructor?
            handleUserInput();
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();

        menuBackground.draw(game.batch);
        gameOverText.render(game.batch);
        game.batch.end();
        stage.draw();
    }

    private boolean secondsPassed(float toPass) {
        if (timer > toPass) {
            return true;
        } else return false;
    }

    private void handleUserInput() {
        if (buttonNewGame.isClicked()) {
            game.setScreen(new PlayScreen(game));
            dispose();
        } else if (buttonReturn.isClicked()) {
            game.setScreen(new MenuScreen(game));
            dispose();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            game.setScreen(new MenuScreen(game));
            dispose();
        }

    }

    private void vibrateIfEnabled() {
        if (game.config.vibrations == true) {
            Gdx.input.vibrate(600);
        }
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
