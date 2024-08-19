package Arrays;

public class SearchInRotatedSortedArray {
	public static void main(String args[]) {
		SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
		int nums[] = { 3, 1 };
		int target = 1;
		System.out.println(obj.search(nums, target));
	}

	public int search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			// left sorted array
			if (nums[l] <= nums[mid]) {
				if ((target < nums[l]) || (target > nums[mid]))
					l = mid + 1;
				else
					r = mid - 1;
			} else { // right sorted array
				if (target < nums[mid] || target > nums[r])
					r = mid - 1;
				else
					l = mid + 1;
			}
		}
		return -1;
	}
}
