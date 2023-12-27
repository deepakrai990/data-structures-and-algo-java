package com.scaler.core.java_3_advance_4.dsa_52_graphs_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Deepak Kumar Rai
 * @created 25/12/23
 * @project scaler_course_code
 */
public class Q6_Construct_Roads_1 {
    /**
     * Problem: A country consists of N cities all connected via N - 2 roads.
     * King of that country wants to construct maximum roads such that cities can be divided into
     * two sets & there is no road between cities of the same set.
     * Find the maximum number of new roads the king can construct.
     * **/
    private int numVertices;
    private List<List<Integer>> adjacencyList;
    private boolean[] visited;
    private Set<Integer> set0;
    private Set<Integer> set1;

    public Q6_Construct_Roads_1(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        this.visited = new boolean[numVertices];
        this.set0 = new HashSet<>();
        this.set1 = new HashSet<>();
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // For an undirected graph
    }

    public void constructRoads() {
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                dfs(i, 0); // Start DFS traversal from city i with distance 0
            }
        }
        // Calculate the maximum number of new roads the king can construct
        long maxRoads = (long) set0.size() * set1.size() - (numVertices - 1);
        System.out.println("Maximum number of new roads the king can construct: " + maxRoads);
    }

    private void dfs(int currentVertex, int distance) {
        visited[currentVertex] = true;
        if (distance % 2 == 0) {
            set0.add(currentVertex);
        } else {
            set1.add(currentVertex);
        }
        for (int neighbor : adjacencyList.get(currentVertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, distance + 1);
            }
        }
    }
    public static void main(String[] args) {
        // Example usage
        int numCities = 6;  // Replace with the actual number of cities
        Q6_Construct_Roads_1 graph = new Q6_Construct_Roads_1(numCities);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        // Find the maximum number of new roads the king can construct
        graph.constructRoads();
    }
}
