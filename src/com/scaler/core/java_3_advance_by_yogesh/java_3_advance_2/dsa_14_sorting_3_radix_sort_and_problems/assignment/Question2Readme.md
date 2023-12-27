### Q2. Maximum Unsorted Subarray
#### Problem Description

<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    <p>Given an array <strong>A</strong> of non-negative integers 
    of size <strong>N</strong>. Find the minimum sub-array 
    <strong>A<sub>l</sub>, A<sub>l+1</sub> ,..., A<sub>r</sub>
    </strong> such that if we sort(in ascending order) that 
    sub-array, then the whole array should get sorted. If 
    <strong>A</strong> is already sorted, output 
    <strong>-1</strong>.</p>
</div>

```text
Given an array A of non-negative integers of size N. Find 
the minimum sub-array A[l], A[l]+1 ,..., A[r] such that if 
we sort(in ascending order) that sub-array, then the whole 
array should get sorted. If A is already sorted, output -1.
```
#### Problem Constraints
```text
1 <= N <= 1000000
1 <= A[i] <= 1000000
```
#### Input Format
```text
First and only argument is an array of non-negative 
integers of size N.
```
#### Output Format
```text
Return an array of length two where the first element denotes 
the starting index(0-based) and the second element denotes the 
ending index(0-based) of the sub-array. If the array is 
already sorted, return an array containing only 
one element i.e. -1.
```
#### Example Input
```text
Input 1:
 A = [1, 3, 2, 4, 5]

Input 2:
 A = [1, 2, 3, 4, 5]
```
#### Example Output
```text
Output 1:
 [1, 2]

Output 2:
 [-1]
```
#### Example Explanation
```text
Explanation 1:
    If we sort the sub-array A1, A2, then the whole array A gets sorted.

Explanation 2:
    A is already sorted.
```
### Hints
* Hint 1

<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    <p>Assume that <strong>A<sub>l</sub></strong>, …, 
    <strong>A<sub>r</sub></strong> is the minimum-unsorted-subarray 
    which is to be sorted, then subarrays 
    <strong>A<sub>0</sub></strong>, …, <strong>A<sub>l-1</sub></strong> 
    and <strong>A<sub>r+1</sub></strong>, …, <strong>A
    <sub>N-1</sub></strong> will be in sorted(ascending) order.</p>
    <p>How would you solve it now?</p>
</div>

```text
Assume that A[l], …, A[r] is the minimum-unsorted-subarray which 
is to be sorted, then sub-arrays A[0], …, A[l]-1 and A[r+1], …, 
A[N-1] will be in sorted(ascending) order.

How would you solve it now?
```
* Solution Approach

<div style="background-color: #f9f9f9; padding: 5px 10px; ">
    <p>Assume that <strong>A<sub>l</sub>
    </strong>, …, <strong>A<sub>r</sub></strong> is the 
    minimum-unsorted-subarray which is to be sorted.<br>
    then min(<strong>A<sub>l</sub></strong>, …, 
    <strong>A<sub>r</sub></strong>) &gt;= max(
    <strong>A<sub>0</sub></strong>, …, 
    <strong>A<sub>l-1</sub></strong>)<br>
    and max(<strong>A<sub>l</sub></strong>, …, 
    <strong>A<sub>r</sub></strong>) &lt;= min(
    <strong>A<sub>r+1</sub></strong>, …, 
    <strong>A<sub>N-1</sub></strong>)    <br>
    You can use this to observe and solve.<br>
    How would you solve it now?<br>
    You can use two pointer technique to solve this question.</p>
</div>

```text
Assume that A[l], …, A[r] is the minimum-unsorted-subarray 
which is to be sorted.
then min(A[l], …, A[r]) >= max(A[0], …, A[l-1])
and max(A[l], …, A[r]) <= min(A[r+1], …, A[N-1])

You can use this to observe and solve.

How would you solve it now?

You can use two pointer technique to solve this question.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] subUnsort(int[] A) {
        int n = A.length;
        int i = 0, j = n - 1;
        while (i < n - 1 && A[i] <= A[i + 1]) {
            i++;
        }
        while (j > 0 && A[j] >= A[j - 1]) {
            j--;
        }
        if (i == n - 1) { // if array is already sorted, output -1
            int ans[] = new int[1];
            ans[0] = -1;
            return ans;
        }
        // find the maximum and and minimum element from A[i]...A[j]
        int mn = A[i + 1], mx = A[i + 1];
        for (int k = i; k <= j; k++) {
            mx = Math.max(mx, A[k]);
            mn = Math.min(mn, A[k]);
        }
        int l = 0, r = n - 1;
        while (A[l] <= mn && l <= i) {
            l++;
        }
        while (A[r] >= mx && r >= j) {
            r--;
        }
        int ans[] = new int[2];
        ans[0] = l;
        ans[1] = r;
        return ans;

    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    subUnsort: function (A) {
        let ans = [];
        let n = A.length;
        let i = 0, j = n - 1;
        while (i < n - 1 && A[i] <= A[i + 1]) {
            i++;
        }
        while (j > 0 && A[j] >= A[j - 1]) {
            j--;
        }
        if (i == n - 1) {
            // if array is already sorted, output -1
            ans.push(-1);
            return ans;
        }
        // find the maximum and and minimum element from A[i]...A[j]
        let mn = A[i + 1], mx = A[i + 1];
        for (let k = i; k <= j; k++) {
            mx = Math.max(mx, A[k]);
            mn = Math.min(mn, A[k]);
        }
        let l = 0, r = n - 1;
        while (A[l] <= mn && l <= i) {
            l++;
        }
        while (A[r] >= mx && r >= j) {
            r--;
        }
        ans.push(l);
        ans.push(r);
        return ans;
    },
};
```
* * Solution in C++
```cpp
vector < int > Solution::subUnsort(vector < int > & A) {
    vector < int > ans;
    int n = A.size();
    int i = 0, j = n - 1;
    while (i < n - 1 and A[i] <= A[i + 1]) {
        i++;
    }
    while (j > 0 and A[j] >= A[j - 1]) {
        j--;
    }
    if (i == n - 1) { // if array is already sorted, output -1
        ans.push_back(-1);
        return ans;
    }
    // find the maximum and and minimum element from A[i]...A[j]
    int mn = A[i + 1], mx = A[i + 1];
    for (int k = i; k <= j; k++) {
        mx = max(mx, A[k]);
        mn = min(mn, A[k]);
    }
    int l = 0, r = n - 1;
    while (A[l] <= mn and l <= i) {
        l++;
    }
    while (A[r] >= mx and r >= j) {
        r--;
    }
    ans.push_back(l);
    ans.push_back(r);
    return ans;
}
```

