### Q5. Range Sum Query - II
#### Problem Description
```text
You are given an integer array A of length N.

You are also given a 2D integer array B with dimensions M x 2, 
where each row denotes a [L, R] query.

For each query, you have to find the sum of all elements 
from L to R indices in A (0 - indexed).

More formally, 
find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    1 &lt;= N, M &lt;= 10<sup>3</sup><br> 
    1 &lt;= A[i] &lt;= 10<sup>5</sup><br> 
    0 &lt;= L &lt;= R &lt; N
</div>

```text
1 <= N, M <= 10^3
1 <= A[i] <= 10^5
0 <= L <= R < N
```
#### Input Format
```text
The first argument is the integer array A.
The second argument is the 2D integer array B.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    Return an integer array of length M where i<sup>th</sup> 
    element is the answer for i<sup>th</sup> query in B.
</div>

```text
Return an integer array of length M where ith element is the 
answer for ith query in B.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]
 B = [[0, 3], [1, 2]]

Input 2:
 A = [2, 2, 2]
 B = [[0, 0], [1, 2]]
```
#### Example Output
```text
Output 1:
 [10, 5]

Output 2:
 [2, 4]
```
#### Example Explanation
```text
Explanation 1:
    The sum of all elements of A[0 ... 3] = 1 + 2 + 3 + 4 = 10.
    The sum of all elements of A[1 ... 2] = 2 + 3 = 5.

Explanation 2:
    The sum of all elements of A[0 ... 0] = 2 = 2.
    The sum of all elements of A[1 ... 2] = 2 + 2 = 4.
```
### Hints
* Hint 1
```text
Look at the constraints for this problem.
The brute force approach is will pass in this one.
```
* Solution Approach
```text
For every query we traverse the array from L to R 
and calculate the sum in every case.

Time Complexity : O(N*M)
Space complexity : O(M)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] A, int[][] B) {
        int[] ans = new int[B.length];
    	for(int i = 0; i < B.length; i++){
    		int sum = 0;
    		for(int j = B[i][0]; j <= B[i][1]; j++){
    			sum += A[j];
    		}
    		ans[i] = sum;
    	}
    	return ans;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
vector<int> Solution::solve(vector<int> &A, vector<vector<int> > &B) {
    vector<int> ans;
	for(int i = 0; i < B.size(); i++){
		int sum = 0;
		for(int j = B[i][0]; j <= B[i][1]; j++){
			sum += A[j];
		}
		ans.push_back(sum);
	}
	return ans;
}
```

