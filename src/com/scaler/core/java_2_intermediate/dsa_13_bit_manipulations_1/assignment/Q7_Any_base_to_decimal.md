### Q7. Any base to decimal
#### Problem Description
```text
You are given a number A. You are also given a base B. A is a 
number on base B.

You are required to convert the number A into its corresponding 
value in decimal number system.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    0 &lt;= A &lt;= 10<sup>9</sup> <br>
    2 &lt;= B &lt;= 9
</div>

```text
0 <= A <= 10^9
2 <= B <= 9
```
#### Input Format
```text
First argument A is an integer.
Second argument B is an integer.
```
#### Output Format
```text
Return an integer.
```
#### Example Input
```text
Input 1:
 A = 1010
 B = 2

Input 2:
 A = 22 
 B = 3
```
#### Example Output
```text
Output 1:
 10
Output 2:
 8
```
#### Example Explanation
```text
For Input 1:
    The decimal 10 in base 2 is 1010.

For Input 2:
    The decimal 8 in base 3 is 22.
```
### Hints
* Hint 1
```text
Can we extract each digit from A and multiply it with some 
powers of B to get our final result ?
```
* Solution Approach
```text
We extract 1 digit from the end of the number A and 
multiply it with the respective power of the given base 
B and finally add it to the answer. This process continues 
until the number A becomes 0, i.e. all the digits of A have 
been extracted.

Time Complexity : O(logA)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, int B) {
        int res = 0, multiplier = 1;
        while (A > 0) {
            int digit = A % 10;
            res += multiplier * digit;
            multiplier *= B;
            A /= 10;
        }
        return res;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::solve(int A, int B) {
    int res = 0, multiplier = 1;
	while(A > 0){
		int digit = A % 10;
		res += multiplier * digit;
		A /= 10;
		multiplier *= B;
	}
	return res;
}
```

