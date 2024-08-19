package practice.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
	public static void main(String args[]) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		MergeInterval obj = new MergeInterval();
		for (int[] arr : obj.merge(intervals)) {
			System.out.println(arr[0] + " " + arr[1]);
		}
	}

	public int[][] merge(int[][] intervals) {
		if(intervals == null || intervals.length == 0) {
			return new int[0][];
		}
		
		// sort intervals on start position
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		
		List<int[]> merged = new ArrayList<>();
		int[] currentInterval = intervals[0];
		merged.add(currentInterval);
		
		for(int [] interval : intervals) {
			int curEnd = currentInterval[1];
			int nextBegin = interval[0];
			int nextEnd = interval[1];
			
			if (curEnd >= nextBegin) { // Overlapping intervals, move the end if needed
				currentInterval[1] = Math.max(curEnd, nextEnd);
			} else { // Disjoint intervals, add the new interval to the list
				currentInterval = interval;
				merged.add(currentInterval);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}
}
