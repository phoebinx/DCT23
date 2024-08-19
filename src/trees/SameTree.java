package trees;

public class SameTree {
	
	public static void main(String args[]) {
		SameTree obj = new SameTree();
		Integer []p = {1,2,3};
		TreeNode pRoot = obj.buildTree(p, 0);
		Integer []q = {1,2,3};
		TreeNode qRoot = obj.buildTree(q, 0);
		System.out.println(obj.isSameTree(pRoot, qRoot));
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		if (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
			return true;
		return false;
    }
	
	private TreeNode buildTree(Integer arr[], int i) {
		if (arr[i] == null) return null;
		TreeNode temp = new TreeNode(arr[i]);
		if (2*i+1<arr.length) {
			temp.left = buildTree(arr, 2*i+1);
			temp.right = buildTree(arr, 2*i+2);
		}
		return temp;
	}

}
