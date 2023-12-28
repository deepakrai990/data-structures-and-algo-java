### Q1. Column Sum
#### Problem Description
```text
You are given a 2D integer matrix A, return a 1D integer array 
containing column-wise sums of original matrix.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A.size() &lt;= 10<sup>3</sup></p><p></p>
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
First argument is a 2D array of integers.(2D matrix).
```
#### Output Format
```text
Return an array conatining column-wise sums of original matrix.
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
 [15,10,13,16]
```
#### Example Explanation
```text
Explanation 1
     Column 1 = 1+5+9 = 15
     Column 2 = 2+6+2 = 10
     Column 3 = 3+7+3 = 13
     Column 4 = 4+8+4 = 16
```
### Hints
* Hint 1
```text
Just check column by column and keep storing their sum in a vector.
```
* Solution Approach
```text
Iterate the 2D vector column wise and by storing sum of a column 
in a variable and push it in a vector after the 
completion of each column.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[][] A) {
        int n = A.length, m = A[0].length;
        int[] ans = new int[m];
        for (int j = 0; j < m; j++) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                temp += A[i][j];
            }
            ans[j] = temp;
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
	    for(let j = 0; j < m; j++) {
	        let sum = 0;
	        
	        for(let i = 0; i < n; i++)
	            sum += A[i][j];
	        ans.push(sum);
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
    for(int j = 0; j < m; j++){
    	int temp = 0;
    	for(int i = 0; i < n; i++){
    		temp += A[i][j];
    	}
    	ans.push_back(temp);
    }
    return ans;
}
```

