### Q3. Coin Sum Infinite
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>You are given a set of coins <strong>A</strong>. In how many ways can you make 
    sum <strong>B</strong> assuming you have infinite amount of each coin in 
    the set.</p>
    <p><strong>NOTE: </strong></p>
    <ul><li>Coins in set A will be unique. Expected space complexity of this problem 
    is <strong>O(B)</strong>.</li>
    <li>The answer can overflow. So, return the answer % (10<sup>6</sup> + 7).</li></ul>
</div>

```text
You are given a set of coins A. In how many ways can you make sum B assuming you have 
infinite amount of each coin in the set.

NOTE:
    * Coins in set A will be unique. Expected space complexity of this problem is O(B).
    * The answer can overflow. So, return the answer % (10^6 + 7).
```
#### Problem Constraints
```text
1 <= A <= 500
1 <= A[i] <= 1000
1 <= B <= 50000
```
#### Input Format
```text
First argument is an integer array A representing the set.
Second argument is an integer B.
```
#### Output Format
```text
Return an integer denoting the number of ways.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3]
 B = 4

Input 2:
 A = [10]
 B = 10
```
#### Example Output
```text
Output 1:
 4

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    The 4 possible ways are:
    {1, 1, 1, 1}
    {1, 1, 2}
    {2, 2}
    {1, 3} 

Explanation 2:
    There is only 1 way to make sum 10.
```
### Hints
* Hint 1
```text
We can approach the problem by dividing the problem into smaller subproblems. We can 
break this into 2 parts for a particular coin:

    1. we use this coin.
    2. we do not use this coin.

Think of using Dynamic Programming.
```
* Solution Approach
```text
Let’s suppose dp[i] denotes the number of ways to make sum i.

Assume we have calculated all the value of dp[k] for k < i.
To calculate dp[i], if the coin we are considering is A[j] then the number of ways is simply is dp[i-A[j]].

Base Case: dp[0] = 1 as sum 0 can be made without taking any coins.

Algorithm:

    Run a loop on the coins 
        For each coin c_i, loop over all sum s_j from 0 to B:
            For each s_j dp[s_j] += dp[s_j - c_i]

dp[B] will be our answer. Remember to take modulo 1000007.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int coinchange2(int[] A, int B) {
        int[] num_ways = new int[B + 1];
        int Mod = 1000000 + 7;
        int i, j, m = A.length;
        Arrays.fill(num_ways, 0);
        num_ways[0] = 1;

        for (i = 0; i < m; i++) {
            for (j = A[i]; j <= B; j++) {
                num_ways[j] += num_ways[j - A[i]];
                num_ways[j] %= Mod;

            }
        }
        return num_ways[B];
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //param B : integer
    //return an integer
    coinchange2: function (coins, amount) {
        var dp = [];
        dp[0] = 1;
        var mod = 1e6 + 7;
        for (var i = 0; i < coins.length; ++i) {
            for (var j = coins[i]; j <= amount; ++j) {
                dp[j] = ((dp[j] || 0) + (dp[j - coins[i]] || 0)) % mod;
            }
        }
        return dp[amount];
    }
};
```
* * Solution in C++
```cpp
int Solution::coinchange2(vector < int > & A, int B) {
    /* 
    num_ways[i] will be storing the number of solutions for
    sum i. We need N+1 rows as the table is constructed
    in bottom up manner using the base case (N = 0)
    */
    int num_ways[B + 1], Mod = 1e6 + 7;
    int i, j, m = A.size();

    // Initialise all values with 0
    memset(num_ways, 0, sizeof(num_ways));

    // Base case (If required sum is 0)
    num_ways[0] = 1;

    // Pick all coins one by one and update the num_ways[] values
    for (i = 0; i < m; i++) {
        for (j = A[i]; j <= B; j++) {
            num_ways[j] += num_ways[j - A[i]];
            num_ways[j] %= Mod;

        }
    }
    return num_ways[B];
}
```

