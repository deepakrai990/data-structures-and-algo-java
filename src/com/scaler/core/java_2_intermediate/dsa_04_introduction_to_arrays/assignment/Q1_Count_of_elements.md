### Q1. Count of elements
#### Problem Description
```text
Given an array A of N integers. Count the number of elements 
that have at least 1 elements greater than itself.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= N <= 10^5
1 <= A[i] <= 10^9
```
#### Input Format
```text
First and only argument is an array of integers A.
```
#### Output Format
```text
Return the count of elements.
```
#### Example Input
```text
Input 1:
 A = [3, 1, 2]

Input 2:
 A = [5, 5, 3]
```
#### Example Output
```text
Output 1:
 2

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    The elements that have at least 1 element greater than itself are 1 and 2

Explanation 2:
    The elements that have at least 1 element greater than itself is 3
```
### Hints
* Hint 1
```text
Which elements do not have at least 1 elements greater than itself?
Only elements that are equal to the maximum value of the array do not
satisfy this
```
* Solution Approach
```text
We need to count the number of elements in the array 
that are not equal to the maximum value of the array.
We can traverse the array and get this count.

Time Complexity : O(N)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        int max_value = 0, max_count = 0;
    	for(int i = 0 ; i < A.length ; i++){
    		if(A[i] > max_value){
    			max_value = A[i];
    			max_count = 1;
    		}
    		else if(A[i] == max_value){
    			max_count += 1;
    		}
    	}
    	return A.length - max_count;
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
    int max_value = 0, max_count = 0;
	for(int i = 0 ; i < A.size() ; i++){
		if(A[i] > max_value){
			max_value = A[i];
			max_count = 1;
		}
		else if(A[i] == max_value){
			max_count += 1;
		}
	}
	return A.size() - max_count;
}
```

