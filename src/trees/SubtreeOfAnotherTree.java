package trees;

public class SubtreeOfAnotherTree {
	public static void main(String args[]) {
		SubtreeOfAnotherTree obj = new SubtreeOfAnotherTree();
		Integer [] t1 = {3,4,5,1,2};
		TreeNode subRoot = obj.buildTree(t1, 0);
		Integer [] t2 = {4,1,2};
		TreeNode root = obj.buildTree(t2, 0);
		System.out.println(obj.isSubtree(root, subRoot));
	}
	
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (isSameTree(root, subRoot)) return true;
		return (isSubtree(root, subRoot.left) || isSubtree(root, subRoot.right));
    }
	
	private boolean isSameTree(TreeNode root, TreeNode subRoot) {
		if (root == null && subRoot == null) return true;
		if (root == null || subRoot == null) return false;
		return (root.val == subRoot.val && isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right));
	}
	
	private TreeNode buildTree(Integer arr[], int i) {
		if (arr[i] == null) return null; 
		TreeNode node = new TreeNode(arr[i]);
		if (i*2+1 < arr.length) {
			node.left = buildTree(arr, 2*i+1);
			node.right = buildTree(arr, 2*i+2);
		}
		return node;
	}

}
