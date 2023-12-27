### Q1. Strange Equality
#### Problem Description
```text
Given an integer A.
Two numbers, X and Y, are defined as follows:

    * X is the greatest number smaller than A such that 
        the XOR sum of X and A is the same as the 
        sum of X and A.
    * Y is the smallest number greater than A, such that 
        the XOR sum of Y and A is the same as the 
        sum of Y and A.

Find and return the XOR of X and Y.

NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is 
    the BITWISE XOR operator.

NOTE 2: Your code will be run against a maximum 
    of 100000 Test Cases.
```
#### Problem Constraints
* <p>1 &lt;= A &lt;= 10<sup>9</sup></p>
```text
1 <= A <= 10^9
```
#### Input Format
```text
First and only argument is an integer A.
```
#### Output Format
```text
Return an integer denoting the XOR of X and Y.
```
#### Example Input
```text
A = 5
```
#### Example Output
```text
10
```
#### Example Explanation
```text
The value of X will be 2 and the value of Y will be 8. The 
XOR of 2 and 8 is 10.
```
### Hints
* Hint 1
```text
A + B = (A ^ B) + 2 * (A & B)
where ^ is the bitwise xor operator and & is the bitwise and operator.
```
* Solution Approach
```text
Following the above equation, if xor sum and the sum of 2 numbers 
are equal, their bitwise AND should be zero.

Given a number N, how to find a number whose bitwise 
AND with N is 0?

Keeping in mind the truth table of AND, 1 & 1 = 1 
while 1 & 0 = 0, 0 & 1 = 0 and 0 & 0 = 0.

Therefore, in the number X such that X & N is 0, all the set 
bits of number N must be unset in the number X since 1 & 0 = 0.

The unset bits of N can have any orientation in X, that is, 
they can either be 0 or be 1.

So to find the smallest number greater than N, the answer is 
the next power of 2 greater than N. Think why!!

And to find the greatest number smaller than N, set all the 
unset bits of N to 1.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
        int bit = 0, x = 0;
        // x is equal to the summation of unset bits in A
        while (A != 0) {
            if (A % 2 == 0) {
                x = x | (1 << bit);
            }
            A /= 2;
            bit++;
        }
        // y equals the power of 2 just greater than A
        int y = (1 << bit);
        return x ^ y;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
  solve: function (A) {
    let bit = Math.floor(Math.log2(A)) + 1;
    let x = 0;
    // x is equal to the summation of unset bits in A
    for (let i = 0; i < bit; i++) {
      if (A & (1 << i)) continue;
      x += 1 << i;
    }
    // y equals the power of 2 just greater than A
    let y = 1 << bit;
    let ans = x ^ y;
    return ans;
  },
};
```
* * Solution in C++
```cpp
int Solution::solve(int A) {
    int bit = (int) log2(A) + 1;
    int x = 0;
    // x is equal to the summation of unset bits in A
    for (int i = 0; i < bit; i++) {
        if (A & (1 << i)) 
            continue;
        x += (1 << i);
    }
    // y equals the power of 2 just greater than A
    int y = (1 << bit);
    int ans = (x ^ y);
    return ans;
}
```

