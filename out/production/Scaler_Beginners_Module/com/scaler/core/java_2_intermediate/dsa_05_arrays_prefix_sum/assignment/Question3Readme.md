### Q3. Range Sum Query
#### Problem Description
```text
You are given an integer array A of length N.
You are also given a 2D integer array B with 
dimensions M x 2, where each row denotes a [L, R] query.

For each query, you have to find the sum of all elements 
from L to R indices in A (0 - indexed).

More formally, 
find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    1 &lt;= N, M &lt;= 10<sup>5</sup><br> 
    1 &lt;= A[i] &lt;= 10<sup>9</sup><br> 
    0 &lt;= L &lt;= R &lt; N
</div>

```text
1 <= N, M <= 10^5
1 <= A[i] <= 10^9
0 <= L <= R < N
```
#### Input Format
```text
The first argument is the integer array A.
The second argument is the 2D integer array B.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    Return an integer array of length M where i<sup>th</sup> 
    element is the answer for i<sup>th</sup> query in B.
</div>

```text
Return an integer array of length M where i th element is 
the answer for i th query in B.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]
 B = [[0, 3], [1, 2]]

Input 2:
 A = [2, 2, 2]
 B = [[0, 0], [1, 2]]
```
#### Example Output
```text
Output 1:
 [10, 5]

Output 2:
 [2, 4]
```
#### Example Explanation
```text
Explanation 1:
    The sum of all elements of A[0 ... 3] = 1 + 2 + 3 + 4 = 10.
    The sum of all elements of A[1 ... 2] = 2 + 3 = 5.

Explanation 2:
    The sum of all elements of A[0 ... 0] = 2 = 2.
    The sum of all elements of A[1 ... 2] = 2 + 2 = 4.
```
### Hints
* Hint 1
```text
The brute force approach is very simple.
Think of any way to pre-process the given array to make 
answering each query faster.
```
* Solution Approach
```text
We have to find a way to optimize the time complexity of 
answering our query.

We can do this by creating an auxiliary array pref, where 
pref[i] is the sum of all elements from the beginning 
to the ith element.

We can easily create the pref array using the following equation:
pref[i] = pref[i - 1] + A[i]

Now, we can answer all our queries in O(1).

The answer to each query will be pref[R] - pref[L - 1].

Time Complexity: O(N)
Space Complexity: O(N)

Refer to the complete solution for more details.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public long[] rangeSum(int[] A, int[][] B) {
        int n = A.length;
        int m = B.length;
        long[] pref = new long[n + 1];
        pref[0] = A[0];
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + A[i];   // Sum from the 0th to the i-th index 
        }
        long[] ans = new long[m];
        for (int i = 0; i < m; i++) {
            ans[i] = pref[B[i][1]] - (B[i][0] > 0 ? pref[B[i][0] - 1] : 0);
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of integers
 //param B : array of array of integers
 //return a array of long integers
	rangeSum : function(A, B){
	     
	     let pre = [];
	     for(let i = 0; i <= A.length ; i++)
	        pre.push(0n);
	     pre[0] = A[0]
	     for( let i = 1; i < A.length ; i++) {
	         pre[i] = pre[i - 1] + A[i];
	     }
	     
	     let ans = [];
	     for( let i = 0; i < B.length ; i++) {
	        ans.push(pre[B[i][1]] - ((B[i][0] > 0) ? pre[B[i][0] - 1] : 0n));
	     }
	     
	     return ans;
	}
};
```
* * Solution in C++
```cpp
vector < long long > Solution::rangeSum(vector < int > & A, vector < vector < int > > & B) {
    int n = A.size();
    int m = B.size();
    assert(n >= 1 && n <= 1e5);
    assert(m >= 1 && m <= 1e5);
    for(auto &x : A) assert(x >= 1 && x <= 1e9);
    for(auto &x : B) assert(0 <= x[0] && x[0] <= x[1] &&  x[1] < n);
    long long pref[n];
    pref[0] = A[0];
    for (int i = 1; i < n; i++) {
        pref[i] = pref[i - 1] + A[i];   // Sum from the 0-th to the i-th index
    }
    vector < long long > ans(m);
    for (int i = 0; i < m; i++) {
        ans[i] = pref[B[i][1]] - (B[i][0] > 0 ? pref[B[i][0] - 1] : 0);
    }
    return ans;
}
```

