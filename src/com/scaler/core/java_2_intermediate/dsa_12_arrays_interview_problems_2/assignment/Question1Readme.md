### Q1. Sum of odd indices
#### Problem Description
```text
You are given an array A of length N and Q queries given by 
the 2D array B of size Q*2. Each query consists of 
two integers B[i][0] and B[i][1].

For every query, the task is to calculate the sum of all odd 
indices in the range A[B[i][0]…B[i][1]].

Note : Use 0-based indexing
```

#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= N &lt;= 10<sup>5</sup><br>
    1 &lt;= Q &lt;= 10<sup>5</sup><br>
    1 &lt;= A[i] &lt;= 100<br>0 &lt;= B[i][0] &lt;= B[i][1] &lt; N
</div>

```text
1 <= N <= 10^5
1 <= Q <= 10^5
1 <= A[i] <= 100
0 <= B[i][0] <= B[i][1] < N
```
#### Input Format
```text
First argument A is an array of integers.
Second argument B is a 2D array of integers.
```
#### Output Format
```text
Return an array of integers.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]
 B = [   [0,2] 
         [1,4]   ]

Input 2:
 A = [2, 1, 8, 3, 9]
 B = [   [0,3] 
         [2,4]   ]
```
#### Example Output
```text
Output 1:
 [2, 6]

Output 2:
 [4, 3]
```
#### Example Explanation
```text
For Input 1:
    The subarray for the first query is [1, 2, 3] whose sum of 
    odd indices is 2.
    
    The subarray for the second query is [2, 3, 4, 5] whose sum of 
    odd indices is 6.

For Input 2:
    The subarray for the first query is [2, 1, 8, 3] whose sum of 
    odd indices is 4.
    
    The subarray for the second query is [8, 3, 9] whose sum of 
    odd indices is 3.
```
### Hints
* Hint 1
```text
Can we precalculate the sum of numbers with odd indices in a range ?
We should try to answer each query in O(1) time.
```
* Solution Approach
```text
Create a prefix array pref[] where pref[i+1] will store the sum of 
numbers with odd indices in the subarray A[0…i]. 

Now, the sum of numbers with odd indices in the range [L, R] can be 
easily calculated in O(1) as pref[R + 1] – pref[L].

Time Complexity : O(N + Q)
Space Complexity : O(N + Q)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] A, int[][] B) {
        int n = A.length;
        int[] pref = new int[n];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                pref[i] = pref[i - 1] + A[i];
            } else {
                pref[i] = pref[i - 1];
            }
        }
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int val = pref[B[i][1]];
            if (B[i][0] > 0) {
                val -= pref[B[i][0] - 1];
            }
            ans[i] = val;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
vector<int> Solution::solve(vector<int> &A, vector<vector<int> > &B) {
    int n;
    n = A.size();
    int pref[n] = {0};
    for(int i = 1 ; i < n ; i++){
        if(i % 2 == 1){
            pref[i] = pref[i - 1] + A[i];
        }
        else{
            pref[i] = pref[i - 1];
        }
    }
    vector<int> ans;
    for(int i = 0 ; i < B.size() ; i++){
        int val = pref[B[i][1]];
        if(B[i][0] > 0){
            val -= pref[B[i][0] - 1];
        }
        ans.push_back(val);
    }
    return ans;
}
```

