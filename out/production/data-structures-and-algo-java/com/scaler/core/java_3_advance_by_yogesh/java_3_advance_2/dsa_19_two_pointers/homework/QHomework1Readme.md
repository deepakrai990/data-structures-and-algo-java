### Q1. Closest pair from sorted arrays
#### Problem Description
```text
Given two sorted arrays of distinct integers, A and B, and an integer C, 
find and return the pair whose sum is closest to C and the pair has one 
element from each array.

More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) 
has minimum value.

If there are multiple solutions find the one with minimum i and even if 
there are multiple values of j for the same i then return the 
one with minimum j.

Return an array with two elements {A[i], B[j]}.
```
#### Problem Constraints
* <p>1 &lt;= length of both the arrays &lt;= 100000</p>
* <p>1 &lt;= A[i], B[i] &lt;= 10<sup>9</sup></p>
* <p>1 &lt;= C &lt;= 10<sup>9</sup></p>
```text
1 <= length of both the arrays <= 100000

1 <= A[i], B[i] <= 10^9

1 <= C <= 10^9
```
#### Input Format
```text
The first argument given is the integer array A.
The second argument given is the integer array B.
The third argument given is integer C.
```
#### Output Format
```text
Return an array of size 2 denoting the pair which has sum closest to C.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]
 B = [2, 4, 6, 8]
 C = 9

Input 2:
 A = [5, 10, 20]
 B = [1, 2, 30]
 C = 13
```
#### Example Output
```text
Output 1:
 [1, 8]

Output 2:
 [10, 2]
```
#### Example Explanation
```text
Explanation 1:
    There are three pairs: (1, 8), (3, 6), (5, 4), that gives 
    the minimum value.
    Since we have to return the value with minimum i and then 
    with minimum j. We will return [1, 8].

Explanation 2:
    [10, 2] is the only pair such abs(10+2-13) is minimum.
```
### Hints
* Hint 1
```text
Since the array are sorted, Can you think of using two pointer approach?

One pointer will be at the start of one array and other on the end of other array.
```
* Solution Approach
```text
This problem can be solved by using two pointer approach.

Let say l = 0 i.e. it point at the start of array A 
and r = len(B) - 1 i.e. it points to end of array B.

Also maintain a variable, let say, dif, which stores the 
minimum of abs(A[i]+B[j]-C).

Now, If abs(A[l]+B[r]-C) < dif then update the value of dif and 
the value of two A[i] and A[j] and there indices.

If abs(A[l]+B[r]-C) == dif then we need to update the indexes such 
that l and r are minimum as possible in case of multiple solution.

Also, increment l and decrement r accordingly.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] a, int[] b, int c) {
        int n = a.length, m = b.length;
        int l = 0, r = m-1;
        long dif = (long)(2e9);
        int ans[] = new int[]{-1, -1};
        while(l < n && r >= 0) {
            if(Math.abs(a[l] + b[r] - c) < dif) {
                // update the ans
                dif = Math.abs(a[l] + b[r] - c);
                ans[0] = a[l];  ans[1] = b[r];
            }
            else if(Math.abs(a[l] + b[r] - c) == dif && ans[0] == a[l]){
                // check for the smallest index
                ans[1] = b[r];
            }
            if(a[l] + b[r] >= c) 
                r--;
            else    
                l++;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (a, b, c) {
        let n = a.length, m = b.length;
        let l = 0, r = m - 1;
        let dif = 2e9;
        let ans = [-1, -1];
        while (l < n && r >= 0) {
            if (Math.abs(a[l] + b[r] - c) < dif) {
                // update the ans
                dif = Math.abs(a[l] + b[r] - c);
                ans[0] = a[l];
                ans[1] = b[r];
            } else if (Math.abs(a[l] + b[r] - c) == dif && ans[0] == a[l]) {
                // check for the smallest index
                ans[1] = b[r];
            }
            if (a[l] + b[r] >= c) r--;
            else l++;
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
vector<int> Solution::solve(vector<int> &a, vector<int> &b, int c) {
    int n = a.size();
    int m = b.size();
    int l = 0;
    int r = m - 1;
    int dif = 2e9;
    vector<int> ans(2);
    ans[0] = -1;
    ans[1] = -1;
    int ind[2] = {-1, -1};
    while (l < n && r >= 0){ 
        if  (abs(a[l] + b[r] - c) < dif) { 
            // update the ans
            dif = abs(a[l] + b[r] - c);
            ans[0] = a[l];
            ans[1] = b[r];
            ind[0] = l;
            ind[1] = r;
        }
        else if(abs(a[l] + b[r] - c) == dif){
            // check for the smallest index
            if (l == ind[0]){
                ans[0] = a[l];
                ans[1] = b[r];
                ind[1] = r;
            }
        }
        if (a[l] + b[r] >= c)
            r -= 1;
        else
            l += 1;
    }
    return ans;
}
```

