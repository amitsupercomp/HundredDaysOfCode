package day75;
import java.util.*;

public class SumOfDistInTree {

	static int[][] graph;
	static int[] count;
	static int[] res;
	static int N;
	
	public static void main(String[] args) {
		int n = 6;
		int[][] edges = {{0,1}, {0,2}, {2,3}, {2,4}, {2,5}};
		System.out.println("Output :: " + Arrays.toString(sumOfDistancesInTree(n, edges)));
	}

	private static int[] sumOfDistancesInTree(int N, int[][] edges) {
		SumOfDistInTree.N = N;
		SumOfDistInTree.res = new int[N];
		SumOfDistInTree.graph = new int[N][];
		SumOfDistInTree.count = new int[N];

		for (int[] e : edges) {
			++count[e[0]];
			++count[e[1]];
		}
		for (int i = 0; i < N; i++) {
			graph[i] = new int[count[i]];
		}
		for (int[] e : edges) {
			graph[e[0]][--count[e[0]]] = e[1];
			graph[e[1]][--count[e[1]]] = e[0];
		}
		dfs1(0, -1);
		dfs2(0, -1);
		return res;
	}
	private static void dfs1(int cur, int parent) {
		count[cur] = 1;
		for (int child : graph[cur]) {
			if (child != parent) {
				dfs1(child, cur);
				count[cur] += count[child];
				res[cur] += res[child] + count[child];
			}
		}
	}
	private static void dfs2(int cur, int parent) {
		for (int child : graph[cur]) {
			if (child != parent) {
				res[child] = res[cur] + N - 2 * count[child];
				dfs2(child, cur);
			}
		}
	}

}
