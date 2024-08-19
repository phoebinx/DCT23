package practice.tree;

public class MaxDepthBinaryTree {
	public static void main(String args[]) {
		MaxDepthBinaryTree obj = new MaxDepthBinaryTree();
		Integer arr[] = { 3, 9, 20, null, null, 15, 7 };
		TreeNode root = obj.buildTree(arr, 0);
		System.out.println(obj.maxDepth(root));
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

	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int l = maxDepth(root.left);
		int r = maxDepth(root.right);
		return 1+Math.max(l, r);
	}

	class TreeNode {
		int val;
		TreeNode left, right;

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
