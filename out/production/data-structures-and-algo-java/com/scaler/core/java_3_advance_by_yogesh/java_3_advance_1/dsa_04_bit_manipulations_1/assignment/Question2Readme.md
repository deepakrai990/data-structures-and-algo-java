### Q2. Single Number II
#### Problem Description
```text
Given an array of integers, every element appears 
thrice except for one, which occurs once.

Find that element that does not appear thrice.

NOTE: Your algorithm should have a linear 
runtime complexity.

Could you implement it without using extra memory?
```
#### Problem Constraints
* <p>2 &lt;= A &lt;= 5*10<sup>6</sup></p>
* <p>0 &lt;= A &lt;= INTMAX</p>
```text
2 <= A <= 5*10^6

0 <= A <= INTMAX
```
#### Input Format
```text
First and only argument of input contains an integer array A.
```
#### Output Format
```text
Return a single integer.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]

Input 2:
 A = [0, 0, 0, 1]
```
#### Example Output
```text
Output 1:
 4

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
 4 occurs exactly once in Input 1.
 1 occurs exactly once in Input 2.
```
### Hints
* Hint 1
```text
Let us look at every bit position.

Every number that occurs thrice will either 
contribute 3 ‘1’s or 3 ‘0’s to the position.

The number that occurs once X will contribute 
exactly one 0 or 1 to the position depending 
on whether it has 0 or 1 in that position.

So:
    * If X has 1 in that position, we will 
        have (3x+1) number of 1s in that position.
    * If X has 0 in that position, we will 
        have (3x+1) number of 0s in that position.

Can you think of a solution using the above observation?
```
* Solution Approach
```text
Having noticed that if X has 1 in that position, we 
will have a 3x+1 number of 1s in that position. If X 
has 0 in that position, we will have a 3x+1 number 
of 0 in that position.

A straightforward implementation is to use an array 
of size 32 to keep track of the total count of ith bit.

We can improve this based on the previous solution 
using three bitmask variables:

Ones as a bitmask to represent the ith bit had 
appeared once.

Twos as a bitmask to represent the ith bit had 
appeared twice.

Threes as a bitmask to represent the ith bit 
had appeared three times.

When the ith bit had appeared for the third time, clear 
the ith bit of both ones and twos to 0. The final answer will be the value of ones.
```
* Complete Solution
* * Solution in Java
```java
/** Approach 1: **/

public class Solution {
    public int singleNumber(final List < Integer > A) {
        int[] bits = new int[32];
        // check frequency of each bit
        for (int num: A) {
            for (int i = 0; i < 32; i++) {
                bits[i] += (1 & (num >> i));
                bits[i] %= 3;
            }
        }
        int number = 0;
        for (int i = 31; i >= 0; i--) {
            number = number * 2 + bits[i];
        }
        return number;
    }
}

/** Approach 2: **/

public class Solution {
    public int singleNumber(final List < Integer > A) {
        int ones = 0, twos = 0, threes = 0;
        for (int num : A) {
            // twos is a bitmask to represent the ith bit had appeared twice
            twos |= ones & num;
            // ones is a bitmask to represent the ith bit had appeared once
            ones ^= num;
            // threes is a bitmask to represent the ith bit had appeared three times
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    singleNumber: function (A) {
        let n = A.length;
        let ones = 0, twos = 0, threes = 0;
        for (let i = 0; i < n; i++) {
            // twos is a bitmask to represent the ith bit had appeared twice
            twos |= ones & A[i];
            // ones is a bitmask to represent the ith bit had appeared once
            ones ^= A[i];
            // threes is a bitmask to represent the ith bit had appeared three times
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    },
};
```
* * Solution in C++
```cpp
/** Approach 1: **/

int Solution::singleNumber(const vector<int> &A) {
    int n = A.size();
    int count[32] = {0};
    int result = 0;
    // check frequency of each bit
    for (int i = 0; i < 32; i++) {
        for (int j = 0; j < n; j++) {
            if ((A[j] >> i) & 1) {
                count[i]++;
            }
        }
        result |= ((count[i] % 3) << i);
    }
    return result;
}
/** Approach 2: **/

int Solution::singleNumber(const vector<int> &A) {
    int n = A.size();
    int ones = 0, twos = 0, threes = 0;
    for (int i = 0; i < n; i++) {
        // twos is a bitmask to represent the ith bit had appeared twice
        twos |= ones & A[i];
        // ones is a bitmask to represent the ith bit had appeared once
        ones ^= A[i];
        // threes is a bitmask to represent the ith bit had appeared three times
        threes = ones & twos;
        ones &= ~threes;
        twos &= ~threes;
    }
    return ones;
}
```

