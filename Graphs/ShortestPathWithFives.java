package Graphs;

import java.util.*;

public class ShortestPathWithFives {
    private int n;
    private List<Integer>[] adj;
    private int[] nodeVal; // stores 0 or 5 for each node

    ShortestPathWithFives(int n) {
        this.n = n;
        adj = new ArrayList[n + 1]; // 1-based indexing
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        nodeVal = new int[n + 1];
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    void setNodeValue(int i, int val) {
        nodeVal[i] = val;
    }

    public void bfsWithFives(int source) {
        int[] dist = new int[n + 1];
        int[] maxFives = new int[n + 1];
        int[] ways = new int[n + 1];
        Arrays.fill(dist, -1); // unvisited

        Queue<Integer> q = new LinkedList<>();
        dist[source] = 0;
        maxFives[source] = (nodeVal[source] == 5 ? 1 : 0);
        ways[source] = 1;
        q.add(source);

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int u : adj[v]) {
                if (dist[u] == -1) {
                    // first time visiting u
                    dist[u] = dist[v] + 1;
                    ways[u] = ways[v];
                    maxFives[u] = maxFives[v] + (nodeVal[u] == 5 ? 1 : 0);
                    q.add(u);
                } else if (dist[u] == dist[v] + 1) {
                    // already shortest path, but check max fives
                    // candidate shortest path
                    int fivesThroughV = maxFives[v] + (nodeVal[u] == 5 ? 1 : 0);

                    if (fivesThroughV > maxFives[u]) {
                        maxFives[u] = fivesThroughV;
                        ways[u] = ways[v]; // reset to only this best option
                    } else if (fivesThroughV == maxFives[u]) {
                        ways[u] += ways[v]; // add another equally good option
                    }
                }
            }
        }

        // Output
        for (int i = 1; i <= n; i++) {
            if (dist[i] == -1) {
                System.out.println("Node " + i + " is unreachable");
            } else {
                System.out.println("Node " + i + ": distance = " + dist[i] +  ", ways = " + ways[i] +
                                   ", maxFives = " + maxFives[i]);
            }
        }
    }

    public static void main(String[] args) {
        ShortestPathWithFives g = new ShortestPathWithFives(6);

        // Example graph
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);

        // node values (0 or 5)
        g.setNodeValue(1, 0);
        g.setNodeValue(2, 5);
        g.setNodeValue(3, 5);
        g.setNodeValue(4, 0);
        g.setNodeValue(5, 5);
        g.setNodeValue(6, 0);

        g.bfsWithFives(1);
    }
}
