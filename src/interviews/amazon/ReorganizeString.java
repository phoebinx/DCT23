package interviews.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

//https://leetcode.com/problems/reorganize-string/description/?envType=company&envId=amazon&favoriteSlug=amazon-three-months&difficulty=MEDIUM%2CEASY
public class ReorganizeString {
	public static void main(String args[]) {
		ReorganizeString obj = new ReorganizeString();
		String s = "aab";
		System.out.println(obj.reorganizeString(s));
	}

	public String reorganizeString(String s) {
		// Get a priority queue (max heap) based on character frequencies
		PriorityQueue<Map.Entry<Character, Integer>> pq = getCharFreqPriorityQueue(s);

		StringBuilder sb = new StringBuilder();
		// Keep track of the previous entry (to ensure no adjacent same chars)
		Map.Entry<Character, Integer> prev = null;

		while (!pq.isEmpty()) {
			// Poll the most frequent character
			Map.Entry<Character, Integer> current = pq.poll();

			// Append the character to the result string
			sb.append(current.getKey());

			// Decrease the frequency of the character
			current.setValue(current.getValue() - 1);

			// If the previous character is not null and its frequency is still > 0, add it
			// back
			if (prev != null && prev.getValue() > 0) {
				pq.offer(prev); // Add the previous entry back to the queue
			}

			// Set the current entry as the new previous one (for the next iteration)
			prev = current;
		}

		// If the result length doesn't match the input string's length, reorganization
		// is impossible
		return sb.length() == s.length() ? sb.toString() : "";
	}

	private PriorityQueue<Map.Entry<Character, Integer>> getCharFreqPriorityQueue(String s) {
		// Create character frequency map
		HashMap<Character, Integer> charMap = new HashMap<>();
		for (char c : s.toCharArray()) {
			charMap.put(c, charMap.getOrDefault(c, 0) + 1);
		}

		// Create a max-heap (priority queue) based on the frequencies of characters
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
			return e2.getValue() - e1.getValue(); // Descending order by frequency
		});

		// Add all entries from the map to the priority queue
		pq.addAll(charMap.entrySet());

		return pq;
	}
}
