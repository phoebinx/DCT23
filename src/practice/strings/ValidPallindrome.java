package practice.strings;

public class ValidPallindrome {
	public static void main(String args[]) {
		ValidPallindrome obj = new ValidPallindrome();
		String s = "A man, a plan, a canal: Panama";
		System.out.println(obj.isPalindrome(s));
	}

	public boolean isPalindrome(String s) {
		String str = parse(s);
		if (str.length() == 0)
			return true; // Check for an empty string

		int start = 0;
		int end = str.length() - 1;

		while (start < end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	private String parse(String s) {
		if (s == null || s.length() == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (isValidAlphaNumeric(c)) {
				sb.append(Character.toLowerCase(c));
			}
		}
		return sb.toString();
	}

	private boolean isValidAlphaNumeric(char c) {
		return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}
}
