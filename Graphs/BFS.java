package Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
    
    //Breadth First Search or Level Order Traversal.
    //Steps
    
    // 1. define No.of vertices and adjacency list
    private int V; // No. of vertices

    //2. define adjacency list
    LinkedList<Integer> adj[];

    //3. Constructor for initializing the adjacency list with null values
    BFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    //4. Function to add an edge into the graph
    void addEdge(int v, int w) {
            adj[v].add(w);   // v -> w   (directed edge)
            // adj[w].add(v);   // w -> v   (use this also if wanted undirected-edge)
    }

    //5. function for the BFS traversal 
    public void bfsTraversal(int v) {
        //mark all the vertices as not visited with default value as false in the visited array
        boolean[] visited = new boolean[V];
        int level[] = new int[V];

        //create an empty queue 
        LinkedList<Integer> queue = new LinkedList<Integer>();

        //mark the current node as visited and enqueue it
        visited[v] = true;
        level[v] = 0;

        //enqueue the current node
        queue.add(v);

        //loop will run till the queue is empty
        while (queue.size() != 0) {

            //dequeue a vertex from queue and print it, poll it out of the queue instead of pop because pop throws an exception if the queue is empty whereas poll returns null
            v = queue.poll();
            System.out.println(v + " " + " -> Level : " + level[v] );


            //get all adjacent vertices of the dequeued vertex v
            //if a adjacent has not been visited, mark it visited and enqueue it
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    level[n] = level[v] + 1;
                    queue.add(n);
                }
            }

        }

    }

    public static void main(String[] args) {

        //creating a graph
        BFS graph = new BFS(5);

        //adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        System.out.println("Following is Breadth First Traversal from vertex 0");
        //bfs traversal from vertex 0
        graph.bfsTraversal(0);
    }

}
