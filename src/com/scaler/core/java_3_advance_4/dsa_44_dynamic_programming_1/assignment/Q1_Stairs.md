### Q1. Stairs
#### Problem Description
```text
You are climbing a staircase and it takes A steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb 
to the top?

Return the number of distinct ways modulo 1000000007
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= A <= 10^5
```
#### Input Format
```text
The first and the only argument contains an integer A, the number of steps.
```
#### Output Format
```text
Return an integer, representing the number of ways to reach the top.
```
#### Example Input
```text
Input 1:
 A = 2

Input 2:
 A = 3
```
#### Example Output
```text
Output 1:
 2

Output 2:
 3
```
#### Example Explanation
```text
Explanation 1:
    Distinct ways to reach top: [1, 1], [2].

Explanation 2:
    Distinct ways to reach top: [1 1 1], [1 2], [2 1].
```
### Hints
* Hint 1
```text
Think of DP.

You need to come up with O(n) solution.
```
* Solution Approach
```text
This is the most basic dynamic programming problem.
We know that we can take 1 or 2 step at a time. So, to take n steps,
we must have arrived at it immediately from (n-1) or (n-2) step.
If we knew the number of ways to reach (n-1) and (n-2) step,
our answer would be the summation of their number of ways.

Time Complexity : O(n)

BONUS: Can you come up with O(logn) solution?
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    int mod = 1000000007;

    public int climbStairs(int A) {
        int ways[] = new int[A + 1]; // ways[i] denotes the number of ways to reach the i'th step.

        if (A == 1)
            return 1;

        ways[1] = 1;
        ways[2] = 2;

        for (int i = 3; i <= A; i++) {
            ways[i] = (ways[i - 1] + ways[i - 2]) % mod;
        }
        return ways[A];
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    climbStairs: function (A) {
        let mod = 1000000007;
        let stairs = new Array(A + 1);
        stairs[0] = 1;
        stairs[1] = 1;
        for (let i = 2; i <= A; i++) {
            stairs[i] = (stairs[i - 1] + stairs[i - 2]) % mod;
        }
        return stairs[A];
    },
};
```
* * Solution in C++
```cpp
int mod = 1000000007;
int Solution::climbStairs(int A) {
    assert(A>=1 and A<=1e5);
    int ways[A + 1]; // ways[i] denotes the number of ways to reach the i'th step.
    ways[0] = 1;
    ways[1] = 1;
    
    for (int i = 2; i <= A; i++) ways[i] = (ways[i - 1] + ways[i - 2])%mod;
    
    return ways[A];
}
```

