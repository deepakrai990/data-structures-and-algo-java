### Q7. Kth Smallest Element in a Sorted Matrix
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given a sorted matrix of integers <strong>A</strong> of size 
    <strong>N x M</strong> and an integer <strong>B</strong>.</p>
    <p>Each of the rows and columns of matrix <strong>A</strong> 
    is sorted in ascending order, find the <strong>B<sup>th</sup> 
    smallest</strong> element in the matrix.</p>
    <p><strong>NOTE:</strong> Return The <strong>B<sup>th</sup></strong> 
    smallest element in the sorted order, not the <strong>B<sup>th</sup></strong> 
    distinct element.</p>
</div>

```text
Given a sorted matrix of integers A of size N x M and an integer B.

Each of the rows and columns of matrix A is sorted in ascending order, 
find the B^th smallest element in the matrix.

NOTE: Return The B^th smallest element in the sorted order, not the B^th distinct element.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N, M &lt;= 500 </p><p></p><p></p>
    <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
    <p>1 &lt;= B &lt;= N * M</p>
</div>

```text
1 <= N, M <= 500

1 <= A[i] <= 10^9

1 <= B <= N * M
```
#### Input Format
```text
The first argument given is the integer matrix A.
The second argument given is an integer B.
```
#### Output Format
```text
Return the B-th smallest element in the matrix.
```
#### Example Input
```text
Input 1:
 A = [ [9, 11, 15],
       [10, 15, 17] ] 
 B = 6

Input 2:
 A = [  [5, 9, 11],
        [9, 11, 13],
        [10, 12, 15],
        [13, 14, 16],
        [16, 20, 21] ]
 B = 12
```
#### Example Output
```text
Output 1:
 17

Output 2:
 16
```
#### Example Explanation
```text
Explanation 1:
    6^th smallest element in the sorted matrix is 17.

Explanation 2:
    12^th smallest element in the sorted matrix is 16.
```
### Hints
* Hint 1
```text
The brute-force approach is to store all the elements in the array and sort 
the array, then find the B-th element from it.

Can you optimize it using Max-Heap?
```
* Solution Approach
```text
We will use Max-Heap to solve this problem.

Create a Max-Heap of size B and process the element of matrix in it.

If the size of the heap is less than B, then push the element inside it.

Once the size of the heap is equal to B, then if the top element in the heap 
is greater than the element of the matrix, pop the element from the heap and 
insert the element of the matrix in the Heap.

The size of the heap still remains the same, i.e., B.

In the end, Return the top element of the Heap.
Time Complexity: O(NMlogB)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;

        PriorityQueue <Integer> q = new PriorityQueue(new CustomComp());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (q.size() < B)
                    q.offer(A[i][j]);
                else {
                    if (A[i][j] < q.peek()) {
                        q.poll();
                        q.offer(A[i][j]);
                    }
                }
            }
        }
        return q.peek();
    }
}
class CustomComp implements Comparator < Integer > {
    @Override
    public int compare(Integer a, Integer b) {
        return b - a;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of array of integers
    //param B : integer
    //return an integer
    solve: function (matrix, k) {
        let arr = [];
        for (let row of matrix) arr = arr.concat(row);
        arr.sort((a, b) => a - b);
        return arr[k - 1];
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < vector < int > > & A, int B) {
    int n = A.size();
    int m = A[0].size();
    priority_queue < int > q;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (q.size() < B)
                q.push(A[i][j]);
            else {
                if (A[i][j] < q.top()) {
                    q.pop();
                    q.push(A[i][j]);
                }
            }
        }
    }
    return q.top();
}
```

