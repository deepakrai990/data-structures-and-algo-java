### Q3. Different Bits Sum Pairwise
#### Problem Description
```text
We define f(X, Y) as the number of different corresponding 
bits in the binary representation of X and Y.
For example, f(2, 7) = 2, since the binary representation 
of 2 and 7 are 010 and 111, respectively. The first and 
the third bit differ, so f(2, 7) = 2.
```
* <p>You are given an array of N positive integers, A<sub>1</sub>, 
    A<sub>2</sub>,..., A<sub>N</sub>. Find sum of 
    <code>f(A<sub>i</sub>, A<sub>j</sub>)</code> for all 
    pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer 
    modulo 10<sup>9</sup>+7.</p>

#### Problem Constraints
* <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
* <p>1 &lt;= A[i] &lt;= 2<sup>31</sup> - 1</p>
```text
1 <= N <= 10^5

1 <= A[i] <= 2^31 - 1
```
#### Input Format
```text
The first and only argument of input contains a single 
integer array A.
```
#### Output Format
```text
Return a single integer denoting the sum.
```
#### Example Input
```text
Input 1:
 A = [1, 3, 5]

Input 2:
 A = [2, 3]
```
#### Example Output
```text
Output 1:
 8

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
    f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) 
    + f(5, 1) + f(5, 3) + f(5, 5) 
    = 0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0 = 8

Explanation 2:
    f(2, 2) + f(2, 3) + f(3, 2) + f(3, 3) = 0 + 1 + 1 + 0 = 2
```
### Hints
* Hint 1

<p>Assume that all values in input have 
only 1 bit <em>i.e.</em> A<sub>i</sub> = 0 or 1.</p>

```text
How would you solve it now?

Can you combine this logic if we have multiple bits?
```
* Solution Approach

<p>Assume that all values in input have 
only 1 bit <em>i.e.</em> A<sub>i</sub> = 0 or 1.</p>

```text
Lets say A = count of elements which are 0
and B = count of elements which are 1

In this case, our answer is just 2 * A * B since each such 
pair contributes 1 to the answer.

Can you combine this logic if we have multiple bits?

Note that all bits are independent in counting since we 
count the number of bits that are different in each pair.
```

<p> So, we do the same process for all different bits. Since A<sub>i</sub> is an integer, we have to do this for all 31 different bits, so our solution is O(31*N).</p>

* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int cntBits(int[] A) {
        long ans = 0;
        int n = A.length, Mod = 1000 * 1000 * 1000 + 7;
        // traverse over all bits
        for (int i = 0; i < 31; i++) {
            // count number of elements with i-th bit set
            long cnt = 0;
            for (int j = 0; j < n; j++)
                if ((A[j] & (1 << i)) != 0) 
                    cnt++;
            // add to answer cnt * (n - cnt) * 2
            ans += (cnt * (n - cnt) * 2) % Mod;
            ans %= Mod;
        }
        return (int) ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    cntBits: function (A) {
        let ans = 0;
        // traverse over all bits
        for (let i = 0; i < 31; i++) {
            let cnt = 0;
            // count number of elements with i-th bit set
            A.forEach((ele) => (cnt += (ele >> i) & 1));
            // add to answer cnt * (A.length - cnt) * 2
            ans += cnt * (A.length - cnt) * 2;
            ans %= 1e9 + 7;
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
typedef long long LL;
#define MOD 1000000007
int Solution::cntBits(vector < int > & A) {
    int ans = 0, n = A.size();
    // traverse over all bits
    for (int i = 0; i < 31; i++) {
        // count number of elements with i-th bit set
        LL cnt = 0;
        for (int j = 0; j < n; j++)
            if ((A[j] & (1 << i))) 
                cnt++;
        // add to answer cnt * (n - cnt) * 2
        ans += (cnt * ((LL) n - cnt) * 2) % MOD;
        if (ans >= MOD) 
            ans -= MOD;
    }
    return ans;
}
```

