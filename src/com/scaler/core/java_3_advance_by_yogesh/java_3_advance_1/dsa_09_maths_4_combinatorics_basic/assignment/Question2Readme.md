### Q2. Compute nCr % p
#### Problem Description
```text
Given three integers A, B, and C, where A represents n, 
B represents r, and C represents p and p is a prime 
number greater than equal to n, find and return the 
value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

NOTE: For this problem, we are considering 1 as a prime.
```
#### Problem Constraints

<ul>
<li>1 &lt;= A &lt;= 10<sup>6</sup></li>
<li>1 &lt;= B &lt;= A</li>
<li>A &lt;= C &lt;= 10<sup>9</sup>+7</li>
</ul>

```text
1 <= A <= 10^6
1 <= B <= A
A <= C <= 10^9+7
```
#### Input Format
```text
The first argument given is the integer A ( = n).
The second argument given is the integer B ( = r).
The third argument given is the integer C ( = p).
```
#### Output Format
```text
Return the value of nCr % p.
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
    nCr( n=5 and r=2) = 10.
    p=13. Therefore, nCr%p = 10.
```
### Hints
* Hint 1
```text
We can preprocess the factorials modulo p.

Then think of how you can calculate (A / B)% C.
```
* Solution Approach
```text
This problem can be solved using Fermat’s Little theorem.

a^p = a (mod p) where p is a prime number.

a^(p-1) = 1 (mod p)

Multiply by an inverse on both sides

a^(p-2) = a^(-1) (mod p).
Using the above result, nCr can be calculated 
as 
( fact[n]%p ) * inverseModulo( fact[n-r] %p ) * inverseModulo( fact[r] %p ).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, int B, int C) {
        if(C == 1)
            return 0;
        if(A == 1)
            return 1;
        long mx = Math.max(A - B, B);
        long mn = Math.min(A - B, B);
        long denominator = 1, numerator = 1;
        // nCr = (n * (n - 1) * ... * (n - r + 1)) * inverse(fact[r])
        // nCr = (n * (n - 1) * ... * (r + 1)) * inverse(fact[n - r])
        for(long n = mx + 1; n < A + 1; n++) {   
            numerator = (numerator * n) % C;
        }
        for(int d = 2 ; d < mn + 1; d++) {
            denominator = (denominator * d) % C;
        }
        return (int)((numerator * pow(denominator, C - 2, C)) % C);
    }
    
    public long pow(long x, int y, int k) {
        long result = 1;
        while(y > 0) {
            if(y % 2 == 1) {
                result = (result * x) % k;
                y--;
            }
            y >>= 1;
            x = (x * x) % k;
        }
        return result;
    }
}
```
* * Solution in Javascript
```javascript
const maxn = 1000010;
let MOD = 1e9 + 7;

let fact = new Array(maxn).fill(0);

function mult(a, b) {
    let val = a * b;
    if (val <= Number.MAX_SAFE_INTEGER && val >= Number.MIN_SAFE_INTEGER)
        return val % MOD;
    return Number((BigInt(a) * BigInt(b)) % BigInt(MOD));
}

function pw(a, b, m) {
    let res = 1;
    while (b > 0) {
        if (b & 1) 
            res = mult(res, a);
        a = mult(a, a);
        b >>= 1;
    }
    return res;
}

function precompute(A) {
    fact[0] = 1;
    for (let i = 1; i <= A; i++) 
        fact[i] = mult(i, fact[i - 1]);
}

function inverse(val) {
    return pw(val, MOD - 2, MOD);
}

function ncr(n, r) {
    if (r > n) 
        return 0;
    // nCr = fact[n] * inverse(fact[n - r]) * inverse(fact[r])
    return mult(fact[n], mult(inverse(fact[n - r]), inverse(fact[r])));
}

module.exports = {
    solve: function (A, B, C) {
        MOD = C;
        precompute(A);
        return ncr(A, B);
    },
};
```
* * Solution in C++
```cpp
long long binpow(long long a, long long b, long long m) {
    // calculates the value of (a ^ b) % m
    a %= m;
    long long res = 1;
    while (b > 0) {
        if (b & 1)
            res = res * a % m;
        a = a * a % m;
        b >>= 1;
    }
    return res;
}

long long fact[1000005];

int Solution::solve(int A, int B, int C) {
    fact[0] = 1;
    for(long long i = 1; i <= A; ++i) {
        fact[i] = (fact[i - 1] * i) % C;
    }
    // nCr = fact[n] * inverse(fact[n - r]) * inverse(fact[r])
    long long ans = fact[A];
    ans = (ans * binpow(fact[B], C - 2, C)) % C;
    ans = (ans * binpow(fact[A-B], C - 2, C)) % C;
    return ans;
}
```

