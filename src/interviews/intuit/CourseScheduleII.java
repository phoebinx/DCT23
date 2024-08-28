package interviews.intuit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

public class CourseScheduleII {
	public static void main(String args[]) {
		CourseScheduleII obj = new CourseScheduleII();
		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int res[] = obj.findOrder(numCourses, prerequisites);
		for (int num : res)
			System.out.println(num);
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> preReqMap = populateMap(prerequisites);
		LinkedHashSet<Integer> visited = new LinkedHashSet<>();
		for (int key : preReqMap.keySet()) {
			dfsUtil(key, visited, preReqMap);
		}
		return visited.stream().mapToInt(Integer::intValue).toArray();
	}

	private void dfsUtil(int key, LinkedHashSet<Integer> visited, HashMap<Integer, List<Integer>> preReqMap) {
		if (!preReqMap.containsKey(key) || preReqMap.get(key).size() == 0) {
			visited.add(key);
			return;
		}

		for (int val : preReqMap.get(key)) {
			if (!visited.contains(val)) {
				dfsUtil(val, visited, preReqMap);
			}
		}
		preReqMap.get(key).clear();
		visited.add(key);
	}

	private HashMap<Integer, List<Integer>> populateMap(int[][] prerequisites) {
		HashMap<Integer, List<Integer>> preReqMap = new HashMap<>();
		for (int[] preReq : prerequisites) {
			int key = preReq[0];
			int value = preReq[1];
			if (!preReqMap.containsKey(key)) {
				preReqMap.put(key, new ArrayList<>());
			}
			preReqMap.get(key).add(value);
		}
		return preReqMap;
	}
}
