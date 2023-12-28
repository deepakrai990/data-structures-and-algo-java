### Q2. Row Sum
#### Problem Description
```text
Problem Description
You are given a 2D integer matrix A, return a 1D integer array 
containing row-wise sums of original matrix.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
<p>1 &lt;= A.size() &lt;= 10<sup>3</sup></p><p></p><p></p>
<p>1 &lt;= A[i].size() &lt;= 10<sup>3</sup></p>
<p>1 &lt;= A[i][j] &lt;= 10<sup>3</sup></p>
</div>

```text
1 <= A.size() <= 10^3

1 <= A[i].size() <= 10^3

1 <= A[i][j] <= 10^3
```
#### Input Format
```text
First argument A is a 2D array of integers.(2D matrix).
```
#### Output Format
```text
Return an array containing row-wise sums of original matrix.
```
#### Example Input
```text
Input 1:
 [1,2,3,4]
 [5,6,7,8]
 [9,2,3,4]
```
#### Example Output
```text
Output 1:
 [10,26,18]
```
#### Example Explanation
```text
Explanation 1
    Row 1 = 1+2+3+4 = 10
    Row 2 = 5+6+7+8 = 26
    Row 3 = 9+2+3+4 = 18
```
### Hints
* Hint 1
```text
Just check row by row and keep storing their sum in a vector.
```
* Solution Approach
```text
Iterate the 2D vector row wise using a for loop and by
store the sum of row in a variable push the sum in a list 
after the completion of each row  and return the list.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[][] A) {
        int n = A.length, m = A[0].length;
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = 0;
            // Finding sum of elements of ith row
            for (int j = 0; j < m; j++) {
                temp += A[i][j];
            }
            ans[i] = temp;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of array of integers
 //return a array of integers
	solve : function(A){
	    let ans = [];
	    let n = A.length;
	    let m = A[0].length;
	    
	    for(let i = 0; i < n; i++) {
	        let row_sum = 0;
	        // Finding sum of elements of ith row
	        for(let j = 0; j <m; j++)
	            row_sum += A[i][j];
	        ans.push(row_sum);
	    }
	    return ans;
	}
};
```
* * Solution in C++
```cpp
vector<int> Solution::solve(vector<vector<int> > &A) {
    int n = A.size(), m = A[0].size();
	vector<int> ans;
    for(int i = 0; i < n; i++){
    	int temp = 0;
    	// Finding sum of elements of ith row
    	for(int j = 0; j < m; j++){
    		temp += A[i][j];
    	}
    	ans.push_back(temp);
    }
    return ans;
}
```

