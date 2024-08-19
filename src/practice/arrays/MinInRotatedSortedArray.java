package practice.arrays;

public class MinInRotatedSortedArray {
	public static void main(String args[]) {
		MinInRotatedSortedArray obj = new MinInRotatedSortedArray();
		int nums[] = { 3, 4, 5, 1, 2 };
		System.out.println(obj.findMin(nums));
	}

	public int findMin(int[] nums) {
		int min = Integer.MAX_VALUE;
		int l = 0;
		int r = nums.length - 1;
		int mid;
		while (l <= r) {
			if (nums[l] < nums[r]) {
				min = Math.min(min, nums[l]);
				break;
			}
			mid = l + r / 2;
			min = Math.min(min, nums[mid]);
			if (nums[mid] >= nums[l]) {
				// search right side
				l = mid + 1;
			} else {
				// search left side
				r = mid - 1;
			}

		}
		return min;
	}
}
