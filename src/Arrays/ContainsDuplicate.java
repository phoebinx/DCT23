package Arrays;

import java.util.HashSet;

public class ContainsDuplicate {
	public static void main(String args[]) {
		int nums [] = {1,2,3,1};
		ContainsDuplicate obj = new ContainsDuplicate();
		System.out.println(obj.containsDuplicate(nums));
	}
	
	public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
        	if (set.contains(num))
        		return true;
        	else 
        		set.add(num);
        }
        return false;
    }

}
