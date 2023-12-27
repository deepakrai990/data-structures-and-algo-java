### Q5. Anti Diagonals
#### Problem Description
```text
Give a N * N square matrix A, return an array of its 
anti-diagonals. Look at the example for more details.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1&lt;= <strong>N</strong> &lt;= 1000<br>
    1&lt;= <strong>A[i][j]</strong> &lt;= 1 * 10<sup>9</sup>
</div>

```text
1<= N <= 1000
1<= A[i][j] <= 1e9 (1 * 10 ^ 9)
```
#### Input Format
```text
Only argument is a 2D array A of size N * N.
```
#### Output Format
```text
Return a 2D integer array of size (2 * N-1) * N, representing 
the anti-diagonals of input array A.

The vacant spaces in the grid should be assigned to 0.
```
#### Example Input
```text
Input 1:
 1 2 3
 4 5 6
 7 8 9

Input 2:
 1 2
 3 4
```
#### Example Output
```text
Output 1:
 1 0 0
 2 4 0
 3 5 7
 6 8 0
 9 0 0

Output 2:
 1 0
 2 3
 4 0
```
#### Example Explanation
```text
For input 1:

    The first anti diagonal of the matrix is [1 ], the rest 
    spaces should be filled with 0 making the row as [1, 0, 0].
    
    The second anti diagonal of the matrix is [2, 4 ], the rest 
    spaces should be filled with 0 making the row as [2, 4, 0].
    
    The third anti diagonal of the matrix is [3, 5, 7 ], the rest 
    spaces should be filled with 0 making the row as [3, 5, 7].
    
    The fourth anti diagonal of the matrix is [6, 8 ], the rest 
    spaces should be filled with 0 making the row as [6, 8, 0].
    
    The fifth anti diagonal of the matrix is [9 ], the rest 
    spaces should be filled with 0 making the row as [9, 0, 0].

For input 2:

    The first anti diagonal of the matrix is [1 ], the rest 
    spaces should be filled with 0 making the row as [1, 0, 0].
    
    The second anti diagonal of the matrix is [2, 4 ], the rest 
    spaces should be filled with 0 making the row as [2, 4, 0].
    
    The third anti diagonal of the matrix is [3, 0, 0 ], the rest 
    spaces should be filled with 0 making the row as [3, 0, 0].
```
### Hints
* Hint 1
```text
Let’s look at how the coordinates change when you move from 
one element to the other in the anti-diagonal.

With every movement, the row increases by one, and the column 
decreases by one ( or in other words, (1, -1) gets added 
to the current coordinates).

Now, all we need to know is the start ( or the first element ) 
in each diagonal.

Can you figure out which elements qualify as the first 
elements in each diagonal?
```
* Solution Approach
```text
Let’s look at how the coordinates change when you move from 
one element to the other in the anti-diagonal.

With every movement, the row increases by one, and the column 
decreases by one ( or in other words, (1, -1) gets added to 
the current coordinates).

Now, all we need to know is the start ( or the first element ) 
in each diagonal.

Can you figure out which elements qualify as the first 
elements in each diagonal?
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int l = A.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 2 * l - 1; ++i) {
            int offset = i < l ? 0 : i - l + 1;
            ArrayList<Integer> row = new ArrayList<Integer>();
            int k = 0;
            for (int j = offset; j <= i - offset; ++j) {
                row.add(A.get(j).get(i - j));
                k++;
            }
            for (int j = k; j < l; j++) {
                row.add(0);
            }
            res.add(row);
        }
        return res;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
    //param A : array of array of integers
    //return a array of array of integers
   diagonal : function(A){
       
       let n = A.length;
       let ans = new Array(2*n - 1);
       
       for(let i = 0; i <2*n - 1; i++)
           ans[i] = [];
       
       for(let i = 0; i < 2*n - 1; i++) {
           
           for(let j = 0; j < n; j++)
               ans[i][j] = 0;
       }
       
       for(let i = 0; i < n; i++) {
           
           let x = 0, y = i, pos = 0;
           while(y >= 0) {
               ans[i][pos++] = A[x][y];
               
               x++;
               y--;
           }
       }
       
        for(let i = n; i < 2*n; i++) {
           
           let x = i - n + 1, y = n - 1, pos = 0;
           while(x < n) {
               ans[i][pos++] = A[x][y];
               
               x++;
               y--;
           }
       }
       return ans;

   }
};
```
* * Solution in C++
```cpp
vector<vector<int> > Solution::diagonal(vector<vector<int> > &A) {
    int l = A.size();
    vector<vector<int> > res;
    for(int i = 0; i < 2 * l - 1; i++){
        int offset = i < l ? 0 : i - l + 1;
        vector<int> row;
        int k = 0;
        for(int j =  offset; j <= i - offset; j++){
            row.push_back(A[j][i-j]);
            k++;
        }
        for(int j = k; j < l; j++){
            row.push_back(0);
        }
        res.push_back(row);
    }
    return res;
}
```

