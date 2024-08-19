package practice.dp;

public class JumpGame {
	public static void main(String args[]) {
		JumpGame obj = new JumpGame();
		int num[] = {2,3,1,1,4};
		System.out.println(obj.canJump(num));
	}
	
	public boolean canJump(int[] nums) {
		int goal = nums.length-1;
		for (int i = nums.length-1; i>=0; i--) {
			if (i+nums[i] >= goal) {
				goal = i;
			}
		}
		return goal==0;
	}
}
