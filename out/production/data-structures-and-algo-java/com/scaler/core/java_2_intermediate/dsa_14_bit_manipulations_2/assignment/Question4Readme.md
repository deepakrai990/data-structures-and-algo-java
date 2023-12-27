### Q4. Set Bit
#### Problem Description
```text
You are given two integers A and B.
Set the A-th bit and B-th bit in 0, and return output in decimal.
```
#### Problem Constraints
```text
0 <= A <= 30
0 <= B <= 30
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
 A = 3
 B = 5

Input 2:
 A = 4
 B = 4
```
#### Example Output
```text
Output 1:
 40

Output 2:
 16
```
#### Example Explanation
```text
For Input 1:
    The binary expression is 101000 which is 40 in decimal.

For Input 2:
    The binary expression is 10000 which is 16 in decimal
```
### Hints
* Hint 1
```text
The value of the i-th bit is 2^i
```
* Solution Approach
```text
The value of the A-th bit is 2^A and that
of the B-th bit is 2^B.

We have to set the A-th bit and the B-th bit
in 0. This is similar to directly adding 2^A 
and 2^B to 0. 

If A = B, then we can just add 2^A to 0.

Time Complexity : O(1)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, int B) {
        int num = (1 << A);
        if(A != B){
            num += (1 << B);
        }
        return num;
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
    int num = (1 << A);
    if(A != B){
        num += (1 << B);
    }
    return num;
}
```

