package practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
	public static void main(String args[]) {
		CloneGraph obj = new CloneGraph();
		int adjList[][] = { { 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } };
		Node node = obj.buildGraphFromAdjList(adjList);
		obj.cloneGraph(node);
		System.out.println("Graph cloned successfully.");
	}

	private Node buildGraphFromAdjList(int[][] adjList) {
		if (adjList.length == 0)
			return null;
		// map to hold all nodes and corresponding index
		HashMap<Integer, Node> listMap = new HashMap<>();
		for (int i = 1; i <= adjList.length; i++) {
			listMap.put(i, new Node(i));
		}

		for (int i = 0; i < adjList.length; i++) {
			List<Node> neighbors = listMap.get(i + 1).neighbors;
			for (int j = 0; j < adjList[i].length; j++) {
				neighbors.add(listMap.get(adjList[i][j]));
			}
		}
		return listMap.get(1);
	}

	public Node cloneGraph(Node node) {
		if (node == null)
			return null;
		Queue<Node> queue = new LinkedList<>();
		HashMap<Node, Node> cloneMap = new HashMap<>();
		cloneMap.put(node, new Node(node.val));
		queue.add(node);
		while (!queue.isEmpty()) {
			Node ogNode = queue.poll();
			Node cloneNode = cloneMap.get(ogNode);
			for (Node neighbor : ogNode.neighbors) {
				if (!cloneMap.containsKey(neighbor)) {
					cloneMap.put(neighbor, new Node(neighbor.val));
					queue.offer(neighbor);
				}
				Node cloneNeighbor = cloneMap.get(neighbor);
				cloneNode.neighbors.add(cloneNeighbor);
			}
		}
		return cloneMap.get(node);
	}

	class Node {
		int val;
		List<Node> neighbors;

		Node() {
			this.val = 0;
			this.neighbors = new ArrayList<>();
		}

		Node(int val) {
			this.val = val;
			this.neighbors = new ArrayList<>();
		}

		Node(int val, List<Node> neighbors) {
			this.val = val;
			this.neighbors = neighbors;
		}
	}
}
