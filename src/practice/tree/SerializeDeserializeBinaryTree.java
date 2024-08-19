package practice.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
	String seperator = ",";
	String nullStr = "*";

	public static void main(String args[]) {
		SerializeDeserializeBinaryTree obj = new SerializeDeserializeBinaryTree();
		Integer arr[] = { 1, 2, 3, null, null, 4, 5 };
		TreeNode root = obj.buildTree(arr, 0);
		obj.printTree(root);
		System.out.println();
		String serializeTreeStr = obj.serialize(root);
		System.out.println("serialized tree: " + serializeTreeStr);
		obj.printTree(obj.deserialize(serializeTreeStr));
	}

	// Encodes a tree to a single string.
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
		return deserializeUtil(nodes);
	}
	
	private TreeNode deserializeUtil(Queue<String> nodes) {
		String val = nodes.poll();
		if (val.equals(nullStr)) return null;
		TreeNode node = new TreeNode(Integer.parseInt(val));
		node.left = deserializeUtil(nodes);
		node.right = deserializeUtil(nodes);
		return node;
	}

	private TreeNode buildTree(Integer[] arr, int i) {
		if (i > arr.length - 1 || arr[i] == null)
			return null;
		TreeNode node = new TreeNode(arr[i]);
		if (2 * i + 1 < arr.length) {
			node.left = buildTree(arr, 2 * i + 1);
			node.right = buildTree(arr, 2 * i + 2);
		}
		return node;
	}

	private void printTree(TreeNode root) {
		if (root == null);
		List<Integer> treeList = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				if (temp != null) {
					treeList.add(temp.val);
					queue.offer(temp.left);
					queue.offer(temp.right);
				} else {
					treeList.add(null);
				}
			}
		}
		for (Integer num:treeList) {
			System.out.print(num+" ");
		}
		System.out.println();
	}

	class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}
	}
}
