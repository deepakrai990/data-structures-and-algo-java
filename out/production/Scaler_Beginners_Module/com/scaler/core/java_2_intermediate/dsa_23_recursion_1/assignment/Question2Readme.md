### Q2. Find Factorial!
#### Problem Description
```text
Write a program to find the factorial of the given 
number A using recursion.
```
#### Problem Constraints
```text
0 <= A <= 12
```
#### Input Format
```text
First and only argument is an integer A.
```
#### Output Format
```text
Return an integer denoting the factorial of the number A.
```
#### Example Input
```text
Input 1:
 A = 4

Input 2:
 A = 1
```
#### Example Output
```text
Output 1:
 24

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    Factorial of 4 = 4 * 3 * 2 * 1 = 24

Explanation 2:
    Factorial of 1 = 1
```
### Hints
* Hint 1
```text
Factorial of a number N is the product of all numbers from 1 to N.

Also factorial of 0 is 1 i.e 0! = 1
```
* Solution Approach
```text
Factorial of a number N is the product of all numbers from 1 to N.

Factorial can be calculated using following recursive formula.

n! = n * (n-1)!
n! = 1 if n = 0 or n = 1

Note: Factorial of 0 is 1.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
        return factorial(A);
    }
    public static int factorial(int n) { 
        if (n == 0) 
            return 1;
        return n * factorial(n - 1); 
    } 
}
```
* * Solution in Javascript
```javascript
module.exports = { 
    //param A : integer
    //return an integer
    solve : function(A) {
       function fact(n) {
           if(n <= 1)
               return 1;
           return n * fact(n-1);
       }
       return fact(A);
    }
};
```
* * Solution in C++
```cpp
int factorial(int n) 
{ 
    if (n == 0) 
        return 1; 
    return n * factorial(n - 1); 
} 
int Solution::solve(int A) {
    return factorial(A);
}
```

