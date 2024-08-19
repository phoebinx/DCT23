package Arrays;

import java.util.HashMap;

public class TwoSum {
	public static void main(String args[]) {
		TwoSum obj = new TwoSum();
		int target = 9;
		int [] nums = {2,7,11,15};
		int [] result = obj.twoSum(nums, target);
		for (int num: result)
			System.out.println(num);
	}
	public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
        	int num = nums[i];
            if (map.containsKey(num)) {
                int [] result = {i, map.get(num)};
                return result;
            } else {
                map.put(target-num, i);
            }
        }
        return null;
    }

}
