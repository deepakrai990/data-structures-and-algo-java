### Q2. Shortest Distance in a Maze
#### Problem Description
```text
Given a matrix of integers A of size N x M describing a maze. The maze consists of 
empty locations and walls.

1 represents a wall in a matrix and 0 represents an empty location in a wall.

There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, 
down, left or right, but it won't stop rolling until hitting a wall (maze boundary is 
also considered as a wall). When the ball stops, it could choose the next direction.

Given two array of integers of size B and C of size 2 denoting the starting and 
destination position of the ball.

Find the shortest distance for the ball to stop at the destination. The distance is 
defined by the number of empty spaces traveled by the ball from the starting 
position (excluded) to the destination (included). If the ball cannot stop at the 
destination, return -1.
```
#### Problem Constraints
```text
2 <= N, M <= 100

0 <= A[i] <= 1

0 <= B[i][0], C[i][0] < N

0 <= B[i][1], C[i][1] < M
```
#### Input Format
```text
The first argument given is the integer matrix A.

The second argument given is an array of integer B.

The third argument if an array of integer C.
```
#### Output Format
```text
Return a single integer, the minimum distance required to reach destination
```
#### Example Input
```text
Input 1:
 A = [ [0, 0], [0, 0] ]
 B = [0, 0]
 C = [0, 1]

Input 2:
 A = [ [0, 0], [0, 1] ]
 B = [0, 0]
 C = [0, 1]
```
#### Example Output
```text
Output 1:
 1

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    Go directly from start to destination in distance 1.

Explanation 2:
    Go directly from start to destination in distance 1.
```
### Hints
* Hint 1
```text
We can observe that the ball will roll until it hits a wall. How can we use this to 
reach some conclusions?

We can definitely say that ball will roll only in one of 4 directions, this gives us 
only 4 options for each place.
```
* Solution Approach
```text
We can definitely say that ball will roll only in one of 4 directions, this gives us 
only 4 options for each place.

This points towards a BFS based solution.

From the starting point as the source node, we will start a Grid BFS based simulation.

We will try to go all 4 directions from each point, following through in each 
direction till we hit a hurdle.

The BFS continues till we have exhausted all our choices or have reached our destination.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int maxn = 100009;
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, -1, 1 };
    public static boolean inside(int x, int y, int n, int m) {
        return (x >= 0 && x <= n - 1 && y >= 0 && y <= m - 1);
    }
    public int solve(int[][] A, int[] B, int[] C) {
        return findMinDist(A, B, C);
    }
    public static int findMinDist(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        int sx = start[0];
        int sy = start[1];
        int ex = destination[0];
        int ey = destination[1];
        int[][] v = new int[n][m];
        for (int[] row: v)
            Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue < Pair > pq = new PriorityQueue < Pair > (new CustomComp());
        int i;
        int d, d1;
        int x, y;
        int x1, y1;
        int x2, y2;
        pq.offer(new Pair(0, sx, sy));
        while (pq.size() != 0 && v[ex][ey] == Integer.MAX_VALUE) {
            Pair temp = pq.poll();
            x = temp.b;
            y = temp.c;
            d = temp.a;
            if (v[x][y] != Integer.MAX_VALUE) {
                continue;
            } else {
                v[x][y] = d;
            }
            for (i = 0; i < 4; ++i) {
                x1 = x;
                y1 = y;
                d1 = 0;
                while (true) {
                    x2 = x1 + dx[i];
                    y2 = y1 + dy[i];
                    if (inside(x2, y2, n, m) == true && maze[x2][y2] == 0) {
                        x1 = x2;
                        y1 = y2;
                        ++d1;
                    } else {
                        break;
                    }
                }
                if (d1 > 0 && v[x1][y1] == Integer.MAX_VALUE) {
                    pq.offer(new Pair(d + d1, x1, y1));
                }
            }
        }
        int res = -1;
        if (v[ex][ey] != Integer.MAX_VALUE)
            res = v[ex][ey];
        return res;
    }
}
class Pair {
    int a, b, c;
    public Pair(int u, int v, int w) {
        this.a = u;
        this.b = v;
        this.c = w;
    }
}
class CustomComp implements Comparator < Pair > {
    @Override
    public int compare(Pair aa, Pair bb) {
        return aa.a - bb.a;
    }
}
```
* * Solution in Javascript
```javascript
const top = 0;
const parent = i => ((i + 1) >>> 1) - 1;
const left = i => (i << 1) + 1;
const right = i => (i + 1) << 1;
class PriorityQueue {
    constructor(comparator = (a, b) => a[0] < b[0]) {
        this._heap = [];
        this._comparator = comparator;
    }
    size() {
        return this._heap.length;
    }
    isEmpty() {
        return this.size() == 0;
    }
    peek() {
        return this._heap[top];
    }
    push(...values) {
        values.forEach(value => {
            this._heap.push(value);
            this._siftUp();
        });
        return this.size();
    }
    pop() {
        const poppedValue = this.peek();
        const bottom = this.size() - 1;
        if (bottom > top) {
            this._swap(top, bottom);
        }
        this._heap.pop();
        this._siftDown();
        return poppedValue;
    }
    replace(value) {
        const replacedValue = this.peek();
        this._heap[top] = value;
        this._siftDown();
        return replacedValue;
    }
    _greater(i, j) {
        return this._comparator(this._heap[i], this._heap[j]);
    }
    _swap(i, j) {
        [this._heap[i], this._heap[j]] = [this._heap[j], this._heap[i]];
    }
    _siftUp() {
        let node = this.size() - 1;
        while (node > top && this._greater(node, parent(node))) {
            this._swap(node, parent(node));
            node = parent(node);
        }
    }
    _siftDown() {
        let node = top;
        while (
            (left(node) < this.size() && this._greater(left(node), node)) ||
            (right(node) < this.size() && this._greater(right(node), node))
        ) {
            let maxChild = (right(node) < this.size() && this._greater(right(node), left(node))) ? right(node) : left(node);
            this._swap(node, maxChild);
            node = maxChild;
        }
    }
}
const maxn = 100009;
let dx = [-1, 1, 0, 0];
let dy = [0, 0, -1, 1];

function inside(x, y, n, m) {
    return (x >= 0 && x <= n - 1 && y >= 0 && y <= m - 1);
}
module.exports = {
    //param A : array of array of integers
    //param B : array of integers
    //param C : array of integers
    //return an integer
    solve: function (maze, start, destination) {
        let n = maze.length;
        let m = maze[0].length;
        let sx = start[0];
        let sy = start[1];
        let ex = destination[0];
        let ey = destination[1];
        let v = new Array(n);
        for (let i = 0; i < n; i++) {
            v[i] = new Array(m).fill(Infinity);
        }
        let pq = new PriorityQueue();
        let i;
        let d, d1;
        let x, y;
        let x1, y1;
        let x2, y2;
        pq.push([0, sx, sy]);

        while (pq.size() != 0 && v[ex][ey] == Infinity) {
            let temp = pq.pop();
            x = temp[1];
            y = temp[2];
            d = temp[0];
            if (v[x][y] != Infinity) {
                continue;
            } else {
                v[x][y] = d;
            }

            for (i = 0; i < 4; ++i) {
                x1 = x;
                y1 = y;
                d1 = 0;
                while (true) {
                    x2 = x1 + dx[i];
                    y2 = y1 + dy[i];
                    if (inside(x2, y2, n, m) == true && maze[x2][y2] == 0) {
                        x1 = x2;
                        y1 = y2;
                        ++d1;
                    } else {
                        break;
                    }
                }
                if (d1 > 0 && v[x1][y1] == Infinity) {
                    pq.push([d + d1, x1, y1]);
                }
            }
        }
        let res = -1;
        if (v[ex][ey] != Infinity)
            res = v[ex][ey];
        return res;
    }
};
```
* * Solution in C++
```cpp
const int dir[][2] = {
    { -1, 0 },
    { 1, 0 },
    { 0, -1 },
    { 0, 1 } };

bool inside(int x, int y, int n, int m) {
    return (x >= 0 && x <= n - 1 && y >= 0 && y <= m - 1);
}

struct Grid {
    int x, y;
    int d;
    Grid(int _x = 0, int _y = 0, int _d = 0): x(_x), y(_y), d(_d) {};
    bool operator < (const Grid & g) const {
        return d > g.d;
    }
};

int findMinimumDistance(vector < vector < int >> & maze, vector < int > & start, vector < int > & destination) {
    auto & a = maze;
    int n = a.size();
    int m = a[0].size();
    int sx = start[0];
    int sy = start[1];
    int ex = destination[0];
    int ey = destination[1];
    vector < vector < int >> v(n, vector < int > (m, INT_MAX));
    priority_queue < Grid > pq;
    int i;
    int d, d1;
    int x, y;
    int x1, y1;
    int x2, y2;
    pq.push(Grid(sx, sy, 0));
    while (!pq.empty() && v[ex][ey] == INT_MAX) {
        x = pq.top().x;
        y = pq.top().y;
        d = pq.top().d;
        pq.pop();
        if (v[x][y] != INT_MAX) {
            continue;
        } else {
            v[x][y] = d;
        }
        for (i = 0; i < 4; ++i) {
            x1 = x;
            y1 = y;
            d1 = 0;
            while (true) {
                x2 = x1 + dir[i][0];
                y2 = y1 + dir[i][1];
                if (inside(x2, y2, n, m) && a[x2][y2] == 0) {
                    x1 = x2;
                    y1 = y2;
                    ++d1;
                } else {
                    break;
                }
            }
            if (d1 > 0 && v[x1][y1] == INT_MAX) {
                pq.push(Grid(x1, y1, d + d1));
            }
        }
    }
    while (!pq.empty()) {
        pq.pop();
    }
    int res = (v[ex][ey] != INT_MAX ? v[ex][ey] : -1);
    v.clear();
    return res;
}

int Solution::solve(vector < vector < int > > & A, vector < int > & B, vector < int > & C) {
    return findMinimumDistance(A, B, C);
}
```

