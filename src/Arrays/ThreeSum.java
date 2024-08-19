package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/3sum/description/
//first half is sort it to handle dups later
// second half is similar to finding target in sorted array - big and small pointers 
public class ThreeSum {
	public static void main(String args[]) {
		int nums[] = { -1, 0, 1, 2, -1, -4 };
		ThreeSum obj = new ThreeSum();
		List<List<Integer>> res = obj.threeSum(nums);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length == 0)
			return res;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { // remove dups
				int target = 0 - nums[i];
				int small = i + 1, big = nums.length - 1;
				while (small < big) { // finding target in a sorted array
					if (nums[small] + nums[big] == target) {
						res.add(Arrays.asList(nums[small], nums[big], nums[i]));
						// remove dups
						while (small < big && nums[small] == nums[small + 1])
							small++;
						while (small < big && nums[big] == nums[big - 1])
							big--;
						small++;
						big--;
					} else if ((nums[small] + nums[big]) > target) {
						big--;
					} else {
						small++;
					}
				}
			}
		}
		return res;
	}
}
