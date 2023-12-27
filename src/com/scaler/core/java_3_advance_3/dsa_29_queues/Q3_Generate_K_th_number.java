package com.scaler.core.java_3_advance_3.dsa_29_queues;

import com.scaler.core.utils.PrintUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Deepak Kumar Rai
 * @created 31/10/23
 * @project scaler_course_code
 */
public class Q3_Generate_K_th_number {
    /**
     * Generate Kth number in series using digits only 1 and 2.
     * **/
    private static String generateKthNumber(int K) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        for (int i = 1; i < K; i++) {
            String element = queue.peek();
            queue.poll();
            queue.add(element + "1");
            queue.add(element + "2");
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int K = 5;
        String result = generateKthNumber(K);
        PrintUtils.print(result);
    }
}
