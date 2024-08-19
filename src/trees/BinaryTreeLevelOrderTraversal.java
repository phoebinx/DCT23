package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String args[]) {
		BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
		Integer arr[] = {3,9,20,null,null,15,7};
		TreeNode root = obj.buildTree(arr, 0);
		List<List<Integer>> res = obj.levelOrder(root);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	List<Integer> list = new LinkedList<>();
        	for (int i = 0; i < size; i++) {
        		TreeNode temp = queue.poll();
        		if (temp.left != null) queue.offer(temp.left);
        		if (temp.right != null) queue.offer(temp.right);
        		list.add(temp.val);
        	}
        	result.add(list);
        }
        return result;
    }
	
	public TreeNode buildTree(Integer arr[], int i) {
		if (arr[i] == null) return null;
		TreeNode temp = new TreeNode(arr[i]);
		if (2*i+1 < arr.length) {
			temp.left = buildTree(arr, 2 * i + 1);
			temp.right = buildTree(arr, 2 * i + 2);
		}
		return temp;
	}
}
