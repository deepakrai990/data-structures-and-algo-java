### Q1. Topological Sort
#### Problem Description
```text
Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which 
represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices 
such that for every directed edge uv, vertex u comes before v in the ordering. Topological 
Sorting for a graph is not possible if the graph is not a DAG.

Return the topological ordering of the graph and if it doesn't exist then return an empty 
array.

If there is a solution return the correct ordering. If there are multiple solutions 
print the lexographically smallest one.

Ordering (a, b, c) is said to be lexographically smaller than 
ordering (e, f, g) if a < e or if(a==e) then b < f and so on.

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
    <p>2 &lt;= A &lt;= 10<sup>4</sup></p>
    <p>1 &lt;= M &lt;= min(100000,A*(A-1))</p>
    <p>1 &lt;= B[i][0], B[i][1] &lt;= A</p>
</div>

```text
2 <= A <= 10^4

1 <= M <= min(100000,A*(A-1))

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
Return a one-dimensional array denoting the topological ordering of the graph 
and it it doesn't exist then return empty array.
```
#### Example Input
```text
Input 1:
 A = 6
 B = [  [6, 3] 
        [6, 1] 
        [5, 1] 
        [5, 2] 
        [3, 4] 
        [4, 2] ]

Input 2:
 A = 3
 B = [  [1, 2]
        [2, 3] 
        [3, 1] ]
```
#### Example Output
```text
Output 1:
 [5, 6, 1, 3, 4, 2]

Output 2:
 []
```
#### Example Explanation
```text
Explanation 1:
    The given graph contain no cycle so topological ordering exists which 
    is [5, 6, 1, 3, 4, 2]

Explanation 2:
    The given graph contain cycle so topological ordering not possible we will 
    return empty array.
```
### Hints
* Hint 1
```text
Pre-requisite: Kahn’s Algorithm for topological sorting

A DAG G has at least one vertex with in-degree 0 and one vertex with out-degree 0

TO maintain the smallest ordering use priority queue instead of queue.
```
* Solution Approach
```text
A DAG G has at least one vertex with in-degree 0 and one vertex with out-degree 0.
Proof: There’s a simple proof to the above fact is that a DAG does not contain a cycle 
which means that all paths will be of finite length.
Now let S be the longest path from u(source) to v(destination). Since S is the longest 
path there can be no incoming edge to u and no outgoing edge from v, if this situation 
had occurred then S would not have been the longest path

=> indegree(u) = 0 and outdegree(v) = 0

Algorithm:
Steps involved in finding the topological ordering of a DAG:

Step-1: Compute in-degree (number of incoming edges) for each of the vertex present in 
        the DAG and initialize the count of visited nodes as 0.

Step-2: Pick all the vertices with in-degree as 0 and add them into a min priority 
        queue (Enqueue operation)

Step-3: Remove a vertex from the queue (Dequeue operation) and then.

Increment count of visited nodes by 1.
Decrease in-degree by 1 for all its neighboring nodes.
If in-degree of a neighboring nodes is reduced to zero, then add it to the queue.
Step 5: Repeat Step 3 until the queue is empty.

Step 5: If count of visited nodes is not equal to the number of nodes in the graph then 
        the topological sort is not possible for the given graph.

How to find in-degree of each node?
There are 2 ways to calculate in-degree of every vertex:
Take an in-degree array which will keep track of

1) Traverse the array of edges and simply increase the counter of the destination node by 1.

for each node in Nodes
indegree[node] = 0;
for each edge(src,dest) in Edges
indegree[dest]++
Time Complexity: O(V+E)

2) Traverse the list for every node and then increment the in-degree of all the nodes 
   connected to it by 1.

for each node in Nodes
    If (list[node].size()!=0) then
    for each dest in list
        indegree[dest]++;
We are using priority queue as we have to output the lexographically smallest ordering.

Overall time complexity: O((VlogV+E)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int maxn = 10009;
    static int[] in = new int[maxn];
    static ArrayList < ArrayList < Integer > > adj;
    public static void graph() {
        adj = new ArrayList < ArrayList < Integer > > (maxn);
        for (int i = 0; i < maxn; i++) {
            in [i] = 0;
            adj.add(new ArrayList < Integer > ());
        }
    }
    public int[] solve(int A, int[][] B) {
        graph();
        for (int[] edge: B) {
            adj.get(edge[0]).add(edge[1]); 
            in[edge[1]]++;
        }
        PriorityQueue < Integer > pq = new PriorityQueue < > ();
        for (int i = 1; i <= A; i++) {
            if ( in [i] == 0)
                pq.offer(i);
        }
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        while (pq.size() > 0) {
            int temp = pq.poll();
            ans.add(temp);
            for (int v: adj.get(temp)) {
                in [v]--;
                if (in[v] == 0)
                    pq.offer(v);
            }
        }
        if (ans.size() != A)
            ans.clear();
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}
```
* * Solution in Javascript
```javascript
let adj;
let inp;

class PriorityQueue {
    constructor(fct) {
        this.heap = [];
        this.fct = fct;
    }

    top() {
        if (this.heap.length == 0) return undefined;
        return this.heap[0] * this.fct;
    }

    push(node) {
        this.heap.push(node * this.fct);
        let id = this.heap.length - 1;
        let par = Math.floor((id - 1) / 2);

        while (id > 0 && this.heap[id] < this.heap[par]) {
            [this.heap[id], this.heap[par]] = [this.heap[par], this.heap[id]];
            id = Math.floor((id - 1) / 2);
            par = Math.floor((id - 1) / 2);
        }
    }

    pop() {
        let ret = this.heap[0];
        this.heap[0] = this.heap[this.heap.length - 1];
        this.heap.pop();
        this.recurDown(0);
        return ret * this.fct;
    }

    recurDown(node) {
        let l = node * 2 + 1;
        let r = node * 2 + 2;

        let cur = node;
        if (l < this.heap.length && this.heap[cur] > this.heap[l]) cur = l;
        if (r < this.heap.length && this.heap[cur] > this.heap[r]) cur = r;
        if (cur != node) {
            [this.heap[node], this.heap[cur]] = [this.heap[cur], this.heap[node]];
            this.recurDown(cur);
        }
    }

    size() {
        return this.heap.length;
    }

    empty() {
        return this.heap.length == 0;
    }
}

module.exports = {
    solve: function (A, B) {
        adj = new Map();
        for (let i = 1; i <= A; i++) {
            adj.set(i, []);
        }
        inp = new Array(A + 1).fill(0);
        for (let i = 0; i < B.length; i++) {
            let a = B[i][0];
            let b = B[i][1];
            adj.get(a).push(b);
            inp[b]++;
        }

        let pq = new PriorityQueue(1);
        for (let i = 1; i <= A; i++) {
            if (inp[i] == 0) pq.push(i);
        }
        let ans = [];
        while (!pq.empty()) {
            let temp = pq.pop();
            ans.push(temp);
            for (let i = 0; i < adj.get(temp).length; i++) {
                inp[adj.get(temp)[i]]--;
                if (inp[adj.get(temp)[i]] == 0) pq.push(adj.get(temp)[i]);
            }
        }
        if (ans.length != A) ans = [];
        return ans;
    },
};
```
* * Solution in C++
```cpp
const int maxn = 10009;
vector < int > adj[maxn];
int in [maxn];
vector < int > Solution::solve(int A, vector < vector < int > > & B) {
    for (int i = 0; i < maxn; i++) adj[i].clear();
    memset( in , 0, sizeof( in ));
    for (auto & it: B) {
        adj[it[0]].push_back(it[1]); in [it[1]]++;
    }
    priority_queue < int, vector < int > , greater < int > > pq;
    for (int i = 1; i <= A; i++) {
        if ( in [i] == 0)
            pq.push(i);
    }
    vector < int > ans;
    while (pq.empty() == false) {
        int temp = pq.top();
        pq.pop();
        ans.push_back(temp);
        for (int v: adj[temp]) {
            in [v]--;
            if (in[v] == 0) 
                pq.push(v);
        }
    }
    if (ans.size() != A) 
        ans.clear();
    return ans;
}
```

