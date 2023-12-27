### Q1. First Depth First Search
#### Problem Description
```text
You are given N towns (1 to N). All towns are connected via unique directed path as 
mentioned in the input.

Given 2 towns find whether you can reach the first town from the second without 
repeating any edge.

B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).

There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed 
that A[i] <= i for every 1 <= i < N.

NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.
```
#### Problem Constraints
```text
1 <= N <= 100000
```
#### Input Format
```text
First argument is vector A

Second argument is integer B

Third argument is integer C
```
#### Output Format
```text
Return 1 if reachable, 0 otherwise.
```
#### Example Input
```text
Input 1:
 A = [1, 1, 2]
 B = 1
 C = 2

Input 2:
 A = [1, 1, 2]
 B = 2
 C = 1
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
    Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.

Explanation 2:
    Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
```
### Hints
* Hint 1
```text
Query : x y
For answer to be true, x is a successor of y, considering root as 1 .

Note - Given graph is always a tree.
```
* Solution Approach
```text
Since you have to start from town number 1 , start your traversal from 1 (root) and use depth first search to reach the second town i.e. y.
Let the query be 6 3, then first search 3 starting from 1.
Now apply depth first search considering root as y ( 3 in this case ) ( move away from 1 ) and search whether x ( i.e. 6 ) is one of its successor. If yes return 1 else return 0 .

OR

Consider parent of i as a[i] and start depth first search from ““y”” to search for x.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
  // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
  static int maxn = 100009;
  static int[] vis = new int[maxn];
  static ArrayList < ArrayList < Integer > > adj;
  public static void graph() {
    adj = new ArrayList < ArrayList < Integer > > (maxn);
    for (int i = 0; i < maxn; i++) {
      vis[i] = 0;
      adj.add(new ArrayList < Integer > ());
    }
  }
  public int solve(int[] A, final int B, final int C) {
    graph();
    int n = A.length;
    for (int i = 1; i < n; i++) {
      adj.get(A[i]).add(i + 1);
    }
    if (dfs(C, B) == true)
      return 1;
    return 0;
  }
  public static boolean dfs(int s, int x) {
    if (s == x)
      return true;
    vis[s] = 1;
    int i, j, k = adj.get(s).size();
    for (i = 0; i < k; i++) {
      j = adj.get(s).get(i);
      if (vis[j] == 0 && dfs(j, x) == true)
        return true;
    }
    return false;
  }
}
```
* * Solution in Javascript
```javascript
let a = new Array(100005);
let vis = new Array(100005);
function dfs(s, x) {
  if (s == x) return true;
  vis[s] == 1;
  let i,
    j,
    k = a[s].length;
  for (i = 0; i < k; i++) {
    j = a[s][i];
    if (!vis[j] && dfs(j, x)) return true;
  }
  return false;
}

module.exports = {
  solve: function (A, B, C) {
    let i,
      j,
      n = A.length;
    for (i = 0; i <= n; i++) {
      a[i] = [];
      vis[i] = 0;
    }
    for (i = 1; i < n; i++) {
      a[A[i]].push(i + 1);
    }
    if (dfs(C, B)) {
      return 1;
    }
    return 0;
  },
};
```
* * Solution in C++
```cpp
vector < int > a[100005];
bool vis[100005];
bool dfs(int s, int x) {
  if (s == x)
    return true;
  vis[s] == 1;
  int i, j, k = a[s].size();
  for (i = 0; i < k; i++) {
    j = a[s][i];
    if (!vis[j] && dfs(j, x))
      return true;
  }
  return false;
}

int Solution::solve(vector < int > & A,
  const int B,
    const int C) {
  int i, j, n = A.size();
  for (i = 0; i <= n; i++) {
    a[i].clear();
    vis[i] = 0;
  }
  for (i = 1; i < n; i++) {
    a[A[i]].push_back(i + 1);
  }
  if (dfs(C, B)) {
    return 1;
  }
  return 0;
}
```

