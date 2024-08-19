package trees;

public class RecursiveDFSMaxDepthBT {

	public static void main(String args[]) {
		RecursiveDFSMaxDepthBT obj = new RecursiveDFSMaxDepthBT();
		Integer arr[] = { 3, 9, 20, null, null, 15, 7 };
		TreeNode root = obj.buildTree(arr, 0);
		System.out.println(obj.maxDepth(root));
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return (1 + Integer.max(maxDepth(root.left), maxDepth(root.right)));
	}

	private TreeNode buildTree(Integer arr[], int i) {
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
