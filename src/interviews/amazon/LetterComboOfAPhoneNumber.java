package interviews.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number
public class LetterComboOfAPhoneNumber {
	public static void main(String args[]) {
		LetterComboOfAPhoneNumber obj = new LetterComboOfAPhoneNumber();
		String digits = "23";
		List<String> res = obj.letterCombinations(digits);
		for (String s : res)
			System.out.print(s + " ");
	}

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits.length() == 0)
			return res;
		HashMap<Integer, String> numToCharMap = buildNumCharMap(digits);
		StringBuilder sb = new StringBuilder();
		backTrack(0, digits, sb, res, numToCharMap);
		return res;
	}

	private void backTrack(int i, String digits, StringBuilder sb, List<String> res,
			HashMap<Integer, String> numToCharMap) {
		// Base case: when sb has reached the length of the digits string
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }

        // Get the current digit and the corresponding characters
        int curDigit = digits.charAt(i) - '0';
        String chars = numToCharMap.get(curDigit);

        // Loop through the characters corresponding to the current digit
        for (char c : chars.toCharArray()) {
            sb.append(c);  // Add the current character to the combination
            backTrack(i + 1, digits, sb, res, numToCharMap);  // Recur for the next digit
            sb.deleteCharAt(sb.length() - 1);  // Remove the last character (backtrack)
        }
	}

	private HashMap<Integer, String> buildNumCharMap(String digits) {
		HashMap<Integer, String> numToCharMap = new HashMap<>();
		numToCharMap.put(2, "abc");
		numToCharMap.put(3, "def");
		numToCharMap.put(4, "ghi");
		numToCharMap.put(5, "jkl");
		numToCharMap.put(6, "mno");
		numToCharMap.put(7, "pqrs");
		numToCharMap.put(8, "tuv");
		numToCharMap.put(9, "wxyz");
		return numToCharMap;
	}
}
