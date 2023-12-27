### Q2. Number of Digit One
#### Problem Description
```text
Given an integer A, find and return the total number of 
digit 1 appearing in all non-negative integers less 
than or equal to A.
```
#### Problem Constraints
* <p>0 &lt;= A &lt;= 10<sup>9</sup></p>
```text
0 <= A <= 10^9
```
#### Input Format
```text
The only argument given is the integer A.
```
#### Output Format
```text
Return the total number of digit 1 appearing in 
all non-negative integers less than or equal to A.
```
#### Example Input
```text
Input 1:
 A = 10

Input 2:
 A = 11
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
 Digit 1 appears in 1 and 10 only and appears 
 one time in each. So the answer is 2.

Explanation 2:
 Digit 1 appears in 1(1 time) , 10(1 time) 
 and 11(2 times) only. So the answer is 4.
```
### Hints
* Hint 1
```text
A simple solution is to traverse from 1 to A and 
count the number of 1 appearing in each digit.
```
* Solution Approach
```text
The brute force solution of traversing all numbers 
from 1 to A and counting the number of 1s in each 
number will not pass with the given constraints.

Try to approach the problem in a different way.

Let’s just figure out the number of 1s at one’s place, 
a number of 1s in second place, and so on. We will 
add all these occurrences of 1s.

At one’s place:
up to 10, there is 1 one.
up to 20, there are 2 one’s.
.
.
up to 131, there are 14 one’s
up to 13x(x>1), there are 14 one’s.

Number of 1’s at one’s position = (n/10) + (n%10!=0)

Try to find the formula for ten’s place, hundred’s 
place, and so on.

Solution can be summarised into 4 steps:
    1) Initialize ans = 0
    2) Iterate over i from 1 to n incrementing by 10 
        times in each iteration.
    3) Add (n / (i * 10 ) ) * i to ans after each (i * 10) interval.
    4) Add min( max((n mod (i * 10) – i + 1, 0), i) to ans.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
        int ans = 0;
        for (int i = 1; i <= A; i *= 10) {
            int divider = i * 10;
            // finding the number of 1's in each place
            ans += (A / divider) * i + Math.min(Math.max(A % divider - i + 1, 0), i);
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : integer
 //return an integer
	solve : function(A){
    let ans = 0;
        for (let i = 1; i <= A; i *= 10) {
            let divider = i * 10;
            // finding the number of 1's in each place
            ans += Math.floor(A / divider) * i + Math.min(Math.max(A % divider - i + 1, 0), i);
        }
        return ans;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(int A) {
    int ans = 0;
    for (int i = 1; i <= A; i *= 10) {
        int divider = i * 10;
        // finding the number of 1's in each place
        ans += (A / divider) * i + min(max(A % divider - i + 1, 0), i);
    }
    return ans;
}
```

