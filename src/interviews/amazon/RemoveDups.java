package interviews.amazon;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDups {
	public static void main(String args[]) {
		RemoveDups obj = new RemoveDups();
		int nums[] = { 1, 1, 2 };
		System.out.println(obj.removeDuplicates(nums));
	}

	public int removeDuplicates(int[] nums) {
		int l = 1;
		;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) { // dup
				nums[l] = nums[i];
				l++;
			}
		}
		return l;

	}
}
