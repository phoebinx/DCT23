package trees;

import java.util.HashMap;
import java.util.Map;

public class BTFromPreorderInorder {
	int preIndex;
	HashMap<Integer, Integer> indexMap; 
	public static void main(String args[]) {
		BTFromPreorderInorder obj = new BTFromPreorderInorder();
		
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		 populateMap(inorder);
		 return buildTreeUtil(preorder, inorder, 0, inorder.length-1);
	 }
	 
	 public TreeNode buildTreeUtil(int[] preorder, int[] inorder, int start, int end) {
		 if (preorder.length==0 || inorder.length==0) return null;
		 if (start>end) return null;
		 TreeNode temp = new TreeNode(preorder[preIndex++]);
		 if (start == end) return temp;
		 
		 int tempIndex = indexMap.get(temp.val);
		 temp.left = buildTreeUtil(preorder, inorder, start, tempIndex-1);
		 temp.right = buildTreeUtil(preorder, inorder, tempIndex+1, end);
		 return temp;
	 }
	 
	 public void populateMap(int [] inorder) {
		 if (inorder.length == 0) return;
		 for (int i = 0;i<inorder.length;i++) {
			 indexMap.put(inorder[i], i);
		 }
	 }
}
