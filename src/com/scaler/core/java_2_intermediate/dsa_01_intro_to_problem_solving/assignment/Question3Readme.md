### Q3. Square root of a number
#### Problem Description
```text
Given a number A. Return square root of the number if it is perfect 
square otherwise return -1.
```
#### Problem Constraints
* <p>1 &lt;= A &lt;= 10<sup>8</sup></p>
```text
1 <= A <= 10^8
```
#### Input Format
```text
First and the only argument is an integer A.
```
#### Output Format
```text
Return an integer which is the square root of A if A is perfect 
square otherwise return -1.
```
#### Example Input
```text
Input 1:
 A = 4

Input 2:
 A = 1001
```
#### Example Output
```text
Output 1:
 2

Output 2:
 -1
```
#### Example Explanation
```text
Explanation 1:
    sqrt(4) = 2

Explanation 2:
    1001 is not a perfect square.
```
### Hints
* Hint 1
```text
The square root of a number can be thought of as raising that number 
to the power of (1/2).

The ** operator in python can be used to raise a number x to the power of y.
```
* Solution Approach
```text
Calculate the square root of A by raising it to the power of 0.5, pass 
it through the int() function, and store it in a variable let’s say sqrt.

If sqrt * sqrt == A then return sqrt, else return -1
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
        // Loop from 1 to 10000
        for(int i = 1; i <= 10000; i++){
            if(i*i==A){
                return i;
            }
        }
        return -1;
    }
}
```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp
int Solution::solve(int A) {
    // Loop from 1 to 10000
    for(int i = 1; i <= 10000; i++){
        if(i*i==A){
            return i;
        }
    }
    return -1;
}
```

