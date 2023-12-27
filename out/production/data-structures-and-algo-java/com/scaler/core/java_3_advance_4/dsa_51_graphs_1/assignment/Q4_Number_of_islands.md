### Q4. Number of islands
#### Problem Description
```text
Given a matrix of integers A of size N x M consisting of 0 and 1. A group of 
connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit 
any cell that shares a corner with (i, j) and value in that cell is 1.

More formally, from any cell (i, j) if A[i][j] = 1 you can visit:

    * (i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
    * (i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
    * (i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
    * (i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
    * (i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
    * (i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
    * (i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
    * (i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.

Return the number of islands.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
```
#### Problem Constraints
```text
1 <= N, M <= 100

0 <= A[i] <= 1
```
#### Input Format
```text
The only argument given is the integer matrix A.
```
#### Output Format
```text
Return the number of islands.
```
#### Example Input
```text
Input 1:
 A = [ 
       [0, 1, 0]
       [0, 0, 1]
       [1, 0, 0]
     ]

Input 2:
 A = [   
       [1, 1, 0, 0, 0]
       [0, 1, 0, 0, 0]
       [1, 0, 0, 1, 1]
       [0, 0, 0, 0, 0]
       [1, 0, 1, 0, 1]    
     ]
```
#### Example Output
```text
Output 1:
 2

Output 2:
 5
```
#### Example Explanation
```text
Explanation 1:
     The 1's at position A[0][1] and A[1][2] forms one island.
     Other is formed by A[2][0].

Explanation 2:
    There 5 island in total.
```
### Hints
* Hint 1
```text
The problem reduces to finding the number of connected components.

It can be solve with both BFS and DFS.
```
* Solution Approach
```text
Whenever a cell with unvisited value ‘1’ is encountered we explore all the nodes that 
are reachable from it and continue exploring until no more nodes are left to explore.

While exploring we mark them visited so that no nodes can be explored twice.

After completion of traversal increment the count of islands.

Find for the 1 which is not visited yet.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int[] dx = new int[] {0, 1, -1, 0, 1, -1, 1, -1};
    static int[] dy = new int[] {1, 0, 0, -1, -1, 1, 1, -1};
    static int tc = 0;
    static int[][] visited = new int[105][105];
    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        ++tc;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1 && visited[i][j] != tc) {
                    dfs(i, j, n, m, A);
                    ans++;
                }
            }
        }
        return ans;
    }
    public static boolean check(int i, int j, int n, int m, int[][] A) {
        return (i >= 0 && i < n && j >= 0 && j < m && (A[i][j] == 1) && visited[i][j] != tc);
    }
    public static void dfs(int i, int j, int n, int m, int[][] A) {
        visited[i][j] = tc;
        int di, dj;
        for (int k = 0; k < 8; ++k) {
            di = i + dx[k];
            dj = j + dy[k];
            if (check(di, dj, n, m, A))
                dfs(di, dj, n, m, A);
        }
    }
}
```
* * Solution in Javascript
```javascript
let dir = [
  [0, 1],
  [1, 0],
  [-1, 0],
  [0, -1],
  [1, -1],
  [-1, 1],
  [1, 1],
  [-1, -1],
];
let tc = 0;

let visited = new Array(105).fill(0).map(() => new Array(105).fill(0));

function check(i, j, n, m, A) {
  return (
    i >= 0 && i < n && j >= 0 && j < m && A[i][j] == 1 && visited[i][j] != tc
  );
}

function dfs(i, j, n, m, A) {
  visited[i][j] = tc;
  let di, dj;
  for (let k = 0; k < 8; ++k) {
    di = i + dir[k][0];
    dj = j + dir[k][1];
    if (check(di, dj, n, m, A)) dfs(di, dj, n, m, A);
  }
}

function solveit(A) {
  let n = A.length;
  let m = A[0].length;

  ++tc;
  let numberofislands = 0;
  for (let i = 0; i < n; ++i) {
    for (let j = 0; j < m; ++j) {
      if (A[i][j] == 1 && visited[i][j] != tc) {
        dfs(i, j, n, m, A);
        ++numberofislands;
      }
    }
  }
  return numberofislands;
}

module.exports = {
  solve: function (A) {
    return solveit(A);
  },
};
```
* * Solution in C++
```cpp
int dir[][2]={{0,1},{1,0},{-1,0},{0,-1},{1,-1},{-1,1},{1,1},{-1,-1}};
int tc = 0;

int visited[105][105];

bool check(int i, int j, int n, int m, vector < vector < int > > & A) {
  return (i >= 0 && i < n && j >= 0 && j < m && (A[i][j] == 1) && visited[i][j] != tc);
}

void dfs(int i, int j, int n, int m, vector < vector < int > > & A) {
  visited[i][j] = tc;
  int di, dj;
  for (int k = 0; k < 8; ++k) {
    di = i + dir[k][0];
    dj = j + dir[k][1];
    if (check(di, dj, n, m, A))
      dfs(di, dj, n, m, A);
  }
}

int solveit(vector < vector < int > > A) {
  int n = A.size();
  int m = A[0].size();
  assert(n >= 1 && n <= 100);
  assert(m >= 1 && m <= 100);
  ++tc;
  int numberofislands = 0;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      if (A[i][j] == 1 && visited[i][j] != tc) {
        dfs(i, j, n, m, A);
        ++numberofislands;
      }
    }
  }
  return numberofislands;
}

int Solution::solve(vector < vector < int > > & A) {
  return solveit(A);
}
```

