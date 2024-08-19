package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertBinaryTree {
	public static void main(String args[]) {
		InvertBinaryTree obj = new InvertBinaryTree();
		Integer arr[] = {4,2,7,1,3,6,9};
		TreeNode root = obj.buildTree(arr, 0);
		Integer res[] = obj.serializeTree(obj.invertTree(root));
		for (int i:res)
			System.out.print(i+" ");
 	}
	
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		TreeNode temp = invertTree(root.left);
		root.left = invertTree(root.right);
		root.right = temp;
		return root;
    }
	
	//Level order traversal
	private Integer[] serializeTree(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) return new Integer[] {};
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			list.add(temp.val);
			if (temp.left != null) queue.offer(temp.left);
			if (temp.right != null) queue.offer(temp.right);
		}
		return list.stream().toArray(Integer[]::new);
	}

	private TreeNode buildTree(Integer []arr, int i)  {
		if (arr[i] == null) return null;
		TreeNode temp = new TreeNode(arr[i]);
		if (2*i+1 < arr.length) {
			temp.left = buildTree(arr, 2*i+1);
			temp.right = buildTree(arr, 2*i+2);
		}
		return temp;
	}
}
