### Q1. Count Factors - 2
#### Problem Description
```text
Given an integer A, you need to find the count of it's factors.

Factor of a number is the number which divides it perfectly 
leaving no remainder.

Example : 1, 2, 3, 6 are factors of 6
```
#### Problem Constraints
* <p>1 &lt;= A &lt;= 10<sup>9</sup></p>
```text
1 <= A <= 10^9
```
#### Input Format
```text
First and only argument is an integer A.
```
#### Output Format
```text
Return the count of factors of A.
```
#### Example Input
```text
Input 1:
 5

Input 2:
 10
```
#### Example Output
```text
Output 1:
 2

Output 2:
 4
```
#### Example Explanation
```text
Explanation 1:
    Factors of 5 are 1 and 5.

Explanation 2:
    Factors of 10 are 1, 2, 5 and 10.
```
### Hints
* Hint 1
```text
Factors exist from 1 to A inclusive.
```
* Solution Approach
```text
Iterate over all numbers from 1 to root(A). 
For each number check if A % i == 0.
If yes, then increment count by 1 if i * i == A or 
by 2 otherwise.

Time Complexity : O(√A)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int A) {
        int count = 0;
        for(int i = 1 ; i * i <= A ; i++){
            if(A % i == 0){
                count += 1;
                if(i * i != A){
                    count += 1;
                }
            }
        }
        return count;
    }
}
```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp
int Solution::solve(int A) {
    int count = 0;
	for(int i = 1 ; i * i <= A ; i++){
		if(A % i == 0){
			count += 1;
			if(i * i != A){
				count += 1;
			}
		}
	}
	return count;
}
```

