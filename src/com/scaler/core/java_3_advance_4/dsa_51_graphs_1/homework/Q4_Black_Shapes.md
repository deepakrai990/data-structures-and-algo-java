### Q4. Black Shapes
#### Problem Description
```text
Given character matrix A of O's and X's, where O = white, X = black.

Return the number of black shapes. A black shape consists of one or more 
adjacent X's (diagonals not included)
```
#### Problem Constraints
```text
1 <= |A|,|A[0]| <= 1000

A[i][j] = 'X' or 'O'
```
#### Input Format
```text
The First and only argument is character matrix A.
```
#### Output Format
```text
Return a single integer denoting number of black shapes.
```
#### Example Input
```text
Input 1:
 A = [ [X, X, X], [X, X, X], [X, X, X] ]

Input 2:
 A = [ [X, O], [O, X] ]
```
#### Example Output
```text
Output 1:
 1

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
    All X's belong to single shapes

Explanation 2:
    Both X's belong to different shapes
```
### Hints
* Hint 1
```text
You need to find number of different connected components here. Any graph traversal algorithm can do this.
You can always use both DFS and BFS to see the working of both of these traversal algorithms.
They will always help you solve such type of problems.
```
* Solution Approach
```text
Simple graph traversal approach:


Answer := 0
Loop i = 1 to N :
    Loop j = 1 to M:
          IF MATRIX at i, j equal to 'X' and not visited:
                 BFS/DFS to mark the connected area as visited
                 update Answer
    EndLoop
EndLoop

return Answer

You can always use both DFS and BFS to see the working of both of these traversal algorithms.
They will always help you solve such type of problems.



Time Complexity : O(N*M)
Space Complexity : O(N*M)

```
* Complete Solution
* * Solution in Java
```java
public class Solution {
  private int count = 0;
  private boolean marked[][];
  private int di[] = new int[] {1, -1, 0, 0};
  private int dj[] = new int[] {0, 0, 1, -1};
  private ArrayList < String > A;

  public int black(ArrayList < String > A) {
    int m, n;

    if (A == null)
      return 0;

    m = A.size();
    n = A.get(0).length();

    marked = new boolean[m][n];
    count = 0;
    this.A = A;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!marked[i][j] && A.get(i).charAt(j) == 'X') {
          dfs(i, j, m, n);
          count++;
        }
      }
    }
    return count;
  }

  public void dfs(int i, int j, int m, int n) {
    marked[i][j] = true;
    for (int k = 0; k < 4; k++) {
      int ii = i + di[k];
      int jj = j + dj[k];
      if (isValid(ii, jj, m, n) && !marked[ii][jj]) {
        dfs(ii, jj, m, n);
      }
    }
  }

  public boolean isValid(int i, int j, int m, int n) {

    if (i < 0 || i >= m || j < 0 || j >= n)
      return false;

    if (A.get(i).charAt(j) != 'X')
      return false;

    return true;
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

class Node {
  constructor(x, y) {
    this.first = x;
    this.second = y;
  }
}

String.prototype.replaceAt = function (index, replacement) {
  return (
    this.substr(0, index) +
    replacement +
    this.substr(index + replacement.length)
  );
};
let dx = [1, -1, 0, 0];
let dy = [0, 0, 1, -1];
let N;
let M;
function is_valid(x, y) {
  if (x < 0 || x >= N || y < 0 || y >= M) return false;
  return true;
}

function bfs(i, j, Vec) {
  let Que = new Queue();
  Que.enqueue(new Node(i, j));

  while (!Que.isEmpty()) {
    let P = Que.dequeue();
    Vec[P.first] = Vec[P.first].replaceAt(P.second, "O");
    for (let i = 0; i < 4; ++i) {
      let x = P.first + dx[i];
      let y = P.second + dy[i];
      if (is_valid(x, y) && Vec[x][y] == "X") {
        Que.enqueue(new Node(x, y));
      }
    }
  }
}

module.exports = {
  black: function (A) {
    let Vec = [];
    Vec = A;
    N = Vec.length;
    M = Vec[0].length;
    let cnt = 0;
    for (let i = 0; i < N; ++i) {
      for (let j = 0; j < M; ++j) {
        if (Vec[i][j] == "X") {
          cnt++;
          bfs(i, j, Vec);
        }
      }
    }
    return cnt;
  },
};
```
* * Solution in C++
```cpp
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
int N;
int M;
bool is_valid(int x, int y) {
  if (x < 0 || x >= N || y < 0 || y >= M)
    return false;
  return true;
}

void bfs(int i, int j, vector < string > & Vec) {
  queue < pair < int, int > > Que;
  Que.push(make_pair(i, j));

  while (!Que.empty()) {
    pair < int, int > P = Que.front();
    Que.pop();
    Vec[P.first][P.second] = 'O';
    for (int i = 0; i < 4; ++i) {
      int x = P.first + dx[i];
      int y = P.second + dy[i];
      if (is_valid(x, y) && Vec[x][y] == 'X') {
        Que.push(make_pair(x, y));
      }
    }
  }
}

int Solution::black(vector < string > & A) {
  vector < string > Vec;
  Vec = A;
  N = Vec.size();
  M = Vec[0].size();
  int cnt = 0;
  for (int i = 0; i < N; ++i) {
    for (int j = 0; j < M; ++j) {
      if (Vec[i][j] == 'X') {
        cnt++;
        bfs(i, j, Vec);
      }
    }
  }
  return cnt;
}
```

