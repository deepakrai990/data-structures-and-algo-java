### Q3. Let's Party
#### Problem Description
```text
In Danceland, one person can party either alone or can pair up with another person.

Can you find in how many ways they can party if there are A people in Danceland?

Note: Return your answer modulo 10003, as the answer can be large.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A &lt;= 10<sup>5</sup> </p>
</div>

```text
1 <= A <= 10^5
```
#### Input Format
```text
Given only argument A of type Integer, number of people in Danceland.
```
#### Output Format
```text
Return an integer denoting the number of ways people of Danceland can party.
```
#### Example Input
```text
Input 1:
 A = 3

Input 2:
 A = 5
```
#### Example Output
```text
Output 1:
 4

Output 2:
 26
```
#### Example Explanation
```text
Explanation 1:
    Let suppose three people are A, B, and C. There are only 4 ways to party
    (A, B, C) All party alone
    (AB, C) A and B party together and C party alone
    (AC, B) A and C party together and B party alone
    (BC, A) B and C party together and A
    here 4 % 10003 = 4, so answer is 4.

Explanation 2:
    Number of ways they can party are: 26.
```
### Hints
* Hint 1
```text
Every person can either pair with another person or can remain single.
Think how can you represent this in a recurrence relation.
```
* Solution Approach
```text
Every person can either pair with another person or can remain single.
Let us consider the kth person, he can either remain single or he can pair up with 
someone from [1, k-1].

So here recurrence relation is :
Number_of_ways(k-1) + (k-1) * Number_of_ways(k-2)

and by using dynamic programming we can solve overlapping subproblems.
i.e. dp[i] = dp[i-1] + dp[i-2] * (i-1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
        if (A == 1)
            return 1;
        int[] dp = new int[A + 1]; // array to store values of subproblems
        int mod = 10003;

        // intialize base conditions
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= A; i += 1) {
            dp[i] = (dp[i - 1] + (i - 1) % mod * dp[i - 2] % mod) % mod; // solve sub problems
        }
        // taking mod to prevent overflow

        return dp[A]; // return answer
    }
}
```
* * Solution in Javascript
```javascript
const mod = 10003;
module.exports = {
  solve: function (A) {
    let party_ways = new Array(A + 1);
    party_ways[1] = 1;
    party_ways[2] = 2;
    for (let i = 3; i <= A; i++) {
      party_ways[i] =
        (party_ways[i - 1] +
          ((((party_ways[i - 2] % mod) * (i - 1)) % mod) % mod)) %
        mod;
    }
    return party_ways[A];
  },
};
```
* * Solution in C++
```cpp
int Solution::solve(int A) {

  int dp[A + 1]; // array to store values of subproblems
  int mod = 10003;

  // intialize base conditions
  dp[0] = 0;
  dp[1] = 1;
  dp[2] = 2;

  for (int i = 3; i <= A; i += 1) {
    dp[i] = (dp[i - 1] + (i - 1) % mod * dp[i - 2] % mod) % mod; // solve sub problems
  }
  // taking mod to prevent overflow

  return dp[A]; // return answer
}
```

