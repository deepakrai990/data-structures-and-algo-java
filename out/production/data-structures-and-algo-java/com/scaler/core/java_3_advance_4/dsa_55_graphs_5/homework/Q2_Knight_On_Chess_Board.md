### Q2. Knight On Chess Board
#### Problem Description
```text
Given any source point, (C, D) and destination point, (E, F) on a chess board 
of size A x B, we need to find whether Knight can move to the destination or not.
```
![alt text](Q2_Knight_On_Chess_Board.jpeg)
```text
The above figure details the movements for a knight ( 8 possibilities ).

If yes, then what would be the minimum number of steps for the knight to move to the 
said point. If knight can not move from the source point to the destination point, 
then return -1.

NOTE: A knight cannot go out of the board.
```
#### Problem Constraints
```text
1 <= A, B <= 500
```
#### Input Format
```text
The first argument of input contains an integer A.
The second argument of input contains an integer B.
The third argument of input contains an integer C.
The fourth argument of input contains an integer D.
The fifth argument of input contains an integer E.
The sixth argument of input contains an integer F.
```
#### Output Format
```text
If it is possible to reach the destination point, return the minimum number of moves.
Else return -1.
```
#### Example Input
```text
Input 1:

 A = 8
 B = 8
 C = 1
 D = 1
 E = 8
 F = 8

Input 2:

 A = 2
 B = 4
 C = 2
 D = 1
 E = 4
 F = 4
```
#### Example Output
```text
Output 1:
 6

Output 2:
 -1
```
#### Example Explanation
```text
Explanation 1:
     The size of the chessboard is 8x8, the knight is initially at (1, 1) and the 
     knight wants to reach position (8, 8).
     
     The minimum number of moves required for this is 6.

Explanation 2:
    It is not possible to move knight to position (4, 4) from (2, 1)
```
### Hints
* Hint 1
```text
Assume this problem as searching in graph where each block of chess board is vertex.
How would you define edges in such a graph ?
When can you travel from vertex i to vertex j ?

Once you have the graph, then it reduces to finding the shortest path in an 
unweighted graph.

How do you find the shortest path in an unweighted graph ?
```
* Solution Approach
```text
A knight can move to 8 positions from (x,y). 

(x, y) -> 
    (x + 2, y + 1)  
    (x + 2, y - 1)
    (x - 2, y + 1)
    (x - 2, y - 1)
    (x + 1, y + 2)
    (x + 1, y - 2)
    (x - 1, y + 2)
    (x - 1, y - 2)

Corresponding to the knight's move, we can define edges. 
(x,y) will have an edge to the 8 neighbors defined above. 

To find the shortest path, we just run a plain BFS. 
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    private static final int dx[] = new int[]{-2, -2, 1, -1, 2, 2, 1, -1};
    private static final int dy[] = new int[]{1, -1, 2, 2, 1, -1, -2, -2};

    public int knight(int N, int M, int x1, int y1, int x2, int y2) {

        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(x1, y1);
        HashSet<Node> marked = new HashSet<>();

        queue.add(node);
        queue.add(null);
        int level = 0;
        marked.add(node);

        while (!queue.isEmpty()) {
            Node n = queue.remove();

            if (n == null) {
                level++;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                continue;
            }

            if (n.x == x2 && n.y == y2)
                return level;

            for (int k = 0; k < 8; k++) {
                int x = n.x + dx[k];
                int y = n.y + dy[k];

                if (isValid(x, y, N, M)) {
                    Node nn = new Node(x, y);
                    if (!marked.contains(nn)) {
                        marked.add(nn);
                        queue.add(nn);
                    }
                }
            }

        }

        return -1;
    }

    public boolean isValid(int x, int y, int N, int M) {
        if (x < 1 || x > N || y < 1 || y > M)
            return false;

        return true;
    }

    class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if (obj.getClass() != getClass())
                return false;
            if (this == obj)
                return true;
            Node node = (Node) obj;
            if (this.x == node.x && this.y == node.y)
                return true;
            return false;
        }

        @Override
        public int hashCode() {
            return (int) ((31 * x + y) & 0x7fffffff);
        }
    }
}
```
* * Solution in Javascript
```javascript
let dx = [2, 2, -2, -2, 1, 1, -1, -1];
let dy = [-1, 1, 1, -1, 2, -2, 2, -2];

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
    constructor(x, y, dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

function valid(x, y, N, M) {
    if (x <= 0 || y <= 0 || x > N || y > M) return false;
    return true;
}

function bfs(p1, p2, p3) {
    let N = p3[0];
    let M = p3[1];
    let Que = new Queue();
    let Vis = new Map();

    let nw = new Node(p1[0], p1[1], 0);
    Que.enqueue(nw);

    while (!Que.isEmpty()) {
        let temp = Que.dequeue();

        if (temp.x == p2[0] && temp.y == p2[1]) return temp.dis;
        let x = temp.x;
        let y = temp.y;
        let dis = temp.dis + 1;

        if (Vis.has(x * M + y)) continue;
        Vis.set(x * M + y, true);

        for (let i = 0; i < 8; ++i) {
            let x1 = x + dx[i];
            let y1 = y + dy[i];
            let psh = new Node(x1, y1, dis);
            if (valid(x1, y1, N, M)) Que.enqueue(psh);
        }
    }
    return -1;
}

module.exports = {
    knight: function (N, M, x1, y1, x2, y2) {
        let p1 = [x1, y1],
            p2 = [x2, y2],
            p3 = [N, M];

        let ans = bfs(p1, p2, p3);
        return ans;
    },
};
```
* * Solution in C++
```cpp
#define pb push_back
#define ff first
#define ss second
#define mpa make_pair

int dx[8] = {2, 2, -2, -2, 1, 1, -1, -1};
int dy[8] = {-1, 1, 1, -1, 2, -2, 2, -2};

bool valid(int x, int y, int N, int M) {
  if (x <= 0 || y <= 0 || x > N || y > M)
    return false;
  return true;
}

int bfs(pair < int, int > p1, pair < int, int > p2, pair < int, int > p3) {
  int N = p3.ff;
  int M = p3.ss;
  queue < pair < pair < int, int > , int > > Que;
  map < pair < int, int > , bool > Vis;

  Que.push(mpa(p1, 0));

  while (!Que.empty()) {
    pair < pair < int, int > , int > temp = Que.front();
    Que.pop();

    if (temp.ff.ff == p2.ff && temp.ff.ss == p2.ss)
      return temp.ss;
    int x = temp.ff.ff;
    int y = temp.ff.ss;
    int dis = temp.ss + 1;

    if (Vis.count(mpa(x, y)))
      continue;
    Vis[mpa(x, y)] = true;

    for (int i = 0; i < 8; ++i) {
      int x1 = x + dx[i];
      int y1 = y + dy[i];
      if (valid(x1, y1, N, M))
        Que.push(mpa(mpa(x1, y1), dis));
    }

  }

  return -1;
}

int Solution::knight(int N, int M, int x1, int y1, int x2, int y2) {
  pair < int, int > p1;
  p1.ff = x1;
  p1.ss = y1;

  pair < int, int > p2;
  p2.ff = x2;
  p2.ss = y2;

  pair < int, int > p3;
  p3.ff = N;
  p3.ss = M;

  int ans = bfs(p1, p2, p3);
  return ans;
}
```

