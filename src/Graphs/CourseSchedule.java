package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CourseSchedule {
	public static void main(String args[]) {
		CourseSchedule obj = new CourseSchedule();
		int numCourses = 2;
		int prerequisites [][] = {{1,0}};
		System.out.println(obj.canFinish(numCourses, prerequisites));
	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preReqMap = populatePreReqMap(numCourses, prerequisites);
        printMap(preReqMap);
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
        	if (!dfs(i, preReqMap, visited)) return false;
        }
        return true;
    }
	
	private boolean dfs(int currentCourse, HashMap<Integer, List<Integer>> preReqMap, HashSet<Integer> visited) {
		if (visited.contains(currentCourse)) return false;
		if (preReqMap.get(currentCourse) == null || preReqMap.get(currentCourse).size() == 0) return true; // no prereq
		visited.add(currentCourse);
		for (int preReq : preReqMap.get(currentCourse)) {
			if (!dfs(preReq, preReqMap, visited)) return false;
		}
		visited.remove(currentCourse);
		preReqMap.put(currentCourse, null); // means that all the prereqs can be visited so no need to do this again.
		return true;
	}

	private HashMap<Integer, List<Integer>> populatePreReqMap(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> preReqMap =new HashMap<>();
		//prepopulate since not all courses may be a part of the prerequisites array by we still need to add all the courses
		for (int i = 0; i < numCourses; i++) {
			preReqMap.put(i, new ArrayList<Integer>());
		}
		for (int i = 0; i <prerequisites.length; i++) {
			preReqMap.get(prerequisites[i][0]).add(prerequisites[i][1]);						
		}
		return preReqMap;
	}
	
	private void printMap(HashMap<Integer, List<Integer>> preReqMap) {
		for (Entry<Integer, List<Integer>> entry : preReqMap.entrySet()) {
        	System.out.println(entry.getKey()+":");
        	for (Integer value:entry.getValue()) {
        		System.out.print(value+ " ");
        	}
        }
	}
}
