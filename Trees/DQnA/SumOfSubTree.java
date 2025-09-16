package Trees.DQnA;

import java.util.LinkedList;

public class SumOfSubTree {
    private int V;
    LinkedList<Integer> adj[];

    // max-Sum of subtree
    int answer = Integer.MIN_VALUE;

    public SumOfSubTree(int v) {
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

        for (int i : adj[v]) {
            if (!visited[i]) {
                visited[i] = true;
                parent[i] = v;
                dfsUtil(i, visited, parent, sum, b);
            }
        }

        int s = 0;

        

        for (int child : adj[v]) {
            if (child == parent[v]) {
                continue;
            } else {
                s += sum[child];
            }
        }
        sum[v] = s + b[v];

        answer = Math.max(answer, sum[v]);


        System.out.println("Node: " + v + " | Parent: " + parent[v] + " | Sum: " + sum[v]);


    }



    public void sumOfSubTreeNodeI(int[] b) {
        
        boolean[] visited = new boolean[V + 1];
        int[] sum = new int[V + 1];
        int[] parent = new int[V + 1];
        parent[1] = -1;
        dfsUtil(1, visited, parent, sum, b);

        System.out.println("----------------------------------");

        System.out.println("The Max Sum of Subtree is: " + answer);
        

    }



    public static void main(String[] args) {
        SumOfSubTree tree = new SumOfSubTree(7);
        tree.addEdge(1, 2);
        tree.addEdge(1, 3);
        tree.addEdge(2, 5);
        tree.addEdge(3, 6);

        //node values
        int[] b = new int [7];
        b[1] = 1;
        b[2] = 2;
        b[3] = 2;
        b[5] = 1;
        b[6] = 1;

        tree.sumOfSubTreeNodeI(b);

    }
}
