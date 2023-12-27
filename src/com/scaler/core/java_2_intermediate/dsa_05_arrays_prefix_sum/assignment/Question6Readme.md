### Q6. Even numbers in a range
#### Problem Description
```text
You are given an array A of length N and Q queries given by 
the 2D array B of size Q×2.

Each query consists of two integers B[i][0] and B[i][1].

For every query, your task is to find the count of even numbers 
in the range from A[B[i][0]] to A[B[i][1]].
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    1 &lt;= N &lt;= 10<sup>5</sup><br>
    1 &lt;= Q &lt;= 10<sup>5</sup><br>
    1 &lt;= A[i] &lt;= 10<sup>9</sup><br>
    0 &lt;= B[i][0] &lt;= B[i][1] &lt; N
</div>

```text
1 <= N <= 10^5
1 <= Q <= 10^5
1 <= A[i] <= 10^9
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
 B = [   [0, 2] 
         [2, 4]
         [1, 4]   ]

Input 2:
 A = [2, 1, 8, 3, 9, 6]
 B = [   [0, 3]
         [3, 5]
         [1, 3] 
         [2, 4]   ]
```
#### Example Output
```text
Output 1:
 [1, 1, 2]

Output 2:
 [2, 1, 1, 1]
```
#### Example Explanation
```text
Example 1:
    The subarray for the first query is [1, 2, 3] (index 0 to 2) 
    which contains 1 even number.
    
    The subarray for the second query is [3, 4, 5] (index 2 to 4) 
    which contains 1 even number.
    
    The subarray for the third query is [2, 3, 4, 5] (index 1 to 4) 
    which contains 2 even numbers.

Example 2:
    The subarray for the first query is [2, 1, 8, 3] (index 0 to 3) 
    which contains 2 even numbers.
    
    The subarray for the second query is [3, 9, 6] (index 3 to 5) 
    which contains 1 even number.
    
    The subarray for the third query is [1, 8, 3] (index 1 to 3) 
    which contains 1 even number.
    
    The subarray for the fourth query is [8, 3, 9] (index 2 to 4) 
    which contains 1 even number.
```
### Hints
* Hint 1
```text
Can we precalculate the number of even numbers in a range ?
We should try to answer each query in O(1) time.
```
* Solution Approach
```text
Create a prefix array pref[] where pref[i+1] will store the count 
of even numbers in the subarray A[0…i]. 

Now, the count of even numbers in the range [L, R] can be easily 
calculated in O(1) as pref[R + 1] – pref[L].

Time Complexity : O(N + Q)
Space Complexity : O(N + Q)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] A, int[][] B) {
        int n = A.length;
        int[] pref = new int[n + 1];
        pref[0] = (A[0] % 2 == 0) ? 1 : 0;
        for(int i = 1 ; i < n ; i++){
            if(A[i] % 2 == 0){
                pref[i] = pref[i - 1] + 1;
            }
            else{
                pref[i] = pref[i - 1];
            }
        }
        int[] ans = new int [B.length];
        for(int i = 0 ; i < B.length ; i++){
            ans[i] = pref[B[i][1]] - (B[i][0] > 0 ? pref[B[i][0] - 1] : 0);
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
    pref[0] = (A[0] % 2 == 0) ? 1 : 0;
    for(int i = 1; i < n; i++){
        if(A[i] % 2 == 0){
            pref[i] = pref[i - 1] + 1;
        }
        else{
            pref[i] = pref[i - 1];
        }
    }
    vector<int> ans;
    for(int i = 0; i < B.size(); i++){
        ans.push_back(pref[B[i][1]] - (B[i][0] > 0 ? pref[B[i][0] - 1] : 0) );
    }
    return ans;
}
```

