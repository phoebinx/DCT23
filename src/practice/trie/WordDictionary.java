package practice.trie;

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
		for (char c : word.toCharArray()) {
			if (!node.neighbor.containsKey(c))
				node.neighbor.put(c, new TrieNode());
			node = node.neighbor.get(c);
		}
		node.isWord = true;
	}

	public boolean search(String word) {
		return searchUtil(word, 0, head);
	}

	private boolean searchUtil(String word, int index, TrieNode node) {
		for (int i = index; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c != '.' ) {
				if (node.neighbor.containsKey(c)) {
					node = node.neighbor.get(c);
				} else {
					return false;
				}
			} else {
				for (TrieNode neighbor : node.neighbor.values()) {
					if (searchUtil(word, i+1, neighbor))
							return true;
				}
				return false;
			}
		}
		return node.isWord;
	}

	class TrieNode {
		HashMap<Character, TrieNode> neighbor;
		boolean isWord;

		TrieNode() {
			this.neighbor = new HashMap<>();
		}
	}
}
