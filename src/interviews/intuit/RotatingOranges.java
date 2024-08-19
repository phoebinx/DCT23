package interviews.intuit;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class RotatingOranges {
	public static void main(String args[]) {
		RotatingOranges obj = new RotatingOranges();
//		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int grid[][] = {{1,2}};
		System.out.println(obj.orangesRotting(grid));
	}

	public int orangesRotting(int[][] grid) {
		int freshOranges = 0;
		int minPassed = 0;

		Queue<int[]> queue = new LinkedList<>();
		// calculate number of fresh oranges, add rest to the queue
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 2)
					queue.offer(new int[] { i, j });
				else if (grid[i][j] == 1)
					freshOranges++;
			}
		}
		if (freshOranges == 0)
			return 0;
		int rows[] = { 0, 0, 1, -1 };
		int cols[] = { 1, -1, 0, 0 };

		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean foundFresh = false;
			for (int i = 0; i < size; i++) {
				int cur[] = queue.poll();
				// visit its neighbors
				for (int k = 0; k < 4; k++) {
					int row = cur[0] + rows[k];
					int col = cur[1] + cols[k];
					if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) 
						continue;
					if (grid[row][col] == 1) {
						queue.offer(new int[] { row, col });
						grid[row][col] = 2;
						freshOranges--;
						foundFresh = true;
					}
				}
			}
			if (foundFresh == true)
				minPassed++;
		}
		return (freshOranges != 0 ? -1 : minPassed);
	}

}
