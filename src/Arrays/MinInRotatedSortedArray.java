package Arrays;

// if middle value is > left most, middle is part of the left sorted array, if middle value 
// is less than left most, middle is part of right sorted array 
public class MinInRotatedSortedArray {

	public static void main(String args[]) {
		MinInRotatedSortedArray obj = new MinInRotatedSortedArray();
		int[] nums = { 2, 3, 4, 5, 1 };
		System.out.println(obj.findMin(nums));
	}

	public int findMin(int[] nums) {
		int min = Integer.MAX_VALUE;
		int l = 0, r = nums.length - 1;
		while (l <= r) { // when sorted array is len number of times so its like sorted
			if (nums[l] < nums[r]) {
				min = Math.min(nums[l], min);
				break;
			}
			int mid = l + (r - l) / 2;
			min = Math.min(nums[mid], min);
			if (nums[mid] >= nums[l]) {
				// search in the right sorted array
				l = mid + 1;
			} else {
				// search the left array since the 2nd sorted array began there
				r = mid - 1;
			}
		}
		return min;
	}

}