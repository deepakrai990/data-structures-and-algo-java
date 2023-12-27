### Q1. Max Rectangle in Binary Matrix
#### Problem Description
```text
Given a 2-D binary matrix A of size N x M filled with 0's and 1's, find the largest 
rectangle containing only ones and return its area.
```
#### Problem Constraints
```text
1 <= N, M <= 100
```
#### Input Format
```text
The first argument is a 2-D binary array A.
```
#### Output Format
```text
Return an integer denoting the area of the largest rectangle containing only ones.
```
#### Example Input
```text
Input 1:
 A = [
       [1, 1, 1]
       [0, 1, 1]
       [1, 0, 0] 
     ]

Input 2:
 A = [
       [0, 1, 0]
       [1, 1, 1]
     ] 
```
#### Example Output
```text
Output 1:
 4

Output 2:
 3
```
#### Example Explanation
```text
Explanation 1:
    As the max area rectangle is created by the 2x2 rectangle 
    created by (0, 1), (0, 2), (1, 1) and (1, 2).

Explanation 2:
    As the max area rectangle is created by the 1x3 rectangle 
    created by (1, 0), (1, 1) and (1, 2).
```
### Hints
* Hint 1
```text
The brute-force approach is to look at all pairs of (i, j) to (k, l)
and check if it's filled with 1s. This approach, however, is O(N*N*N*N*N2) = O(N6).
[ N4 ways to choose i,j,k,l, and then N2 elements in the square ]. 
Can you optimize this approach if you had additional space to store 
results for your previous calculations? 
Maybe if you knew the result for  (i, j) to (k, l - 1)  or (i, j) to (k - 1, l) or both? 
```
* Hint 2
```text
We can improve from N^6 by storing in dp[i][j][k][l] if (i,j) to (k,l) is all filled with 1. 
dp[i][j[k][l] = 1 iff  dp[i][j][k][l-1] = 1 && dp[i][j][k-1][l] = 1 and matrix[k][l] = 1.
Now we can improve this further. What if with every (i,j) we stored
the length of 1s in the same row i starting from (i,j). 
Can we move down in the column j from row i and determine 
the largest rectangle without visiting all cells ? 
```
* Solution Approach
```text
Lets max_x[i][j] denote the length of 1s in the same row i starting from (i,j).
So our current max with one end of the rectangle at (i,j) would be max_x[i][j]. 
As we move to the next row, there are 2 cases : 

  1) max_x[i+1][j] >= max_x[i][j] which means that we can take max_x[i][j] 
    1s from next column as well and extend our current rectangle as it is, 
    with one more extra row.
           11100000         -    111
           11111100         -    111

  2) max_x[i+1][j] < max_x[i][j] which means that if we want to extend our
    current rectangle to next row, we need to reduce the number of columns
    in it to max_x[i+1][j]
           11100000         -     11   
           11000000         -     11
```
<pre>As mentioned above, we keep increasing the columns and adjusting the rectangle's width. 
O(N<sup>3</sup>) time complexity. 

Even though N<sup>3</sup> is acceptable, it might be worth exploring a better solution. 
If you notice, laying out max_x[i][j] helps you make histograms in every row. Then the
problem becomes of finding the maximum area in histograms 
( which we have solved before in Stacks and Queues ) in O(n). 
This would lead to an O(N<sup>2</sup>) solution. 
We strongly suggest you explore the O(N<sup>2</sup>) solution as well.
</pre>

* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size(), ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                int curAns = getMaxRect(A.get(i));
                ans = Math.max(ans, curAns);
            } else {
                for (int j = 0; j < m; j++) {
                    if (A.get(i).get(j) == 1) {
                        //A[i][j] = A[i - 1][j] + 1
                        A.get(i).set(j, A.get(i - 1).get(j) + 1);
                    }
                }
                int curAns = getMaxRect(A.get(i));
                ans = Math.max(ans, curAns);
            }
        }
        return ans;
    }

    public int getMaxRect(ArrayList<Integer> arr) {
        arr.add(0);
        Stack<Integer> st = new Stack<Integer>();
        int i = 0, ans = 0;
        while (i < arr.size()) {
            while (!st.empty() && arr.get(st.peek()) >= arr.get(i)) {
                int h = arr.get(st.peek());
                st.pop();
                int sidx = st.empty() ? -1 : st.peek();
                ans = Math.max(h * (i - sidx - 1), ans);
            }
            st.push(i);
            i++;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    maximalRectangle: function (matrix) {
        const row = matrix.length;
        if (row === 0)
            return 0;
        const col = matrix[0].length,
            tempSum = new Array(row);

        function findMaxArea(arr) {
            let len = arr.length;
            if (len === 1)
                return arr[0];
            let newArr = [...arr];
            newArr.push(-1);
            len++;
            let stack = [],
                maxCount = Number.MIN_SAFE_INTEGER;
            for (let i = 0; i < len; i++) {
                let j = stack.length - 1;
                while (j >= 0 && newArr[stack[j]] >= newArr[i]) {
                    const h = newArr[stack[j]];
                    stack.pop();
                    j--;
                    const otherIndex = j >= 0 ? stack[j] : -1;
                    maxCount = Math.max(maxCount, h * (i - otherIndex - 1));
                }
                stack.push(i);
            }
            return maxCount;
        }

        for (let i = 0; i < row; i++) {
            tempSum[i] = +matrix[i][0];
        }

        let maxArea = findMaxArea(tempSum);
        for (let i = 1; i < col; i++) {
            for (let j = 0; j < row; j++) {
                if (matrix[j][i] == "0") {
                    tempSum[j] = 0;
                } else {
                    tempSum[j] += parseInt(matrix[j][i]);
                }
            }
            maxArea = Math.max(maxArea, findMaxArea(tempSum));
        }
        return maxArea;
    },
};
```
* * Solution in C++
```cpp
int Solution::maximalRectangle(vector < vector < int > > & A) {
    int rows = A.size();
    if (rows == 0) return 0;
    int cols = A[0].size();
    if (cols == 0) return 0;
    assert(rows <= 100 && cols <= 100);
    // max_x stores the number of consecutive 1's to the left of A[i][j], including itself
    vector < vector < int >> max_x(rows, vector < int > (cols, 0)); 

    int area = 0;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (A[i][j] == 1) {
                if (j == 0) 
                    max_x[i][j] = 1;
                else 
                    max_x[i][j] = max_x[i][j - 1] + 1;
                int y = 1;
                int x = cols;
                // finds the area of the rectangles with (i, j) as the bottom right corner
                while ((i - y + 1 >= 0) && (A[i - y + 1][j] == 1)) {
                    x = min(x, max_x[i - y + 1][j]);
                    area = max(area, x * y);
                    y++;
                }
            }
        }
    }

    return area;
}
```

