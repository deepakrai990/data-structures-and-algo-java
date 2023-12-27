### Q1. Matrix Scalar Product
#### Problem Description
```text
You are given a matrix A and and an integer B, you have to perform 
scalar multiplication of matrix A with an integer B.
```
#### Problem Constraints
```text
1 <= A.size() <= 1000

1 <= A[i].size() <= 1000

1 <= A[i][j] <= 1000

1 <= B <= 1000
```
#### Input Format
```text
First argument is 2D array of integers A representing matrix.

Second argument is an integer B.
```
#### Output Format
```text
You have to return a 2D array of integers after doing required operations.
```
#### Example Input
```text
Input 1:
 A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
 B = 2 
```
#### Example Output
```text
Output 1:
 [[2, 4, 6], [8, 10, 12], [14, 16, 18]]
```
#### Example Explanation
```text
Explanation 1:
    ==> ( [[1, 2, 3],[4, 5, 6],[7, 8, 9]] ) * 2
    ==> [[2*1, 2*2, 2*3],[2*4, 2*5, 2*6],[2*7, 2*8, 2*9]]
    ==> [[2, 4, 6], [8, 10, 12], [14, 16, 18]]
```
### Hints
* Hint 1
```text
In scalar matrix multiplication, you multiply the value B with each and 
every element of the matrix A.
```
* Solution Approach
```text
Run a outer loop from i = 1 to i = row
Run a inner loop from j = 1 to j = col
Do A[i][j]*B for all elements
Return the updated matrix.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[][] solve(int[][] A, int B) {
        int row = A.length, col = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // Multiplying each element by B
                A[i][j] *= B;
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
    //param B : integer
    //return a array of array of integers
    solve: function (A, B) {
        let n = A.length;
        let m = A[0].length;

        for (let i = 0; i < n; i++) {
            for (let j = 0; j < m; j++) {
                // Multiplying each element by B
                A[i][j] *= B;
            }
        }
        return A;
    }
};
```
* * Solution in C++
```cpp
vector<vector<int> > Solution::solve(vector<vector<int> > &A, int B) {
    int row = A.size(), col = A[0].size();
    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
            // Multiplying each element by B
            A[i][j] *= B;
        }
    }
    return A;
}
```

