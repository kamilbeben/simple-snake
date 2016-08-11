package com.beben.simplesnake.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.beben.simplesnake.GameLogic.Position;
import com.beben.simplesnake.Menu.MenuButton;
import com.beben.simplesnake.SnakeGame;

/**
 * Created by bezik on 09.08.16.
 */
public class OptionsScreen implements Screen { //TODO OPTIONS

    private SnakeGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;

    private Sprite background;
    private Sprite stylePreview;
    private Sprite mapPreview;

    private MenuButton buttonVibrations;
    private MenuButton buttonSwitchRight;
    private MenuButton buttonSwitchLeft;


    public OptionsScreen(SnakeGame game) {
        this.game = game;
        game.assets.loadOptionsAssets();
        initializeSprites();
        initializeStage();
    }

    private void initializeSprites() {
        background = new Sprite(game.assets.textureHolder.options_BACKGROUND);
        initializeStylePreview();
        initializeMapPreview();
    }

    private void initializeStylePreview() {
        float position_y = 200;
        if (game.config.isDefault()) {
            stylePreview = new Sprite(game.assets.textureHolder.options_stylePreview_DEFAULT);
        } else {
            stylePreview = new Sprite(game.assets.textureHolder.options_stylePreview_MODERN);
        }
        stylePreview.setPosition((SnakeGame.V_WIDTH/2) - (stylePreview.getWidth()/2),
                position_y);
    }

    private void initializeMapPreview() {

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
        initializeVibrationButton();
        initializeSwitchStyleButtons();
    }

    private void initializeVibrationButton() {
        float position_y = 300;
        if (game.config.vibrations) {
            buttonVibrations = new MenuButton(stage, position_y,
                    game.assets.textureHolder.options_VIBRATION_ON);
        } else {
            buttonVibrations = new MenuButton(stage, position_y,
                    game.assets.textureHolder.options_VIBRATION_OFF);
        }
    }

    private void initializeSwitchStyleButtons() {
        float spacing = 2;

        buttonSwitchRight = new MenuButton(stage, new Position(
                stylePreview.getX() + stylePreview.getWidth() + spacing,
                stylePreview.getY()),
                game.assets.textureHolder.options_switch_RIGHT);

        buttonSwitchLeft = new MenuButton(stage, new Position(
                stylePreview.getX() - spacing - game.assets.textureHolder.options_switch_RIGHT.getWidth(),
                stylePreview.getY()),
                game.assets.textureHolder.options_switch_LEFT);
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
        stylePreview.draw(game.batch);
        game.batch.end();
        stage.draw();
    }

    public void handleUserInput() {
        if ( buttonVibrations.isClicked() ) {
            switchVibrations();
        }
    }

    private void switchVibrations() { //TODO LOAD DEFAULT ICON IN DEPENDENCE OF GAME.CONFIG.VIBRATION
        if ( game.config.vibrations ) {
            buttonVibrations.setTexture(stage, game.assets.textureHolder.options_VIBRATION_OFF);
        } else {
            buttonVibrations.setTexture(stage, game.assets.textureHolder.options_VIBRATION_ON);
        }
        game.config.switchVibrations();
        System.out.println(game.config.vibrations);
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
