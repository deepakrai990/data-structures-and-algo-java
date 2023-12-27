package com.scaler.core.java_3_advance_1.dsa_04_bit_manipulations_1.assignment;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 02/04/23 7:58 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Add_Binary_Strings {
    private static String addBinary(String A, String B) {
        StringBuilder res = new StringBuilder();

        int i = A.length() - 1;
        int j = B.length() - 1;
        int sum = 0;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            sum = carry;                                //initialize with carry to add carry in next iteration
            if (i >= 0) {
                sum = sum + A.charAt(i) - '0';          //add i'th place's digit to sum until length is over
            }
            if (j >= 0) {
                sum = sum + B.charAt(j) - '0';          //add j'th place's sum until its length =0
            }
            res.append(sum % 2);                        // append sum%2 E.g. 1%2=1 || 0%2==0 || *imp* 2%2=0
            carry = sum / 2;                              // and carry if sum = 1+1 =2 i.e carry = 2/2=1
            i--;
            j--;
        }
        if (carry != 0) {                                   //after last digit if carry is there then append it.
            res.append(1);
        }
        StringBuilder res2 = new StringBuilder();
        for (int k = res.length() - 1; k >= 0; k--) {             //reverse because we appended in reverse order;
            res2.append(res.charAt(k));
        }
        return res2.toString();
    }

    public static void main(String[] args) {
        String A = "100";
        String B = "11";
        String result = addBinary(A, B);
        PrintUtils.print(result);
    }
}
