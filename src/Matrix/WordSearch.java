package Matrix;

public class WordSearch {
	public static void main(String args[]) {
		WordSearch obj = new WordSearch();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCESEEEFS";
		System.out.println(obj.exist(board, word));
	}

	

	public boolean exist(char[][] board, String word) {
		if (board.length == 0 && word.length() != 0)
			return false;
		if (word.length() == 0) {
			return true;
		}
		boolean[][] visited = new boolean[board.length][board[0].length];
		int index = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (existsUtility(board, word, i, j, index, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean existsUtility(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
		if (index > word.length() - 1)
			return true;
		int row[] = { 0, 0, 1, -1 };
		int col[] = { -1, 1, 0, 0 };
		if (board[i][j] == word.charAt(index)) {
			index = index + 1;
			if (index > word.length() - 1)
				return true;
			for (int k = 0; k < 4; k++) {
				if (isSafe(board, word, i + row[k], j + col[k], index, visited)) {
					visited[i][j] = true;
					if (existsUtility(board, word, i + row[k], j + col[k], index, visited))
						return true;
					else
						visited[i][j] = false;
				}
			}
		}
		return false;
	}

	public boolean isSafe(char[][] board, String word, int i, int j, int index, boolean visited[][]) {
		if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && board[i][j] == word.charAt(index)
				&& visited[i][j] != true)
			return true;
		return false;
	}

}
