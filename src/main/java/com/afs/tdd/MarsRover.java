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
        if (command.equals(COMMAND_MOVE)){
            move();
        }
        else if (command.equals(COMMAND_LEFT)){
            turnLeft();
        }
        else if (command.equals(COMMAND_RIGHT)){
            turnRight();
        }
        else {
            throw new CommandNotDefinedException("CommandNotDefinedException");
        }
    }

    private void turnRight() {
        if (heading.equals(HEADING_SOUTH)){
            heading = HEADING_WEST;
        }
        else if (heading.equals(HEADING_EAST)){
            heading = HEADING_SOUTH;
        }
        else if (heading.equals(HEADING_NORTH)){
            heading = HEADING_EAST;
        }
        else if (heading.equals(HEADING_WEST)){
            heading = HEADING_NORTH;
        }
    }

    private void turnLeft() {
        if (heading.equals(HEADING_EAST)){
            heading = HEADING_NORTH;
        }
        else if (heading.equals(HEADING_SOUTH)){
            heading = HEADING_EAST;
        }
        else if (heading.equals(HEADING_WEST)){
            heading = HEADING_SOUTH;
        }
        else if (heading.equals(HEADING_NORTH)){
            heading = HEADING_WEST;
        }
    }

    private void move() {
        if (heading.equals(HEADING_NORTH)){
            locationY++;
        }
        else if (heading.equals(HEADING_SOUTH)){
            locationY--;
        }
        else if (heading.equals(HEADING_EAST)){
            locationX++;
        }
        else if (heading.equals(HEADING_WEST)){
            locationX--;
        }
    }
}