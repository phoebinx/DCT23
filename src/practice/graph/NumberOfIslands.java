package practice.graph;

public class NumberOfIslands {
	public static void main(String args[]) {
		NumberOfIslands obj = new NumberOfIslands();
		char grid[][] = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(obj.numIslands(grid));
	}

	public int numIslands(char[][] grid) {
		int n = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (!visited[i][j]  && grid[i][j] == '1' && dfs(i, j, grid, visited)) {
					n++;
				}
			}
		}
		return n;
	}

	private boolean dfs(int i, int j, char[][] grid, boolean[][] visited) {
		if (visited[i][j] || grid[i][j] == '0')
			return false;
		visited[i][j] = true;
		int row[] = { 0, 0, -1, 1 };
		int col[] = { 1, -1, 0, 0 };
		for (int k = 0; k < 4; k++) {
			if (isValid(i + row[k], j + col[k], grid)) {
				dfs(i + row[k], j + col[k], grid, visited);
			}
		}
		return true;
	}

	private boolean isValid(int i, int j, char[][] grid) {
		if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0)
			return false;
		return true;
	}
}
