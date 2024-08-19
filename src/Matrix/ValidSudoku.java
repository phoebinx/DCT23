package Matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	public static void main(String args[]) {
		ValidSudoku obj = new ValidSudoku();
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(obj.isValidSudoku(board));
	}

	public boolean isValidSudoku(char[][] board) {
		//arrays of sets to track characters in rows, columns and squares
		Set<Character>[] rowSets = new HashSet[9];
		Set<Character>[] colSets = new HashSet[9];
		Set<Character>[] squareSets = new HashSet[9];
		
		//initialize the sets
		for (int i = 0; i<9; i++) {
			rowSets[i] = new HashSet<>();
			colSets[i] = new HashSet<>();
			squareSets[i] = new HashSet<>();
		}
		
		//iterate through the board
		for (int i = 0; i<board.length; i++) {
			for (int j = 0; j<board[i].length; j++) {
				char curChar = board[i][j];
				if (curChar == '.') continue;
				
				int squareKey = (i/3)*3 + (j/3);
				
				//check for duplicated in row, col or square set
				if ( rowSets[i].contains(curChar) ||
						colSets[j].contains(curChar) ||
						squareSets[squareKey].contains(curChar)) {
					return false;
				} else {
					rowSets[i].add(curChar);
					colSets[j].add(curChar);
					squareSets[squareKey].add(curChar);
				}
				
			}
		}
		return true;
	}
}
