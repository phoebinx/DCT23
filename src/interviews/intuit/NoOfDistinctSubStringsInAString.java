package interviews.intuit;

import java.util.HashMap;

public class NoOfDistinctSubStringsInAString {
	public static void main(String args[]) {
		NoOfDistinctSubStringsInAString obj = new NoOfDistinctSubStringsInAString();
		String s = "aabbaba";
		System.out.println(obj.countDistinct(s));
	}

	public int countDistinct(String s) {
		TrieNode root = new TrieNode();
		int count = 0;
		//put every suffix in the Trie and count every insert
		for (int i = 0; i<s.length();i++) {
			TrieNode node = root;
			for (int j = i; j<s.length(); j++) {
				char c = s.charAt(j);
				if (!node.children.containsKey(c)) {
					node.children.put(c, new TrieNode());
					count++;
				}
				node = node.children.get(c);
			}
		}
		return count;
	}
	
	static class TrieNode {
		HashMap<Character, TrieNode> children;
		TrieNode() {
			children = new HashMap<>();
		}
	}
}
