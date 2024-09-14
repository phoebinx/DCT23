package interviews.amazon;

import java.util.HashMap;

//https://www.youtube.com/watch?v=fFVZt-6sgyo
public class SubarraySumEqualsK {
	public static void main(String args[]) {
		SubarraySumEqualsK obj = new SubarraySumEqualsK();
		int[] nums = { 1 };
		int k = 0;
		System.out.println(obj.subarraySum(nums, k));
	}

	public int subarraySum(int[] nums, int k) {
		//prefixSum, frequency map 
		//sumSoFar
		//sumSoFar-k is what we want to look in the map and that freq+total
		int total = 0;
		int curSum = 0;
		HashMap<Integer, Integer> prefixSum  = new HashMap<>();
		prefixSum.put(0, 1); //number of ways to get a sum of 0 is 1
		for (int n:nums) {
			curSum+=n;
			int diff = curSum-k;
			total += prefixSum.getOrDefault(diff, 0);
			// Update the current sum in the map
	        prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0) + 1);
		}
		return total;
	}	
}
// basically maintain curSum in the map so in futre if you need x-k = curSum, (which essential is curSum+x = k, you have it in you map
// and you can count how many times it occured too. 