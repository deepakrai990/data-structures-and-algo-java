### Q4. Row with maximum number of ones
#### Problem Description
```text
Given a binary sorted matrix A of size N x N. 
Find the row with the maximum number of 1.

NOTE:

    * If two rows have the maximum number of 1 
        then return the row which has a lower index.
    * Rows are numbered from top to bottom and 
        columns are numbered from left to right.
    * Assume 0-based indexing.
    * Assume each row to be sorted by values.
    * Expected time complexity is O(rows + columns).
```
#### Problem Constraints
```text
1 <= N <= 1000

0 <= A[i] <= 1
```
#### Input Format
```text
The only argument given is the integer matrix A.
```
#### Output Format
```text
Return the row with the maximum number of 1.
```
#### Example Input
```text
Input 1:
 A = [   [0, 1, 1]
         [0, 0, 1]
         [0, 1, 1]   ]

Input 2:
 A = [   [0, 0, 0, 0]
         [0, 0, 0, 1]
         [0, 0, 1, 1]
         [0, 1, 1, 1]    ]
```
#### Example Output
```text
Output 1:
 0
Output 2:
 3
```
#### Example Explanation
```text
Explanation 1:
 Row 0 has maximum number of 1s.

Explanation 2:
 Row 3 has maximum number of 1s.
```
### Hints
* Hint 1
```text
To solve this problem, you just have to iterate through 
the grid and maintain some variables.
```
* Solution Approach
```text
We will start iterating from the top-right of 
the matrix.

We check for all rows from top to bottom and 
store the maximum answer so far.

For every row, we only search from the left of 
the index of maximum answer so far. 

Time Complexity : O(M + N)
Space Complexity : O(1)
```
* Complete Solution
```java
public class Solution {
    public int solve(int[][] A) {
        int n = A.length;
        int ans = 0, i, j;
        for (i = 0, j = n - 1; i < n && j >= 0; i++){
            while(A[i][j] == 1 && j >= 0){
                ans = i;
                j--;
            }
        }
        return ans;
    }
}
```

```cpp
int Solution::solve(vector<vector<int> > &A) {
    int n = A.size();
    assert(1 <= n and n <= 1e3);
    int ans = 0, i, j;
    for (i = 0, j = n - 1; i < n && j >= 0; i++){
        while(A[i][j] == 1 && j >= 0){
            ans = i;
            j--;
        }
    }
    return ans;
}
```

