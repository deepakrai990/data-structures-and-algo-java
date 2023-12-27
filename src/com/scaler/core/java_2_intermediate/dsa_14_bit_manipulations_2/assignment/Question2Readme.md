### Q2. Number of 1 Bits
#### Problem Description
```text
Write a function that takes an integer and returns the 
number of 1 bits it has.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= A &lt;= 10<sup>9</sup>
</div>

```text
1 <= A <= 10^9
```
#### Input Format
```text
First and only argument contains integer A
```
#### Output Format
```text
Return an integer as the answer
```
#### Example Input
```text
Input 1:
 11

Input 2:
 6
```
#### Example Output
```text
Output 1:
 3

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
    11 is represented as 1011 in binary.

Explanation 2:
    6 is represented as 110 in binary.
```
### Hints
* Hint 1
```text
A bruteforce solution will be to convert number into base 2 and 
count number of ones.

Can you think of something better tho? Maybe a solution which 
runs in O(number_of_ones) at-least. It’s really similar to the 
trick used to check if a number is a power of 2 in O(1) approx.
```
* Solution Approach
```text
Bruteforce:

Iterate 32 times, each time determining if the ith bit is a ’1′ or not.

This is probably the easiest solution, and the interviewer would 
probably not be too happy about it.

This solution is also machine dependent (You need to be sure that 
an unsigned integer is 32-bit).

In addition, this solution is not very efficient too because you 
need to iterate 32 times no matter what.

A better solution:

This special solution uses a trick which is normally used 
in bit manipulations.

Notice what x - 1 does to bit representation of x.

x - 1 would find the first set bit from the end, and then set 
it to 0, and set all the bits following it.

Which means if x = 10101001010100
                              ^
                              |
                              |
                              |

                       First set bit from the end

Then x - 1 becomes 10101001010(011)

All other bits in x - 1 remain unaffected.

This means that if we do (x & (x - 1)), it would just unset the 
last set bit in x (which is why x&(x-1) is 0 for powers of 2).

Can you use the above fact to come up with a solution ?
```
* Complete Solution
* * Solution in Java
```java
/** Method 1: **/

public class Solution {
    public int numSetBits(long A) {
        int total_ones = 0;
        while (A != 0) {
            // rightmost set bit becomes unset
            A = A & (A - 1);
            total_ones++;
        }
        return total_ones;
    }
}

/** Method 2: **/

public class Solution {
    public int numSetBits(long A) {
        int total_ones = 0;
        for (int i = 0; i < 30; i++) {
            if ((A & (1 << i)) > 0) {
                total_ones += 1;
            }
        }
        return total_ones;
    }
}
```
* * Solution in Javascript
```javascript
/** Method 1: **/

module.exports = {
    //param A : integer
    //return an integer
    numSetBits: function (A) {
        let ans = 0;
        while (A != 0) {
            // rightmost set bit becomes unset
            A = (A & (A - 1));
            ans++;
        }
        return ans;
    }
};

/** Method 2: **/

module.exports = {
    //param A : integer
    //return an integer
    numSetBits: function (A) {
        let total_ones = 0;
        for (let i = 0; i < 30; i++) {
            if ((A & (1 << i)) > 0) {
                total_ones += 1;
            }
        }
        return total_ones;
    }
};
```
* * Solution in C++
```cpp
/** Method 1: **/

int Solution::numSetBits(int A) {
    int total_ones = 0;
    while (A != 0) {
        // rightmost set bit becomes unset
        A = A & (A - 1);
        total_ones++;
    }
    return total_ones;
}

/** Method 2: **/

int Solution::numSetBits(int A) {
    int total_ones = 0;
    for(int i = 0; i < 30; i++){
        if((A & (1 << i)) > 0){
            total_ones += 1;
        }
    }
    return total_ones;
}
```

