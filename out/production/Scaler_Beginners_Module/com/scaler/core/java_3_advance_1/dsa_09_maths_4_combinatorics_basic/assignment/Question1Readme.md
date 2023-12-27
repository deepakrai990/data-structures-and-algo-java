### Q1. Compute nCr % m
#### Problem Description

<p>Given three integers <strong>A</strong>, <strong>B,</strong> 
and <strong>C</strong>, where <strong>A</strong> represents 
<strong>n</strong>, <strong>B</strong> represents 
<strong>r,</strong> and <strong>C</strong> represents 
<strong>m</strong>, find and return the value of 
<strong><sup>n</sup>C<sub>r</sub> % m</strong> where 
<strong><sup>n</sup>C
<sub>r</sub> % m = (n!/((n-r)!*r!))% m</strong>.</p>

<p><strong>x!</strong> means factorial of x i.e. 
<strong>x! = 1 * 2 * 3... * x.</strong></p>


```text
x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
```
#### Problem Constraints
* <p>1 &lt;= A * B &lt;= 10<sup>6</sup></p>
* <p>1 &lt;= B &lt;= A</p>
* <p>1 &lt;= C &lt;= 10<sup>6</sup></p>
```text
1 <= A * B <= 10^6

1 <= B <= A

1 <= C <= 10^6
```
#### Input Format
```text
The first argument given is integer A ( = n).
The second argument given is integer B ( = r).
The third argument given is integer C ( = m).
```
#### Output Format
```text
Return the value of nCr % m.
```
#### Example Input
```text
Input 1:
 A = 5
 B = 2
 C = 13

Input 2:
 A = 6
 B = 2
 C = 13
```
#### Example Output
```text
Output 1:
 10

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
```
<pre> The value of <sup>5</sup>C<sub>2</sub> % 11 is 10.</pre>
```text
Explanation 2:
```
<pre> The value of <sup>6</sup>C<sub>2</sub> % 13 is 2.</pre>

### Hints
* Hint 1
<p>Use the property : <sup>n</sup>C<sub>r</sub> = <sup>n-1</sup>
C<sub>r-1</sub> + <sup>n-1</sup>C<sub>r</sub>.</p>

```text

```
* Solution Approach
```text
Suppose we calculate nCr by calculating the factorial of 
each number and then doing n! / (r! * (n-r)!) % m. This 
will not work as the factorial can be very large and 
will cause overflow.
```

<p>As we know <sup>n</sup>C<sub>r</sub> = 
<sup>n-1</sup>C<sub>r-1</sub> + <sup>n-1</sup>
C<sub>r</sub>.</p>

```text
So we will use the Dynamic Programming approach and 
calculate the value of nCr.
```

* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, int B, int C) {
        // dp[n][r] stores the value of nCr
        int[][] dp = new int[A + 1][B + 1];
        for(int i = 0; i <= A; i++) {
            for(int j = 0; j <= Math.min(i, B); j++) {
                if(j == i || j == 0) {
                    dp[i][j] = 1;
                } else {
                    // nCr = (n - 1)C(r - 1) + (n - 1)Cr
                    dp[i][j] = (dp[i - 1][j - 1] % C + dp[i - 1][j] % C) % C;
                }
            }
        }
        return dp[A][B] % C;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A, B, C) {
        // dp[n][r] stores the value of nCr
        let dp = new Array(A + 1).fill(0).map(() => new Array(B + 1).fill(0));
        dp[0][0] = 1;
        for (let i = 1; i <= A; i++) {
            dp[i][0] = 1;
            for (let j = 1; j <= B; j++) {
                // nCr = (n - 1)C(r - 1) + (n - 1)Cr
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % C;
            }
        }
        return dp[A][B];
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(int A, int B, int C) {
    int dp[A + 1][B + 1];
    // dp[n][r] stores the value of nCr
    for(int i = 0; i <= A; i++) {
        for(int j = 0; j <= min(i, B); j++) {
            if(j == i || j == 0) {
                dp[i][j] = 1;
            }
            else {
                // nCr = (n - 1)C(r - 1) + (n - 1)Cr
                dp[i][j] = (dp[i - 1][j - 1] % C + dp[i - 1][j] % C) % C;
            }
        }
    }
    return dp[A][B] % C;
}
```

