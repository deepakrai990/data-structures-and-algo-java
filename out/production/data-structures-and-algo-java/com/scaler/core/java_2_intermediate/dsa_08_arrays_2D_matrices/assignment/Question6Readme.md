### Q6. Matrix Transpose
#### Problem Description
```text
You are given a matrix A, you have to return another matrix 
which is the transpose of A.

NOTE: Transpose of a matrix A is defined as - AT[i][j] = A[j][i]; 
Where 1 ≤ i ≤ col and 1 ≤ j ≤ row. The transpose of a matrix 
switches the element at (i, j)th index to (j, i)th index, and 
the element at (j, i)th index to (i, j)th index.
```
#### Problem Constraints
```text
1 <= A.size() <= 1000

1 <= A[i].size() <= 1000

1 <= A[i][j] <= 1000
```
#### Input Format
```text
First argument is a 2D matrix of integers.
```
#### Output Format
```text
You have to return the Transpose of this 2D matrix.
```
#### Example Input
```text
Input 1:
 A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]

Input 2:
 A = [[1, 2],[1, 2],[1, 2]]
```
#### Example Output
```text
Output 1:
 [[1, 4, 7], [2, 5, 8], [3, 6, 9]]

Output 2:
 [[1, 1, 1], [2, 2, 2]]
```
#### Example Explanation
```text
Explanation 1:
    Clearly after converting rows to column and columns to 
    rows of [[1, 2, 3],[4, 5, 6],[7, 8, 9]]  we will 
    get [[1, 4, 7], [2, 5, 8], [3, 6, 9]].
```
### Hints
* Hint 1
```text
You will need to iterate over every element in the matrix and while 
doing so try to devise a way to switch the row and the 
column index of that element.
```
* Solution Approach
```text
The (i, j)th element in the input array (where i is the row 
and j is the column) is going to be at (j, i) in the answer matrix.

Initialize an answer list.

Run a inner loop from j = 1 to j = N, and append A[j][i] to temp,

Now append temp to the answer list.

If the size of the input matrix is (N x M), then the answer matrix 
will have a size of (M x N).

Return the updated answer matrix.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[][] solve(int[][] A) {
        int row = A.length, col = A[0].length;
        int[][] ans = new int[col][row];
        // Iterating over the columns
        for (int i = 0; i < col; i++) {
            // Iterating over the rows
            for (int j = 0; j < row; j++)
                ans[i][j] = A[j][i];

        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of array of integers
 //return a array of array of integers
	solve : function(A){
	    
	   let n = A.length;
	   let m = A[0].length;
	   let ans = new Array (m);
	   
	   for(let i = 0; i< m; i++)
	    ans[i] = [];
	   // Iterating over the columns
	   for( let j = 0; j < m; j++)
	       // Iterating over the rows
	       for(let i = 0; i < n; i++)
	            ans[j][i] = A[i][j];
	            
	   return ans;

	}
};
```
* * Solution in C++
```cpp
vector<vector<int> > Solution::solve(vector<vector<int> > &A) {
    int row = A.size(), col = A[0].size();
    vector<vector<int> > ans;
    // Iterating over the columns
    for(int i = 0; i < col; i++){
        vector<int> temp;
        // Iterating over the rows
        for(int j = 0; j < row; j++)
            temp.push_back(A[j][i]);
        ans.push_back(temp);
    }
    return ans;
}
```

