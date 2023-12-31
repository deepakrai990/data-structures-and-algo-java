### Q2. Possibility of Finishing
#### Problem Description
```text
There are a total of A courses you have to take, labeled from 1 to A.

Some courses may have prerequisites, for example to take course 2 you have to first 
take course 1, which is expressed as a pair: [1,2].

So you are given two integer array B and C of same size where for 
each i (B[i], C[i]) denotes a pair.

Given the total number of courses and a list of prerequisite pairs, is it possible 
for you to finish all courses?

Return 1 if it is possible to finish all the courses, or 0 if it is not possible to 
finish all the courses.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A &lt;= 6*10<sup>4</sup></p>
    <p>1 &lt;= length(B) = length(C) &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= B[i], C[i] &lt;= A</p>
</div>

```text
1 <= A <= 6*10^4

1 <= length(B) = length(C) <= 10^5

1 <= B[i], C[i] <= A
```
#### Input Format
```text
The first argument of input contains an integer A, representing the number of courses.

The second argument of input contains an integer array, B.

The third argument of input contains an integer array, C.
```
#### Output Format
```text
Return 1 if it is possible to finish all the courses, or 0 if it is not possible 
to finish all the courses.
```
#### Example Input
```text
Input 1:
 A = 3
 B = [1, 2]
 C = [2, 3]

Input 2:
 A = 2
 B = [1, 2]
 C = [2, 1]
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
    It is possible to complete the courses in the following order:
        1 -> 2 -> 3

Explanation 2:
    It is not possible to complete all the courses.
```
### Hints
* Hint 1
```text
Think in terms of directed graphs and dependencies. What’s the minimal property of the 
graph for a solution to exist?

Think what will be the output if there is a cycle in the graph formed.
```
* Solution Approach
```text
Consider a graph with courses from 1 to N representing the nodes of the graph and each 
prerequisite pair [u, v] correspond to a directed edge from u to v.

It is obvious that we will get several disjoint components of the graph.

 When is it possible for you to finish all the courses?

The problem reduces down to finding a directed cycle in the whole graph. If any such 
cycle is present, it is not possible to finish all the courses.

Depth First Traversal(DFS) can be used to detect cycle in a Graph. There is a cycle 
in a graph only if there is a back edge present in the graph. A back edge is an edge 
that is from a node to itself (self loop) or one of its ancestor in the tree produced 
by DFS.

For a disconnected graph, we can check for cycle in individual DFS trees by checking 
back edges.

We can use various methods for detecting a back edge. One of the method is by using 
the method of coloring. Assume the non-visited node are colored black, the nodes 
currently present in the recursion stack are colored blue and the nodes already 
visited and out of the recursion stack are colored grey. The edge that connects 
current vertex in DFS to the vertex in the recursion stack(blue coloured node) is back edge.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int maxn = 100009;
    static ArrayList < ArrayList < Integer > > g;
    static int[] visited = new int[maxn];
    static int f = 0;
    public static void graph() {
        g = new ArrayList < ArrayList < Integer > > (maxn);
        for (int i = 0; i < maxn; i++) {
            visited[i] = 0;
            g.add(new ArrayList < Integer > ());
        }
    }
    public int solve(int A, int[] B, int[] C) {
        graph();
        for (int i = 0; i < B.length; i++) {
            g.get(B[i]).add(C[i]);
        }
        for (int i = 1; i <= A; i++) {
            if (visited[i] == 0) {
                f = 0;
                check_cycle(i);
                if (f == 1)
                    break;
            }
        }
        f = 1 - f;
        return f;
    }
    public static void check_cycle(int u) {
        visited[u] = 1;
        for (int v: g.get(u)) {
            if (visited[v] == 0)
                check_cycle(v);
            else if (visited[v] == 1)
                f = 1;
        }
        visited[u] = 2;
    }
}
```
* * Solution in Javascript
```javascript
const MAXN = 100005;
const BLACK = 0;
const BLUE = 1;
const GREY = 2;
let g = new Array(MAXN);
let f;

function check_cycle(u, visited) {
    visited[u] = BLUE;
    for (let i = 0; i < g[u].length; i++) {
        let v = g[u][i];
        if (visited[v] == BLACK) {
            check_cycle(v, visited);
        } else if (visited[v] == BLUE) {
            //cycle found
            f = true;
        }
    }
    visited[u] = GREY;
}

module.exports = {
    solve: function (N, B, C) {
        f = false;
        let visited = new Array(MAXN).fill(0);
        for (let i = 1; i <= N; i++) {
            g[i] = [];
        }
        for (let i = 0; i < B.length; i++) {
            g[B[i]].push(C[i]);
        }
        for (let i = 1; i <= N; i++) {
            if (visited[i] == BLACK) {
                check_cycle(i, visited);
                if (f) {
                    break;
                }
            }
        }
        return !f ? 1 : 0;
    },
};
```
* * Solution in C++
```cpp
#define MAXN 100005
#define BLACK 0
#define BLUE 1
#define GREY 2
vector < int > g[MAXN];
void check_cycle(int u, int visited[], bool & f) {
    visited[u] = BLUE;
    for (auto v: g[u]) {
        if (visited[v] == BLACK) {
            check_cycle(v, visited, f);
        } else if (visited[v] == BLUE) {
            //cycle found
            f = true;
        }
    }
    visited[u] = GREY;
}

int Solution::solve(int N, vector < int > & B, vector < int > & C) {
    bool f = false;
    int visited[MAXN] = {0};
    for (int i = 1; i <= N; i++) {
        g[i].clear();
    }
    for (int i = 0; i < B.size(); i++) {
        g[B[i]].push_back(C[i]);
    }
    for (int i = 1; i <= N; i++) {
        if (visited[i] == BLACK) {
            check_cycle(i, visited, f);
            if (f) {
                break;
            }
        }
    }
    return !f;
}
```

