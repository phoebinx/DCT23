package practice.tree;

import practice.tree.SerializeDeserializeBinaryTree.TreeNode;

public class BinaryTreeMaxPathSum {
	int max;

	public static void main(String args[]) {
		BinaryTreeMaxPathSum obj = new BinaryTreeMaxPathSum();
		Integer arr[] = { 1, 2, 3 };
		TreeNode root = obj.buildTree(arr, 0);
		System.out.println(obj.maxPathSum(root));
	}

	public int maxPathSum(TreeNode root) {
		max =Integer.MIN_VALUE;
		maxPathUtil(root);
		return max;
	}

	private int maxPathUtil(TreeNode node) {
		if (node == null)
			return 0;
		int lMax = Math.max(0, maxPathUtil(node.left));
		int rMax = Math.max(0, maxPathUtil(node.right));
		int maxBranchNoSplit = Math.max(node.val + Math.max(lMax, rMax), node.val);
		int maxBranchSplit = Math.max(maxBranchNoSplit, lMax + rMax + node.val);
		max = Math.max(max, maxBranchSplit);
		return maxBranchNoSplit;
	}

	private TreeNode buildTree(Integer[] arr, int i) {
		if (arr[i] == null)
			return null;
		TreeNode node = new TreeNode(arr[i]);
		if (2 * i + 1 < arr.length) {
			node.left = buildTree(arr, 2 * i + 1);
			node.right = buildTree(arr, 2 * i + 2);
		}
		return node;
	}

	public class TreeNode {
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
