### Q1. Path in Directed Graph
#### Problem Description
```text
Given an directed graph having A nodes labelled from 1 to A containing M edges given 
by matrix B of size M x 2such that there is a edge directed from node

B[i][0] to node B[i][1].

Find whether a path exists from node 1 to node A.

Return 1 if path exists else return 0.

NOTE:

    * There are no self-loops in the graph.
    * There are no multiple edges between two nodes.
    * The graph may or may not be connected.
    * Nodes are numbered from 1 to A.
    * Your solution will run on multiple test cases. If you are using global variables 
      make sure to clear them.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>2 &lt;= A &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= M &lt;= min(200000,A*(A-1))</p>
    <p>1 &lt;= B[i][0], B[i][1] &lt;= A</p>
</div>

```text
2 <= A <= 10^5

1 <= M <= min(200000,A*(A-1))

1 <= B[i][0], B[i][1] <= A
```
#### Input Format
```text
The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such 
that there is a edge directed from node B[i][0] to node B[i][1].
```
#### Output Format
```text
Return 1 if path exists between node 1 to node A else return 0.
```
#### Example Input
```text
Input 1:
 A = 5
 B = [  [1, 2] 
        [4, 1] 
        [2, 4] 
        [3, 4] 
        [5, 2] 
        [1, 3] ]

Input 2:
 A = 5
 B = [  [1, 2]
        [2, 3] 
        [3, 4] 
        [4, 5] ]
```
#### Example Output
```text
Output 1:
 0

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    The given doesn't contain any path from node 1 to node 5 so we will return 0.

Explanation 2:
    Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.
```
### Hints
* Hint 1
```text
Approach:
Either Breadth First Search (BFS) or Depth First Search (DFS) can be used to find path 
between two vertices.

Take the first vertex as source in BFS (or DFS), follow the standard BFS (or DFS). 
If the second vertex is found in our traversal, then return 1 else return 0.
```
* Solution Approach
```text
Approach:
Either Breadth First Search (BFS) or Depth First Search (DFS) can be used to find path 
between two vertices.

Take the first vertex as source in BFS (or DFS), follow the standard BFS (or DFS). 
If the second vertex is found in our traversal, then return 1 else return 0.

Algorithm:
The author implementation iss using BFS.

    1. Create a queue and a visited array initially filled with 0, of size V where V 
       is number of vertices.
    
    2. Insert the starting node in the queue, i.e. push u in the queue and mark u as 
       visited.
    
    3. Run a loop until the queue is not empty.
    
    4. Dequeue the front element of the queue. Iterate all its adjacent elements. If 
       any of the adjacent element is the destination return 1. Push all the adjacent 
       and unvisited vertices in the queue and mark them as visited.
    
    5. Return 0 as the destination is not reached in BFS.

Complexity Analysis:

    1. Time Complexity: O(A + M) where A is number of vertices in the graph and M is 
       number of edges in the graph.
    
    2. Space Complexity: O(A).

There can be atmost A elements in the queue. So the space needed is O(A).

Trade-offs between BFS and DFS: Breadth-First search can be useful to find the 
shortest path between nodes, and depth-first search may traverse one adjacent node 
very deeply before ever going into immediate neighbours.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int maxn = 100009;
    static int[] visited = new int[maxn];
    static ArrayList<ArrayList<Integer>> adj;

    public int solve(int A, int[][] B) {
        adj = new ArrayList<ArrayList<Integer>>(maxn);
        for (int i = 0; i < maxn; i++) {
            visited[i] = 0;
            adj.add(new ArrayList<Integer>());
        }
        for (int[] edge : B)
            adj.get(edge[0]).add(edge[1]);
        if (isReachable(1, A) == true)
            return 1;
        return 0;
    }

    public static boolean isReachable(int s, int d) {
        if (s == d)
            return true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        visited[s] = 1;
        while (q.size() > 0) {
            s = q.poll();
            for (int v : adj.get(s)) {
                if (v == d) return true;
                if (visited[v] == 0) {
                    visited[v] = 1;
                    q.offer(v);
                }
            }
        }
        return false;
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

const maxn = 100009;
let adj = new Array(maxn).fill([]);
let visited = new Array(maxn);
function ini() {
  for (let i = 0; i < maxn; i++) (adj[i] = []), (visited[i] = 0);
}
function isReachable(s, d) {
  if (s == d) return true;
  let q = new Queue();
  q.enqueue(s);
  visited[s] = 1;
  while (q.isEmpty() == false) {
    let s = q.dequeue();
    for (let i = 0; i < adj[s].length; i++) {
      let v = adj[s][i];
      if (v == d) return true;
      if (visited[v] == 0) {
        visited[v] = 1;
        q.enqueue(v);
      }
    }
  }
  return false;
}

module.exports = {
  solve: function (A, B) {
    ini();
    for (let i = 0; i < B.length; i++) {
      let it = B[i];
      adj[it[0]].push(it[1]);
    }
    if (isReachable(1, A)) return 1;
    return 0;
  },
};
```
* * Solution in C++
```cpp
const int maxn = 100009;
vector < int > adj[maxn];
int visited[maxn];
void ini() {
  for (int i = 0; i < maxn; i++) adj[i].clear();
  memset(visited, 0, sizeof(visited));
}
bool isReachable(int s, int d) {
  if (s == d) return true;
  queue < int > q;
  q.push(s);
  visited[s] = 1;
  while (q.empty() == false) {
    int s = q.front();
    q.pop();
    for (auto v: adj[s]) {
      if (v == d) return true;
      if (visited[v] == 0) {
        visited[v] = 1;
        q.push(v);
      }
    }
  }
  return false;
}
int Solution::solve(int A, vector < vector < int > > & B) {
  ini();
  for (auto & it: B) adj[it[0]].push_back(it[1]);
  if (isReachable(1, A)) return 1;
  return 0;
}
```

