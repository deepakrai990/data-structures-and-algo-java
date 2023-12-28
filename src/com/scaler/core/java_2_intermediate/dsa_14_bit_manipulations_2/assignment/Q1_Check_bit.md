### Q1. Check bit
#### Problem Description
```text
You are given two integers A and B.
    
    * Return 1 if B-th bit in A is set
    * Return 0 if B-th bit in A is unset
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= A &lt;= 10<sup>9</sup> <br>
    0 &lt;= B &lt;= 30
</div>

```text
1 <= A <= 10^9
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
 A = 4
 B = 1

Input 2:
 A = 5
 B = 2
```
#### Example Output
```text
Output 1:
 0

Output 2:
 1
```
#### Example Explanation
```text
For Input 1:
    Given N = 4 which is 100 in binary. The 1-st bit is unset
    so we return 0

For Input 2:
    Given N = 5 which is 101 in binary. The 2-nd bit is set
    so we return 1
```
### Hints
* Hint 1
```text
The value of the i-th bit is 2^i
```
* Solution Approach
```text
The value of the B-th bit is 2^B

To find the B-th bit in A, we can directly
perform bitwise AND operation between A and 2^B.

If the bit was unset we get 0 as the result of the
bitwise AND and if the bit was set then the result is
2^B

Time Complexity : O(1)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, int B) {
        int num = 1 << B;
        if((A & num) == 0){
            return 0;
        }
        return 1;
    }
}
```
* * Solution in Javascript
```javascript
/** Not avaialbe **/
```
* * Solution in C++
```cpp
int Solution::solve(int A, int B) {
    int num = (1 << B);
    return (A & num) == 0 ? 0 : 1;
}
```

