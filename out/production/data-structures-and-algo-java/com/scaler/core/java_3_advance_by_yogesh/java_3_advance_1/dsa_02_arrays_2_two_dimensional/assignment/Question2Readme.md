### Q2. Sub-matrix Sum Queries
#### Problem Description
```text
Given a matrix of integers A of size N x M and multiple 
queries Q, for each query, find and return the sub matrix sum.

Inputs to queries are top left (b, c) and bottom 
right (d, e) indexes of sub matrix whose sum is to find out.
```
* NOTE:
  * <p>Rows are numbered from top to bottom, and columns are numbered from left to right.</p>
  * <p>Sum may be large, so return the answer mod 10<sup>9</sup> + 7.</p>
    
#### Problem Constraints
```text
1 <= N, M <= 1000
-100000 <= A[i] <= 100000
1 <= Q <= 100000
1 <= B[i] <= D[i] <= N
1 <= C[i] <= E[i] <= M
```
#### Input Format
```text
The first argument given is the integer matrix A.
The second argument given is the integer array B.
The third argument given is the integer array C.
The fourth argument given is the integer array D.
The fifth argument given is the integer array E.
(B[i], C[i]) represents the top left corner of the i'th query.
(D[i], E[i]) represents the bottom right corner of the i'th query.
```
#### Output Format
```text
Return an integer array containing the submatrix sum for each query.
```
#### Example Input
```text
Input 1:
 A = [   [1, 2, 3]
         [4, 5, 6]
         [7, 8, 9]   ]
 B = [1, 2]
 C = [1, 2]
 D = [2, 3]
 E = [2, 3]
 
Input 2:
 A = [   [5, 17, 100, 11]
         [0, 0,  2,   8]    ]
 B = [1, 1]
 C = [1, 4]
 D = [2, 2]
 E = [2, 4]
```
#### Example Output
```text
Output 1:
 [12, 28]

Output 2:
 [22, 19]
```
#### Example Explanation
```text
Explanation 1:

 For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
 For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.


Explanation 2:

 For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
 For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.
 
```
### Hints
* Hint 1
```text
One way to solve is, for each query, run two loops: The outer loop from x1 to x2 and the inner loop from y1 to y2
and sum all the elements in that range. But this will not pass the constraints as for each query it takes O(N*M), and there are
O(10^5) queries.
```
* Solution Approach
```text
The idea is to first create an auxiliary matrix arr[N+1][M+1] such that arr[i][j] stores sum of elements in submatrix from (0,0) to (i,j).
Once arr[][] is constructed, we can compute sum of submatrix between (x1, y1) and (x2, y2) in O(1) time.
We need to consider arr[x2][y2] and subtract all unnecessary elements.
Below is the complete expression to compute the submatrix sum in O(1) time.

Sum between (x1, y1) and (x2, y2) is,
arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y1-1]

The submatrix aux[x1-1][x2-1] is added because elements of it are subtracted twice.
Remember to return the ans%1000000007
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    final int mod = 1000000007;
    public long[][] prefixMatrixSum(int[][] A){
        int n = A.length, m = A[0].length;
        long preSum[][] = new long[n + 1][m + 1];
        // preSum[i][j] denotes the sum of elements of matirx (0, 0) to (i, j)
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= m; j++){
                preSum[i][j] = (A[i - 1][j - 1] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + mod) % mod;
            }
        }
        return preSum;
    } 
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int sum = 0;
        long preSum[][] = prefixMatrixSum(A);
        int res[] = new int[B.length];
        for(int i = 0; i < B.length; i++){
            int x1 = B[i], y1 = C[i], x2 = D[i], y2 = E[i];
            long ans = preSum[x2][y2] - preSum[x2][y1 - 1] - preSum[x1 - 1][y2] + preSum[x1 - 1][y1 - 1];
            while(ans < 0)
                ans += mod;
            ans = ans % mod;
            res[i] = (int)ans;
        }
        return res;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function(A, B, C, D, E) {
        function prefixMatrixSum(A){
            let mat = [...Array(A.length + 1)].map(() =>
                Array(A[0].length + 1).fill(0)
            );
            // mat[i][j] denotes the sum of elements of matirx (0, 0) to (i, j)
            for (let i = 1; i <= A.length; i++) {
                for (let j = 1; j <= A[0].length; j++) {
                    mat[i][j] +=
                        mat[i - 1][j] + mat[i][j - 1] - mat[i - 1][j - 1] + A[i - 1][j - 1];
                    mat[i][j] %= MOD;
                    if (mat[i][j] < 0) mat[i][j] += MOD;
                }
            }
            return mat;
        }
        
        const MOD = 1000000007;
        let mat = prefixMatrixSum(A)
        let ret = [];
        for (let i = 0; i < B.length; i++) {
            let b = B[i];
            let c = C[i];
            let d = D[i];
            let e = E[i];
            ret.push((((mat[d][e] - mat[d][c - 1] - mat[b - 1][e] + mat[b - 1][c - 1]) % MOD) + MOD) % MOD);
        }
        return ret;
    },
};
```
* * Solution in C++
```cpp
 vector < vector < long long > > prefixMatrixSum(vector < vector < int > > & A){
    int n = A.size();
    int m = A[0].size();
    vector < vector < long long > > arr(n + 1, vector<long long>(m + 1, 0));
    for (int i = 0; i < m; i++)
        arr[1][i + 1] = A[0][i];
    //Do column wise sum
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < m; j++) {
            arr[i + 1][j + 1] = A[i][j] + arr[i][j + 1];
        }
    }
    //Do row wise sum
    for (int i = 0; i < n; i++) {
        for (int j = 1; j < m; j++) {
            arr[i + 1][j + 1] += arr[i + 1][j];
        }
    }
    return arr;
}
vector < int > Solution::solve(vector < vector < int > > & A, vector < int > & B, vector < int > & C, vector < int > & D, vector < int > & E) {
    
    int q = B.size();
    
    vector < vector < long long > > arr = prefixMatrixSum(A);
    
    vector < int > v;
    for (int i = 0; i < q; i++) {
        int x1 = B[i], y1 = C[i], x2 = D[i], y2 = E[i];
        long long ans = arr[x2][y2] - arr[x2][y1 - 1] - arr[x1 - 1][y2] + arr[x1 - 1][y1 - 1];
        while (ans < 0)
            ans += 1000000007;
        ans = ans % 1000000007;
        v.push_back(ans);
    }
    return v;
}
```