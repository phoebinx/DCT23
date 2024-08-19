package practice.tree;

import java.util.Stack;

public class KSmallestElementBST {
	public static void main(String args[]) {
		KSmallestElementBST obj = new KSmallestElementBST();
		Integer arr[] = { 3, 1, 4, null, 2 };
		int k = 1;
		TreeNode root = obj.buildTree(arr, 0);
		System.out.println(obj.kthSmallest(root, k));
	}

	public int kthSmallest(TreeNode root, int k) {
		TreeNode cur = root;
		int curPointer = 0;
		Stack<TreeNode> stack = new Stack<>();
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			if (++curPointer == k) return cur.val;
			cur = cur.right;
		}
		return Integer.MAX_VALUE;
	}
	
	private TreeNode buildTree(Integer arr[], int i) {
		if (arr[i] == null) return null;
		TreeNode node = new TreeNode(arr[i]);
		if (2*i+1 < arr.length) {
			node.left = buildTree(arr, 2*i+1);
			node.right = buildTree(arr, 2*i+2);
		}
		return node;
	}

	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}

	}
}
