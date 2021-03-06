package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.beben.simplesnake.*;
import com.beben.simplesnake.Options.Difficulty;
import com.beben.simplesnake.Options.OptionsMap;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * Created by bezik on 04.08.16.
 */
public class Player {

    public enum DIRECTION {
        LEFT, RIGHT, UP, DOWN;
    }
    public DIRECTION direction;
    private static final int moveDistance = 12;

    private int playerScore;

    private List <Element> elementList;
    private List <Position> elementPastPosition;
    private Timer timer;
    private TextureHolder textureHolder;
    private boolean hardMode;



    public Player(TextureHolder textureHolder, Difficulty difficulty, OptionsMap map) {
        this.textureHolder = textureHolder;
        timer = new Timer(difficulty);
        hardMode = difficulty.isHard();
        playerScore = 0;
        if (map.isCage() || map.isEquation()) {
            direction = DIRECTION.RIGHT;
        } else if (map.isHeart()) {
            direction = DIRECTION.LEFT;
        } else {
            direction = DIRECTION.UP;
        }
        initializeSnakeElements();
    }

    private void initializeSnakeElements() {
        elementList = new ArrayList<Element>();
        elementPastPosition = new ArrayList<Position>();
        elementList.add(new Element(textureHolder));
        elementList.get(0).setPosition(SnakeGame.BORDER + 9 * moveDistance,
                SnakeGame.V_HEIGHT - SnakeGame.BORDER - 9 * moveDistance);
        elementPastPosition.add(new Position());
        addNewBodyElement();
        addNewBodyElement();
    }

    private void addNewBodyElement() {
        elementList.add(new Element(textureHolder));
        elementPastPosition.add(new Position());
    }

    public void update() {
        timer.update(playerScore);
        goingThroughWalls();
        moveIfTimeIsRight();
    }

    private void moveIfTimeIsRight() {
        if (timer.isItTimeToMove()) move();
    }

    private void move() {

        autoElementPastPositions();

        if (direction == DIRECTION.LEFT) {
            elementList.get(0).move( - moveDistance, 0);
            elementList.get(0).setRotation(90);
        }

        if (direction == DIRECTION.RIGHT) {
            elementList.get(0).move( moveDistance, 0);
            elementList.get(0).setRotation(-90);
        }

        if (direction == DIRECTION.UP) {
            elementList.get(0).move(0, moveDistance);
            elementList.get(0).setRotation(0);
        }

        if (direction == DIRECTION.DOWN) {
            elementList.get(0).move(0, - moveDistance);
            elementList.get(0).setRotation(180);
        }

        autoSetPresentPositions();

    }

    private void autoElementPastPositions() {
        try {
            for (int i = 0; i < elementPastPosition.size(); i++) {
                elementPastPosition.get(i).x = elementList.get(i).getX();
                elementPastPosition.get(i).y = elementList.get(i).getY();
                elementPastPosition.get(i).rotation = elementList.get(i).getRotation();
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }


    private void autoSetPresentPositions() {

        try {
            for (int i=1; i<elementPastPosition.size(); i++) {
                elementList.get(i).setPositionAndRotation(elementPastPosition.get(i-1));
                changeTextureIfLast(i);
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private void changeTextureIfLast(int i) {
        if (i == elementPastPosition.size() - 1) elementList.get(i).isLast(true);
        else elementList.get(i).isLast(false);
    }

    public void draw(Batch batch) {
        for (Element tmp : elementList) {
            tmp.draw(batch);
        }
    }

    public void eatTimeBomb() {
        addNewBodyElement();
        if (hardMode) {
            timer.startNitro();
            playerScore += 50;
        } else {
            playerScore += 30;
        }
    }

    public void eatApple() {
        addNewBodyElement();
        if (hardMode) {
            playerScore += 10;
        } else {
            playerScore += 7;
        }
    }

    public boolean isCollidingWith(TimeBomb timeBomb) {

        try {
            for (int i=0;i<elementList.size();i++) {
                if (elementList.get(i).isCollidingWith(timeBomb.position)) {
                    eatTimeBomb();
                    return true;
                }
            }
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isCollidingWith(Apple apple) {

        try {
            for (int i=0;i<elementList.size();i++) {
                if (elementList.get(i).isCollidingWith(apple.position)) {
                    eatApple();
                    return true;
                }
            }
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isCollidingWithItself() {
        try {
            for (int i=1; i<elementList.size();i++) {
                if (elementList.get(i).isCollidingWith(elementList.get(0).getPosition())) {
                    return true;
                }
            }
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }

    private void goThroughTopWall() {
        direction = DIRECTION.UP;
        elementList.get(0).setY(SnakeGame.V_HEIGHT - SnakeGame.BORDER - SnakeGame.ARENA_WIDTH);
    }

    private void goThroughBottomWall() {
        direction = DIRECTION.DOWN;
        elementList.get(0).setY(SnakeGame.V_HEIGHT - 3*SnakeGame.BORDER);
    }

    private void goThroughLeftWall() {
        direction = DIRECTION.LEFT;
        elementList.get(0).setX(SnakeGame.V_WIDTH - 3*SnakeGame.BORDER);
    }

    private void goThroughRightWall() {
        direction = DIRECTION.RIGHT;
        elementList.get(0).setX(SnakeGame.BORDER);
    }

    private void goingThroughWalls( ) {
        if (elementList.get(0).getX() == -SnakeGame.BORDER) {
            goThroughLeftWall();
        } else if (elementList.get(0).getX() == (SnakeGame.V_WIDTH - SnakeGame.BORDER)) {
            goThroughRightWall();
        } else if (elementList.get(0).getY() == (SnakeGame.V_HEIGHT - SnakeGame.BORDER)) {
            goThroughTopWall();
        } else if (elementList.get(0).getY() == (SnakeGame.V_HEIGHT - 3*SnakeGame.BORDER - SnakeGame.ARENA_WIDTH)) {
            goThroughBottomWall();
        }
    }

    public Position getHeadPosition() {
        return elementList.get(0).getPosition();
    }

    public int getPlayerScore() {
        return playerScore;
    }
}
