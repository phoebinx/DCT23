package interviews.intuit;

import java.util.HashSet;

public class SudokuSolver {
	public static void main(String args[]) {
		SudokuSolver obj = new SudokuSolver();
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		obj.solveSudoku(board);
	}

	public void solveSudoku(char[][] board) {
		HashSet<Character>[] rowSet = new HashSet[9];
		HashSet<Character>[] colSet = new HashSet[9];
		HashSet<Character>[] squareSet = new HashSet[9];

		// initialize sets
		for (int i = 0; i < 9; i++) {
			rowSet[i] = new HashSet<>();
			colSet[i] = new HashSet<>();
			squareSet[i] = new HashSet<>();
		}

		// populate sets with known values
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				char c = board[i][j];
				if (c == '.')
					continue;
				int squareIndex = (i / 3) * 3 + (j / 3);
				rowSet[i].add(c);
				colSet[j].add(c);
				squareSet[squareIndex].add(c);
			}
		}

		solveSudokuUtil(board, rowSet, colSet, squareSet);
	}

	private boolean solveSudokuUtil(char[][] board, HashSet<Character>[] rowSet, HashSet<Character>[] colSet,
			HashSet<Character>[] squareSet) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						int squareIndex = (i / 3) * 3 + (j / 3);
						if (rowSet[i].contains(c) || colSet[j].contains(c) || squareSet[squareIndex].contains(c))
							continue;
						// place the digit
						board[i][j] = c;
						rowSet[i].add(c);
						colSet[j].add(c);
						squareSet[squareIndex].add(c);

						// Recursively solve the rest of the board
						if (solveSudokuUtil(board, rowSet, colSet, squareSet))
							return true;
						else {
							// backtrack if it doesn't work
							board[i][j] = '.';
							rowSet[i].remove(c);
							colSet[j].remove(c);
							squareSet[squareIndex].remove(c);
						}
					}
					return false; //if no valid number can be placed, backtrack
				}
			}
		}
		return true; //if no empty cells remain, board is already solved. 
	}

	private void printBoard(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
