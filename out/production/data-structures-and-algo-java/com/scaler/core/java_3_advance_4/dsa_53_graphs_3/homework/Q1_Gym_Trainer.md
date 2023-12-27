### Q1. Gym Trainer
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>You are the trainer of a gym and there are <strong>A</strong> people who 
    come to your gym.</p>
    <p>Some of them are friends because they walk together, and some of them are 
    friends because they talk together.<br>
    But people become possessive about each other, so a person cannot walk with one 
    friend and talk with another. Although he can walk with two or more people or talk 
    with two or more people.</p>
    <p>You being the trainer, decided to suggest each one of the 2 possible diets. 
    But friends, being friends will always have the same diet as all the other friends 
    are having.</p>
    <p>Find and return the <strong>number of ways</strong> you can suggest each of 
    them a diet.</p>
    <p>As the number of ways can be huge, return the answer modulo 10<sup>9</sup>+7.</p>
    <p><strong>NOTE:</strong> If there is any person who walks with one person and 
    talks with the another person, then you may return 0.</p>
</div>

```text
You are the trainer of a gym and there are A people who come to your gym.

Some of them are friends because they walk together, and some of them are friends 
because they talk together.
But people become possessive about each other, so a person cannot walk with one friend 
and talk with another. Although he can walk with two or more people or talk with two or 
more people.

You being the trainer, decided to suggest each one of the 2 possible diets. But friends, 
being friends will always have the same diet as all the other friends are having.

Find and return the number of ways you can suggest each of them a diet.

As the number of ways can be huge, return the answer modulo 10^9+7.

NOTE: If there is any person who walks with one person and talks with the another person, 
then you may return 0.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A, N, M &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= B[i][0], B[i][1], C[i][0], C[i][1] &lt;= A</p>
</div>

```text
1 <= A, N, M <= 10^5

1 <= B[i][0], B[i][1], C[i][0], C[i][1] <= A
```
#### Input Format
```text
The first argument contains an integer A, representing the number of people.

The second argument contains a 2-D integer array B of size N x 2, where B[i][0] 
and B[i][1] are friends because they walk together.

The third argument contains a 2-D integer array C of size M x 2, where C[i][0] 
and C[i][1] are friends because they talk together.
```
#### Output Format
```text
Return an integer representing the number of ways to suggest one of the two 
diets to the people.
```
#### Example Input
```text
Input 1:
 A = 4
 B = [
       [1, 2]
     ]
 C = [
       [3, 4]
     ]

Input 2:
 A = 3
 B = [
       [1, 2]
     ]
 C = [
       [1, 3] 
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
    There are four ways to suggest the diet:
    Diet-1 to (1, 2) and Diet-2 to (3, 4).
    Diet-1 to (1, 2) and Diet-1 to (3, 4).
    Diet-2 to (1, 2) and Diet-1 to (3, 4).
    Diet-2 to (1, 2) and Diet-2 to (3, 4).

Explanation 2:
    Person 1 walks with person 2 and talks with person 3. So, we will return 0.
```
### Hints
* Hint 1
```text
We have only 2 diets.

So the possible ways will be power(2, (Number of groups of friends)).
```
* Solution Approach
```text
Our task is to find the number of groups of friends formed. Since all persons in a 
groups will have same diet. There is only two possibility for each group.

So the number of ways will be power(2, (Number of groups of friends)).

We can efficiently find the number of groups by using disjoint set and union.

Iterate over the walk friends and talk friends one by one.
If the friends are not in same component, do union.

After this count the number of component that will be our number of groups of friend.
Return power(2,cnt).

NOTE: We also need to check that there is no person who walks with one person and 
talks with the another person.

Think of implementing this.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int maxn = 100009;
    static long MOD = 1000000007;
    static int[] par = new int[maxn];
    static int[] sz = new int[maxn];
    public int solve(int A, int[][] B, int[][] C) {
        reset();
        int n = A;
        int m = B.length;
        Map < Integer, Integer > mp = new HashMap < Integer, Integer > ();
        for (int i = 0; i < m; i++) {
            int u = B[i][0];
            int v = B[i][1];
            mp.putIfAbsent(u, 1);
            mp.putIfAbsent(v, 1);
            if (same(u, v) == false)
                un(u, v);
        }
        int flag = 0;
        m = C.length;
        for (int i = 0; i < m; i++) {
            int u = C[i][0];
            int v = C[i][1];
            if (mp.containsKey(u) || mp.containsKey(v))
                flag = 1;
            if (same(u, v) == false)
                un(u, v);
        }
        if (flag == 1)
            return 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (par[i] == i)
                cnt++;
        }
        long ret = 1;
        for (int i = 0; i < cnt; i++) {
            ret = (2 * ret) % MOD;
        }
        return (int) ret;
    }
    public static void reset() {
        for (int i = 0; i < maxn; i++) {
            par[i] = i;
            sz[i] = 1;
        }
    }
    public static int find(int a) {
        while (par[a] != a) {
            par[a] = par[par[a]];
            a = par[a];
        }
        return a;
    }
    public static boolean same(int x, int y) {
        if (find(x) == find(y))
            return true;
        return false;
    }
    public static void un(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (sz[ra] <= sz[rb]) {
            par[ra] = rb;
            sz[rb] += sz[ra];
        } else {
            par[rb] = ra;
            sz[ra] += sz[rb];
        }
    }
}
```
* * Solution in Javascript
```javascript
const maxn = 100009;
const MOD = 1000000007;
let par = new Array(maxn);
let sz = new Array(maxn);

function reset() {
    for (let i = 0; i < maxn; i++) {
        par[i] = i;
        sz[i] = 1;
    }
}

function find(a) {
    while (par[a] != a) {
        par[a] = par[par[a]];
        a = par[a];
    }
    return a;
}

function same(x, y) {
    if (find(x) == find(y))
        return true;
    return false;
}

function un(a, b) {
    let ra = find(a);
    let rb = find(b);
    if (sz[ra] <= sz[rb]) {
        par[ra] = rb;
        sz[rb] += sz[ra];
    } else {
        par[rb] = ra;
        sz[ra] += sz[rb];
    }
}
module.exports = {
    //param A : integer
    //param B : array of array of integers
    //param C : array of array of integers
    //return an integer
    solve: function (A, B, C) {
        reset();
        let n = A;
        let m = B.length;
        let mp = new Map();
        for (let i = 0; i < m; i++) {
            let u = B[i][0];
            let v = B[i][1];
            mp.set(u, 1);
            mp.set(v, 1);
            if (same(u, v) == false)
                un(u, v);
        }
        let flag = 0;
        m = C.length;
        for (let i = 0; i < m; i++) {
            let u = C[i][0];
            let v = C[i][1];
            if (mp.has(u) || mp.has(v))
                flag = 1;
            if (same(u, v) == false)
                un(u, v);
        }
        if (flag == 1)
            return 0;
        let cnt = 0;
        for (let i = 1; i <= n; i++) {
            if (par[i] == i)
                cnt++;
        }
        let ret = 1;
        for (let i = 0; i < cnt; i++) {
            ret = (2 * ret);
            ret %= MOD;
        }
        return ret;
    }
};
```
* * Solution in C++
```cpp
const int MAXN = 1e5 + 10, MOD = 1e9 + 7;
int n, m, hehe;
set < int > set1;
int par[MAXN], sz[MAXN];

void reset() {
    set1.clear();
    for (int i = 0; i < MAXN; i++) {
        par[i] = i;
        sz[i] = 1;
    }
}

int find(int x) {
    while (x != par[x])
        x = par[x];
    return x;
}

bool same(int x, int y) {
    return find(x) == find(y);
}

void merge(int a, int b) {
    a = find(a);
    b = find(b);
    if (sz[a] < sz[b])
        swap(a, b);
    sz[a] += sz[b];
    par[b] = a;
}

int solveit(int A, vector < vector < int > > & B, vector < vector < int > > & C) {
    reset();
    n = A;
    m = B.size();
    for (int i = 0; i < m; i++) {
        int u = B[i][0], v = B[i][1];
        set1.insert(u);
        set1.insert(v);
        if (!same(u, v))
            merge(u, v);
    }
    bool flag = false;
    m = C.size();
    for (int i = 0; i < m; i++) {
        int u = C[i][0], v = C[i][1];
        if (set1.find(u) != set1.end()) {
            flag = true;
        }
        if (set1.find(v) != set1.end()) {
            flag = true;
        }
        if (!same(u, v))
            merge(u, v);
    }
    if (flag) {
        return 0;
    }
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
        cnt += (par[i] == i);
    }
    int ret = 1;
    for (int i = 0; i < cnt; i++) {
        ret = (ret * 2) % MOD;
    }
    return ret;
}

int Solution::solve(int A, vector < vector < int > > & B, vector < vector < int > > & C) {
    return solveit(A, B, C);
}
```

