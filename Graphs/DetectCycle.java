package Graphs;

import java.util.*;

//TODO: check for directed graph

public class DetectCycle {
    // 1. define No.of vertices and adjacency list
    private int V; // No. of vertices

    //2. define adjacency list
    LinkedList<Integer> adj[];

    //3. Constructor for initializing the adjacency list with null values
    DetectCycle(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    //4. Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }


    //this function checks that the given undirected graph is cyclic or not

    public boolean isCyclicUtil(int v, boolean visited[], int parent) {
        //mark the current vertex as visited
        visited[v] = true;

        Iterator<Integer> itr = adj[v].iterator();
        Integer i;
        while (itr.hasNext()) {
            i = itr.next();
            if (!visited[i]) {
                //if the vertex is not visited, mark it as visited
                if (isCyclicUtil(i, visited, v))
                    //if there is a cycle, return true
                    return true;
            } 
            //if the vertex is visited and it is not the parent of the current vertex, return true
            else if (i != parent)
                return true;
        }
        return false;
    }

    public boolean isCyclic(int v) {
        boolean visited[] = new boolean[v];
        
        for(int i = 0; i < v; i++) {
            if(!visited[i]) {
                if(isCyclicUtil(i, visited, -1)) {
                    return true;
                }
            }
        }

        System.out.println("Graph doesn't contain cycle");
        return false;
    }

    public static void main(String[] args) {
        DetectCycle g = new DetectCycle(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 0);
        
        if(g.isCyclic(5))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
        
    }

}








/*

    Case	                                     Meaning	                                                           Action
    i == parent	                                Came back to the parent node (expected in undirected graph)	            Ignore (not a cycle)
    i != parent and visited[i] == true	        Came to an already visited node not via parent → a cycle exists	        Cycle Found (Return true)


    🔥 Why?
    In an undirected graph, every edge is "two-way."

    When you move from u -> v, there is also an implied v -> u.

    So when visiting neighbors, if you find your parent, it’s normal.

    But if you find a visited node that is not your parent, it means you have looped around — 🌀 cycle detected!

⚡ Visual small example:
    Copy
    Edit
    0 — 1
    |  /
    2
    From 0 -> 1 → ok.

    From 1 -> 2 → ok.

    From 2 -> 0 → uh-oh!

    0 is already visited.

    0 is NOT parent of 2 → 🚨 CYCLE!

    So yes, even if cycle is not visible immediately, visited[i] == true && i != parent is sufficient to say cycle is there ✅.


----------------------------------------------------------

    🔑 Key Explanation
        When checking neighbors of a vertex v, if a neighbor i is already visited and it's not the parent, it means we've come back to an earlier node via another path, which forms a cycle in an undirected graph.


 
    🔁 Final Rule of Thumb:

    Case	Means	Cycle?
    !visited[i]	Unvisited → go deeper	❓
    visited[i] && i == parent	Back edge to parent	❌
    visited[i] && i != parent	Hit visited node not via parent	✅
    ✅ TL;DR
    Cycle is only when:

    You hit a node that you already visited and it’s not your parent.

    You must not count i == parent as a cycle → that's just the way you came.


*/
