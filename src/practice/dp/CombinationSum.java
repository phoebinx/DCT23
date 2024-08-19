package practice.dp;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public static void main(String args[]) {
		CombinationSum obj = new CombinationSum();
		int candidates[] = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> res = obj.combinationSum(candidates, target);
		for (List<Integer> list : res) {
			for (int num : list) {
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> resList = new ArrayList<>();
		List<Integer> curList = new ArrayList<>();;
		combinationSumUtil(0, 0, target, candidates, curList, resList);
		return resList;
	}	
	
	private void combinationSumUtil(int i, int total, int target, int[] candidates, List<Integer> curList, List<List<Integer>> resList) {
		if (total == target) {
			resList.add(List.copyOf(curList));
			return;
		}
		if (total > target || i >= candidates.length) return;
		
		//repeat candidates[i]
		curList.add(candidates[i]);
		combinationSumUtil(i, total+candidates[i], target, candidates, curList, resList);
		curList.remove(curList.size()-1);
		combinationSumUtil(i+1, total, target, candidates, curList, resList);
	}
}
