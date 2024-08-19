package Graphs;

public class NumberOfIslands {
	public static void main(String args[]) {
		NumberOfIslands obj = new NumberOfIslands();
		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(obj.numIslands(grid));
	}

	public int numIslands(char[][] grid) {
		int result = 0;
		if (grid.length == 0) return result;
		boolean visited[][] = new boolean[grid.length][grid[0].length];
		
		for (int i = 0; i<grid.length; i++) {
			for (int j = 0; j< grid[i].length; j++) {
				if (dfs(grid, visited, i, j)) {
					result++;
				}
			}
		}
		return result;
	}
	
	private boolean dfs(char[][] grid, boolean[][] visited, int i, int j) {
		if (visited[i][j] || grid[i][j] == '0') return false;
		int row[] = {0,0,1,-1};
		int col[] = {1,-1,0,0};
		visited[i][j] = true;
		for (int k = 0; k<4; k++) {
			if (dfsUtil(grid, visited, i+row[k], j+col[k])) {
				dfs(grid, visited, i+row[k], j+col[k]);
			}
		}
		return true;
	}
	
	private boolean dfsUtil(char[][] grid, boolean[][] visited, int i, int j) {
		if (i>=0 && i <grid.length && j>=0 && j<grid[0].length)
			return true;
		return false;
	}
	
	
}
