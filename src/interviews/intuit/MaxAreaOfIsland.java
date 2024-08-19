package interviews.intuit;

public class MaxAreaOfIsland {
	public static void main(String args[]) {
		MaxAreaOfIsland obj = new MaxAreaOfIsland();
		int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		System.out.println(obj.maxAreaOfIsland(grid));
	}

	public int maxAreaOfIsland(int[][] grid) {
		boolean visited[][] = new boolean[grid.length][grid[0].length];
		int res = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					res = Math.max(res, dfs(i, j, grid, visited));
				}
			}
		}

		return res;
	}

	private int dfs(int i, int j, int[][] grid, boolean[][] visited) {
		visited[i][j] = true;
		int res = 1;

		int row[] = { 0, 0, 1, -1 };
		int col[] = { 1, -1, 0, 0 };

		for (int k = 0; k < 4; k++) {
			int curRow = i + row[k];
			int curCol = j + col[k];
			if (curRow >= 0 && curRow < grid.length && curCol >= 0 && curCol < grid[0].length
					&& grid[curRow][curCol] == 1 && !visited[curRow][curCol]) {
				res += dfs(curRow, curCol, grid, visited);
			}
		}
		return res;
	}
}
