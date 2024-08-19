package practice.strings;

public class PallindromicSubstrings {
	public static void main(String args[]) {
		PallindromicSubstrings obj = new PallindromicSubstrings();
		String s = "abc";
		System.out.println(obj.countSubstrings(s));
	}

	public int countSubstrings(String s) {
		int res = 0;
		if (s.length() == 0)
			return 0;
		for (int i = 0; i < s.length(); i++) {
			// odd length
			res  += addPallindrome(i, i, s);
			// even length
			res += addPallindrome(i, i + 1, s);
		}
		return res;
	}

	private int addPallindrome(int start, int end, String s) {
		if (s == null || start > end)
			return 0;
		int res = 0;
		while (start >= 0 && end < s.length() && start <= end && s.charAt(start) == s.charAt(end)) {
			res++;
			start--;
			end++;
		}
		return res;
	}
}
