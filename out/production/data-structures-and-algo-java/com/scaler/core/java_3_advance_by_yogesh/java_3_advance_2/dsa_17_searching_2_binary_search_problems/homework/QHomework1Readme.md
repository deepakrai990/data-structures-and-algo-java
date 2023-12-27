### Q1. ADD OR NOT
#### Problem Description
```text
Given an array of integers A of size N and an integer B.

In a single operation, any one element of the array can be 
increased by 1. You are allowed to do at most B such operations.

Find the number with the maximum number of occurrences and 
return an array C of size 2, where C[0] is the number of 
occurrences, and C[1] is the number with maximum occurrence.

If there are several such numbers, your task is to find the minimum one.
```
#### Problem Constraints
* <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
* <p>-10<sup>9</sup> &lt;= A[i] &lt;= 10<sup>9</sup></p>
* <p>0 &lt;= B &lt;= 10<sup>9</sup></p>
```text
1 <= N <= 10^5

-10^9 <= A[i] <= 10^9

0 <= B <= 10^9
```
#### Input Format
```text
The first argument given is the integer array A.
The second argument given is the integer B.
```
#### Output Format
```text
Return an array C of size 2, where C[0] is number of 
occurrence and C[1] is the number with maximum occurrence.
```
#### Example Input
```text
Input 1:
 A = [3, 1, 2, 2, 1]
 B = 3

Input 2:
 A = [5, 5, 5]
 B = 3
```
#### Example Output
```text
Output 1:
 [4, 2]

Output 2:
 [3, 5]
```
#### Example Explanation
```text
Explanation 1:
    Apply operations on A[2] and A[4]
    A = [3, 2, 2, 2, 2]
    Maximum occurrence =  4
    Minimum value of element with maximum occurrence = 2

Explanation 2:
    A = [5, 5, 5]
    Maximum occurrence =  3
    Minimum value of element with maximum occurrence = 5
```
### Hints
* Hint 1
```text
For each i, considering A[i] be the minimum value, count 
the number of elements we can make equal to A[i] in not 
more than B operations

Can we apply Binary Search to it?
```
* Solution Approach
```text
Sort array in non-decreasing order.
Iterate over A[i] and calculate, what is the maximal number 
of A[i] we can obtain.

For maximizing the first number of answer, we must increase 
some lesser numbers to A[i] and perform not greater 
than B operations.

It is obvious that first, we should increase such A[j] 
that A[i]–A[j] is minimal.

So, if we can solve the problem in O(n^2), we would 
iterate j from i to 0 and increase A[j] to A[i] while we could.

But the solution must be faster, and we will use binary search.

We will brute the number of numbers, which we must do 
equal to A[i].

Suppose we fix cnt this value. Now we have to check if we 
can do cnt numbers equal to A[i] by not greater 
than B operations.

For doing this, let’s calculate A[i]*cnt - sum(i-cnt+1,i) . 
If this value not greater than B, we can do it.

For calculating sum quickly, we can save prefix sums and 
than s(i-cnt+1,i)=s(i)–s(i–cnt).

Finally, we solved this problem in O(n * log n).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
   public int[] solve(int[] A, int B) {
      // To do the prefix sum
      long prefix[] = new long[A.length + 1];
      Arrays.sort(A);
      int n = A.length;
      // Make prefix array
      for (int i = 0; i < n; i++) {
         prefix[i + 1] += A[i] + prefix[i];
      }
      int ans[] = new int[2];
      ans[0] = -1;
      ans[1] = -1;
      for (int i = 0; i < n; i++) {
         int lo = 1, hi = i + 1;
         int mx = 0;
         // Binary search to find the value of cnt for each i
         while (lo <= hi) {
            int cnt = (lo + hi) / 2;
            if ((long) A[i] * cnt - (prefix[i + 1] - prefix[i - cnt + 1]) <= B) {
               mx = cnt;
               lo = cnt + 1;
            } else {
               hi = cnt - 1;
            }
         }
         // Update ans
         if (ans[0] < mx) {
            ans[0] = mx;
            ans[1] = A[i];
         }
      }
      return ans;
   }
}
```
* * Solution in Javascript
```javascript
module.exports = {
  solve: function (A, B) {
    A.sort((a, b) => a - b);
    let n = A.length;
    let mx = -2e9;
    let el = 0;
    let req = 0;
    let i = 0,
      j = 0;
    while (j < n) {
      if (req <= B) {
        if (mx < j - i + 1) {
          mx = j - i + 1;
          el = A[j];
        }
      }
      if (req <= B) {
        j++;
        req += (A[j] - A[j - 1]) * (j - i);
      } else {
        i++;
        req -= A[j] - A[i - 1];
      }
    }
    let ans = [];
    ans.push(mx);
    ans.push(el);
    return ans;
  },
};
```
* * Solution in C++
```cpp
/** Approach 1 **/

// To do the prefix sum
long long prefix[100005];

bool check(long long cnt, int B, vector < int > & A, int i) {
   // To check whether we can change cnt numbers to A[i] 
   if (A[i] * cnt - (prefix[i + 1] - prefix[i - cnt + 1]) <= B) {
      return true;
   }
   return false;
}
vector < int > Solution::solve(vector < int > & A, int B) {
   // Initialize value to 0 
   memset(prefix, 0, sizeof(prefix));
   sort(A.begin(), A.end());

   int n = A.size();
   // Make prefix array
   for (int i = 0; i < n; i++) {
      prefix[i + 1] += A[i] + prefix[i];
   }
   vector < int > ans(2);
   ans[0] = -1;
   ans[1] = -1;
   for (int i = 0; i < n; i++) {
      int lo = 1, hi = i + 1;
      int mx = 0;
      // Binary search to find the value of cnt for each i
      while (lo <= hi) {
         long long cnt = (lo + hi) / 2;
         if (check(cnt, B, A, i)) {
            mx = cnt;
            lo = cnt + 1;
         } else {
            hi = cnt - 1;
         }
      }
      // Update ans
      if (ans[0] < mx) {
         ans[0] = mx;
         ans[1] = A[i];
      }
   }
   return ans;
}

/** Approach 2 **/

vector < int > Solution::solve(vector < int > & A, int B) {
   sort(A.begin(), A.end());
   int n = A.size();
   int mx = INT_MIN;
   int el = 0;
   long long int req = 0;
   int i = 0, j = 0;
   while (j < n) {
      if (req <= B) {
         if (mx < j - i + 1) {
            mx = j - i + 1;
            el = A[j];
         }
      }
      if (req <= B) {
         j++;
         req += (long long)(A[j] - A[j - 1]) * (j - i);
      } else {
         i++;
         req -= (A[j] - A[i - 1]);
      }
   }
   vector < int > ans;
   ans.push_back(mx);
   ans.push_back(el);
   return ans;
}
```

