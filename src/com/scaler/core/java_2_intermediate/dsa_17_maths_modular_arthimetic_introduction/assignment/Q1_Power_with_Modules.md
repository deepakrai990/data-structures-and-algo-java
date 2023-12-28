### Q1. Power with Modules
#### Problem Description
```text
You are given A, B and C .
Calculate the value of (A ^ B) % C
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= A &lt;= 10<sup>9</sup><br>
    0 &lt;= B &lt;= 10<sup>5</sup><br>
    1 &lt;= C &lt;= 10<sup>9</sup>
</div>

```text
1 <= A <= 10^9
0 <= B <= 10^5
1 <= C <= 10^9
```
#### Input Format
```text
Given three integers A, B and C.
```
#### Output Format
```text
Return an integer.
```
#### Example Input
```text
Input 1:
 A = 2
 B = 3
 C = 3

Input 2:
 A = 5
 B = 2
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
For Input 1:
    (2 ^ 3) % 3 = 8 % 3 = 2

For Input 2:
    (5 ^ 2) % 4 = 25 % 4 = 1
```
### Hints
* Hint 1
```text
You can just simulate the entire process.
Keep a watch on integer overflow
```
* Solution Approach
```text
We will have to find the value of (A ^ B) % C.

We initialize our result with 1 and then traverse a loop B times 
and multiply A to our result everytime.

We keep doing modulo C in every step to prevent overflow.

Time Complexity : O(B)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, int B, int C) {
        long res = 1;
        for(int i = 1 ; i <= B ; i++){
            res = (res * A) % C;
        }
        return (int)res;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::solve(int A, int B, int C) {
    long long res = 1;
	for(int i = 1 ; i <= B ; i++){
		res = (res * A) % C;
	}
	return (int)res;
}
```

