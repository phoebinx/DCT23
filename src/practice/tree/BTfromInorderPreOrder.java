package practice.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BTfromInorderPreOrder {
	HashMap<Integer, Integer> map;
	int preIndex = 0;

	public static void main(String args[]) {
		BTfromInorderPreOrder obj = new BTfromInorderPreOrder();
		int preorder[] = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		obj.printTree(obj.buildTree(preorder, inorder));
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		buildInorderMap(inorder);
		return buildTreeUtil(preorder, inorder, 0, inorder.length - 1);
	}

	private TreeNode buildTreeUtil(int[] preorder, int[] inorder, int start, int end) {
		if (inorder.length == 0 || preorder.length == 0)
			return null;
		if (start > end)
			return null;
		TreeNode node = new TreeNode(preorder[preIndex++]);
		if (start == end)
			return node;
		int mid = map.get(node.val);
		node.left = buildTreeUtil(preorder, inorder, start, mid - 1);
		node.right = buildTreeUtil(preorder, inorder, mid + 1, end);
		return node;
	}

	private void buildInorderMap(int[] inorder) {
		map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
	}

	private void printTree(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp == null) {
				System.out.print(null + " ");
				continue;
			} else {
				System.out.print(temp.val + " ");
				queue.offer(temp.left);
				queue.offer(temp.right);
			}
		}
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
