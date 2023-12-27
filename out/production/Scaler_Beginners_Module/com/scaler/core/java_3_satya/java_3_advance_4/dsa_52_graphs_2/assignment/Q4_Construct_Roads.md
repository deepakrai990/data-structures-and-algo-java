### Q4. Construct Roads
#### Problem Description
```text
A country consist of N cities connected by N - 1 roads. King of that country want to 
construct maximum number of roads such that the new country formed remains bipartite country.

Bipartite country is a country, whose cities can be partitioned into 2 sets in 
such a way, that for each road (u, v) that belongs to the country, u and v belong 
to different sets. Also, there should be no multiple roads between two cities and 
no self loops.
```

<p>Return the maximum number of roads king can construct. Since the answer 
    could be large return <strong>answer % 10<sup>9</sup> + 7</strong>.</p>

```text
NOTE: All cities can be visited from any city.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= B[i][0], B[i][1] &lt;= N </p>
</div>

```text
1 <= A <= 10^5

1 <= B[i][0], B[i][1] <= N
```
#### Input Format
```text
First argument is an integer A denoting the number of cities, N.

Second argument is a 2D array B of size (N-1) x 2 denoting the initial roads i.e. there 
is a road between cities B[i][0] and B[1][1] .
```
#### Output Format
```text
Return an integer denoting the maximum number of roads king can construct.
```
#### Example Input
```text
Input 1:
 A = 3
 B = [
       [1, 2]
       [1, 3]
     ]

Input 2:
 A = 5
 B = [
       [1, 3]
       [1, 4]
       [3, 2]
       [3, 5]
     ]
```
#### Example Output
```text
Output 1:
 0

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
    We can't construct any new roads such that the country remains bipartite.

Explanation 2:
    We can add two roads between cities (4, 2) and (4, 5).
```
### Hints
* Hint 1
```text
We can convert the given problem as the city can be considered as nodes of the tree 
and roads as the edge.

As we know, the tree is itself bipartite.

Run a Depth First search over the given tree and partition it into two sets.
```
* Solution Approach
```text
As we know, the tree is itself bipartite.

Run a Depth First search over the given tree and partition it into two sets.

We can’t add an edge between any 2 nodes in the same set and we can add an edge 
between every 2 nodes in different sets, so let the number of nodes in the left 
set be x and the number of nodes in the right set be y.

The maximum number of edges that can exist is x * y, but N - 1 edges already exist so 
the maximum number of edges to be added is x * y - (N - 1).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int maxn = 100009;
    static long[] col = new long[2];
    static long mod = 1000000007;
    static ArrayList<ArrayList<Integer>> adj;

    public static void graph() {
        adj = new ArrayList<ArrayList<Integer>>(maxn);
        for (int i = 0; i < maxn; i++) {
            adj.add(new ArrayList<Integer>());
        }
        col[0] = 0;
        col[1] = 0;
    }

    public int solve(int A, int[][] B) {
        graph();
        for (int[] edge : B) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        dfs(1, 0, 0);
        long ans = col[0] * col[1];
        ans -= A - 1;
        ans %= mod;
        return (int) ans;
    }

    public static void dfs(int u, int pnode, int c) {
        col[c]++;
        for (int v : adj.get(u)) {
            if (v != pnode) {
                dfs(v, u, 1 - c);
            }
        }
    }
}
```
* * Solution in Javascript
```javascript
const maxN = 1e5 + 5;
let col = new Array(2);
let g = new Array(maxN).fill([]);
const mod = 1e9 + 7;

function dfs(u, pnode, c) {
  col[c]++;
  // for(auto v: g[u]){
  for (let i = 0; i < g[u].length; i++) {
    let v = g[u][i];
    if (v != pnode) {
      dfs(v, u, 1 - c);
    }
  }
}

module.exports = {
  solve: function (A, B) {
    let N = A;
    col[0] = col[1] = 0;
    for (let i = 0; i <= N; i++) {
      g[i] = [];
    }

    for (let i = 0; i < B.length; i++) {
      let u = B[i][0],
        v = B[i][1];
      g[u].push(v);
      g[v].push(u);
    }
    dfs(1, 0, 0);
    let ans = col[0] * col[1];
    ans -= N - 1;
    return ans % mod;
  },
};
```
* * Solution in C++
```cpp
const int maxN = 1e5 + 5;
long long col[2];
vector < int > g[maxN];
const int mod = 1e9 + 7;

void dfs(int u, int pnode, int c) {
    col[c]++;
    for (auto v: g[u]) {
        if (v != pnode) {
            dfs(v, u, 1 - c);
        }
    }
}

int Solution::solve(int A, vector < vector < int > > & B) {
    int N = A;
    col[0] = col[1] = 0;
    for (int i = 0; i <= N; i++) {
        g[i].clear();
    }
    for (int i = 0; i < B.size(); i++) {
        int u = B[i][0], v = B[i][1];
        g[u].push_back(v);
        g[v].push_back(u);
    }
    dfs(1, 0, 0);
    long long ans = col[0] * col[1];
    ans -= N - 1;
    return ans % mod;
}
```

