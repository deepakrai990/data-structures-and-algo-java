### Q3. Unset i-th bit
#### Problem Description
```text
You are given two integers A and B.

    * If B-th bit in A is set, make it unset
    * If B-th bit in A is unset, leave it as it is

Return the updated A value
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
 4

Output 2:
 1
```
#### Example Explanation
```text
For Input 1:
    Given N = 4 which is 100 in binary. The 1-st bit is already unset

For Input 2: 
    Given N = 5 which is 101 in binary. We unset the 2-nd bit
```
### Hints
* Hint 1
```text
The value of the i-th bit is 2^i
```
* Solution Approach
```text
We can find if the B-th bit is set in A by performing
bitwise AND of A and 2^B. If the result is non-zero then
we subtract 2^B from A. If the bitwise AND is zero that means
the B-th bit is already unset. So, then we return A as it is.

Time Complexity : O(1)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A, int B) {
        int num = 1 << B;
        if((A & num) > 0){
            A -= num;
        }
        return A;
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
    int num = 1 << B;
    if(A & num){
        A -= num;
    }
    return A;
}
```

