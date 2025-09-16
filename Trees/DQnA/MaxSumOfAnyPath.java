package Trees.DQnA;

import java.util.LinkedList;

public class MaxSumOfAnyPath {
    private int V;
    private long ans = Long.MIN_VALUE;
    LinkedList<Integer> adj[];

    public MaxSumOfAnyPath(int v) {
        this.V = v;
        adj = new LinkedList[v + 1];
        for (int i = 1; i <= v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int u) {
        adj[v].add(u);
        adj[u].add(v);
    }

    public void dfsUtil(int v, boolean[] visited, int[] parent, int[] sum, int[] b) {

        visited[v] = true;

        for (int node : adj[v]) {
            if (!visited[node]) {
                parent[node] = v;
                dfsUtil(node, visited, parent, sum, b);
            }
        }
        
        int s = 0;
        for (int child : adj[v]) {
            if (child == parent[v]) {
                continue;
            } else {
                s = Math.max(s, sum[child]);
            }
        }
        
        sum[v] = s + b[v];
        
        ans = Math.max(ans, sum[v]);
    }


    public void maxSumOfAnyPath(int source, int[] b) {
        
        boolean[] visited = new boolean[V + 1];
        int[] sum = new int[V + 1];
        int[] parent = new int[V + 1];
        parent[1] = -1;
        dfsUtil(source, visited, parent, sum, b);



        System.out.println("The Max Sum of Subtree is: " + ans);


    }





    public static void main(String[] args) {
        MaxSumOfAnyPath g = new MaxSumOfAnyPath(8);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);

        int[] b = new int[8];
        b[1] = -5;
        b[2] = -8;
        b[3] = -1;
        b[4] = -3;
        b[5] = 5;
        b[6] = 10;
        b[7] = 8;

        g.maxSumOfAnyPath(1, b);
    }

}
