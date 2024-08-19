package trees;

import java.util.Stack;

public class KSmallestBST {
	int count = 0;
	public static void main(String args[]) {
		KSmallestBST obj = new KSmallestBST();
		Integer arr[] = {3,1,4,null,2};
		int k = 1;
		TreeNode root = obj.buildTree(arr, 0);
		System.out.println(obj.kthSmallest(root, k));
 	}
	
	public int kthSmallest(TreeNode root, int k) {
		int index = 0;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;			
		while (curr != null || !stack.isEmpty()) {
			//keep going left = inorder
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			if (++index == k) return curr.val;
			curr = curr.right;
		}
		return Integer.MAX_VALUE;
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
}

