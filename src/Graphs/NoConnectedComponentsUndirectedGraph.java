package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

public class NoConnectedComponentsUndirectedGraph {
	public static void main(String args[]) {
		NoConnectedComponentsUndirectedGraph obj = new NoConnectedComponentsUndirectedGraph();
		int n = 5;
//		int edges[][] = {{0, 1}, {1, 2}, {3, 4}};
		int edges[][] = {{0, 1}, {1, 2}, {2,3}, {3, 4}};
		System.out.println(obj.countComponents(n, edges));
	}
	
	public int countComponents(int n, int [][] edges) {
		HashMap<Integer, List<Integer>> map = buildMap(n, edges);
		printMap(map);
		HashSet<Integer> visited = new HashSet<>();
		int compCount = 0;
		//dfs on every vertex
		for (int key : map.keySet()) {
			if (dfs(key, map, visited)) {
				compCount++;
			}
		}
		return compCount;
	}

	private boolean dfs(int key, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited) {
		if (visited.contains(key)) return false;
		visited.add(key);
		//dfs for every neighbor
		for (int neighbor : map.get(key)) {
			dfs(neighbor, map, visited);
		}
		
		return true;
	}

	private HashMap<Integer, List<Integer>> buildMap(int n, int[][] edges) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		//initialize every node
		for (int i =0; i< n; i++) {
			map.put(i, new ArrayList<>());
		}
		for (int i = 0; i< edges.length; i++) {
				map.get(edges[i][0]).add(edges[i][1]);
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
