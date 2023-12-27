### Q3. Divide Integers
#### Problem Description
```text
Divide two integers without using multiplication, division and mod operator.

Return the floor of the result of the division.

Also, consider if there can be overflow cases i.e output is greater than INT_MAX, 
return INT_MAX.

NOTE: INT_MAX = 2^31 - 1
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>-2<sup>31</sup> &lt;= A, B &lt;= 2<sup>31</sup>-1</p>
    <p>B != 0</p>
</div>

```text
-2^31 <= A, B <= 2^31-1

B != 0
```
#### Input Format
```text
The first argument is an integer A denoting the dividend.
The second argument is an integer B denoting the divisor.
```
#### Output Format
```text
Return an integer denoting the floor value of the division.
```
#### Example Input
```text
Input 1:
 A = 5
 B = 2

Input 2:
 A = 7
 B = 1
```
#### Example Output
```text
Output 1:
 2

Output 2:
 7
```
#### Example Explanation
```text
Explanation 1:
    floor(5/2) = 2
```
### Hints
* Hint 1
```text
dividend = answer * divisor + c

It would be best to find the answer here without using any of the operators 
mentioned in the question. Think about the binary expansion of the answer.

We can work with bits without using the standard operators. You will be done 
if you can find what bits are set in the answer.
```
* Solution Approach
```text
Think in terms of bits.

How do you divide with bits?

How do you determine the most significant bit in the answer?
Iterate on the bit position ‘i’ from 31 to 1 and find the first bit for which 
divisor « i is less than the dividend.

How do you use (1) to move forward similarly?
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int divide(int A, int B) {
        long n = A, m = B;
        // determine sign of the quotient
        int sign = 1;
        if ((n < 0 && m >= 0) || (n >= 0 && m < 0))
            sign = -1;
        // remove sign of operands
        n = Math.abs(n);
        m = Math.abs(m);
        // q stores the quotient in computation
        long q = 0, t = 0;
        // test down from the highest bit
        // accumulate the tentative value for valid bits
        for (int i = 31; i >= 0; i--) {
            if (t + (m << i) <= n) {
                t += m << i;
                q |= (long) 1 << i;
            }
        }
        // assign back the sign
        if (sign < 0)
            q = -q;
        // check for overflow and return
        if (q > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int) q;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : integer
 //param B : integer
 //return an integer
	divide : function(A, B){
        let n = A, m = B;
        let MAX = 2147483647, MIN = -2147483648;
        // determine sign of the quotient
        let sign = (n < 0 && m >= 0) || (n >= 0 && m < 0) ? -1 : 1;
        // remove sign of operands
        n = Math.abs(n), m = Math.abs(m);
        // q stores the quotient in computation
        let q = 0;
        // test down from the highest bit
        // accumulate the tentative value for valid bits
        let mask = 1;
        for(let i = 1; i <= 31; i++){
            mask *= 2;
        }
        for (let t = 0, i = 31; i >= 0; i--){
            if (t + m * mask <= n){
                t += m * mask, q += mask;
            }
            mask /= 2
        }
        // assign back the sign
        if (sign < 0){
            q = -q;
        }
        // check for overflow and return
        return q >= MAX || q < MIN ? MAX : q;
	}
};
```
* * Solution in C++
```cpp
// Corner case : INT_MIN, -1
int Solution::divide(int A, int B) {
    long long n = A, m = B;
    // determine sign of the quotient
    int sign = n < 0 ^ m < 0 ? -1 : 1;
    // remove sign of operands
    n = abs(n), m = abs(m);
    // q stores the quotient in computation
    long long q = 0;
    // test down from the highest bit
    // accumulate the tentative value for valid bits
    for (long long t = 0, i = 31; i >= 0; i--)
        if (t + (m << i) <= n)
            t += m << i, q |= 1LL << i;
    // assign back the sign
    if (sign < 0) q = -q;
    // check for overflow and return
    return q >= INT_MAX || q < INT_MIN ? INT_MAX : q;
}
```

