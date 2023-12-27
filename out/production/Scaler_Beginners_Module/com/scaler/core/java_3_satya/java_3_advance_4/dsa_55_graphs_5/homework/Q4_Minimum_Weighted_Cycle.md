### Q4. Minimum Weighted Cycle
#### Problem Description
```text
Given an integer A, representing number of vertices in a graph.

Also you are given a matrix of integers B of size N x 3 where N represents number of 
Edges in a Graph and Triplet (B[i][0], B[i][1], B[i][2]) implies there is an undirected 
edge between B[i][0] and B[i][1] and weight of that edge is B[i][2].

Find and return the weight of minimum weighted cycle and if there is no cycle 
return -1 instead.

NOTE: Graph may contain multiple edges and self loops.
```
#### Problem Constraints
```text
1 <= A <= 1000

1 <= B[i][0], B[i][1] <= A

1 <= B[i][2] <= 100000
```
#### Input Format
```text
The first argument given is the integer A.

The second argument given is the integer matrix B.
```
#### Output Format
```text
Return the weight of minimum weighted cycle and if there is no cycle return -1 instead.
```
#### Example Input
```text
Input 1:

 A = 4
 B = [  [1 ,2 ,2]
        [2 ,3 ,3]
        [3 ,4 ,1]
        [4 ,1 ,4]
        [1 ,3 ,15]  ]

Input 2:

 A = 3
 B = [  [1 ,2 ,2]
        [2 ,3 ,3]  ]
```
#### Example Output
```text
Output 1:
 10 

Output 2:
 -1
```
#### Example Explanation
```text
Explanation 1:
     Given graph forms 3 cycles
     1. 1 ---> 2 ---> 3 ---> 4 ---> 1 weight = 10
     2. 1 ---> 2 ---> 3 ---> 1 weight = 20
     3. 1 ---> 3---> 4 ---> 1 weight = 20
     so answer would be 10.

Explanation 2:
    Given graph forms 0 cycles so return -1.
```
### Hints
* Hint 1
```text
If a Minimum weighted cycle contains an edge between vertices i and j then answer 
would be shortest path from i to j without edge i --> j + weight of i ---> j.
```
* Solution Approach
```text
The idea is to use shortest path algorithm. We one by one remove every edge from 
graph, then we find shortest path between two corner vertices of it. We add an edge 
back before we process next edge.

    1). create an empty vector ‘edge’ of size ‘E’
        ( E total number of edge). Every element of
        this vector is used to store information of
        all the edge in graph info

    2) Traverse every edge edge[i] one - by - one
        a). First remove ‘edge[i]’ from graph ‘G’
        b). get current edge vertices which we just
            removed from graph
        c). Find the shortest path between them
            “Using Dijkstra’s shortest path algorithm “
        d). To make a cycle we add weight of the
            removed edge to the shortest path.
        e). update min_weight_cycle if needed
    
    3) Return minimum weighted cycle

Time Complexity : O( E ( E log V ) ) where E is number of edges and N is number of nodes.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int maxn = 1009;
    static ArrayList < ArrayList < pair > > adj;
    static int[] dist = new int[maxn];
    static int[] visited = new int[maxn];
    static int inf = 1000000000;
    public static void graph() {
        adj = new ArrayList < ArrayList < pair > > (maxn);
        for (int i = 0; i < maxn; i++) {
            dist[i] = 0;
            visited[i] = 0;
            adj.add(new ArrayList < pair > ());
        }
    }
    public int solve(int A, int[][] B) {
        graph();
        Map < pair, Integer > mp = new HashMap < pair, Integer > ();
        for (int[] row: B) {
            if (row[0] == row[1]) continue;
            if (mp.containsKey(new pair(row[0], row[1])) || mp.containsKey(new pair(row[1], row[0])))
                continue;
            mp.put(new pair(row[0], row[1]), 1);
            mp.put(new pair(row[1], row[0]), 1);
            adj.get(row[0]).add(new pair(row[1], row[2]));
            adj.get(row[1]).add(new pair(row[0], row[2]));
        }
        int ans = Integer.MAX_VALUE;
        for (int[] row: B) {
            int u = row[0];
            int v = row[1];
            int w = row[2];
            removeEdge(u, v, w);
            int cost = dijkstra(u, v);
            if (cost != inf)
                ans = Math.min(ans, cost + w);
            addEdge(u, v, w);
        }
        if (ans == Integer.MAX_VALUE)
            ans = -1;
        return ans;
    }
    public static void removeEdge(int u, int v, int w) {
        adj.get(u).remove(new pair(v, w));
        adj.get(v).remove(new pair(u, w));
    }
    public static void addEdge(int u, int v, int w) {
        adj.get(u).add(new pair(v, w));
        adj.get(v).add(new pair(u, w));
    }
    public static int dijkstra(int source, int dest) {
        PriorityQueue < pair > pq = new PriorityQueue < pair > (new CustomComp());
        for (int i = 0; i < maxn; i++) {
            dist[i] = inf;
            visited[i] = 0;
        }
        dist[source] = 0;
        pq.offer(new pair(0, source));

        while (pq.size() != 0) {
            pair temp = pq.poll();
            int u = temp.S;
            if (visited[u] == 1)
                continue;
            visited[u] = 1;
            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i).F, w = adj.get(u).get(i).S;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new pair(dist[v], v));
                }
            }
        }
        return dist[dest];
    }
}
class pair implements Comparable {
    int F, S;
    pair(int f, int s) {
        F = f;
        S = s;
    }
    @Override
    public int compareTo(Object o) {
        pair p1 = (pair) this;
        pair p2 = (pair) o;
        return (p1.F != p2.F) ? p1.F - p2.F : p1.S - p2.S;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof pair)) return false;
        pair p1 = (pair) this;
        pair p2 = (pair) o;
        return p1.F == p2.F && p1.S == p2.S;
    }
    @Override
    public int hashCode() {
        return this.F + 97 * this.S;
    }
}
class CustomComp implements Comparator < pair > {
    @Override
    public int compare(pair aa, pair bb) {
        return aa.F - bb.F;
    }
}
```
* * Solution in Javascript
```javascript
class Graph {
  constructor() {
    this.adjacencyList = {};
  }
  addVertex(vertex) {
    if (!this.adjacencyList[vertex]) {
      this.adjacencyList[vertex] = [];
    }
  }
  addEdge(source, destination, weight) {
    if (!this.adjacencyList[source]) {
      this.addVertex(source);
    }
    if (!this.adjacencyList[destination]) {
      this.addVertex(destination);
    }
    this.adjacencyList[source].push({ to: destination, wt: weight });
    this.adjacencyList[destination].push({ to: source, wt: weight });
  }
}

const top = 0;
const parent = (i) => ((i + 1) >>> 1) - 1;
const left = (i) => (i << 1) + 1;
const right = (i) => (i + 1) << 1;

class PriorityQueue {
  constructor(comparator = (a, b) => a > b) {
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
    values.forEach((value) => {
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
      let maxChild =
        right(node) < this.size() && this._greater(right(node), left(node))
          ? right(node)
          : left(node);
      this._swap(node, maxChild);
      node = maxChild;
    }
  }
}

let g;
const maxn = 1000000000;
let visited = [];

function dijkstra(A, f, t, timed) {
  let dist = new Array(A + 1).fill(maxn);
  dist[f] = 0;
  let pq = new PriorityQueue((a, b) => a[0] < b[0]);
  pq.push([0, f]);
  while (!pq.isEmpty()) {
    let temp = pq.pop();
    let v = temp[1];
    if (visited[v] == timed) continue;
    visited[v] = timed;

    // console.log(v);
    for (let node of g.adjacencyList[v]) {
      // console.log(node);
      let w = node.wt;
      let u = node.to;
      if (v == f && u == t) continue;
      else if (v == t && u == f) continue;
      if (dist[v] + w < dist[u]) {
        dist[u] = dist[v] + w;
        pq.push([dist[u], u]);
      }
    }
  }
  if (dist[t] == maxn) return -1;
  return dist[t];
}

module.exports = {
  solve: function (A, B) {
    g = new Graph();
    B.forEach((it) => {
      g.addEdge(it[0], it[1], it[2]);
    });

    visited = new Array(A + 1).fill(0);
    let ans = maxn;
    let timed = 0;
    for (let i of B) {
      timed += 1;
      res = dijkstra(A, i[0], i[1], timed);
      if (res == -1) continue;
      ans = Math.min(ans, res + i[2]);
    }
    if (ans == maxn) ans = -1;

    return ans;
  },
};
```
* * Solution in C++
```cpp
#include<bits/stdc++.h>

using namespace std;
# define INF 0x3f3f3f3f

struct Edge {
    int u;
    int v;
    int weight;
};
class Graph {
    int V;
    list < pair < int, int > > * adj;
    vector < Edge > edge;
    public:
        Graph(int V) {
            this -> V = V;
            adj = new list < pair < int, int > > [V];
        }
    void addEdge(int u, int v, int w);
    void removeEdge(int u, int v, int w);
    int ShortestPath(int u, int v);
    void RemoveEdge(int u, int v);
    int FindMinimumCycle();
};
void Graph::addEdge(int u, int v, int w) {
    adj[u].push_back(make_pair(v, w));
    adj[v].push_back(make_pair(u, w));
    Edge e { u, v, w};
    edge.push_back(e);
}
void Graph::removeEdge(int u, int v, int w) {
    adj[u].remove(make_pair(v, w));
    adj[v].remove(make_pair(u, w));
}
int Graph::ShortestPath(int u, int v) {
    set < pair < int, int > > setds;
    vector < int > dist(V, INF);
    setds.insert(make_pair(0, u));
    dist[u] = 0;
    while (!setds.empty()) {
        pair < int, int > tmp = * (setds.begin());
        setds.erase(setds.begin());
        int u = tmp.second;
        list < pair < int, int > > ::iterator i;
        for (i = adj[u].begin(); i != adj[u].end(); ++i) {
            int v = ( * i).first;
            int weight = ( * i).second;
            if (dist[v] > dist[u] + weight) {
                if (dist[v] != INF)
                    setds.erase(setds.find(make_pair(dist[v], v)));
                dist[v] = dist[u] + weight;
                setds.insert(make_pair(dist[v], v));
            }
        }
    }
    if (dist[v] == INF)
        return -1;
    return dist[v];
}
int Graph::FindMinimumCycle() {
    int min_cycle = INF;
    int E = edge.size();
    for (int i = 0; i < E; i++) {
        Edge e = edge[i];
        removeEdge(e.u, e.v, e.weight);
        int vistance = ShortestPath(e.u, e.v);
        if (vistance == -1) continue;
        min_cycle = min(min_cycle, vistance + e.weight);
        addEdge(e.u, e.v, e.weight);
    }
    if (min_cycle == INF)
        min_cycle = -1;
    return min_cycle;
}
int Solution::solve(int A, vector < vector < int > > & B) {
    Graph g(A);
    int E = B.size();
    for (int i = 0; i < E; i++) {
        B[i][0]--;
        B[i][1]--;
        g.addEdge(B[i][0], B[i][1], B[i][2]);
    }
    return g.FindMinimumCycle();
}
```

