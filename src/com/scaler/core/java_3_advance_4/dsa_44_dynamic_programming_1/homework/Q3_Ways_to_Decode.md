### Q3. Ways to Decode
#### Problem Description
```text
A message containing letters from A-Z is being encoded to numbers using the 
following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message denoted by string A containing digits, determine the total 
number of ways to decode it modulo 10^9 + 7.
```
<p>Given an encoded message denoted by string <strong>A</strong> 
containing digits, determine the total number of ways to decode 
it modulo <strong>10<sup>9</sup> + 7</strong>.</p>

#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= length(A) &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= length(A) <= 10^5
```
#### Input Format
```text
The first and the only argument is a string A.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Return an integer, representing the number of ways to decode the 
    string modulo <strong>10<sup>9</sup> + 7</strong>.</p>
</div>

```text
Return an integer, representing the number of ways to decode the string modulo 10^9 + 7.
```
#### Example Input
```text
Input 1:
 A = "12"

Input 2:
 A = "8"
```
#### Example Output
```text
Output 1:
 2

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
    The number of ways decoding "12" is 2.

Explanation 2:
    Given encoded message "8", it could be decoded as only "H" (8).
    The number of ways decoding "8" is 1.
```
### Hints
* Hint 1
```text
Try to compute answer for all prefixes of different lengths.

For computing number of ways for decoding string upto ith length you can use number 
of ways for decoding string upto (i-1)th or (i-2)th length.

Think DP.
```
* Solution Approach
```text
Lets first look at the bruteforce solution.
It only makes sense to look at 1 digit or 2 digit pairs ( as 3 digit sequence will be 
greater than 26 ).

So, when looking at the start of the string, we can either form a one digit code, and 
then look at the ways of forming the rest of the string of length L - 1, or we can 
form 2 digit code if its valid and add up the ways of decoding rest of the string 
of length L - 2.

This obviously is exponential.

The code would go something like the following :

 int ways(string &s, int startIndex) {
    // BASE CASES

    int answer = 0;
    if (isValid(s[startIndex])) answer += ways(s, startIndex + 1);
        if (isValid(s[startIndex] + s[startIndex + 1])) answer += ways(s, startIndex + 2);
        return answer;
     }
Note that in this case, startIndex can only take L number of values. Can you use the 
fact to store the result so that the function processing does not happen so many times ?
```
* Complete Solution
* * Solution in Java
```java
public class Solution {

    private int[] dp;
    private int N;
    private String A;

    public int numDecodings(String A) {
        N = A.length();
        if (A == null)
            return 0;

        dp = new int[N];
        Arrays.fill(dp, -1);
        this.A = A;
        return rec(N - 1);
    }

    private int rec(int index) {
        if (index < 0)
            return 1;
        if (dp[index] != -1)
            return dp[index] % 1000000007;
        int ways = 0;
        if (A.charAt(index) > '0') {
            ways = rec(index - 1);
            ways %= 1000000007;
        }
        if (isValidTwoDigits(index)) {
            ways += rec(index - 2);
            ways %= 1000000007;
        }
        return dp[index] = ways;
    }

    private boolean isValidTwoDigits(int index) {
        if (index > 0 && (A.charAt(index - 1) == '1' || A.charAt(index - 1) == '2' && A.charAt(index) < '7'))
            return true;
        return false;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    numDecodings: function (s) {
        const MOD = 1e9 + 7;

        if (s == null || s.length === 0) return 0;
        if (s[0] === "0") return 0;

        const dp = new Array(s.length + 1).fill(0);

        dp[0] = 1;
        dp[1] = 1;

        for (let i = 2; i <= s.length; i++) {
            const a = Number(s.slice(i - 1, i));
            if (a >= 1 && a <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= MOD;
            }

            const b = Number(s.slice(i - 2, i));
            if (b >= 10 && b <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }
        return dp[s.length] % MOD;
    },
};
```
* * Solution in C++
```cpp
const int mod = 1000000007;
const int maxn = 100009;
int dp[maxn];
int solve(int index, string & A) {
  if (index >= A.size())
    return 1;
  if (dp[index] != -1)
    return dp[index];
  if (A[index] == '0')
    return dp[index] = 0;
  int ans = solve(index + 1, A);
  ans %= mod;
  if (index + 1 < A.size()) {
    int num = ((A[index] - '0') * 10) + (A[index + 1] - '0');
    if (num >= 10 && num <= 26)
      ans += solve(index + 2, A);
    ans %= mod;
  }
  return dp[index] = ans;
  ans %= mod;
}
int Solution::numDecodings(string A) {
  memset(dp, -1, sizeof(dp));
  return solve(0, A);
}
```

