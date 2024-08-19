package practice.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static void main(String args[]) {
		SpiralMatrix obj = new SpiralMatrix();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		for (Integer num : obj.spiralOrder(matrix)) {
			System.out.print(num + " ");
		}
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		int ci, cf, ri, rf;
		ci = ri = 0;
		rf = matrix.length - 1;
		cf = matrix[0].length - 1;
		while (ci <= cf && ri <= rf) {
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
				cf--;
			} else {
				break;
			}
			// left
			if (isValid(ci, cf, ri, rf)) {
				for (int j = cf; j >= ci; j--) {
					res.add(matrix[rf][j]);
				}
				rf--;
			} else {
				break;
			}
			// up
			if (isValid(ci, cf, ri, rf)) {
				for (int i = rf; i >= ri; i--) {
					res.add(matrix[i][ci]);
				}
				ci++;
			} else {
				break;
			}
		}
		return res;
	}

	private boolean isValid(int ci, int cf, int ri, int rf) {
		if (ci <= cf && ri <= rf)
			return true;
		return false;
	}

}
