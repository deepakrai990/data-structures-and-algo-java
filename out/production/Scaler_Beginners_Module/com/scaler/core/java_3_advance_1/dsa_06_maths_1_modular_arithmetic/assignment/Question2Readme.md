### Q2. Pair Sum divisible by M
#### Problem Description
```text
Given an array of integers A and an integer B, find and 
return the number of pairs in A whose sum 
is divisible by B.

Since the answer may be large, return the answer modulo (10^9 + 7).
```

<p>Since the answer may be large, return the answer 
modulo (10<sup>9</sup> + 7).</p>

#### Problem Constraints
* <p>1 &lt;= length of the array &lt;= 100000</p>
* <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
* <p>1 &lt;= B &lt;= 10<sup>6</sup></p>
```text
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^6
```
#### Input Format
```text
The first argument given is the integer array A.
The second argument given is the integer B.
```
#### Output Format
* <p>Return the total number of pairs for which the sum is divisible
    by B modulo (10<sup>9</sup> + 7).</p>
```text
Return the total number of pairs for which the sum is 
divisible by B modulo (10^9 + 7).
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 2

Input 2:
 A = [5, 17, 100, 11]
 B = 28
```
#### Example Output
```text
Output 1:
 4

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5). 
    So total 4 pairs.
```
### Hints
* Hint 1
```text
A trivial way of solving is to count the number of pairs whose 
sum is divisible by B by using two loops over the array.

Can you think of optimizing it by using the fact that the value 
is up to 10^6 and using the modulo operator, we can reduce all 
the elements in the range 0 to B-1.
```

<p>Can you think of optimizing it by using the fact that the value 
is up to 10<sup>6</sup> and using the modulo operator, we can 
reduce all the elements in the range 0 to B-1.</p>

* Solution Approach

<p>Let’s optimize using the fact that the value is up 
to 10<sup>6</sup>, and using the modulo operator, we can 
reduce all the elements in the range 0 to B-1.</p>

```text
Let’s optimize using the fact that the value is up to 10^6, 
and using the modulo operator, we can reduce all the 
elements in the range 0 to B-1.

We make an auxiliary array cnt, the index i denotes the 
number of elements which gives i as the remainder 
when divided by B.

Now, we know that the sum of the pair modulo B should 
be equal to 0.

So we will count the pairs that give the sum of the pair 
modulo B is 0.

We can do this by adding cnt[i]*cnt[j] in the answer 
such that (i + j) % B = 0.
Note: Keep in mind the base case when i==0 and j==0 and i==j.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] a, int k) {
        int n = a.length;
        long mod = (long)(1e9 + 7);
        long cnt[] = new long[k];
        // cnt[i] stores the count of elements such that their modulo k equals i
        for(int x : a)    cnt[x % k]++;
        long ans = cnt[0] * (cnt[0] - 1) / 2;
        for(int i = 1, j = k - 1; i <= j; i++, j--) {
            if(i == j)    
                ans = (ans + cnt[i] * (cnt[i] - 1) / 2) % mod;
            else    
                ans = (ans + cnt[i] * cnt[j]) % mod;
        }
        return (int)ans;
    }
}
```
* * Solution in Javascript
```javascript
const MOD = 1e9 + 7;
module.exports = {
  solve: function (A, B) {
    A = A.map((ele) => (ele = ((ele % B) + B) % B));
    // mp[i] stores the count of elements such that their modulo B equals i
    let mp = new Array(B + 1).fill(0);
    let ans = 0;
    A.forEach((ele) => {
        let need = (B - ele) % B;
        ans += mp[need];
        ans %= MOD;
        mp[ele]++;
    });
    return ans;
  },
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A, int B) {
    int n = A.size();
    long long  mod = 1e9 +7;
    long long cnt[B];
    memset(cnt, 0, sizeof(cnt));
    // cnt[i] stores the count of elements such that their modulo B equals i
    for(int i = 0; i < n; i++) {
        cnt[A[i] % B]++;
    }
    long long ans = (cnt[0] * (cnt[0] - 1)) / 2;
    ans %= mod;
    int i = 1, j = B - 1;
    while(i <= j) {
        if(i == j) {
            ans += (cnt[i] * (cnt[j] - 1)) / 2;
            ans %= mod;
        } else {
            ans += cnt[i] * cnt[j];
            ans %= mod;
        }
        i++;
        j--;
    }
    return ans;
}
```

