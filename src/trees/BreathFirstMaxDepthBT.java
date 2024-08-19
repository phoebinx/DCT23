package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstMaxDepthBT {
	public static void main(String args[]) {
		BreathFirstMaxDepthBT obj = new BreathFirstMaxDepthBT();
		Integer arr[] = {3,9,20,null,null,15,7}; 
		TreeNode root = obj.buildTree(arr, 0);
		System.out.println(obj.maxDepth(root));
	}
	
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int level = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i<size; i++) {
				TreeNode temp = queue.poll();
				if (temp.left != null)
					queue.offer(temp.left);
				if(temp.right != null) 
					queue.offer(temp.right);
			}
			level+=1;
		}
        return level;
    }
	
	private TreeNode buildTree(Integer[] arr, int i) {
		if (arr[i] == null) return null;
		TreeNode temp = new TreeNode(arr[i]);
		if (2*i+1 < arr.length) {
			temp.left = buildTree(arr, 2*i+1);
			temp.right = buildTree(arr, 2*i+2);
		}
		return temp;
	}

}
