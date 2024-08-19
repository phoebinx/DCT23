package practice.strings;

public class LongestPallindromeSubstring {
	public static void main(String args[]) {
		LongestPallindromeSubstring obj = new LongestPallindromeSubstring();
		String s = "babad";
		System.out.println(obj.longestPalindrome(s));
	}

	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1) return "";
		StringBuilder sb = new StringBuilder();
		int resLen = 0;
		for (int i = 0; i < s.length(); i++) {
			// odd length
			resLen = findPalindrome(i, i, s, sb, resLen);
			// even length
			resLen = findPalindrome(i, i + 1, s, sb, resLen);
		}
		return sb.toString();
	}

	private int findPalindrome(int l, int r, String s, StringBuilder sb, int resLen) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			if (resLen < r - l + 1) {
				sb.setLength(0);
				sb.append(s.substring(l, r+1));
				resLen = sb.length();
			}
			l -= 1;
			r += 1;
		}
		return resLen;
	}
}
