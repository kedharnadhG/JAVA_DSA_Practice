package Trees.DQnA;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfOnesTillNodei {

    private int V;
    LinkedList<Integer> adj[];

    public NoOfOnesTillNodei(int v) {
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

    public void printNoOfOnesTillNodeI(int[] b) {
        boolean visited[] = new boolean[b.length];
        int ans[] = new int[b.length];
        ans[1] = b[1];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int v : adj[node]) {
                if (!visited[v]) {
                    q.add(v);
                    visited[v] = true;

                    if (b[v] == 1) {
                        ans[v] = ans[node] + 1;
                    } else {
                        ans[v] = ans[node];
                    }

                }

            }
            
            System.out.println("Node " + node + " has " + ans[node] + " ones till it");
        } 

    }
    

    public static void main(String[] args) {
        NoOfOnesTillNodei g = new NoOfOnesTillNodei(7);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 6);
        g.addEdge(3, 7);

        // array for each node ( 0 or 1 )
        int[] nodeValues = new int[8];
        nodeValues[1] = 0;
        nodeValues[2] = 1;
        nodeValues[3] = 0;
        nodeValues[4] = 1;
        nodeValues[5] = 1;
        nodeValues[6] = 1;
        nodeValues[7] = 0;

        g.printNoOfOnesTillNodeI(nodeValues);

    }


}
