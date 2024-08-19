package interviews.intuit;

public class SudokuSolver2 {
    public static void main(String[] args) {
    	SudokuSolver2 obj = new SudokuSolver2();
        char[][] board = {
            { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
            { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
            { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
            { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
            { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
            { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
            { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        obj.solveSudoku(board);
    }

    public void solveSudoku(char[][] board) {
        boolean[][] rowSet = new boolean[9][10];  // Allows indexing from 1 to 9
        boolean[][] colSet = new boolean[9][10];
        boolean[][] squareSet = new boolean[9][10];

        // Populate sets with known values
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '0'; // Convert char '1'-'9' to integer 1-9
                    int squareIndex = (i / 3) * 3 + (j / 3);
                    rowSet[i][num] = true;
                    colSet[j][num] = true;
                    squareSet[squareIndex][num] = true;
                }
            }
        }

        // Start solving the board
        solveSudokuUtil(board, rowSet, colSet, squareSet);
        printBoard(board);
    }

    private boolean solveSudokuUtil(char[][] board, boolean[][] rowSet, boolean[][] colSet, boolean[][] squareSet) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int num = 1; num <= 9; num++) {
                        int squareIndex = (i / 3) * 3 + (j / 3);
                        if (!rowSet[i][num] && !colSet[j][num] && !squareSet[squareIndex][num]) {
                            // Place the digit
                            board[i][j] = (char) (num + '0'); // Convert int 1-9 to char '1'-'9'
                            rowSet[i][num] = true;
                            colSet[j][num] = true;
                            squareSet[squareIndex][num] = true;

                            // Recursively solve the rest of the board
                            if (solveSudokuUtil(board, rowSet, colSet, squareSet))
                                return true;
                            else {
                                // Backtrack if it doesn't work
                                board[i][j] = '.';
                                rowSet[i][num] = false;
                                colSet[j][num] = false;
                                squareSet[squareIndex][num] = false;
                            }
                        }
                    }
                    return false; // If no valid number can be placed, backtrack
                }
            }
        }
        return true; // If no empty cells remain, the board is already solved
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
