package interviews.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class AllNodesDistanceKInBinaryTree {
	TreeNode target;

	public static void main(String args[]) {
		AllNodesDistanceKInBinaryTree obj = new AllNodesDistanceKInBinaryTree();
		Integer arr[] = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
		int t = 5, k = 2;
		TreeNode root = obj.buildTree(arr, 0, t);
		List<Integer> res = obj.distanceK(root, obj.target, k);
		for (int num : res) {
			System.out.print(num+" ");
		}
	}

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		HashMap<TreeNode, Set<TreeNode>> adjMap = buildAdjMap(root);
		Set<Integer> res = new HashSet<>();
		for (TreeNode node : adjMap.keySet()) {
			if (node == target) {
				dfs(0, k, node, null, adjMap, res);
			}
		}
		return new ArrayList<>(res);
	}

	private void dfs(int step, int k, TreeNode node, TreeNode parent, HashMap<TreeNode, Set<TreeNode>> adjMap,
			Set<Integer> res) {
		if (step > k || node == null) {
			return;
		}
		if (step == k) {
			res.add(node.val);
			return;
		}

		for (TreeNode neighbor : adjMap.get(node)) {
			if (neighbor == parent)
				continue;
			dfs(step + 1, k, neighbor, node, adjMap, res);
		}
	}

	private HashMap<TreeNode, Set<TreeNode>> buildAdjMap(TreeNode root) {
		HashMap<TreeNode, Set<TreeNode>> adjMap = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode node = root;
		queue.offer(node);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			TreeNode left = cur.left;
			TreeNode right = cur.right;
			if (left != null) {
				adjMap.computeIfAbsent(cur, k -> new HashSet<>()).add(left);
				adjMap.computeIfAbsent(left, k -> new HashSet<>()).add(cur);
				queue.offer(left);
			}

			if (right != null) {
				adjMap.computeIfAbsent(cur, k -> new HashSet<>()).add(right);
				adjMap.computeIfAbsent(right, k -> new HashSet<>()).add(cur);
				queue.offer(right);
			}
		}
		return adjMap;
	}

	private TreeNode buildTree(Integer arr[], int index, int t) {
		if (arr[index] == null)
			return null;
		TreeNode root = new TreeNode(arr[index]);
		if (root.val == t)
			this.target = root;
		if (2 * index + 1 < arr.length) {
			root.left = buildTree(arr, 2 * index + 1, t);
			root.right = buildTree(arr, 2 * index + 2, t);
		}
		return root;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

	}

}
