### Q2. Unbounded Knapsack
#### Problem Description
```text
Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], 
we need to calculate maximum amount that could fit in this quantity.

This is different from classical Knapsack problem, here we are allowed to use 
unlimited number of instances of an item.
```
#### Problem Constraints
```text
1 <= A <= 1000

1 <= |B| <= 1000

1 <= B[i] <= 1000

1 <= C[i] <= 1000
```
#### Input Format
```text
First argument is the Weight of knapsack A

Second argument is the vector of values B

Third argument is the vector of weights C
```
#### Output Format
```text
Return the maximum value that fills the knapsack completely
```
#### Example Input
```text
Input 1:
 A = 10
 B = [5]
 C = [10]

Input 2:
 A = 10
 B = [6, 7]
 C = [5, 5]
```
#### Example Output
```text
Output 1:
 5

Output 2:
 14
```
#### Example Explanation
```text
Explanation 1:
    Only valid possibility is to take the given item.

Explanation 2:
    Take the second item twice.
```
### Hints
* Hint 1
```text
This is quite closely related to standard knapsack except the fact that items can be repeated.
Can you use this fact to modify the recursion of the original knapsack problem?
```
* Solution Approach
```text
This is quite closely related to standard knapsack except the fact that items can be repeated.
In fact, the only change that we need to do is to introduce a term that allows us take the same item again.
This can be done by just subtracting the weight of the item from current weight and iterating ahead.

Lets take dp[i] as the maximum value of the items that we can get whose sum of weights is equal to i.

We can come up with the following relation :

    dp[i] = max( dp[i] , dp[i-C[j]] + B[j] )  

    where 0<=i<=A , 0<=j<n and C[j] >= i

Time complexity : O(A*n)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, int[] B, int[] C) {
        int W = A;
        int[] dp = new int[W + 1];
        Arrays.fill(dp, 0);
        for (int i = 0; i <= W; i++)
            for (int j = 0; j < B.length; j++)
                if (C[j] <= i)
                    dp[i] = Math.max(dp[i], dp[i - C[j]] + B[j]);
        return dp[W];
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : integer
    //param B : array of integers
    //param C : array of integers
    //return an integer
    solve: function (A, B, C) {
        let W = A;
        let dp = new Array(W + 1).fill(0);
        for (let i = 0; i <= W; i++)
            for (let j = 0; j < B.length; j++)
                if (C[j] <= i)
                    dp[i] = Math.max(dp[i], dp[i - C[j]] + B[j]);
        return dp[W];
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(int A, vector < int > & B, vector < int > & C) {
    int W = A;
    int dp[W + 1];
    memset(dp, 0, sizeof dp);

    // Fill dp[] using above recursive formula
    for (int i = 0; i <= W; i++)
        for (int j = 0; j < B.size(); j++)
            if (C[j] <= i)
                dp[i] = max(dp[i], dp[i - C[j]] + B[j]);
    return dp[W];
}
```

