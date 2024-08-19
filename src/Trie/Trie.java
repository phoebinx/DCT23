package Trie;

import java.util.HashMap;

public class Trie {
	TrieNode head;
	public static void main(String args[]) {
		Trie obj = new Trie();
		obj.insert("apple");
		System.out.println(obj.search("apple"));
		System.out.println(obj.search("app"));
		System.out.println(obj.startsWith("apple"));
		obj.insert("app");
		System.out.println(obj.search("app"));
	}

	public Trie() {
		head = new TrieNode();
	}

	public void insert(String word) {
		TrieNode node = head;
		for (Character c : word.toCharArray()) {
			if (!node.neighbors.containsKey(c)) {
				TrieNode temp = new TrieNode(c);
				node.neighbors.put(c, temp);
			}
			node = node.neighbors.get(c);	
		}
		node.isWord = true;
	}

	public boolean search(String word) {
		TrieNode node = searchUtil(word);
		if (node == null)
			return false;
		return node.isWord;
	}

	public boolean startsWith(String prefix) {
		TrieNode node = searchUtil(prefix);
		return !(node == null);
	}
	
	private TrieNode searchUtil(String word) {
		TrieNode node = head;
		for (Character c : word.toCharArray()) {
			if (!node.neighbors.containsKey(c))
				return null;
			node = node.neighbors.get(c);
		}
		return node;
	}

	public class TrieNode {
		int val;
		boolean isWord;
		HashMap<Character, TrieNode> neighbors;

		TrieNode(int val) {
			this.val = val;
			neighbors = new HashMap<>();
		}

		TrieNode() {
			neighbors = new HashMap<>();
		}
	}
}
