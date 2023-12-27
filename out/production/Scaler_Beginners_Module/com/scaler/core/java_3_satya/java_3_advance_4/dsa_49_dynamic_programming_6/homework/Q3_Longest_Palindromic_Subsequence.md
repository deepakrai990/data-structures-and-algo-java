### Q3. Longest Palindromic Subsequence
#### Problem Description
```text
Given a string A. Find the longest palindromic subsequence (A subsequence which 
does not need to be contiguous and is a palindrome).

You need to return the length of longest palindromic subsequence.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= length of(A) &lt;= 10<sup>3</sup></p>
</div>

```text
1 <= length of(A) <= 10^3
```
#### Input Format
```text
First and only integer is a string A.
```
#### Output Format
```text
Return an integer denoting the length of longest palindromic subsequence.
```
#### Example Input
```text
Input 1:
 A = "bebeeed"

Input 2:
 A = "aedsead"
```
#### Example Output
```text
Output 1:
 4

Output 2:
 5
```
#### Example Explanation
```text
Explanation 1:
    The longest palindromic subsequence is "eeee", which has a length of 4.

Explanation 2:
    The longest palindromic subsequence is "aedea", which has a length of 5.
```
### Hints
* Hint 1
```text
Naive solution is to generate all the possible subsequences and check the longest 
palindromic subsequence.

But this will take exponential time.

Can you optimize it using Dynamic Programming?
```
* Solution Approach
```text
First, Create a recurrence relation then we will think of optimizing that.
Let’s say for sequence A[0..n-1] , L(0,n-1) denotes the length of longest palindromic 
subsequence.
It will be calculated by:
-> If last and first character of the sequence are same, then L(0,n-1) = L(1,n-1) + 2
->Else, L(0,n-1) = max(L(0,n-2),L(1,n-1))

Since we can observe overlapping Subproblems, we will optimize it using a 
dynamic programming solution.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A) {
        return lps(A);
    }
    static int lps(String seq) {
        int n = seq.length();
        int i, j, cl;
        int L[][] = new int[n][n];
        for (i = 0; i < n; i++)
            L[i][i] = 1;
        for (cl = 2; cl <= n; cl++) {
            for (i = 0; i < n - cl + 1; i++) {
                j = i + cl - 1;
                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (seq.charAt(i) == seq.charAt(j))
                    L[i][j] = L[i + 1][j - 1] + 2;
                else
                    L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
            }
        }
        return L[0][n - 1];
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : string
    //return an integer
    solve: function (s) {
        const dp = Array(s.length).fill(0).map(() => Array(s.length).fill(0));

        // every sequence with one element is a palindrome of length 1
        for (let i = 0; i < s.length; i++) {
            dp[i][i] = 1;
        }

        for (let startIndex = s.length - 1; startIndex >= 0; startIndex--) {
            for (let endIndex = startIndex + 1; endIndex < s.length; endIndex++) {
                // case 1: elements at the beginning and the end are the same
                if (s[startIndex] === s[endIndex]) {
                    dp[startIndex][endIndex] = dp[startIndex + 1][endIndex - 1] + 2;
                } else {
                    // case 2: skip one element either from the beginning or the end
                    dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]);
                }
            }
        }
        return dp[0][s.length - 1];
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(string A) {
    int n = A.size();
    int i, j, cl;
    int L[n][n]; // Create a table to store results of subproblems 

    // Strings of length 1 are palindrome of lentgh 1 
    for (i = 0; i < n; i++)
        L[i][i] = 1;

    // Build the table. Note that the lower diagonal values of table are useless and not filled in the process.
    for (cl = 2; cl <= n; cl++) {
        for (i = 0; i < n - cl + 1; i++) {
            j = i + cl - 1;
            if (A[i] == A[j] && cl == 2)
                L[i][j] = 2;
            else if (A[i] == A[j])
                L[i][j] = L[i + 1][j - 1] + 2;
            else
                L[i][j] = max(L[i][j - 1], L[i + 1][j]);
        }
    }
    return L[0][n - 1];
}
```

