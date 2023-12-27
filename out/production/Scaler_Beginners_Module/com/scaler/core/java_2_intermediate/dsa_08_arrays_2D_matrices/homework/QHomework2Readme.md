### Q2. Are Matrices Same ?
#### Problem Description
```text
You are given two matrices A & B of equal dimensions and you have to 
check whether two matrices are equal or not.

NOTE: Both matrices are equal if A[i][j] == B[i][j] for all i and j 
in the given range.
```
#### Problem Constraints
```text
1 <= A.size(), B.size() <= 1000

1 <= A[i].size(), B[i].size() <= 1000

1 <= A[i][j], B[i][j] <= 1000
```
#### Input Format
```text
First argument is vector of vector of integers representing matrix A.

Second argument is vector of vector of integers representing matrix B.
```
#### Output Format
```text
Return 1 if both matrices are equal or return 0.
```
#### Example Input
```text
Input 1:
 A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
 B = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]

Input 2:
 A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
 B = [[1, 2, 3],[7, 8, 9],[4, 5, 6]]
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
    ==> Clearly all the elements of both matrices are equal at 
        respective positions.

Explanation 2:
    ==> Clearly all the elements of both matrices are not equal at 
        respective positions.
```
### Hints
* Hint 1
```text
Run loops for each row, and for each row run another loop to traverse 
through each element in that row.

So we are using nested loops.

Check all the elements of both matrices one by one and return 1 if all 
are equal otherwise return 0.
```
* Solution Approach
```text
Here run a outer loop for i = 0 to i = row
Run the inner loop from j = 0 to j = col
Return 0 if any A[i][j] != B[i][j]
Otherwise return 1 at the end of the loop.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[][] A, int[][] B) {
        int row = A.length, col = A[0].length;
        // Iterating over the rows
        for (int i = 0; i < row; i++) {
            // Iterating over the columns
            for (int j = 0; j < col; j++) {
                if (A[i][j] != B[i][j]) return 0;
            }
        }
        return 1;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of array of integers
 //param B : array of array of integers
 //return an integer
	solve : function(A, B) {
	    let n = A.length;
            let m = A[0].length;
            // Iterating over the rows
            for(let i = 0; i < n; i++) {
                // Iterating over the columns
                for (let j = 0; j < m; j++) {
                    if (A[i][j] != B[i][j])
                        return 0;
                }
            }
            return 1;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<vector<int> > &A, vector<vector<int> > &B) {
    int row = A.size(), col = A[0].size();
    // Iterating over the rows
    for(int i = 0; i < row; i++) {
        // Iterating over the columns
        for(int j = 0; j < col; j++) {
            if (A[i][j] != B[i][j]) return 0;
        }
    }
    return 1;
}
```

