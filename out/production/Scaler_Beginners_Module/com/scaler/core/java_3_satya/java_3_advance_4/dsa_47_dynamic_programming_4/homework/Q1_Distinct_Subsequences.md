### Q1. Distinct Subsequences
#### Problem Description
```text
Given two sequences A and B, count number of unique ways in sequence A, to form a 
subsequence that is identical to the sequence B.

Subsequence : A subsequence of a string is a new string which is formed from the 
original string by deleting some (can be none) of the characters without disturbing 
the relative positions of the remaining characters. (ie, "ACE" is a subsequence 
of "ABCDE" while "AEC" is not).
```
#### Problem Constraints
```text
1 <= length(A), length(B) <= 700
```
#### Input Format
```text
The first argument of input contains a string A.
The second argument of input contains a string B.
```
#### Output Format
```text
Return an integer representing the answer as described in the problem statement.
```
#### Example Input
```text
Input 1:
 A = "abc"
 B = "abc"

Input 2:
 A = "rabbbit" 
 B = "rabbit" 
```
#### Example Output
```text
Output 1:
 1

Output 2:
 3
```
#### Example Explanation
```text
Explanation 1:
    Both the strings are equal.

Explanation 2:
    These are the possible removals of characters:
        => A = "ra_bbit" 
        => A = "rab_bit" 
        => A = "rabb_it"
        
    Note: "_" marks the removed character.
```
### Hints
* Hint 1
```text
Can you solve the problem for some prefix of first string and some prefix of second 
string and use it to compute the final answer?

Try to think of DP on prefixes of both strings.
```
* Solution Approach
```text
As a typical way to implement a dynamic programming algorithm, we construct a 
matrix dp, where each cell dp[i][j] represents the number of solutions of aligning 
substring B[0..i] with A[0..j];

Rule 1). dp[0][j] = 1, since aligning B = “” with any substring of A would have 
         only ONE solution which is to delete all characters in A.

Rule 2). when i > 0, dp[i][j] can be derived by two cases:

case 1). if B[i] != A[j], then the solution would be to ignore the character A[j] 
         and align substring B[0..i] with A[0..(j-1)]. Bherefore, dp[i][j] = dp[i][j-1].

case 2). if B[i] == A[j], then first we could adopt the solution in case 1), but also 
         we could match the characters B[i] and A[j] and align the rest of 
         them (i.e. B[0..(i-1)] and A[0..(j-1)]. As a 
         result, dp[i][j] = dp[i][j-1] + d[i-1][j-1]

e.g. B = B, A = ABC

dp[1][2]=1: Align B’=B and A’=AB, only one solution, which is to remove character A in A’.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    private String S;
    private String T;
    int[][] dp;
    int n;
    int nT;

    public int numDistinct(String S, String T) {
        if (T.length() > S.length())
            return 0;
        n = S.length();
        nT = T.length();
        this.S = S;
        this.T = T;
        dp = new int[n][nT];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return rec(0, 0);
    }

    public int rec(int sIndex, int tIndex) {
        if (tIndex == nT)
            return 1;
        if (sIndex >= n)
            return 0;
        if (dp[sIndex][tIndex] != -1)
            return dp[sIndex][tIndex];
        int res = 0;
        if (S.charAt(sIndex) == T.charAt(tIndex))
            res = rec(sIndex + 1, tIndex + 1);
        res += rec(sIndex + 1, tIndex);
        return dp[sIndex][tIndex] = res;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : string
    //param B : string
    //return an integer
    numDistinct: function (s, t) {
        if (!s && !t) return 1;

        let dp = new Array(t.length + 1)
            .fill(null)
            .map(_ => new Array(s.length + 1).fill(0));

        dp[0] = new Array(s.length + 1).fill(1);

        for (let i = 1; i <= t.length; i++) {
            for (let j = 1; j <= s.length; j++) {
                dp[i][j] += dp[i][j - 1];
                if (t[i - 1] === s[j - 1]) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[t.length][s.length];
    }
};
```
* * Solution in C++
```cpp
/**
 * Solution (DP):
 * We keep a m*n matrix and scanning through string A, while
 * m = B.length() + 1 and n = A.length() + 1
 * and each cell in matrix Path[i][j] means the number of distinct subsequences of 
 * B.substr(1...i) in A(1...j)
 * 
 * Path[i][j] = Path[i][j-1]            (discard A[j])
 *              +     Path[i-1][j-1]    (A[j] == B[i] and we are going to use A[j])
 *                 or 0                 (A[j] != B[i] so we could not use A[j])
 * while Path[0][j] = 1 and Path[i][0] = 0.
 */

int Solution::numDistinct(string A, string B) {
    int m = B.length();
    int n = A.length();
    if (m > n) return 0; // impossible for subsequence
    vector < vector < int >> path(m + 1, vector < int > (n + 1, 0));
    for (int k = 0; k <= n; k++) 
        path[0][k] = 1; // initialization
    for (int j = 1; j <= n; j++) {
        for (int i = 1; i <= m; i++) {
            path[i][j] = path[i][j - 1] + (B[i - 1] == A[j - 1] ? path[i - 1][j - 1] : 0);
        }
    }
    return path[m][n];
}
```

