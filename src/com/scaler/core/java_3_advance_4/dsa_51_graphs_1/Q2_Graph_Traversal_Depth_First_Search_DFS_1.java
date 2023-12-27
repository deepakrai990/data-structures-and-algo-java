package com.scaler.core.java_3_advance_4.dsa_51_graphs_1;

import java.util.*;

/**
 * @author Deepak Kumar Rai
 * @created 23/12/23
 * @project scaler_course_code
 */
public class Q2_Graph_Traversal_Depth_First_Search_DFS_1 {
    /**
     * Graph Traversal DFS
     * In simple words, traversal means the process of visiting every node in the graph.
     * There are 2 standard methods of graph traversal Breadth-First Search and Depth First Search
     * Depth First Search
     * Depth First Search (DFS) is a graph traversal algorithm, where
     * we start from a selected(source) node and go into the depth of
     * this node by recursively calling the DFS function until no children are encountered.
     * When the dead-end is reached, this algorithm backtracks and starts visiting
     * the other children of the current node.
     * **/
    private int numVertices;
    private List<List<Integer>> adjacencyList;

    public Q2_Graph_Traversal_Depth_First_Search_DFS_1(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>();
        for (int i = 0; i < this.numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        // adjacencyList.get(destination).add(source); // For undirected graph
    }

    private boolean[] visited;
    private  void traversalDFS(int N /* number of nodes */) {
        visited = new boolean[N + 1];
        Arrays.fill(visited, false);
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                this.dfs(i);
            }
        }
    }
    private void dfs(int s) {
        System.out.print(s + ", ");
        visited[s] = true;
        for (List<Integer> list: this.adjacencyList) {
            for (int v : list) {
                if (!visited[v]) {
                    dfs(v);
                }
            }
        }
    }
    public static void main(String[] args) {
        int numNodes = 5;
        Q2_Graph_Traversal_Depth_First_Search_DFS_1 graph =
                new Q2_Graph_Traversal_Depth_First_Search_DFS_1(numNodes);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);

        System.out.println("Depth First Search starting from node 0:");
        graph.traversalDFS(numNodes);
    }
}
