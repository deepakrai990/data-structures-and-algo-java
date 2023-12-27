### Q1. Distance of nearest cell
#### Problem Description
```text
Given a matrix of integers A of size N x M consisting of 0 or 1.

For each cell of the matrix find the distance of nearest 1 in the matrix.

Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.

Find and return a matrix B of size N x M which defines for each cell in A distance 
of nearest 1 in the matrix A.

NOTE: There is atleast one 1 is present in the matrix.
```
#### Problem Constraints
```text
1 <= N, M <= 1000

0 <= A[i][j] <= 1
```
#### Input Format
```text
The first argument given is the integer matrix A.
```
#### Output Format
```text
Return the matrix B.
```
#### Example Input
```text
Input 1:
 A = [
       [0, 0, 0, 1]
       [0, 0, 1, 1] 
       [0, 1, 1, 0]
     ]

Input 2:
 A = [
       [1, 0, 0]
       [0, 0, 0]
       [0, 0, 0]  
     ]
```
#### Example Output
```text
Output 1:
 [ 
   [3, 2, 1, 0]
   [2, 1, 0, 0]
   [1, 0, 0, 1]   
 ]

Output 2:
 [
   [0, 1, 2]
   [1, 2, 3]
   [2, 3, 4] 
 ]
```
#### Example Explanation
```text
Explanation 1:
    A[0][0], A[0][1], A[0][2] will be nearest to A[0][3].
    A[1][0], A[1][1] will be nearest to A[1][2].
    A[2][0] will be nearest to A[2][1] and A[2][3] will be nearest to A[2][2].

Explanation 2:
    There is only a single 1. Fill the distance from that 1.
```
### Hints
* Hint 1
```text
Initially consider the nearest distance from 1 for all cells as infinity.
Now for each cell do a bfs and update the distance matrix accordingly.

This approach can lead to the correct answer but may cause a 
worst case complexity of O(N^2 * M^2).

Can we do better ?
```
* Solution Approach
```text
The idea is to use multi-source BFS. At the beginning insert all the nodes having 
value 1 in the queue.

We first explore immediate adjacent of all 1’s, then adjacent of adjacent, and so on.

Only if the distance at the cell of matrix is greater than the current distance, 
then only we update the distance of the cell.

Therefore we find minimum distance.

Time Complexity: O( N x M)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int inf = 99999999;
    static int[] dxx = new int[]{0, 1, 0, -1};
    static int[] dyy = new int[]{1, 0, -1, 0};

    public int[][] solve(int[][] A) {
        return solveIt(A);
    }

    public static int[][] solveIt(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        Queue<Pair> q = new ArrayDeque<Pair>();
        int[][] distance = new int[n][m];
        for (int[] row : distance)
            Arrays.fill(row, inf);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (A[i][j] == 1) {
                    distance[i][j] = 0;
                    q.offer(new Pair(i, j));
                }
            }
        }
        int x, y;
        while (q.size() > 0) {
            Pair p = q.poll();
            x = p.ff;
            y = p.ss;
            int dx, dy;
            for (int k = 0; k < 4; ++k) {
                dx = x + dxx[k];
                dy = y + dyy[k];
                if (dx >= 0 && dx < n && dy >= 0 && dy < m && distance[dx][dy] > distance[x][y] + 1) {
                    distance[dx][dy] = distance[x][y] + 1;
                    q.offer(new Pair(dx, dy));
                }
            }
        }
        return distance;
    }
}

class Pair {
    int ff;
    int ss;

    public Pair(int a, int b) {
        this.ff = a;
        this.ss = b;
    }
}
```
* * Solution in Javascript
```javascript
function Queue() {
  var a = [],
    b = 0;
  this.getLength = function () {
    return a.length - b;
  };
  this.isEmpty = function () {
    return 0 == a.length;
  };
  this.enqueue = function (b) {
    a.push(b);
  };
  this.dequeue = function () {
    if (0 != a.length) {
      var c = a[b];
      2 * ++b >= a.length && ((a = a.slice(b)), (b = 0));
      return c;
    }
  };
  this.peek = function () {
    return 0 < a.length ? a[b] : void 0;
  };
}

class node {
  constructor(a, b) {
    this.first = a;
    this.second = b;
  }
}
const inf = 99999999;
let dir = [
  [0, 1],
  [1, 0],
  [0, -1],
  [-1, 0],
];

function solveit(A) {
  let n = A.length;
  let m = A[0].length;
  let q = new Queue();
  let distance = new Array(n).fill(inf).map(() => new Array(m).fill(inf));
  for (let i = 0; i < n; ++i) {
    for (let j = 0; j < m; ++j) {
      if (A[i][j] == 1) {
        distance[i][j] = 0;
        q.enqueue(new node(i, j));
      }
    }
  }
  let x, y;
  while (!q.isEmpty()) {
    x = q.peek().first;
    y = q.peek().second;
    q.dequeue();
    let dx, dy;
    for (let k = 0; k < 4; ++k) {
      dx = x + dir[k][0];
      dy = y + dir[k][1];
      if (dx >= 0 && dx < n && dy >= 0 && dy < m &&
        distance[dx][dy] > distance[x][y] + 1) {
          distance[dx][dy] = distance[x][y] + 1;
          q.enqueue(new node(dx, dy));
      }
    }
  }
  return distance;
}

module.exports = {
  solve: function (A) {
    return solveit(A);
  },
};
```
* * Solution in C++
```cpp
const int inf = 99999999;
int dir[][2]={{0,1},{1,0},{0,-1},{-1,0}};

vector < vector < int > > solveit(vector < vector < int > > A) {
  int n = A.size();
  int m = A[0].size();
  queue < pair < int, int > > q;
  vector < vector < int > > distance(n, vector < int > (m, inf));
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      if (A[i][j] == 1) {
        distance[i][j] = 0;
        q.push({i, j});
      }
    }
  }
  assert(q.empty() == false);
  int x, y;
  while (!q.empty()) {
    x = q.front().first;
    y = q.front().second;
    q.pop();
    int dx, dy;
    for (int k = 0; k < 4; ++k) {
      dx = x + dir[k][0];
      dy = y + dir[k][1];
      if (dx >= 0 && dx < n && dy >= 0 && dy < m && distance[dx][dy] > distance[x][y] + 1) {
        distance[dx][dy] = distance[x][y] + 1;
        q.push({dx, dy});
      }
    }
  }
  return distance;
}

vector < vector < int > > Solution::solve(vector < vector < int > > & A) {
  return solveit(A);
}
```

