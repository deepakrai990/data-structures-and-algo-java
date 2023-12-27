### Q2. Intersecting Chords in a Circle
#### Problem Description
```text
Given a number A, return number of ways you can draw A chords in a circle with 2 x A points 
such that no 2 chords intersect.

Two ways are different if there exists a chord which is present in one way and not in other.
Return the answer modulo 10^9 + 7.
```
<p>Return the answer modulo <strong>10<sup>9</sup> + 7</strong>.</p>

#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A &lt;= 10<sup>3</sup></p>
</div>

```text
1 <= A <= 10^3
```
#### Input Format
```text
The first and the only argument contains the integer A.
```
#### Output Format
```text
Return an integer answering the query as described in the problem statement.
```
#### Example Input
```text
Input 1:
 A = 1

Input 2:
 A = 2
```
#### Example Output
```text
Output 1:
 1

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
    If points are numbered 1 to 2 in clockwise direction, then different ways to draw 
    chords are: {(1-2)} only. So, we return 1.

Explanation 2:
    If points are numbered 1 to 4 in clockwise direction, then different ways to draw 
    chords are:{(1-2), (3-4)} and {(1-4), (2-3)}.
    So, we return 2.
```
### Hints
* Hint 1
```text
Think in terms of DP.
Can we relate answer for N with smaller answers.

If we draw a chord between any two points, can you observe current set of points 
getting broken into two smaller sets? Can a chord be drawn between two points where 
each point belong to different set?
```
* Solution Approach
```text
Think in terms of DP.
Can we relate answer for N with smaller answers.

If we draw a chord between any two points, can you observe current set of points 
getting broken into two smaller sets S_1 and S_2? Can a chord be drawn between 
two points where each point belong to different set?

If we draw a chord from a point in S_1 to a point in S_2, it will surely intersect the 
chord we’ve just drawn.

So, we can arrive at a recurrence that Ways(n) = sum[i = 0 to n-1] { Ways(i)*Ways(n-i-1) }.

Here we iterate over i, assuming that size of one of the sets is i and size of other 
set automatically is (n-i-1) since we’ve already used a pair of points and i pair of 
points in one set.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static long mod = 1000000007;

    public int chordCnt(int A) {
        return catalanDP(A);
    }

    static int catalanDP(int n) {
        // Table to store results of subproblems 
        long catalan[] = new long[n + 2];
        // Initialize the first two values in table 
        catalan[0] = 1;
        catalan[1] = 1;
        // Fill entries in catalan[] using recursive formula 
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
                catalan[i] %= mod;
            }
        }
        // Return last entry 
        return (int) catalan[n];
    }
}
```
* * Solution in Javascript
```javascript
function catalanDP(n) {
    // Table to store results of subproblems 
    let catalan = new Array(n + 2);

    // Initialize first two values in table 
    catalan[0] = 1n;
    catalan[1] = 1n;

    // Fill entries in catalan[] using recursive formula 
    for (let i = 2; i <= n; i++) {
        catalan[i] = 0n;
        for (let j = 0; j < i; j++) {
            catalan[i] += catalan[j] * catalan[i - j - 1];
            catalan[i] %= 1000000007n;
        }
    }

    // Return last entry 
    return parseInt(catalan[n]);
}

module.exports = {
    //param A : integer
    //return an integer
    chordCnt: function (A) {
        return catalanDP(A);
    }
};
```
* * Solution in C++
```cpp
#define MOD 1000000007ll
typedef long long LL;
LL dp[1009];
LL rec(int n) {
    if (n == 0)
        return 1;
    LL & ret = dp[n];
    if (ret != -1) return ret;
    ret = 0;
    for (int i = 0; i < n; i++) {
        ret += (rec(i) * rec(n - i - 1)) % MOD;
        if (ret >= MOD)
            ret -= MOD;
    }
    return ret;
}

int Solution::chordCnt(int A) {
    memset(dp, -1, sizeof(dp));
    return (int) rec(A);
}
```

