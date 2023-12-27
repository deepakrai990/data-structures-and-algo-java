### Q4. Very Large Power
#### Problem Description
```text
Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).

"^" means power,

"%" means "mod", and

"!" means factorial.
```
#### Problem Constraints
```text
1 <= A, B <= 5e5
```
#### Input Format
```text
First argument is the integer A

Second argument is the integer B
```
#### Output Format
```text
Return one integer, the answer to the problem
```
#### Example Input
```text
Input 1:
 A = 1
 B = 1

Input 2:
 A = 2
 B = 2
```
#### Example Output
```text
Output 1:
 1

Output 2:
 4
```
#### Example Explanation
```text
Explanation 1:
    1! = 1. Hence 1^1 = 1.

Explanation 2:
    2! = 2. Hence 2^2 = 4.
```
### Hints
* Hint 1
```text
You can calculate A ^ B by using the divide and conquer technique 
or by recursion.

It requires knowledge of some advanced mathematics concepts 
to find (A ^ (B!)) % P.

Have you noticed that (1e9 + 7) is prime?
```
* Solution Approach
```text
This problem is very simple if you know Fermat’s Little Theorem.

The basic approach to solve this problem is to find factorial 
of B by taking mod with (P-1), where P is a prime. In this 
problem, 10007 is also a prime.

After calculating the factorial of B, you can calculate A ^ B! by 
simply taking mod with P.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    int fast_power(long A, long B, long mod) {
        long ans = 1;
        while(B > 0) {
            if((B & 1) == 1) {
                ans = (ans * A) % mod;
            }
            A = (A % mod * A % mod) % mod;
            B = B >> 1;
        }
        return (int)(ans % mod);
    }
    
    public int solve(int A, int B) {
        long fact = 1;
        long mod = (long)(1e9 + 7);
        // calculating factorial of B
        for(long i = 2; i <= B; i += 1) {
            fact = (fact * i) % (mod - 1);      // (mod-1) is used accoring to Fermat Little theorem.
        }
        int ans = fast_power(A, fact, mod);     // calculating power by divide and conquer
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
  solve: function (A, B) {
    let ans = 1;
    const MOD = 1000000007;

    function mult(a, b){
      a = BigInt(a);
      b = BigInt(b);
      m = BigInt(MOD);
      return Number((a * b) % m);
    }

    function pw(a, b, m) {
      if (b == 0) return 1;
      if (b % 2 == 1) return mult(a, pw(a, b - 1, m));
      return pw(mult(a, a), b / 2, m);
    }
    
    // calculating factorial of B
    for (let i = 1; i <= +B; i++) {
      ans *= i;
      ans = ans % (MOD - 1);    // (MOD-1) is used accoring to Fermat Little theorem.
    }
    return pw(+A, ans, MOD);    // calculating power by divide and conquer
  },
};
```
* * Solution in C++
```cpp
// a^b %mod using binary exponentiation
int fast_power(long long A, long long B, long long mod) {
    long long ans = 1;
    while(B > 0) {
        if(B & 1) {
            ans = (ans * A) % mod;
        }
        A = (A % mod * A % mod) % mod;
        B = B >> 1;
    }
    return ans % mod;
}

int Solution::solve(int A, int B) {
    long long fact = 1;
    long long mod = (1e9 + 7);
    // calculating factorial of B
    for(long long i = 2; i <= B; i += 1) {
        fact = (fact * i) % (mod - 1);      // (mod-1) is used accoring to Fermat Little theorem.
    }
    int ans = fast_power(A, fact, mod);     // calculating power by divide and conquer
    return ans;
}
```

