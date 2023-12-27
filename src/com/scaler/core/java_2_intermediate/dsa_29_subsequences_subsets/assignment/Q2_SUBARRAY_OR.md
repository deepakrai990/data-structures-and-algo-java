### Q2. SUBARRAY OR
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>You are given an array of integers <strong>A</strong> 
    of size <strong>N</strong>.</p>
    <p>The value of a subarray is defined as 
    <strong>BITWISE OR</strong> of all elements in it.</p>
    <p>Return the sum of value of all subarrays of 
    <strong>A % 10<sup>9</sup> + 7</strong>.</p>
</div>

```text
You are given an array of integers A of size N.

The value of a subarray is defined as BITWISE OR of all elements in it.

Return the sum of value of all subarrays of A % 10^9 + 7.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i] &lt;= 10<sup>8</sup></p>
</div>

```text
1 <= N <= 10^5

1 <= A[i] <= 10^8
```
#### Input Format
```text
The first argument given is the integer array A.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Return the sum of Value of all subarrays of A % 10
    <sup>9</sup> + 7.</p>
</div>

```text
Return the sum of Value of all subarrays of A % 10^9 + 7.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]

Input 2:
 A = [7, 8, 9, 10]
```
#### Example Output
```text
Output 1:
 71

Output 2:
 110
```
#### Example Explanation
```text
Explanation 1:
    Value([1]) = 1
    Value([1, 2]) = 3
    Value([1, 2, 3]) = 3
    Value([1, 2, 3, 4]) = 7
    Value([1, 2, 3, 4, 5]) = 7
    Value([2]) = 2
    Value([2, 3]) = 3
    Value([2, 3, 4]) = 7
    Value([2, 3, 4, 5]) = 7
    Value([3]) = 3
    Value([3, 4]) = 7
    Value([3, 4, 5]) = 7
    Value([4]) = 4
    Value([4, 5]) = 5
    Value([5]) = 5
    Sum of all these values = 71

Explanation 2:
    Sum of value of all subarray is 110.
```
### Hints
* Hint 1
```text
Think in terms of a single bit of the number. If we find the 
number of times, that bit will contribute to the answer.
```
* Solution Approach
```text
In this question, we will consider every bit as a unique bit, and 
every bit will have an independent contribution to the answer.

Thus, we will iterate over the whole array for all bits 
independently. We will maintain a 2d array BitInfo[bits][index]. 

The value at any index ind for any bit will signify the next 
index on which this bit is set.

Thus after that index, every subarray corresponding to ind will 
have that bit set. 

In this manner, the contribution of every bit corresponding 
to each bit can be determined independently and can be added 
to the overall answer.

Another way to solve this problem is to iterate over each bit 
and count the number of subarrays in which it won't contribute.

After calculating that, we can deduct this from the total 
count of subarrays(which is the same for each bit).

To count the number of subarrays in which a bit won't have a 
contribution, consider the following example for a random bit:
0 1 1 0 0 0 0 1 1 0 0 1 (0 is for the places where the bit 
is unset, and 1 is for the places where this bit is set)

If the starting till ending point of a subarray does not 
consist of even a single 1, the bit won't contribute to the bitwise OR.
The number of subarrays that can be formed from an 
array of size x is x * (x + 1) / 2. So, we can iterate over 
this binary array that we had precomputed for each bit 
before and applied the formula to get the total 
number of subarrays where the selected bit does not 
contribute to bitwise OR.

More details in the video are provided.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        int[] idx = new int[32];
        long ans = 0;
        for (int i = 1; i <= n; ++i) {
            long tmp = A[i - 1];
            for (int j = 0; j <= 31; ++j) {
                long pw = 1 << j;
                if ((tmp & pw) != 0) { //if jth bit is set
                    ans += pw * i; // add its contribution in ans for all subarrays ending at index i
                    idx[j] = i; // store the index for next elements
                } else if (idx[j] != 0) // if jth bit is not set
                {
                    ans += pw * idx[j]; // add its contribution in ans for all subarrays ending at index i using 
                } // the information of last element having jth bit set
            }
        }
        return (int)(ans % 1000000007);
    }
}
```
* * Solution in Javascript
```javascript
const MOD = 1000000007;
function mult(a, b) {
    let val = a * b;
    if (val <= Number.MAX_SAFE_INTEGER && val >= Number.MIN_SAFE_INTEGER)
        return val % MOD;
    return Number((BigInt(a) * BigInt(b)) % BigInt(MOD));
}

function totalSubarrays(n){
    return (n * (n + 1)) / 2;
}

module.exports = {
    solve: function (A) {
        let ans = 0;
        let n = A.length;
        for (let bit = 0; bit <= 27; bit++) {
            let zeroes = [];
            for (let i = 0; i < n; i++) {
                if ((A[i] & (1 << bit)) == 0) {
                    if (i == 0 || (A[i - 1] & (1 << bit)) != 0) {
                        zeroes.push(0);
                    }
                    zeroes[zeroes.length - 1]++;
                }
            }
            let count = 0;
            // total number of subarray of an array of size n
            count += totalSubarrays(n);
            let sub = 0;
            zeroes.forEach((x) => {
                // subtract the total number of subarrays possible from x elements
                sub += totalSubarrays(x);
            });
            count -= sub;
            // add the contribution due to the current bit
            ans = (ans + mult(count, 1 << bit)) % MOD;
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
#define lli long long
int idx[50];
int Solution::solve(vector < int > & A) {
    int n = A.size();
    memset(idx, 0, sizeof(idx));
    lli ans = 0;
    for (int i = 1; i <= n; ++i) {
        lli tmp = A[i - 1];
        for (int j = 0; j <= 31; ++j) {
            lli pw = 1ll << j;
            if (tmp & pw) { //if jth bit is set
                ans += pw * i; // add its contribution in ans for all subarrays ending at index i
                idx[j] = i; // store the index for next elements
            } else if (idx[j]) // if jth bit is not set
            {
                ans += pw * idx[j]; // add its contribution in ans for all subarrays ending at index i using 
            } // the information of last element having jth bit set
        }
    }
    return ans % 1000000007;
}

Alternate Solution that is explained in the video

long long totalSubarrays(int n){
    return 1LL * n * (n + 1) / 2;
}
int Solution::solve(vector < int > & A) {
    const int mod = 1000000007;
    long long ans = 0;
    int n = A.size();
    for (int bit = 0; bit <= 27; bit++) {
        vector < int > zeroes;
        for (int i = 0; i < n; i++) {
            if ((A[i] & (1 << bit)) == 0) {
                if (i == 0 || (A[i - 1] & (1 << bit)) != 0) {
                    zeroes.push_back(0);
                }
                zeroes.back() ++;
            }
        }
        long long count = 0;
        // total number of subarray of an array of size n
        count += totalSubarrays(n);
        long long sub = 0;
        for (auto x: zeroes) {
            // subtract the total number of subarrays possible from x elements
            sub += totalSubarrays(x);
        }
        count -= sub;
        // add the contribution due to the current bit
        ans = (ans + 1LL * count * (1 << bit)) % mod;
    }
    return ans;
}
```

