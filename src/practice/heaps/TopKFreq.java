package practice.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFreq {
	public static void main(String args[]) {
		TopKFreq obj = new TopKFreq();
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		for (int num : obj.topKFrequent(nums, k)) {
			System.out.print(num+" ");
		}
	}

	public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> freqMap = populateFreqMap(nums, k);
		PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((e1, e2) -> {
			return e2.getValue() - e1.getValue();
		});
		pq.addAll(freqMap.entrySet());
		int res[] = new int[k];
		int i = 0;
		while (i<k) {
			res[i] = pq.poll().getKey();
			i++;
		}
		return res;
	}

	private HashMap<Integer, Integer> populateFreqMap(int[] nums, int k) {
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		for (int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
		}
		return freqMap;
	}
}
