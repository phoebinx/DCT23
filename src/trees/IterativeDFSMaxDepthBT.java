package trees;

import java.util.Stack;

public class IterativeDFSMaxDepthBT {
	public static void main(String args[])  {
		IterativeDFSMaxDepthBT obj = new IterativeDFSMaxDepthBT();
		Integer arr[] = {3,9,20,null,null,15,7};
		TreeNode root = obj.buildTree(arr, 0);
		System.out.println(obj.maxDepth(root));
	}
	
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int result = 1;
		Stack<NodeDepth> stack = new Stack<>();
		stack.push(new NodeDepth(root, 1));
		while (!stack.isEmpty()) {
			NodeDepth temp = stack.pop();
			result = Math.max(result, temp.depth);
			if (temp.node.left != null) stack.push(new NodeDepth(temp.node.left, temp.depth+1));
			if (temp.node.right != null) stack.push(new NodeDepth(temp.node.right, temp.depth+1));
		}
        return result;
    }
	
	private TreeNode buildTree(Integer arr[], int i) {
		if (arr[i] == null) return null;
		TreeNode temp = new TreeNode(arr[i]);
		if (2*i+1 < arr.length) {
			temp.left = buildTree(arr,2*i+1);
			temp.right = buildTree(arr, 2*i+2);
		}
		return temp;
	}
	
	private class NodeDepth {
		TreeNode node;
		int depth;
		NodeDepth(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}
}
