package interviews.intuit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NoOfOpsToMakeNetworkConnected {
	public static void main(String arg[]) {
		NoOfOpsToMakeNetworkConnected obj = new NoOfOpsToMakeNetworkConnected();
		int n = 4, connections[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
		System.out.println(obj.makeConnected(n, connections));
	}

	public int makeConnected(int n, int[][] connections) {
		// if edges < vertex-1 can't connect
		if (connections.length < n-1)
			return -1;
		// Step 1: Build the adjacency list for the graph
		HashMap<Integer, List<Integer>> adjMap = populateMap(n, connections);
		boolean[] visited = new boolean[n];
		// Step 2: Count the number of connected components using DFS
		int component = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				component++;
				dfs(i, adjMap, visited);
			}
		}
		// Step 3: Calculate the minimum number of operations needed
		return component - 1;
	}

	private void dfs(int i, HashMap<Integer, List<Integer>> adjMap, boolean[] visited) {
		visited[i] = true;
		for (int neighbor : adjMap.get(i)) {
			if (!visited[neighbor]) {
				dfs(neighbor, adjMap, visited);
			}
		}
	}

	private HashMap<Integer, List<Integer>> populateMap(int n, int[][] connections) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		// initialze list for every vertex
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}

		// fill the map values
		for (int i = 0; i < connections.length; i++) {
			map.get(connections[i][0]).add(connections[i][1]);
			map.get(connections[i][1]).add(connections[i][0]);
		}
		return map;
	}

}


// if no of edges >= vertex-1, then we have enough edges to make the graph connected.
// now to identify minimum operations, all we have to do is find total components (islands) 
//and that  - 1 is min no of edges needed to make the graph connected