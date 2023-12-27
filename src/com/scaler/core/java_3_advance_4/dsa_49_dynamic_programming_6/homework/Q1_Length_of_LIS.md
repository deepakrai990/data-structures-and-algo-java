### Q1. Length of LIS
#### Problem Description
```text
You are given an array A. You need to find the length of the Longest Increasing 
Subsequence in the array.

In other words, you need to find a subsequence of array A in which the elements are in 
sorted order, (strictly increasing) and as long as possible.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 ≤ length(A), A[i] ≤ 10<sup>5</sup></p>
</div>

```text
1 ≤ length(A), A[i] ≤ 10^5
```
#### Input Format
```text
The first and only argument of the input is the array A.
```
#### Output Format
```text
Output a single integer, the length of the longest increasing subsequence in array A.
```
#### Example Input
```text
Input 1:
 A: [2, 1, 4, 3]

Input 2:
 A: [5, 6, 3, 7, 9]
```
#### Example Output
```text
Output 1:
 2

Output 2:
 4
```
#### Example Explanation
```text
Explanation 1:
    [2, 4] and [1, 3] are the longest increasing sequences of size 2. 

Explanation 2:
    The longest increasing subsequence we can get is [5, 6, 7, 9] of size 4.
```
### Hints
* Hint 1
```text
Approach 1:

Using a bit of dynamic programming, we can get a recurrence relation for LIS of the 
sequence ending at position i.

Segment Tree seems reasonable for speeding the process up.

Approach 2:

Let dp[i] be the smallest element at which a subsequence of length i terminates.

Let dp[i] be the smallest element at which a subsequence of length i terminates.

Try to maintain this dp as we iterate and consider the elements one by one.
```
* Solution Approach
```text
Approach 1:

Let LIS[i] be the longest increasing subsequence of the array A[1..i] ending at A[i].

Now, consider the second last element of this subsequence, it should be smaller 
than A[i] and should lie to the left of i.

So, we can get a recurrence relation as follows:

LIS[i] = 1 + max(LIS[j]), over all j<i, such that A[j] < A[i]. 
This is not fast enough to pass. We can speed it up using segment trees.

We will maintain the segment tree from left to right, hence we do not need to worry 
about the condition j<i.

If we build segment tree on the values A[i], instead of i, the recurrence becomes:

LIS[A[i]] = 1 + max(LIS[A[j]]), over all j<i, such that A[j] < A[i]. 

Now, we can simply query the segment tree from 1 to A[i]-1 and take the maximum 
value. This way transition takes O(logN) time.

When we move from index i to i+1, we update the segment tree at A[i] for further queries.

Final answer would be max(LIS[A[i]]) over all i from 1 to N.

Approach 2:

Let dp[i] be the smallest element at which a subsequence of length i terminates.

Initially we assume d[0] = −inf and for all other elements d[i] = inf.

We will again gradually process the numbers, first a[0], then a[1], etc, and in each 
step maintain the array d[] so that it is up to date.

We now make two important observations.

The array d will always be sorted: d[i−1] ≤ d[i] for all i= 1 … n.

And also the element a[i] will only update at most one value d[j].

Thus we can find this element in the array d[] using binary search in O(logn).

In fact we are simply looking in the array d[] for the first number that is strictly 
greater than a[i], and we try to update this element.

After processing all the elements of a[] the length of the desired subsequence is the 
largest l with d[l] < inf.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int findLIS(int[] A) {
        return LongestIncreasingSubsequenceLength(A, A.length);
    }
    // Binary search (note boundaries in the caller) 
    // A[] is ceilIndex in the caller 
    static int CeilIndex(int A[], int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key)
                r = m;
            else
                l = m;
        }
        return r;
    }

    static int LongestIncreasingSubsequenceLength(int A[], int size) {
        // Add boundary case, when array size is one 
        int[] tailTable = new int[size];
        int len; // always points empty slot 
        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] < tailTable[0])
                // new smallest value 
                tailTable[0] = A[i];
            else if (A[i] > tailTable[len - 1])
                // A[i] wants to extend largest subsequence 
                tailTable[len++] = A[i];
            else
                // A[i] wants to be current end candidate of an existing 
                // subsequence. It will replace ceil value in tailTable 
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
        }
        return len;
    }
}
```
* * Solution in Javascript
```javascript
function CeilIndex(A, l, r, key) {
    while (r - l > 1) {
        let m = l + Math.floor((r - l) / 2);
        if (A[m] >= key)
            r = m;
        else
            l = m;
    }
    return r;
}

function LongestIncreasingSubsequenceLength(A, size) {
    // Add boundary case, when array size is one 

    let tailTable = new Array(size);
    let len; // always points empty slot 

    tailTable[0] = A[0];
    len = 1;
    for (let i = 1; i < size; i++) {
        if (A[i] < tailTable[0])
            // new smallest value 
            tailTable[0] = A[i];

        else if (A[i] > tailTable[len - 1])
            // A[i] wants to extend largest subsequence 
            tailTable[len++] = A[i];

        else
            // A[i] wants to be current end candidate of an existing 
            // subsequence. It will replace ceil value in tailTable 
            tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
    }

    return len;
}
module.exports = {
    //param A : array of integers
    //return an integer
    findLIS: function (A) {
        return LongestIncreasingSubsequenceLength(A, A.length);
    }
};
```
* * Solution in C++
```cpp
int Solution::findLIS(vector < int > & a) {
    int n = a.size();
    const int INF = 1e9;
    vector < int > d(n + 1, INF);
    d[0] = -INF;
    for (int i = 0; i < n; i++) {
        int j = upper_bound(d.begin(), d.end(), a[i]) - d.begin();
        if (d[j - 1] < a[i] && a[i] < d[j])
            d[j] = a[i];
    }
    int ans = 0;
    for (int i = 0; i <= n; i++)
        if (d[i] < INF)
            ans = i;
    return ans;
}
```

