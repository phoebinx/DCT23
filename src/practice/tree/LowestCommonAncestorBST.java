package practice.tree;

public class LowestCommonAncestorBST {
	static TreeNode p = null;
	static TreeNode q = null;

	public static void main(String args[]) {
		LowestCommonAncestorBST obj = new LowestCommonAncestorBST();
		Integer arr[] = { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 };
		TreeNode root = obj.buildTree(arr, 0);
		System.out.println(obj.lowestCommonAncestor(root, p, q).val);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		TreeNode node=  root;
		while (node != null) {
			if (node.val> p.val && node.val> q.val) node = node.left;
			else if (node.val < p.val && node.val < q.val) node = node.right;
			else break;
		}
		return node;
	}

	private TreeNode buildTree(Integer arr[], int i) {
		if (arr[i] == null)
			return null;
		TreeNode node = new TreeNode(arr[i]);
		if (node.val == 2)
			p = node;
		else if (node.val == 8)
			q = node;
		if (2 * i + 1 < arr.length) {
			node.left = buildTree(arr, 2 * i + 1);
			node.right = buildTree(arr, 2 * i + 2);
		}
		return node;
	}

	class TreeNode {
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
