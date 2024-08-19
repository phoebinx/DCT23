package Matrix;

public class RotateImage {

	public static void main(String args[]) {
		RotateImage obj = new RotateImage();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		obj.rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	public void rotate(int[][] matrix) {
		if (matrix.length == 0) return;
		transpose(matrix);
		int len = matrix[0].length-1; // no of cols
		// switch columns around the center
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][len - j];
				matrix[i][len - j] = temp;
			}
		}
	}

	private void transpose(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[i].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

}
