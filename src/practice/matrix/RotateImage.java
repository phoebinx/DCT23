package practice.matrix;

public class RotateImage {
	public static void main(String args[]) {
		RotateImage obj = new RotateImage();
		int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
		obj.rotate(matrix);
	}

	public void rotate(int[][] matrix) {
		transpose(matrix);
		printMatrix(matrix);
		int start =0,end = matrix[0].length-1;
		while (start < end) {
			for (int i = 0; i<matrix.length; i++) {
				int temp = matrix[i][start];
				matrix[i][start] = matrix[i][end];
				matrix[i][end] = temp;
			}
			start++; end--;
		}
		printMatrix(matrix);
	}
	
	private void printMatrix(int[][] matrixT) {
		 for (int i = 0; i<matrixT.length; i++) {
			 for (int j= 0; j<matrixT[i].length; j++) {
				 System.out.print(matrixT[i][j] + " ");
			 }
			 System.out.println();
		 }
		
	}

	private void transpose(int [][]matrix) {
		int temp;
		for (int i = 0; i<matrix.length; i++) {
			for (int j = i; j< matrix[i].length; j++) {
				temp = matrix[i][j];
				matrix[i][j]= matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}
