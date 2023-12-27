### Q1. Best Time to Buy and Sell Stocks I
#### Problem Description
```text
Say you have an array, A, for which the i^th element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Return the maximum possible profit.
```
#### Problem Constraints
```text
0 <= len(A) <= 7e5
1 <= A[i] <= 1e7
```
#### Input Format
```text
The first and the only argument is an array of integers, A.
```
#### Output Format
```text
Return an integer, representing the maximum possible profit.
```
#### Example Input
```text
Input 1:
 A = [1, 2]

Input 2:
 A = [1, 4, 5, 2, 4]
```
#### Example Output
```text
Output 1:
 1

Output 2:
 4
```
#### Example Explanation
```text
Explanation 1:
    Buy the stock on day 0, and sell it on day 1.

Explanation 2:
    Buy the stock on day 0, and sell it on day 2.
```
### Hints
* Hint 1
```text
Basically you need to find the maximum value of A[j]-A[i] where j>i.

Now can you do this?
```
* Solution Approach
```text
Basically you need to find the maximum value of A[j]-A[i] where j>i.

Now can you do this?
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] A) {
        if (A.length == 0 || A.length == 1) {
            return 0;
        }
        
        int max = A[A.length - 1];

        int profit = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > max) {
                max = A[i];
            }
            // max stores the maximum value to the right of A[i]
            profit = Math.max(profit, max - A[i]);
        }

        return profit;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //return an integer
    maxProfit: function (A) {
        let max = A[A.length - 1];
        let profit = 0;
        for (let i = A.length - 2; i >= 0; i--) {
            if (A[i] > max) {
                max = A[i];
            }
            // max stores the maximum value to the right of A[i]
            profit = Math.max(profit, max - A[i]);
        }
        return profit;
    }
};
```
* * Solution in C++
```cpp
int Solution::maxProfit(const vector<int> &A) {
    int sz = A.size();
    int maxTillNow = -1000000000, maxGain = 0;
    for (int i = sz - 1; i >= 0; i--) {
        maxGain = max(maxGain, maxTillNow - A[i]);
        maxTillNow = max(maxTillNow, A[i]);
    }
    return maxGain;
}
```

