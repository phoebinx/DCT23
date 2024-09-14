package interviews.amazon;

public class SearchInsertPosition {
	public static void main(String args[]) {
		SearchInsertPosition obj = new SearchInsertPosition();
		int[] nums = { 1, 3, 5, 6 };
		int target = 5;
		System.out.println(obj.searchInsert(nums, target));
	}

	public int searchInsert(int[] nums, int target) {
		return searchInsertUtil(nums, target, 0, nums.length - 1);
	}

	private int searchInsertUtil(int nums[], int target, int start, int end) {
		if (start > end) {
			return start; // Position where target should be inserted
		}
		int mid = start + (end - start) / 2;
		if (target == nums[mid]) {
            return mid;  // Target found, return its index
        } else if (target < nums[mid]) {
            return searchInsertUtil(nums, target, start, mid - 1);  // Search in the left half
        } else {
            return searchInsertUtil(nums, target, mid + 1, end);  // Search in the right half
        }
	}
}
