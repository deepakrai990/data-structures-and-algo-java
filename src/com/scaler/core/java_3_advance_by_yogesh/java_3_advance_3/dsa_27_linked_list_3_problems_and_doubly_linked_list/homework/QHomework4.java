package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_27_linked_list_3_problems_and_doubly_linked_list.homework;

import java.util.LinkedList;

/**
 * @created 02/03/23 1:34 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework4 {
    static int counter = -1;

    public int[] solve(int[][] A) {
        int arr[] = new int[A.length];
        LinkedList<Integer> al = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            int val = A[i][0];
            switch (val) {
                case 1:
                    push(A[i][1], arr);
                    break;
                case 2:
                    int num = pop(arr);
                    al.add(num);
                    break;
                case 3:
                    int mid = midElement(arr);
                    al.add(mid);
                    break;
                case 4:
                    deleteMid(arr);
                    break;
            }
        }
        int[] result = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            result[i] = al.get(i);
        }
        if (result[0] == 0) result[0] = -1;
        return result;
    }

    private static void push(int num, int[] arr) {
        arr[++counter] = num;
    }

    private static int pop(int[] arr) {
        //  System.out.println(counter);
        if (counter == -1) return counter;
        return arr[counter--];
    }

    private static int midElement(int[] arr) {
        if (counter == -1) return counter;

        int mid = (counter + 2) / 2;
        if (counter % 2 == 0) {
            mid--;
        }
        // System.out.println(counter +" "+mid);
        // for(int val:arr) System.out.print(val+" ");
        // System.out.println(arr[mid]);
        return arr[mid];
    }

    private static void deleteMid(int[] arr) {
        if (counter == -1) return;
        int mid = (counter + 2) / 2;
        if (counter % 2 == 0) {
            mid--;
        }
        int prev = mid;
        int next = mid + 1;

        for (int i = prev; i < arr.length - 1; i++) {
            arr[i] = arr[next++];
        }
        counter--;
    }
}
