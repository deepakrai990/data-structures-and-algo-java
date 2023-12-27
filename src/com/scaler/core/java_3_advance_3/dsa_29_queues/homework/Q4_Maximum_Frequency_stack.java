package com.scaler.core.java_3_advance_3.dsa_29_queues.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * @author Deepak Kumar Rai
 * @created 02/04/23 6:32 pm
 * @project scaler_course_code
 */
public class Q4_Maximum_Frequency_stack {
    private HashMap<Integer, Integer> freqMap;
    private HashMap<Integer, ArrayDeque<Integer>> stackFreqMap;
    int maxFreq = Integer.MIN_VALUE;

    public Q4_Maximum_Frequency_stack() {
        freqMap = new HashMap<>();
        stackFreqMap = new HashMap<>();
    }

    private int[] solve(int[][] A) {
        int rowLen = A.length;
        int[] out = new int[rowLen];
        for (int r = 0; r < rowLen; r++) {
            if (A[r][0] == 1) {
                out[r] = push(A[r][1]);
            } else {
                out[r] = pop();
            }
        }
        return out;
    }

    private int push(int x) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int freq = freqMap.getOrDefault(x, 0) + 1;
        maxFreq = Math.max(maxFreq, freq);
        freqMap.put(x, freq);
        if (stackFreqMap.containsKey(freq)) {
            stack = stackFreqMap.get(freq);
        }
        stack.push(x);
        stackFreqMap.put(freq, stack);
        return -1;
    }

    private int pop() {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack = stackFreqMap.get(maxFreq);
        int out = stack.pop();
        freqMap.put(out, freqMap.getOrDefault(out, 0) - 1);
        if (stack.isEmpty()) {
            maxFreq--;
        }
        return out;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 5},
                {1, 7},
                {1, 5},
                {1, 7},
                {1, 4},
                {1, 5},
                {2, 0},
                {2, 0},
                {2, 0},
                {2, 0}
        };
        Q4_Maximum_Frequency_stack solution = new Q4_Maximum_Frequency_stack();
        int[] results = solution.solve(A);
        PrintUtils.print(results);
    }
}
