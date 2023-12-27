### Q3. Greatest Common Divisor
#### Problem Description
```text
Given 2 non-negative integers A and B, find gcd(A, B)

GCD of 2 integers A and B is defined as the greatest integer 'g' such that 'g' is a divisor of both A and B. Both A and B fit in a 32 bit signed integer.

Note: DO NOT USE LIBRARY FUNCTIONS.
```
#### Problem Constraints
```text
0 <= A, B <= 109
```
#### Input Format
```text
First argument is an integer A.
Second argument is an integer B.
```
#### Output Format
```text
Return an integer denoting the gcd(A, B).
```
#### Example Input
```text
Input 1:
A = 4
B = 6

Input 2:
A = 6
B = 7
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

 2 divides both 4 and 6


Explanation 2:

 1 divides both 6 and 7
```
### Hints
* Hint 1
```text
Let’s say g is gcd(m, n) and m > n.

m = g * m1
n = g * m2

m - n = g * (m1 - m2)

gcd (m, n) = gcd(m-n, n)

Can you use the above fact to find the gcd?
```
* Solution Approach
```text
Let's say g is gcd(m, n) and m > n.

m = g * m1
n = g * m2

m - n = g * (m1 - m2)

gcd (m, n) = gcd(m-n, n)

           = gcd(m - 2n, n) if m >= 2n
           = gcd(m - 3n, n) if m >= 3n 
             .
             .
             .
           = gcd(m - k*n, n) if m >= k*n

       In other words, we keep subtracting n till the result is greater than 0. Ultimately we will end up with m % n.

              So gcd(m, n)  = gcd(m % n, n) 
```
* Complete Solution
```java
public class Solution {
    public int gcd(int A, int B) {
        if (A == 0)
            return B;
        return gcd(B % A, A);
    }
}
```

```javascript
module.exports = { 
	gcd : function gcd(a, b){
	    if(b == 0)
	        return a;
	    return gcd(b, a % b);
	}
};
```

```cpp
int Solution::gcd(int A, int B) {
    if (A < B)
        swap(A, B);
    if (B == 0)
        return A;
    return gcd(A % B, B);
}
```



