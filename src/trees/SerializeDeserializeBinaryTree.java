package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
	String nullStr = "*";
	String seperator = ",";
	public static void main(String args[]) {
		SerializeDeserializeBinaryTree obj = new SerializeDeserializeBinaryTree();
		Integer arr[] = {1,2,3,null,null,4,5};
		TreeNode root = obj.buildTree(arr, 0);
		
		String serializedTreeStr =  obj.serialize(root);
		System.out.println("Serialized tree string: " + serializedTreeStr);
		obj.printTree(obj.deserialize(serializedTreeStr));
	}
	
	// Encodes a tree to a single string.
	// Preorder DFS
    public String serialize(TreeNode root) {
    	StringBuilder sb = new StringBuilder();
    	serializeUtil(root, sb);
        return sb.toString();
    }
    
   

    private void serializeUtil(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append(nullStr).append(seperator);
			return;
		}
		sb.append(root.val).append(seperator);
		serializeUtil(root.left, sb);
		serializeUtil(root.right, sb);
	}

	// Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	Queue<String> nodes = new LinkedList<>();
    	nodes.addAll(Arrays.asList(data.split(seperator)));
    	return deSerializeUtil(nodes);
    }
    
    private TreeNode deSerializeUtil(Queue<String> nodes) {
		// TODO Auto-generated method stub
    	String val = nodes.poll();
    	if (val.equals(nullStr)) return null;
    	TreeNode node = new TreeNode(Integer.parseInt(val));
    	node.left = deSerializeUtil(nodes);
    	node.right = deSerializeUtil(nodes);
		return node;
	}

    //DFS - recursive  
	public TreeNode buildTree(Integer arr[], int i) {
    	if (arr[i] == null) return null;
		TreeNode temp = new TreeNode(arr[i]);
		if (2*i+1 < arr.length) {
			temp.left = buildTree(arr, 2 * i + 1);
			temp.right = buildTree(arr, 2 * i + 2);
		}
		return temp;
    }

  //Level order traversal, BFS 
  	private Integer[] printTree(TreeNode root) {
  		List<Integer> list = new ArrayList<>();
  		if (root == null) return new Integer[] {};
  		Queue<TreeNode> queue = new LinkedList<>();
  		queue.add(root);
  		while(!queue.isEmpty()) {
  			int size = queue.size();
  			for (int i = 0; i< size; i++) {
	  			TreeNode temp = queue.poll();
	  			if (temp != null) { 
	  				list.add(temp.val);
	  				queue.offer(temp.left);
	  				queue.offer(temp.right);
	  			} else {
	  				list.add(null);
	  			}
  			}
  		}
  		return list.stream().toArray(Integer[]::new);
  	}
}
