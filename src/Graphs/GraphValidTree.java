package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

public class GraphValidTree {
	public static void main(String args[]) {
		GraphValidTree obj = new GraphValidTree();
		int n = 5;
//		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		int [][] edges = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
		System.out.println(obj.isValidTree(n, edges));
	}

	private boolean isValidTree(int n, int[][] edges) {
		HashMap<Integer, List<Integer>> map = buildTree(n, edges);
		printMap(map);
		Set<Integer> visited = new HashSet<>();
		Set<Integer> recStack = new HashSet<>();
		if (!dfs(0, -1, map, visited))
				return false;
		return visited.size() == n; // all nodes must be visited 
	}

	private boolean dfs(int i, int parent, HashMap<Integer, List<Integer>> map, Set<Integer> visited) {
		if (visited.contains(i)) return false;
		visited.add(i);
		
		for (int neighbor: map.get(i) ) {
			if (neighbor == parent) continue;
			if (!dfs(neighbor, i, map, visited))
				return false;
		}
		return true;
	}

	private HashMap<Integer, List<Integer>> buildTree(int n, int[][] edges) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++)
			map.put(i, new ArrayList<Integer>());
		for (int i = 0; i < edges.length; i++) {
			map.get(edges[i][0]).add(edges[i][1]);
			map.get(edges[i][1]).add(edges[i][0]); // for undirected graph
		}
			return map;
	}
	
	private void printMap(HashMap<Integer, List<Integer>> map) {
		for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
			System.out.print("key:"+entry.getKey()+" Values: ");
			for (int value:entry.getValue()) 
				System.out.print(value+" ");
			System.out.println();
		}
	}
}
