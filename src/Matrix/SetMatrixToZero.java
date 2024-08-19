package Matrix;

import java.util.HashSet;

public class SetMatrixToZero {
	public static void main(String args[]) {
		SetMatrixToZero obj = new SetMatrixToZero();
		int matrix[][] = {{1,1,1},{1,0,1},{1,1,1}};
		obj.setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j< matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[i].length; j++) {
        		if (matrix[i][j] == 0) {
        			rows.add(i);
        			cols.add(j);
        		}
        	}
        }
        
        for (int i = 0; i< matrix.length; i++) {
        	for (int j=0 ; j<matrix[i].length; j++) {
        		if (rows.contains(i) || cols.contains(j)) {
        			matrix[i][j] = 0;
        		}
        	}
        }
    }
}
