package DP;

import java.util.Arrays;

public class CombinationSum4 {
	public static void main(String args[]) {
		CombinationSum4 obj = new CombinationSum4();
		int [] nums = {1,2,3}; int target = 4;
		System.out.println(obj.combinationSum4(nums, target));
	}

	public int combinationSum4(int[] nums, int target) {
		int mem[] = new int[target+1];
		Arrays.sort(nums);
		mem[0] = 1;
		for (int i = 0; i <= target; i++) {
			for (int j = 0; j<nums.length; j++) {
				if (nums[j] <= i) {
					mem[i] += mem[i-nums[j]];
				}
			}
		}
		return mem[target];
	}
}

/*
 * In the "Combination Sum 4" problem, mem[i] represents the number of different
 * combinations that add up to the amount i using the elements from the nums
 * array.
 * 
 * Base Case (mem[0] = 1): Interpretation: There is exactly one way to make up
 * the amount 0, which is to choose nothing. This is considered a valid
 * combination (the empty set), so mem[0] is initialized to 1. Reasoning: When
 * considering combinations to reach a particular sum, the empty set is a valid
 * way to sum up to zero. Thus, the number of ways to form the sum 0 is 1.
 */
/*
 * combinationSum4 Method:
 * 
 * Initialization:
 * 
 * An array mem of size target + 1 is initialized. This array will be used to
 * store the number of combinations that sum up to each value from 0 to target.
 * mem[0] is set to 1, which serves as the base case. There is one way to reach
 * the sum 0: by using no elements. Dynamic Programming Approach:
 * 
 * The method uses two nested loops to fill the mem array. The outer loop
 * iterates over all possible sums from 0 to target (variable i). The inner loop
 * iterates over each number in the nums array (variable j). For each number
 * nums[j], the algorithm checks if it can be used to form the current sum i
 * (i.e., if nums[j] <= i). If so, it adds the number of ways to form the sum i
 * - nums[j] (which is mem[i - nums[j]]) to mem[i]. Result:
 * 
 * After filling the mem array, mem[target] contains the number of ways to form
 * the target sum using the numbers in nums. How the Algorithm Works The
 * algorithm uses dynamic programming to build up the number of combinations for
 * each sum incrementally. The key idea is that if you know the number of ways
 * to form a smaller sum, you can determine the number of ways to form a larger
 * sum by adding an available number from nums.
 * 
 * For example, to find the number of ways to form the sum 4 using {1, 2, 3}:
 * 
 * You can form 4 by adding 1 to the ways to form 3. You can form 4 by adding 2
 * to the ways to form 2. You can form 4 by adding 3 to the ways to form 1. By
 * summing up these possibilities, you get the total number of ways to form the
 * target sum.
 * 
 * Time Complexity The time complexity of this algorithm is 𝑂 ( target × 𝑛 )
 * O(target×n), where n is the number of elements in nums. This is because the
 * algorithm iterates over the range from 0 to target and, for each value,
 * iterates over the nums array.
 * 
 * Space Complexity The space complexity is 𝑂 ( target ) O(target) due to the
 * mem array, which stores the number of ways to form each sum up to target.
 */