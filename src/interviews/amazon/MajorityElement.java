package interviews.amazon;

public class MajorityElement {
	public static void main(String args[]) {
		MajorityElement obj = new MajorityElement();
		int nums [] = {2,2,1,1,1,2,2};
		System.out.println(obj.majorityElement(nums));
	}

	public int majorityElement(int[] nums) {
		int res, count;
		res = count =0;
		for (int n:nums) {
			if (count == 0) res = n;
			count += (n==res)? 1: -1; // add 1 if same n as res else -1
		}
		return res;
	}
}
