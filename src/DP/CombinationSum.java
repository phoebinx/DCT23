package DP;

import java.util.ArrayList;
import java.util.List;
//time complexity is 2^target, because each decision tree can mean candidate 
//taken or not taken which is 2^number of candidates, 
//but the minimum value of candidate can be 1, and 1 can be taken or left 
//target number of times so, 2^target where target is the greatest depth when candidate is 1. 

public class CombinationSum {
	public static void main(String args[]) {
		CombinationSum obj = new CombinationSum();
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		for (List<Integer> list : obj.combinationSum(candidates, target)) {
			for (int i : list)
				System.out.print(i + " ");
			System.out.println();
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(0, new ArrayList<>(), 0, candidates, target, res);
		return res;
	}

	private void dfs(int i, List<Integer> curr, int total, int[] candidates, int target, List<List<Integer>> res) {
		if (total == target) {
			res.add(List.copyOf(curr));
			return;
		}			
		if (i >= candidates.length || total > target)
			return;
		//with candidate
		curr.add(candidates[i]);
		dfs(i, curr, total+candidates[i], candidates, target, res);
		//without candidate
		curr.remove(curr.size()-1);
		dfs(i+1, curr, total, candidates, target, res );
	}
}
