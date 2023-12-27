### Q4. Ways to form Max Heap 2
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p><strong>Max heap</strong> is a special kind of <strong>complete binary tree</strong> 
    in which, for every node, the value present in that node is greater than the value 
    present in its children nodes.</p>
    <p>Given an array <strong>A</strong> of size <strong>N</strong> consisting of 
    <strong>N - 1</strong> distinct elements. In other words, there is exactly 
    <strong>one</strong> element that is repeated.<br> It is given that the element 
    that would repeat would be either the <strong>maximum</strong> element or the 
    minimum element.</p>
    <p>Find the number of structurally different <strong>Max heaps</strong> possible 
    using all the <strong>N</strong> elements of the array i.e., Max heap of size 
    <strong>N</strong>.</p>
    <p>As the final answer can be very large return your answer 
    <strong>modulo 10<sup>9</sup> + 7</strong>.</p>
</div>

```text
Max heap is a special kind of complete binary tree in which, for every node, the value 
present in that node is greater than the value present in its children nodes.

Given an array A of size N consisting of N - 1 distinct elements. In other words, 
there is exactly one element that is repeated.
It is given that the element that would repeat would be either the maximum element or 
the minimum element.

Find the number of structurally different Max heaps possible using all the N elements of 
the array i.e., Max heap of size N.

As the final answer can be very large return your answer modulo 10^9 + 7.
```
#### Problem Constraints
```text
1 <= N <= 1000
```
#### Input Format
```text
The first and only argument is an integer array A.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Return an integer denoting the number of structurally different Max heaps 
    possible <strong>modulo 10<sup>9</sup> + 7</strong>.</p>
</div>

```text
Return an integer denoting the number of structurally different Max heaps 
possible modulo 10^9 + 7.
```
#### Example Input
```text
Input 1:
 A = [1, 5, 5]

Input 2:
 A = [2, 2, 7]
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
    The possible max heaps using the given elements are:- First: 5 on the root. 1 as 
    the left child of root and 5 as the right child of the root.   
                5
              /   \
            1       5
    Second: 5 on the root. 5 as the left child of root and 1 as the right child of 
    the root.
                5
              /   \
            5       1            

Explanation 2:
     There is only one possible max heaps: 7 on the root. 2 as the left child of 
     root and 2 as the right child of the root.   
                7
              /   \
            2       2
```
### Hints
* Hint 1
```text
First, what would be the number of max heaps if all the elements of the array of distinct?

Next, consider what would be the case when both repeating elements are maximum and 
what would be the case when both would be minimum.
```
* Solution Approach
```text
If both repeating elements are maximum, then one maximum element has to be fixed at 
the root, and the other maximum element can go either in the left subtree or the 
right subtree, so the number of max heaps is equal to when there were no repeating 
elements.

Now, if minimum elements are repeated, then there would be two cases:-
    
    1) Both repeating elements go in the same subtree
    
    2) Both repeating elements go in the different subtrees.

If both repeating elements go in a different subtree than now, the problem is back to 
when there were no repeating elements but with smaller problem size.
If both repeating elements go in the same subtree, then for one subtree(left or right), 
it would be the case with no repeating elements, while for the other subtree, call the 
same function recursively.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static int maxn = 1005;
    static long[] dp = new long[maxn];
    static long[] dp1 = new long[maxn];
    static long[][] nck = new long[maxn][maxn];
    static int[] log_2 = new int[maxn];
    static long MOD = 1000000007;
    
    public int solve(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n; i++)
            dp[i] = (long) - 1;

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                nck[i][j] = (long) - 1;

        int currlog_2Answer = -1;
        int currPower2 = 1;
        for (int i = 1; i <= n; i++) {
            if (currPower2 == i) {
                currlog_2Answer++;
                currPower2 *= 2;
            }
            log_2[i] = currlog_2Answer;
        }
        int max = -1;
        int min = 10000000;
        int maxcount = 0;
        int mincount = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
                mincount = 1;
            } else if (arr[i] == min) {
                mincount++;
            }
            if (arr[i] > max) {
                max = arr[i];
                maxcount = 1;
            } else if (arr[i] == max) {
                maxcount++;
            }
        }
        if (maxcount == 2)
            return (int) getNumberOfMaxHeaps(n);
        else
            return (int) getNumberOfMaxHeaps2(n);
    }
    
    public static long choose(int n, int k) {
        if (k > n)
            return 0;
        if (n <= 1)
            return 1;
        if (k == 0)
            return 1;

        if (nck[n][k] != -1)
            return nck[n][k];
        long answer = choose(n - 1, k - 1) + choose(n - 1, k);
        answer %= MOD;
        nck[n][k] = answer;
        return answer;
    }
    
    public static int getL(int n) {
        if (n == 1)
            return 0;

        int h = log_2[n];
        int p = n - ((1 << (h)) - 1);
        int m = (1 << h);
        if (p >= (m / 2))
            return (1 << (h)) - 1;
        else
            return (1 << (h)) - 1 - ((m / 2) - p);
    }
    
    public static long getNumberOfMaxHeaps(int n) {
        if (n <= 1)
            return 1;

        if (dp[n] != -1)
            return dp[n];

        int L = getL(n);
        long ans = (choose(n - 1, L) * getNumberOfMaxHeaps(L)) % MOD * (getNumberOfMaxHeaps(n - 1 - L));
        ans %= MOD;
        dp[n] = ans;
        return ans;
    }
    
    public static long getNumberOfMaxHeaps2(int n) {
        if (n < 2)
            return (long) 0;
        if (n < 4)
            return (long) 1;
        if (n == 4)
            return (long) 2;
        if (n == 5)
            return (long) 4;
        if (dp1[n] != 0)
            return dp1[n];
        int l = getL(n);
        int r = n - l - 1;
        long ans = (((choose(n - 3, l - 2) * getNumberOfMaxHeaps2(l)) % MOD) * getNumberOfMaxHeaps(r)) % MOD;
        ans = (ans + (((choose(n - 3, r - 2) * getNumberOfMaxHeaps(l)) % MOD) * getNumberOfMaxHeaps2(r)) % MOD) % MOD;
        ans = (ans + (((choose(n - 3, l - 1) * getNumberOfMaxHeaps(l)) % MOD) * getNumberOfMaxHeaps(r)) % MOD) % MOD;
        dp1[n] = ans;
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
const maxn = 1005;
let dp = new Array(maxn).fill(0);
let dp1 = new Array(maxn).fill(0);
let nck = new Array(maxn).fill(0).map(() => new Array(maxn).fill(0));
let log_2 = new Array(maxn);
let MOD = 1000000007;

function mult(a, b) {
  let val = a * b;
  if (val <= Number.MAX_SAFE_INTEGER && val >= Number.MIN_SAFE_INTEGER)
    return val % MOD;
  return Number((BigInt(a) * BigInt(b)) % BigInt(MOD));
}

function choose(n, k) {
  if (k > n) return 0;
  if (n <= 1) return 1;
  if (k == 0) return 1;

  if (nck[n][k] != -1) return nck[n][k];
  let answer = choose(n - 1, k - 1) + choose(n - 1, k);
  answer %= MOD;
  nck[n][k] = answer;
  return answer;
}

function getL(n) {
  if (n == 1) return 0;

  let h = log_2[n];
  let p = n - ((1 << h) - 1);
  let m = 1 << h;
  if (p >= Math.floor(m / 2)) return (1 << h) - 1;
  else return (1 << h) - 1 - (Math.floor(m / 2) - p);
}

function getNumberOfMaxHeaps(n) {
  if (n <= 1) return 1;

  if (dp[n] != -1) return dp[n];

  let L = getL(n);
  let ans = mult(
    mult(choose(n - 1, L), getNumberOfMaxHeaps(L)),
    getNumberOfMaxHeaps(n - 1 - L)
  );
  ans %= MOD;
  dp[n] = ans;
  return ans;
}
function getNumberOfMaxHeaps2(n) {
  if (n < 2) return 0;
  if (n < 4) return 1;
  if (n == 4) return 2;
  if (n == 5) return 4;
  if (dp1[n] != 0) return dp1[n];
  let l = getL(n);
  let r = n - l - 1;
  let ans = mult(
    mult(choose(n - 3, l - 2), getNumberOfMaxHeaps2(l)),
    getNumberOfMaxHeaps(r)
  );
  ans =
    (ans +
      mult(
        mult(choose(n - 3, r - 2), getNumberOfMaxHeaps(l)),
        getNumberOfMaxHeaps2(r)
      )) %
    MOD;
  ans =
    (ans +
      mult(
        mult(choose(n - 3, l - 1), getNumberOfMaxHeaps(l)),
        getNumberOfMaxHeaps(r)
      )) %
    MOD;
  dp1[n] = ans;
  return ans;
}

module.exports = {
  solve: function (arr) {
    let n = arr.length;
    for (let i = 0; i <= n; i++) dp[i] = -1;

    for (let i = 0; i <= n; i++) for (let j = 0; j <= n; j++) nck[i][j] = -1;

    let currlog_2Answer = -1;
    let currPower2 = 1;
    for (let i = 1; i <= n; i++) {
      if (currPower2 == i) {
        currlog_2Answer++;
        currPower2 *= 2;
      }
      log_2[i] = currlog_2Answer;
    }
    let max = -1;
    let min = 10000000;
    let maxcount = 0;
    let mincount = 0;
    for (let i = 0; i < n; i++) {
      if (arr[i] < min) {
        min = arr[i];
        mincount = 1;
      } else if (arr[i] == min) {
        mincount++;
      }
      if (arr[i] > max) {
        max = arr[i];
        maxcount = 1;
      } else if (arr[i] == max) {
        maxcount++;
      }
    }
    if (maxcount == 2) return getNumberOfMaxHeaps(n);
    else return getNumberOfMaxHeaps2(n);
  },
};
```
* * Solution in C++
```cpp
#define MAXN 1005

long long int dp[MAXN]; /* dp[i] = number of max heaps for i distinct integers */
long long int dp1[MAXN]; /*dp1[i]=number of max heaps for i-1 distinct integers */
long long int nck[MAXN][MAXN]; /* nck[i][j] = i choose j if i>=j else 0 */
int log_2[MAXN]; /* log_2[i] = int(log_2 base 2 of i) */
long long int MOD = 1000000007;

const int M = 1001;
long long int f[M], inv[M];

long long int expo(long long int base, long long int exponent, long long int mod) {
    long long int ans = 1;
    while (exponent != 0) {
        if (exponent & 1) ans = (1LL * ans * base) % mod;
        base = (1LL * base * base) % mod;
        exponent >>= 1;
    }
    return ans % mod;
}
void compute() {
    if (f[0])
        return;
    f[0] = 1;
    for (int i = 1; i < M; i++) {
        f[i] = (1LL * i * f[i - 1]) % MOD;
    }
    inv[M - 1] = expo(f[M - 1], MOD - 2, MOD);
    for (int i = M - 2; i >= 0; i--) {
        inv[i] = (1LL * (i + 1) * inv[i + 1]) % MOD;
    }
}
long long int C(int n, int r) {
    return (1LL * ((1LL * f[n] * inv[r]) % MOD) * inv[n - r]) % MOD;
}

long long int choose(int n, int k) {
    if (k > n)
        return 0;
    if (n <= 1)
        return 1;
    if (k == 0)
        return 1;

    if (nck[n][k] != -1)
        return nck[n][k];
    nck[n][k] = C(n, k);
    return nck[n][k];
}

int getL(int n) {
    if (n == 1)
        return 0;

    int h = log_2[n];
    int p = n - ((1 << (h)) - 1);
    int m = (1 << h);
    if (p >= (m / 2))
        return (1 << (h)) - 1;
    else
        return (1 << (h)) - 1 - ((m / 2) - p);
}

long long int getNumberOfMaxHeaps(int n) {
    if (n <= 1)
        return 1;

    if (dp[n] != -1)
        return dp[n];

    int L = getL(n);
    long long int ans = (choose(n - 1, L) * getNumberOfMaxHeaps(L)) % MOD * (getNumberOfMaxHeaps(n - 1 - L));
    ans %= MOD;
    dp[n] = ans;
    return ans;
}
long long int getNumberOfMaxHeaps2(int n) {
    if (n < 2)
        return (long long int) 0;
    if (n < 4)
        return (long long int) 1;
    if (n == 4)
        return (long long int) 2;
    if (n == 5)
        return (long long int) 4;
    if (dp1[n] != 0)
        return dp1[n];
    int l = getL(n);
    int r = n - l - 1;
    long long int ans = (((choose(n - 3, l - 2) * getNumberOfMaxHeaps2(l)) % MOD) * getNumberOfMaxHeaps(r)) % MOD;
    ans = (ans + (((choose(n - 3, r - 2) * getNumberOfMaxHeaps(l)) % MOD) * getNumberOfMaxHeaps2(r)) % MOD) % MOD;
    ans = (ans + (((choose(n - 3, l - 1) * getNumberOfMaxHeaps(l)) % MOD) * getNumberOfMaxHeaps(r)) % MOD) % MOD;
    dp1[n] = ans;
    return ans;
}

int Solution::solve(vector < int > & arr) {
    compute();
    int n = arr.size();
    for (int i = 0; i <= n; i++) {
        dp[i] = -1;
        dp1[i] = 0;
    }
    for (int i = 0; i <= n; i++)
        for (int j = 0; j <= n; j++)
            nck[i][j] = -1;

    int currlog_2Answer = -1;
    int currPower2 = 1;
    for (int i = 1; i <= n; i++) {
        if (currPower2 == i) {
            currlog_2Answer++;
            currPower2 *= 2;
        }
        log_2[i] = currlog_2Answer;
    }
    int max = -1;
    int min = 10000000;
    int maxcount = 0;
    int mincount = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i] < min) {
            min = arr[i];
            mincount = 1;
        } else if (arr[i] == min) {
            mincount++;
        }
        if (arr[i] > max) {
            max = arr[i];
            maxcount = 1;
        } else if (arr[i] == max) {
            maxcount++;
        }
    }
    if (maxcount == 2)
        return (int) getNumberOfMaxHeaps(n);
    else
        return (int) getNumberOfMaxHeaps2(n);
}
```

