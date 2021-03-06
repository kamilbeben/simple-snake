package com.beben.simplesnake.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.beben.simplesnake.GameLogic.Apple;
import com.beben.simplesnake.GameLogic.GameState;
import com.beben.simplesnake.GameLogic.Map;
import com.beben.simplesnake.GameLogic.TimeBomb;
import com.beben.simplesnake.GameLogic.GameInterface;
import com.beben.simplesnake.GameLogic.GameText;
import com.beben.simplesnake.GameLogic.GameTheme;
import com.beben.simplesnake.GameLogic.Player;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 07.08.16.
 */
public class PlayScreen implements Screen {

    private SnakeGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;

    private GameTheme theme;
    private GameText text;
    private GameInterface gameInterface;

    private Map map;
    private Player player;
    private TimeBomb timeBomb;
    private Apple apple;

    private GameState state = new GameState();



    public PlayScreen(SnakeGame game) {
        this.game = game;
        initializeAssets();
        map = new Map(game);
        initializeStage();
        initializeDrawableElements();
        initializeGUI();
        game.enableAndroidBackKey();
    }

    private void initializeAssets() {
        game.assets.setStyle(game.config.theme.value);
        game.assets.loadGameAssets();
    }
    private void initializeStage() {
        camera = new OrthographicCamera(game.V_WIDTH, game.V_HEIGHT);
        camera.translate(camera.viewportWidth/2, camera.viewportHeight/2);
        viewport = new FitViewport(game.V_WIDTH, game.V_HEIGHT, camera);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
    }

    private void initializeDrawableElements() {
        player = new Player(game.assets.textureHolder, game.config.difficulty, game.config.map);
        apple = new Apple(game.assets.textureHolder.snack_APPLE);
        timeBomb = new TimeBomb(game.assets.textureHolder.snack_TIMEBOMB);
    }

    private void initializeGUI() {
        gameInterface = new GameInterface(stage, game.assets);
        theme = new GameTheme(game.assets.textureHolder);
        text = new GameText(game.assets.manager.get(
                "fonts/font.fnt", BitmapFont.class));
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        theme.draw(game.batch);
        game.batch.end();

        gameInterface.render();

        game.batch.begin();
        map.draw(game.batch);
        player.draw(game.batch);
        timeBomb.drawIfAlive(game.batch);
        apple.draw(game.batch);
        text.render(game.batch);

        game.batch.end();
    }

    private void update() {
        handleUserInput();
        text.update(player.getPlayerScore(), state);
        if (state.isContinue()) {
            timeBomb.update();
            player.update();
        }
        checkForCollisionsWithItself();
        checkForCollisionWithMap();
        checkForCollisionsWithSnacks();
    }

    private void checkForCollisionsWithItself() {
        if (player.isCollidingWithItself()) gameOver();
    }

    private void checkForCollisionWithMap() {
        if (map.isCollidingWith(player.getHeadPosition())) {
            gameOver();
        }

        if (map.isCollidingWith(apple.position)) {
            apple.randomizePosition();
        }

        if (map.isCollidingWith(timeBomb.position)) {
            timeBomb.randomizePosition();
        }
    }


    private void checkForCollisionsWithSnacks() {
        if (timeBomb.isAlive() && player.isCollidingWith(timeBomb)) {
            timeBomb.dissapear();
        }
        if (player.isCollidingWith(apple)) {
            apple.randomizePosition();
        }
    }


    private void gameOver() {
        game.setScreen(new GameOverScreen(game, player.getPlayerScore()));
        dispose();
    }


    private void handleUserInput() {

        if (gameInterface.dPad.right.isClicked()) {
            moveRight();
        }

        if (gameInterface.dPad.left.isClicked()) {
            moveLeft();
        }

        if (gameInterface.dPad.up.isClicked()) {
            moveUp();
        }

        if (gameInterface.dPad.down.isClicked()) {
            moveDown();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            game.setScreen(new MenuScreen(game));
            dispose();
        }

        if (gameInterface.pauseButton.isClicked()) {
            state.switchPause();
        } else if (state.isPause() && Gdx.input.justTouched()) {
            state.switchPause();
        }
    }

    private void moveRight() {
        if (player.direction != Player.DIRECTION.LEFT) {
            player.setDirection(Player.DIRECTION.RIGHT);
        }
    }

    private void moveLeft() {
        if (player.direction != Player.DIRECTION.RIGHT) {
            player.setDirection(Player.DIRECTION.LEFT);
        }
    }

    private void moveUp() {
        if (player.direction != Player.DIRECTION.DOWN) {
            player.setDirection(Player.DIRECTION.UP);
        }
    }

    private void moveDown() {
        if (player.direction != Player.DIRECTION.UP){
            player.setDirection(Player.DIRECTION.DOWN);
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
        text.dispose();
    }
}
