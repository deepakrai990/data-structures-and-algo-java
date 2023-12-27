### QQ3. Is Perfect Square ?
#### Problem Description
```text
You are given a function that takes an integer argument A. Return 1 if 
A is a perfect square otherwise return 0.
```
#### Problem Constraints
* <p>1 &lt;= A &lt;= 10<sup>8</sup></p>
```text
1 <= A <= 10^8
```
#### Input Format
```text
First argument is an integer A.
```
#### Output Format
```text
Return an integer (0 or 1) based upon the question.
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
 1

Output 2:
 0
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
Calculating the square root of a number is like raising it to 
the power of (1/2).

The ** operator in python is used to raise a number to a certain power.

For example, 2**2 = 4.
```
* Solution Approach
```text
Calculate the square root of A by raising it to the power 
of (1/2) which is 0.5.

Pass the calculated square root through the int() function and 
store it in a variable let’s say sqrt.

Inside a if statement check if sqrt * sqrt is equal to A.

If it is then return 1, else return 0.
```
* Complete Solution
* * Solution in Java
```java
class Solution{
    public static int solve(int A) {
        // x is the smallest integer less than equal to square root of A
        int x = (int) Math.sqrt(A);
        if (x*x == A){
            return 1;
        }
        return 0;
    }
}
```
* * Solution in Javascript
```javascript
// Loop from 1 to 10000
function solve(A) {
    for (let i = 0; i * i <= A; i++) {
        if (i * i == A) {
            return 1;
        }
    }
    return 0;
}
```
* * Solution in C++
```cpp
int Solution::solve(int A) {
    // Loop from 1 to 10000
    for(int i=1;i<=10000;i++)
    if(i*i==A){
        return 1;
    }
    return 0;
}
```

