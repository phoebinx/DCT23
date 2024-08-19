package practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ValidTree {
	public static void main(String args[]) {
		ValidTree obj = new ValidTree();
		int n = 5;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		System.out.println(obj.validTree(n, edges));
	}

	public boolean validTree(int n, int[][] edges) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}
		// polulate
		for (int i = 0; i < edges.length; i++) {
			map.get(edges[i][0]).add(edges[i][1]);
			map.get(edges[i][1]).add(edges[i][0]); // for undirected graph
		}

		HashSet<Integer> visited = new HashSet<>();
		if (!dfs(0, -1, map, visited))
			return false;
		return (visited.size() == n);
	}

	private boolean dfs(int node, int parent, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited) {
		if (visited.contains(node)) return false; //cycle
		visited.add(node);
		for (int neighbor: map.get(node)) {
			if (neighbor == parent) continue; //don't backtrack
			if (!dfs(neighbor, node, map, visited))
				return false;
		}
		return true;
	}
}
