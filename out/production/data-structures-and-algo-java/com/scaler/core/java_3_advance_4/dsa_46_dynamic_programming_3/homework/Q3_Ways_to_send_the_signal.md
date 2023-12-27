### Q3. Ways to send the signal
#### Problem Description
```text
You are trying to send signals to aliens using a linear array of A laser lights. 
You don't know much about how the aliens are going to percieve the signals, but what 
you know is that if two consecutive lights are on then the aliens might take 
it as a sign of danger and destroy the earth.

Find and return the total number of ways in which you can send a signal without 
compromising the safty of the earth. Return the ans % 10^9 + 7.
```
<p> Find and return the total number of ways in which you can send a signal without 
compromising the safty of the earth. Return the ans % 10<sup>9</sup> + 7.</p>

#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= A <= 10^5
```
#### Input Format
```text
The only argument given is integer A.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Return the ans%(10<sup>9</sup>+7). </p>
</div>

```text
Return the ans % (10^9 + 7).
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
 3

Output 2:
 5
```
#### Example Explanation
```text
Explanation 1:
    OFF OFF
    OFF ON 
    ON OFF
    All lights off is also a valid signal which probably means 'bye'

Explanation 2:
     OFF OFF OFF
     OFF OFF ON
     OFF ON OFF 
     ON OFF OFF
     ON OFF ON
```
### Hints
* Hint 1
```text
A string S of length i can be made from a string t of length i - 1 by adding '0' 
behind T or by adding '1' behind T if last character of T is not '1'.
```
* Solution Approach
```text
Dp recurrence:-
DP[0][i] = DP[0][i-1] + DP[1][i-1]

DP[1][i] = DP[0][i-1]

DP[0][i] = Count of all possible binary strings of lenght i without having 
           consecutive 1's and ending at 0

DP[1][i] = Count of all possible binary strings of length i without having 
           consecutive 1's and ending at 1
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
        long mod = 1000000007;
        long[][] dp = new long[2][A + 1];
        dp[0][1] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= A; i++) {
            dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
            dp[0][i] %= mod;
            dp[1][i] = dp[0][i - 1] % mod;
        }
        long res = (dp[0][A] + dp[1][A]) % mod;
        return (int) res;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : integer
    //return an integer
    solve: function (A) {
        let mod = 1000000007;
        let dp = new Array(2);
        dp[0] = new Array(A + 1);
        dp[1] = new Array(A + 1);
        dp[0][1] = 1;
        dp[1][1] = 1;
        for (let i = 2; i <= A; i++) {
            dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
            dp[0][i] %= mod;
            dp[1][i] = dp[0][i - 1] % mod;
        }
        let res = (dp[0][A] + dp[1][A]) % mod;
        return res;
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(int A) {
    long long mod = 1000000007;
    long long dp[2][A + 1];
    dp[0][1] = 1 LL;
    dp[1][1] = 1 LL;
    for (int i = 2; i <= A; i++) {
        dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
        dp[0][i] %= mod;
        dp[1][i] = dp[0][i - 1] % mod;
    }
    return (dp[0][A] + dp[1][A]) % mod;
}
```

