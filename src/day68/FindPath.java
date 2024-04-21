package day68;

class UnionFind {
    private int[] root;
    private int[] rank;
    public UnionFind(int n) {
        this.root = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; ++i) {
            this.root[i] = i;
            this.rank[i] = 1;
        }
    }   
    public int find(int x) {
        if (this.root[x] != x) {
            this.root[x] = find(this.root[x]);
        }
        return this.root[x];
    }
    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX != rootY) {
            if (this.rank[rootX] > this.rank[rootY]) {
                int tmp = rootX;
                rootX = rootY;
                rootY = tmp;
            }
            this.root[rootX] = rootY;
            this.rank[rootY] += this.rank[rootX];
        }
    }
}

public class FindPath {
	
	public static void main(String[] args) {
		int[][] edges = {{0,1}, {1,2}, {2,0}};
		int n = 3, source = 0, destination = 2;
		System.out.println("Valid Path :: " + validPath(n, edges, source, destination));
	}
	
	private static boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);

       for (int[] edge : edges) {
           uf.union(edge[0], edge[1]);
       }

       return uf.find(source) == uf.find(destination);
   }

}
