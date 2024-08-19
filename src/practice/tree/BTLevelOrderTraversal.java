package practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {
	public static void main(String args[]) {
		BTLevelOrderTraversal obj = new BTLevelOrderTraversal();
		Integer arr[] = { 3, 9, 20, null, null, 15, 7 };
		TreeNode root = obj.buildTree(arr, 0);
		for (List<Integer> list : obj.levelOrder(root)) {
			for (Integer num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null ) return res;
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode node = root;
		queue.offer(node);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i<size; i++) {
				TreeNode temp = queue.poll();
				list.add(temp.val);
				if (temp.left != null) queue.offer(temp.left);
				if (temp.right != null) queue.offer(temp.right);
			}
			res.add(list);
		}
		return res;
	}

	private TreeNode buildTree(Integer arr[], int i) {
		if (arr[i] == null)
			return null;
		TreeNode node = new TreeNode(arr[i]);
		if (2 * i + 1 < arr.length) {
			node.left = buildTree(arr, 2 * i + 1);
			node.right = buildTree(arr, 2 * i + 2);
		}
		return node;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
