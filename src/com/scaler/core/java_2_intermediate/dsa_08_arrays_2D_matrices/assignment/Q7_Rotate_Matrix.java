package com.scaler.core.java_2_intermediate.dsa_08_arrays_2D_matrices.assignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @created 26/09/22 7:20 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Q7_Rotate_Matrix {
    /**
     * Q7. Rotate Matrix
     * <p>
     * Problem Description
     * You are given a n x n 2D matrix A representing an image.
     * <p>
     * Rotate the image by 90 degrees (clockwise).
     * <p>
     * You need to do this in place.
     * <p>
     * Note: If you end up using an additional array, you will only receive partial score.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= n <= 1000
     * <p>
     * <p>
     * <p>
     * Input Format
     * First argument is a 2D matrix A of integers
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return the 2D rotated matrix.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * [
     * [1, 2],
     * [3, 4]
     * ]
     * Input 2:
     * <p>
     * [
     * [1]
     * ]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * [
     * [3, 1],
     * [4, 2]
     * ]
     * Output 2:
     * <p>
     * [
     * [1]
     * ]
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * After rotating the matrix by 90 degree:
     * 1 goes to 2, 2 goes to 4
     * 4 goes to 3, 3 goes to 1
     * Explanation 2:
     * <p>
     * 2D array remains the ssame as there is only element.
     **/
    private static void solve(ArrayList<ArrayList<Integer>> A) {
        int n;
        if (A == null)
            return;

        n = A.size();
        if (n == 0)
            return;

        int layers = n;
        int row1, col1, row2, col2;
        int num;
        int temp;
        int first, last;

        for (int layer = 0; layer < layers / 2; layer++) {
            first = layer;
            last = n - layer - 1;
            for (int i = first; i < last; i++) {
                int offset = i - layer;
                int top = A.get(first).get(i);
                A.get(first).set(i, A.get(last - offset).get(first));
                A.get(last - offset).set(first, A.get(last).get(last - offset));
                A.get(last).set(last - offset, A.get(i).get(last));
                A.get(i).set(last, top);

            }
        }
    }

    /**
     * Scaler Solution
     * <p>
     * Hint 1
     * Let’s say our matrix is,
     * <p>
     * * * * ^ * * *
     * * * * | * * *
     * * * * | * * *
     * * * * | * * *
     * After rotating right, it appears (observe arrow direction)
     * <p>
     * * * * *
     * * * * *
     * * * * *
     * -- - - >
     * * * * *
     * * * * *
     * * * * *
     * The idea is simple. Transform each row of the source matrix into the required column of the final matrix.
     * <p>
     * From the above picture, we can observe that.
     * <p>
     * first row of source ------> last column of destination
     * second row of source ------> last but-one column of destination
     * so ... on
     * last row of source ------> first column of destination
     * Thus, if we were allowed extra memory, the solution should be easy.
     * <p>
     * result[j][matrix.size() - i - 1] = matrix[i][j];
     * Now that you know the basic relation, can you do it in place ( without using extra memory )?
     * <p>
     * Solution Approach
     * Doing things in place can be slightly trickier.
     * <p>
     * Note that if you create a graph with each cell as the vertex with an edge from the source cell to the destination cell, the graph ends up with cycles of length 4.
     * <p>
     * This means something like this should work:
     * <p>
     * Divide the array into 4 along the diagonals
     * Place each element in the top quadrant into the slot 90 degrees clockwise
     * Place the old 90 in 180 degrees clockwise
     * Place the old 180 in 270 degrees
     * Lastly, place the old 270 in the original place
     * It might be easier to understand the solution if a few examples are tried out by hand.
     * Let me elaborate on a 3x3 example. You can try more examples of other sizes.
     * Let’s say the array is
     * <p>
     * [
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * ]
     * After rotation by 90 degrees, it should be
     * <p>
     * [
     * 7 4 1
     * 8 5 2
     * 9 6 3
     * ]
     * Let’s say you were allowed extra space and not required to do things in place.
     * <p>
     * Easier approach:
     * If you notice, if you read out the column ‘i’ in reverse order, it corresponds to the new row ‘i’ in the resulting array. So, column 0 in the original array read out in reverse order is 7 4 1, which is row 0 in answer. And so on. So you just simulate this approach and keep creating the result in another 2 D array.
     * <p>
     * However, this approach requires additional space of O(n^2) where n = number of rows in a 2D array.
     * <p>
     * Now let’s say we have to do things in place ( no extra space allowed ). This implies that we have to make things work by just moving elements around with constant extra memory.
     * So, let’s try to observe where elements need to end up in the result array.
     * <p>
     * * 7 needs to end up in 1's position.
     * * If 7 goes to 1's position, then we need to check where 1 needs to go otherwise, value 1 will be lost. 1 needs to go to 3's position.
     * * 3 needs to go to 9's position.
     * * 9 needs to go to 7's position.
     * * We already have placed 7 in 1's position.
     * So when we move these 4 elements, all 4 elements are in their correct position.
     * <p>
     * Let’s look at 4 now.
     * <p>
     * 4 -> 2 -> 6 -> 8.
     * Again, a group of 4. So, we can move these elements group by group without requiring creating a copy of the array.
     * <p>
     * You can try a few more examples to convince yourself.
     * <p>
     * The code just tries to simulate what’s being discussed here.
     **/
    private static void solve1(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        if (A == null || n == 0)
            return;
        int layers = n;
        for (int layer = 0; layer < layers / 2; layer++) {
            int first = layer;
            int last = n - layer - 1;
            for (int i = first; i < last; i++) {
                int offset = i - layer;
                int top = A.get(first).get(i);
                A.get(first).set(i, A.get(last - offset).get(first));
                A.get(last - offset).set(first, A.get(last).get(last - offset));
                A.get(last).set(last - offset, A.get(i).get(last));
                A.get(i).set(last, top);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        A.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        A.add(list2);
        solve(A);
        System.out.println(Arrays.deepToString(A.toArray()));

        ArrayList<ArrayList<Integer>> A1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        A1.add(list3);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(3);
        list4.add(4);
        A1.add(list4);
        solve1(A1);
        System.out.println(Arrays.deepToString(A.toArray()));
    }
}
