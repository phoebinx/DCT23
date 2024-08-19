package practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
	public static void main(String args[]) {
		PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();
		int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		List<List<Integer>> res = obj.pacificAtlantic(heights);
		for (List<Integer> list : res) {
			for (Integer num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		if (heights.length == 0)
			return null;
		boolean[][] dfsA = new boolean[heights.length][heights[0].length];
		boolean[][] dfsP = new boolean[heights.length][heights[0].length];
		List<List<Integer>> res = new ArrayList<>();

		// dfs for valid pacific and atlantic columns
		for (int i = 0; i < heights.length; i++) {
			dfsUtil(heights, i, 0, dfsP, Integer.MIN_VALUE);
			dfsUtil(heights, i, heights[0].length - 1, dfsA, Integer.MIN_VALUE);
		}

		// dfs for valid pacific and atlantic rows
		for (int j = 0; j < heights[0].length; j++) {
			dfsUtil(heights, 0, j, dfsP, Integer.MIN_VALUE);
			dfsUtil(heights, heights.length - 1, j, dfsA, Integer.MIN_VALUE);
		}

		// populate res

		for (int i = 0; i < heights.length; i++) {
			for (int j = 0; j < heights[0].length; j++) {
				if (dfsA[i][j] == true && dfsP[i][j] == true) {
					res.add(Arrays.asList(i, j));
				}
			}
		}

		return res;
	}

	private void dfsUtil(int[][] heights, int i, int j, boolean[][] visited, int prev) {
		if (i > heights.length - 1 || i < 0 || j > heights[0].length - 1 || j < 0 || visited[i][j]
				|| heights[i][j] < prev) {
			return;
		}
		visited[i][j] = true;
		int row[] = { 0, 0, 1, -1 };
		int col[] = { 1, -1, 0, 0 };
		for (int k = 0; k < 4; k++) {
			dfsUtil(heights, i + row[k], j + col[k], visited, heights[i][j]);
		}

	}
}
