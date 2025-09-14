package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class VisitNodeiFromSource {
    
    private int V;

    LinkedList<Integer> adj[];

    VisitNodeiFromSource(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int u) {
        adj[v].add(u);
        adj[u].add(v);
    }


    public void isNodeVisitableFromSource(int source) {
        boolean[] visited = new boolean[V];

        int level[] = new int[V];
        Arrays.fill(level, -1);

        Queue<Integer> q = new LinkedList<>();

        visited[source] = true;
        level[source] = 0;
        q.add(source);

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int i : adj[v]) {
                if (visited[i] == false) {
                    visited[i] = true;
                    level[i] = level[v] + 1;
                    q.offer(i);
                }
            }
        }

        for (int i = 1; i <V; i++) {
            if(visited[i] == false) {
                System.out.println(i + " is not visitable from " + source);
            } else {
                System.out.println(i + " is visitable from " + source + " at level " + level[i]);
            }
        }
    }


    public static void main(String[] args) {
        VisitNodeiFromSource g = new VisitNodeiFromSource(5);
        
        g.addEdge(1, 2);
        g.addEdge(3, 2);
        g.addEdge(3, 4);

        g.isNodeVisitableFromSource( 1);
        
    }

}
