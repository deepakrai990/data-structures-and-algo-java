### Q3. Capture Regions on Board
#### Problem Description
```text
Given a 2-D board A of size N x M containing 'X' and 'O', capture all regions 
surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.
```
#### Problem Constraints
```text
1 <= N, M <= 1000
```
#### Input Format
```text
First and only argument is a N x M character matrix A.
```
#### Output Format
```text
Make changes to the the input only as matrix is passed by reference.
```
#### Example Input
```text
Input 1:

 A = [ 
       [X, X, X, X],
       [X, O, O, X],
       [X, X, O, X],
       [X, O, X, X] 
     ]

Input 2:

 A = [
       [X, O, O],
       [X, O, X],
       [O, O, O]
     ]
```
#### Example Output
```text
Output 1:

 After running your function, the board should be:
 A = [
       [X, X, X, X],
       [X, X, X, X],
       [X, X, X, X],
       [X, O, X, X]
     ]

Output 2:

 After running your function, the board should be:
 A = [
       [X, O, O],
       [X, O, X],
       [O, O, O]
     ]
```
#### Example Explanation
```text
Explanation 1:
    O in (4,2) is not surrounded by X from below.

Explanation 2:
    No O's are surrounded.
```
### Hints
* Hint 1
```text
Note that all the chunks of O which remain as O are the ones which have 
at least one O connected to them which is on the boundary. Otherwise they will turn into X.

Think of graph traversal.
```
* Solution Approach
```text
We already know chunks of O which remain as O are the ones which have at least one O 
connected to them which is on the boundary.

Use BFS starting from ‘O’s on the boundary and mark them as ‘B’, then iterate over 
the whole board and mark ‘O’ as ‘X’ and ‘B’ as ‘O’.

Note: Don’t return any matrix. Do the changes in the given matrix.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
  private boolean[][] marked;
  private int di[] = new int[] {1, -1, 0, 0};
  private int dj[] = new int[] {0, 0, 1, -1};
  private int m, n;
  private ArrayList < ArrayList < Character >> A;

  public void solve(ArrayList < ArrayList < Character >> A) {
    if (A == null)
      return;
    m = A.size();
    n = A.get(0).size();
    if (m == 0)
      return;

    marked = new boolean[m][n];
    this.A = A;

    // First and last row
    for (int i = 0; i < n; i++) {
      char c = A.get(0).get(i);
      if (c == 'O')
        dfs(0, i);
      c = A.get(m - 1).get(i);
      if (c == 'O')
        dfs(m - 1, i);
    }

    // First and last column
    for (int i = 0; i < m; i++) {
      char c = A.get(i).get(0);
      if (c == 'O')
        dfs(i, 0);
      c = A.get(i).get(n - 1);
      if (c == 'O')
        dfs(i, n - 1);
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!marked[i][j])
          A.get(i).set(j, 'X');
      }
    }

  }

  public void dfs(int row, int col) {

    marked[row][col] = true;
    int nRow, nCol;

    for (int k = 0; k < 4; k++) {
      nRow = row + di[k];
      nCol = col + dj[k];

      if (isValid(nRow, nCol) && !marked[nRow][nCol] && A.get(nRow).get(nCol) == 'O') {
        dfs(nRow, nCol);
      }
    }

  }

  private boolean isValid(int row, int col) {
    if (row < 0 || row >= m || col < 0 || col >= n)
      return false;

    return true;
  }
}
```
* * Solution in Javascript
```javascript
class node {
  constructor(a, b) {
    this.first = a;
    this.second = b;
  }
}
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

String.prototype.replaceAt = function (index, replacement) {
  return (
    this.substr(0, index) +
    replacement +
    this.substr(index + replacement.length)
  );
};
function bfsBoundary(board, w, l) {
  let width = board.length;
  let length = board[0].length;
  let q = new Queue();
  q.enqueue(new node(w, l));
  board[w] = board[w].replaceAt(l, "B");
  while (!q.isEmpty()) {
    let cur = q.dequeue();
    let adjs = [
      new node(cur.first - 1, cur.second),
      new node(cur.first + 1, cur.second),
      new node(cur.first, cur.second - 1),
      new node(cur.first, cur.second + 1),
    ];
    for (let i = 0; i < 4; ++i) {
      let adjW = adjs[i].first;
      let adjL = adjs[i].second;
      if (
        adjW >= 0 &&
        adjW < width &&
        adjL >= 0 &&
        adjL < length &&
        board[adjW][adjL] == "O"
      ) {
        q.enqueue(new node(adjW, adjL));
        // board[adjW][adjL] = 'B';
        board[adjW] = board[adjW].replaceAt(adjL, "B");
      }
    }
  }
}

module.exports = {
  /**
   * param A: list of string
   * return: list of string
   */
  solve: function (board) {
    let width = board.length;
    if (width == 0) return;
    let length = board[0].length;
    if (length == 0) return;

    for (let i = 0; i < length; ++i) {
      if (board[0][i] == "O") bfsBoundary(board, 0, i);

      if (board[width - 1][i] == "O") bfsBoundary(board, width - 1, i);
    }

    for (let i = 0; i < width; ++i) {
      if (board[i][0] == "O") bfsBoundary(board, i, 0);
      if (board[i][length - 1] == "O") bfsBoundary(board, i, length - 1);
    }

    for (let i = 0; i < width; ++i) {
      for (let j = 0; j < length; ++j) {
        if (board[i][j] == "O") board[i] = board[i].replaceAt(j, "X");
        else if (board[i][j] == "B") board[i] = board[i].replaceAt(j, "O");
      }
    }
    return board;
  },
};
```
* * Solution in C++
```cpp
void bfsBoundary(vector < vector < char > > & board, int w, int l) {
    int width = board.size();
    int length = board[0].size();
    deque < pair < int, int > > q;
    q.push_back(make_pair(w, l));
    board[w][l] = 'B';
    while (!q.empty()) {
        pair < int, int > cur = q.front();
        q.pop_front();
        pair < int, int > adjs[4] = {
            {
                cur.first - 1, cur.second
            },
            {
                cur.first + 1,
                cur.second
            },
            {
                cur.first,
                cur.second - 1
            },
            {
                cur.first,
                cur.second + 1
            }
        };
        for (int i = 0; i < 4; ++i) {
            int adjW = adjs[i].first;
            int adjL = adjs[i].second;
            if ((adjW >= 0) && (adjW < width) && (adjL >= 0) &&
                (adjL < length) &&
                (board[adjW][adjL] == 'O')) {
                q.push_back(make_pair(adjW, adjL));
                board[adjW][adjL] = 'B';
            }
        }
    }
}

void Solution::solve(vector < vector < char > > & board) {
    int width = board.size();
    if (width == 0)
        return;
    int length = board[0].size();
    if (length == 0)
        return;

    for (int i = 0; i < length; ++i) {
        if (board[0][i] == 'O')
            bfsBoundary(board, 0, i);

        if (board[width - 1][i] == 'O')
            bfsBoundary(board, width - 1, i);
    }

    for (int i = 0; i < width; ++i) {
        if (board[i][0] == 'O')
            bfsBoundary(board, i, 0);
        if (board[i][length - 1] == 'O')
            bfsBoundary(board, i, length - 1);
    }

    for (int i = 0; i < width; ++i) {
        for (int j = 0; j < length; ++j) {
            if (board[i][j] == 'O')
                board[i][j] = 'X';
            else if (board[i][j] == 'B')
                board[i][j] = 'O';
        }
    }
}
```

