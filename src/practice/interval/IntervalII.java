package practice.interval;

import java.util.Arrays;

public class IntervalII {
	public static void main(String args[]) {
		IntervalII obj = new IntervalII();
		int[][] intervals = { { 1, 5 }, { 9, 11 }, { 3, 10 }, { 2, 7 } };
		System.out.println(obj.minMeetingRooms(intervals));
	}

	public int minMeetingRooms(int[][] intervals) {
		// sorted intervals[i][0]
		int start[] = sortElement(0, intervals);
		// sorted intervals[i][1]
		int end[] = sortElement(1, intervals);
		int s, e, count, res;
		s = e = res = count = 0;
		while (s < intervals.length) {
			if (start[s] < end[e]) {
				// another meeting started
				s++;
				count++;
			} else {
				// a meeting ended
				e++;
				count--;
			}
			res = Math.max(count, res);
		}
		return res;
	}

	private int[] sortElement(int index, int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[index], b[index]));
		int arr[] = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			for (int j = 0; j < intervals[i].length; j++) {
				arr[i] = intervals[i][index];
			}
		}
		return arr;
	}

}
