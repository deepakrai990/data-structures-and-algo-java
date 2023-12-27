### Q4. Minor Diagonal Sum
#### Problem Description
```text
You are given a N X N integer matrix. You have to find the 
sum of all the minor diagonal elements of A.

Minor diagonal of a M X M matrix A is a collection of 
elements A[i, j] such that i + j = M + 1 
(where i, j are 1-based).
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
First and only argument is a 2D integer matrix A.
```
#### Output Format
```text
Return an integer denoting the sum of minor diagonal elements.
```
#### Example Input
```text
Input 1:
 A = [[1, -2, -3],
      [-4, 5, -6],
      [-7, -8, 9]]

Input 2:
 A = [[3, 2],
      [2, 3]]
```
#### Example Output
```text
Output 1:
 -5 

Output 2:
 4 
```
#### Example Explanation
```text
Explanation 1:
 A[1][3] + A[2][2] + A[3][1] = (-3) + 5 + (-7) = -5

Explanation 2:
 A[1][2] + A[2][1] = 2 + 2 = 4
```
### Hints
* Hint 1
```text
This is a simple implementation problem requiring knowledge 
of loops and 2D arrays.
```
* Solution Approach
```text
You can iterate through all the elements such that their 
row number(one-based) and their column number(one-based) 
adds up to N + 1 i.e i + j = N + 1, and add each of 
them to the answer.
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
            sum += A[i][N - 1 - i];
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
	solve : function(A){
	    let n = A.length;
	    let ans = 0;
	    
	    for(let i = 0; i <n; i++) 
	        ans += A[i][n - 1 -i];
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
        sum += A[i][N - 1 - i];
    }
    return sum;
}
```

