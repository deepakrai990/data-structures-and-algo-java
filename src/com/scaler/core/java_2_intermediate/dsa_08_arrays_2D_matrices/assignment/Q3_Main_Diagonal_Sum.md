### Q3. Main Diagonal Sum
#### Problem Description
```text
You are given a N X N integer matrix. You have to find the 
sum of all the main diagonal elements of A.

Main diagonal of a matrix A is a collection of 
elements A[i, j] such that i = j.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p> 1 &lt;= <strong>N</strong> &lt;= 10<sup>3</sup> </p>
    <p> -1000 &lt;= <strong>A[i][j]</strong> &lt;= 1000 </p>
</div>

```text
1 <= N <= 10^3

-1000 <= A[i][j] <= 1000
```
#### Input Format
```text
There are 1 lines in the input. First 2 integers R, C are the 
number of rows and columns. Then R * C integers follow 
corresponding to the row wise numbers in the 2D array A.
```
#### Output Format
```text
Return an integer denoting the sum of main diagonal elements.
```
#### Example Input
```text
Input 1:
 3 3 1 -2 -3 -4 5 -6 -7 -8 9

Input 2:
 2 2 3 2 2 3
```
#### Example Output
```text
Output 1:
 15 

Output 2:
 6 
```
#### Example Explanation
```text
Explanation 1:
 A[1][1] + A[2][2] + A[3][3] = 1 + 5 + 9 = 15

Explanation 2:
 A[1][1] + A[2][2] = 3 + 3 = 6
```
### Hints
* Hint 1
```text
A diagonal element of a matrix is where both of its indices 
have the same value

For example, an element at A[1][2] won’t be a diagonal element 
because the values of row and column indices are different.
```
* Solution Approach
```text
The matrix given to us is a square matrix

Because of the above fact, we can just loop over all the row indices.

We set the column indices to be equal to the row indices. This gives 
us the diagonal elements which we can just sum up in a variable.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int[][] A) {
        int N = A.length;

        int sum = 0;
        for (int i = 0; i < N; i++) {
            // A[i][i] is the main diagonal element 
            sum += A[i][i];
        }

        return sum;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of array of integers
    //return an integer
    solve: function (A) {
        let n = A.length;
        let ans = 0;

        for (let i = 0; i < n; i++)
            // A[i][i] is the main diagonal element 
            ans += A[i][i];
        return ans;
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(const vector<vector<int> > &A) {
    int N = A.size();
    
    int sum = 0;
    for (int i = 0; i < N;i++){
        // A[i][i] is the main diagonal element 
        sum += A[i][i];
    }

    return sum;
}
```

