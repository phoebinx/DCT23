package practice.tree;

import trees.TreeNode;

public class ValidBST {
	public static void main(String args[]) {
		ValidBST obj = new ValidBST();
		Integer rootArr[] = { 5,1,4,null,null,3,6 };
		TreeNode root = obj.buildTree(rootArr, 0);
		System.out.println(obj.isValidBST(root));
	}

	public boolean isValidBST(TreeNode root) {
		return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBSTUtil(TreeNode root, int minVal, int maxVal) {
		if (root == null)
			return true;
		if (root.val < minVal || root.val > maxVal)
			return false;
		return (isValidBSTUtil(root.left, minVal, root.val) && isValidBSTUtil(root.right, root.val, maxVal));
	}
	

	private TreeNode buildTree(Integer[] arr, int i) {
		if (arr[i] == null)
			return null;
		TreeNode temp = new TreeNode(arr[i]);
		if (2 * i + 1 < arr.length) {
			temp.left = buildTree(arr, 2 * i + 1);
			temp.right = buildTree(arr, 2 * i + 2);
		}
		return temp;
	}


	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {

		}

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
