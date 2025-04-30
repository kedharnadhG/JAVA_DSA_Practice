package Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
    
    // 'V' is the number of vertices in the graph
    private int V;

    // adjacency list is an array of linked list, adj[i] is a linked list of vertices adjacent to vertex i
    private LinkedList<Integer>[] adj;

    DFS(int v) {

        //initializing the vertex
        V = v;

        // adjacency list of graph of size v, i.e  v means number of vertices
        adj = new LinkedList[v];

        // loop is for initializing the adjacency list i.e for each vertex we are creating a linked list for adjacency
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }


    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    //utility function to track the visited vertices
    public void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        //after that we need to traverse all the adjacent vertices of the current vertex
        Iterator<Integer> itr = adj[v].listIterator();

        while (itr.hasNext()) {
            //getting the next adjacent vertex
            int n = itr.next();
            if (!visited[n]) {

                //if the vertex is not visited, mark it as visited
                //this is a recursive call, it ensures the stack procedure
                dfsUtil(n, visited);
            }
        }

    }


    // function for the DFS traversal
    public void dfsTraversal(int v) {
        boolean[] visited = new boolean[V];

        //calling the utility function for to mark the visited vertices
        dfsUtil(v, visited);

    }

    public static void main(String[] args) {
        DFS graph = new DFS(5);

        
        /* 
         
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        
        System.out.println("Following is Depth First Traversal for vertex 1");
        graph.dfsTraversal(1);


        */


        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        

        System.out.println("Following is Depth First Traversal for vertex 0");
        graph.dfsTraversal(0);

        

    }
}
