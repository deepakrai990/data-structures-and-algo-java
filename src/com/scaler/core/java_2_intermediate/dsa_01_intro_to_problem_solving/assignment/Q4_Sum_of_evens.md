### Q4. Sum of evens!
#### Problem Description
```text
You are given an integer A, you need to find and return the sum of 
all the even numbers between 1 and A.

Even numbers are those numbers that are divisible by 2.
```
#### Problem Constraints
```text
1 <= N <= 500
```
#### Input Format
```text
First and only argument is an integer A.
```
#### Output Format
```text
Return an integer denoting the sum of even numbers between [1, A] (both inclusive).
```
#### Example Input
```text
Input 1:
 5

Input 2:
 2
```
#### Example Output
```text
Output 1:
 6

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
 Even numbers between [1, 5] are (2, 4).

Explanation 2:
 Even numbers between [1, 2] are (2)
```
### Hints
* Hint 1
```text
Iterate from 2 to N, and check for even. If it is a even number, 
add it to the sum.

To check whether a number is even or not use modulo operator.
```
* Solution Approach
```text
Iterate from 2 to N, and check for even. If it is a even number, 
add it to the sum.

To check for even property of any number n just use modulo operation 
and see if remainder is zero or not when dividing by 2.

If remainder is zero add this number to the sum else not.

Time Complexity: O(N)
Space Complexity: O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
    	int sum = 0;
    	// Looping from 2 to A for even integers
    	for (int i = 2; i <= A; i++){
    		if (i % 2 == 0)
    			sum += i;
    	}
    	return sum;
    }
}
```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp
int Solution::solve(int A)
{
	int sum = 0;
	// Looping from 2 to A for even integers
	for (int i = 2; i <= A; i++)
	{
		if (i % 2 == 0)
			sum += i;
	}
	return sum;
}
```

