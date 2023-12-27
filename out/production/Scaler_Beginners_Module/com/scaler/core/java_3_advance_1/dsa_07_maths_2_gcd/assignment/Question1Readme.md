### Q1. Delete one
#### Problem Description
```text
Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

Find the maximum value of GCD.
```
#### Problem Constraints
```text
2 <= N <= 105
1 <= A[i] <= 109
```
#### Input Format
```text
First argument is an integer array A.
```
#### Output Format
```text
Return an integer denoting the maximum value of GCD.
```
#### Example Input
```text
Input 1:
 A = [12, 15, 18]

Input 2:
 A = [5, 15, 30]
```
#### Example Output
```text
Output 1:
 6
 
Output 2:
 15
```
#### Example Explanation
```text
Explanation 1:

 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum vallue of gcd is 6.


Explanation 2:

 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.
```
### Hints
* Hint 1
```text
The naive approach will be deleting elements one by one, finding the gcd of the remaining array, and maintaining the maximum answer.
But the time complexity for this will be O(N^2logN).
```
* Solution Approach
```text
We can maintain two arrays for prefix and suffix gcd; likewise, we do for prefix sum and suffix sum.
Then,for each index, i:1 to N calculate gcd(prefix[i-1],suffix[i+1]) and return the maximum among all.
```
* Complete Solution
```java
public class Solution {
    public int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    public int[]suffixGCD(int[] A){
        int n = A.length;
        int[] suf = new int[n];
        int g = 0;
        for (int i = n - 1; i >= 0; i--) {
            g = gcd(g, A[i]);
            suf[i] = g;
        }
        return suf;
    }
    public int solve(int[] A) {
        int n = A.length, ans = 1;
        // suf stores the suffix gcd of the array
        int[] suf = suffixGCD(A);
        int curGcd = 0;
        for (int i = 0; i < n; i++) {
            if (i != n - 1)
                ans = Math.max(ans, gcd(suf[i + 1], curGcd));
            else
                ans = Math.max(ans, curGcd);
            curGcd = gcd(curGcd, A[i]);
        }
        return ans;
    }
}
```

```javascript
function gcd(a, b) {
  return b ? gcd(b, a % b) : a;
}
function prefixGCD(A){
    let n = A.length;
    let pre = new Array(n).fill(0);
    let val = A[0];
    for (let i = 0; i < n; i++) {
        pre[i] = gcd(val, A[i]);
        val = pre[i];
    }
    return pre;
}
function suffixGCD(A){
    let n = A.length;
    let back = new Array(n).fill(0);
    let val = A[n - 1];
    for (let i = n - 1; i >= 0; i--) {
        back[i] = gcd(val, A[i]);
        val = back[i];
    }
    return back;
}
module.exports = {
  solve: function (A) {
    let n = A.length;
    // pre and back stores the prefix and suffix gcd's respectively
    let pre = prefixGCD(A);
    let back = suffixGCD(A);
    let ans = 0;
    for (let i = 0; i < n; i++) {
        if (i == 0) {
            ans = Math.max(ans, back[i + 1]);
        } else if (i == n - 1) {
            ans = Math.max(ans, pre[i - 1]);
        } else {
            ans = Math.max(ans, gcd(pre[i - 1], back[i + 1]));
        }
    }
    return ans;
  },
};
```

```cpp
vector<int> prefixGCD(vector<int> &A){
    int n = A.size();
    vector<int> pre(n + 1, 0);
    int val = A[0];
    for (int i = 0; i < n; i++) {
        pre[i] = __gcd(val, A[i]);
        val = pre[i];
    }
    return pre;
}

vector<int> suffixGCD(vector<int> &A){
    int n = A.size();
    vector<int> back(n + 1, 0);
    int val = A[n - 1];
    for (int i = n - 1; i >= 0; i--) {
        back[i] = __gcd(val, A[i]);
        val = back[i];
    }
    return back;
}

int Solution::solve(vector < int > & A) {
    int n = A.size();
    // pre and back stores the prefix and suffix gcd's respectively
    vector<int> pre = prefixGCD(A);
    vector<int> back = suffixGCD(A);
    int ans = 0;
    for (int i = 0; i < n; i++) {
        if (i == 0)
            ans = max(ans, back[i + 1]);
        else if (i == n - 1)
            ans = max(ans, pre[i - 1]);
        else
            ans = max(ans, __gcd(pre[i - 1], back[i + 1]));
    }
    return ans;
}
```

