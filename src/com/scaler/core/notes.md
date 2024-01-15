### DSA 10 Sliding Window
#### Q2_Min_no_of_swaps_to_bring_all_no_together
```Java
public class Q2_Min_no_of_swaps_to_bring_all_no_together {
    private static int solve(int[] A, int N, int B) {
        int count = 0;
        // Count of good elements
        for (int i = 0; i < N; i++) {
            if (A[i] <= B) {
                count++;
            }
        }
        if (count <= 1) {
            return 0;
        }
        int badElements = 0;
        // Get number of bad elements in first window
        for (int i = 0; i < count; i++) {
            if (A[i] > B) {
                badElements++;
            }
        }
        int ans = badElements;
        int start = 1, end = count;
        while (end < N) {
            if (A[start - 1] > B) { // Out going
                badElements--;
            }
            if (A[end] > B) { // In coming
                badElements++; 
            }
            ans = Math.min(ans, badElements);
            start++;
            end++;
        }
        return ans;
    }
    public static void main(String[] args) {
        logStart();
        
        int[] A = {8, 3, 10, 20, 22, 13, 1, 2, 55, 5, 15, 50};
        int B = 5, N = A.length;

        int result = solve(A, N, B);
        PrintUtils.print(result);
        
        logEnd();
    }
    private static void logStart() {
        System.out.println("----------------------log Start----------------------");
    }
    private static void logEnd() {
        System.out.println("-----------------------log End-----------------------");
    }
}
```
#### Q3_Print_the_boundary_in_clockwise_direction
```Java
public class Q3_Print_the_boundary_in_clockwise_direction {
    private static void printBoundary(int[][] mat) {
        int N = mat.length;
        int row =  0, column = 0;
        // Top row: Left to right
        for (int i = 1; i < N; i++) {
            System.out.print(mat[row][column] + ", ");
            column++;
        }
        // Last column: top to bottom
        for (int i = 1; i < N; i++) {
            System.out.print(mat[row][column] + ", ");
            row++;
        }
        // Last row: Right to left
        for (int i = 1; i < N; i++) {
            System.out.print(mat[row][column] + ", ");
            column--;
        }
        // First Column: Bottom to top
        for (int i = 1; i < N; i++) {
            System.out.print(mat[row][column] + ", ");
            row--;
        }
    }
    public static void main(String[] args) {
        logStart();
        
        int[][] A = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25},
        };

        printBoundary(A);
        
        logEnd();
    }
    private static void logStart() {
        System.out.println("----------------------log Start----------------------");
    }
    private static void logEnd() {
        System.out.println("\n-----------------------log End-----------------------");
    }
}
```
#### Q4_Print_Spiral
```Java
public class Q4_Print_Spiral {
    private static void spiral(int[][] mat) {
        int N = mat.length;
        int row = 0, column = 0;
        while (N > 1) {
            // Top row: Left to right
            for (int i = 1; i < N; i++) {
                System.out.print(mat[row][column] + ", ");
                column++;
            }
            // Last column: top to bottom
            for (int i = 1; i < N; i++) {
                System.out.print(mat[row][column] + ", ");
                row++;
            }
            // Last row: Right to left
            for (int i = 1; i < N; i++) {
                System.out.print(mat[row][column] + ", ");
                column--;
            }
            // First Column: Bottom to top
            for (int i = 1; i < N; i++) {
                System.out.print(mat[row][column] + ", ");
                row--;
            }
            row++;
            column++;
            N = N - 2;
            System.out.println();
        }
        if (N == 1) {
            System.out.print(mat[row][column] + ", ");
        }
    }
    public static void main(String[] args) {
        logStart();
        
        int[][] A = {
            {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 10, 11, 12},
            {13, 14, 15, 16, 17, 18},
            {19, 20, 21, 22, 23, 24},
            {25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36},
        };
        spiral(A);

        logEnd();
    }
    private static void logStart() {
        System.out.println("----------------------log Start----------------------");
    }
    private static void logEnd() {
        System.out.println("\n-----------------------log End-----------------------");
    }
}
```
### dsa_11_arrays_interview_problems_1
#### Q1_At_most_replace_a_single_0
```Java
public class Q1_At_most_replace_a_single_0 {
    private static int replace(int[] A, int N) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            count = count + A[i];
        }
        if (count == N) { // Edge Case 1
            return N;
        }
        if (count == 0) { // dge Case 2
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == 0) {
                int left = 0, right = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (A[j] == 1) {
                        left++;
                    } else {
                        break;
                    }
                }
                for (int j = i + 1; j < N; j++) {
                    if (A[i] == 1) {
                        right++;
                    } else {
                        break;
                    }
                }
                int countElements = left + right + 1;
                if (countElements > ans) {
                    ans = countElements;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        logStart();
        
        int[] A = {1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1};
        int N = A.length;

        int result = replace(A, N);
        PrintUtils.print(result);
        
        logEnd();
    }
    private static void logStart() {
        System.out.println("----------------------log Start----------------------");
    }
    private static void logEnd() {
        System.out.println("-----------------------log End-----------------------");
    }
}
```
#### Q2_At_most_1_swap
```Java
public class Q2_At_most_1_swap {
    private static int swap(int[] A, int N) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            count = count + A[i];
        }
        if (count == N) { // Edge Case 1
            return N;
        }
        if (count == 0) { // dge Case 2
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == 0) {
                int left = 0, right = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (A[j] == 1) {
                        left++;
                    } else {
                        break;
                    }
                }
                for (int j = i + 1; j < N; j++) {
                    if (A[j] == 1) {
                        right++;
                    } else {
                        break;
                    }
                }
                int countElements = left + right;
                if (left + right < count) { // Extra 1
                    count++;
                }
                if (ans < countElements) {
                    ans = countElements;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        logStart();
        
        int[] A = {0, 1, 1, 1, 0, 1, 1, 0, 0};
        int N = A.length;

        int result = swap(A, N);
        PrintUtils.print(result);
        
        logEnd();
    }
    private static void logStart() {
        System.out.println("----------------------log Start----------------------");
    }
    private static void logEnd() {
        System.out.println("-----------------------log End-----------------------");
    }
}
```

#### Q3_Number_of_trplets
```Java
public class Q3_Number_of_trplets {
    private static int countTriplets(int[] A, int N) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (A[i] < A[j] && A[j] < A[k]) {
                        count++;
                    }
                }   
            }
        }
        return count;
    }
    // Optimise One
    private static int countTriplets1(int[] A, int N) {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int left = 0, right = 0;
            // Check left for elements less than A[i]
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    left++;
                }
            }
            // Check on right for elements mor than A[i]
            for (int j = i + 1; j < N; j++) {
                if (A[i] < A[j]) {
                    right++;
                }
            }
            int count = left * right; // Multiply here 
            ans = ans + count;
        }
        return ans;
    }
    public static void main(String[] args) {
        logStart();
        
        int[] A = {4, 1, 2, 6, 9, 7};
        int N = A.length;

        int result = countTriplets(A, N);
        PrintUtils.print(result);

        result = countTriplets1(A, N);
        PrintUtils.print(result);
        
        logEnd();
    }
    private static void logStart() {
        System.out.println("----------------------log Start----------------------");
    }
    private static void logEnd() {
        System.out.println("-----------------------log End-----------------------");
    }
}
```
#### Q4_Josephus_Problem 
```Java
public class Q4_Josephus_Problem {
    /**
     * Problem: Josephus Problem
     * N people standing in a circle (clockwise).
     * Person one has a knife. He kills the next person in clockwise direction.
     * He pass the knife to surviving person in clockwise direction.
     * Repeat the same process unit one survives.
     * Find last last people standing.
     * **/
    public static void main(String[] args) {
        
    }
}
```
### dsa_01_arrays_1
#### Q1_Add_val_from_index_onwards
```java
public class Q1_Add_val_from_index_onwards {
    /**
     * Problem: Given array A[N], where all elements are zero.
     * Given a query Q which has index and value. Add the value from index onwards.
     * **/
    // Bruteforce Approach
    private static int[] addValByIdxThroughQueries(int[] A, int[][] Q) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < Q.length; i++) {
            int index = Q[i][0];
            int value = Q[i][1];
            for (int k = index; k < N; k++) {
                ans[k] = ans[k] + value;
            }
        }
        return ans;
    }
    // Optimise Approach
    private static int[] addValByIdxThroughQueries1(int[] A, int[][] Q) {
        int N = A.length, M = Q.length;
        while (M-- > 0) {
            // Given index and value
            int index = Q[M][0];
            int value = Q[M][1];
            A[index] += value;
        }
        // Create prefix sum array in original array
        // A[0] -> Do nothing
        for (int i = 1; i < N; i++) {
            A[i] = A[i - 1] + A[i];
        }
        return A;
    }
    public static void main(String[] args) {
        logStart();
        
        int[] A = new int[7];
        int[][] Q = {{2, 4}, {3, -1}, {0, 2}, {4, 1}};
        PrintUtils.print(A);
        
        int[] results = addValByIdxThroughQueries(A, Q);
        PrintUtils.print(results);
        
        System.out.println("-----------------------------------------------------");

        int[] A1 = new int[7];
        int[][] Q1 = {{2, 4}, {3, -1}, {0, 2}, {4, 1}};
        PrintUtils.print(A);
        
        int[] results1 = addValByIdxThroughQueries1(A1, Q1);
        PrintUtils.print(results1);
        
        logEnd();
    }
    private static void logStart() {
        System.out.println("----------------------log Start----------------------");
    }
    private static void logEnd() {
        System.out.println("-----------------------log End-----------------------");
    }
}
```
#### Q2_Add_val_from_start_to_end_onwards
```Java
public class Q2_Add_val_from_start_to_end_onwards {
    private static int[] addValByStartToEndThroughQueries(int[] A, int[][] Q) {
        int N = A.length, M = Q.length;
        while (M-- > 0) {
            // Given index and value
            int start = Q[M][0];
            int end = Q[M][1];
            int value = Q[M][2];
            A[start] += value;
            if (end + 1 < N) {
                A[end + 1] -= value;
            }
        }
        // Create prefix sum array in original array
        // A[0] -> Do nothing
        for (int i = 1; i < N; i++) {
            A[i] = A[i - 1] + A[i];
        }
        return A;
    }
    public static void main(String[] args) {
        logStart();
        
        int[] A = new int[10];
        int[][] Q = {{3, 6, 1}, {2, 7, 3}, {5, 8, -3}, {1, 9, 2}};
        PrintUtils.print(A);
        
        int[] results = addValByStartToEndThroughQueries(A, Q);
        PrintUtils.print(results);
        
        logEnd();
    }
    private static void logStart() {
        System.out.println("----------------------log Start----------------------");
    }
    private static void logEnd() {
        System.out.println("-----------------------log End-----------------------");
    }
}
```

