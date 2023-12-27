### Q2. Length of Longest Fibonacci Subsequence
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given a strictly increasing array <strong>A</strong> of positive integers 
    forming a sequence.</p>
    <p>A sequence <strong>X<sub>1</sub>, X<sub>2</sub>, X<sub>3</sub>, ..., X<sub>N</sub>
    </strong> is fibonacci like if</p>
    <p><strong></strong></p><li><strong>N &gt; =3
    </strong></li><li><strong>X<sub>i</sub> + X<sub>i+1</sub> = X<sub>i+2</sub> for 
    all i+2 &lt;= N</strong><p></p>
    <p>Find and return the length of the longest Fibonacci-like subsequence of 
    <strong>A</strong>.</p>
    <p>If one does not exist, return 0.</p>
    <p><strong>NOTE:</strong> A subsequence is derived from another sequence A by 
    deleting any number of elements (including none) from A, without changing the 
    order of the remaining elements.</p>
    <p></p></li>
</div>

```text
Given a strictly increasing array A of positive integers forming a sequence.

A sequence X1, X2, X3, ..., XN is fibonacci like if


    * N > =3
    * Xi + X(i+1) = X(i+2) for all i+2 <= N

Find and return the length of the longest Fibonacci-like subsequence of A.

If one does not exist, return 0.

NOTE: A subsequence is derived from another sequence A by deleting any number of 
elements (including none) from A, without changing the order of the remaining elements.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>3 &lt;= length of the array &lt;= 1000</p>
    <p>1 &lt;= A[i] &lt;= 10<sup>9</sup> </p>
</div>

```text
3 <= length of the array <= 1000

1 <= A[i] <= 10^9
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format
```text
Return the length of the longest Fibonacci-like subsequence of A.
If one does not exist, return 0.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5, 6, 7, 8]

Input 2:
 A = [1, 3, 7, 11, 12, 14, 18]
```
#### Example Output
```text
Output 1:
 5

Output 2:
 3
```
#### Example Explanation
```text
Explanation 1:
    The longest subsequence that is fibonacci-like: [1, 2, 3, 5, 8].

Explanation 2:
    The longest subsequence that is fibonacci-like: [1, 11, 12], [3, 11, 14] or [7, 11, 18].
    The length will be 3.
```
### Hints
* Hint 1
```text
Take two terms and find the next expected term, Move until next expected term is not found.
```
* Solution Approach
```text
Think of two consecutive terms A[i], A[j] in a fibonacci-like subsequence 
as a single node (i, j), and the entire subsequence is a path between 
these consecutive nodes. For example, with the fibonacci-like 
subsequence (A[1] = 2, A[2] = 3, A[4] = 5, A[7] = 8, A[10] = 13), we have the 
path between nodes (1, 2) <-> (2, 4) <-> (4, 7) <-> (7, 10).

The motivation for this is that two nodes (i, j) and (j, k) are connected if 
and only if A[i] + A[j] == A[k], and we needed this amount of information to 
know about this connection. Now we have a problem similar 
to Longest Increasing Subsequence.

Let longest[i, j] be the longest path ending in [i, j]. 
Then longest[j, k] = longest[i, j] + 1 if (i, j) and (j, k) are 
connected. Since i is uniquely determined as A.index(A[k] - A[j]), 
this is efficient: we check for each j < k what i is potentially, and 
update longest[j, k] accordingly.

Time Complexity: O(N^2) where N is the length of A.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        return lenLongestFibSubseq(A);
    }

    public static int lenLongestFibSubseq(int[] A) {
        int N = A.length;
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; ++i)
            index.putIfAbsent(A[i], i);
        Map<Integer, Integer> longest = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int k = 0; k < N; ++k)
            for (int j = 0; j < k; ++j) {
                if (A[k] - A[j] < A[j] && index.containsKey(A[k] - A[j]) == true) {
                    int i = index.getOrDefault(A[k] - A[j], 0);
                    longest.putIfAbsent(j * N + k, 0);
                    longest.putIfAbsent(i * N + j, 0);
                    longest.replace(j * N + k, longest.get(i * N + j) + 1);
                    ans = Math.max(ans, longest.getOrDefault(j * N + k, 0) + 2);
                }
            }
        return (ans >= 3) ? ans : 0;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //return an integer
    solve: function (A) {
        var map = new Map();
        for (var a of A) {
            map.set(a, true);
        }
        A.sort((a, b) => a - b);
        var len = 0;
        for (var i = 0; i < A.length; i++) {
            for (var j = i + 1; j < A.length; j++) {
                var left = A[i];
                var right = A[j];
                var tempLen = 0;
                while (map.has(left + right)) {
                    tempLen++;
                    var temp = left + right;
                    left = right;
                    right = temp;
                }
                len = Math.max(len, tempLen + 2);
            }
        }
        return len > 2 ? len : 0;
    }
};
```
* * Solution in C++
```cpp
int lenLongestFibSubseq(vector < int > & A) {
    int N = A.size();
    unordered_map < int, int > index;
    for (int i = 0; i < N; ++i)
        index[A[i]] = i;
    unordered_map < int, int > longest;
    int ans = 0;
    for (int k = 0; k < N; ++k)
        for (int j = 0; j < k; ++j) {
            if (A[k] - A[j] < A[j] && index.count(A[k] - A[j])) {
                int i = index[A[k] - A[j]];
                longest[j * N + k] = longest[i * N + j] + 1;
                ans = max(ans, longest[j * N + k] + 2);
            }
        }
    return (ans >= 3) ? ans : 0;
}

int Solution::solve(vector < int > & A) {
    return lenLongestFibSubseq(A);
}
```

