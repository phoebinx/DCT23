package trees;

public class BinaryTreeMaxPathSum {
	int max;
	public static void main(String args[]) {
		BinaryTreeMaxPathSum obj = new BinaryTreeMaxPathSum();
		Integer arr[] = {-10,9,20,null,null,15,7};
		TreeNode root = obj.buildTree(arr, 0);
		
		System.out.println(obj.maxPathSum(root));
	}
	
	public int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		maxPathSumUtil(root);
		return max;
    }
	
	public int maxPathSumUtil(TreeNode root) {
		if (root == null) return 0;
		int lMax = Math.max(0, maxPathSumUtil(root.left));
		int rMax = Math.max(0, maxPathSumUtil(root.right));
		int maxBranchNoSplit = Math.max(Math.max(lMax,rMax)+root.val, root.val);
		int maxBranchSplit = Math.max(maxBranchNoSplit, lMax+rMax+root.val);
		max = Math.max(maxBranchSplit, max);
		return maxBranchNoSplit;
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
