### Q2. Longest Common Subsequence
#### Problem Description
```text
Given two strings A and B. Find the longest common subsequence ( A sequence which 
does not need to be contiguous), which is common in both the strings.

You need to return the length of such longest common subsequence.
```
#### Problem Constraints
```text
1 <= Length of A, B <= 1005
```
#### Input Format
```text
First argument is a string A.
Second argument is a string B.
```
#### Output Format
```text
Return an integer denoting the length of the longest common subsequence.
```
#### Example Input
```text
Input 1:
 A = "abbcdgf"
 B = "bbadcgf"

Input 2:
 A = "aaaaaa"
 B = "ababab"
```
#### Example Output
```text
Output 1:
 5

Output 2:
 3
```
#### Example Explanation
```text
Explanation 1:
    The longest common subsequence is "bbcgf", which has a length of 5.

Explanation 2:
    The longest common subsequence is "aaa", which has a length of 3.
```
### Hints
* Hint 1
```text
If for some (i, j) A[i] = B[j], then we can break our problem:

Longest common subsequence of(A[1..i-1], B[1….j-1]) + 1(for A[i] == B[j]) + Longest common subsequence of(A[i+1….n], B[j+1….m]).

To find the longest common subsequence of given strings, Do this for all i, j.

Try to reduce the time complexity of this solution ?
```
* Solution Approach
```text
Suppose LCS[i][j] represents the longest common subsequence of A[1..i] and B[1..j]

A[1..i] represents first i characters of string A
A[1..j] represents first j characters of string B

For every i, j we have two conditions A[i] == B[j] or not. Divide the problem based on 
this condition.

Recursion relation to divide the problem into smaller sub problems can be written as:-

LCS(i, j) = maximum (LCS(i-1, j-1] + 1,       //if(A[i] = B[j])
                     LCS(A[i-1], B[j],
                     LCS(A[i], B[j-1] )

LCS[ len(A) ][ len(B) ] will be our answer.

Think about the time complexity of this solution.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A, String B) {
        int m = A.length(), n = B.length();
        int[][] L = new int[m + 1][n + 1];
        int i, j;
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                //Base condition
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (A.charAt(i - 1) == B.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : string
    //param B : string
    //return an integer
    solve: function (text1, text2) {
        if (text1 == "" || text2 == "")
            return 0;
        // The first row and the first col is an empty string (base case).
        // dp[row][col] represents the length of the longest possible subsequence
        // using substrings text1.substring(0,row) and text2.substring(0,col).
        let dp = new Array(text2.length + 1).fill(0).map(() => new Array(text1.length + 1));
        for (let row = 0; row < dp.length; row++) {
            for (let col = 0; col < dp[0].length; col++) {
                if (row == 0 || col == 0) {
                    dp[row][col] = 0; // can't have a common subsequence with ""
                } else if (text1[col - 1] === text2[row - 1]) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
                }
            }
        }
        return dp[text2.length][text1.length];
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(string A, string B) {
    int m = A.size(), n = B.size();
    int L[m + 1][n + 1];
    int i, j;
    for (i = 0; i <= m; i++) {
        for (j = 0; j <= n; j++) {
            //Base condition
            if (i == 0 || j == 0)
                L[i][j] = 0;
            else if (A[i - 1] == B[j - 1])
                L[i][j] = L[i - 1][j - 1] + 1;
            else
                L[i][j] = max(L[i - 1][j], L[i][j - 1]);
        }
    }
    return L[m][n];
}
```

