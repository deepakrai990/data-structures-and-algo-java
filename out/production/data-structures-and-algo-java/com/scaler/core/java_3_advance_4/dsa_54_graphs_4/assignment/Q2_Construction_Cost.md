### Q2. Construction Cost
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given a graph with <strong>A</strong> nodes and <strong>C</strong> 
    weighted edges. Cost of constructing the graph is the sum of weights of all 
    the edges in the graph.</p><p></p><p></p><p></p><p></p><p></p>
    <p>Find the <strong>minimum cost</strong> of constructing the graph by selecting 
    some given edges such that we can reach every other node from the 
    <strong>1<sup>st</sup></strong> node.</p>
    <p><strong>NOTE: </strong>Return the answer modulo <strong>10<sup>9</sup>+7</strong> 
    as the answer can be large.</p>
</div>

```text
Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the 
sum of weights of all the edges in the graph.

Find the minimum cost of constructing the graph by selecting some given edges such that 
we can reach every other node from the 1^st node.

NOTE: Return the answer modulo 10^9+7 as the answer can be large.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A &lt;= 100000<br>
    0 &lt;= C &lt;= 100000<br>
    1 &lt;= B[i][0], B[i][1] &lt;= N<br>
    1 &lt;= B[i][2] &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= A <= 100000
0 <= C <= 100000
1 <= B[i][0], B[i][1] <= N
1 <= B[i][2] <= 10^9
```
#### Input Format
```text
First argument is an integer A.
Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] 
and B[i][1] are connected by ith edge with weight B[i][2]
```
#### Output Format
```text
Return an integer denoting the minimum construction cost.
```
#### Example Input
```text
Input 1:
A = 3
B = [   [1, 2, 14]
        [2, 3, 7]
        [3, 1, 2]   ]

Input 2:
A = 3
B = [   [1, 2, 20]
        [2, 3, 17]  ]
```
#### Example Output
```text
Output 1:
 9

Output 2:
 37
```
#### Example Explanation
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Explanation 1:</p>
    <pre>We can take only two edges (2 -&gt; 3 and 3 -&gt; 1) to construct the graph. 
    we can reach the 1<sup>st</sup> node from 2<sup>nd</sup> and 3<sup>rd</sup> 
    node using only these two edges.
    So, the total cost of construction is 9.
    </pre>
    <p>Explanation 2:</p>
    <pre>We have to take both the given edges so that we can reach the 1<sup>st</sup> 
    node from 2<sup>nd</sup> and 3<sup>rd</sup> node.</pre>
</div>

```text
Explanation 1:
    We can take only two edges (2 -> 3 and 3 -> 1) to construct the graph. 
    we can reach the 1^st node from 2^nd and 3^rd node using only these two edges.
    So, the total cost of construction is 9.

Explanation 2:
    We have to take both the given edges so that we can reach the 1^st node 
    from 2^nd and 3^rd node.
```
### Hints
* Hint 1
```text
Graph with minimum cost will not have any cycles.

If any cycles are present, we can remove some edges from the graph to reduce the cost.
```
* Solution Approach
<p>As it can be easily be seen that the graph will not have any cycles and every other 
node should be reachable from the 1<sup>st</sup>.</p>

```text
As it can be easily be seen that the graph will not have any cycles and every other 
node should be reachable from the 1^st.

The resulting graph is connected and without cycles. So, it will be a tree.

To minimize the cost, we can find minimum spanning tree using Kruskal or Prim algorithms.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int maxn = 100009;
    static int[] arr = new int[maxn];
    static int[] sz = new int[maxn];
    static ArrayList < pair > edges;
    static long mod = 1000000007;
    public int solve(int A, int[][] B) {
        ini();
        for (int i = 0; i < B.length; i++)
            edges.add(new pair(B[i][2], i));
        Collections.sort(edges);
        int ans = 0;
        for (pair p: edges) {
            int ind = p.second;
            int val = p.first;
            int u = B[ind][0];
            int v = B[ind][1];
            if (root(u) == root(v))
                continue;
            else {
                un(u, v);
                ans += (int) val;
                ans %= mod;
            }
        }
        return (int) ans;

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
    int first;
    int second;
    public pair(int a, int b) {
        this.first = a;
        this.second = b;
    }
    @Override
    public int compareTo(pair temp) {
        return this.first - temp.first;
    }
}
```
* * Solution in Javascript
```javascript
const maxn = 100009;
let arr = new Array(maxn);
let sz = new Array(maxn);
let edges = [];
const mod = 1000000007;

function ini() {
    edges = [];
    for (let i = 0; i < maxn; i++) {
        arr[i] = i;
        sz[i] = 1;
    }
}

function root(a) {
    while (arr[a] != a) {
        arr[a] = arr[arr[a]];
        a = arr[a];
    }
    return a;
}

function un(a, b) {
    let ra = root(a);
    let rb = root(b);
    if (sz[ra] <= sz[rb]) {
        arr[ra] = rb;
        sz[rb] += sz[ra];
    } else {
        arr[rb] = ra;
        sz[ra] += sz[rb];
    }
}
module.exports = {
    //param A : integer
    //param B : array of array of integers
    //return an integer
    solve: function (A, B) {
        ini();
        for (let i = 0; i < B.length; i++)
            edges.push([B[i][2], i]);
        edges.sort(function (a, b) {
            return a[0] - b[0]
        });
        let ans = 0;
        for (let i = 0; i < edges.length; i++) {
            let p = edges[i];
            let ind = p[1];
            let val = p[0];
            let u = B[ind][0];
            let v = B[ind][1];
            if (root(u) == root(v))
                continue;
            else {
                un(u, v);
                ans += val;
                ans %= mod;
            }
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
class DSU {
    private:
        vector < int > parent;
    vector < int > rank;
    public:
        DSU(int x) {
            parent.resize(x, 0);
            rank.resize(x, 1);
            for (int i = 0; i < x; i++) {
                parent[i] = i;
            }
        }
    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[parent[x]]);
        return parent[x];
    }
    int merge(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py)
            return 0;
        if (rank[px] < rank[py]) {
            parent[px] = py;
            rank[py] += rank[px];
        } else {
            parent[py] = px;
            rank[px] += rank[py];
        }
        return 1;
    }
};

int Solution::solve(int A, vector < vector < int > > & B) {
    vector < pair < int, int >> edges;
    for (int i = 0; i < B.size(); i++) {
        int weight = B[i][2];
        edges.push_back({weight, i});
    }
    sort(edges.begin(), edges.end());
    DSU dsu(A + 1);
    int ans = 0, Mod = 1000000007;
    for (int i = 0; i < edges.size(); i++) {
        int ind = edges[i].second, val = edges[i].first;
        int u = B[ind][0], v = B[ind][1];
        int f = dsu.merge(u, v);
        if (f == 1) {
            ans += val;
            ans %= Mod;
        }
    }
    return ans;
}
```

