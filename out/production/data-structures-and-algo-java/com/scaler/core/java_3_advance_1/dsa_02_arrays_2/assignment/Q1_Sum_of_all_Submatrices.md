### Q1. Sum of all Submatrices
#### Problem Description
```text
Given a 2D Matrix A of dimensions N*N, we need to return 
the sum of all possible sub matrices.
```
#### Problem Constraints
```text
1 <= N <=30

0 <= A[i][j] <= 10
```
#### Input Format
```text
Single argument representing a 2-D array A of size N x N.
```
#### Output Format
```text
Return an integer denoting the sum of all possible 
sub matrices in the given matrix.
```
#### Example Input
```text
A = [ [1, 1]
      [1, 1] ]
```
#### Example Output
```text
16
```
#### Example Explanation
```text
Number of submatrices with 1 elements = 4, so sum of all such submatrices = 4 * 1 = 4
Number of submatrices with 2 elements = 4, so sum of all such submatrices = 4 * 2 = 8
Number of submatrices with 3 elements = 0
Number of submatrices with 4 elements = 1, so sum of such submatrix = 4
Total Sum = 4+8+4 = 16
```
### Hints
* Hint 1
```text
For each element of the matrix, let us try to find the number of sub-matrices the element will lie in. Then multiplying
that with the element and hence finding the total sum.
How?
```
* Solution Approach
```text
Let us suppose the index of an element be (X, Y) in 0 based indexing, then the number of submatrices Sub(x,y) for this element
can be given by the formula Sub(x, y) = (X + 1) * (Y + 1) * (N – X) * (N – Y) .
This formula works because we just have to choose two different positions on the matrix that will create a submatrix that
envelopes the element. Thus, for each element, ‘sum’ can be updated as sum += Sub(x,y) * A[x][y].

More Formally,
Number of ways to choose from top-left elements (X + 1) * (Y + 1)
Number of ways to choose from bottom-right elements (N - X) * (N - Y)
```
* Complete Solution
* * Solution in Java
```java
/** 
 * Approach 1: 
 * **/

public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // Number of sub matrices contain A[i][j]
                int times = (i + 1) * (j + 1) * (n - i) * (n - j);
                sum += times * A.get(i).get(j);
            }
        }
        return sum;
    }
}
/**
 * Approach 2: Works only with given constraints 
 * **/

public class Solution {
    public int solve(int[][] A) {
        int n = A.length;
        int sum = 0;
        int preSum[][] = new int[n + 1][n + 1];
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= n; j++){
                preSum[i][j] = A[i - 1][j - 1] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = i; k <= n; k++){
                    for(int l = j; l <= n; l++){
                        sum += preSum[k][l] - preSum[k][j - 1] - preSum[i - 1][l] + preSum[i - 1][j - 1];
                    }
                }
            }
        }
        return sum;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
    //param a : array of integers
    //return a list of integers
	plusOne : function(a){
	    var b = [];
	    a.forEach( function( i ) { if( i ) b.push( i ); } );
	    var i = a.length;
	    var carry = 1;
	    
	    // traversing the digits of the number in reverse order
	    while( --i >= 0 ) {
	        var prev = +a[i];
	        b[i] = +a[i] + carry;
	        b[i] = b[i] % 10;
	        if( b[i] < prev )
	            carry = 1;
	        else 
	            carry = 0;
	    }
	    
	    if( carry )
	        b.unshift( 1 );
	    while( b[0] === 0 ) b.shift();
	    
	    return b;
	}
};
```
* * Solution in C++
```cpp
vector<int> Solution::plusOne(vector<int> &A) {
    // reversing the digits of the number
    reverse(A.begin(), A.end());
    vector<int> ans;
    int carry = 1;
    // traverse each digit of the number
    for (int i = 0; i < A.size(); i++) {
        int sum = A[i] + carry;
        ans.push_back(sum % 10);
        carry = sum / 10;
    }
    while (carry) {
        ans.push_back(carry % 10);
        carry /= 10;
    }
    while (ans[ans.size() - 1] == 0 && ans.size() > 1) {
        // removing leading zeroes from the final answer
        ans.pop_back();
    }
    reverse(ans.begin(), ans.end());
    return ans;
}
```

