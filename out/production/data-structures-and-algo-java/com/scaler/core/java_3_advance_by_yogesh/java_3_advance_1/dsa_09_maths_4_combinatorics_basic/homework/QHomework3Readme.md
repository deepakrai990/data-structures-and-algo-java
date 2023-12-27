### Q3. Consecutive Numbers Sum
#### Problem Description
```text
Given a positive integer A.

Return the number of ways it can be written as a sum of 
consecutive positive integers.
```
#### Problem Constraints
* <p>1 &lt;= A &lt;= 10<sup>9</sup></p>
```text
1 <= A <= 10^9
```
#### Input Format
```text
The first and the only argument of input contains an integer, A.
```
#### Output Format
```text
Return an integer, representing the answer as described 
in the problem statement.
```
#### Example Input
```text
Input 1:
 A = 5

Input 2:
 A = 15
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
     The 2 ways are:
     => [5]
     => [2, 3]

Explanation 2:
     The 4 ways are:
     => [15]
     => [7, 8]
     => [4, 5, 6] 
     => [1, 2, 3, 4, 5]
```
### Hints
* Hint 1
```text
We can model the situation by the equation 
A = (x+1) + (x+2) + … + (x+k). Here, x >= 0, k >= 1.

Using the identity 1 + 2 + … + k = k(k+1)/2, we can simplify 
this equation to 2 * A = k(2 * x + k + 1).

From here, clearly 1 <= k <= 2 * A. We can try every 
such k. We need x = ((2 * A/k) - k - 1)/2 to be a 
non-negative integer for a solution to existing 
for the k we are trying.
```
* Solution Approach
```text
As in the hint, 2 * A = k(2 * x + k + 1) with x >= 0, k >= 1.

Call k the first factor, and 2 * x + k + 1 the second factor. 
We are looking for ways to solve this equation without 
trying all 2 * A possibilities.

Now notice that the parity of k and (2 * x + k + 1) are 
different. That is, if k is even, then the other quantity 
is odd, and vice versa.

Also, 2 * x + k + 1 >= k + 1 > k, so the second 
factor must be bigger.

Now write 2*A = 2y * M, where M is odd. If we 
factor M = a * b, then two candidate solutions are:

1. k = a, 2x+k+1 = b * 2y

2. k = a * 2y, 2x+k+1 = b

However, only one of these solutions will have the 
second factor larger than the first. (Because y >= 1, we 
are guaranteed that one factor is strictly larger.)

Thus, the answer is the number of ways to factor 
the odd part of A.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
        int ans = 0;
        long n = 1;
        while(n * (n + 1) <= 2 * A) {
            // check if the difference between A and sum of n consecutive numbers is a multiple of n    
            long sum = n * (n + 1) / 2;
            if((A - sum) % n == 0) ans++;
            n++;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
	solve : function(A){
        let maxx = Math.floor(Math.sqrt(2 * A));
        let cnt = 0;
        for (let k = 1; k <= maxx; ++k) {
            // check if the difference between A and sum of k consecutive numbers is a multiple of k
            let term = A - (k * (k - 1) / 2);
            if (term % k == 0) {
                ++cnt;
            }
        }
        return cnt;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(int A) {
    while((A & 1) == 0) A >>= 1;
    int ans = 1, d = 3;
    // find the number of odd factors
    while(d * d <= A){
        int e = 0;
        while(A % d == 0){
            A /= d;
            e++;
        }
        ans *= e + 1;
        d += 2;
    }
    if(A > 1)
        ans <<= 1;
    return ans;
}
```

