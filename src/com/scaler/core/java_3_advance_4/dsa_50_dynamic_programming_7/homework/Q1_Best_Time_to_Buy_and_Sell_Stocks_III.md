### Q1. Best Time to Buy and Sell Stocks III
#### Problem Description
```text
Say you have an array, A, for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most 2 transactions.

Return the maximum possible profit.

Note: You may not engage in multiple transactions at the same time (ie, you must sell 
the stock before you buy again).
```
#### Problem Constraints
```text
1 <= length(A) <= 7e5
1 <= A[i] <= 1e7
```
#### Input Format
```text
The first and the only argument is an integer array, A.
```
#### Output Format
```text
Return an integer, representing the maximum possible profit.
```
#### Example Input
```text
Input 1:
    A = [1, 2, 1, 2]
    
Input 2:
    A = [7, 2, 4, 8, 7]
```
#### Example Output
```text
Output 1:
    2
    
Output 2:
    6
```
#### Example Explanation
```text
Explanation 1: 
    Day 0 : Buy 
    Day 1 : Sell
    Day 2 : Buy
    Day 3 : Sell
    
Explanation 2:
    Day 1 : Buy
    Day 3 : Sell
```
### Hints
* Hint 1
```text
Think DP.

What are the essential things you need to keep in your DP states?

You will need to store maximum number of transactions you can do in any prefix of array.
```
* Solution Approach
```text
As we have to find the answer for atmost two transactions, We can keep four variables namely
1) First buy (this should be minimum at any given position)
2) First Sell (this should be maximum at any given position)
3) Second buy (this should be minimum at any given position)
4) Second Sell (this should be maximum at any given position)

Our answer would be max(First sell,Second sell)

How do we update these values?

First initialise FirstBuy and SecondBuy as INT_MAX and FirstSell and SecondSell as 0.

For every i we can update them in the following way (All the updates are simultaneous)

int b1=FirstBuy,s1=FirstSell,b2=SecondBuy,s2=SecondSell

FirstBuy=min(b1,A[i]);
FirstSell=max(s1,A[i]-b1);
SecondBuy=min(b2,A[i]-s1);
SecondSell=max(s2,A[i]-b2);

Time Complexity: O(n)
Space Complexity: O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] A) {
        int FirstBuy = 1000000000, FirstSell = 0, SecondBuy = 1000000000, SecondSell = 0;
        for (int i = 0; i < A.length; i++) {
            int b1 = FirstBuy, s1 = FirstSell, b2 = SecondBuy, s2 = SecondSell;
            FirstBuy = Math.min(b1, A[i]);
            FirstSell = Math.max(s1, A[i] - b1);
            SecondBuy = Math.min(b2, A[i] - s1);
            SecondSell = Math.max(s2, A[i] - b2);
        }
        return Math.max(FirstSell, SecondSell);
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //return an integer
    maxProfit: function (A) {
        let FirstBuy = 1000000000, FirstSell = 0, SecondBuy = 1000000000, SecondSell = 0;
        for (let i = 0; i < A.length; i++) {
            let b1 = FirstBuy, s1 = FirstSell, b2 = SecondBuy, s2 = SecondSell;
            FirstBuy = Math.min(b1, A[i]);
            FirstSell = Math.max(s1, A[i] - b1);
            SecondBuy = Math.min(b2, A[i] - s1);
            SecondSell = Math.max(s2, A[i] - b2);
        }
        return Math.max(FirstSell, SecondSell);
    }
};
```
* * Solution in C++
```cpp
int Solution::maxProfit(const vector<int> &A) {
    int FirstBuy = INT_MAX, FirstSell = 0, SecondBuy = INT_MAX, SecondSell = 0;
    for(int i = 0; i < A.size(); i++){
        int b1 = FirstBuy, s1 = FirstSell, b2 = SecondBuy, s2 = SecondSell;
        FirstBuy = min(b1, A[i]);
        FirstSell = max(s1, A[i] - b1);
        SecondBuy = min(b2, A[i] - s1);
        SecondSell = max(s2, A[i] - b2);
    }
    return max(FirstSell,SecondSell);
}
```

