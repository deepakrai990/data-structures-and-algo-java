### Q3. Special Integer
#### Problem Description
```text
Given an array of integers A and an integer B, find and return the 
maximum value K such that there is no subarray in A of size K with 
the sum of elements greater than B.
```
#### Problem Constraints
* <p>1 &lt;= |A| &lt;= 100000<p></p>
* <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
* <p>1 &lt;= B &lt;= 10<sup>9</sup></p>
```text
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9
```
#### Input Format
```text
The first argument given is the integer array A.

The second argument given is integer B.
```
#### Output Format
```text
Return the maximum value of K (sub array length).
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 10

Input 2:
 A = [5, 17, 100, 11]
 B = 130
```
#### Example Output
```text
Output 1:
 2

Output 2:
 3
```
#### Example Explanation
```text
Explanation 1:
    Constraints are satisfied for maximal value of 2.

Explanation 2:
    Constraints are satisfied for maximal value of 3.
```
### Hints
* Hint 1
```text
You need to find the maximal K.
Can you think of a way to do this by binary search??
```
* Solution Approach
```text
You need to find the maximal K.

Think of a way to do this by binary search.

You can use binary search to find if a certain K is allowed or not.

if it is, you try finding a bigger answer

if not, try finding a smaller answer.

    int l = 1, r = a.length;
    while(l <= r) {
        int m = (l + r) >> 1;
        if(check(a, b, m))
            l = m + 1;
        else
            r = m - 1;
    }
    return l-1;

How do we check for a particular K if it is allowed or not?

We can use the sliding window technique.
First we can compute the sum from 0 to k-1. Check if it is less than 
of equal to B or not.

To move to the next window we can simply subtract a[0] from the sum 
and add a[K], and repeat the process.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public void prefix_function(int[] A, long[] prefix){
        // calculating the prefix sum
        for (int i = 0; i < A.length; ++i) {
            prefix[i] = A[i];
            if(i > 0)
                prefix[i] += prefix[i - 1];
        }
    }
    
    public int solve(int[] A, int B) {
        long[] prefix = new long[A.length];
        prefix_function(A, prefix);
        // Binary search for the length  
        int lo = 1;
        int hi = A.length, ans = 0;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo; // to keep our mid towards the right
            if (check(mid, prefix, (long) B) == 1) {
                hi = mid - 1;
            } else {
                ans = mid;
                lo = mid + 1;
            }
        }
        return ans;
    }

   // Checks if there is a subarray of size s whose sum is greater than sm in linear time
   int check(int s, long[] arr, long sm) {
        int flag = 0;
        for (int i = s - 1; i < arr.length; ++i) {
            if (i == s - 1) {
                if (arr[i] > sm)
                    return 1;
            } else if (arr[i] - arr[i - s] > sm) {
                return 1;
            }
        }
        return 0;
    }
}
```
* * Solution in Javascript
```javascript
// Checks if there is a subarray of size s whose sum is greater than sm in linear time
function check(s, arr, sm) {
    let flag = false;
    for (let i = s - 1; i < arr.length; ++i) {
        flag = i == s - 1 && arr[i] > sm ? true : arr[i] - arr[i - s] > sm ? true : false;
        if (flag) return flag;
    }
    return flag;
}

function prefix_function(A) {
    // calculating the prefix sum
    let prefix = new Array(A.length).fill(0);
    for (let i = 0; i < A.length; ++i) {
        prefix[i] = A[i];
        if (i > 0){
            prefix[i] += prefix[i - 1];
        }
    }
    return prefix;
}

module.exports = {
    solve: function (A, B) {
        let prefix = prefix_function(A);
        let lo = 1;
        let hi = A.length;
        let ans = 0;
        // Binary search for the length  
        while (lo <= hi) {
            let mid = lo + hi >> 1; 
            if (check(mid, prefix, B)) {
                hi = mid - 1;
            } else {
                ans = mid;
                lo = mid + 1;
            }
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
// Checks if there is a subarray of size s whose sum is greater than sm in linear time
bool check(int s, vector<long long> &arr, long long sm){
    bool flag = false;
    for(int i = s - 1; i < arr.size(); ++i){
        flag = (i == s - 1 and arr[i] > sm ? true : arr[i] - arr[i - s] > sm ? true : false);
        if(flag)
            return flag;
    }
    return flag;
}
void prefix_function(vector<long long> &prefix, vector<int> &A){
    // calculating the prefix sum;
    for(int i = 0; i < A.size(); ++i){
        prefix[i] = A[i];
        if(i > 0)
            prefix[i] += prefix[i - 1];
    }
}
int Solution::solve(vector<int> &A, int B) {
    vector<long long> prefix(A.size());
    prefix_function(prefix, A);
    // Binary search for the length 
    int lo = 1; int hi = A.size(); int ans = 0;
    while(lo <= hi){
        int mid = (hi - lo) / 2 + lo; // to keep our mid towards the right
        if(check(mid, prefix, (long long)B)){
            hi = mid - 1;
        }
        else{
            lo = mid + 1;
            ans = mid;
        }
    }
    return ans;
}
```

