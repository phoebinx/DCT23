package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticFlow {
	public static void main(String args[]) {
		PacificAtlanticFlow obj = new PacificAtlanticFlow();
		int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		for (List<Integer> list : obj.pacificAtlantic(heights)) {
			for (int i:list)
				System.out.print(i+" ");
			System.out.println();
		}
	}

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		if (heights.length == 0) return null;
		List<List<Integer>> result = new ArrayList<>();
		boolean [][] dfsP = new boolean[heights.length][heights[0].length];
		boolean [][] dfsA = new boolean[heights.length][heights[0].length]; 
		
		
		//dfs for valid atlantic and pacific coordinates
		// iterating rows // col=0 & n-1
		for (int i = 0; i<heights.length;i++) {
			pacificAtlanticUtil(heights, dfsP, i, 0, Integer.MIN_VALUE);
			pacificAtlanticUtil(heights, dfsA, i, heights[0].length-1, Integer.MIN_VALUE);
		}
		
		// iterating cols // row=0 & m-1
		for (int j = 0; j<heights[0].length;j++) {
			pacificAtlanticUtil(heights, dfsP, 0, j, Integer.MIN_VALUE);
			pacificAtlanticUtil(heights, dfsA, heights.length-1, j, Integer.MIN_VALUE);
		}
		
		//add dfsA && dfsP's to results
		for (int i = 0; i <heights.length; i++) {
			for (int j = 0; j<heights[i].length; j++) {
				if (dfsA[i][j] && dfsP[i][j]) {
					ArrayList<Integer> list = new ArrayList<>(Arrays.asList(i, j));
					result.add(list);
				}
			}
		}
		
		return result;
	}
	
	private void pacificAtlanticUtil(int [][] heights, boolean[][] visited, int x, int y, int prev) {
		if (x>= heights.length || x<0 || y>=heights[0].length || y<0 || visited[x][y]|| heights[x][y] < prev )
			return;
		visited[x][y] = true;
		prev = heights[x][y];
		int row[] = { 0, 0, 1, -1 };
		int col[] = { -1, 1, 0, 0 };
		for (int i = 0; i<4; i++) {
			pacificAtlanticUtil(heights, visited, x+row[i], y+col[i], prev);
		}
	}
}
