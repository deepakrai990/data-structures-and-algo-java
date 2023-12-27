### Q4. Matrix Chain Multiplication
#### Problem Description
```text
Given an array of integers A representing chain of 2-D matices such that the 
dimensions of i^th matrix is A[i-1] x A[i].

Find the most efficient way to multiply these matrices together. The problem is not 
actually to perform the multiplications, but merely to decide in which order to 
perform the multiplications.

Return the minimum number of multiplications needed to multiply the chain.
```
#### Problem Constraints
```text
1 <= length of the array <= 1000
1 <= A[i] <= 100
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format
```text
Return an integer denoting the minimum number of multiplications needed to multiply 
the chain.
```
#### Example Input
```text
Input 1:
 A = [40, 20, 30, 10, 30]

Input 2:
 A = [10, 20, 30]
```
#### Example Output
```text
Output 1:
 26000

Output 2:
 6000
```
#### Example Explanation
```text
Explanation 1:
    Dimensions of A1 = 40 x 20
    Dimensions of A2 = 20 x 30
    Dimensions of A3 = 30 x 10
    Dimensions of A4 = 10 x 30
    First, multiply A2 and A3 ,cost = 20*30*10 = 6000
    Second, multilpy A1 and (Matrix obtained after multilying A2 and A3) =  40 * 20 * 10 = 8000
    Third, multiply (Matrix obtained after multiplying A1, A2 and A3) and A4 =  40 * 10 * 30 = 12000
    Total Cost = 12000 + 8000 + 6000 =26000

Explanation 2:
    Cost to multiply two matrices with dimensions 10 x 20 and 20 x 30 = 10 * 20 * 30 = 6000.
```
### Hints
* Hint 1
```text
The order of multiplication does not affect the output of product but affects the 
number of operations required to obtained the product.

One simple solution is to try all possible order of multiplication of matrix and 
find the minimum cost.
```
* Solution Approach
```text
Matrix Multiplication is associative, if we have four matrices W,X,Y and Z.
WXYZ = W(XY)Z = (WX)((YZ) = (W)(X(YZ))
The Problem reduces to place parenthesis such that the cost is minimum.

For example, if the given chain is of 4 matrices. let the chain be WXYZ,
then there are 3 ways to place first set of parenthesis 
outer side: (W)(XYZ), (WX)(YZ) and (WXY)(Z).

So when we place a set of parenthesis, we divide the problem into sub-problems of 
smaller size.

Therefore, the problem has optimal substructure property and can be easily solved using recursion.
But This will lead to exponential time complexity.

You can reduce the unnecessary function because there is overlapping Sub-problem 
property in its recursive implementation.
Use dynamic programming to reduce unnecessary calls.
Refer Complete Solution for Implementation.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        int[][] m = new int[n][n];
        int i, j, k, L, q;
        for (i = 1; i < n; i++)
            m[i][i] = 0;
        for (L = 2; L < n; L++) {
            for (i = 1; i < n - L + 1; i++) {
                j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                // try to divide at every i<=k<=j-1 
                for (k = i; k <= j - 1; k++) {
                    q = m[i][k] + m[k + 1][j] + A[i - 1] * A[k] * A[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }
        return m[1][n - 1];
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //return an integer
    solve: function (A) {
        let n = A.length;
        let m = new Array(n);
        for (let i = 0; i < n; i++) {
            m[i] = new Array(n);
        }
        for (let i = 1; i < n; i++)
            m[i][i] = 0;

        for (let L = 2; L < n; L++) {
            for (let i = 1; i < n - L + 1; i++) {
                j = i + L - 1;
                m[i][j] = Number.MAX_VALUE;
                // try to divide at every i<=k<=j-1 
                for (let k = i; k <= j - 1; k++) {
                    q = m[i][k] + m[k + 1][j] + A[i - 1] * A[k] * A[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }
        return m[1][n - 1];
    }
};
```
* * Solution in C++
```cpp
int MatrixMultiplicationCost(vector < int > & A) {
    int n = A.size();
    assert(n <= 1000 && n >= 1);
    int m[n][n];
    int i, j, k, L, q;

    //m[i][j] will store the minimum cost to multiply the matrices represented by A[i...j]
    for (i = 1; i < n; i++)
        m[i][i] = 0;

    for (L = 2; L < n; L++) {
        for (i = 1; i < n - L + 1; i++) {
            j = i + L - 1;
            m[i][j] = INT_MAX;
            // try to divide at every i<=k<=j-1 
            for (k = i; k <= j - 1; k++) {
                assert(A[j] >= 1 and A[j] <= 100);
                q = m[i][k] + m[k + 1][j] + A[i - 1] * A[k] * A[j];
                if (q < m[i][j])
                    m[i][j] = q;
            }
        }
    }
    return m[1][n - 1];
}

int Solution::solve(vector < int > & A) {
    return MatrixMultiplicationCost(A);
}
```

