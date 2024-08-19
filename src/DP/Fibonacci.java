package DP;

public class Fibonacci {
	public static void main(String args[]) {
		Fibonacci obj = new Fibonacci();
		System.out.println(obj.fib(5));
	}

	private int fib(int i) {
		int memo [] = new int[i+1];
		memo[0] = 0;
		memo[1] = 1;
		for (int x = 2; x < i+1; x++) {
			memo[x] = memo[x-1] + memo[x-2];
		}
		return memo[i];
	}

}
