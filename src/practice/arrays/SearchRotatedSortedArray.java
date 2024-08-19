package practice.arrays;

public class SearchRotatedSortedArray {
	public static void main(String args[]) {
		SearchRotatedSortedArray obj = new SearchRotatedSortedArray();
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		System.out.println(obj.search(nums, target));
	}

	public int search(int[] nums, int target) {
		int l = 0;
		int r= nums.length-1;
		int mid;
		while(l<=r) {
			mid = (l+r)/2;
			if (nums[mid] == target) return mid;
			
			//left half is sorted
			if (nums[l] <= nums[mid]) {
				//if target is in left half
				if (target>=nums[l] && target<nums[mid])
					r = mid-1;
				else
					l = mid+1;
			}
			//right half is sorted
			else {
				//if target is in right half
				if (target>nums[mid] && target<=nums[r])
					l = mid+1;
				else
					r = mid-1;
			}
		}
		return -1;
	}
}
