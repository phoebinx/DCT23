package heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFreq {
	public static void main(String args[]) {
		TopKFreq obj = new TopKFreq();
		int nums[] = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		int[] res = obj.topKFrequent(nums, k);
		for (int num : res) {
			System.out.print(num + " ");
		}
	}

	public int[] topKFrequent(int[] nums, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		HashMap<Integer, Integer> freqMap = frequencyMap(nums);
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
			return e1.getValue() - e2.getValue();
		});
		
		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			if (pq.size() >= k) {
				if (entry.getValue() > pq.peek().getValue()) {
					pq.poll();
				} else {
					continue;
				}
			}
			pq.offer(entry);
		}
		while (!pq.isEmpty()) {
			res.add(pq.poll().getKey());
		}
		Collections.reverse(res);
		return res.stream().mapToInt(i->i).toArray();
	}
	
	public HashMap<Integer, Integer> frequencyMap(int nums[]) {
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		for (int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		return freqMap;
	}
}
