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
    private float lastDirectionChange;
    private float speed;
    private int points;
    private static final int moveDistance = 12;
    private List <Element> elementList;
    private List <Position> elementPastPosition;
    private float timeHelper;
    private boolean keepMoving;
    public boolean collidingWithWall;



    public Player() {
        lastDirectionChange = 0;
        points = 0;
        speed = 0.1f;
        direction = DIRECTION.UP;
        initializeSnakeElements();
        keepMoving = true;
    }

    private void initializeSnakeElements() {
        elementList = new ArrayList<Element>();
        elementPastPosition = new ArrayList<Position>();
        elementList.add(new Element());
        elementList.get(0).setPosition(SnakeGame.BORDER + 9 * moveDistance,
                SnakeGame.V_HEIGHT - SnakeGame.BORDER - 9 * moveDistance);
        elementPastPosition.add(new Position());
        addNewBodyElement();
        addNewBodyElement();
    }

    private void addNewBodyElement() {
        elementList.add(new Element());
        elementPastPosition.add(new Position());
    }

    public void update() {
        increaseSpeedIfTimeIsRight();
        moveIfTimeIsRight();
    }

    private void increaseSpeedIfTimeIsRight() { // 0.1f
        if (points < 50) speed = 0.1f;
        else if (points < 100) speed = 0.090f;
        else if (points < 150) speed = 0.080f;
        else if (points < 200) speed = 0.075f;
        else if (points < 250) speed = 0.070f;
        else if (points < 300) speed = 0.065f;
        else if (points < 350) speed = 0.060f;
        else if (points < 400) speed = 0.055f;
        else if (points < 500) speed = 0.050f;
    }

    private void moveIfTimeIsRight() {
        timeHelper += Gdx.graphics.getDeltaTime();
        if (timeHelper > speed) {
            if (keepMoving) move();
            timeHelper = 0;
        }
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
        nitro();

    }

    private void nitro() {
        //TODO nitro for 1 seconds
    }

    public boolean checkIfCollidingWith(TimeBomb timeBomb) {

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

    public void setDirectionAndCheckTime(DIRECTION destination, float timer) {

        if (timer - lastDirectionChange > speed + 0.05) {
            direction = destination;
            lastDirectionChange = timer;
        }

    }
}
