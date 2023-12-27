### Q2. Floyd Warshall Algorithm
#### Problem Description
```text
Given a matrix of integers A of size N x N, where A[i][j] represents the weight of 
directed edge from i to j (i ---> j).

If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to 
vertex j, A[i][j] = -1.

Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j.

If there is no possible path from vertex i to vertex j , B[i][j] = -1

Note: Rows are numbered from top to bottom and columns are numbered from left to right.
```
#### Problem Constraints
```text
1 <= N <= 200
-1 <= A[i][j] <= 1000000
```
#### Input Format
```text
The first and only argument given is the integer matrix A.
```
#### Output Format
```text
Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j
If there is no possible path from vertex i to vertex j, B[i][j] = -1.
```
#### Example Input
```text
Input

A = [ [0 , 50 , 39]
      [-1 , 0 , 1]
      [-1 , 10 , 0] ]
```
#### Example Output
```text
Output

 [ [0 , 49 , 39 ]
   [-1 , 0 , -1 ]
   [-1 , 10 , 0 ] ]
```
#### Example Explanation
```text
Explanation
    Shortest Path from 1 to 2 would be 1 ---> 3 ---> 2 and not directly from 1 to 2,
    All remaining distances remains same.
```
### Hints
* Hint 1
```text
There should be no possible triplet of i , j , k in matrix  such that 
A[i][j] + A[j][k] < A[i][k] && (A[i][j] != -1, A[j][k] != -1, A[k][j] != -1).
```
* Solution Approach
```text
The Floyd Warshall Algorithm is basically a Dynamic Programming approach to solve the
all pairs shortest path problem.
Let dp[i][j] = Shortest distance between node i and j.
Then to go from i to j, we can either go to j via some some intermediate node k, or not.
We iterate over all possible values of k, and take the best among them.
The pseudo code is given below:

For all possible i, j and k
    if ( A[i][j] + A[j][k] < A[i][k] )
    { 
        A[i][k]=A[i][j]+A[j][k]  // Update A[i][k]
    }
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[][] solve(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == -1) {
                    A[i][j] = 100000005;
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (A[i][k] + A[k][j] < A[i][j]) {
                        A[i][j] = A[i][k] + A[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 100000005) {
                    A[i][j] = -1;
                }
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
    //return a array of array of integers
    solve: function (A) {
        let n = A.length;
        for (let i = 0; i < n; i++) {
            for (let j = 0; j < n; j++) {
                if (A[i][j] == -1) {
                    A[i][j] = 100000005;
                }
            }
        }
        for (let k = 0; k < n; k++) {
            for (let i = 0; i < n; i++) {
                for (let j = 0; j < n; j++) {
                    if (A[i][k] + A[k][j] < A[i][j]) {
                        A[i][j] = A[i][k] + A[k][j];
                    }
                }
            }
        }
        for (let i = 0; i < n; i++) {
            for (let j = 0; j < n; j++) {
                if (A[i][j] == 100000005) {
                    A[i][j] = -1;
                }
            }
        }
        return A;
    }
};
```
* * Solution in C++
```cpp
vector < vector < int > > Solution::solve(vector < vector < int > > & A) {
    int n = A.size();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (A[i][j] == -1) {
                A[i][j] = 100000005;
            }
        }
    }
    for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][k] + A[k][j] < A[i][j]) {
                    A[i][j] = A[i][k] + A[k][j];
                }
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (A[i][j] == 100000005) {
                A[i][j] = -1;
            }
        }
    }
    return A;
}
```

