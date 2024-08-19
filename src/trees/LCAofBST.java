package trees;

public class LCAofBST {
	
	public static void main(String args[]) {
		LCAofBST obj = new LCAofBST();
		Integer arr[] = {6,2,8,0,4,7,9,null,null,3,5};
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(8);
		TreeNode root = obj.buildTree(arr, 0);
		System.out.println(obj.lowestCommonAncestor(root, p, q).val);
				
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        while (root != null) {
        	if (root.val > p.val && root.val > q.val) root = root.left;
        	else if (root.val < p.val && root.val < q.val) root = root.right;
        	else break;
        }
        return root;
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
