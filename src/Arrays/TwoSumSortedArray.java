package Arrays;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
//2 pointer solution - small num[0], big num[len-1] and depending on the sum ,you change pointer
public class TwoSumSortedArray {
	public static void main(String args[]) {
		TwoSumSortedArray obj = new TwoSumSortedArray();
		int nums[] = { 2, 7, 11, 15 };
		int targert = 9;
		for (int i : obj.twoSum(nums, targert)) {
			System.out.print(i + " ");
		}
	}

	public int[] twoSum(int[] numbers, int target) {
		int small = 0, big = numbers.length-1;
		while (small < big) {
			int curr = numbers[small]+numbers[big];
			if (curr == target) {
				return new int[] {small+1, big+1};
			}
			if (curr < target)
				small++;
			if (curr > target)
				big --;
		}
		return new int[] {-1, -1};
	}
}
