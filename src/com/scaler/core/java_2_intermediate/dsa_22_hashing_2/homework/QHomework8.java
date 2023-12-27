package com.scaler.core.java_2_intermediate.dsa_22_hashing_2.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @created 20/02/23 8:53 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework8 {
    private static int solve(int[] A, int B) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : A) {
           if (set.contains(i ^ B)) {
               ans++;
            }
            set.add(i);
        }
        return ans;
    }
    private static int solve1(int[] A, int B) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        for(int x: A){
            if(mp.containsKey(x^B)){
                ++ans;
            }
            mp.put(x, 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {3, 6, 8, 10, 15, 50};
        int B = 5;
        int result = solve(A, B);
        PrintUtils.printInt(result);
        PrintUtils.printNewLine();
        result = solve1(A, B);
        PrintUtils.printInt(result);
    }
}
