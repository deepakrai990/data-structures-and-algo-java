### Q2. Poisonous Graph
#### Problem Description
```text
You are given an undirected unweighted graph consisting of A vertices and M edges given in a form of 2D Matrix B of size M x 2 where (B[i][0], B][i][1]) denotes two nodes connected by an edge.

You have to write a number on each vertex of the graph. Each number should be 1, 2 or 3. The graph becomes Poisonous if for each edge the sum of numbers on vertices connected by this edge is odd.

Calculate the number of possible ways to write numbers 1, 2 or 3 on vertices so the graph becomes poisonous. Since this number may be large, return it modulo 998244353.

NOTE:
    * Note that you have to write exactly one number on each vertex.
    * The graph does not have any self-loops or multiple edges.
    * Nodes are labelled from 1 to A.
```
#### Problem Constraints
```text
1 <= A <= 3*10^5

0 <= M <= 3*10^5

1 <= B[i][0], B[i][1] <= A

B[i][0] != B[i][1]
```
#### Input Format
```text
First argument is an integer A denoting the number of nodes.

Second argument is an 2D Matrix B of size M x 2 denoting the M edges.
```
#### Output Format
```text
Return one integer denoting the number of possible ways to write numbers 1, 2 or 3 on 
the vertices of given graph so it becomes Poisonous . Since answer may be large, print 
it modulo 998244353.
```
#### Example Input
```text
Input 1:
 A = 2
 B = [  [1, 2]
     ]

Input 2:
 A = 4
 B = [  [1, 2]
        [1, 3]
        [1, 4]
        [2, 3]
        [2, 4]
        [3, 4]
    ]
```
#### Example Output
```text
Output 1:
 4

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    There are 4 ways to make the graph poisonous. i.e, writing number on node 1 and 2 as,
        [1, 2] , [3, 2], [2, 1] or [2, 3] respectively.

Explanation 2:
    There is no way to make the graph poisonous.
```
### Hints
* Hint 1
```text
We can solve the problem for each connected component of the graph independently 
and multiply the answers.

Let’s analyze a connected component. If some vertex has an odd number written on 
it, then we should write even numbers on all adjacent vertices, and vice versa.
```
* Solution Approach
<div>
    <p>We can solve the problem for each connected component of the graph 
    independently and multiply the answers.<br>
    Let’s analyze a connected component. If some vertex has an odd number written 
    on it, then we should write even numbers on all adjacent vertices, and 
    vice versa.<br>
    So in fact we need to check if the component is <strong>bipartite</strong>, 
    and if it is, divide it into two parts.<br>
    The number of ways to assign values to this connected component such that it 
    remains poisonous is <strong>2<sup>a</sup>+2<sup>b</sup></strong>, where 
    <strong>a</strong> is the size of the first part, and <strong>b</strong> is 
    the size of the second part, because we write <strong>2’s</strong> into all 
    vertices of one part, and <strong>1’s</strong> or <strong>3’s</strong> into 
    all vertices of another part</p>
    <p>Also if any of the component is not bipartite then answer will be 0.</p>
</div>

```text
We can solve the problem for each connected component of the graph independently 
and multiply the answers.

Let’s analyze a connected component. If some vertex has an odd number written on it, 
then we should write even numbers on all adjacent vertices, and vice versa.

So in fact we need to check if the component is bipartite, and if it is, divide it 
into two parts.

The number of ways to assign values to this connected component such that it 
remains poisonous is 2^a + 2^b, where a is the size of the first part, and b is the 
size of the second part, because we write 2’s into all vertices of one part, 
and 1’s or 3’s into all vertices of another part

Also if any of the component is not bipartite then answer will be 0.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int maxn = 300009;
    static long mod = 998244353;
    static int[] visited = new int[maxn];
    static long[] dp = new long[maxn];
    static ArrayList < ArrayList < Integer > > adj;
    static int a, b;
    public static void graph() {
        adj = new ArrayList < ArrayList < Integer > > (maxn);
        for (int i = 0; i < maxn; i++) {
            visited[i] = -1;
            adj.add(new ArrayList < Integer > ());
        }
    }
    public static void pre() {
        dp[0] = 1;
        for (int i = 1; i < maxn; i++) {
            dp[i] = ((long) 2) * dp[i - 1];
            dp[i] %= mod;
        }
    }
    public int solve(int A, int[][] B) {
        graph();
        pre();
        for (int[] edge: B) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        long ans = 1;
        for (int i = 1; i <= A; i++) {
            if (visited[i] == -1) {
                a = 0;
                b = 0;
                if (bfs(i) == false)
                    return 0;
                long res = ((dp[a] % mod) + (dp[b] % mod)) % mod;
                ans = ((ans % mod) * (res % mod)) % mod;
            }
        }
        return (int) ans;
    }
    public static boolean bfs(int s) {
        visited[s] = 1;
        a++;
        Queue < Integer > q = new ArrayDeque < > ();
        q.offer(s);
        while (q.size() > 0) {
            int temp = q.poll();
            for (int v: adj.get(temp)) {
                if (visited[v] == -1) {
                    visited[v] = 1 - visited[temp];
                    if (visited[v] == 0) b++;
                    else a++;
                    q.offer(v);
                } else if (visited[v] == visited[temp])
                    return false;
            }
        }
        return true;
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

const maxn = 300009;
const mod = 998244353;
let adj = new Array(maxn).fill([]);
let visited = new Array(maxn).fill();
let dp = new Array(maxn).fill(); //storing all powers of 2

function pre() {
    dp[0] = 1;
    for (let i = 1; i < maxn; i++) dp[i] = mult(2, dp[i - 1] % mod);
}
let a, b;
function bfs(s) {
    visited[s] = 1;
    a++;

    let q = new Queue();
    q.enqueue(s);

    while (q.isEmpty() == false) {
        let temp = q.dequeue();
        for (let i = 0; i < adj[temp].length; i++) {
            let v = adj[temp][i];
            if (visited[v] == -1) {
                visited[v] = 1 - visited[temp];
                if (visited[v] == 0) b++;
                else a++;
                q.enqueue(v);
            } else if (visited[v] == visited[temp]) return false;
        }
    }
    return true;
}
module.exports = {
    solve: function (A, B) {
        pre();
        for (let i = 0; i <= A; i++) {
            adj[i] = [];
            visited[i] = -1;
        }
        B.forEach((it) => {
            adj[it[0]].push(it[1]);
            adj[it[1]].push(it[0]);
        });

        let ans = 1;
        for (let i = 1; i <= A; i++) {
            if (visited[i] == -1) {
                a = 0;
                b = 0;
                if (bfs(i) == false) return 0;
                let res = ((dp[a] % mod) + (dp[b] % mod)) % mod;
                ans = mult(ans % mod, res % mod);
            }
        }
        return ans;
    },
};

function mult(a, b) {
    let val = a * b;
    if (val <= Number.MAX_SAFE_INTEGER && val >= Number.MIN_SAFE_INTEGER)
        return val % mod;
    return Number((BigInt(a) * BigInt(b)) % BigInt(mod));
}
```
* * Solution in C++
```cpp
#define ll long long
const int maxn = 300009;
const int mod = 998244353;
vector < int > adj[maxn];
int visited[maxn];
ll dp[maxn]; //storing all powers of 2
void pre() {
    dp[0] = 1;
    for (int i = 1; i < maxn; i++)
        dp[i] = ((2LL % mod) * (dp[i - 1] % mod)) % mod;
}
bool bfs(int s, int & a, int & b) {
    visited[s] = 1;
    a++;
    queue < int > q;
    q.push(s);
    while (q.empty() == false) {
        int temp = q.front();
        q.pop();
        for (int v: adj[temp]) {
            if (visited[v] == -1) {
                visited[v] = 1 - visited[temp];
                if (visited[v] == 0) b++;
                else a++;
                q.push(v);
            } else if (visited[v] == visited[temp]) return false;
        }
    }
    return true;
}
int Solution::solve(int A, vector < vector < int > > & B) {
    pre();
    for (int i = 0; i <= A; i++) {
        adj[i].clear();
        visited[i] = -1;
    }
    for (auto & it: B) {
        adj[it[0]].push_back(it[1]);
        adj[it[1]].push_back(it[0]);
    }
    ll ans = 1;
    for (int i = 1; i <= A; i++) {
        if (visited[i] == -1) {
            int a = 0;
            int b = 0;
            if (bfs(i, a, b) == false)
                return 0;
            ll res = ((dp[a] % mod) + (dp[b] % mod)) % mod;
            ans = ((ans % mod) * (res % mod)) % mod;
        }
    }
    return ans;
}
```

