### Q3. Matrix and Absolute Difference
#### Problem Description
```text
Given a matrix C of integers, of dimension A x B.

For any given K, you are not allowed to travel between cells that have an absolute 
difference greater than K.

Return the minimum value of K such that it is possible to travel between any pair of 
cells in the grid through a path of adjacent cells.

NOTE:
    * Adjacent cells are those cells that share a side with the current cell.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A, B &lt;= 10<sup>2</sup></p>
    <p>1 &lt;= C[i][j] &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= A, B <= 10^2

1 <= C[i][j] <= 10^9
```
#### Input Format
```text
The first argument given is A.

The second argument give is B.

The third argument given is the integer matrix C.
```
#### Output Format
```text
Return a single integer, the minimum value of K.
```
#### Example Input
```text
Input 1:

 A = 3
 B = 3
 C = [  [1, 5, 6]
        [10, 7, 2]
        [3, 6, 9]   ]
```
#### Example Output
```text
Output 1:
 4
```
#### Example Explanation
```text
Explanation 1:
    It is possible to travel between any pair of cells through a path of adjacent 
    cells that do not have an absolute difference in value 
    greater than 4. e.g. : A path from (0, 0) to (2, 2) may look like this:
    => (0, 0) -> (0, 1) -> (1, 1) -> (2, 1) -> (2, 2)
```
### Hints
* Hint 1
```text
Think of matrix as a graph with A*B nodes and Each node has an edge to its four 
neighbouring cells with weight as absolute difference of values between them.

Apply any MST algorithm on it and find the maximum weighted edge in that MST.
```
* Solution Approach
```text
Think of matrix as a graph with A*B nodes and Each node has an edge to its four 
neighbouring cells with weight as absolute difference of values between them.

Apply any MST algorithm on it and find the maximum weighted edge in that MST.

Why we have to apply MST?
Because in MST we always consider smallest weighted edge as to minimize the total 
cost so just find mst and find the maximum weighted edge in that MST.

You can use any of Kruskal or Prims Implementation of MST to solve this question.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int maxn = 10009;
    static ArrayList < ArrayList < Pair > > adj;
    static int[] visited = new int[maxn];
    public int solve(int A, int B, int[][] C) {
        adj = new ArrayList < ArrayList < Pair > > (maxn);
        for (int i = 0; i < maxn; i++) {
            adj.add(new ArrayList < Pair > ());
            visited[i] = 0;
        }
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                int u = i * B + j;
                if (i + 1 < A) {
                    int v = (i + 1) * B + j;
                    int w = Math.abs(C[i][j] - C[i + 1][j]);
                    adj.get(u).add(new Pair(v, w));
                    adj.get(v).add(new Pair(u, w));
                }
                if (j + 1 < B) {
                    int v = i * B + (j + 1);
                    int w = Math.abs(C[i][j] - C[i][j + 1]);
                    adj.get(u).add(new Pair(v, w));
                    adj.get(v).add(new Pair(u, w));
                }
            }
        }
        return prims();
    }
    public static int prims() {
        PriorityQueue < Pair > pq = new PriorityQueue < Pair > (new CustomComp());
        pq.offer(new Pair(0, 0));
        int maxe = 0;
        while (pq.size() > 0) {
            Pair temp = pq.poll();
            if (visited[temp.b] > 0) continue;
            visited[temp.b] = 1;
            maxe = Math.max(maxe, temp.a);
            for (Pair p: adj.get(temp.b)) {
                if (visited[p.a] > 0) continue;
                pq.offer(new Pair(p.b, p.a));
            }
        }
        return maxe;
    }
}
class Pair {
    int a;
    int b;
    public Pair(int c, int d) {
        this.a = c;
        this.b = d;
    }
}
class CustomComp implements Comparator < Pair > {
    @Override
    public int compare(Pair aa, Pair b) {
        return aa.a - b.a;
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
const maxn = 10009;
let adj = new Array(maxn);
let visited = new Array(maxn);

function prims() {
    let pq = new PriorityQueue();
    pq.push([0, 0]);
    let maxe = 0;
    while (pq.size() > 0) {
        let temp = pq.pop();
        if (visited[temp[1]])
            continue;
        visited[temp[1]] = 1;
        maxe = Math.max(maxe, temp[0]);
        for (let i = 0; i < adj[temp[1]].length; i++) {
            let p = adj[temp[1]][i];
            if (visited[p[0]])
                continue;
            pq.push([p[1], p[0]]);
        }
    }
    return maxe;
}
module.exports = {
    //param A : integer
    //param B : integer
    //param C : array of array of integers
    //return an integer
    solve: function (A, B, C) {
        visited.fill(0);
        for (let i = 0; i < maxn; i++)
            adj[i] = [];
        for (let i = 0; i < A; i++) {
            for (let j = 0; j < B; j++) {
                let u = i * B + j;
                if (i + 1 < A) {
                    let v = (i + 1) * B + j;
                    let w = Math.abs(C[i][j] - C[i + 1][j]);
                    adj[u].push([v, w]);
                    adj[v].push([u, w]);
                }
                if (j + 1 < B) {
                    let v = i * B + (j + 1);
                    let w = Math.abs(C[i][j] - C[i][j + 1]);
                    adj[u].push([v, w]);
                    adj[v].push([u, w]);
                }
            }
        }
        return prims();
    }
};
```
* * Solution in C++
```cpp
#define pi pair < int, int >
#define ff first
#define pb push_back
#define ss second
const int maxn = 10009;
vector < pi > adj[maxn];
int visited[maxn];
int prims() {
    priority_queue < pi, vector < pi > , greater < pi > > pq;
    pq.push({ 0, 0 });
    int maxe = 0;
    while (pq.empty() == false) {
        pi temp = pq.top();
        pq.pop();
        if (visited[temp.ss]) continue;
        visited[temp.ss] = 1;
        maxe = max(maxe, temp.ff);
        for (pi p: adj[temp.ss]) {
            if (visited[p.ff]) continue;
            pq.push({
                p.ss,
                p.ff
            });
        }
    }
    return maxe;
}
int Solution::solve(int A, int B, vector < vector < int > > & C) {
    memset(visited, 0, sizeof(visited));
    for (int i = 0; i < maxn; i++) adj[i].clear();
    for (int i = 0; i < A; i++) {
        for (int j = 0; j < B; j++) {
            int u = i * B + j;
            if (i + 1 < A) {
                int v = (i + 1) * B + j;
                int w = abs(C[i][j] - C[i + 1][j]);
                adj[u].pb({ v, w });
                adj[v].pb({ u, w });
            }
            if (j + 1 < B) {
                int v = i * B + (j + 1);
                int w = abs(C[i][j] - C[i][j + 1]);
                adj[u].pb({ v, w });
                adj[v].pb({ u, w });
            }
        }
    }
    return prims();
}
```

