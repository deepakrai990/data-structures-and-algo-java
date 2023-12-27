### Q1. Christmas Trees
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>You are given an array <strong>A</strong> consisting 
    of heights of Christmas trees and an array <strong>B</strong> 
    of the same size consisting of the cost of each of the 
    trees (<strong>B<sub>i</sub></strong> is the cost of tree 
    <strong>A<sub>i</sub></strong>, where 
    <strong>1 ≤ i ≤ size(A</strong>)), and you are supposed to 
    choose <strong>3</strong> trees (let's say, indices p, q, and r), 
    such that <strong>A<sub>p</sub> &lt; A<sub>q</sub> &lt; A<sub>r</sub></strong>, 
    where <strong>p &lt; q &lt; r</strong>. <br> The cost of these 
    trees is <strong>B<sub>p</sub> + B<sub>q</sub> + B<sub>r</sub></strong>.
    </p>
    <p>You are to choose <strong>3</strong> trees such that their total 
    cost is minimum. Return that cost.</p>
    <p>If it is not possible to choose 3 such trees return 
    <strong>-1</strong>.
    </p>
</div>

#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= A[i], B[i] &lt;= 10<sup>9</sup><br> 
    3 &lt;= size(A) = size(B) &lt;= 3000</p>
</div>

```text
1 <= A[i], B[i] <= 10^9
3 <= size(A) = size(B) <= 3000
```
#### Input Format
```text
First argument is an integer array A.
Second argument is an integer array B.
```
#### Output Format
```text
Return an integer denoting the minimum cost of choosing 3 trees 
whose heights are strictly in increasing order, if not possible, -1.
```
#### Example Input
```text
Input 1:
 A = [1, 3, 5]
 B = [1, 2, 3]

Input 2:
 A = [1, 6, 4, 2, 6, 9]
 B = [2, 5, 7, 3, 2, 7]
```
#### Example Output
```text
Output 1:
 6 

Output 2:
 7 
```
#### Example Explanation
```text
Explanation 1:
    We can choose the trees with indices 1, 2 and 3, and 
    the cost is 1 + 2 + 3 = 6. 

Explanation 2:
    We can choose the trees with indices 1, 4 and 5, and 
    the cost is 2 + 3 + 2 = 7. 
    
    This is the minimum cost that we can get.
```
### Hints
* Hint 1
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>As the constraints for size(<strong>A</strong>) is 
    upto 3000, we see that an O(n<sup>2</sup>) solution should pass, 
    as 3000<sup>2</sup> is &lt; 10<sup>8</sup>.</p>
    <p>Hence, we can think of an O(n<sup>2</sup>) solution, where 
    we can fix one element, and traverse the other elements that 
    satisfy our condition.</p>
</div>

* Solution Approach
```text
To solve this, let’s take three indices, p, q and r.

    * p is the index of the tree that is to be chosen first, i.e. 
      the one with the smallest height.
    * q is the index of the tree that is to be chosen second, i.e. 
      the one with the middle height.
    * r is the index of the tree that is to be chosen third, i.e. 
      the one with the largest height.

We should now traverse the array by fixing index q. Lets N be the 
size of the array.

For q, that goes from index q+1 to N-1, we can find an index p that 
goes from 1 to q-1 such that A[p] < A[q], and B[p] is minimum.

Similarly, find an index r that goes from q+1 to N such 
that A[r] > A[q], and B[r] is minimum.

This way, for all q we can find the minimum values, and we choose 
the minimum values from all the q values.

Time Complexity : O(n^2)
Space Complexity(extra) : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int[] B) {
        final int inf = (int) (1e9 + 10);
        int n = A.length;
        int ans = inf;
        for (int i = 0; i < n; i++) {
            int left_min = inf, right_min = inf;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    left_min = Math.min(left_min, B[j]);
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (A[j] > A[i]) {
                    right_min = Math.min(right_min, B[j]);
                }
            }
            int temp_ans = left_min + B[i] + right_min;
            ans = Math.min(ans, temp_ans);
        }
        if (ans == inf) ans = -1;
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A, C) {
        let n = A.length;
        let min_ans = 1e18;
        for (let q = 1; q < n - 1; q++) {
            let mid = A[q];
            let minn = 1e18;
            let ans = 0;
            for (let p = 0; p < q; p++) {
                if (A[p] < mid) {
                    minn = Math.min(C[p], minn);
                }
            }
            if (minn == 1e18) {
                continue;
            } else ans += minn;
            minn = 1e18;
            for (let r = q + 1; r < n; r++) {
                if (A[r] > mid) {
                    minn = Math.min(C[r], minn);
                }
            }
            if (minn == 1e18) {
                continue;
            } else ans += minn;
            ans += C[q];
            min_ans = Math.min(min_ans, ans);
        }
        if (min_ans == 1e18) {
            return -1;
        } else return min_ans;
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A, vector<int> &B) {
    const int inf = 1e9 + 10;
    int n = A.size();
    int ans = inf;
    //for each q from 1 to n-1
    for(int i = 1 ; i < n ; i++){
        int left_min = inf , right_min = inf;
        
        //for p
        for(int j = 0 ; j < i ; j++){
            if(A[j] < A[i]){
                left_min = min(left_min, B[j]);
            }
        }
        
        //for r
        for(int j = i + 1 ; j < n ; j++){
            if(A[j] > A[i]){
                right_min = min(right_min, B[j]);
            }
        }
        int temp_ans = left_min + B[i] + right_min;
        ans = min(ans , temp_ans);
    }
    if(ans == inf) ans = -1;
    return ans;
}
```

