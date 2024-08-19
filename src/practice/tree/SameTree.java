package practice.tree;

import trees.TreeNode;

public class SameTree {
	public static void main(String args[]) {
		SameTree obj = new SameTree();
		Integer[] p = { 1, 2, 3 };
		TreeNode pRoot = obj.buildTree(p, 0);
		Integer[] q = { 1, 2, 3 };
		TreeNode qRoot = obj.buildTree(q, 0);
		System.out.println(obj.isSubtree(pRoot, qRoot));
	}

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null) {
			return false;
		}
		if (isSameTree(root, subRoot))
			return true;
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	private boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null)
			return (p == null && q == null);
		
		return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
	}

	private TreeNode buildTree(Integer arr[], int i) {
		if (arr[i] == null)
			return null;
		TreeNode temp = new TreeNode(arr[i]);
		if (2 * i + 1 < arr.length) {
			temp.left = buildTree(arr, 2 * i + 1);
			temp.right = buildTree(arr, 2 * i + 2);
		}
		return temp;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.left = left;
			this.right = right;
			this.val = val;
		}
	}
}
