package practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String args[]) {
		ThreeSum obj = new ThreeSum();
		int nums[] = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> res = obj.threeSum(nums);
		for (List<Integer> list : res) {
			for (int num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3)
			return res;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue; // remove dups
			int target = 0 - nums[i];
			int low = i + 1, high = nums.length - 1;
			while (low < high) {
				if (nums[low] + nums[high] == target) {
					res.add(Arrays.asList(nums[low], nums[high], nums[i]));
					while (low < high && nums[low] == nums[low + 1])
						low++;
					while (low < high && nums[high] == nums[high - 1])
						high--;
					low++;
					high--;
				} else if (target > nums[low] + nums[high]) {
					low++;
				} else {
					high--;
				}
			}
		}
		return res;
	}
}
