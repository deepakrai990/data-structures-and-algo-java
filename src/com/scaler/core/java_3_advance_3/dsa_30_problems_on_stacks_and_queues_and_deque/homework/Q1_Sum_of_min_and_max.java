package com.scaler.core.java_3_advance_3.dsa_30_problems_on_stacks_and_queues_and_deque.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @created 02/04/23 6:28 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_Sum_of_min_and_max {
    private static int solve(int[] A, int B) {
        int n = A.length;
        int mod = 1000000007;
        long sum = 0;
        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> maxQ = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!minQ.isEmpty() && minQ.peekFirst() < i - B + 1) {
                minQ.pollFirst();
            }
            while (!maxQ.isEmpty() && maxQ.peekFirst() < i - B + 1) {
                maxQ.pollFirst();
            }
            while (!minQ.isEmpty() && A[minQ.peekLast()] > A[i]) {
                minQ.pollLast();
            }
            while (!maxQ.isEmpty() && A[maxQ.peekLast()] < A[i]) {
                maxQ.pollLast();
            }
            minQ.add(i);
            maxQ.add(i);
            if (i >= B - 1) {
                sum += A[minQ.peekFirst()] + A[maxQ.peekFirst()];
                sum %= mod;
            }
        }
        return (int) (sum + mod) % mod;
    }

    private static int solve_1(int[] A, int B) {
        Deque<Integer> maxQ = new LinkedList<>();//will be in decreasing order
        Deque<Integer> minQ = new LinkedList<>();//will be in increasing order
        int n = A.length;
        long min = 0L;
        long max = 0L;
        int mod = 1000000007;

        //implementing 1st window
        for (int i = 0; i < B; i++) {
            while (!maxQ.isEmpty() && maxQ.getLast() < A[i])
                maxQ.removeLast();
            maxQ.addLast(A[i]);

            while (!minQ.isEmpty() && minQ.getLast() > A[i])
                minQ.removeLast();
            minQ.addLast(A[i]);
        }

        //calculate contribution of first window
        min = (min + minQ.getFirst()) % mod;
        max = (max + maxQ.getFirst()) % mod;

        int i = B;
        while (i < n) {
            int outgoing = A[i - B];
            int incoming = A[i];
            //removing the outgoing element from minQ if exists
            if (minQ.getFirst() == outgoing)
                minQ.removeFirst();
            //removing the outgoing element from maxQ if exists
            if (maxQ.getFirst() == outgoing)
                maxQ.removeFirst();

            //inserting incoming element in maxQ
            while (!maxQ.isEmpty() && maxQ.getLast() < incoming)
                maxQ.removeLast();
            maxQ.addLast(incoming);
            //inserting incoming element in minQ
            while (!minQ.isEmpty() && minQ.getLast() > incoming)
                minQ.removeLast();
            minQ.addLast(incoming);

            min = (min + minQ.getFirst()) % mod;
            max = (max + maxQ.getFirst()) % mod;
            i++;
        }

        return (int) (min % mod + max % mod + mod) % mod;
    }

    public static void main(String[] args) {
        int[] A = {2, 5, -1, 7, -3, -1, -2};
        int B = 4;
        int result = solve(A, B);
        PrintUtils.print(result);

        PrintUtils.printNewLine();

        result = solve_1(A, B);
        PrintUtils.print(result);
    }
}
