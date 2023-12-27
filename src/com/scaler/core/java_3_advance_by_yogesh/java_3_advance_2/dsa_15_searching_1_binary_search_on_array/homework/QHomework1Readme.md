### Q1. Matrix Search
#### Problem Description
```text
Given a matrix of integers A of size N x M and an 
integer B. Write an efficient algorithm that searches 
for integer B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.

The first integer of each row is greater than or equal to the 
last integer of the previous row.

Return 1 if B is present in A, else return 0.

NOTE: Rows are numbered from top to bottom, and columns are 
from left to right.
```
#### Problem Constraints
* <p>1 &lt;= N, M &lt;= 1000</p>
* <p>1 &lt;= A[i][j], B &lt;= 10<sup>6</sup></p>
```text
1 <= N, M <= 1000
1 <= A[i][j], B <= 10^6
```
#### Input Format
```text
The first argument given is the integer matrix A.
The second argument given is the integer B.
```
#### Output Format
```text
Return 1 if B is present in A else, return 0.
```
#### Example Input
```text
Input 1:
    A = [ 
          [1,   3,  5,  7]
          [10, 11, 16, 20]
          [23, 30, 34, 50]  
        ]
    B = 3

Input 2:
    A = [   
          [5, 17, 100, 111]
          [119, 120, 127, 131]    
        ]
    B = 3
```
#### Example Output
```text
Output 1:
    1

Output 2:
    0
```
#### Example Explanation
```text
Explanation 1:
    3 is present in the matrix at A[0][1] position so return 1.

Explanation 2:
    3 is not present in the matrix so return 0.
```
### Hints
* Hint 1
```text
Look at the matrix properties carefully. You are given the 
elements in sorted order already.

How can you exploit this property now?
```
* Solution Approach
```text
If you write down the numbers of row 1 followed by numbers 
in row2, row3, and so on, do you think the resulting 
array would be sorted?

If yes, how do you search for a number efficiently 
in a sorted array?

Just think of how the index in the array can be translated 
to the elements in the matrix.

For eg: Total elements : mn; m = no of rows; n = no of columns.

Indexing will go from 0 to mn - 1. Since the matrix 
is sorted, binary search can be applied here.

We take the mid of the total search 
space (initially all elements), then translate it to the 
indexes in the matrix by row = int(mid / n) and 
col = int(mid % n). This is valid because every 
row contains n elements.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int searchMatrix(int[][] A, int B) {
        int n = A.length, m = A[0].length;
        //assume all elements are added to a list and after that it is sorted
        //last index will be n * m - 1
        int low = 0, high = n * m - 1, ans = -1;
        while(low <= high){
            int mid = (high - low) / 2 + low;
            int row = mid / m, col = mid % m;
            if(A[row][col] > B) 
                high = mid - 1;
            else{
                ans = mid;
                low = mid + 1;
            }
        }
        if(ans == -1 || A[ans / m][ans % m] != B) 
            return 0;
        return 1;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
    //param a : array of array of integers
    //param b : integer
    //return an integer
  searchMatrix : function(m, num){

  var low = 0, high = m.length * m[0].length - 1;
  var mid;
  while( low <= high ) {
    mid = Math.floor((high - low) / 2 + low);
    var row = Math.floor(mid / m[0].length);
    var col = mid % m[0].length;
    if( m[row][col] > num )
      high = mid - 1;
    else if( m[row][col] < num )
      low = mid + 1;
    else return 1;
  }
  return 0;
	}
};
```
* * Solution in C++
```cpp
int Solution::searchMatrix(vector<vector<int> > &matrix, int target) {
    int n = matrix.size();
    int m = matrix[0].size();
    int l = 0, r = m * n - 1;
    while (l != r){
        int mid = (l + r - 1) >> 1;
        if (matrix[mid / m][mid % m] < target)
            l = mid + 1;
        else 
            r = mid;
    }
    return matrix[r / m][r % m] == target;
}
```

