package com.scaler.core.java_1_beginner.intro_12_strings.assignment;

/**
 * @created 18/08/22 1:57 pm
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class Question3 {
    /**
     * Q3. First Occurrence
     *
     * Problem Description
     *
     * You are given a character string A, having length N and an integer ASCII code B.
     *
     * You have to tell the leftmost occurrence of the character having ASCII code equal to B, in A or report that it does not exist.
     *
     * Letter	ASCII Code	 Binary            Letter	ASCII Code	    Binary
     *    a	       097	    01100001	          A	    065	           01000001
     *    b	       098	    01100010	          B	    066	           01000010
     *    c	       099	    01100011	          C	    067	           01000011
     *    d	       100	    01100100	          D	    068	           01000100
     *    e	       101	    01100101	          E	    069	           01000101
     *    f	       102	    01100110	          F	    070	           01000110
     *    g	       103	    01100111	          G	    071	           01000111
     *    h	       104	    01101000	          H	    072	           01001000
     *    i	       105	    01101001	          I	    073	           01001001
     *    j	       106	    01101010	          J	    074	           01001010
     *    k	       107	    01101011	          K	    075	           01001011
     *    l	       108	    01101100	          L	    076	           01001100
     *    m	       109	    01101101	          M	    077	           01001101
     *    n	       110	    01101110	          N	    078	           01001110
     *    o	       111	    01101111	          O	    079	           01001111
     *    p	       112	    01110000	          P	    080	           01010000
     *    q	       113	    01110001	          Q	    081	           01010001
     *    r	       114    	01110010	          R	    082	           01010010
     *    s	       115	    01110011	          S	    083	           01010011
     *    t	       116	    01110100	          T	    084	           01010100
     *    u	       117	    01110101	          U	    085	           01010101
     *    v	       118	    01110110	          V	    086	           01010110
     *    w	       119	    01110111	          W	    087	           01010111
     *    x	       120	    01111000	          X	    088	           01011000
     *    y	       121	    01111001	          Y	    089	           01011001
     *    z	       122	    01111010	          Z	    090	           01011010
     *
     *
     *
     * Problem Constraints
     *
     * 1 <= N <= 105
     *
     * A[i] ∈ ['a'-'z']
     *
     * 97 <= B <= 122
     *
     *
     *
     * Input Format
     *
     * First argument is a character string A.
     *
     * Second argument is an integer B.
     *
     *
     *
     * Output Format
     *
     * If there exists an occurrence, return the leftmost index(0 - based), else return -1.
     *
     *
     * Example Input
     *
     * Input 1:
     *
     *  A = "aabbcc"
     *  B = 98
     *
     * Input 2:
     *
     *  A = "abc"
     *  B = 100
     *
     *
     *
     * Example Output
     *
     * Output 1:
     *
     *  2
     *
     * Output 2:
     *
     *  -1
     *
     *
     *
     * Example Explanation
     *
     * Explanation 1:
     *
     *  Character having ASCII code equal to 98 = 'b'
     *  Leftmost index of character 'b' in "aabbcc" is 2.
     *
     * Explanation 2:
     *
     *  Character having ASCII code equal to 100 = 'd'
     *  Character 'd' is not present in "abc".
     * **/
    public static void main(String[] args) {

    }

    private static int solve(final String A, final int B) {
        int leftMostIndex = -1;
        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if((int)ch == B) {
                leftMostIndex = i;
                break;
            }
        }
        return leftMostIndex;
    }
}
