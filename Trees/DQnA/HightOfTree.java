package Trees.DQnA;

import java.util.LinkedList;

public class HightOfTree {

    private int V;
    LinkedList<Integer> adj[];

    public HightOfTree(int v) {
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


    public void dfsUtil(int v, boolean[] visited, int[] parent, int[] height) {
        visited[v] = true;
        
        for (int i : adj[v]) {
            if (!visited[i]) {
                parent[i] = v;
                dfsUtil(i, visited, parent, height);
            }
        }

        // Print (node) ----> parent
        
        int h = 0;
        
        for (int child : adj[v]) {
            if (child == parent[v]) {
                
                // means the child node is parent of the node, i.e not the child
                continue;
            } else {
                h = Math.max(h, height[child]);
            }
        }
        
        height[v] = h + 1; // height's of all the childs + 1
        
        System.out.println("Node: " + v + 
                       " | Parent: " + parent[v] + 
                       " | Height: " + height[v]);

    }


    public void printHightOfTree(int v) {

        boolean[] visited = new boolean[V + 1];
        int[] parent = new int[V + 1];
        int[] height = new int[V + 1];
        parent[v] = -1;
        dfsUtil(v, visited, parent, height);

    }



    public static void main(String[] args) {
        
        HightOfTree g = new HightOfTree(7);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);

        g.printHightOfTree(1);


    }

}
