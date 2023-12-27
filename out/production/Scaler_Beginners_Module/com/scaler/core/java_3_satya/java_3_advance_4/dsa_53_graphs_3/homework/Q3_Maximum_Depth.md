### Q3. Maximum Depth
#### Problem Description
```text
Given a Tree of A nodes having A-1 edges. Each node is numbered from 1 to A 
where 1 is the root of the tree.

You are given Q queries. In each query, you will be given two integers L and X. Find 
the value of such node which lies at level L mod (MaxDepth + 1) and has value greater 
than or equal to X.

Answer to the query is the smallest possible value or -1, if all the values at the 
required level are smaller than X.

NOTE:
    * Level and Depth of the root is considered as 0.
    * It is guaranteed that each edge will be connecting exactly two different nodes 
      of the tree.
    * Please read the input format for more clarification.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>2 &lt;= A, Q(size of array E and F) &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= B[i], C[i] &lt;= A</p>
    <p>1 &lt;= D[i], E[i], F[i] &lt;= 10<sup>6</sup></p>
</div>

```text
2 <= A, Q(size of array E and F) <= 10^5

1 <= B[i], C[i] <= A

1 <= D[i], E[i], F[i] <= 10^6
```
#### Input Format
```text
The first argument is an integer A denoting the number of nodes.

The second and third arguments are the integer arrays B and C where for 
each i (0 <= i < A-1), B[i] and C[i] are the nodes connected by an edge.

The fourth argument is an integer array D, where D[i] denotes the value of 
the (i+1)th node

The fifth and sixth arguments are the integer arrays E and F where for 
each i (0 <= i < Q), E[i] denotes L and F[i] denotes X for i^th query.
```
<p>The fifth and sixth arguments are the integer arrays E and F where 
for each i (0 &lt;= i &lt; Q), E[i] denotes L and F[i] denotes X 
for i<sup>th</sup> query.</p>

#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Return an array of integers where the i<sup>th</sup> element denotes the 
    answer to i<sup>th</sup> query.</p>
</div>

```text
Return an array of integers where the i^th element denotes the answer to i^th query.
```
#### Example Input
```text
Input 1:
 A = 5
 B = [1, 4, 3, 1]
 C = [5, 2, 4, 4]
 D = [7, 38, 27, 37, 1]
 E = [1, 1, 2]
 F = [32, 18, 26]

Input 2:
 A = 3
 B = [1, 2]
 C = [3, 1]
 D = [7, 15, 27]
 E = [1, 10, 1]
 F = [29, 6, 26]
```
#### Example Output
```text
Output 1:
 [37, 37, 27]

Output 2:
 [-1, 7, 27]
```
#### Example Explanation
```text
Explanation 1:

      1[7]
     /    \
   5[1]  4[37]
        /    \
       2[38]  3[27]

 Query 1: 
    L = 1, X = 32
    Nodes for level 1 are 5, 4
    Value of Node 5 = 1 < 32
    Value of Node 4 = 37 >= 32
    Ans = 37

Explanation 2:

      1[7]
     /    \
   2[15]  3[27]

 Query 1: 
    L = 1, X = 6
    Nodes for level 1 are 2, 3 having value 15 and 27 respectively.
    Answer = -1 (Since no node is greater or equal to 29).
 Query 1: 
    L = 10 % 2 = 0, X = 6
    Nodes for level 0 is 1 having value 7.
    Answer = 7.    
```
### Hints
* Hint 1
```text
Can we use binary search for nodes at a particular level?
```
* Solution Approach
```text
Main idea is to maintain list of nodes at every different level.

Can we do that with dfs or bfs?

To maintain the list, Call dfs from the root of tree(1) and insert the node at in the 
list at particularr level.

For each query, Use binary search to find the required value at a particular level.

If there is no value present which is greater or equal to x, output -1.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int maxn = 100009;
    static int n, q;
    static int mx = 0;
    static int[] val = new int[maxn];
    static ArrayList < ArrayList < Integer > > adj;
    static ArrayList < ArrayList < Integer > > lvl;
    public static void graph() {
        adj = new ArrayList < ArrayList < Integer > > (maxn);
        lvl = new ArrayList < ArrayList < Integer > > (maxn);
        for (int i = 0; i < maxn; i++) {
            adj.add(new ArrayList < Integer > ());
            lvl.add(new ArrayList < Integer > ());
        }
        mx = 0;
    }
    public int[] solve(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {
        graph();
        n = A;
        q = F.length;
        for (int i = 0; i < n; i++)
            val[i + 1] = D[i];
        for (int i = 0; i < n - 1; i++) {
            adj.get(B[i]).add(C[i]);
            adj.get(C[i]).add(B[i]);
        }
        mx = 0;
        dfs(1, 1, 0);
        for (int i = 0; i < maxn; i++) {
            Collections.sort(lvl.get(i));
        }
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            int l = E[i];
            int x = F[i];
            l %= (mx + 1);
            int it = lowerBound(lvl.get(l), 0, lvl.get(l).size(), x);
            if (it == lvl.get(l).size())
                res[i] = -1;
            else res[i] = lvl.get(l).get(it);
        }
        return res;
    }
    public static void dfs(int u, int v, int d) {
        mx = Math.max(mx, d);
        lvl.get(d).add(val[u]);
        for (int i: adj.get(u)) {
            if (i == v) continue;
            dfs(i, u, d + 1);
        }
    }
    static int lowerBound(ArrayList < Integer > a, int low, int high, int element) {
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (element > a.get(middle)) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }
}
```
* * Solution in Javascript
```javascript
const maxn = 100009;
let n = 0;
let q = 0;
let mx = 0;
let val = new Array(maxn);
let adj = new Array(maxn);
let lvl = new Array(maxn);

function graph() {
    for (let i = 0; i < maxn; i++) {
        adj[i] = [];
        lvl[i] = [];
    }
    mx = 0;
}

function dfs(u, v, d) {
    mx = Math.max(mx, d);
    lvl[d].push(val[u]);
    for (let j = 0; j < adj[u].length; j++) {
        let i = adj[u][j];
        if (i == v) continue;
        dfs(i, u, d + 1);
    }
}

function lowerBound(a, low, high, element) {
    while (low < high) {
        let middle = low + ((high - low) >> 1);
        if (element > a[middle]) {
            low = middle + 1;
        } else {
            high = middle;
        }
    }
    return low;
}
module.exports = {
    //param A : integer
    //param B : array of integers
    //param C : array of integers
    //param D : array of integers
    //param E : array of integers
    //param F : array of integers
    //return a array of integers
    solve: function (A, B, C, D, E, F) {
        graph();
        n = A;
        q = F.length;
        for (let i = 0; i < n; i++)
            val[i + 1] = D[i];
        for (let i = 0; i < n - 1; i++) {
            adj[B[i]].push(C[i]);
            adj[C[i]].push(B[i]);
        }
        mx = 0;
        dfs(1, 1, 0);
        for (let i = 0; i < maxn; i++) {
            lvl[i].sort(function (a, b) {
                return a - b
            });
        }
        let res = new Array(q);
        for (let i = 0; i < q; i++) {
            let l = E[i];
            let x = F[i];
            l %= (mx + 1);
            let it = lowerBound(lvl[l], 0, lvl[l].length, x);
            if (it == lvl[l].length)
                res[i] = -1;
            else
                res[i] = lvl[l][it];
        }
        return res;
    }
};
```
* * Solution in C++
```cpp
const int N = 1e5 + 10;
int n, q, val[N], mx = 0;
vector < int > adj[N];
set < int > lvl[N];

void dfs(int u, int v, int d) {
    mx = max(mx, d);
    lvl[d].insert(val[u]);
    for (auto i: adj[u]) {
        if (i == v)
            continue;
        dfs(i, u, d + 1);
    }
}

vector < int > Solution::solve(int A, vector < int > & B, vector < int > & C, vector < int > & D, vector < int > & E, vector < int > & F) {
    n = A;
    q = F.size();
    for (int i = 0; i <= n; i++) {
        adj[i].clear();
        lvl[i].clear();
        val[i + 1] = D[i];
    }
    for (int i = 0; i < n - 1; i++) {
        adj[B[i]].push_back(C[i]);
        adj[C[i]].push_back(B[i]);

    }
    mx = 0;
    dfs(1, 1, 0);
    vector < int > res;
    for (int i = 0; i < q; i++) {
        int l = E[i], x = F[i];
        l %= (mx + 1);
        set < int > ::iterator it = lvl[l].lower_bound(x);
        if (it == lvl[l].end())
            res.push_back(-1);
        else
            res.push_back( * it);
    }
    return res;
}
```

