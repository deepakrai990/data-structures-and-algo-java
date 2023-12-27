### Q1. Maximum Sum Square SubMatrix
#### Problem Description
```text
Given a 2D integer matrix A of size N x N, 
find a B x B sub-matrix where B<= N and B>= 1, 
such that the sum of all the elements in 
the sub-matrix is maximum.
```
#### Problem Constraints
* <p>1 &lt;= N &lt;= 10<sup>3</sup>.</p>
* <p>1 &lt;= B &lt;= N </p>
* <p>-10<sup>2</sup> &lt;= A[i][j] &lt;= 10<sup>2</sup>.</p>
```text
1 <= N <= 10^3.

1 <= B <= N

-10^2 <= A[i][j] <= 10^2.
```
#### Input Format
```text
First argument is an 2D integer matrix A.

Second argument is an integer B.
```
#### Output Format
```text
Return a single integer denoting the maximum 
sum of sub-matrix of size B x B.
```
#### Example Input
```text
Input 1:
 A = [
        [1, 1, 1, 1, 1]
        [2, 2, 2, 2, 2]
        [3, 8, 6, 7, 3]
        [4, 4, 4, 4, 4]
        [5, 5, 5, 5, 5]
     ]
 B = 3
 
Input 2:
 A = [
        [2, 2]
        [2, 2]
    ]
 B = 2
```
#### Example Output
```text
Output 1:
 48

Output 2:
 8
```
#### Example Explanation
```text
Explanation 1: 
    Maximum sum 3 x 3 matrix is
    8 6 7
    4 4 4
    5 5 5
    Sum = 48

Explanation 2:
    Maximum sum 2 x 2 matrix is
    2 2
    2 2
    Sum = 8
```
### Hints
* Hint 1
```text
Think of some preprocessing like calculating the 
sum of all vertical strips of size B x 1. Try to 
use this preprocessing to get the sum of 
any sub-matrix in constant time.

Use this fact to find a solution to the problem.
```
* Solution Approach
```text
Method 1- Brute Force:
A Simple Solution is to consider all possible 
sub-squares of size B x B in our input matrix 
and find the one which has the maximum sum.
```
* <strong>Time complexity of above solution is O(N<sup>2</sup>B<sup>2</sup>).</strong>
```text
This will timeout for the given constraints.
```
```text
Method 2- Efficient Approach: 
The idea is to preprocess the given square 
matrix. In the preprocessing step, calculate 
the sum of all vertical strips of size B x 1 in 
a temporary square matrix stripSum[][].

Once we have the sum of all vertical strips, we 
can calculate the sum of the first sub-square 
in a row as the sum of the first B strips in 
that row, and for the remaining sub-squares, we 
can calculate the sum in O(1) time by removing 
the leftmost strip of the previous sub-square and 
adding the rightmost strip of the new square.
```
* <strong>Time complexity of this solution is O(N<sup>2</sup>).</strong>


* Complete Solution
* * Solution in Java
```java
public class Solution {
    int maxn = 1009;
    int[][] stripSum=new int[maxn][maxn];
    public void getStripSum(int[][] A, int B){
        int N = A.length;
        // To store sums of all strips of size B x 1
        for(int i = 0; i < maxn; i++)
            for(int j = 0; j < maxn; j++)
                stripSum[i][j] = 0;
        
        // Go column by column
        for (int j = 0; j < N; j++) {
            // Calculate sum of first B x 1 rectangle in this column
            int sum = 0;
            for (int i = 0; i < B; i++)
                sum += A[i][j];
            stripSum[0][j] = sum;
            
            // Calculate sum of remaining rectangles
            for (int i = 1; i < N - B + 1; i++) {
                sum += (A[i + B - 1][j] - A[i - 1][j]);
                stripSum[i][j] = sum;
            }
        }
    }
    public int solve(int[][] A, int B) {
        int N = A.length;
        // B must be smaller than or equal to N
        if (B > N) return 0;
        
        // 1: PREPROCESSING
        getStripSum(A, B);
        
        // max_sum stores maximum sum in matrix
        int max_sum = Integer.MIN_VALUE;
        
        // 2: CALCULATE SUM of Sub-Squares using stripSum[][]
        for (int i = 0; i < N - B + 1; i++) {
            // Calculate sum of first subsquare in this row
            int sum = 0;
            for (int j = 0; j < B; j++)
                sum += stripSum[i][j];
                
            // Update max_sum
            if (sum > max_sum) {
                max_sum = sum;
            }
            
            // Calculate sum of remaining squares in current row by removing
            // the leftmost strip of previous sub-square and adding a new strip
            for (int j = 1; j < N - B + 1; j++) {
                sum += (stripSum[i][j + B - 1] - stripSum[i][j - 1]);
                // Update max_sum
                if (sum > max_sum) {
                    max_sum = sum;
                }
            }
        }
        return max_sum;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of array of integers
 //param B : integer
 //return an integer
	solve : function(A, B){
	    function getStripSum(A, B){
	        let N = A.length;
	        let stripsum = [];
	        // To store sums of all strips of size B x 1
    	    for(let i = 0; i < N; i++) {
    	        let temp = [];
    	        for(let j = 0; j < N; j++) {
    	            temp.push(0);
    	        }
    	        stripsum.push(temp);
    	    }
    	    // Go column by column
    	    for(let j = 0; j < N; j++) {
    	        // Calculate sum of first B x 1 rectangle in this column
    	        let sum = 0;
    	        for(let i = 0; i < B; i++)
    	            sum += A[i][j];
    	        stripsum[0][j] = sum;
    	        
    	        // Calculate sum of remaining rectangles
    	        for(let i = 1; i < N - B + 1; i++) {
    	            sum += (A[i + B - 1][j] - A[i - 1][j]);
    	            stripsum[i][j] = sum;
    	        }
    	    }
    	    return stripsum;
	    }
	    
	    let N = A.length;
	    
	    // 1: PREPROCESSING
	    let stripsum = getStripSum(A, B)
        
	    // max_sum stores maximum sum in matrix
	    let max_sum = -100000007;
	    
	    // 2: CALCULATE SUM of Sub-Squares using stripSum[][]
	    for(let i = 0; i < N - B + 1; i++) {
	        // Calculate sum of first subsquare in this row
	        let sum = 0;
	        for(let j = 0; j < B; j++)
	            sum+=stripsum[i][j];
	        // Update max_sum
	        if(sum > max_sum)
	            max_sum = sum;
	        
	        // Calculate sum of remaining squares in current row by removing
            // the leftmost strip of previous sub-square and adding a new strip
	        for(let j = 1; j < N - B + 1 ; j++) {
	            sum+=(stripsum[i][j + B - 1]- stripsum[i][j - 1]);
	            // Update max_sum
	            if(sum > max_sum)
	            max_sum = sum;
	        }
	    }
        return max_sum;
	}
};
```
* * Solution in C++
```cpp
const int maxn = 1009;
int stripSum[maxn][maxn];

void getStripSum(vector<vector<int> > &A, int B){
    int N = A.size();
    // To store sums of all strips of size B x 1
    memset(stripSum, 0, sizeof(stripSum));;

    // Go column by column
    for (int j = 0; j < N; j++) {
        // Calculate sum of first B x 1 rectangle
        // in this column
        int sum = 0;
        for (int i = 0; i < B; i++)
            sum += A[i][j];
        stripSum[0][j] = sum;

        // Calculate sum of remaining rectangles
        for (int i = 1; i < N - B + 1; i++) {
            sum += (A[i + B - 1][j] - A[i - 1][j]);
            stripSum[i][j] = sum;
        }
    }
}

int Solution::solve(vector<vector<int> > &A, int B) {
    int N = A.size();
    // B must be smaller than or equal to N
    if (B > N) return 0;

    // 1: PREPROCESSING
    getStripSum(A, B);

    // max_sum stores maximum sum
    int max_sum = INT_MIN;

    // 2: CALCULATE SUM of Sub-Squares using stripSum[][]
    for (int i = 0; i < N - B + 1; i++) {
        // Calculate sum of first subsquare in this row
        int sum = 0;
        for (int j = 0; j < B; j++)
            sum += stripSum[i][j];

        // Update max_sum
        if (sum > max_sum) {
            max_sum = sum;
        }

        // Calculate sum of remaining squares in current row by removing 
        // the leftmost strip of previous sub-square and adding a new strip
        for (int j = 1; j < N - B + 1; j++) {
            sum += (stripSum[i][j + B - 1] - stripSum[i][j - 1]);

            // Update max_sum
            if (sum > max_sum) {
                max_sum = sum;
            }
        }
    }
    return max_sum;
}
```
