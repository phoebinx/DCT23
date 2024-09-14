package interviews.amazon;

import java.util.ArrayList;
import java.util.List;

public class PallindromePartitioning {
	public static void main(String args[]) {
		PallindromePartitioning obj = new PallindromePartitioning();
		String s = "aab";
		List<List<String>> res = obj.partition(s);
		for (List<String> list : res) {
			for (String str : list) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}

	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> curPart = new ArrayList<>();
		dfs(s, res, curPart, 0);
		return res;
	}

	private void dfs(String s, List<List<String>> res, List<String> curPar, int i) {
		if (i >= s.length()) {
			// Make a copy of curPar to avoid modification in the next calls
			res.add(new ArrayList<>(curPar));
			return;
		}

		for (int j = i; j < s.length(); j++) {
			if (isPallin(i, j, s)) {
				String curString = s.substring(i, j + 1);
				curPar.add(curString);
				dfs(s, res, curPar, j + 1);
				// remove string for other permutaitons
				curPar.remove(curPar.size() - 1);
			}
		}

	}

	private boolean isPallin(int i, int j, String s) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
