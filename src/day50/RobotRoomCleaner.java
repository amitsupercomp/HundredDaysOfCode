package day50;
import java.util.*;

import javafx.util.Pair;

interface Robot {
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

public class RobotRoomCleaner {

	int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	Set<Pair<Integer, Integer>> visited = new HashSet<>();
	Robot robot;
	
	public void cleanRoom(Robot robot) {
		this.robot = robot;
		backtrack(0, 0, 0);
	}

	public void goBack() {
		robot.turnRight();
		robot.turnRight();
		robot.move();
		robot.turnRight();
		robot.turnRight();
	}

	public void backtrack(int row, int col, int d) {
		visited.add(new Pair(row, col));
		robot.clean();
		for (int i = 0; i < 4; ++i) {
			int newD = (d + i) % 4;
			int newRow = row + directions[newD][0];
			int newCol = col + directions[newD][1];

			if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
				backtrack(newRow, newCol, newD);
				goBack();
			}
			robot.turnRight();
		}
	}


}
