package practice.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
	public static void main(String args[]) {
		GroupAnagram obj = new GroupAnagram();
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> res = obj.groupAnagrams(strs);
		for (List<String> list : res) {
			for (String str : list) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] cArray = str.toCharArray();
			Arrays.sort(cArray);
			String temp = new String(cArray);
			if (!map.containsKey(temp)) {
				map.put(temp, new ArrayList<>());
			}
			map.get(temp).add(str);
		}
		res.addAll(map.values());
		return res;
	}
}
