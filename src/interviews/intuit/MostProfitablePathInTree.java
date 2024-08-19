package interviews.intuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostProfitablePathInTree {
	List<Integer>[] adjList;
	int[] bobTime;

	public static void main(String args[]) {
		MostProfitablePathInTree obj = new MostProfitablePathInTree();
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 3, 4 } };
		int bob = 3;
		int[] amount = { -2, 4, 2, -4, 6 };
		System.out.println(obj.mostProfitablePath(edges, bob, amount));
	}

	public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
		int n = amount.length;
		getAdjList(edges, n);
		bobTime = new int[n];
		Arrays.fill(bobTime, -1);

		// determine bob's arrival time at each node
		dfsBob(bob, -1, 0);

		// dfs alice to find maxProfit
		return dfsAlice(0, -1, 0, amount);
		// return maxProfit;
	}

	// since bob is going towards leaf, there will only be one path, no competition.
	private boolean dfsBob(int node, int parent, int time) {
		if (node == 0) {
			bobTime[node] = time;
			return true;
		}
		for (int neighbor : adjList[node]) {
			if (neighbor != parent) {
				if (dfsBob(neighbor, node, time + 1)) {
					bobTime[node] = time;
					return true;
				}
			}
		}
		return false;
	}

	// since alice is going towards leaf, many possible paths
	private int dfsAlice(int node, int parent, int time, int[] amount) {
		int curAmount;
		int bTime = bobTime[node];
		if (bTime < 0 || bTime > time) {
			curAmount = amount[node];
		} else if (bTime == time) {
			curAmount = amount[node] / 2;
		} else {
			curAmount = 0;
		}

		int maxChildIncome = Integer.MIN_VALUE;

		for (int neighbor : adjList[node]) {
			if (neighbor == parent)
				continue;
			maxChildIncome = Math.max(maxChildIncome, dfsAlice(neighbor, node, time + 1, amount));
		}

		// If it’s a leaf node, return the current amount

		return maxChildIncome == Integer.MIN_VALUE ? curAmount : curAmount + maxChildIncome;
	}

	@SuppressWarnings("unchecked")
	private void getAdjList(int[][] edges, int n) {
		adjList = new ArrayList[n];
		// initializelist
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<>();
		}
		// populate adj list
		for (int[] edge : edges) {
			adjList[edge[0]].add(edge[1]);
			adjList[edge[1]].add(edge[0]);
		}
	}
}
