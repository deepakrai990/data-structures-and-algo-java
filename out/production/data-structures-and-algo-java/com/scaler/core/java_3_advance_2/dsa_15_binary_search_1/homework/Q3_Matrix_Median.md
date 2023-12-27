### Q3. Matrix Median
#### Problem Description
```text
Given a matrix of integers A of size N x M in which each 
row is sorted.

Find and return the overall median of matrix A.

NOTE: No extra memory is allowed.

NOTE: Rows are numbered from top to bottom and columns are 
numbered from left to right.
```
#### Problem Constraints
* <p>1 <= N, M <= 10<sup>5</sup></p>
* <p>1 <= N x M <= 10<sup>6</sup></p>
* <p>1 <= A[i] <= 10<sup>9</sup></p>
* <p>N x M is odd</p>
```text
1 <= N, M <= 10^5

1 <= N*M <= 10^6

1 <= A[i] <= 10^9

N*M is odd
```
#### Input Format
```text
The first and only argument given is the integer matrix A.
```
#### Output Format
```text
Return the overall median of matrix A.
```
#### Example Input
```text
Input 1:
 A = [   [1, 3, 5],
         [2, 6, 9],
         [3, 6, 9]   ] 

Input 2:
 A = [   [5, 17, 100]    ]
```
#### Example Output
```text
Output 1:
 5 

Output 2:
 17
```
#### Example Explanation
```text
Explanation 1:
    A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
    Median is 5. So, we return 5. 

Explanation 2:
    Median is 17.
```
### Hints
* Hint 1
```text
We cannot use extra memory, so we can’t store all elements in 
an array and sort the array.

But since rows are sorted, it must be of some use, right?

Note that in a row, you can binary search to find how many 
elements are smaller than a value X in O(log M).
```
* Solution Approach
```text
We cannot use extra memory, so we can’t store all elements in 
an array and sort the array.

But since rows are sorted, it must be of some use, right?

Note that in a row, you can binary search to find how many 
elements are smaller than a value X in O(log M).
This is the base of our solution.

Say k = N*M/2. We need to find (k + 1)^th smallest element.
We can use binary search on the answer. In O(N log M), we can 
count how many elements are smaller than X in the matrix.

So, we use binary search on the interval [1, INT_MAX]. So, 
the total complexity is O(30 * N log M).

Note:
This problem can be solved by using a min-heap, but extra 
memory is not allowed.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int lowerBound(int A[], int val){    
        int l = 0, h = A.length-1, ans = -1;
        while(l <= h){
            int mid = (h - l) / 2 + l;
            if(A[mid] < val){
                ans = mid;
                l = mid + 1;
            }
            else
                h = mid - 1;
        }
        return ans + 1;
    }
    public int findMedian(int[][] A) {
        int low = 0, high = 1000000000, n = A.length, m = A[0].length;
        int medPos = n * m / 2, ans = -1; // number of elements less than median element
        while(low <= high){
            int mid = (high - low)/2 + low;
            int cnt = 0;
            //count in each row numer of elements <= mid
            for(int i = 0; i < n; i++)
                cnt += lowerBound(A[i], mid);
            if(cnt > medPos)
                high = mid - 1;
            else{
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
  findMedian: function (A) {
    function getCount(val) {
      let ret = 0;
      for (let i = 0; i < A.length; i++) {
        let lo = 1,
          hi = A[i].length,
          mid,
          ans = 0;
        while (lo <= hi) {
          mid = (lo + hi) >> 1;
          if (A[i][mid - 1] <= val) {
            ans = mid;
            lo = mid + 1;
          } else hi = mid - 1;
        }
        ret += ans;
      }
      return ret;
    }

    let need = Math.floor((A.length * A[0].length) / 2);
    let lo = 1;
    let hi = 1e9;

    let mid, ans;
    while (lo <= hi) {
      mid = (lo + hi) >> 1;
      let count = getCount(mid);
      if (count >= need + 1) {
        ans = mid;
        hi = mid - 1;
      } else lo = mid + 1;
    }
    return ans;
  },
};
```
* * Solution in C++
```cpp
int Solution::findMedian(vector<vector<int> > &A) {
    int l = 0, r = INT_MAX;
    int mid, req = (int)A.size() * (int)A[0].size();
    while(r - l > 1){
        mid = l + (r - l) / 2;
        int cnt = 0;
        for(auto &i: A){ 
            //using upper bound in a sorted array to count number of elements smaller than mid
            int p = upper_bound(i.begin(), i.end(), mid) - i.begin();
            cnt += p;
        }
        if(cnt >= (req/2 +1)) 
            r = mid;
        else l = mid;
    }   
    return r;
}
```

