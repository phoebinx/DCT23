package interviews.amazon;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	public static void main(String args[]) {
		GenerateParenthesis obj = new GenerateParenthesis();
		int n = 3;
		List<String> res = obj.generateParenthesis(n);
		for (String s : res) {
			System.out.println(s);
		}
	}

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		backTrack(0, 0, n, sb, res);
		return res;
	}

	private void backTrack(int openCount, int closeCount, int n, StringBuilder sb, List<String> res) {
		if (openCount == n &&  closeCount == n) {
			res.add(sb.toString());
			return;
		}
		
		if (openCount < n) {
			sb.append("(");
			backTrack(openCount+1, closeCount, n, sb, res);
			sb.deleteCharAt(sb.length()-1);
		}
		
		if (closeCount < openCount) {
			sb.append(")");
			backTrack(openCount, closeCount+1, n, sb, res);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
