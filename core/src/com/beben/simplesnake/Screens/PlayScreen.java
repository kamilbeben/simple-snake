package com.beben.simplesnake.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
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
    public Stage stage;

    public GameTheme theme;
    private GameText gameText;
    private GameInterface gameInterface;

    private Player player;
    private TimeBomb timeBomb;

    private float timeHelper;
    private float timeBombLifeTime;
    private boolean gameIsNotOverYet;



    public PlayScreen(SnakeGame game) {
        this.game = game;
        camera = new OrthographicCamera(game.V_WIDTH, game.V_HEIGHT);
        camera.translate(camera.viewportWidth/2, camera.viewportHeight/2);
        viewport = new FitViewport(game.V_WIDTH, game.V_HEIGHT, camera);

        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        gameInterface = new GameInterface(stage);

        timeBombLifeTime = 0;
        theme = new GameTheme();
        player = new Player();
        timeBomb = new TimeBomb();
        gameText = new GameText();
        gameIsNotOverYet = true;

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
        player.draw(game.batch);
        timeBomb.draw(game.batch);
        gameText.render(game.batch);
        game.batch.end();
        gameInterface.render();
    }

    private void update() {
        timeHelper += Gdx.graphics.getDeltaTime();
        gameText.update(player.getPoints(), gameIsNotOverYet);
        cherryLifeTimer();
        player.update();
        checkForCollisionsWithItself();
        checkForCollisionsWithWalls();
        checkForCollisionsWithTimeBomb();
        handleUserInput();
    }

    private void checkForCollisionsWithItself() {
        if (player.isCollidingWithItself()) gameOver();
    }

    private void checkForCollisionsWithWalls() {
        if (player.isCollidingWithWalls()) {
            if (game.config.walls == true) {
                gameOver();
            } else if (game.config.walls == false) {
                player.goThroughWall();
            }
        }
    }

    private void checkForCollisionsWithTimeBomb() {
        if (player.checkIfCollidingWith(timeBomb)) {
            timeBomb.randomizePosition();
            timeBombLifeTime = 0;
        }
    }

    private void cherryLifeTimer() {
        if (gameIsNotOverYet) {
            timeBombLifeTime += Gdx.graphics.getDeltaTime();
            if (timeBombLifeTime > timeBomb.lifeTime()) {
                timeBomb.randomizePosition();
                timeBombLifeTime = 0;
            }
        }
        setCherryTransparency();
    }

    private void setCherryTransparency() {
        if (timeBombLifeTime < timeBomb.lifeTime() / 2)       timeBomb.setAlpha(1);
        else if (timeBombLifeTime < timeBomb.lifeTime() / 1.5)  timeBomb.setAlpha(0.5f);
    }

    private void gameOver() {
        player.stopMoving();
        gameIsNotOverYet = false;
        if (Gdx.input.justTouched()) {
            game.setScreen(new PlayScreen(game));
            dispose();
        }
        //TODO - vibrations?
    }

    private void handleUserInput() {

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || gameInterface.dPad.right.isClicked()) {
            moveRight();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || gameInterface.dPad.left.isClicked()) {
            moveLeft();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP) || gameInterface.dPad.up.isClicked()) {
            moveUp();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || gameInterface.dPad.down.isClicked()) {
            moveDown();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.BACKSPACE) || gameInterface.backButton.isClicked()) {
            game.setScreen(new MenuScreen(game));
            try {
                dispose();
            } catch (IllegalArgumentException e) {
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.P) || gameInterface.pauseButton.isClicked()) {
            pauseGame();
        }

    }

    private void pauseGame() {

    }

    private void moveRight() {
        if (player.direction != Player.DIRECTION.LEFT
                && !player.collidingWithWall) {
            player.setDirectionAndCheckTime(com.beben.simplesnake.GameLogic.Player.DIRECTION.RIGHT, timeHelper);
        }
    }

    private void moveLeft() {
        if (player.direction != Player.DIRECTION.RIGHT
                && !player.collidingWithWall) {
            player.setDirectionAndCheckTime(com.beben.simplesnake.GameLogic.Player.DIRECTION.LEFT, timeHelper);
        }
    }

    private void moveUp() {
        if (player.direction != Player.DIRECTION.DOWN
                && !player.collidingWithWall) {
            player.setDirectionAndCheckTime(com.beben.simplesnake.GameLogic.Player.DIRECTION.UP, timeHelper);
        }
    }

    private void moveDown() {
        if (player.direction != Player.DIRECTION.UP
                && !player.collidingWithWall){
            player.setDirectionAndCheckTime(Player.DIRECTION.DOWN, timeHelper);
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
