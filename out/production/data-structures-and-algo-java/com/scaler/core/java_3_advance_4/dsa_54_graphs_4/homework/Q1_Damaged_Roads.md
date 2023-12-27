### Q1. Damaged Roads
#### Problem Description
```text
You are the Prime Minister of a country and once you went for a world tour.
After 5 years, when you returned to your country, you were shocked to see the 
condition of the roads between the cities. So, you plan to repair them, but you 
cannot afford to spend a lot of money.

The country can be represented as a (N+1) x (M+1) grid, where Country(i, j) is a city.

The cost of repairing a road between (i, j) and (i + 1, j) is A[i]. The cost of 
repairing a road between (i, j) and (i, j + 1) is B[j].

Return the minimum cost of repairing the roads such that all cities can be visited 
from city indexed (0, 0).

As the cost can be large, return the cost modulo 10^9+7.
```
<p>As the cost can be large, return the <strong>cost modulo 10<sup>9</sup>+7</strong>.</p>

#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N, M &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i], B[i] &lt;= 10<sup>3</sup><p>
</div>

```text
1 <= N, M <= 10^5

1 <= A[i], B[i] <= 10^3
```
#### Input Format
```text
The first argument will be an integer array, A, of size N.
The second argument will be an integer array, B, of size M.
```
#### Output Format
```text
Return an integer representing the minimum possible cost.
```
#### Example Input
```text
Input 1:
 A = [1, 1, 1]
 B = [1, 1, 2]

Input 2:
 A = [1, 2, 3]
 B = [4, 5, 6]
```
#### Example Output
```text
Output 1:
 16

Output 2:
 39
```
#### Example Explanation
```text
Explanation 1:
     The minimum cost will be 16 if we repair the roads in the following way:
     Repair the roads from the all cities in row 0 to row 1 i.e. (0, j) to (1, j) (0 <= j <= 3), so that the cost will be 4 (A[0] * 4).
     Repair the roads from the all cities in row 1 to row 2 i.e. (1, j) to (2, j) (0 <= j <= 3), so that the cost will be 4 (A[1] * 4).
     Repair the roads from the all cities in row 2 to row 3 i.e. (2, j) to (3, j) (0 <= j <= 3), so that the cost will be 4 (A[2] * 4).
     Repair the roads (0, 0) to (0, 1), (0, 1) to (0, 2), (0, 2) to (0, 3), so that the cost will be B[0] + B[1] + B[2] = 4.
     Total cost will be 16.

Explanation 2:
    The minimum possible cost will be 39.
```
### Hints
* Hint 1
```text
Think of converting the problem into graph where the city denotes vertex and the 
roads denotes the edges.

Can you observe something similar to Minimum Spanning Tree?
```
* Solution Approach
```text
If you convert the problem into graph, you can notice that the solution of the 
problem is to find the MST(Minimum Spanning Tree) of the graph.

Now, Can you do that without creating the graph?

Let’s look into this.

Add all the edge cost and type of edge(vertical or horizontal) in an auxiliary array 
sort the array on the basis of edge cost in ascending order.

We can observe that the number of vertices are (N+1) * (M+1) so the number of 
edges in MST will be (N+1) * (M+1) - 1.

Initially N = N+1, M = M+1
Iterate over the sorted array:
->If the type is vertical, then ans += M * (edge cost) and decrement N.
->Else, ans += N * (edge cost) and decrement M.

Return the ans%(1e9+7).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static long MOD = 1000000007;
    public int solve(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        ArrayList < Pair > v = new ArrayList < Pair > ();
        for (int i = 0; i < n; i++)
            v.add(new Pair(A[i], 0));
        for (int i = 0; i < m; i++)
            v.add(new Pair(B[i], 1));
        Collections.sort(v);
        n++;
        m++;
        long ans = 0;
        for (Pair u: v) {
            if (u.second == 0) {
                ans = (ans + (m * u.first) % MOD) % MOD;
                ans %= MOD;
                n--;
            } else {
                ans = (ans + (n * u.first) % MOD) % MOD;
                ans %= MOD;
                m--;
            }
        }
        return (int) ans;
    }
}
class Pair implements Comparable < Pair > {
    int first;
    int second;
    public Pair(int a, int b) {
        this.first = a;
        this.second = b;
    }
    @Override
    public int compareTo(Pair temp) {
        if (this.first == temp.first)
            return this.second - temp.second;
        return this.first - temp.first;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //param B : array of integers
    //return an integer
    solve: function (A, B) {
        let n = A.length;
        let m = B.length;
        const MOD = 1000000007;
        let v = [];
        for (let i = 0; i < n; i++)
            v.push([A[i], 0]);
        for (let i = 0; i < m; i++)
            v.push([B[i], 1]);
        v.sort(function (a, b) {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        n++;
        m++;
        let ans = 0;
        for (let i = 0; i < v.length; i++) {
            let u = v[i];
            if (u[1] == 0) {
                ans = (ans + (m * u[0]) % MOD) % MOD;
                ans %= MOD;
                n--;
            } else {
                ans = (ans + (n * u[0]) % MOD) % MOD;
                ans %= MOD;
                m--;
            }
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
const int MOD = 1e9 + 7;
int Solution::solve(vector < int > & A, vector < int > & B) {
    int n = A.size();
    int m = B.size();
    vector < pair < long long int, long long int > > v;
    for (int i = 0; i < n; i++) {
        v.push_back(make_pair(A[i], 0));
    }
    for (int i = 0; i < m; i++)
        v.push_back(make_pair(B[i], 1));
    sort(v.begin(), v.end());
    n++;
    m++;
    long long int ans = 0;
    for (auto u: v) {
        if (u.second == 0) {
            ans = (ans + (m * u.first) % MOD) % MOD;
            ans %= MOD;
            n--;
        } else {
            ans = (ans + (n * u.first) % MOD) % MOD;
            ans %= MOD;
            m--;
        }
    }
    return ans;
}
```

