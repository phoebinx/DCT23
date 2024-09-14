package interviews.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	public static void main(String argsp[]) {
		GroupAnagrams obj = new GroupAnagrams();
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> res = obj.groupAnagrams(strs);
		for (List<String> list : res) {
			for (String item : list) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> result = new HashMap<>();
		for (String str : strs) {
			char[] strArray = str.toCharArray();
			Arrays.sort(strArray);
			String key = new String(strArray);
			if (!result.containsKey(key)) {
				result.put(key, new ArrayList<>());
			}
			result.get(key).add(str);
		}
		return new ArrayList<>(result.values());
	}

}
