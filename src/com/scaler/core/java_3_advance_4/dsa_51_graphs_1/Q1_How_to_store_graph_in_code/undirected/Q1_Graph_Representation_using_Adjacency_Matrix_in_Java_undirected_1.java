package com.scaler.core.java_3_advance_4.dsa_51_graphs_1.Q1_How_to_store_graph_in_code.undirected;

import com.scaler.core.java_3_advance_4.dsa_51_graphs_1.Q1_How_to_store_graph_in_code.directed.Q1_Graph_Representation_using_Adjacency_Matrix_in_Java_1;

import java.util.Scanner;

/**
 * @author Deepak Kumar Rai
 * @created 24/12/23
 * @project scaler_course_code
 */
public class Q1_Graph_Representation_using_Adjacency_Matrix_in_Java_undirected_1 {
    private int vertices;
    private int[][] adjacency_matrix;
    public Q1_Graph_Representation_using_Adjacency_Matrix_in_Java_undirected_1(int v) {
        this.vertices = v;
        this.adjacency_matrix = new int[vertices + 1][vertices + 1];
    }
    public void makeEdge(int to, int from, int edge) {
        try {
            adjacency_matrix[to][from] = edge;
            adjacency_matrix[from][to] = edge;//
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
    }
    public int getEdge(int to, int from) {
        try {
            return adjacency_matrix[to][from];
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("The vertices does not exists");
        }
        return -1;
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
        int v, e, count = 1, to = 0, from = 0;
        Scanner sc = new Scanner(System.in);
        Q1_Graph_Representation_using_Adjacency_Matrix_in_Java_1 graph;
        try {
            System.out.println("Enter the number of vertices: ");
            v = sc.nextInt();
            System.out.println("Enter the number of edges: ");
            e = sc.nextInt();
            graph = new Q1_Graph_Representation_using_Adjacency_Matrix_in_Java_1(v);
            System.out.println("Enter the edges: <to> <from>");
            while (count <= e) {
                to = sc.nextInt();
                from = sc.nextInt();
                graph.makeEdge(to, from, 1);
                count++;
            }
            System.out.println("The adjacency matrix for the given graph is: ");
            System.out.print("  ");
            for (int i = 1; i <= v; i++)
                System.out.print(i + " ");
            System.out.println();
            for (int i = 1; i <= v; i++) {
                System.out.print(i + " ");
                for (int j = 1; j <= v; j++)
                    System.out.print(graph.getEdge(i, j) + " ");
                System.out.println();
            }
        } catch (Exception E) {
            System.out.println("Something went wrong");
        }
        sc.close();
    }
}
