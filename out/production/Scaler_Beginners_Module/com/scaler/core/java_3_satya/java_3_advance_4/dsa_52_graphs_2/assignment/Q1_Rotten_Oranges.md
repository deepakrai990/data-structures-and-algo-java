### Q1. Rotten Oranges
#### Problem Description
```text
Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a 
rotten orange becomes rotten. Return the minimum number of minutes that must elapse 
until no cell has a fresh orange. If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, 
make sure to clear them.
```
#### Problem Constraints
```text
1 <= N, M <= 1000

0 <= A[i][j] <= 2
```
#### Input Format
```text
The first argument given is the integer matrix A.
```
#### Output Format
```text
Return the minimum number of minutes that must elapse until no cell has a fresh orange.

If this is impossible, return -1 instead.
```
#### Example Input
```text
Input 1:
A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]

Input 2:
A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]
```
#### Example Output
```text
Output 1:
 4

Output 2:
 -1
```
#### Example Explanation
```text
Explanation 1:
    Max of 4 using (0,0) , (0,1) , (1,1) , (1,2) , (2,2)

Explanation 2:
    Task is impossible
```
### Hints
* Hint 1
```text
Every turn, the rotting spreads from each rotting orange to other adjacent oranges.
Initially, the rotten oranges have ‘depth’ 0, and every time they rot a neighbor,
the neighbors have 1 more depth. We want to know the largest possible depth.
Think of this as possible solution
```
* Solution Approach
```text
Every turn, the rotting spreads from each rotting orange to other adjacent oranges.
Initially, the rotten oranges have ‘depth’ 0, and every time they rot a neighbor,
the neighbors have 1 more depth. We want to know the largest possible depth.

Use multi-source BFS to achieve this with all cells containing rotten oranges as starting 
nodes.

At the end check if there are fresh oranges left or not.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[][] grid) {
        Queue <int[]> queue = new LinkedList <> ();
        int fresh = 0;
        int time = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] direction = {
            { 1, 0 },
            { 0, 1 },
            {-1, 0 },
            { 0, -1 } };
        while (!queue.isEmpty() && fresh > 0) {
            time++;
            int size = queue.size();
            while (size > 0) {
                int[] bad = queue.poll();
                for (int[] dir: direction) {
                    int nrow = bad[0] + dir[0];
                    int ncol = bad[1] + dir[1];

                    if (nrow < 0 || nrow >= grid.length || ncol < 0 || ncol >= grid[0].length || grid[nrow][ncol] == 2 || grid[nrow][ncol] == 0) {
                        continue;
                    }
                    grid[nrow][ncol] = 2;
                    fresh--;
                    queue.add(new int[] {
                        nrow,
                        ncol
                    });
                }
                size--;
            }
        }

        if (fresh == 0) {
            return time;
        } else
            return -1;
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

let dir = [
  [0, 1],
  [1, 0],
  [-1, 0],
  [0, -1],
];
const inf = 99999999;

function solveit(grid) {
  let n = grid.length;
  let m = grid[0].length;
  let distance = new Array(n).fill(0).map(() => new Array(m).fill(0));
  let q = new Queue();
  for (let i = 0; i < n; ++i) {
    for (let j = 0; j < m; ++j) {
      if (grid[i][j] == 1 || grid[i][j] == 0) distance[i][j] = inf;
      else {
        distance[i][j] = 0;
        q.enqueue([i, j]);
      }
    }
  }
  let x, y;

  while (!q.isEmpty()) {
    let tp = q.dequeue();
    x = tp[0];
    y = tp[1];

    let dx, dy;
    for (let k = 0; k < 4; ++k) {
      dx = x + dir[k][0];
      dy = y + dir[k][1];
      if (
        dx >= 0 &&
        dx < n &&
        dy >= 0 &&
        dy < m &&
        grid[dx][dy] == 1 &&
        distance[x][y] + 1 < distance[dx][dy]
      ) {
        distance[dx][dy] = 1 + distance[x][y];
        q.enqueue([dx, dy]);
      }
    }
  }
  let ans = 0;
  for (let i = 0; i < n; ++i) {
    for (let j = 0; j < m; ++j) {
      if (grid[i][j] == 1) {
        ans = Math.max(ans, distance[i][j]);
      }
    }
  }
  return ans == inf ? -1 : ans;
}

module.exports = {
  solve: function (A) {
    return solveit(A);
  },
};
```
* * Solution in C++
```cpp
int dir[][2] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
const int inf = 99999999;

int solveit(vector < vector < int >> & grid) {
  int n = grid.size();
  int m = grid[0].size();
  int distance[n][m];
  queue < pair < int, int > > q;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      if (grid[i][j] == 1 || grid[i][j] == 0)
        distance[i][j] = inf;
      else {
        distance[i][j] = 0;
        q.push({ i, j });
      }
    }
  }
  int x, y;

  while (!q.empty()) {
    x = q.front().first;
    y = q.front().second;
    q.pop();
    int dx, dy;
    for (int k = 0; k < 4; ++k) {
      dx = x + dir[k][0];
      dy = y + dir[k][1];
      if (dx >= 0 && dx < n && dy >= 0 && dy < m && grid[dx][dy] == 1 && distance[x][y] + 1 < distance[dx][dy]) {
        distance[dx][dy] = 1 + distance[x][y];
        q.push({ dx, dy });
      }
    }
  }
  int ans = 0;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      if (grid[i][j] == 1) {
        ans = max(ans, distance[i][j]);
      }
    }
  }
  return (ans == inf ? -1 : ans);
}

int Solution::solve(vector < vector < int > > & A) {
  return solveit(A);
}
```

