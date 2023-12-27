### Q3. Check Bipartite Graph
#### Problem Description
```text
Given a undirected graph having A nodes. A matrix B of size M x 2 is given which 
represents the edges such that there is an edge between B[i][0] and B[i][1].

Find whether the given graph is bipartite or not.

A graph is bipartite if we can split it's set of nodes into two independent 
subsets A and B such that every edge in the graph has one node in A and another node in B

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make 
sure to clear them.
```
#### Problem Constraints
```text
1 <= A <= 100000

1 <= M <= min(A*(A-1)/2,200000)

0 <= B[i][0],B[i][1] < A
```
#### Input Format
```text
The first argument given is an integer A.

The second argument given is the matrix B.
```
#### Output Format
```text
Return 1 if the given graph is bipartide else return 0.
```
#### Example Input
```text
Input 1:
 A = 2
 B = [ [0, 1] ]

Input 2:
 A = 3
 B = [ [0, 1], [0, 2], [1, 2] ]
```
#### Example Output
```text
Output 1:
 1

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    Put 0 and 1 into 2 different subsets.

Explanation 2:
    It is impossible to break the graph down to make two different subsets for 
    bipartite matching
```
### Hints
* Hint 1
```text
Try to color the graph using two colors.
If possible then it is bipartite else not.
```
* Solution Approach
```text
You can use and approach either BFS or DFS to check whether the graph can be colored 
using two colors or not.

    1. Start from any node that hase not been colored yet:
        
        a. Assign color1 to this nodes
        
        b. check its adjacent nodes
        
        a. if this is colored in color1 then the graph can’t be bipartite ,return 0.
        
        b. else if this is colored in color1 do nothing.
        
        c. else color it with color 2 and push it into queue.
    
    2. Repeat step1 until no nodes is left for coloring.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int maxn = 100009;
    static ArrayList < ArrayList < Integer > > graph;
    public static void graphC() {
        graph = new ArrayList < ArrayList < Integer > > (maxn);
        for (int i = 0; i < maxn; i++) {
            graph.add(new ArrayList < Integer > ());
        }
    }
    public int solve(int A, int[][] B) {
        graphC();
        for (int[] edge: B) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        if (isBipar(A) == true)
            return 1;
        return 0;
    }
    public static boolean isBipar(int n) {
        if (n == 0)
            return true;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        Queue < Integer > q = new ArrayDeque < > ();
        for (int i = 0; i < n; ++i) {
            if (color[i] != -1)
                continue;
            color[i] = 1;
            q.offer(i);
            while (q.size() > 0) {
                int x = q.poll();
                for (int it: graph.get(x)) {
                    if (color[it] == -1) {
                        color[it] = color[x] ^ 1;
                        q.offer(it);
                    } else if (color[it] == color[x])
                        return false;
                }
            }
        }
        return true;
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
  addEdge(source, destination) {
    if (!this.adjacencyList[source]) {
      this.addVertex(source);
    }
    if (!this.adjacencyList[destination]) {
      this.addVertex(destination);
    }
    this.adjacencyList[source].push(destination);
    this.adjacencyList[destination].push(source);
  }
  removeEdge(source, destination) {
    this.adjacencyList[source] = this.adjacencyList[source].filter(
      (vertex) => vertex !== destination
    );
    this.adjacencyList[destination] = this.adjacencyList[destination].filter(
      (vertex) => vertex !== source
    );
  }
  removeVertex(vertex) {
    while (this.adjacencyList[vertex]) {
      const adjacentVertex = this.adjacencyList[vertex].pop();
      this.removeEdge(vertex, adjacentVertex);
    }
    delete this.adjacencyList[vertex];
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

const N = 100005;
let g;

function make_graph(edges) {
  for (let i = 0; i < edges.length; ++i) {
    g.addEdge(edges[i][0], edges[i][1]);
  }
}

function isBipartite(n) {
  if (!n) return true;
  let color = new Array(n).fill(-1);
  let q = new Queue();
  for (let i = 0; i < n; ++i) {
    if (color[i] != -1) continue;
    color[i] = 1;
    q.enqueue(i);
    while (!q.isEmpty()) {
      let x = q.dequeue();
      g.addVertex(x);
      for (let i = 0; i < g.adjacencyList[x].length; i++) {
        let it = g.adjacencyList[x][i];
        if (color[it] == -1) {
          color[it] = color[x] ^ 1;
          q.enqueue(it);
        } else if (color[it] == color[x]) return false;
      }
    }
  }
  return true;
}

module.exports = {
  solve: function (A, B) {
    g = new Graph();
    make_graph(B);
    if (isBipartite(A)) return 1;
    return 0;
  },
};
```
* * Solution in C++
```cpp
const int N = 100005;
vector < int > graph[N];

void clean(int n) {
    for (int i = 0; i <= n; ++i)
        graph[i].clear();
}

void make_graph(int n, vector < vector < int > > & edges) {
    clean(n);
    for (int i = 0; i < edges.size(); ++i) {
        graph[edges[i][0]].push_back(edges[i][1]);
        graph[edges[i][1]].push_back(edges[i][0]);
    }
}

bool isBipartite(int n) {
    if (!n)
        return true;
    int color[n];
    memset(color, -1, sizeof color);
    queue < int > q;
    for (int i = 0; i < n; ++i) {
        if (color[i] != -1)
            continue;
        color[i] = 1;
        q.push(i);
        while (!q.empty()) {
            int x = q.front();
            q.pop();
            for (auto & it: graph[x]) {
                if (color[it] == -1) {
                    color[it] = color[x] ^ 1;
                    q.push(it);
                } else if (color[it] == color[x])
                    return false;
            }
        }
    }
    return true;
}

int Solution::solve(int A, vector < vector < int > > & B) {
    make_graph(A, B);
    if (isBipartite(A))
        return 1;
    return 0;
}
```

