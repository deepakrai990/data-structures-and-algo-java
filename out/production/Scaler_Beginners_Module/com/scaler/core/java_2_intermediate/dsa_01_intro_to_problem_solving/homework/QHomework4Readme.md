### Q4. Make it
#### Problem Description
```text
Given two integers A and B. A represents the count of mangoes 
and B represent the count of slices of mangoes. Mango can be 
cut into three slices of mangoes. A glass of mango shake can 
be formed by two slices of mangoes.

Find the maximum number of glasses of mango shakes you can make 
with A mangoes and B slices of mangoes initially.
```
#### Problem Constraints
* <p>0 &lt;= A, B &lt;= 10<sup>8</sup></p>
```text
0 <= A, B <= 10^8
```
#### Input Format
```text
The First argument is an integer A.
The Second argument is an integer B.
```
#### Output Format
```text
Return the maximum number of glasses of mango shakes you can make.
```
#### Example Input
```text
Input 1:
 A = 19
 B = 0
Input 2:
 A = 7
 B = 1
```
#### Example Output
```text
Output 1:
 28

Output 2:
 11
```
#### Example Explanation
```text

```
### Hints
* Hint 1
```text
Not available 
```
* Solution Approach
```text
A mangoes will give 3*A mango slices and total mango slices will became B+3*A;
answer if integer division of (B+3*A)/2
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    int solve(int A, int B) {
        return (B + A + A + A) / 2;
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
    return (B+A+A+A)/2;
}
```

