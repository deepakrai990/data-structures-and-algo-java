### Q3. Ath Magical Number
#### Problem Description
```text
You are given three positive integers, A, B, and C.

Any positive integer is magical if divisible by either B or C.
```

<p>Return the <strong>A<sup>th</sup></strong> smallest 
magical number. Since the answer may be very large, 
return modulo <strong>10<sup>9</sup> + 7</strong>.</p>

#### Problem Constraints
* <p>1 &lt;= A &lt;= 10<sup>9</sup></p>
* <p>2 &lt;= B, C &lt;= 40000</p>
```text
1 <= A <= 10^9

2 <= B, C <= 40000
```
#### Input Format
```text
The first argument given is an integer A.

The second argument given is an integer B.

The third argument given is an integer C.
```
#### Output Format

<p>Return the <strong>A<sup>th</sup></strong> smallest 
magical number. Since the answer may be very large, 
return modulo <strong>10<sup>9</sup> + 7</strong>.</p>

```text
Return the A^th smallest magical number. Since the 
answer may be very large, return modulo 10^9 + 7.
```
#### Example Input
```text
Input 1:
 A = 1
 B = 2
 C = 3

Input 2:
 A = 4
 B = 2
 C = 3
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
    1st magical number is 2.

Explanation 2:
    First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
```
### Hints
* Hint 1
```text
Try to think by reading the below property:

Numbers divisible by B and C in a range of [1,M] is 
given by M/B + M/C - M/lcm(B,C)

The number of magical numbers less than or equal to x is 
a monotone increasing function in x, so we can 
binary search for the answer.
```
* Solution Approach
```text
Say L = lcm(B, C), the least common multiple of B and C, 
and let f(x) be the number of magical numbers less 
than or equal to x.

A well known result says that L = (B*C)/gcd(B,C), and that 
we can calculate the function gcd.

Then f(x) = x/B + x/C - x/L (floor of all the divisions)

Why? There are x/B numbers B, 2B, 3B…. that are 
divisible by B, there are x/C numbers divisible by C, 
and we need to subtract the x/L numbers divisible by B 
and C that we double-counted.

Finally,the answer must be between 0 and A * min(B,C).

If x increases f(x) increases, we can use 
binary search on x to find the Ath number.

Algorithm:

1) Low=1 and High = A * min(B,C)

2) Find mid = (low + high)/2

3) Find f(mid) let it be count

4) If count>=A then mark it as a answer and try
 to find smaller number which implies high = mid-1

5) Else low = mid+1

6) Repeat steps 2 to 5 until low<=high

Time Complexity: O(log (A * min(B, C)))
Space Complexity: O(1).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int gcd(int x, int y) {
        if (x == 0)
            return y;
        return gcd(y % x, x);
    }

    public int solve(int A, int B, int C) {
        // lcm of B and C
        long lcm = (long) B * C / gcd(B, C);
        long low = 2, high = ((long)A * Math.min(B, C)) , ans = 0;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            // f(x) = x / B + x / C - x / lcm(B, C)
            long cntB = mid / B, cntC = mid / C, cntBC = mid / lcm;
            if (cntB + cntC - cntBC >= A) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return (int)(ans % (1000 * 1000 * 1000 + 7));
    }
}
```
* * Solution in Javascript
```javascript
function gcd(a, b) {
    return b ? gcd(b, a % b) : a;
}
function solveit(A, B, C) {
    // lcm of B and C
    let ab = (B * C) / gcd(B, C);
    let l = 1,
    r = A * Math.min(B, C),
    m,
    ans;
    let mod = 1000000007;
    while (l <= r) {
        m = Math.floor((l + r) / 2);
        // f(x) = x / B + x / C - x / lcm(B, C)
        let temp = Math.floor(m / B) + Math.floor(m / C) - Math.floor(m / ab);
        if (temp >= A) {
            ans = m;
            r = m - 1;
        } else l = m + 1;
    }
    return ans % mod;
}
module.exports = {
    solve: function (A, B, C) {
        return solveit(A, B, C);
    },
};
```
* * Solution in C++
```cpp
int solveit(int A, int B, int C) {
    long long mod = 1000000007;
    long long ab, l, r, m, ans;
    // lcm of B and C
    ab = (1LL * B * C) / __gcd(B, C);
    l = 1;
    r = ((long long)A * min(B, C));
    while (l <= r) {
        m = (l + r) >> 1;
        // f(x) = x / B + x / C - x / lcm(B, C)
        long long temp = m / B + m / C - m / ab;
        if (temp >= A) {
            ans = m;
            r = m - 1;
        } else {
            l = m + 1;
        }
    }
    return (int)(ans % mod);
}

int Solution::solve(int A, int B, int C) {
    return solveit(A, B, C);
}
```

