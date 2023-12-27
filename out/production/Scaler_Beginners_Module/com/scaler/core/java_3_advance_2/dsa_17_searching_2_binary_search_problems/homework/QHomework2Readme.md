### Q2. Find Smallest Again
#### Problem Description

<div><p>Given an integer array <strong>A</strong> of size 
<strong>N</strong>.</p> <p>If we store the sum of each triplet of 
the array <strong>A</strong> in a new list, then find the 
<strong>B<sup>th</sup></strong> smallest element among 
the list.</p> <p><strong>NOTE:</strong> A triplet consists 
of three elements from the array. Let's say if 
<strong>A[i], A[j], A[k]</strong> are the elements of the 
triplet then <strong>i &lt; j &lt; k</strong>.</p></div>

```text
Given an integer array A of size N.

If we store the sum of each triplet of the array A in a new 
list, then find the B th smallest element among the list.

NOTE: A triplet consists of three elements from the 
array. Let's say if A[i], A[j], A[k] are the elements 
of the triplet then i < j < k.
```
#### Problem Constraints
* <p>3 &lt;= N &lt;= 500</p>
* <p>1 &lt;= A[i] &lt;= 10<sup>8</sup></p>
* <p>1 &lt;= B &lt;= <code>(N*(N-1)*(N-2))/6</code></p>
```text
3 <= N <= 500
1 <= A[i] <= 10^8
1 <= B <= (N*(N-1)*(N-2))/6
```
#### Input Format
```text
The first argument is an integer array A.
The second argument is an integer B.
```
#### Output Format

<p> Return an integer denoting the B<sup>th</sup> element of the list.</p>

```text
Return an integer denoting the B th element of the list.
```
#### Example Input
```text
Input 1:
 A = [2, 4, 3, 2]
 B = 3

Input 2:
 A = [1, 5, 7, 3, 2]
 B = 9
```
#### Example Output
```text
Output 1:
 9 

Output 2:
 14
```
#### Example Explanation
```text
Explanation 1:

 All the triplets of the array A are:

 (2, 4, 3) = 9
 (2, 4, 2) = 8
 (2, 3, 2) = 7
 (4, 3, 2) = 9

 So the 3^rd smallest element is 9.
```
<pre> All the triplets of the array A are:

 (2, 4, 3) = 9
 (2, 4, 2) = 8
 (2, 3, 2) = 7
 (4, 3, 2) = 9

 So the 3<sup>rd</sup> smallest element is 9.
</pre>

### Hints
* Hint 1
```text
The trivial way to do it is by generating all possible triplets and 
sorting all of them, and finding elements at index B-1.
But it will exceed the memory limit for larger test cases.
So think of using binary search.
```
* Solution Approach

<div><p>We can do this by binary search in O(N<sup>2</sup>logA[i]).<br>
As the answer lies in the range [3 to 3*10<sup>8</sup>]. So we binary 
search in this range <br> and can choose a mid and count the number of 
triplets whose sum is less than mid.<br> If the count of triplets is 
more than or equal to B, then our answer is lesser than mid<br>
Else our answer is greater than equal to mid.<br>
So we can use that to find the answer.</p>
<p>Time Complexity : O(N<sup>2</sup>logA[i])<br>
Space Complexity : O(1)</p></div>

```text
We can do this by binary search in O(N^2logA[i]).

As the answer lies in the range [3 to 3*10^8]. So we binary search in this range
and can choose a mid and count the number of triplets whose sum is less than mid.

If the count of triplets is more than or equal to B, then our answer is lesser 
than mid

Else our answer is greater than equal to mid.

So we can use that to find the answer.

Time Complexity : O(N^2logA[i])
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int check(int[] A, int val) {
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            int s = i + 1, e = A.length - 1;
            while (s < e) {
                if (A[i] + A[s] + A[e] < val) {
                    cnt += e - s;
                    s++;
                } else {
                    e--;
                }
            }
        }
        return cnt;
    }

    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int n = A.length;
        int low = 0, high = A[n - 1] + A[n - 2] + A[n - 3], ans = 0;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            // count of triplets with sum less than mid
            int count = check(A, mid);
            if (count >= B) {
                high = mid - 1;
            } else {
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
function check(A, val) {
    let cnt = 0;
    for (let i = 0; i < A.length; i++) {
        let s = i + 1,
            e = A.length - 1;
        while (s < e) {
            if (A[i] + A[s] + A[e] < val) {
                cnt += e - s;
                s++;
            } else {
                e--;
            }
        }
    }
    return cnt;
}
module.exports = {
    solve: function (A, B) {
        A.sort((a, b) => a - b);
        let n = A.length;
        let low = 0,
            high = A[n - 1] + A[n - 2] + A[n - 3],
            ans = 0;

        while (low <= high) {
            let mid = Math.floor((high - low) / 2) + low;
            let count = check(A, mid);
            if (count >= B) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
int check(vector < int > & A, int val) {
    int cnt = 0;
    for (int i = 0; i < A.size(); i++) {
        int s = i + 1, e = A.size() - 1;
        while (s < e) {
            if (A[i] + A[s] + A[e] < val) {
                cnt += e - s;
                s++;
            } else {
                e--;
            }
        }
    }
    return cnt;
}

int Solution::solve(vector < int > & A, int B) {
    int n = A.size();
    sort(A.begin(), A.end());
    int low = 0, high = A[n - 1] + A[n - 2] + A[n - 3], ans = 0;
    while (low <= high) {
        int mid = (high - low) / 2 + low;
        // count of triplets with sum less than mid
        int count = check(A, mid);
        if (count >= B) {
            high = mid - 1;
        } else {
            ans = mid;
            low = mid + 1;
        }
    }
    return ans;
}
```

