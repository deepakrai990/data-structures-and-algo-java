### Q2. Aggressive cows
#### Problem Description
```text
Farmer John has built a new long barn with N stalls. Given an 
array of integers A of size N where each element of the array 
represents the location of the stall and an integer B which 
represents the number of cows.

His cows don't like this barn layout and become aggressive 
towards each other once put into a stall. To prevent the 
cows from hurting each other, John wants to assign the cows 
to the stalls, such that the minimum distance between any 
two of them is as large as possible. What is the largest 
minimum distance?
```
#### Problem Constraints
* <p>2 &lt;= N &lt;= 100000</p>
* <p>0 &lt;= A[i] &lt;= 10<sup>9</sup></p>
* <p>2 &lt;= B &lt;= N</p>
```text
2 <= N <= 100000
0 <= A[i] <= 10^9
2 <= B <= N
```
#### Input Format
```text
The first argument given is the integer array A.
The second argument given is the integer B.
```
#### Output Format
```text
Return the largest minimum distance possible among the cows.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 3

Input 2:
 A = [1, 2]
 B = 2
```
#### Example Output
```text
Output 1:
 2

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    John can assign the stalls at location 1, 3 and 5 to 
    the 3 cows respectively. So the minimum distance will be 2.

Explanation 2:
    The minimum distance will be 1.
```
### Hints
* Hint 1
```text
We’ll do the binary search to find the best possible 
maximum difference.

Since the maximum difference ranges between 0 to the 
max of array.

If we sort the array, the binary search starts 
with l = 0 and r = A[n-1], and we’ve to find the 
maximum distance.
```
* Solution Approach
```text
We’ll do the binary search to find the best possible 
maximum difference.

Since the maximum difference ranges between 0 to the 
max of array.

If we sort the array, the binary search starts 
with l = 0 and r = A[n-1], and we’ve to find 
the maximum distance.

For mid in binary search, we will check whether there 
are B stalls such that the minimum distance is greater 
than equal to mid.

Finally, store the maximum value we can get.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
   public boolean check(int x, int[] A, int c) {
      int j = 0, n = A.length;
      int cnt = 1;
      for (int i = 1; i < n; i++) {
         if (A[i] - A[j] >= x) {
            j = i;
            cnt++;
         }
      }
      return (cnt >= c);
   }

   public int solve(int[] A, int B) {
      int n = A.length;
      Arrays.sort(A);
      int l = 1, r = 1000 * 1000 * 1000;
      int ans = 1;
      while (l <= r) {
         int mid = (l + r) / 2;
         if (check(mid, A, B)) {
            ans = mid;
            l = mid + 1;
         } else {
            r = mid - 1;
         }
      }
      return ans;
   }
}
```
* * Solution in Javascript
```javascript
function canplace(x, v, c) {
  let cur = v[0];
  c--;
  for (let i = 1; i < v.length; i++) {
    if (v[i] - cur >= x) {
      c--;
      cur = v[i];
    }
  }
  if (c <= 0) return true;
  return false;
}

module.exports = {
  solve: function (v, c) {
    v.sort((a, b) => a - b);

    let i = 0,
      j = v[v.length - 1] - v[0];
    let mid,
      ans = 0;

    while (i <= j) {
      mid = (i + j) >> 1;
      if (canplace(mid, v, c)) {
        ans = mid;
        i = mid + 1;
      } else j = mid - 1;
    }
    return ans;
  },
};
```
* * Solution in C++
```cpp
bool check(int x, vector < int > A, int c) {
   int j = 0, n = A.size();
   int cnt = 1;
   for (int i = 1; i < n; i++) {
      if (A[i] - A[j] >= x) {
         j = i;
         cnt++;
      }
   }
   return (cnt >= c);
}

int Solution::solve(vector < int > & A, int B) {
   int n = A.size();
   sort(A.begin(), A.end());
   assert(B <= n && B >= 2);
   int l = 1, r = 1e9;
   int ans = 1;
   while (l <= r) {
      int mid = (l + r) / 2;
      if (check(mid, A, B)) {
         ans = mid;
         l = mid + 1;
      } else {
         r = mid - 1;
      }
   }
   return ans;
}
```

