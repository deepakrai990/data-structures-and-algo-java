### Q1. Commutable Islands
#### Problem Description
```text
There are A islands and there are M bridges connecting them. Each bridge has some 
cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which 
all islands are connected with each other.
```
#### Problem Constraints
```text
1 <= A, M <= 6*10^4

1 <= B[i][0], B[i][1] <= A

1 <= B[i][2] <= 10^3
```
#### Input Format
```text
The first argument contains an integer, A, representing the number of islands.

The second argument contains an 2-d integer matrix, B, of size M x 3 where 
Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
```
#### Output Format
```text
Return an integer representing the minimal cost required.
```
#### Example Input
```text
Input 1:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 4]
        [1, 4, 3]
        [4, 3, 2]
        [1, 3, 10]  ]

Input 2:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 2]
        [3, 4, 4]
        [1, 4, 3]   ]
```
#### Example Output
```text
Output 1:
 6

Output 2:
 6
```
#### Example Explanation
```text
Explanation 1:
    We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost 
    incurred will be (1 + 3 + 2) = 6.

Explanation 2:
    We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost 
    incurred will be (1 + 2 + 3) = 6.
```
### Hints
* Hint 1
```text
Hint : Try to think in terms of graph.
Can we make a graph out of the given data and use some graph algorithms?
```
* Solution Approach
```text
We can assume islands as the vertex points and bridges as the edges and can construct a 
graph with the the help of them. After constructing the graph, the problem boils down 
to finding a subset of edges which helps in connecting vertices in a single connected 
component such that the sum of their edge weights is as minimum as possible.

Now since the problem is clear to you, can you think of any graph theory algorithms 
related to this?

Well the answer to this problem is the classic minimum spanning tree algorithm. In 
this algorithm we aim at finding subset of the edges of a connected, edge-weighted 
undirected graph that connects all the vertices together, without any cycles and with 
the minimum possible total edge weight.

There are many algorithms for finding minimum spanning tree of a graph. Some of them 
are Kruskal’s algorithm, Prim’s algorithm etc.

Kruskal’s algorithm in detail can be found at : https://en.wikipedia.org/wiki/Kruskal%27s_algorithm
Prim’s algorithm in detail can be found at : https://en.wikipedia.org/wiki/Prim%27s_algorithm

Now, can you code this?
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int maxn = 60009;
    static int[] arr = new int[maxn];
    static int[] sz = new int[maxn];
    static ArrayList < pair > edges;
    public int solve(int A, int[][] B) {
        ini();
        for (int[] row: B) {
            edges.add(new pair(row[2], row[0], row[1]));
        }
        Collections.sort(edges);
        return kruskal();
    }
    public static int kruskal() {
        int cost = 0;
        for (int i = 0; i < edges.size(); i++) {
            if (root(edges.get(i).b) == root(edges.get(i).c))
                continue;
            cost += edges.get(i).a;
            un(edges.get(i).b, edges.get(i).c);
        }
        return cost;
    }
    public static void ini() {
        edges = new ArrayList < pair > ();
        for (int i = 0; i < maxn; i++) {
            arr[i] = i;
            sz[i] = 1;
        }
    }
    public static int root(int a) {
        while (arr[a] != a) {
            arr[a] = arr[arr[a]];
            a = arr[a];
        }
        return a;
    }
    public static void un(int a, int b) {
        int ra = root(a);
        int rb = root(b);
        if (sz[ra] <= sz[rb]) {
            arr[ra] = rb;
            sz[rb] += sz[ra];
        } else {
            arr[rb] = ra;
            sz[ra] += sz[rb];
        }
    }
}
class pair implements Comparable < pair > {
    int a, b, c;
    pair(int e, int f, int g) {
        this.a = e;
        this.b = f;
        this.c = g;
    }
    @Override
    public int compareTo(pair aa) {
        return this.a - aa.a;
    }
}
```
* * Solution in Javascript
```javascript
let n, m;
let p = new Array(100005);
let rank11 = new Array(100005);
let v = [];

function create_set() {
    for (let i = 1; i <= n; i++) {
        p[i] = i, rank11[i] = 0;
    }
}

function find_set(u) {
    while (u != p[u]) {
        u = p[u];
    }
    return u;
}

function merge_set(u, v) {
    let s1 = find_set(u);
    let s2 = find_set(v);
    if (rank11[s1] > rank11[s2])
        p[s2] = s1;
    else
        p[s1] = s2;
    if (rank11[s1] == rank11[s2])
        rank11[s2] += 1;
}

function kruskal() {
    create_set();
    let res = 0;
    for (let i = 0; i < v.length; i++) {
        let v1 = v[i][1];
        let v2 = v[i][2];
        if (find_set(v1) != find_set(v2)) {
            res += v[i][0];
            merge_set(v1, v2);
        }
    }
    return res;
}
module.exports = {
    //param A : integer
    //param B : array of array of integers
    //return an integer
    solve: function (A, B) {
        n = A;
        m = B.length;
        v = [];
        for (let i = 0; i < m; i++) {
            let x, y, cost;
            x = B[i][0];
            y = B[i][1];
            cost = B[i][2];
            v.push([cost, x, y]);
        }
        v.sort(function (a, b) {
            return a[0] - b[0]
        });
        return kruskal();
    }
};
```
* * Solution in C++
```cpp
/**
There are numerous classic approaches for finding Minimum Spanning Tree(MST) of a 
graph. One among them is Kruskal’s method. Kruskal’s Algorithm builds the spanning 
tree by adding edges one by one into a growing spanning tree. Kruskal’s algorithm 
follows greedy approach as in each iteration it finds an edge which has least 
weight and add it to the growing spanning tree.

Steps:

Sort the graph edges with respect to their weights.
Start adding edges to the MST from the edge with the smallest weight until the edge 
of the largest weight.
Only add edges which doesn’t form a cycle , edges which connect only disconnected 
components.
So now the question is how to check if vertices are connected or not ?

We can find it using Disjoint sets method. Disjoint sets are sets whose 
intersection is the empty set, so it means that they don’t have any 
element in common.

See author’s solution for more details.
**/

#define N 100005
int n, m, p[N], rank11[N];
vector < pair < int, pair < int, int > > > v;

void create_set() {
    for (int i = 1; i <= n; i++) {
        p[i] = i, rank11[i] = 0;
    }
}

int find_set(int u) {
    int x = p[u];
    if (x != u)
        x = find_set(x);
    return x;
}
void merge_set(int u, int v) {
    int s1 = find_set(u);
    int s2 = find_set(v);
    if (rank11[s1] > rank11[s2])
        p[s2] = s1;
    else
        p[s1] = s2;
    if (rank11[s1] == rank11[s2])
        rank11[s2] += 1;
}
int kruskal() {
    create_set();
    int res = 0;
    for (int i = 0; i < v.size(); i++) {
        int v1 = v[i].second.first;
        int v2 = v[i].second.second;
        if (find_set(v1) != find_set(v2)) {
            res += v[i].first;
            merge_set(v1, v2);
        }
    }
    return res;
}

int Solution::solve(int A, vector < vector < int > > & B) {
    n = A;
    m = (int) B.size();
    v.clear();
    for (int i = 0; i < m; i++) {
        int x, y, cost;
        x = B[i][0];
        y = B[i][1];
        cost = B[i][2];
        v.push_back(make_pair(cost, make_pair(x, y)));
    }
    sort(v.begin(), v.end());
    return kruskal();
}
```

