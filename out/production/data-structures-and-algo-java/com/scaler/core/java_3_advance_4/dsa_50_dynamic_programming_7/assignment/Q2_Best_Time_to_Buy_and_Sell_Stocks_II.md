### Q2. Best Time to Buy and Sell Stocks II
#### Problem Description
```text
Say you have an array, A, for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit.

You may complete as many transactions as you like (i.e., buy one and sell one share of 
the stock multiple times).

However, you may not engage in multiple transactions at the same time (ie, you must 
sell the stock before you buy again).
```
#### Problem Constraints
```text
0 <= len(A) <= 1e5
1 <= A[i] <= 1e7
```
#### Input Format
```text
The first and the only argument is an array of integer, A.
```
#### Output Format
```text
Return an integer, representing the maximum possible profit.
```
#### Example Input
```text
Input 1:
    A = [1, 2, 3]
    
Input 2:
    A = [5, 2, 10]
```
#### Example Output
```text
Output 1:
    2
    
Output 2:
    8
```
#### Example Explanation
```text
Explanation 1:
    => Buy a stock on day 0.
    => Sell the stock on day 1. (Profit +1)
    => Buy a stock on day 1.
    => Sell the stock on day 2. (Profit +1)

    Overall profit = 2
    
Explanation 2:
    => Buy a stock on day 1.
    => Sell the stock on on day 2. (Profit +8)

    Overall profit = 8
```
### Hints
* Hint 1
```text
This problem can be solved in different ways.

Try to observe when it will be optimal to buy and sell the stock.

Or you can also try to come up with a dp solution such that what can be possible 
thing to do( states to go) after you purchase stock on some day.
```
* Solution Approach
```text
Observation based solution:

Note 1: I will never buy a stock and sell it in loss.

Note 2: If A[i] < A[i+1], I will always buy a stock on i and sell it on i+1.
Think and try to come up with a proof on the validity of the statement.

DP based solution:

Let Dp[i] = max profit you can gain in region (i,i+1,….,n).
Then Dp[i] = max(Dp[i+1],-A[i] + max( A[j]+Dp[j] st j > i ) )

Can you come up with base cases and direction of computation now?
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] A) {
        int total = 0, sz = A.length;
        for (int i = 0; i < sz - 1; i++) {
            if (A[i + 1] > A[i]) 
                total += A[i + 1] - A[i];
        }
        return total;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //return an integer
    maxProfit: function (A) {
        let total = 0, sz = A.length;
        for (let i = 0; i < sz - 1; i++) {
            if (A[i + 1] > A[i]) {
                total += A[i + 1] - A[i];
            }
        }
        return total;
    }
};
```
* * Solution in C++
```cpp
int Solution::maxProfit(const vector<int> &A) {
    int total = 0, sz = A.size();
    for (int i = 0; i < sz - 1; i++) {
        if (A[i + 1] > A[i]) 
            total += A[i + 1] - A[i];
    }
    return total;
}
```

