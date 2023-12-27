### Q2. Min Sum Path in Matrix
#### Problem Description
```text
Given a M x N grid A of integers, find a path from top left to bottom right which 
minimizes the sum of all numbers along its path.

Return the minimum sum of the path.

NOTE: You can only move either down or right at any point in time.
```
#### Problem Constraints
```text
1 <= M, N <= 2000

-1000 <= A[i][j] <= 1000
```
#### Input Format
```text
First and only argument is a 2-D grid A.
```
#### Output Format
```text
Return an integer denoting the minimum sum of the path.
```
#### Example Input
```text
Input 1:
 A = [
       [1, 3, 2]
       [4, 3, 1]
       [5, 6, 1]
     ]

Input 2:
 A = [
       [1, -3, 2]
       [2, 5, 10]
       [5, -5, 1]
     ]
```
#### Example Output
```text
Output 1:
 8

Output 2:
 -1
```
#### Example Explanation
```text
Explanation 1:
    The path will be: 1 -> 3 -> 2 -> 1 -> 1.

Input 2:
    The path will be: 1 -> -3 -> 5 -> -5 -> 1.
```
### Hints
* Hint 1
```text
Think Dynamic programming. How would the current minimum distance be related to the 
minimum distance of its neighbors ?
```
* Solution Approach
```text
Let DP[i][j] store the minimum sum of numbers along the path from top left to (i,j). 
where 0<=i<=n-1 and 0<=j<=m-1.

Basically, DP[i][j] = A[i][j] + min(DP[i-1][j],DP[i][j-1]).

You only need to figure out the base conditions and boundary conditions now.

The answer to the problem would be simply Dp[n-1][m-1]. where n is the no. of rows 
and m is the no. of columns.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    private int[][] mem;
    private ArrayList<ArrayList<Integer>> A;

    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int m, n;
        if (A == null || A.size() == 0 || A.get(0).size() == 0)
            return 0;
        m = A.size();
        n = A.get(0).size();
        mem = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(mem[i], Integer.MAX_VALUE);
        mem[0][0] = A.get(0).get(0);
        this.A = A;
        rec(m - 1, n - 1);
        return mem[m - 1][n - 1];
    }

    public int rec(int i, int j) {
        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;
        if (mem[i][j] != Integer.MAX_VALUE)
            return mem[i][j];
        int res = rec(i - 1, j);
        res = Math.min(rec(i, j - 1), res);
        mem[i][j] = res + A.get(i).get(j);
        return mem[i][j];
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of array of integers
    //return an integer
    minPathSum: function (grid) {
        if (grid.length === 0 || grid[0].length === 0) {
            return Infinity;
        }
        let height = grid.length,
            width = grid[0].length;
        for (let row = height - 1; row >= 0; row--) {
            for (let col = width - 1; col >= 0; col--) {
                if (row === height - 1 && col === width - 1) {
                    continue;
                }
                let right = col < width - 1 ? grid[row][col + 1] : Infinity;
                let bottom = row < height - 1 ? grid[row + 1][col] : Infinity;
                grid[row][col] = grid[row][col] + Math.min(right, bottom);
            }
        }
        return grid[0][0];
    }
};
```
* * Solution in C++
```cpp
int Solution::minPathSum(vector < vector < int > > & A) {
    if (A.size() == 0) 
        return 0;
    int m = A.size(), n = A[0].size();
    int minPath[m + 1][n + 1];
    for (int i = 0; i < m; i++) {
        minPath[i][0] = A[i][0];
        if (i > 0) minPath[i][0] += minPath[i - 1][0];
        for (int j = 1; j < n; j++) {
            minPath[i][j] = A[i][j] + minPath[i][j - 1];
            if (i > 0) minPath[i][j] = min(minPath[i][j], A[i][j] + minPath[i - 1][j]);
        }
    }
    return minPath[m - 1][n - 1];
}
```

