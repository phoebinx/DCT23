package practice.trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
	public static void main(String args[]) {
		WordSearchII obj = new WordSearchII();
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String words[] = { "oath", "pea", "eat", "rain" };
		List<String> res = obj.findWords(board, words);
		for (String s : res) {
			System.out.print(s + " ");
		}
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		TrieNode node = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				dfs(i, j, node, res, board);
			}
		}
		return res;
	}

	private void dfs(int i, int j, TrieNode node, List<String> res, char[][] board) {
		char c = board[i][j];
		if (c == '#' || node.next[c - 'a'] == null)
			return;
		node = node.next[c - 'a'];
		if (node.word != null) {
			res.add(node.word);
			node.word = null;
		}
		// dfs board[i][j] to find other words in the path
		board[i][j] = '#';
		int[] rows = { 0, 0, 1, -1 };
		int[] cols = { 1, -1, 0, 0 };
		for (int k = 0; k < 4; k ++) {
			if (isSafe(i+rows[k], j + cols[k], board)) {
				dfs(i+rows[k], j+cols[k], node, res, board);
			}
		}
		board[i][j] = c;
	}

	private boolean isSafe(int i, int j, char[][] board) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return false;
		return true;
	}

	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				if (node.next[c - 'a'] == null) {
					node.next[c - 'a'] = new TrieNode();
				}
				node = node.next[c - 'a'];
			}
			node.word = word;
		}
		return root;
	}

	static class TrieNode {
		String word;
		TrieNode[] next;

		TrieNode() {
			next = new TrieNode[26];
		}
	}
}
