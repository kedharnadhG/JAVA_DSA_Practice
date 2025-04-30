package Graphs;

import java.util.*;

//TODO: implement TopoSort using BFS

public class TopoSortDfs {
    
     // 'V' is the number of vertices in the graph
    private int V;

    // adjacency list is an array of linked list, adj[i] is a linked list of vertices adjacent to vertex i
    private LinkedList<Integer>[] adj;

    TopoSortDfs(int v) {

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


    public void topoSort(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        
        Integer i;

        //loop will run till all the adjacent vertices of the current vertex are visited
        Iterator<Integer> itr = adj[v].iterator();
        while (itr.hasNext()) {
            i = itr.next();
            if (!visited[i]) {
                topoSort(i, visited, stack);
            }
        }

        //pushing the current vertex in the stack
        stack.push(v);
    
    }

    public void printTopoSort(int v) {
        boolean visited[] = new boolean[V];
        for(int i = 0; i < v; i++) {
            visited[i] = false;
        }
        Stack<Integer> stack = new Stack<>();

        //loop will run till all the vertices are visited
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topoSort(i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }


    public static void main(String[] args) {
        TopoSortDfs g = new TopoSortDfs(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        //topological sort
        g.printTopoSort(6);

    }

}
