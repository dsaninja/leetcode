package com.dsaninja.lc.recursionII;

import java.util.HashSet;
import java.util.Set;

/**
 * Use the robot to clean the entire room (i.e., clean every empty cell in the room).
 * The robot with the four given APIs can move forward, turn
 * left, or turn right. Each turn is 90 degrees.
 *
 * <a href="https://leetcode.com/problems/robot-room-cleaner/">Problem-489</a>
 */
public class RobotRoomCleaner{
    // Up, Right, Down, Left
    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    private final int[][] DIRECTIONS = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private final Set<Pair> visited = new HashSet<>();

    public void cleanRoom(Robot robot) {
        dfs(0, 0, robot, 0);
    }
    private void dfs(int row, int col, Robot robot, int arrow){
        Pair entry = new Pair(row, col);

        if(!visited.contains(entry)){
            visited.add(entry);

            robot.clean();

            for(int i = 0; i < 4; i++){
                if(robot.move()){
                    int[] curDirection = DIRECTIONS[arrow];
                    dfs(row + curDirection[0], col + curDirection[1], robot, arrow);
                }
                //Change robot direction and arrow
                robot.turnRight();//turn clock wise
                arrow = (arrow + 1) % 4;
            }
        }
        //Move Back
        moveBack(robot);
    }
    private void moveBack(Robot robot){
        //Turn 180 degree back
        robot.turnLeft();
        robot.turnLeft();

        robot.move();

        //Turn back the original direction
        robot.turnRight();
        robot.turnRight();
    }

    private record Pair(int row, int col){}

    private interface Robot{
        // returns true if next cell is open and robot moves into the cell.
        // returns false if next cell is obstacle and robot stays on the current cell.
        boolean move();

        // Robot will stay on the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft();

        void turnRight();

        // Clean the current cell.
        void clean();
    }
}
