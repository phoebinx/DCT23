package interviews.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnalyzeUserWebsitePattern {
	public static void main(String args[]) {
		AnalyzeUserWebsitePattern obj = new AnalyzeUserWebsitePattern();
		String[] username = { "joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary" };
		int[] timestamp = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		String[] website = { "home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career" };
		List<String> res = obj.mostVisitedPattern(username, timestamp, website);
		for (String s : res) {
			System.out.print(s + " ");
		}
	}

	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		HashMap<String, LinkedList<String>> userWebsiteMap = getUserWebsiteMap(username, timestamp, website);
		Map<String, Integer> patternCount = new HashMap<>();
		// maintains pattern user mapping
		Map<String, Set<String>> patternUsers = new HashMap<>();
		for (Map.Entry<String, LinkedList<String>> entry : userWebsiteMap.entrySet()) {
			String user = entry.getKey();
			List<String> websites = entry.getValue();
			for (int i = 0; i < websites.size() - 2; i++) {
				for (int j = i + 1; j < websites.size() - 1; j++) {
					for (int k = j + 1; k < websites.size(); k++) {
						String pattern = websites.get(i) + "," + websites.get(j) + "," + websites.get(k);
						patternUsers.computeIfAbsent(pattern, x -> new HashSet<>()).add(user);
					}
				}
			}
		}

		// Calculate the frequency of each pattern and find the one with the highest
		// score
		int maxCount = 0;
		String bestPattern = "";
		for (String pattern : patternUsers.keySet()) {
			int count = patternUsers.get(pattern).size();
			if (count > maxCount || (count == maxCount && pattern.compareTo(bestPattern) < 0)) {
				maxCount = count;
				bestPattern = pattern;
			}
		}

		return Arrays.asList(bestPattern.split(","));
	}

	private HashMap<String, LinkedList<String>> getUserWebsiteMap(String[] username, int[] timestamp,
			String[] website) {
		List<int[]> sortedVisits = new ArrayList<>();
		for (int i = 0; i < username.length; i++) {
			sortedVisits.add(new int[] { timestamp[i], i }); // Store timestamp and original index
		}

		// Sort the visits based on timestamp
		Collections.sort(sortedVisits, Comparator.comparingInt(a -> a[0]));

		HashMap<String, LinkedList<String>> userWebsiteMap = new HashMap<>();
		for (int[] visit : sortedVisits) {
			int i = visit[1];
			userWebsiteMap.computeIfAbsent(username[i], k -> new LinkedList<>()).add(website[i]);
		}

		return userWebsiteMap;
	}
}
