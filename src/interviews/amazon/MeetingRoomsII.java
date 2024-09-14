package interviews.amazon;

import java.util.Arrays;

public class MeetingRoomsII {
	public static void main(String args[]) {
		MeetingRoomsII obj = new MeetingRoomsII();
		int intervals[][] = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		System.out.println(obj.minMeetingRooms(intervals));
	}

	public int minMeetingRooms(int[][] intervals) {
		// get array sorted with start time
		int sortedStart[] = sortArray(intervals, 0);
		// get array sorted with endtime
		int sortedEnd[] = sortArray(intervals, 1);
		// for each index, check how many simultaneous meetings are going on and return
		// max
		int res, count, s, e;
		res = count = s = e = 0;
		while (s < intervals.length) {
			if (sortedStart[s] < sortedEnd[e]) {
				// another meeting has started
				s++;
				count++;
			} else {
				// meeting has ended
				e++;
				count--;
			}
			res = Math.max(res, count);
		}
		return res;
	}

	private int[] sortArray(int[][] interval, int index) {
		Arrays.sort(interval, (a, b) -> Integer.compare(a[index], b[index]));
		int [] arr = new int[interval.length];
		for (int i = 0; i< interval.length; i++) {
			arr[i] = interval[i][index];
		}
		return arr;
	}
}
