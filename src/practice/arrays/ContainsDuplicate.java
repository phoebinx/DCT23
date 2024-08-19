package practice.arrays;

import java.util.HashSet;

public class ContainsDuplicate {
	public static void main(String args[]) {
		ContainsDuplicate obj = new ContainsDuplicate();
		int arr[] = {1,2,3,1};
		System.out.println(obj.containsDuplicate(arr));
	}
	
	 public boolean containsDuplicate(int[] nums) {
		 HashSet<Integer> set = new HashSet<>();
		 for (int num : nums) {
			 if (set.contains(num)) return true;
			 set.add(num);
		 }
		 return false;
	 }

}
