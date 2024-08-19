package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static void main(String args[]) {
		SpiralMatrix obj = new SpiralMatrix();
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> res = obj.spiralOrder(matrix);
		for (Integer i : res)
			System.out.print(i);
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix.length == 0)
			return null;

		List<Integer> res = new ArrayList<>();
		int ri = 0, rf = matrix.length-1;
		int ci = 0, cf = matrix[0].length-1;

		while (ri <= rf && ci <= cf) {
			// right
			for (int j = ci; j <= cf; j++) {
				res.add(matrix[ri][j]);
			}
			ri++;
			// down
			if (isValid(ci, cf, ri, rf)) {
				for (int i = ri; i <= rf; i++) {
					res.add(matrix[i][cf]);
				}
			} else {
				break;
			}
			cf--;
			// left
			if (isValid(ci, cf, ri, rf)) {
				for (int j = cf; j >= ci; j--) {
					res.add(matrix[rf][j]);
				}
			} else {
				break;
			}
			rf--;
			//up
			if (isValid(ci, cf, ri, rf)) {
				for (int i = rf; i>=ri; i--) {
					res.add(matrix[i][ci]);
				}
			} else break;
			ci++;
		}
		return res;
	}

	private boolean isValid(int ci, int cf, int ri, int rf) {
		return (ci <= cf && ri <= rf);
	}
}
