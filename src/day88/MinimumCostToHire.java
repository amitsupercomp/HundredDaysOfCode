package day88;
import java.util.*;

class Worker implements Comparable<Worker> {
    final int q, w;
    public Worker(int q, int w) {
        this.q = q;
        this.w = w;
    }
    @Override
    public int compareTo(Worker other) {
        return Integer.compare(w * other.q, q * other.w);
    }
}

public class MinimumCostToHire {
	
	public static void main(String[] args) {
		int[] quality = {3,1,10,10,1}, wage = {4,8,2,2,7};
		int k = 3;
		System.out.println("Minimum wage :: " + mincostToHireWorkers(quality, wage, k));
	}
	
	private static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] a = new Worker[n];
        for (int i = 0; i < n; ++i) {
            a[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(a);
        int s = 0;
        double res = 1e15;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (Worker worker: a) {
            q.add(-worker.q);
            s += worker.q;
            if (q.size() > k) s += q.poll();
            if (q.size() == k) res = Math.min(res, (double) s * worker.w / worker.q);
        }
        return res;
    }

}
