package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfWaysToVisitNodei {
    
    private int V;

    LinkedList<Integer> adj[];

    NoOfWaysToVisitNodei(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int u) {
        adj[v].add(u);
        adj[u].add(v);
    }

    // public void noOfWaysToVisitNodeI(int node) {

    // }
    
    public void noOfWaysToVisitNodeI(int source) {
        boolean visited[] = new boolean[V];
        int[] ways = new int[V];
        int[] level = new int[V];

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        level[source] = 0;
        ways[source] = 1;

        while (!q.isEmpty()) {
            int v = q.poll();

            System.out.println("Node: " + v + " level: " + level[v] + " ways: " + ways[v]);
            
            for (int i : adj[v]) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    level[i] = level[v] + 1;
                    ways[i] = ways[v];
                } else {
                    if (level[i] == level[v] + 1) {
                        ways[i] += ways[v];
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        NoOfWaysToVisitNodei g = new NoOfWaysToVisitNodei(6);

        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        // g.noOfWaysToVisitNodeI(5);
        g.noOfWaysToVisitNodeI(1);
    }

}
