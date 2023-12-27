package com.scaler.core.java_1_beginner.intro_08_one_1DArrays;

import java.util.Scanner;

/**
 * @created 06/08/22 10:32 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // problem 1. take runs for 5 matches and print its avg
        // int[] runs;
        // runs = new int[5];

        // // take input and set it in array
        // for(int i = 0; i < 5; i++) {
        // 	runs[i] = scn.nextInt();
        // }

        // // print array
        // for(int i = 0; i < 5; i++) {
        // 	System.out.println("Runs in " + i +"th match is : " + runs[i]);
        // }

        // // task -> find average of runs
        // // average = (sum of entries) / (no. of entries)

        // // find sum of array
        // int sum = 0;
        // for(int i = 0; i < 5; i++) {
        // 	sum += runs[i];
        // }

        // // i 	sum[before]	runs[i] 	sum[after] sum = sum + runs[i]
        // // 0		0			40		0 + 40 = 40
        // // 1		40			66		40 + 66 = 106
        // // 2		106			100		106 + 100 = 206
        // // 3		206			99		206 + 99 = 305
        // // 4		305			0		305 + 0 = 305
        // // 5 -> loop will break

        // // sum after loop = 305

        // double avg = sum / 5.0;
        // // double avg = sum / 5;
        // System.out.println("Average is : " + avg);


        // user want to give size of array
        // int n = scn.nextInt();
        // int[] runs = new int[n];

        // for(int i = 0; i < n; i++) {
        // 	runs[i] = scn.nextInt();
        // }

        // for(int i = 0; i < n; i++) {
        // 	System.out.println("Runs in " + i +"th match is : " + runs[i]);
        // }

        // problem : take n from user and take runs for n different matches
        // find min and max from it.
        // int n = scn.nextInt();
        // int[] runs = new int[n];

        // for(int i = 0; i < n; i++) {
        // 	runs[i] = scn.nextInt();
        // }

        // // runs -> ffind min and max from it
        // int max = runs[0];
        // int min = runs[0];
        // for(int i = 1; i < n; i++) {
        // 	if(max < runs[i]) {
        // 		max = runs[i];
        // 	}

        // 	if(min > runs[i]) {
        // 		min = runs[i];
        // 	}
        // }
        // System.out.println("Max is : " + max);
        // System.out.println("Min is : " + min);

        // problem : give array in function and ask them to return
        // min and max from it.
        // initialize the array
        int[] arr = {10, 4, 6, 17, 9, 20, 8};

        int[] arr2 = minAndmax(arr);
        // // res[0] -> min
        // // res[1] -> max

        System.out.println("Min is : " + arr2[0]);
        System.out.println("Max is : " + arr2[1]);

        // for(int i = 0; i < res.length; i++) {
        // 	System.out.print(res[i] + " ");
        // }
        doubt();

    }

    public static void doubt() {
        // int sum = 98;
        // double avg = sum / 10.0;
        // double avg = (double)sum / 10;
        // double avg = sum / (double)10;
        // System.out.println(avg);

        int[] arr = {1, 2, 3, 4, 5};
        System.out.print("[");
        for(int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");

    }

    // return type -> array -> int[]
    // input parameter -> arr -> int[] arr
    public static int[] minAndmax(int[] arr) {
        if(arr.length == 0) {
            int[] res = {-1, -1};
            return res;
        }
        // write our code
        // return 0 index value as min and 1 as max
        int[] res = new int[2];
        int min = arr[0];
        int max = arr[0];

        // to find length of array/ size of array -> arr.length
        for(int i = 0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }

            if(min > arr[i]) {
                min = arr[i];
            }
        }

        System.out.println(res[0] + " " + res[1]);

        res[0] = min;
        res[1] = max;

        return res;
    }
}
