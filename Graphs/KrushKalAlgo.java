package Graphs;

import java.util.*;

public class KrushKalAlgo {
    public static class Edge {
    
        int src, dest, weight;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
        
    }

    //'Subset' class to store parent and rank for each node inorder to implement Union Find Algorithm (see notes for Disjoint Set)
    static class  Subset {
        int parent, rank;

        Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }    
        
    }


    //Kruskal's Algorithm to find Minimum Spanning Tree (MST)
    public static void kruskal(int v, List<Edge> edges) {

        int j = 0;
        int noOfEdges = 0;

        //creating the Disjoint Set
        Subset[] subsets = new Subset[v];

        Edge result[] = new Edge[v];

        for (int i = 0; i < v; i++) {
            subsets[i] = new Subset(i, 0);
        }

        //loop will run till all the edges are processed (n -1 edges)
        while (noOfEdges < v - 1) {

            Edge nextEdge = edges.get(j);
            
            int x = findRoot(subsets, nextEdge.src);
            int y = findRoot(subsets, nextEdge.dest);

            //if both the vertices are not connected(not form a cycle), that means we can add this edge to the MST
            if (x != y) {
                result[noOfEdges] = nextEdge;
                union(subsets, x, y);
                noOfEdges++;
            }
            j++;
        }

        System.out.println("Following are the edges in the constructed MST");
        int minCost = 0;
        for (int i = 0; i < noOfEdges; i++) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
            minCost += result[i].weight;
        }

        System.out.println("Total Weight of MST is: " + minCost);
    }

    //to find the parent of the set
    public static int findRoot(Subset[] subsets, int i) {
        if (subsets[i].parent == i) {
           return subsets[i].parent;
        }

        subsets[i].parent = findRoot(subsets, subsets[i].parent);
        return subsets[i].parent;
    }


    //to unite two disjoint sets
    public static void union( Subset[] subsets ,int x, int y) {
        int rootX = findRoot(subsets, x);
        int rootY = findRoot(subsets, y);

        if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else if (subsets[rootX].rank > subsets[rootY].rank) {
            subsets[rootY].parent = rootX;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }


    public static void main(String[] args) {
        int V = 4;
        List<Edge> edges = new ArrayList<Edge>(
            Arrays.asList(
                new Edge(0, 1, 10),
            new Edge(0, 2, 6),
            new Edge(0, 3, 5),
            new Edge(1, 3, 15),
            new Edge(2, 3, 4)
            )
        );

        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
            }
        });

        kruskal(V, edges);

    }




}

