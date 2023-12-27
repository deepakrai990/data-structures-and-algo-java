package com.scaler.core.java_3_advance_3.dsa_29_queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Deepak Kumar Rai
 * @created 31/10/23
 * @project scaler_course_code
 */
public class Q4_Generate_K_th_palindrome_number {
    /**
     * Generate Kth palindrome number using digits 1 & 2.
     * **/
    private static String generateKthPalindromeNumber1(int K) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        for (int i = 1; i < K; i++) {
            String element = queue.poll();
            assert element != null;
            int N = element.length();
            String startToMid = element.substring(0, N / 2);
            if ((N & 1) == 0) {
                String midToEnd = element.substring(N / 2);
                queue.add(startToMid + "1" + midToEnd);
                queue.add(startToMid + "2" + midToEnd);
            } else if (!startToMid.equalsIgnoreCase("")) {
                char mid = element.charAt(N / 2);
                String afterMidToEnd = element.substring(N / 2 + 1);
                queue.add(startToMid + mid + mid + afterMidToEnd);
            } else {
                queue.add(element + element);
            }
        }
        return queue.peek();
    }
    public static void main(String[] args) {
        int k = 7;
        String result = generateKthPalindromeNumber1(k);
        System.out.println(result);
    }
}
