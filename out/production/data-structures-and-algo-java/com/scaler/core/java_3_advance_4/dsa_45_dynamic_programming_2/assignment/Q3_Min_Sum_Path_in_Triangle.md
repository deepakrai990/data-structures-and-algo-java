### Q3. Min Sum Path in Triangle
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given a triangle, find the minimum path sum from top to bottom. Each step you 
    may move to adjacent numbers on the row below.</p>
    <p>Adjacent numbers for j<sup>th</sup> column of i<sup>th</sup> row 
    is j<sup>th</sup> and (j+1)<sup>th</sup> column of (i + 1)<sup>th</sup> row</p>
</div>

```text
Given a triangle, find the minimum path sum from top to bottom. Each step you may 
move to adjacent numbers on the row below.

Adjacent numbers for j^th column of i^th row is jth and (j+1)^th column of (i + 1)^th row
```
#### Problem Constraints
```text
|A| <= 1000

A[i] <= 1000
```
#### Input Format
```text
First and only argument is the vector of vector A defining the given triangle
```
#### Output Format
```text
Return the minimum sum
```
#### Example Input
```text
Input 1:
A = [ 
         [2],
        [3, 4],
       [6, 5, 7],
      [4, 1, 8, 3]
    ]

Input 2:
 A = [ [1] ]
```
#### Example Output
```text
Output 1:
 11

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Explanation 2:
    Only 2 can be collected.
```
### Hints
* Hint 1
```text
Brute force : Try traversing each possible path from top to the leaves. Not an 
acceptable solution in this case.

The triangle has a tree-like structure, which would lead people to think about 
traversal algorithms such as DFS. However, if you look closely, you would notice 
that the adjacent nodes always share a ‘branch’. In other word, there are 
overlapping subproblems. Also, suppose x and y are ‘children’ of k. Once minimum 
paths from x and y to the bottom are known, the minimum path starting from k can be 
decided in O(1), that is optimal substructure. Therefore, dynamic programming 
would be the best solution to this problem in terms of time complexity.
```
* Solution Approach
```text
For ‘top-down’ DP, starting from the node on the very top, we recursively find the 
minimum path sum of each node. When a path sum is calculated, we store it in an 
array (memoization); the next time we need to calculate the path sum of the same 
node, just retrieve it from the array. However, you will need a cache that is at 
least the same size as the input triangle itself to store the pathsum, which 
takes O(N^2) space. With some clever thinking, it might be possible to release 
some of the memory that will never be used after a particular point, but the order 
of the nodes being processed is not straightforwardly seen in a recursive solution, 
so deciding which part of the cache to discard can be a hard job.

‘Bottom-up’ DP, on the other hand, is very straightforward: we start from the nodes 
on the bottom row; the min pathsums for these nodes are the values of the nodes 
themselves. From there, the min pathsum at the ith node on the kth row would be 
the lesser of the pathsums of its two children plus the value of itself, i.e.:

minpath[k][i] = min( minpath[k+1][i], minpath[k+1][i+1]) + triangle[k][i];

Or even better, since the row minpath[k+1] would be useless after minpath[k] is 
computed, we can simply set minpath as a 1D array, and iteratively update itself:

For the kth level:
minpath[i] = min( minpath[i], minpath[i+1]) + triangle[k][i];
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> A) {
        int m, n;
        m = A.size();
        n = A.get(m - 1).size();
        int[] dp = new int[n + 1];
        int size = n;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < size; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + A.get(i).get(j);
            }
            size--;
        }
        return dp[0];
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of array of integers
    //return an integer
    minimumTotal: function (A) {
        // Write your solution here 
        var m = A.length;
        var n = A[m - 1].length;
        var dp = {};
        var size = n;
        for (var i = m - 1; i >= 0; i--) {
            for (var j = 0; j < size; j++) {
                dp[j] = Math.min(dp[j] || 0, dp[j + 1] || 0) + A[i][j];
            }
            size--;
        }
        return dp[0];
    }
};
```
* * Solution in C++
```cpp
int Solution::minimumTotal(vector < vector < int > > & A) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    int n = A.size();
    vector < int > minlen(A.back());
    for (int layer = n - 2; layer >= 0; layer--) {  // For each layer
        for (int i = 0; i <= layer; i++) {  // Check its every 'node'
            // Find the lesser of its two children, and sum the current value in the triangle with it.
            minlen[i] = min(minlen[i], minlen[i + 1]) + A[layer][i];
        }
    }
    return minlen[0];
}
```

