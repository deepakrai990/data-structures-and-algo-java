### Q1. 0-1 Knapsack II
#### Problem Description
```text
Given two integer arrays A and B of size N each which represent values and weights 
associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is 
smaller than or equal to C.

NOTE: You cannot break an item, either pick the complete item, or don’t pick 
it (0-1 property).
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 500</p>
    <p>1 &lt;= C, B[i] &lt;= 10<sup>6</sup></p>
    <p>1 &lt;= A[i] &lt;= 50</p>
</div>

```text
1 <= N <= 500

1 <= C, B[i] <= 10^6

1 <= A[i] <= 50
```
#### Input Format
```text
First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.
```
#### Output Format
```text
Return a single integer denoting the maximum value subset of A such that sum of the 
weights of this subset is smaller than or equal to C.
```
#### Example Input
```text
Input 1:
 A = [6, 10, 12]
 B = [10, 20, 30]
 C = 50

Input 2:
 A = [1, 3, 2, 4]
 B = [12, 13, 15, 19]
 C = 10
```
#### Example Output
```text
Output 1:
 22

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    Taking items with weight 20 and 30 will give us the maximum value i.e 10 + 12 = 22

Explanation 2:
    Knapsack capacity is 10 but each item has weight greater than 10 so no items can be 
    considered in the knapsack therefore answer is 0.
```
### Hints
* Hint 1
```text
We can’t create a 2-D dynamic programming of N x C, since the constaints are high.

Think in terms of value and use the fact that the max total value will be 50 * N.
```
* Solution Approach
```text
Since the value of items will be less than equal to 50. So the max value can be 50 * N.

Create a dp array of size 50 * N where dp[val] will tell that minimum weight require 
to have value exactly equal to val.

This can be easily calculated by running two loops:

    for i -> 0 to N-1:
        for val -> mxval to A[i]
            dp[val] = min(dp[val],B[i] + dp[val-A[i]])

Now, check for the maximum value for which dp[val] is less than equal to the 
capacity of knapsack.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int[] B, int C) {
        int n = A.length;
        int mxval = 50 * n;
        int[] dp = new int[mxval + 1];
        for (int i = 0; i < mxval + 1; i++) {
            dp[i] = 1000000000;
        }
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int val = mxval; val >= A[i]; val--) {
                dp[val] = Math.min(dp[val], B[i] + dp[val - A[i]]);
            }
        }
        int ans = 0;
        for (int val = mxval; val >= 0; val--) {
            if (dp[val] <= C) {
                ans = val;
                break;
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //param B : array of integers
    //param C : integer
    //return an integer
    solve: function (A, B, C) {
        let n = A.length;
        let mxval = 50 * n;
        let dp = new Array(mxval + 1);
        for (let i = 0; i < mxval + 1; i++) {
            dp[i] = 1e9;
        }
        dp[0] = 0;
        for (let i = 0; i < n; i++) {
            for (let val = mxval; val >= A[i]; val--) {
                dp[val] = Math.min(dp[val], B[i] + dp[val - A[i]]);
            }
        }
        let ans = 0;
        for (let val = mxval; val >= 0; val--) {
            if (dp[val] <= C) {
                ans = val;
                break;
            }
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A, vector < int > & B, int C) {
    int n = A.size();
    int mxval = 50 * n;
    int dp[mxval + 1];
    for (int i = 0; i < mxval + 1; i++) {
        dp[i] = 1e9;
    }
    dp[0] = 0;
    for (int i = 0; i < n; i++) {
        for (int val = mxval; val >= A[i]; val--) {
            dp[val] = min(dp[val], B[i] + dp[val - A[i]]);
        }
    }
    int ans = 0;
    for (int val = mxval; val >= 0; val--) {
        if (dp[val] <= C) {
            ans = val;
            break;
        }
    }
    return ans;
}
```

