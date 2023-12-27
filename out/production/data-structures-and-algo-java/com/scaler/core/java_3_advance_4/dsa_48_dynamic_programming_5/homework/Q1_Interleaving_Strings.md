### Q1. Interleaving Strings
#### Problem Description
```text
Given A, B, C find whether C is formed by the interleaving of A and B.
```
#### Problem Constraints
```text
1 <= length(A), length(B) <= 100

1 <= length(C) <= 200
```
#### Input Format
```text
The first argument of input contains a string, A.
The second argument of input contains a string, B.
The third argument of input contains a string, C.
```
#### Output Format
```text
Return 1 if string C is formed by interleaving of A and B else 0.
```
#### Example Input
```text
Input 1:
 A = "aabcc"
 B = "dbbca"
 C = "aadbbcbcac"

Input 2:
 A = "aabcc"
 B = "dbbca"
 C = "aadbbbaccc"
```
#### Example Output
```text
Output 1:
 1

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)

Explanation 2:
    It is not possible to get C by interleaving A and B.
```
### Hints
* Hint 1
```text
Let M,N be the length of A and B respectively.

You need to check if using portion upto M and portion upto N if C can be formed or not.

So basically last character of C should be something from Mth position of A or Nth position 
of B. How can you recursively simulate this?
```
* Solution Approach
```text
Lets again look at the bruteforce solution for this question.
Given the string A, B, C, the first character of C has to match with either the first 
character of A or B. If it matches with first character of A, we try to see if 
solution is possible with remaining part of A, all of B, and remaining part of C. Then we 
do the same thing for B.

The pseudocode might look something like this :

    bool isInterleave(int index1, int index2, int index3) {
                    // HANDLE BASE CASES HERE

        bool answer = false; 
        if (index1 < A.length() && A[index1] == C[index3]) answer |= isInterleave(index1 + 1, index2, index3 + 1);
        if (index2 < B.length() && B[index2] == C[index3]) answer |= isInterleave(index1, index2 + 1, index3 + 1);

        return answer;
    }

Again, index1, index2, and index3 can only take A.length(), B.length() and C.length() 
possibilities respectively. Can you think of a memoization solution using the observation ?

BONUS: Can you eliminate one of the state i.e. come up with something having only 
two arguments.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    int nA, nB, nC;
    private int mem[][];
    private String A, B, C;

    public int isInterleave(String A, String B, String C) {
        if (A == null || B == null || C == null)
            return 0;

        nA = A.length();
        nB = B.length();
        nC = C.length();

        if (nA + nB != nC)
            return 0;

        mem = new int[nA + 1][nB + 1];

        for (int i = 0; i <= nA; i++)
            Arrays.fill(mem[i], -1);

        this.A = A;
        this.B = B;
        this.C = C;

        return rec(0, 0);
    }

    public int rec(int nA, int nB) {
        if (nA + nB == nC)
            return 1;

        if (mem[nA][nB] != -1)
            return mem[nA][nB];

        char a = nA < this.nA ? A.charAt(nA) : '~';
        char b = nB < this.nB ? B.charAt(nB) : '~';
        char c = C.charAt(nA + nB);

        int status = 0;

        if (a == c) {
            status = rec(nA + 1, nB);
        }

        if (b == c) {
            status |= rec(nA, nB + 1);
        }
        return mem[nA][nB] = status;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : string
    //param B : string
    //param C : string
    //return an integer
    isInterleave: function (s1, s2, s3) {
        if (s1.length + s2.length !== s3.length)
            return 0;

        const memo = new Set();
        return (function interleave(i, j, k) {
            const key = i + s1.length ** 4 * j;
            if (memo.has(key))
                return false;
            if (i === s1.length && j === s2.length)
                return true;
            if (s1[i] === s3[k] && interleave(i + 1, j, k + 1))
                return true;
            if (s2[j] === s3[k] && interleave(i, j + 1, k + 1))
                return true;
            memo.add(key);
            return false;
        })(0, 0, 0) == true ? 1 : 0;
    }
};
```
* * Solution in C++
```cpp
int Solution::isInterleave(string A, string B, string C) {
    int M = A.size(), N = B.size();

    // Let us create a 2D table to store solutions of subproblems.  dp[i][j] will be true if C[0..i+j-1] is an interleaving of A[0..i-1] and B[0..j-1]. 
    bool dp[M + 1][N + 1];

    memset(dp, 0, sizeof(dp)); // Initialize all values as false. 

    // C can be an interleaving of A and B only of sum of lengths of A & B is equal to length of C. 
    if ((M + N) != C.size())
        return false;

    // Process all characters of A and B 
    for (int i = 0; i <= M; ++i) {
        for (int j = 0; j <= N; ++j) {
            // two empty strings have an empty string as interleaving 
            if (i == 0 && j == 0)
                dp[i][j] = true;

            // A is empty 
            else if (i == 0) {
                if (B[j - 1] == C[j - 1])
                    dp[i][j] = dp[i][j - 1];
            }

            // B is empty 
            else if (j == 0) {
                if (A[i - 1] == C[i - 1])
                    dp[i][j] = dp[i - 1][j];
            }

            // Current character of C matches with current character of A, but doesn't match with current character of B 
            else if (A[i - 1] == C[i + j - 1] && B[j - 1] != C[i + j - 1])
                dp[i][j] = dp[i - 1][j];

            // Current character of C matches with current character of B, but doesn't match with current character of A 
            else if (A[i - 1] != C[i + j - 1] && B[j - 1] == C[i + j - 1])
                dp[i][j] = dp[i][j - 1];

            // Current character of C matches with that of both A and B 
            else if (A[i - 1] == C[i + j - 1] && B[j - 1] == C[i + j - 1])
                dp[i][j] = (dp[i - 1][j] || dp[i][j - 1]);
        }
    }
    return dp[M][N];
}
```

