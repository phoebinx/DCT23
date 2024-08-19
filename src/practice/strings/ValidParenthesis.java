package practice.strings;

import java.util.Stack;

public class ValidParenthesis {
	public static void main(String args[]) {
		ValidParenthesis obj = new ValidParenthesis();
		String s = "()[]{}";
		System.out.println(obj.isValid(s));
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			switch (c) {
			case '(':
				stack.push(')');
				break;
			case '{':
				stack.push('}');
				break;
			case '[':
				stack.push(']');
				break;
			default:
				if (stack.isEmpty() || stack.pop() != c)
					return false;
				break;
			}
		}
		return stack.isEmpty();
	}
}
