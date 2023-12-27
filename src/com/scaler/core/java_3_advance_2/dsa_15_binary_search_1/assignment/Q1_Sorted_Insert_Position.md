### Q1. Sorted Insert Position
#### Problem Description
```text
Given a sorted array A of size N and a target value B, return the 
index (0-based indexing) if the target is found.
If not, return the index where it would be if it were inserted in order.

NOTE: You may assume no duplicates in the array. Users are expected 
to solve this in O(log(N)) time.
```
#### Problem Constraints
* <p>1 &lt;= N &lt;= 10<sup>6</sup></p>
```text
1 <= N <= 10^6
```
#### Input Format
```text
The first argument is an integer array A of size N.
The second argument is an integer B.
```
#### Output Format
```text
Return an integer denoting the index of target value.
```
#### Example Input
```text
Input 1:
 A = [1, 3, 5, 6]
 B = 5 

Input 2:
 A = [1]
 B = 1
```
#### Example Output
```text
Output 1:
 2 

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
 The target value is present at index 2. 

Explanation 2:
 The target value is present at index 0.
```
### Hints
* Hint 1
```text
You need to return the index of least element >= x.
You can do this by binary search.
```
* Solution Approach
```text
Not available 
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
  public int searchInsert(int[] A, int B) {
        int l = 0, h = A.length - 1;
        int ans = A.length;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (A[mid] > B) {
                ans = Math.min(ans, mid);
                h = mid - 1;
            } else if (A[mid] < B) {
                l = mid + 1;
            } else 
                return mid;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of integers
 //param B : integer
 //return an integer
	searchInsert : function(A, B){
        let n = A.length;
        let low = 0;
        let high = n - 1;
        while (low <= high){
            let mid = Math.floor((low + high) / 2);
            if (A[mid] == B){
                return mid;
            }
            else if (A[mid] < B){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
	}
};
```
* * Solution in C++
```cpp
int Solution::searchInsert(vector<int> &A, int B) {
    int target = B;
    int n = A.size();
    int start = 0, end = n - 1;
    int mid;
    while(start <= end){
        mid = (start + end) / 2;
        if(target == A[mid]){
            return mid;
        }
        else if(target < A[mid]){
            end = mid - 1;
        }
        else{
            start = mid + 1;
        }
    }
    return start;
}
```

