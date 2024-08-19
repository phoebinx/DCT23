package Trie;

import java.util.HashMap;

public class WordDictionary {
	TrieNode head;

	public static void main(String args[]) {
		WordDictionary obj = new WordDictionary();
		obj.addWord("bad");
		obj.addWord("dad");
		obj.addWord("mad");
		System.out.println(obj.search("pad"));
		System.out.println(obj.search("bad"));
		System.out.println(obj.search(".ad"));
		System.out.println(obj.search("b.."));
	}

	public WordDictionary() {
		head = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode node = head;
		for (Character c : word.toCharArray()) {
			if (!node.neighbor.containsKey(c))
				node.neighbor.put(c, new TrieNode(c));
			node = node.neighbor.get(c);
		}
		node.isWord = true;
	}

	public boolean search(String word) {
		return searchUtil(word, head);
	}

	private boolean searchUtil(String word, TrieNode node) {
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (node.neighbor.containsKey(c)) {
				node = node.neighbor.get(c);
			} else if (c == '.' && !node.neighbor.isEmpty()) {
				// look for substring in every neighbor
				for (TrieNode neighbor : node.neighbor.values()) {
					if (searchUtil(word.substring(i + 1, word.length()), neighbor)) {
						return true;
					}
				}
				return false;
			} else {
				return false;
			}
		}
		return node.isWord;
	}

	class TrieNode {
		int val;
		HashMap<Character, TrieNode> neighbor;
		boolean isWord;

		TrieNode(int val) {
			this.val = val;
			this.neighbor = new HashMap<>();
		}

		TrieNode() {
			this.neighbor = new HashMap<>();
		}
	}
}
