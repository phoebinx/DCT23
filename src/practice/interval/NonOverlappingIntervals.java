package practice.interval;

import java.util.Arrays;

public class NonOverlappingIntervals {
	public static void main(String args[]) {
		NonOverlappingIntervals obj = new NonOverlappingIntervals();
		int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		System.out.println(obj.eraseOverlapIntervals(intervals));
	}

	public int eraseOverlapIntervals(int[][] intervals) {	
		int res = 0;
		//sort array but start time
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int prevEnd = intervals[0][1];
		for (int i = 1; i<intervals.length;i++) {
			int curStart = intervals[i][0];
			int curEnd = intervals[i][1];
			//overlap
			if (curStart < prevEnd) {
				prevEnd = Math.min(prevEnd, curEnd);
				res += 1;
			}
			else {
				prevEnd = curEnd;
			}
		}
		return res;
	}

}
