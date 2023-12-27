package com.scaler.core.java_3_advance_4.dsa_51_graphs_1.Q1_How_to_store_graph_in_code.directed;

import java.util.*;

/**
 * @author Deepak Kumar Rai
 * @created 23/12/23
 * @project scaler_course_code
 */
public class Q1_Graph_Representation_using_Adjacency_List_in_Java_1 {
    private Map<Integer, List<Integer>> adjacencyList;
    public Q1_Graph_Representation_using_Adjacency_List_in_Java_1(int v) {
        adjacencyList = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            adjacencyList.put(i, new LinkedList<>());
        }
    }
    public void setEdge(int to, int from) {
        if (to > adjacencyList.size() || from > adjacencyList.size()) {
            System.out.println("The vertices does not exists");
        }
        List<Integer> sls = adjacencyList.get(to);
        sls.add(from);
    }
    public List<Integer> getEdge(int to) {
        if (to > adjacencyList.size()) {
            System.out.println("The vertices does not exists");
            return null;
        }
        return adjacencyList.get(to);
    }
    /**
     * Inputs:
     * Enter the number of vertices:
     * 4
     * Enter the number of edges:
     * 5
     * Enter the edges: <to> <from>
     * 1 2
     * 1 3
     * 2 3
     * 3 4
     * 4 2
     * The adjacency matrix for the given graph is:
     *   1 2 3 4
     * 1 0 1 1 0
     * 2 0 0 1 0
     * 3 0 0 0 1
     * 4 0 1 0 0
     * **/
    public static void main(String[] args) {
        int v, e, count = 1, to, from;
        Scanner sc = new Scanner(System.in);
        Q1_Graph_Representation_using_Adjacency_List_in_Java_1 glist;
        try {
            System.out.println("Enter the number of vertices: ");
            v = sc.nextInt();
            System.out.println("Enter the number of edges: ");
            e = sc.nextInt();

            glist = new Q1_Graph_Representation_using_Adjacency_List_in_Java_1(v);

            System.out.println("Enter the edges in the graph : <to> <from>");
            while (count <= e) {
                to = sc.nextInt();
                from = sc.nextInt();

                glist.setEdge(to, from);
                count++;
            }

            System.out.println("The Adjacency List Representation of the graph is: ");
            for (int i = 1; i <= v; i++) {
                System.out.print(i + "->");
                List<Integer> edgeList = glist.getEdge(i);
                for (int j = 1; ; j++) {
                    if (j != edgeList.size())
                        System.out.print(edgeList.get(j - 1) + " -> ");
                    else {
                        System.out.print(edgeList.get(j - 1));
                        break;
                    }
                }
                System.out.println();
            }
        } catch (Exception E) {
            System.out.println("Something went wrong");
        }
        sc.close();
    }
}
