package Trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
	TrieNode root;
	public static void main(String args[]) {
		WordSearchII obj = new WordSearchII();
		 char [][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		 String words[] = {"oath","pea","eat","rain"};
		 List<String> result = obj.findWords(board, words);
		 for (String s : result)
			 System.out.println(s);
	}

	public List<String> findWords(char[][] board, String[] words) {
		root = buildTrie(words);
		List<String> result = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j< board[i].length; j++) {
				dfs(i, j, board, result, root);
			}
		}
		return result;
	}
	
	
	private void dfs(int i, int j, char[][] board, List<String> result, TrieNode node) {
		char c = board[i][j];
		int n = c - 'a';
		if (c == '#' || node.next[n] == null) return;
		node = node.next[n];
		if (node.word != null) {
			result.add(node.word);
			node.word = null;
		}
		board[i][j] = '#';
		int row[]  = {0,0,1,-1};
		int col[] = {1,-1,0,0};
		for (int k = 0; k<4; k++) {
			if (isSafe(i+row[k], j+col[k], board))
				dfs(i+row[k], j+col[k], board, result, node);
		}
		board[i][j] = c;
	}

	private boolean isSafe(int i, int j, char[][] board) {
		if (i>=0 && i<board.length && j>=0 && j<board[0].length)
			return true;
		return false;
	}

	private TrieNode buildTrie(String[] words) {
		TrieNode node = new TrieNode();
		for (String word : words) {
			TrieNode temp = node;
			for (Character c : word.toCharArray()) {
				int i = c-'a';
				if (temp.next[i] == null) 
					temp.next[i] = new TrieNode();
				temp = temp.next[i];
			}
			temp.word = word;
		}
		return node;
	}


	class TrieNode {
		TrieNode next[];
		String word;
		TrieNode() {
			next = new TrieNode[26];
		}
	}

}
