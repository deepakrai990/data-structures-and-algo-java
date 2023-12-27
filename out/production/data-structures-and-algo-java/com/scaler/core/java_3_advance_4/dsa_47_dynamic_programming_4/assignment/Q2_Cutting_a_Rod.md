### Q2. Cutting a Rod
#### Problem Description
```text
Given a rod of length N units and an array A of size N denotes prices that contains 
prices of all pieces of size 1 to N.

Find and return the maximum value that can be obtained by cutting up the rod and 
selling the pieces.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 1000</p>
    <p>0 &lt;= A[i] &lt;= 10<sup>6</sup></p>
</div>

```text
1 <= N <= 1000

0 <= A[i] <= 10^6
```
#### Input Format
```text
First and only argument is an integer array A of size N.
```
#### Output Format
```text
Return an integer denoting the maximum value that can be obtained by cutting up the 
rod and selling the pieces.
```
#### Example Input
```text
Input 1:
 A = [3, 4, 1, 6, 2]

Input 2:
 A = [1, 5, 2, 5, 6]
```
#### Example Output
```text
Output 1:
 15

Output 2:
 11
```
#### Example Explanation
```text
Explanation 1:
    Cut the rod of length 5 into 5 rods of length (1, 1, 1, 1, 1) and sell them 
    for (3 + 3 + 3 + 3 + 3) = 15.

Explanation 2:
    Cut the rod of length 5 into 3 rods of length (2, 2, 1) and sell them 
    for (5 + 5 + 1) = 11.
```
### Hints
* Hint 1
```text
Naive solution for this problem is to generate all configurations of different pieces 
and find the highest priced configuration.

This solution is exponential in term of time complexity.

Can you think of using Dynamic Programming to find an efficient solution?
```
* Solution Approach
```text
For the naive solution, We can get the best price by making a cut at different 
positions and comparing the values obtained after a cut.

We can recursively call the same function for a piece obtained after a cut.

Let’s optimize it.

Consider val[i] denotes the maximum price we can get by selling the rod (can sell 
by cutting any how) of length i.

->for all j from 0 to i-1, val[i] = max(val[i],A[j] + val[i-j-1]).

val[n] will be the output.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        int[] val = new int[n + 1];
        val[0] = 0;

        // Build the table val[] in bottom up manner and return the last entry from the table
        for (int i = 1; i <= n; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val, A[j] + val[i - j - 1]);
            val[i] = max_val;
        }

        return val[n];
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //return an integer
    solve: function (A) {
        let n = A.length;
        let val = new Array(n + 1);
        val[0] = 0;

        // Build the table val[] in bottom up manner and return the last entry from the table
        for (let i = 1; i <= n; i++) {
            let max_val = Number.MIN_VALUE;
            for (let j = 0; j < i; j++)
                max_val = Math.max(max_val, A[j] + val[i - j - 1]);
            val[i] = max_val;
        }
        return val[n];
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A) {
    int n = A.size();
    int val[n + 1];
    val[0] = 0;

    // Build the table val[] in bottom up manner and return the last entry from the table
    for (int i = 1; i <= n; i++) {
        int max_val = INT_MIN;
        for (int j = 0; j < i; j++)
            max_val = max(max_val, A[j] + val[i - j - 1]);
        val[i] = max_val;
    }

    return val[n];
}
```

