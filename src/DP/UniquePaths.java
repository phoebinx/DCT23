package DP;

public class UniquePaths {
	public static void main(String args[]) {
		UniquePaths obj = new UniquePaths();
		int m = 3, n = 7;
		System.out.println(obj.uniquePaths(m, n));
	}

	public int uniquePaths(int m, int n) {
		int grid[][] = new int[m][n];
		
		// Initialize last row and last column
        for (int i = 0 ; i <m ; i++) {
			grid[i][n-1] = 1;
		}
		for (int j = 0; j<n ; j++) {
			grid[m-1][j] = 1; 
		}
		
		// Fill the rest of the grid
		for (int i = m-2; i>=0; i--) {
			for (int j = n-2; j>=0; j--) {
				grid[i][j] = grid[i+1][j] + grid[i][j+1];
			}
		}
		return grid[0][0];
	}
}
