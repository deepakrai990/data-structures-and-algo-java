### Q1. Subarray with given sum and length
#### Problem Description
```text
Given an array A of length N. Also given are integers B and C.

Return 1 if there exists a subarray with length B having 
sum C and 0 otherwise
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i] &lt;= 10<sup>4</sup></p>
    <p>1 &lt;= B &lt;= N</p>
    <p>1 &lt;= C &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= N <= 10^5

1 <= A[i] <= 10^4

1 <= B <= N

1 <= C <= 10^9
```
#### Input Format
```text
First argument A is an array of integers.

The remaining arguments B and C are integers
```
#### Output Format
```text
Return 1 if such a subarray exist and 0 otherwise
```
#### Example Input
```text
Input 1:
 A = [4, 3, 2, 6, 1]
 B = 3
 C = 11

Input 2:
 A = [4, 2, 2, 5, 1]
 B = 4
 C = 6
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
    The subarray [3, 2, 6] is of length 3 and sum 11.

Explanation 2:
    There are no such subarray.
```
### Hints
* Hint 1
```text
We can brute force for all subarrays and check if is
of length B and sum C.

Can you think of something in O(N)?
```
* Solution Approach
```text
We will use sliding window technique. 

We will check for all subarrays of length B whether their 
sum equals C or not.

Time Complexity : O(N)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int B, int C) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (i >= B) {
                sum -= A[i - B];
            }
            if (sum == C && i >= B - 1) {
                return 1;
            }
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
int Solution::solve(vector<int> &A, int B, int C) {
    int sum = 0;
	for(int i = 0 ; i < A.size() ; i++){
		sum += A[i];
		if(i >= B){
		    sum -= A[i - B];
		}
		if(sum == C and i >= B - 1){
		    return 1;
		}
	}
	return 0;
}
```

