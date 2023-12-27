### Q3. Minimum Difference
#### Problem Description
```text
You are given a 2-D matrix C of size A × B.
You need to build a new 1-D array of size A by taking one 
element from each row of the 2-D matrix in such a way that 
the cost of the newly built array is minimized.

The cost of an array is the minimum possible value of the 
absolute difference between any two adjacent elements 
of the array.

So if the newly built array is X, the element picked from 
row 1 will become X[1], element picked from row 2 will 
become X[2], and so on.

Determine the minimum cost of the newly built array.
```
#### Problem Constraints
* <p>2 &lt;= A &lt;= 1000</p>
* <p>2 &lt;= B &lt;= 1000</p>
* <p>1 &lt;= C[i][j] &lt;= 10<sup>6</sup></p>
```text
2 <= A <= 1000
2 <= B <= 1000
1 <= C[i][j] <= 10^6
```
#### Input Format
```text
The first argument is an integer A denoting number of rows in 
the 2-D array.

The second argument is an integer B denoting number of columns 
in the 2-D array.

The third argument is a 2-D array C of size A x B.
```
#### Output Format
```text
Return an integer denoting the minimum cost of the newly build array.
```
#### Example Input
```text
Input 1:
 A = 2
 B = 2
 C = [ [8, 4]
      [6, 8] ]

Input 2:
 A = 3
 B = 2
 C = [ [7, 3]
       [2, 1]
       [4, 9] ]
```
#### Example Output
```text
Output 1:
 0

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
 Newly build array : [8, 8]. The minimum cost will be 0 since 
 the absolute difference will be 0(8-8).

Explanation 2:
 Newly build array : [3, 2, 4]. The minimum cost will be 1 since 
 the minimum absolute difference will be 1(3 - 2).
```
### Hints
* Hint 1
```text
We can check for every row for every element and then 
use binary search to search for the next element in the 
next row, which gives the minimum absolute difference.

You can also use the built-in function lower_bound() to 
search for the element.
```
* Solution Approach
```text
First, in order to the further operations, you need to sort 
each row of the matrix.

Initialize one variable “ans” as a large value to track the 
latest minimum difference between two elements.

Starting from the first row to the second last row of 
the matrix, for each element, say A[i][j] of the current row 
in the matrix, find the smallest element in the next row 
which is greater than or equal to the current element, say 
it a (lower bound) and the largest element which is smaller 
than the current element, say it b.

This can be done using Binary search (the reason we sorted 
each row of the matrix) or using the in-built 
function of lower_bound.

Now, just update ans with min(ans,min(a−A[i][j],A[i][j]−b)).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
   public int solve(int A, int B, int[][] C) {
      int x;
      int ans = 1000000000; // Initialize answer as a large number
      int lb;
      for (int i = 0; i < A; i++) {
         Arrays.sort(C[i]); // Sort each row of matrix
      }
      for (int i = 0; i < A - 1; i++) {
         for (int j = 0; j < B; j++) {
            lb = lower_bound(C[i + 1], C[i][j]); // check for next element as in soltion
            if (lb != B) {
               ans = Math.min(ans, Math.abs(C[i][j] - C[i + 1][lb])); // Update answer
            }
            if (lb != 0) {
               ans = Math.min(ans, Math.abs(C[i][j] - C[i + 1][lb - 1]));
            }
         }
      }
      return ans;
   }

   // function used to find element index just greater than or equal to val
   public int lower_bound(int a[], int val) {
      int low = 0, high = a.length - 1, ans = a.length;
      while (low <= high) {
         int mid = (high - low) / 2 + low;
         if (a[mid] < val) {
            low = mid + 1;
         } else {
            ans = mid;
            high = mid - 1;
         }
      }
      return ans;
   }
}
```
* * Solution in Javascript
```javascript
function lower_bound(a, val) {
  let low = 0,
    high = a.length - 1,
    ans = a.length;

  while (low <= high) {
    let mid = Math.floor((high - low) / 2) + low;
    if (a[mid] < val) {
      low = mid + 1;
    } else {
      ans = mid;
      high = mid - 1;
    }
  }
  return ans;
}
module.exports = {
  solve: function (A, B, C) {
    let x;
    let ans = 1000000000;
    let lb;
    for (let i = 0; i < A; i++) {
      C[i].sort((a, b) => a - b);
    }

    for (let i = 0; i < A - 1; i++) {
      for (let j = 0; j < B; j++) {
        lb = lower_bound(C[i + 1], C[i][j]);
        if (lb != B) {
          ans = Math.min(ans, Math.abs(C[i][j] - C[i + 1][lb]));
        }
        if (lb != 0) {
          ans = Math.min(ans, Math.abs(C[i][j] - C[i + 1][lb - 1]));
        }
      }
    }

    return ans;
  },
};
```
* * Solution in C++
```cpp
int Solution::solve(int A, int B, vector < vector < int > > & C) {
   int x;
   int ans = 1000000000; // Initialize answer as a large number
   int lb;
   for (int i = 0; i < A; i++) {
      sort(C[i].begin(), C[i].end()); // Sort each row of matrix
   }
   for (int i = 0; i < A - 1; i++) {
      for (int j = 0; j < B; j++) {
         lb = lower_bound(C[i + 1].begin(), C[i + 1].end(), C[i][j]) - C[i + 1].begin(); // check for next element as in soltion
         ans = min(ans, abs(C[i][j] - C[i + 1][lb])); // Update answer
         if (lb != 0) {
            ans = min(ans, abs(C[i][j] - C[i + 1][lb - 1]));
         }
      }
   }
   return ans;
}
```

