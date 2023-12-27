### Q1. Maximum Sum Value
#### Problem Description
```text
You are given an array A of N integers and three integers B, C, and D.

You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>-10000 &lt;= A[i], B, C, D &lt;= 10000</p>
</div>

```text
1 <= N <= 10^5

-10000 <= A[i], B, C, D <= 10000
```
#### Input Format
```text
First argument is an array A
Second argument is an integer B
Third argument is an integer C
Fourth argument is an integer D
```
#### Output Format
```text
Return an Integer S, i.e maximum value of (A[i] * B + A[j] * C + A[k] * D), 
where 1 <= i <= j <= k <= N.
```
#### Example Input
```text
Input 1:
 A = [1, 5, -3, 4, -2]
 B = 2
 C = 1
 D = -1

Input 2:
 A = [3, 2, 1]
 B = 1
 C = -10
 D = 3
```
#### Example Output
```text
Output 1:
 18

Output 2:
 -4
```
#### Example Explanation
```text
Explanation 1:
    If you choose i = 2, j = 2, and k = 3 then we will get
    A[2]*B + A[2]*C + A[3]*D = 5*2 + 5*1 + (-3)*(-1) = 10 + 5 + 3 = 18

Explanation 2:
    If you choose i = 1, j = 3, and k = 3 then we will get
    A[1]*B + A[3]*C + A[3]*D = (3*1) + (-10*1) + (3*1) = 3 - 10 + 3 = -4
```
### Hints
* Hint 1
```text
If all B, C, and D are positive then find the maximum number from the Array and 
multiplying with that number will give you answer.

But what if any one of B, C, and D is negative?

Can DP help us to solve this problem?
```
* Solution Approach
```text
Create a dynamic programming table of size n * 3. In this, dp[i][0] stores 
maximum of value B * A[p] for p between 1 and i. Similarly dp[i][1] stores the 
maximum value of B * A[p] + C * A[q] such that p <= q <= i and dp[i][2] stores 
maximum value of B * A[p] + C * A[q] + D * A[r] for p <= q <= r <= i.

To calculate the dp:

dp[i][0] = max(dp[i-1][0], B * A[i])

dp[i][1] = max(dp[i-1][1], dp[i][0] + C * A[i])

dp[i][2] = max(dp[i-1][2], dp[i][1] + D * A[i])

The answer will be stored in dp[n][2]
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int B, int C, int D) {
        int n = A.length;
        int[][] dp = new int[n + 1][3]; // dp array to store answer of previous states

        for (int i = 0; i <= n; i += 1) {
            dp[i][0] = dp[i][1] = dp[i][2] = -1000000000; // Initialize the dp array with minus infinity
        }

        for (int i = 1; i <= n; i += 1) {
            dp[i][0] = Math.max(dp[i - 1][0], A[i - 1] * B); // Maximum value of A[i]*B
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + A[i - 1] * C); // Maximum value of A[i]*B + A[j]*C
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + A[i - 1] * D); // Maximum value of A[i]*B + A[j]*C + A[k]*D
        }

        return dp[n][2]; // return the answer.
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A, B, C, D) {
        let n = A.length;
        let dp = new Array(n + 1).fill(-1e9).map(() => new Array(3).fill(-1e9));

        for (let i = 1; i <= n; i += 1) {
            dp[i][0] = Math.max(dp[i - 1][0], A[i - 1] * B);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + A[i - 1] * C);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + A[i - 1] * D);
        }
        return dp[n][2];
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A, int B, int C, int D) {

  int n = (int) A.size();
  int dp[n + 1][3]; // dp array to store answer of previous states

  for (int i = 0; i <= n; i += 1) {
    dp[i][0] = dp[i][1] = dp[i][2] = -1e9; // Initialize the dp array with minus infinity
  }

  for (int i = 1; i <= n; i += 1) {
    dp[i][0] = max(dp[i - 1][0], A[i - 1] * B); // Maximum value of A[i]*B
    dp[i][1] = max(dp[i - 1][1], dp[i][0] + A[i - 1] * C); // Maximum value of A[i]*B + A[j]*C
    dp[i][2] = max(dp[i - 1][2], dp[i][1] + A[i - 1] * D); // Maximum value of A[i]*B + A[j]*C + A[k]*D
  }

  return dp[n][2]; // return the answer.
}
```

