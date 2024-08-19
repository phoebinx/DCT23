package practice.interval;

import java.util.ArrayList;

public class InsertInterval {
	public static void main(String args[]) {
		InsertInterval obj = new InsertInterval();
		int[][] intervals = { { 1, 3 }, { 6, 9 } };
		int[] newInterval = { 2, 5 };
		int[][] res = obj.insert(intervals, newInterval);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		boolean newIntervalInserted = false;
		ArrayList<int[]> resList = new ArrayList<>();
		for (int[] curr : intervals) {
			if (newIntervalInserted == true) {
				resList.add(curr);
				continue;
			} else if (newInterval[1] < curr[0]) {
				resList.add(newInterval);
				resList.add(curr);
				newIntervalInserted = true;
			} else if (newInterval[0] > curr[1]){
				resList.add(curr);				
			} else {
				newInterval[0] = Math.min(newInterval[0], curr[0]);
				newInterval[1] = Math.max(newInterval[1], curr[1]);
			}
		}
		if (newIntervalInserted == false) {
			resList.add(newInterval);
		}
		return convertListToArr(resList);
	}

	private int[][] convertListToArr(ArrayList<int[]> resList) {
		int rows = resList.size();
		int cols = 2;
		int resArr [][] = new int[rows][cols];
		int i = 0;
		for (int arr[] : resList) {
			resArr[i] = arr;
			i++;
		}
		return resArr;
	}
}
