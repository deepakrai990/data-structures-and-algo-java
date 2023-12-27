package com.scaler.core.java_3_advance_by_yogesh.java_3_advance_3.dsa_32_deque.assignment;

import com.scaler.core.utils.PrintUtils;

import java.util.*;

/**
 * @created 11/03/23 9:39 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q1_First_Non_Repeating_Character {
    private static String solve(String A) {
        int N = A.length();
        HashMap<Character, Integer> mp = new HashMap<>();
        Queue<Character> queue = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder("");
        ans.append(String.valueOf(A.charAt(0)));
        queue.add(A.charAt(0));
        mp.put(A.charAt(0), 1);
        for (int i = 1; i < N; i++) {
            char c = A.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
            if (mp.get(c) > 1) {
                while (queue.size() > 0 && mp.get(queue.peek()) > 1) {
                    queue.poll();
                }
                if (queue.size() == 0) {
                    ans.append("#");
                } else {
                    ans.append(queue.peek());
                }
            } else {
                queue.add(c);
                ans.append(queue.peek());
            }
        }
        return ans.toString();
    }

    private static String solve_1(String A) {
        Deque<Character> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            if (dq.isEmpty())
                dq.add(A.charAt(i));
            else if (A.charAt(i) == dq.peekFirst())
                dq.pollFirst();
            else if (A.charAt(i) == dq.peekLast())
                dq.pollLast();
            else dq.add(A.charAt(i));

            while (map.containsKey(dq.peekFirst()) && map.get(dq.peekFirst()) > 1) dq.pollFirst();


            if (dq.isEmpty())
                sb.append("#");
            else sb.append(dq.peekFirst());

            map.put(A.charAt(i), map.getOrDefault(A.charAt(i), 0) + 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String A = "abadbc";
        String result = solve(A);
        PrintUtils.print(result);

        PrintUtils.printNewLine();

        result = solve_1(A);
        PrintUtils.print(result);
    }
}
