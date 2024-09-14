package interviews.amazon;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
	public static void main(String args[]) {
		NextGreaterElementII obj = new NextGreaterElementII();
		int nums[] = { 1, 2, 1 };
		int res[] = obj.nextGreaterElements(nums);
		for (int n : res) {
			System.out.print(n + " ");
		}
	}

	public int[] nextGreaterElements(int[] nums) {
		int res[] = new int[nums.length];
		Arrays.fill(res, -1);
		int n = nums.length;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n * 2; i++) {
			// current index of circular array
			int curidx = i % n;
			// while stack is not empty and curElement > top of stack
			while (!stack.isEmpty() && nums[curidx] > nums[stack.peek()]) {
				int index = stack.pop();
				res[index] = nums[curidx];
			}

			// Push current index onto stack if we are in the first pass -> i<n
			if (i < n) {
				stack.push(i);
			}
		}
		return res;
	}
}
