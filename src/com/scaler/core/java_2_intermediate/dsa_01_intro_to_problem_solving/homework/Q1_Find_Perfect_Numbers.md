### Q1. Find Perfect Numbers
#### Problem Description
```text
You are given an integer A. You have to tell whether it is a 
perfect number or not.

Perfect number is a positive integer which is equal to the sum of 
it's proper positive divisors.

A proper divisor of a natural number is the divisor that is 
strictly less than the number.
```
#### Problem Constraints
* <p>1 &lt;= <strong>A</strong> &lt;= 10<sup>6</sup></p>
```text
1 <= A <= 10^6
```
#### Input Format
```text
First and only argument contains a single positive integer A.
```
#### Output Format
```text
Return 1 if A is a perfect number and 0 otherwise.
```
#### Example Input
```text
Input 1:
 A = 4

Input 2:
 A = 6
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
Explanation 1:
    For A = 4, the sum of its proper divisors = 1 + 2 = 3, is not equal to 4.

Explanation 2:
    For A = 6, the sum of its proper divisors = 1 + 2 + 3 = 6, is equal to 6. 
```
### Hints
* Hint 1
```text
You can loop through all the perfect factors of A
and calculate the sum.
```
* Solution Approach
```text
To check if a number is perfect number or not, you can find all the 
factors of that number and check if their sum (excluding the number 
itself as a factor) is equal to the number itself or not.

Time Complexity : O(√A)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
        if(A == 1){
            return 0;
        }
        int sum = 1;
        for (int j = 2; j * j <= A;j++){
            if(A % j == 0){
                sum += j;
				if(j != A / j){
					sum += A / j;
				}
            }
        }
        if(sum == A){
            return 1;
        }
        return 0;
    }
}
```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp
int Solution::solve(int A) {
    if(A == 1){
		return 0;
	}
	int sum = 1;
	for (int j = 2; j * j <= A;j++){
		if(A % j == 0){
			sum += j;
			if(j != A / j){
				sum += A / j;
			}
		}
	}
	if(sum == A){
		return 1;
	}
	return 0;
}
```

