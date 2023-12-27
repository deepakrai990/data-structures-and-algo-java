### Q1. Dijsktra
#### Problem Description
```text
Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.

You have to find an integer array D of size A such that:

=> D[i] : Shortest distance form the C node to node i.

=> If node i is not reachable from C then -1.

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables 
make sure to clear them.
```
#### Problem Constraints
```text
1 <= A <= 1e5

0 <= B[i][0],B[i][1] < A

0 <= B[i][2] <= 1e3

0 <= C < A
```
#### Input Format
```text
The first argument given is an integer A, representing the number of nodes.

The second argument given is the matrix B of size M x 3, where nodes B[i][0] 
and B[i][1] are connected with an edge of weight B[i][2].

The third argument given is an integer C.
```
#### Output Format
```text
Return the integer array D.
```
#### Example Input
```text
Input 1:

A = 6
B = [   [0, 4, 9]
        [3, 4, 6] 
        [1, 2, 1] 
        [2, 5, 1] 
        [2, 4, 5] 
        [0, 3, 7] 
        [0, 1, 1] 
        [4, 5, 7] 
        [0, 5, 1] ] 
C = 4

Input 2:

A = 5
B = [   [0, 3, 4]
        [2, 3, 3] 
        [0, 1, 9] 
        [3, 4, 10] 
        [1, 3, 8]  ] 
C = 4
```
#### Example Output
```text
Output 1:
 D = [7, 6, 5, 6, 0, 6]

Output 2:
 D = [14, 18, 13, 10, 0]
```
#### Example Explanation
```text
Explanation 1:
    All Paths can be considered from the node C to get shortest path

Explanation 2:
    All Paths can be considered from the node C to get shortest path
```
### Hints
* Hint 1
```text
You need to use a shortest path algorithm to solve this.
What better algorithm than Dijkstra.
```
* Solution Approach
```text
Initialize a distance array of integers(denoting distance of source to node i) with infinity.
Initialize d[source]=0 (distance from source to source is 0).
Insert {d[source],source} into a min heap based on distance.
extract first element from the heap:
if this element is mark visited then again start extract top element fro heap
else mark this as vis and expore adjacent nodes of the top node of the heap:
if distance[adjacentnode]>distance[curr]+weight of the edge between curr and adjacent node
update distacne[adjacentnode] = distance[curr]+weight of the edge between curr and 
adjacent node insert this node alongwith weight into minheap.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int maxn = 100009;
    static int[] vis = new int[maxn];
    static ArrayList < ArrayList < Pair > > adj;
    public static void graph() {
        adj = new ArrayList < ArrayList < Pair > > (maxn);
        for (int i = 0; i < maxn; i++) {
            vis[i] = 0;
            adj.add(new ArrayList < Pair > ());
        }
    }
    public int[] solve(int A, int[][] B, int C) {
        graph();
        for (int[] edge: B) {
            adj.get(edge[0]).add(new Pair(edge[2], edge[1]));
            adj.get(edge[1]).add(new Pair(edge[2], edge[0]));
        }
        return dijkstra(A, C);
    }

    public static int[] dijkstra(int n, int source) {
        PriorityQueue < Pair > pq = new PriorityQueue < Pair > (new CustomComp());
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;
        pq.offer(new Pair(0, source));

        while (pq.size() != 0) {
            Pair temp = pq.poll();
            int u = temp.b;
            if (vis[u] == 1)
                continue;
            vis[u] = 1;
            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i).b, w = adj.get(u).get(i).a;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Pair(dist[v], v));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }
}
class Pair {
    int a, b;
    public Pair(int u, int v) {
        this.a = u;
        this.b = v;
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
let g = new Array(100005);
let vis = new Array(100005);
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

function clean(n) {
    for (let i = 0; i <= n; ++i) {
        g[i] = [];
        vis[i] = 0;
    }
}

function make_graph(edges) {
    for (let i = 0; i < edges.length; i++) {
        let it = edges[i];
        let x = it[0];
        let y = it[1];
        let w = it[2];
        g[x].push([w, y]);
        g[y].push([w, x]);
    }
}
module.exports = {
    //param A : integer
    //param B : array of array of integers
    //param C : integer
    //return a array of integers
    solve: function (n, edges, source) {
        clean(n);
        make_graph(edges);
        let distance = new Array(n).fill(Infinity);
        let q = new PriorityQueue();
        distance[source] = 0;
        q.push([0, source]);
        while (q.size() > 0) {
            let p = q.pop();
            let x = p[1];
            if (vis[x] == 1)
                continue;
            vis[x] = 1;
            for (let i = 0; i < g[x].length; ++i) {
                let y = g[x][i][1];
                let w = g[x][i][0];
                if (distance[x] + w < distance[y]) {
                    distance[y] = distance[x] + w;
                    q.push([distance[y], y]);
                }
            }
        }
        for (let i = 0; i < n; ++i) {
            if (distance[i] == Infinity)
                distance[i] = -1;
        }
        return distance;
    }
};
```
* * Solution in C++
```cpp
#define pi pair < int, int >
const int N = 100005;
vector < pi > g[N];
int vis[N];
const int inf = 1000000000;

void clean(int n) {
    for (int i = 0; i <= n; ++i) {
        g[i].clear();
        vis[i] = 0;
    }
}

void make_graph(vector < vector < int > > & edges) {
    for (auto & it: edges) {
        int x = it[0];
        int y = it[1];
        int w = it[2];
        g[x].push_back(make_pair(w, y));
        g[y].push_back(make_pair(w, x));
    }
}

vector < int > dijsktra(int n, vector < vector < int > > & edges, int source) {
    clean(n);
    make_graph(edges);
    vector < int > distance(n, inf);
    priority_queue < pi, vector < pi > , greater < pi > > q;
    distance[source] = 0;
    q.push(make_pair(0, source));
    while (!q.empty()) {
        pi p = q.top();
        int x = p.second;
        q.pop();
        if (vis[x])
            continue;
        vis[x] = 1;
        for (int i = 0; i < g[x].size(); ++i) {
            int y = g[x][i].second;
            int w = g[x][i].first;
            if (distance[x] + w < distance[y]) {
                distance[y] = distance[x] + w;
                q.push(make_pair(distance[y], y));
            }
        }
    }
    for (int i = 0; i < n; ++i) {
        if (distance[i] == inf)
            distance[i] = -1;
    }
    return distance;
}

vector < int > Solution::solve(int A, vector < vector < int > > & B, int C) {
    return dijsktra(A, B, C);
}
```

