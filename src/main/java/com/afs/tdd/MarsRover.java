package com.afs.tdd;

import java.util.Arrays;

public class MarsRover {
    private static final String HEADING_NORTH = "N";
    private static final String HEADING_SOUTH = "S";
    private static final String HEADING_EAST = "E";
    private static final String HEADING_WEST = "W";
    private static final String COMMAND_MOVE = "M";
    private static final String COMMAND_LEFT = "L";
    private static final String COMMAND_RIGHT = "R";
    private int locationX;
    private int locationY;
    private String heading;

    public MarsRover(int locationX, int locationY, String heading) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.heading = heading;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public String getHeading() {
        return heading;
    }

    public void executeCommands(String commands) throws CommandNotDefinedException {
        for (String command : Arrays.asList(commands.split(""))) {
            this.executeCommand(command);
        }
    }

    public void executeCommand(String command) throws CommandNotDefinedException {
        switch (command) {
            case COMMAND_MOVE:
                move();
                break;
            case COMMAND_LEFT:
                turnLeft();
                break;
            case COMMAND_RIGHT:
                turnRight();
                break;
            default:
                throw new CommandNotDefinedException("CommandNotDefinedException");
        }
    }

    private void turnRight() {
        switch (heading) {
            case HEADING_SOUTH:
                heading = HEADING_WEST;
                break;
            case HEADING_EAST:
                heading = HEADING_SOUTH;
                break;
            case HEADING_NORTH:
                heading = HEADING_EAST;
                break;
            case HEADING_WEST:
                heading = HEADING_NORTH;
                break;
        }
    }

    private void turnLeft() {
        switch (heading) {
            case HEADING_EAST:
                heading = HEADING_NORTH;
                break;
            case HEADING_SOUTH:
                heading = HEADING_EAST;
                break;
            case HEADING_WEST:
                heading = HEADING_SOUTH;
                break;
            case HEADING_NORTH:
                heading = HEADING_WEST;
                break;
        }
    }

    private void move() {
        switch (heading) {
            case HEADING_NORTH:
                locationY++;
                break;
            case HEADING_SOUTH:
                locationY--;
                break;
            case HEADING_EAST:
                locationX++;
                break;
            case HEADING_WEST:
                locationX--;
                break;
        }
    }
}