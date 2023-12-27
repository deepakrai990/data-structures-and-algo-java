### Q3. Divisibility by 3
#### Problem Description
```text
Given a number in the form of an array A of size N. Each of the 
digits of the number is represented by A[i]. Check if the 
number is divisible by 3.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>0 &lt;= A[i] &lt;= 9</p>
    <p>A[1] ≠ 0</p>
</div>

```text
1 <= N <= 10^5

0 <= A[i] <= 9

A[1] ≠ 0
```
#### Input Format
```text
Given an integer array representing the number
```
#### Output Format
```text
Return 1 if the number is divisible by 3 and return 0 otherwise.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3]

Input 2:
 A = [1, 0, 0, 1, 2]
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
For Input 1:
    The number 123 is divisible by 3.

For Input 2:
    The number 10012 is not divisible by 3.
```
### Hints
* Hint 1
```text
Whether a number is divisible by 3 can be found out
by calculating the sum of its digits.
```
* Solution Approach
```text
We will calculate the sum of all the digits of the number. 
If the sum is divisble by 3, then our number is divisible by 3.
Otherwise, it is not divisible by 3.

Time Complexity : O(N)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 == 0) {
            return 1;
        }
        return 0;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A) {
	int sum = 0;
	for(auto x : A){
		sum += x;
	}
	if(sum % 3 == 0){
		return 1;
	}
	return 0;
}
```

