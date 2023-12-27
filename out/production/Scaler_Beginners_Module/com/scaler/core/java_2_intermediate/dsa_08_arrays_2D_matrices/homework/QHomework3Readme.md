### Q3. Add the matrices
#### Problem Description
```text
You are given two matrices A & B of same size, you have to return another 
matrix which is the sum of A and B.
```
#### Problem Constraints
```text
1 <= A.size(), B.size() <= 1000

1 <= A[i].size(), B[i].size() <= 1000

1 <= A[i][j], B[i][j] <= 1000
```
#### Input Format
```text
The first argument is the 2D integer array A

The second argument is the 2D integer array B
```
#### Output Format
```text
You have to return a vector of vector of integers after doing 
required operations.
```
#### Example Input
```text
Input 1:
    A = [[1, 2, 3], 
         [4, 5, 6], 
         [7, 8, 9]]

    B = [[9, 8, 7], 
         [6, 5, 4], 
         [3, 2, 1]]
```
#### Example Output
```text
Output 1:
    [[10, 10, 10], 
     [10, 10, 10], 
     [10, 10, 10]]
```
#### Example Explanation
```text
Explanation 1:
    A + B = [[1+9, 2+8, 3+7],[4+6, 5+5, 6+4],[7+3, 8+2, 9+1]] = 
    [[10, 10, 10], [10, 10, 10], [10, 10, 10]].
```
### Hints
* Hint 1
```text
Just initialize an ans vector and push sum of elements of both matrices accordingly.
```
* Solution Approach
```text
Run a outer loop from i = 1 to i = row - 1
Run a inner loop from j = 1 to j = col - 1, and do A[i][j] += B[i][j]
return the updated ans matrix.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[][] solve(int[][] A, int[][] B) {
        int row = A.length, col = A[0].length;
        // Iterating over rows
        for (int i = 0; i < row; i++) {
            // Iterating over the columns
            for (int j = 0; j < col; j++) {
                A[i][j] += B[i][j];
            }
        }
        return A;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of array of integers
    //param B : array of array of integers
    //return a array of array of integers
    solve: function (A, B) {

        let n = A.length, m = A[0].length;
        let ans = new Array(n);

        for (let i = 0; i < n; i++) {
            ans[i] = [];
        }
        // Iterating over rows
        for (let i = 0; i < n; i++) {
            // Iterating over the columns
            for (let j = 0; j < m; j++) {
                ans[i][j] = A[i][j] + B[i][j];
            }
        }
        return ans;
    }
};

```
* * Solution in C++
```cpp
vector<vector<int> > Solution::solve(vector<vector<int> > &A, vector<vector<int> > &B) {
    int row = A.size(), col = A[0].size();
    // Iterating over rows
    for(int i = 0; i < row; i++) {
        // Iterating over the columns
        for(int j = 0; j < col; j++) {
            A[i][j] += B[i][j];
        }
    }
    return A;
}
```

