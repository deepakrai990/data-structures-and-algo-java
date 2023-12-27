### Q4. Pairs with given sum II
#### Problem Description
```text
Given a sorted array of integers (not necessarily distinct) A 
and an integer B, find and return how many pair of 
integers ( A[i], A[j] ) such that i != j have sum equal to B.
```

<p>Since the number of such pairs can be very large, return 
number of such pairs modulo (10<sup>9</sup> + 7).</p>

#### Problem Constraints
* <p>1 &lt;= |A| &lt;= 100000</p>
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
Return the number of pairs for which sum is equal 
to B modulo (10^9+7).
```

<p>Return the number of pairs for which sum is equal 
to B modulo (10<sup>9</sup>+7)</p>

#### Example Input
```text
Input 1:
 A = [1, 1, 1]
 B = 2
Input 2:
 A = [1, 1]
 B = 2
```
#### Example Output
```text
Output 1:
 3

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
 Any two pairs sum up to 2.

Explanation 2:
 only pair (1, 2) sums up to 2.
```
### Hints
* Hint 1
```text
What is the brute force solution?
You can iterate over all pairs and count.
Due to large constraint, this will exceed time limit.
Can you think of a two pointer approach?
```
* Solution Approach
```text
Let us formulate a two pointer approach to the this problem.

We will first sort the given array and use 
two pointers i and j with i = 0, j = Length of Array - 1.

We will have three conditions:

1. A[i] + A[j] < sum  --> We will increase the pointer i.
2. A[i] + A[j] > sum  --> We will decrease the pointer j.
3. A[i] + A[j] = sum  --> We will count the frequency of A[i] and A[j] and 
multiply them and add to the answer.

Note, that if A[i] and A[j] are equal in value, then we will 
have to change the formula instead:
freq(A[i]) * freq(A[i]) –> freq(A[i]) * (freq(A[i]) - 1) / 2
to avoid over-counting pairs.

Refer to the complete solution for more details.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int B) {
        int i = 0, j = A.length - 1, mod = 1000 * 1000 * 1000 + 7;
        long ans = 0;
        while (i < j) {
            if (A[i] + A[j] == B) {
                int ii = i, jj = j;
                if (A[i] == A[j]) {
                    // equal A[i] and A[j]
                    long cnt = j - i + 1;
                    ans += (cnt * (cnt - 1) / 2) % mod;
                    ans %= mod;
                    break;
                } else {
                    // count number of elements with value A[i]
                    while (A[i] == A[ii]) {
                        ii++;
                    }
                    int cnt1 = ii - i;
                    i = ii;
                    // count number of elements with value A[j]
                    while (A[jj] == A[j]) {
                        jj--;
                    }
                    int cnt2 = j - jj;
                    j = jj;
                    ans += (cnt1 * cnt2) % mod;
                    ans %= mod;
                }
            } else if (A[i] + A[j] > B) {
                j--;
            } else i++;
        }
        return (int) ans;
    }
}
```
* * Solution in Javascript
```javascript
const MOD = 1e9 + 7;
module.exports = {
    solve: function (A, B) {
        let lo = 0;
        let hi = A.length - 1;
        let ans = 0;
        while (lo < hi) {
            if (A[lo] + A[hi] == B) {
                // equal A[lo] and A[hi]
                if (A[lo] == A[hi]) {
                  let range = hi - lo + 1;
                  ans += ((range * (range - 1)) / 2) % MOD;
                  break;
                }
                let a = 1,b = 1;
                // count number of elements with value A[lo]
                while (lo + 1 < A.length && A[lo + 1] == A[lo]) lo++, a++;
                // count number of elements with value A[hi]
                while (hi - 1 >= 0 && A[hi - 1] == A[hi]) hi--, b++;
                ans += (a * b) % MOD;
                lo++, hi--;
            } else if (A[lo] + A[hi] > B) 
                hi--;
            else 
                lo++;
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
const int mod = (int)(1e9 + 7);
int Solution::solve(vector < int > & A, int B) {
    int n = A.size(), i = 0, j = n - 1;
    long count = 0;
    while (i < j) {
        int sum = A[i] + A[j];
        if (sum == B) {
             if (A[i] != A[j]) {
                int a = 1, b = 1;
                // count number of elements with value A[i]
                while (i + 1 < j && A[i] == A[i + 1]) i++, a++;
                // count number of elements with value A[j]
                while (j - 1 > i && A[j] == A[j - 1]) j--, b++;
                count = (count + (a * 1l * b) % mod) % mod;
                i++, j--;
            } else { 
                // equal A[i] and A[j]
                int cnt = 1;
                cnt = (j - i + 1);
                cnt = (cnt * 1ll * (cnt - 1) / 2) % mod;
                count = (cnt + count) % mod;
                break;
            }
        } else if (sum > B)
            j--;
        else i++;
    }
    return count;
}
```

