### Q2. N digit numbers
#### Problem Description
```text
Find out the number of A digit positive numbers, whose digits on being added equals 
to a given number B.

Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. 
leading zeroes are not allowed.

Since the answer can be large, output answer modulo 1000000007
```
#### Problem Constraints
```text
1 <= A <= 1000

1 <= B <= 10000
```
#### Input Format
```text
First argument is the integer A

Second argument is the integer B
```
#### Output Format
```text
Return a single integer, the answer to the problem
```
#### Example Input
```text
Input 1:
 A = 2
 B = 4

Input 2:
 A = 1
 B = 3
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
     Valid numbers are {22, 31, 13, 40}
     Hence output 4.

Explanation 2:
    Only valid number is 3
```
### Hints
* Hint 1
```text
Try to think in terms of Recursion with two states - current digit count and current 
sum. You may also think to try and make this into a dp solution.
```
* Solution Approach
```text
Part 1

Lets build a recursive approach to this problem. Let rec_Count(id, sum) be the number 
of numbers having digit count as id and digit sum as sum. To be more clear,

rec_Count(id, sum) = ∑ rec_Count(id-1,sum-x) where 0 <= x <= 9 && sum-x >= 0. 
Note that the above relation has not handled the leading zeroes case. How can 
you handle them ?

Part 2

We can handle them by calling this rec_Count function for the first digit 
explicitly. i.e. we can fix the starting digits from 1-9 explicitly and then call 
the recursion function to handle the other digits(i.e. N - 1 digits). Finally we can 
add them together to get the final answer.

Gotcha : Try to think about the approach when sum is given as 0.

Now, we have the recursive solution. However, the recursive solution is too expensive 
because of the exponential time complexity.

A key thing to note here is that there are overlapping subproblems as many things 
are being calculated repeatedly in the recursive solution ? Can you use the concept 
of Dynamic programming to optimize the time complexity here ?

Final solution

My recursive function only depends on id and sum variable. If ID is the max 
possible id, and SUM is the max possible sum, then there are only ID * SUM number 
of ways in which the function can be called.

We can use memoization to store those values.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int dp[][] = new int[1001][10001];
    int rec(int id, int sum) {
        if (sum < 0)
            return 0;
        if (id == 0 && sum == 0)
            return 1;
        if (id == 0)
            return 0;
        if (dp[id][sum] != -1)
            return dp[id][sum];
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += rec(id - 1, sum - i);
            ans %= 1000000007;
        }
        return dp[id][sum] = ans;
    }
    public int solve(int A, int B) {
        int ans = 0;
        for (int i = 0; i < A + 1; i++) {
            for (int j = 0; j < B + 1; j++)
                dp[i][j] = -1;
        }
        for (int i = 1; i < 10; i++) {
            ans += rec(A - 1, B - i);
            ans %= 1000000007;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
let dp = new Array(1001);

function rec(id, sum) {
    if (sum < 0)
        return 0;
    if (id == 0 && sum == 0)
        return 1;
    if (id == 0)
        return 0;

    if (dp[id][sum] != -1)
        return dp[id][sum];

    let ans = 0;
    for (let i = 0; i < 10; i++) {
        ans += rec(id - 1, sum - i);
        ans %= 1000000007;
    }
    return dp[id][sum] = ans;
}
module.exports = {
    //param A : integer
    //param B : integer
    //return an integer
    solve: function (A, B) {
        let ans = 0;
        for (let i = 0; i < A + 1; i++) {
            dp[i] = new Array(1001);
            for (let j = 0; j < B + 1; j++)
                dp[i][j] = -1;
        }
        for (let i = 1; i < 10; i++) {
            ans += rec(A - 1, B - i);
            ans %= 1000000007;
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
int rec(vector < vector < int > > & dp, int id, int sum) {
    if (sum < 0)
        return 0;
    if (id == 0 && sum == 0) //Base Case
        return 1;
    if (id == 0)
        return 0;
    if (dp[id][sum] != -1)
        return dp[id][sum];
    int ans = 0;
    for (int i = 0; i < 10; i++) {
        ans += rec(dp, id - 1, sum - i);
        ans %= 1000000007;
    }
    return dp[id][sum] = ans;
}

int Solution::solve(int A, int B) {
    int ans = 0;
    vector < vector < int > > dp;
    dp.resize(A + 1);
    for (int i = 0; i < A + 1; i++) {
        dp[i].resize(B + 1);
        for (int j = 0; j < B + 1; j++)
            dp[i][j] = -1;
    }
    for (int i = 1; i < 10; i++) {
        ans += rec(dp, A - 1, B - i);
        ans %= 1000000007;
    }
    return ans;
}
```

