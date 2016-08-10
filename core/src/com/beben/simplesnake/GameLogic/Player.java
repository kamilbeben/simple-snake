package com.beben.simplesnake.GameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.beben.simplesnake.*;
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
    private int points;
    private static final int moveDistance = 12;
    private List <Element> elementList;
    private List <Position> elementPastPosition;
    private boolean keepMoving;
    public boolean collidingWithWall;
    private Timer timer;
    private TextureHolder textureHolder;



    public Player(TextureHolder textureHolder) {
        this.textureHolder = textureHolder;
        timer = new Timer();
        points = 0;
        direction = DIRECTION.UP;
        initializeSnakeElements();
        keepMoving = true;
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
        timer.update();
        timer.increaseSpeedIfTimeIsRight(points);
        moveIfTimeIsRight();
    }

    private void moveIfTimeIsRight() {
        if (keepMoving && timer.isItTimeToMove()) move();
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
            System.out.println("Index out of bounds in Player.autoElementPastPositions()");
        }
    }


    private void autoSetPresentPositions() {

        try {
            for (int i=1; i<elementPastPosition.size(); i++) {
                elementList.get(i).setPositionAndRotation(elementPastPosition.get(i-1));
                changeTextureIfLast(i);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds in Player.autoSetPresentPositions()");
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
        points += 50;
        timer.startNitro();
    }

    public void eatApple() {
        addNewBodyElement();
        points += 10;
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
            System.out.println("ConcurrentModificationException in Player.checkIfCollidingWithAndEat(TimeBomb)");
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
            System.out.println("ConcurrentModificationException in Player.checkIfCollidingWithAndEat(Apple)");
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
            System.out.println("ConcurrentModificationException in Player.isCollidingWithItself()");
        }
        return false;
    }

    public void stopMoving() {
        keepMoving = false;
    }

    public void goThroughWall() {

        if (direction == DIRECTION.LEFT) {
            elementList.get(0).setX(SnakeGame.V_WIDTH - SnakeGame.BORDER);
        }

        if (direction == DIRECTION.RIGHT) {
            elementList.get(0).setX(SnakeGame.BORDER);
        }

        if (direction == DIRECTION.UP) {
            elementList.get(0).setY(SnakeGame.V_HEIGHT - SnakeGame.BORDER - SnakeGame.ARENA_WIDTH);
        }

        if (direction == DIRECTION.DOWN) {
            elementList.get(0).setY(SnakeGame.V_HEIGHT - SnakeGame.BORDER);
        }
    }

    public void setDirection(DIRECTION direction) {
        if (timer.isItTimeToChangeDirection()) {
            this.direction = direction;
        }
    }

    public boolean isCollidingWithWalls( ) {

        if (elementList.get(0).getX() < SnakeGame.BORDER) {
            collidingWithWall = true;
            return true;
        } else if (elementList.get(0).getX() > SnakeGame.V_WIDTH - 2 * SnakeGame.BORDER) {
            collidingWithWall = true;
            return true;
        } else if (elementList.get(0).getY() > SnakeGame.V_HEIGHT - 2 * SnakeGame.BORDER) {
            collidingWithWall = true;
            return true;
        } else if (elementList.get(0).getY() < SnakeGame.V_HEIGHT - SnakeGame.BORDER - SnakeGame.ARENA_WIDTH) {
            collidingWithWall = true;
            return true;
        }  else {
            collidingWithWall = false;
            return false;
        }
    }

    public int getPoints() {
        return points;
    }
}
