### Q1. Absolute maximum
#### Problem Description
```text
Given 4 array of integers A, B, C and D of same size, find and return 
the maximum value of | A [ i ] - A [ j ] | + | B [ i ] - B [ j ] | + | C [ i ] - C [ j ] | + | D [ i ] - D [ j ] | + | i - j| 
where i != j and |x| denotes the absolute value of x.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>2 &lt;= length of the array A, B, C, D &lt;= 100000<br>
    -10<sup>6</sup> &lt;= A[i] &lt;= 10<sup>6</sup></p>
</div>

```text
2 <= length of the array A, B, C, D <= 100000
-10^6 <= A[i] <= 10^6
```
#### Input Format
```text
The arguments given are the integer arrays A, B, C, D.
```
#### Output Format
```text
Return the maximum value of | A [ i ] - A [ j ] | + | B [ i ] - B [ j ] | + | C [ i ] - C [ j ] | + | D [ i ] - D [ j ] | + | i - j|
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4]
 B = [-1, 4, 5, 6]
 C = [-10, 5, 3, -8]
 D = [-1, -9, -6, -10]

Input 2:
 A = [1, 2]
 B = [3, 6]
 C = [10, 11]
 D = [1, 6]
```
#### Example Output
```text
Output 1:
 30

Output 2:
 11
```
#### Example Explanation
```text
Explanation 1:

    Maximum value occurs for i = 0 and j = 1.


Explanation 2:

    There is only one possibility for i, j as there are only two elements 
    in the array.
```
### Hints
* Hint 1
```text
For any two indices i and j, try to observe how we can expand the 
given expression.
```
* Solution Approach
```text
| a - b| = { a-b if (a>=b)
             b-a  if (b>a)
           }
We can expand the absolute in two ways: a - b or b - a as shown above.

For e.g. a = 5, b = 7. b > a so absolute expansion should be b - a. 
If we use a - b then it’s value 5 - 7 = -2 which is less than 2 (7 - 5).

So, if we expand the operator the wrong way, it can’t attain maximum value.
Similarly, the given expression can be expanded 
in 32 different ways(2 ways for each absolute), and if any of the 
expansion is expanded wrong, we can’t achieve maximum value.

Some of the ways are:
-> A[i] - A[j] + B[i] - B[j] + C[i] - C[j] + D[i] - d[j] + i - j.
-> -A[i] + A[j] + B[i] - B[j] + C[i] - C[j] + D[i] - d[j] + i - j.
-> A[i] - A[j] - B[i] + B[j] + C[i] - C[j] + D[i] - d[j] + i - j.

So try to expand the given expression in all possible 32 ways and 
calculate the maximum among these values.

Time Complexity (32 * N) where N is the number of elements in all the arrays.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
        public int solve(int[] A, int[] B, int[] C, int[] D) {
        
        int[] m = new int[5];
        int d = 0; 
        int val;
        int ans = 0;
        
        // Expand the given expression in 32 different ways
        for(int i = 0; i < 32; i++) {
            
            for(int j = 0; j < 5; j++) {
                m[j] = ((i >> j) & 1);
                if(m[j] == 0)   m[j] = -1;
            }
            
            int Min = Integer.MAX_VALUE;
            int Max = Integer.MIN_VALUE;
            for(int k = 0; k < A.length; k++) {
                val = A[k] * m[0] + B[k] * m[1] + C[k] * m[2] + D[k] * m[3] + k * m[4];
                Max = Math.max(Max, val);
                Min = Math.min(Min, val);
            }
            ans = Math.max(ans, Max - Min);
        }
        
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of integers
 //param B : array of integers
 //param C : array of integers
 //param D : array of integers
 //return an integer
	solve : function(A, B, C, D){
        let n = A.length;
        let res = 0;
        // Expand the given expression in 32 different ways
        for (let i = 0; i < 16; ++i) {
            let maxi = -100000000000, mini = 100000000000;
            let cur = 0;
            for (let j = 0; j < n; ++j) {
                cur = A[j];
                let temp;
                for (let k = 0; k < 4; ++k) {
                    if (k == 0) {
                        temp = B[j];   
                    } else if (k == 1) {
                        temp = C[j];
                    } else if (k == 2) {
                        temp = D[j];
                    } else {
                        temp = j;
                    }
                    if (i & (1 << k)) {
                        cur += temp;
                    } else {
                        cur -= temp;
                    }
                }
                maxi = Math.max(maxi, cur);
                mini = Math.min(mini, cur);
            }
            res = Math.max(res, maxi - mini);
        }
        return res;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A, vector < int > & B, vector < int > & C, vector < int > & D) {
    int n = A.size();
    int e[n + 1];
    int mx = 0;
    
    // Expand the given expression in 32 different ways
    for (int p = 0; p < 32; ++p) {
        for (int i = 0; i < n; ++i) e[i] = 0;
        int mxx = INT_MIN, mn = INT_MAX;
        for (int i = 0; i < n; ++i) {
            for (int k = 0; k < 5; ++k) {
                int temp;
                if (k == 0) temp = A[i];
                else if (k == 1) temp = B[i];
                else if (k == 2) temp = C[i];
                else if (k == 3) temp = D[i];
                else temp = i;
                
                if (p & (1 << k)) e[i] += temp;
                else e[i] -= temp;
            }
            mxx = max(mxx, e[i]);
            mn = min(mn, e[i]);
        }
        mx = max(mx, mxx - mn);
    }
    return mx;
}
```
