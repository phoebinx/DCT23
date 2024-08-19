package practice.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {
	public static void main(String args[]) {
		EncodeDecodeStrings obj = new EncodeDecodeStrings();
		List<String> strs = Arrays.asList("he#llo", "wo#rld");
		String encodedStr = obj.encode(strs);
		System.out.println("encoded strs" + encodedStr);
		List<String> decodedStrs = obj.decode(encodedStr);
		for (String str : decodedStrs) {
			System.out.print(str + " ");
		}
	}

	public String encode(List<String> strs) {
		if (strs == null || strs.size() == 0) return "";
		StringBuilder sb = new StringBuilder();
		for (String str:strs) {
			sb.append(str.length()).append('#').append(str);
		}
		return sb.toString();
	}

	/*
	 * @param str: A string
	 * 
	 * @return: decodes a single string to a list of strings
	 */
	public List<String> decode(String str) {
		List<String> strs = new ArrayList<>();
		if (str == null || str == "") return strs;
		int i = 0;
		int start;
		int count = 0;
		while (i<str.length()) {
			start = i;
			while(str.charAt(i) != '#') {
				i++;
			}
			count = Integer.parseInt(str.substring(start, i));
			i++;
			strs.add(str.substring(i, i+count));
			i = i+count;
		}
		return strs;
	}
}
