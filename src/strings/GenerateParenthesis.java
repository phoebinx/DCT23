package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//lc 22
public class GenerateParenthesis {
	public static void main(String args[]) {
		GenerateParenthesis obj = new GenerateParenthesis();
		List<String> res = obj.generateParenthesis(3);
		for (String str: res) 
			System.out.println(str);
	}

	public List<String> generateParenthesis(int n) {
		Stack<String> stack = new Stack<>();
		List<String> res = new ArrayList<>();
		backtrack(res, "", 0, 0, n);
		return res;
	}
	
	private void backtrack(List<String> res, String currentString, int open, int close, int max) {
		if (currentString.length() == max*2) {
			res.add(currentString);
			return;
		}
		if (open<max) {
			backtrack(res, currentString+"(", open+1, close, max);
		}
		if (close<open) {
			backtrack(res, currentString+")", open, close+1, max);
		}
		
	}
}
