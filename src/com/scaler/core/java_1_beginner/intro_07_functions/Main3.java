package com.scaler.core.java_1_beginner.intro_07_functions;

import java.util.*;

/**
 * @created 04/08/22 3:12 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Main3 {
    public static void main(String[] args) {
        int n = 16777214;
        ArrayList<Integer> array = primesum(n);
        System.out.println(Arrays.toString(array.toArray()));
    }
    public static ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 2; i < A; i++) {
            if (isPrime(i) && isPrime(A - i)) {
                arr.add(i);
                arr.add(A - i);
                return arr;
            }
        }
        return arr;
    }
    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    static boolean isPrime1(int n, int i) {
        if (n <= 2)
            return (n == 2) ? true : false;
        if (n % i == 0)
            return false;
        if (i * i > n)
            return true;
        return isPrime1(n, i + 1);
    }

    public static boolean isPrime1(int n) {
        if(n == 1 || n == 0) {
            return false;
        }
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
