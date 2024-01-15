package com.scaler.core.java_3_advance_4.dsa_54_graphs_4.assignment;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @created 01/04/23 11:47 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q3_Capture_Regions_on_Board {
    boolean[][] visited;

    private void solve(ArrayList<ArrayList<Character>> a) {
        int m = a.size();
        int n = a.get(0).size();
        if (m == 1 && n == 1)
            return;
        visited = new boolean[m][n];
        //iterate boundary only
        int i = 0, j = 0;
        for (int k = 0; k < n - 1; k++) {//left to right
            if (a.get(i).get(j) == 'O') {
                dfs(i, j, m, n, a);
            }
            j++;
        }
        for (int k = 0; k < m - 1; k++) {//top to bottom
            if (a.get(i).get(j) == 'O') {
                dfs(i, j, m, n, a);
            }
            i++;
        }
        for (int k = 0; k < n - 1; k++) {// right to left
            if (a.get(i).get(j) == 'O') {
                dfs(i, j, m, n, a);
            }
            j--;
        }
        for (int k = 0; k < m - 1; k++) {//bottom to top
            if (a.get(i).get(j) == 'O') {
                dfs(i, j, m, n, a);
            }
            i--;
        }

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (visited[i][j])
                    a.get(i).set(j, 'O');
                else
                    a.get(i).set(j, 'X');
            }
        }
    }

    private void dfs(int x, int y, int m, int n, ArrayList<ArrayList<Character>> a) {
        if (x == m || y == n || x < 0 || y < 0 || a.get(x).get(y) == 'X' || visited[x][y])
            return;
        else
            visited[x][y] = true;
        dfs(x + 1, y, m, n, a);
        dfs(x, y + 1, m, n, a);
        dfs(x - 1, y, m, n, a);
        dfs(x, y - 1, m, n, a);
    }
    public static void printBoard(ArrayList<ArrayList<Character>> board) {
        for (ArrayList<Character> row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> A = new ArrayList<>();
        A.add(Stream.of('X', 'X', 'X', 'X').collect(Collectors.toCollection(ArrayList::new)));
        A.add(Stream.of('X', 'O', 'O', 'X').collect(Collectors.toCollection(ArrayList::new)));
        A.add(Stream.of('X', 'X', 'O', 'X').collect(Collectors.toCollection(ArrayList::new)));
        A.add(Stream.of('X', 'O', 'X', 'X').collect(Collectors.toCollection(ArrayList::new)));

        System.out.println("Original Board:");
        printBoard(A);

        Q3_Capture_Regions_on_Board solution = new Q3_Capture_Regions_on_Board();
        solution.solve(A);

        System.out.println("\nBoard after capturing regions surrounded by 'X':");
        printBoard(A);
    }
}
