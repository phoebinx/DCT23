package interviews.intuit;

import java.util.Collections;
import java.util.HashMap;

public class DestroySequentialTargets {
	public static void main(String args[]) {
		DestroySequentialTargets obj = new DestroySequentialTargets();
		int[] nums = { 3, 7, 8, 1, 1, 5 };
		int space = 2;
		System.out.println(obj.destroyTargets(nums, space));
	}

	public int destroyTargets(int[] nums, int space) {
		//map's key will be num[i]%space
		HashMap<Integer, Integer> remainderMap = new HashMap<>();
		//populate freqMap
		for (int num:nums) {
			int remainder = num%space;
			remainderMap.put(remainder, remainderMap.getOrDefault(remainder, 0)+1);
		}
		
		int max = Collections.max(remainderMap.values());
		int result = Integer.MAX_VALUE;
		
		//find minNumber corresponding to key whoes value matches the frequency
		for (int num:nums) {
			int remainder = num%space;
			if (remainderMap.get(remainder) == max) {
				result = Math.min(result, num);
			}
		}
		return result;
	}
}
