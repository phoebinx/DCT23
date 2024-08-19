package practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseSchedule {
	public static void main(String args[]) {
		CourseSchedule obj = new CourseSchedule();
		int numCourses = 2;
		int[][] prerequisites = { { 1, 0 } , {0,1}};
		System.out.println(obj.canFinish(numCourses, prerequisites));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> courseMap = courseMap(numCourses, prerequisites);
		HashSet<Integer> visited = new HashSet<>();
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(i, courseMap, visited)) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(int course, HashMap<Integer, List<Integer>> courseMap, HashSet<Integer> visited) {
		if (visited.contains(course))
			return false;
		if (courseMap.get(course) == null || courseMap.get(course).size() == 0)
			return true;
		visited.add(course);
		for (int preReq : courseMap.get(course)) {
			if (!dfs(preReq, courseMap, visited))
				return false;
		}
		visited.remove(course);
		courseMap.put(course, null);
		return true;
	}

	private HashMap<Integer, List<Integer>> courseMap(int numCourses, int[][] prereq) {
		HashMap<Integer, List<Integer>> courseMap = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			courseMap.put(i, new ArrayList<>());
		}

		for (int i = 0; i < prereq.length; i++) {
			courseMap.get(prereq[i][0]).add(prereq[i][1]);
		}
		return courseMap;
	}
}
