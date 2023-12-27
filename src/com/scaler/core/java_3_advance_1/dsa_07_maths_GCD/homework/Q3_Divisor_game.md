### Q3. Divisor game
#### Problem Description
```text
Scooby has 3 three integers A, B, and C.

Scooby calls a positive integer special if it is divisible by B and 
it is divisible by C. You need to tell the number of special integers 
less than or equal to A.
```
#### Problem Constraints
* <p>1 &lt;= A, B, C &lt;= 10<sup>9</sup></p>
```text
1 <= A, B, C <= 10^9
```
#### Input Format
```text
First argument is a positive integer A
Second argument is a positive integer B
Third argument is a positive integer C
```
#### Output Format
```text
One integer corresponding to the number of special integers less than or 
equal to A.
```
#### Example Input
```text
Input 1:
 A = 12
 B = 3
 C = 2
 
Input 2:
 A = 6
 B = 1
 C = 4
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

 The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.

Explanation 2:

 Only 4 is a positive integer less than equal to 6 which is divisible by 1 and 4.
```
### Hints
* Hint 1
```text
Run a loop from 1 to A and check if that number is divisible by B and C. 
If it does increase the count.

Can we loop to a large number up to 10^9?
```
* Solution Approach
```text
We can’t loop, so we can try for another approach, i.e., find 
the lcm(least common multiple) of B and C and find the number of
elements less than equal to A, which is divisible by lcm.
lcm(A,B)=(A*B)/(gcd(A,B))
```
* Complete Solution
```java
public class Solution {
    public int gcd(int x, int y) {
        if (x == 0)
            return y;
        return gcd(y % x, x);
    }
    public int solve(int A, int B, int C) {
        // find lcm of B and C
        long lcm = (long) B * C / gcd(B, C);
        if (lcm > A)
            return 0;
        // no of multiples of lcm that is <= A
        return (int)(A / lcm);
    }
}
```

```javascript
function gcd(a, b) {
  return b ? gcd(b, a % b) : a;
}

function lcm(a, b) {
  return (a / gcd(a, b)) * b;
}

module.exports = {
    solve: function (A, B, C) {
        // no of multiples of lcm(B, C) that is <= A
        return Math.floor(A / lcm(B, C));
    },
};
```

```cpp
int Solution::solve(int A, int B, int C) {
    // find lcm of B and C
    long long lcm = (C * B) / __gcd(C, B);
    if (lcm > A)
        return 0;
    // no of multiples of lcm that is <= A
    int ans = A / lcm;
    return ans;
}
```

