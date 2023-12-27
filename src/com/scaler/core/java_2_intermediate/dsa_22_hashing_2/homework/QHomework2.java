package com.scaler.core.java_2_intermediate.dsa_22_hashing_2.homework;

import com.scaler.core.utils.PrintUtils;

import java.util.HashMap;

/**
 * @created 20/02/23 8:52 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class QHomework2 {
    private static int solve(int[] A, int B) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;

        for(int i = 0; i < A.length; i++){
            if(map.containsKey(A[i] - B)){
                res += map.get(A[i] - B);
            }
            if(map.containsKey(A[i] + B)){
                res+= map.get(A[i] + B);
            }
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 2};
        int B = 1;
        int result = solve(A, B);
        PrintUtils.printInt(result);
    }
}
