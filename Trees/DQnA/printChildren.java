package Trees.DQnA;

import java.util.LinkedList;
import java.util.Queue;

public class printChildren {
    private int V;
    LinkedList<Integer> adj[];

    public printChildren(int v) {
        this.V = v;
        adj = new LinkedList[v+1];
        for (int i = 1; i <=v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int u) {
        adj[v].add(u);
        adj[u].add(v);
    }

    public void printChilds() {
        boolean[] visited = new boolean[V + 1];
        int[] childCnt = new int[V + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        // int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int v : adj[node]) {
                if (!visited[v]) {
                    q.offer(v);
                    visited[v] = true;
                    childCnt[node]++;
                }
            }

            System.out.println("Node " + node + " has " + childCnt[node] + " children");

        }
        
        int i = 1;
        while (i <= V) {
            if(childCnt[i] == 0){
                System.out.println("Node " + i + " is a leaf");
            }
            i++;
        }
        
        
    }


    public static void main(String[] args) {
        printChildren p = new printChildren(5);

        p.addEdge(1, 2);
        p.addEdge(1, 3);
        p.addEdge(3, 4);
        p.addEdge(3, 5);

        p.printChilds();

    }

}
