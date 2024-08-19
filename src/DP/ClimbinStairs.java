package DP;

public class ClimbinStairs {
	public static void main(String args[]) {
		ClimbinStairs obj = new ClimbinStairs();
		System.out.println(obj.climbStairs(5));
	}

	public int climbStairs(int n) {
		int last = 1, secondLast = 1;
		for (int i = n-2; i>=0 ; i--) {
			int temp = secondLast;
			secondLast = last + secondLast;
			last = temp;			
		}
		return secondLast;
	}
}
