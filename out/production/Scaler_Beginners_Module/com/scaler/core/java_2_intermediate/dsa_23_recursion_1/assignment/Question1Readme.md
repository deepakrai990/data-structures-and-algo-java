### Q1. Find Fibonacci - II
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>The Fibonacci numbers are the numbers in the 
    following integer sequence.</p>
    <p>0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..</p>
    <p>In mathematical terms, the sequence F<sub>n</sub> 
    of Fibonacci numbers is defined by the recurrence 
    relation:</p>
    <p><strong>F<sub>n</sub> = F<sub>n-1</sub> + F
    <sub>n-2</sub></strong></p>
    <p>Given a number <strong>A</strong>, find and return 
    the <strong>A<sup>th</sup></strong> Fibonacci Number 
    using recursion.</p>
    <p>Given that F<sub>0</sub> = 0 and F<sub>1</sub> = 1.</p>
</div>

```text
The Fibonacci numbers are the numbers in the following 
integer sequence.

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..

In mathematical terms, the sequence Fn of Fibonacci numbers 
is defined by the recurrence relation:

F(n) = F(n-1) + F(n-2)

Given a number A, find and return the A^th Fibonacci Number 
using recursion.

Given that F0 = 0 and F1 = 1.
```
#### Problem Constraints
```text
0 <= A <= 20
```
#### Input Format
```text
First and only argument is an integer A.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Return an integer denoting the 
    <strong>A<sup>th</sup></strong> term of the sequence.</p>
</div>

```text
Return an integer denoting the A^th term of the sequence.
```
#### Example Input
```text
Input 1:
 A = 2

Input 2:
 A = 9
```
#### Example Output
```text
Output 1:
 1

Output 2:
 34
```
#### Example Explanation
```text
Explanation 1:
    f(2) = f(1) + f(0) = 1

Explanation 2:
    f(9) = f(8) + f(7) = 21 + 13  = 34
```
### Hints
* Hint 1
```text
Think of how a given term relates to the others.

As recurrence relation is already given try to find out 
the base for recursion and implement it.
```
* Solution Approach
```text
Use recursion to apply the formula. Do not forget to add 
base cases or else you might run into an infinite loop.

Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
We can observe that this implementation does a lot of 
repeated work (see the following recursion tree). So 
this is a bad implementation for nth Fibonacci number.

                       fib(5)   
                     /                \
               fib(4)                fib(3)   
             /        \              /       \ 
         fib(3)      fib(2)         fib(2)   fib(1)
        /    \       /    \        /      \
  fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
  /     \
fib(1) fib(0)

Extra Space: O(n) if we consider the function 
call stack size, otherwise O(1).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int findAthFibonacci(int A) {
        return fib(A);
    }
    static int fib(int n) { 
    	if (n <= 1) 
        	return n; 
	    return fib(n-1) + fib(n-2); 
	}
}
```
* * Solution in Javascript
```javascript
module.exports = { 
    //param A : integer
    //return an integer
    findAthFibonacci : function(A) {
       function fib(n) {
           if(n <= 1)
               return n;
           return fib(n-1) + fib(n-2);
       }
       return fib(A);
    }
};
```
* * Solution in C++
```cpp
int fib(int n) 
{ 
	if (n <= 1) 
		return n; 
	return fib(n-1) + fib(n-2); 
} 
int Solution::findAthFibonacci(int A) {
    return fib(A);
}
```

