### Q4. Another BFS
#### Problem Description
```text
iven a weighted undirected graph having A nodes, a source node C and destination node D.

Find the shortest distance from C to D and if it is impossible to reach node D 
from C then return -1.

You are expected to do it in Time Complexity of O(A + M).

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables 
make sure to clear them.
```
#### Problem Constraints
```text
1 <= A <= 10^5

0 <= B[i][0], B[i][1] < A

1 <= B[i][2] <= 2

0 <= C < A

0 <= D < A
```
#### Input Format
```text
The first argument given is an integer A, representing the number of nodes.

The second argument given is the matrix B, where B[i][0] and B[i][1] are connected 
through an edge of weight B[i][2].

The third argument given is an integer C, representing the source node.

The fourth argument is an integer D, representing the destination node.

Note: B[i][2] will be either 1 or 2.
```
#### Output Format
```text
Return the shortest distance from C to D. If it is impossible to reach node D from C 
then return -1.
```
#### Example Input
```text
Input 1:

 A = 6
 B = [   [2, 5, 1]
         [1, 3, 1] 
         [0, 5, 2] 
         [0, 2, 2] 
         [1, 4, 1] 
         [0, 1, 1] ] 
 C = 3
 D = 2

Input 2:

 A = 2
 B = [   [0, 1, 1]
     ] 
 C = 0
 D = 1
```
#### Example Output
```text
Output 1:
 4

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    The path to be followed will be:
        3 -> 1 (Edge weight : 1)
        1 -> 0 (Edge weight : 1)
        0 -> 2 (Edge weight : 2)
    Total length of path = 1 + 1 + 2 = 4.

Explanation 2:
    Path will be 0-> 1.
```
### Hints
* Hint 1
```text
BFS can be use for finding shortest path between destination and source by modifying 
the original graph.

A bfs would work if all edges have same weight.

So for each edge of weight 2 insert a dummy node between them.

After modifying the graph you can apply bfs to find the shortest path from 
source to destination in O(A+M) time because all edges have same weight now.
```
* Solution Approach
```text
BFS can be use for finding shortest path between destination and source by modifying 
the original graph.

A bfs would work if all edges have same weight.

So for each edge of weight 2 insert a dummy node between them.

After modifying the graph you can apply bfs to find the shortest path from source to 
destination in O(A+M) time because all edges have same weight now.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int maxn = 200009;
    static int[] vis = new int[maxn];
    static ArrayList < ArrayList < Integer > > adj;
    public static void graph() {
        adj = new ArrayList < ArrayList < Integer > > (maxn);
        for (int i = 0; i < maxn; i++) {
            vis[i] = 0;
            adj.add(new ArrayList < Integer > ());
        }
    }
    public int solve(int A, int[][] B, int C, int D) {
        graph();
        int n = A;
        for (int[] it: B) {
            int x = it[0];
            int y = it[1];
            int w = it[2];
            if (w == 1) {
                adj.get(x).add(y);
                adj.get(y).add(x);
            } else {
                adj.get(x).add(x + n);
                adj.get(x + n).add(y);
                adj.get(y).add(y + n);
                adj.get(y + n).add(x);
            }
        }
        return bfs(C, D);
    }
    public static int bfs(int source, int destination) {
        vis[source] = 1;
        Queue < Pair > q = new ArrayDeque < Pair > ();
        q.offer(new Pair(source, 0));
        while (q.size() > 0) {
            Pair p = q.poll();
            int x = p.ff;
            int w = p.ss;
            if (x == destination)
                return w;
            for (int v: adj.get(x)) {
                if (vis[v] == 0) {
                    vis[v] = 1;
                    q.offer(new Pair(v, w + 1));
                }
            }
        }
        return -1;
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
const N = 200005;
let g = new Array(N);
let vis = new Array(N);

function clean(n) {
    for (let i = 0; i <= n; ++i) {
        g[i] = [];
        vis[i] = 0;
    }
}

function make_graph(n, edges) {
    for (let j = 0; j < edges.length; j++) {
        let x = edges[j][0];
        let y = edges[j][1];
        let w = edges[j][2];
        if (w == 1) {
            g[x].push(y);
            g[y].push(x);
        } else {
            g[x].push(x + n);
            g[x + n].push(y);
            g[y].push(y + n);
            g[y + n].push(x);
        }
    }
}

module.exports = {
    //param A : integer
    //param B : array of array of integers
    //param C : integer
    //param D : integer
    //return an integer
    solve: function (n, edges, source, destination) {
        clean(n + n);
        make_graph(n, edges);
        vis[source] = 1;
        let q = [];
        q.push([source, 0]);
        while (q.length > 0) {
            let x = q[0][0];
            let w = q[0][1];
            q.shift();
            if (x == destination)
                return w;
            for (let j = 0; j < g[x].length; j++) {
                let it = g[x][j];
                if (vis[it] == 0) {
                    vis[it] = 1;
                    q.push([it, w + 1]);
                }
            }
        }
        return -1;
    }
};
```
* * Solution in C++
```cpp
const int N = 200005;
vector < int > g[N];
int vis[N];

void clean(int n) {
    for (int i = 0; i <= n; ++i) {
        g[i].clear();
        vis[i] = 0;
    }
}

void make_graph(int n, vector < vector < int > > & edges) {
    for (auto & it: edges) {
        int x = it[0];
        int y = it[1];
        int w = it[2];
        if (w == 1) {
            g[x].push_back(y);
            g[y].push_back(x);
        } else {
            g[x].push_back(x + n);
            g[x + n].push_back(y);
            g[y].push_back(y + n);
            g[y + n].push_back(x);
        }
    }
}

int shortestDistance(int n, vector < vector < int > > & edges, int source, int destination) {
    clean(n + n);
    make_graph(n, edges);
    vis[source] = 1;
    queue < pair < int, int > > q;
    q.push({source, 0});
    while (!q.empty()) {
        int x = q.front().first;
        int w = q.front().second;
        q.pop();
        if (x == destination)
            return w;
        for (auto & it: g[x]) {
            if (!vis[it]) {
                vis[it] = 1;
                q.push({
                    it,
                    w + 1
                });
            }
        }
    }
    return -1;
}

int Solution::solve(int A, vector < vector < int > > & B, int C, int D) {
    return shortestDistance(A, B, C, D);
}
```

