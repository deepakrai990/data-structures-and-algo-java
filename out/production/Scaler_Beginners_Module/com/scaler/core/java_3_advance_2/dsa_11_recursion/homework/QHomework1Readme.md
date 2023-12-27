### Q1. Combinations
#### Problem Description
```text
Given two integers A and B, return all possible combinations 
of B numbers out of 1 2 3 ... A.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a 
valid entry while [4, 1] is not.
Entries should be sorted within themselves.
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
```
#### Problem Constraints
```text
1 <= A, B <= 10
```
#### Input Format
```text
The first argument is an integer A.
The second argument is an integer B.
```
#### Output Format
```text
Return a 2-D vector denoting all possible combinations.
```
#### Example Input
```text
Input 1:
 A = 4
 B = 2

Input 2:
 A = 3
 B = 2
```
#### Example Output
```text
Output 1:
 [
  [1, 2],
  [1, 3],
  [1, 4],
  [2, 3],
  [2, 4],
  [3, 4],
 ]

Output 2:
 [
  [1, 2],
  [1, 3],
  [2, 3]
 ] 
```
#### Example Explanation
```text
Explanation 1:
    All the possible combinations of size 2 in sorted order.
```
### Hints
* Hint 1
```text
Think in terms of recursion. How would you have brute-forced 
all the combinations?
```
* Solution Approach
```text
Method- 1
For every element, you have two options.

You either include the element in your subset, or you will 
not have the element in your subset.

Make the call for both cases.

Maintain the 2D array to return the answer.

Make sure the return array contains the combinations in sorted order.

Time Complexity - O(2^{A} * B)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    private ArrayList < ArrayList < Integer >> ans;
    public ArrayList < ArrayList < Integer >> combine(int A, int B) {
        ans = new ArrayList < > ();
        ArrayList < Integer > cur = new ArrayList < > ();
        solve(1, cur, A, B);
        return ans;
    }
    void solve(int idx, ArrayList < Integer > cur, int A, int B) {
        if (cur.size() == B) {
            ans.add(new ArrayList < > (cur));
            return;
        }
        if (idx == A + 1) 
            return;
        // Include current element
        cur.add(idx);
        solve(idx + 1, cur, A, B);
        cur.remove(cur.size() - 1);
        // Don't include current element
        solve(idx + 1, cur, A, B);
    }
}
```
* * Solution in Javascript
```javascript
let ret;
function solve(start, lmt, rg, cur) {
    if (rg == 0) {
        ret.push(cur.slice(0));
        return;
    }
    for (let i = start; i <= lmt - rg + 1; i++) {
        // iterate over all possible next element
        cur.push(i);
        solve(i + 1, lmt, rg - 1, cur);
        cur.pop();
    }
}
module.exports = {
    combine: function (A, B) {
        ret = new Array();
        let temp = new Array();
        solve(1, A, B, temp);
        return ret;
    },
};
```
* * Solution in C++
```cpp
void combineHelper(vector < int > & current, int n, int k, vector < vector < int > > & ans) {
    if (k == 0) {
        vector < int > newEntry = current;
        reverse(newEntry.begin(), newEntry.end());
        ans.push_back(newEntry);
        return;
    }
    if (n == 0 || n < k) 
        return;
    // We have 2 options here. We can either include n or not. 
    // Option 1 : Do not include n.
    combineHelper(current, n - 1, k, ans);
    // Option 2 : Include n. 
    current.push_back(n);
    combineHelper(current, n - 1, k - 1, ans);
    current.pop_back();
    return;
}

vector < vector < int > > Solution::combine(int A, int B) {
    vector < vector < int > > ans;
    vector < int > current;
    combineHelper(current, A, B, ans);
    sort(ans.begin(), ans.end());
    return ans;
}
```

