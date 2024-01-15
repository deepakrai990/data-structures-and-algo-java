package com.scaler.core.java_2_intermediate.dsa_13_bit_manipulations_1;

/**
 * @author Deepak Kumar Rai
 * @created 05/01/24
 * @project scaler_course_code
 */
public class Q6_Bitwise_Properties {
    public static void main(String[] args) {
        int A = 0b11001100;
        System.out.println("A: " + A);
        // Identity Properties
        System.out.println("---------------Identity Properties---------------");
        int resultIdentityAND = A & 0;
        System.out.println(A + " & " + 0 + " : " + resultIdentityAND);
        int resultIdentityOR = A | 0;
        System.out.println(A + " | " + 0 + " : " + resultIdentityOR);
        int resultIdentityXOR = A ^ 0;
        System.out.println(A + " ^ " + 0 + " : " + resultIdentityXOR);

        // Zero Properties
        System.out.println("---------------Zero Properties---------------");
        int resultZeroAND = A & 1;
        System.out.println(A + " & " + 1 + " : " + resultZeroAND);
        int resultZeroOR = A | 1;
        System.out.println(A + " | " + 1 + " : " + resultZeroOR);
        int resultZeroXOR = A ^ A;
        System.out.println(A + " ^ " + A + " : " + resultZeroXOR);

        // Complement Properties
        System.out.println("---------------Complement Properties---------------");
        int resultComplementAND = A & ~A;
        System.out.println(A + " & ~" + A + " : " + resultComplementAND);
        int resultComplementOR = A | ~A;
        System.out.println(A + " | ~" + A + " : " + resultComplementOR);
        int resultComplementXOR = A ^ ~A;
        System.out.println(A + " ^ ~" + A + " : " + resultComplementXOR);

        // Shift Properties
        System.out.println("---------------Shift Properties---------------");
        int resultLeftShift = A << 1;
        System.out.println(A + " << " + 1 + " : " + resultLeftShift);
        int resultRightShift = A >> 1;
        System.out.println(A + " >> " + 1 + " : " + resultRightShift);
        int resultUnsignedRightShift = A >>> 1;
        System.out.println(A + " >>> " + 1 + " : " + resultUnsignedRightShift);

        // Commutative Property
        System.out.println("---------------Commutative Property---------------");
        int a = 0b11001100;
        int b = 0b00110011;
        System.out.println("a : " + a + ", b : " + b);
        // Commutative property for AND
        int resultAND1 = a & b;
        int resultAND2 = b & a;

        // Commutative property for OR
        int resultOR1 = a | b;
        int resultOR2 = b | a;

        // Commutative property for XOR
        int resultXOR1 = a ^ b;
        int resultXOR2 = b ^ a;

        // Print the results
        System.out.println("AND: Result1 = " + Integer.toBinaryString(resultAND1) +
                "(" +resultAND1+ ")" +
                ", Result2 = " + Integer.toBinaryString(resultAND2) + "(" +resultAND2+ ")");

        System.out.println("OR:  Result1 = " + Integer.toBinaryString(resultOR1) +
                "(" +resultOR1+ ")" +
                ", Result2 = " + Integer.toBinaryString(resultOR2) + "(" +resultOR2+ ")");

        System.out.println("XOR: Result1 = " + Integer.toBinaryString(resultXOR1) +
                "(" +resultXOR1+ ")" +
                ", Result2 = " + Integer.toBinaryString(resultXOR2) + "(" +resultXOR2+ ")");

        // Associative Property
        System.out.println("---------------Associative Property---------------");
        a = 0b11001100;
        b = 0b00110011;
        int c = 0b11110000;
        System.out.println("a : " + a + ", b : " + b + ", c: " + c);
        // Associative property for AND
        int resultAND1A = (a & b) & c;
        int resultAND2A = a & (b & c);

        // Associative property for OR
        int resultOR1A = (a | b) | c;
        int resultOR2A = a | (b | c);

        // Associative property for XOR
        int resultXOR1A = (a ^ b) ^ c;
        int resultXOR2A = a ^ (b ^ c);

        // Print the results
        System.out.println("AND: Result1 = " + Integer.toBinaryString(resultAND1A) +
                "(" +resultAND1A+ ")" +
                ", Result2 = " + Integer.toBinaryString(resultAND2A) + "(" +resultAND2A+ ")");

        System.out.println("OR:  Result1 = " + Integer.toBinaryString(resultOR1A) +
                "(" +resultOR1A+ ")" +
                ", Result2 = " + Integer.toBinaryString(resultOR2A) + "(" +resultOR2A+ ")");

        System.out.println("XOR: Result1 = " + Integer.toBinaryString(resultXOR1A) +
                "(" +resultXOR1A+ ")" +
                ", Result2 = " + Integer.toBinaryString(resultXOR2A) + "(" +resultXOR2A+ ")");

    }
}
