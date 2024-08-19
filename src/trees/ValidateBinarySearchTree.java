package trees;

import java.util.Stack;
 
public class ValidateBinarySearchTree {
	public static void main(String args[]) {
		ValidateBinarySearchTree obj = new ValidateBinarySearchTree();
		Integer arr[] = { 0 };
		TreeNode root = obj.buildTree(arr, 0);
		System.out.println(obj.isValidBST(root));
	}

	public boolean isValidBST(TreeNode root) {
		return isValidUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValidUtil(TreeNode root, long minVal, long maxVal) {
		if (root == null) return true;
		if (!(root.val > minVal && root.val < maxVal)) return false;
		return (isValidUtil(root.left, minVal,root.val) && isValidUtil(root.right, root.val, maxVal));
		
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

}
