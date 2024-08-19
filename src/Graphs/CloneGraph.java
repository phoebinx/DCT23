package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//bfs of graph 

public class CloneGraph {
	public static void main(String args[]) {
		CloneGraph obj = new CloneGraph();
		int arr[][] = { { 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } };
		Node node = obj.buildGraph(arr);
		Node clonedNode = obj.cloneGraph(node);
	}

	private Node buildGraph(int[][] arr) {
		if (arr.length == 0)
			return null;
		if (arr[0].length == 0)
			return new Node(1);
		HashMap<Integer, Node> nodeMap = new HashMap<>();
		for (int i = 1; i <= arr.length; i++) {
			nodeMap.put(i, new Node(i));
		}
		for (int i = 0; i < arr.length; i++) {
			List<Node> neighbors = nodeMap.get(i).neighbors;
			for (int j = 0; j < arr[i].length; j++) {
				neighbors.add(nodeMap.get(arr[i][j]));
			}
		}
		return nodeMap.get(0);
	}
	
	public Node cloneGraph(Node node) {
		if (node == null)
			return null;
		Queue<Node> queue = new LinkedList<>();
		HashMap<Node, Node> ogCloneMap = new HashMap<>();
		ogCloneMap.put(node, new Node(node.val));
		queue.add(node);
		while (!queue.isEmpty()) {
			Node ogNode = queue.poll();
			Node cloneNode = ogCloneMap.get(ogNode);
			for (Node neighbor : ogNode.neighbors) {
				if (!ogCloneMap.containsKey(neighbor)) {
					ogCloneMap.put(neighbor, new Node(neighbor.val));
					queue.offer(neighbor);
				}
				Node cloneNeighbor = ogCloneMap.get(neighbor);
				cloneNode.neighbors.add(cloneNeighbor);
			}
		}
		return ogCloneMap.get(node);
	}
}
