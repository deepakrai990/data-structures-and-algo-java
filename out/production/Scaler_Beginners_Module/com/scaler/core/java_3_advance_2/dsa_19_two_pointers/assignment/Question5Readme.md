### Q5. 3 Sum
#### Problem Description
```text
Given an array A of N integers, find three integers in A such 
that the sum is closest to a given number B. Return the 
sum of those three integers.

Assume that there will only be one solution.
```
#### Problem Constraints
* <p> -10<sup>8</sup> &lt;= B &lt;= 10<sup>8</sup></p>
* <p> 1 &lt;= N &lt;= 10<sup>4</sup></p>
* <p> -10<sup>8</sup> &lt;= A[i] &lt;= 10<sup>8</sup></p>
```text
-10^8 <= B <= 10^8
1 <= N <= 10^4
-10^8 <= A[i] <= 10^8
```
#### Input Format
```text
First argument is an integer array A of size N.

Second argument is an integer B denoting the sum you need to 
get close to.
```
#### Output Format
```text
Return a single integer denoting the sum of three integers which 
is closest to B.
```
#### Example Input
```text
Input 1:
 A = [-1, 2, 1, -4]
 B = 1

Input 2:
 A = [1, 2, 3]
 B = 6
```
#### Example Output
```text
Output 1:
 2

Output 2:
 6
```
#### Example Explanation
```text
Explanation 1:
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

Explanation 2:
 Take all elements to get exactly 6.
```
### Hints
* Hint 1
```text
The naive approach obviously is exploring all combinations 
of 3 integers using 3 loops.

Now, to look into improving, does it help if we sort the array?
```
* Solution Approach
```text
As stated in the earlier hint, the naive approach is to have 3 loops 
of i,j,k over the array. We then just track S[i]+S[j]+S[k] for the 
case when (S[i]+S[j]+S[k]-target) is minimum.

The code for the same looks something like the following :


  IF number of elements in S < 3
    THEN return -1; // Invalid case
  minDifference = abs(S[0] + S[1] + S[2] - target);
  bestTillNow = S[0] + S[1] + S[2];
  FOR i = 0 to size of S
    FOR j = i + 1 to size of S
      FOR k = j + 1 to size of S
        newDiff = abs(S[i] + S[j] + S[k] - target)
        IF newDiff < minDifference
          minDifference = newDiff
          bestTillNow = S[i] + S[j] + S[k]
        END IF
      END FOR
    END FOR
  END FOR

  bestTillNow is my answer. 

However, as stated earlier this approach is O(N^3). Lets see if we can do better.

Lets sort the array.
When the array is sorted, try to fix the least integer by looping over it.
Lets say the least integer in the solution is arr[i].

Now we need to find a pair of integers j and k, such that arr[j] + arr[k] is 
closest to (target - arr[i]).
To do that, let us try the 2 pointer approach.
If we fix the two pointers at the end ( that is, i+1 and end of array ), we 
look at the sum.

    * If the sum is smaller than the sum we need to get to, we increase 
      the first pointer.
    * If the sum is bigger, we decrease the end pointer to reduce the sum.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int threeSumClosest(int[] A, int B) {
        int n = A.length, diff = 1000000000, ans = -1;
        Arrays.sort(A);
        // fix the smallest number of the three integers
        for (int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (Math.abs(A[i] + A[j] + A[k] - B) < diff) {
                    diff = Math.abs(A[i] + A[j] + A[k] - B);
                    ans = A[i] + A[j] + A[k];
                }
                if (A[i] + A[j] + A[k] > B)
                    k--;
                else
                    j++;
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    threeSumClosest: function (A, B) {
        A.sort((a, b) => a - b);
        let sum = 1e12;
        // fix the smallest number of the three integers
        for (let i = 0; i < A.length; i++) {
            let lo = i + 1;
            let hi = A.length - 1;
            let cur = 0;
            while (lo < hi) {
                cur = A[i] + A[lo] + A[hi];
                if(Math.abs(B - cur) < Math.abs(B - sum)) sum = cur;
                if (cur < B) lo++;
                else hi--;
            }
        }
        return sum;
    },
};
```
* * Solution in C++
```cpp
int Solution::threeSumClosest(vector < int > & A, int B) {
    vector < int > num;
    int target = B;
    num = A;
    sort(num.begin(), num.end());
    int bestSum = 1000000000, sum = 0;
    // fix the smallest number of the three integers
    for (int i = 0; i < num.size() - 2; i++) {
        int ptr1 = i + 1, ptr2 = num.size() - 1;
        while (ptr1 < ptr2) {
            sum = num[i] + num[ptr1] + num[ptr2];
            if (abs(target - sum) < abs(target - bestSum)) {
                bestSum = sum;
            }
            if (sum > target) {
                ptr2--;
            } else {
                ptr1++;
            }
        }
    }
    return bestSum;
}
```

