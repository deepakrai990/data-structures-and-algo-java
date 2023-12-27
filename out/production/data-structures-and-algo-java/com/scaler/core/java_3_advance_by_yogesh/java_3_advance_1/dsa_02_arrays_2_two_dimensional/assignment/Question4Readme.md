### Q4. Maximum Submatrix Sum
#### Problem Description
```text
Given a row-wise and column-wise sorted matrix A of size N * M.
Return the maximum non-empty sub-matrix sum of this matrix.
```
#### Problem Constraints
* <p>1 &lt;= N, M &lt;= 1000</p>
* <p>-10<sup>9</sup> &lt;= A[i][j] &lt;= 10<sup>9</sup></p>
```text
1 <= N, M <= 1000
-10^9 <= A[i][j] <= 10^9
```
#### Input Format
```text
The first argument is a 2D integer array A.
```
#### Output Format
```text
Return a single integer that is the maximum non-empty 
sub-matrix sum of this matrix.
```
#### Example Input
```text
Input 1:-
 A = {{-5, -4, -3}, {-1,  2,  3}, {2,  2,  4}}
     
Input 2:-
 A = {{1, 2, 3}, {-4,,  5,  6}, {7,  8,  9}}
```
#### Example Output
```text
Output 1:-
 12
Output 2:-
 45
```
#### Example Explanation
```text
Explanation 1:-
 The sub-matrix with max sum is 
 -1 2 3
  2 2 4
  2 2 4
  Sum is 12.
Explanation 2:-
 The largest sub-matrix with max sum is 
 1 2 3
 4 5 6
 7 8 9
 The sum is 45.
```
### Hints
* Hint 1
```text
Imagine you had the same problem but with a 1D array. 
That is if the array was sorted and find the 
maximum subarray.

What would be the answer? The answer will be the 
sum of one of the suffixes right? So we could 
check over all suffix arrays and return the 
maximum sum. The sum of all suffix arrays can 
be computed in O(N).

Now apply the same logic on a 2D matrix.
```
* Solution Approach
```text
Imagine you had the same problem but with a 1D array. 
That is if the array was sorted and find the 
maximum subarray.

What would be the answer? The answer will be 
the sum of one of the suffixes right? So we 
could check over all suffix arrays and return 
the maximum sum. The sum of all suffix arrays 
can be computed in O(N).

Now apply the same logic on a 2D matrix.

What is a suffix matrix? A matrix whose right 
lower corner is always the N*M th element. 

Now we can have iterate over all the possible 
top left corners which is N*M. So N*M matrices.

The sum of each of these matrices can be 
computed in O(1) with a pre-computation of O(N*M).

Return the maximum sum of all these matrices. 

Time Complexity - O(N * M)
Space Complexity - O(N * M)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public long solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        long pf[][] = new long[n][m];
        pf[n - 1][m - 1] = A[n - 1][m - 1];
        long ans = pf[n - 1][m - 1];
        for(int j = m - 2 ; j >= 0 ; j--){
            pf[n - 1][j] = pf[n - 1][j + 1] + A[n - 1][j];
            ans = Math.max(ans, pf[n - 1][j]);
        }
        for(int i = n - 2 ; i >= 0 ; i--){
            pf[i][m - 1] = pf[i + 1][m - 1] + A[i][m - 1];
            ans = Math.max(ans, pf[i][m - 1]);
        }
        for(int i = n - 2 ; i >= 0 ; i--){
            for(int j = m - 2 ; j >= 0 ; j--){
                pf[i][j] = A[i][j] + pf[i + 1][j] + pf[i][j + 1] - pf[i + 1][j + 1];
                ans = Math.max(ans, pf[i][j]);
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of array of integers
    //return a long integers
    solve: function (A) {
        const n = A.length;
        const m = A[0].length;
        let suff = new Array(n);
        for (let i = 0; i < n; i++) suff[i] = new Array(m);
        suff[n - 1][m - 1] = A[n - 1][m - 1];
        let res = suff[n - 1][m - 1];
        for (let i = m - 2; i >= 0; i--) {
            suff[n - 1][i] = suff[n - 1][i + 1] + A[n - 1][i];
            res = Math.max(res, suff[n - 1][i]);
        }
        for (let i = n - 2; i >= 0; i--) {
            suff[i][m - 1] = suff[i + 1][m - 1] + A[i][m - 1];
            res = Math.max(res, suff[i][m - 1]);
        }
        for (let i = n - 2; i >= 0; i--) {
            for (let j = m - 2; j >= 0; j--) {
                suff[i][j] = suff[i][j + 1] + suff[i + 1][j] - suff[i + 1][j + 1] + A[i][j];
                res = Math.max(res, suff[i][j]);
            }
        }
        return res;
    }
};
```
* * Solution in C++
```cpp
typedef long ll;
ll Solution::solve(vector < vector < int >> & A) {
    int n = A.size();
    int m = A[0].size();
    assert(n >= 1 && n <= 1000);
    assert(m >= 1 && m <= 1000);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (i > 0) assert(A[i][j] >= A[i - 1][j]);
            if (j > 0) assert(A[i][j] >= A[i][j - 1]);
            assert(A[i][j] >= -1e9 && A[i][j] <= 1e9);
        }
    }
    int i, j;
    ll suff[n][m];
    suff[n - 1][m - 1] = A[n - 1][m - 1];
    ll res = suff[n - 1][m - 1];
    for (i = m - 2; i >= 0; i--) {
        suff[n - 1][i] = suff[n - 1][i + 1] + A[n - 1][i];
        res = max(res, suff[n - 1][i]);
    }
    for (i = n - 2; i >= 0; i--) {
        suff[i][m - 1] = suff[i + 1][m - 1] + A[i][m - 1];
        res = max(res, suff[i][m - 1]);
    }
    for (i = n - 2; i >= 0; i--) {
        for (j = m - 2; j >= 0; j--) {
            suff[i][j] = suff[i][j + 1] + suff[i + 1][j] - suff[i + 1][j + 1] + A[i][j];
            res = max(res, suff[i][j]);
        }
    }
    return res;
}
```

