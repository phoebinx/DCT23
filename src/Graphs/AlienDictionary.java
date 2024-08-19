package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

//REcStack is needed for cycle detection , for counting distinct elemenst, just visited is enough 
public class AlienDictionary {
	public static void main(String args[]) {
		AlienDictionary obj = new AlienDictionary();
		String arr[] = { "wrt", "wrf", "er", "ett", "rftt" };
		System.out.println(obj.alienOrder(arr));
	}

	public String alienOrder(String[] words) {
		HashMap<Character, Set<Character>> map = buildGraph(words);
		HashSet<Character> visited = new HashSet<>();
		HashSet<Character> recStack = new HashSet<>();
		Stack<Character> res = new Stack<>();
		for (Character c : map.keySet()) {
			if (!dfs(c, map, recStack, visited, res)) return "";
		}
		String resStr = new StringBuilder(res.toString()).reverse().toString();
		// the first [ and last ] is needed for the regex, indicates find whatever is inside the [] and replac with "", also the \\[ is escapeing [. 
		
		return resStr.replaceAll("[\\[\\]]", "");
	}

	private boolean dfs(Character c, HashMap<Character, Set<Character>> map, HashSet<Character> recStack,
			HashSet<Character> visited, Stack<Character> res) {
		if (recStack.contains(c)) return false; //there is a cycle
		if (visited.contains(c)) return true;
		recStack.add(c); visited.add(c);
		for (Character neighbor: map.get(c)) {
			if (!dfs(neighbor, map, recStack, visited, res)) return false;
		}
		recStack.remove(c);
		res.push(c);
		return true;
	}
	
	private HashMap<Character, Set<Character>> buildGraph(String[] words) {
		HashMap<Character, Set<Character>> map = new HashMap<>();
		//default initialization for all char so the char with no outdegree is not left out
		for (String word : words) {
			for (char c : word.toCharArray()) {
				if (!map.containsKey(c))
					map.put(c, new HashSet<Character>());
			}
		}
		Character out, in;
		int len;
		for (int i = 1; i < words.length; i++) {
			len = Math.min(words[i - 1].length(), words[i].length());
			for (int j = 0; j < len; j++) {
				out = words[i - 1].charAt(j);
				in = words[i].charAt(j);
				if (in != out) {
					map.get(out).add(in);
				}
			}
		}
		return map;
	}
	
	private void printMap(HashMap<Character, Set<Character>> map) {
		for (Entry<Character, Set<Character>> entry : map.entrySet()) {
			System.out.print(entry.getKey() + ":");
			for (Character value : entry.getValue())
				System.out.print(value + " ");
			System.out.println();
		}
	}
}