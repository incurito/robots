package com.test.robots;

import com.test.robots.Util.RobotOperations;
import com.test.robots.bean.Direction;
import com.test.robots.bean.Position;

/**
 * This class is the implementation of a ground robot.
 *
 * @author Ajay Sridharan
 */
public class GroundRobot implements Robot {
    private Position position;
    private Direction direction;
    private final RobotOperations operations;

    public GroundRobot(Position position, Direction direction, RobotOperations operations) {
        this.position = position;
        this.direction = direction;
        this.operations = operations;
    }

    @Override
    public void turnRight() {
        direction = operations.getTurnDirection(direction, true);
    }

    @Override
    public void turnLeft() {
        direction = operations.getTurnDirection(direction, false);
    }

    @Override
    public void moveForward() {
        if (direction.equals(Direction.N) || direction.equals(Direction.S)) {
            position.setY(operations.moveInGround(position.getY(), true));
        }
        if (direction.equals(Direction.W) || direction.equals(Direction.E)) {
            position.setX(operations.moveInGround(position.getX(), true));
        }
    }

    @Override
    public void moveBackward() {
        if (direction.equals(Direction.N) || direction.equals(Direction.S)) {
            position.setY(operations.moveInGround(position.getY(), false));
        }
        if (direction.equals(Direction.W) || direction.equals(Direction.E)) {
            position.setX(operations.moveInGround(position.getX(), false));
        }
    }

    @Override
    public void moveHigher() {}

    @Override
    public void moveLower() {}

    @Override
    public String getPosition() {
        return "position is: " + position.toString() + " and direction is " + direction;
    }
}
