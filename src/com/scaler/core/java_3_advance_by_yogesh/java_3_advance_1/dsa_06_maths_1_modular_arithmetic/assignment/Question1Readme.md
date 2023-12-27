### Q1. Prime Modulo Inverse
#### Problem Description
```text
Given two integers A and B. Find the value of A-1 mod B where B is a 
prime number and gcd(A, B) = 1.

A-1 mod B is also known as modular multiplicative inverse of A under 
modulo B.
```
#### Problem Constraints
```text
1 <= A <= 109
1<= B <= 109
B is a prime number
```
#### Input Format
```text
First argument is an integer A.
Second argument is an integer B.
```
#### Output Format
```text
Return an integer denoting the modulor inverse
```
#### Example Input
```text
Input 1:
 A = 3
 B = 5
 
Input 2:
 A = 6
 B = 23
```
#### Example Output
```text
Output 1:
 2
 
Output 2:
 4
```
#### Example Explanation
```text
Explanation 1:
 Let's say A-1 mod B = X, then (A * X) % B = 1.
 3 * 2 = 6, 6 % 5 = 1.

Explanation 2:
 Similarly, (6 * 4) % 23 = 1.
```
### Hints
* Hint 1
```text
According to Fermats’s little theorem:
```

<div>
<pre>A<sup>B-1</sup> ≡ 1 (mod B) where B is prime and A is not a 
multiple of B.</pre>
</div>

```text
Can we use the above relation to find the modular inverse?
```
* Solution Approach
```text
Fermats’s little theorem:
```
<div>
<pre>A<sup>B-1</sup> ≡ 1 (mod B) where B is prime and A is not a 
multiple of B.</pre>
</div> 

```text
Multiply by A-1 on both sides, We get
```

<div>
<pre>A<sup>B-2</sup> ≡ A<sup>-1</sup> (mod B) where B is prime 
and A is not a multiple of B.</pre>
</div>

```text
We just have to calculate AB-2 (mod B). This will be the modular multiplicative inverse of A under modulo B.
```

* Complete Solution
```java
public class Solution {
    long power(long x, long y, long p) { 
        long res = 1;        // Initialize result 
        x = x % p;        // Update x if it is more than or equal to p 
        while (y > 0) { 
            // If y is odd, multiply x with result 
            if ((y & 1) == (long)1) 
                res = (res*x) % p; 
            y = y >> 1; 
            x = (x * x) % p; 
        }
        return res; 
    }
    
    public int solve(int A, int B) {
        // Modular inverse of A Modulo B = pow(A, B - 2, B)
        return (int)power(A, B - 2, B);
    }
}
```

```javascript
let MOD;
function mult(a, b) {
    let val = a * b;
    if (val <= Number.MAX_SAFE_INTEGER && val >= Number.MIN_SAFE_INTEGER)
        return val % MOD;
    return Number((BigInt(a) * BigInt(b)) % BigInt(MOD));
}

function pw(a, b, m) {
    let res = 1;    // Initialize result 
    while (b > 0) {
        // If b is odd, multiply a with result 
        if (b & 1) res = mult(res, a);
        a = mult(a, a);
        b >>= 1;
    }
    return res;
}

module.exports = {
    solve: function (A, B) {
        MOD = B;
        // Modular inverse of A Modulo B = pw(A, B - 2, B)
        return pw(A, B - 2, B);
    },
};
```

```cpp
long long power(long long x, long long y, long long p) { 
    long long res = 1;      // Initialize result 
    x = x % p;          // Update x if it is more than or equal to p 
    while (y > 0) { 
        // If y is odd, multiply x with result 
        if (y & 1) 
            res = (res * x) % p; 
   
        y = y >> 1; 
        x = (x * x) % p; 
    } 
    return res; 
} 

int Solution::solve(int A, int B) {
    // Modular inverse of A Modulo B = pow(A, B - 2, B)
    return power(A, B - 2, B);
}
```

