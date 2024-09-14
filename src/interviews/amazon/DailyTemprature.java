package interviews.amazon;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/
public class DailyTemprature {
	public static void main(String args[]) {
		DailyTemprature obj = new DailyTemprature();
		int temperatures[] = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int res[] = obj.dailyTemperatures(temperatures);
		for (int n : res)
			System.out.print(n + " ");
	}

	public int[] dailyTemperatures(int[] temperatures) {
		int res[] = new int[temperatures.length];
		Arrays.fill(res, 0);
		Stack<Pair> stack = new Stack<>();
		// Check for warmer temperatures in the future
		for (int i = 0; i < temperatures.length; i++) {
			int t = temperatures[i];
			while (!stack.isEmpty() && t > stack.peek().val) {
				// pop the top
				Pair top = stack.pop();
				res[top.index] = i - top.index;
			}
			stack.push(new Pair(t, i));
		}
		return res;
	}

	static class Pair {
		int val;
		int index;

		Pair(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}
}

//monotonic stack, contains decreasing order or val. (top is largest). Compare the new temp with top
// if greater, pop, set the right index, and insert the greater element. 
