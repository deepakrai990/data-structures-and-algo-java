### Q1. Factorial Array
#### Problem Description
```text
Groot has an array A of size N. Boring, right? Groot thought 
so too, so he decided to construct another array B of the 
same size and defined elements of B as:

B[i] = factorial of A[i] for every i such that 1<= i <= N.

    * factorial of a number X denotes (1 x 2 x 3 x 4......(X-1) x (X)).

Now Groot is interested in the total number of non-empty 
subsequences of array B such that every element in the 
subsequence has the same non-empty set of prime factors.
```

<p>Since the number can be huge, return it 
<strong>modulo 10<sup>9</sup> + 7</strong>.</p>

```text
NOTE: A set is a data structure having only distinct 
      elements. E.g : the set of prime factors of Y=12 
      will be {2,3} and not {2,2,3}
```
#### Problem Constraints
* <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
* <p>1 &lt;= A[i] &lt;= 10<sup>6</sup></p>
* <p>Your code will run against a maximum of 5 test cases.</p>
```text
1 <= N <= 10^5
1 <= A[i] <= 10^6
Your code will run against a maximum of 5 test cases.
```
#### Input Format
```text
Only argument is an integer array A of size N.  
```
#### Output Format

<p>Return an integer denoting the total number of non-empty 
subsequences of array B such that every element in the 
subsequence has the same set of prime 
factors modulo 10<sup>9</sup>+7.</p>

```text
Return an integer denoting the total number of non-empty 
subsequences of array B such that every element in the 
subsequence has the same set of prime factors modulo 10^9+7.
```
#### Example Input
```text
Input 1:
 A = [2, 3, 2, 3]

Input 2:
 A = [2, 3, 4]
```
#### Example Output
```text
Output 1:
 6

Output 2:
 4
```
#### Example Explanation
```text
Explanation 1:
    Array B will be : [2, 6, 2, 6]
    The total possible subsequences are 6 : 
    [2], [2], [2, 2], [6], [6], [6, 6].

Explanation 2:
    Array B will be : [2, 6, 24]
    The total possible subsequences are 4 : 
    [2], [6], [24], [6, 24].
```
### Hints
* Hint 1
```text
We can’t store the factorial of each value since that 
can cause overflow.

So think of sorting the array and finding all the subsequences.
```
* Solution Approach
```text
We can say that the factorial of any number between two 
consecutive prime numbers, say (x, y) will have an equal 
set of prime numbers as that of a set of prime numbers in x.

Since the factorial of x will contain all prime numbers 
less than equal to x.

We will store all the prime numbers less than equal to the 
highest value in the given array in sorted order in an 
auxiliary array, say v.

Iterate over all prime numbers in array v, and for 
each v[i], count the number of values in the array 
which are less than v[i].

Let cnt denotes that value of each prime number v[i].

All the subsequences of this will be pow(2, cnt) - 1.

Sum all the values and return the answer.

Note that we are talking of a non-empty set. So the 1st 
set will be discarded.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    private int[] prime = new int[1000001];
    private int mod = 1000 * 1000 * 1000 + 7;

    public void pre(){
        // sieve of eratosthenes
        int maxN = 1000001;
        prime[1] = 1;
        for(int i = 2; i < maxN; i++){
            if(prime[i] == 0){
                for(int j = 2 * i; j < maxN; j += i) {
                    prime[j] = 1;
                }
            }
        }
    }
    
    public int power(long x, long y){
        // modular exponentiation
        long res = 1;
        while(y != 0){
            if(y % 2 == 1){
                res = (x * res) % mod;
            }
            y /= 2;
            x = (x * x) % mod;
        }
        return (int)res;
    }    
    
    public int solve(int[] A) {
        pre();
        int n = A.length;
        Arrays.sort(A);
        int v[] = new int[100000], itr = 0;
        // stores all the prime numbers
        for(int i = 2; i <= A[n - 1]; i++) {
            if(prime[i] == 0){
                v[itr] = i;
                itr++;
            }
        }
        
        long ans = 0;
        int j = 0, i = 0;
        while(i < n && j < itr) {
            // find the count of elements with same set of non-empty prime factors
            int cnt = 0;
            if(A[i] == 1){
                i++;
                continue;
            }
            while(i < n && A[i] < v[j]) {
                i++;
                cnt++;
            }
            long temp = power(2, cnt) - 1;
            ans = (ans + temp) % mod;
            j++;
        }
        if(i < n){
            long temp = power(2, n - i) -1;
            ans = (ans + temp) % mod;
        }
        return (int)ans;
    }
}
```
* * Solution in Javascript
```javascript
const maxn = 1e6 + 10;
let prime = new Array(maxn).fill(1);

function sieve() {
    // sieve of eratosthenes
    prime[0] = prime[1] = 0;
    for (let i = 2; i < maxn; i++) {
        if (!prime[i]) 
            continue;
        for (let j = i * i; j < maxn; j += i) 
            prime[j] = 0;
    }
}

function pw(a, b, m) {
    // modular exponentiation
    let res = 1;
    while (b > 0) {
        if (b & 1) 
            res = (res * a) % m;
        a = (a * a) % m;
        b >>= 1;
    }
  return res;
}

module.exports = {
    solve: function (A) {
        const MOD = 1e9 + 7;
        A.sort((a, b) => a - b);
        sieve();
        for (let i = 1; i < prime.length; i++) {
            prime[i] += prime[i - 1];
        }
        // stores the count of the prime factors
        A = A.map((ele) => prime[ele]);
        let mp = new Map();
        // find the count of elements with same set of non-empty prime factors
        A.forEach((ele) => {
            mp.set(ele, 1 + (mp.has(ele) ? mp.get(ele) : 0));
        });
        let ans = 0;
        mp.delete(0);
        for (let ele of mp.values()) {
            ans += (+pw(2, ele, MOD) - 1 + MOD) % MOD;
            ans %= MOD;
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
const int maxN = 1e6 + 1;
int prime[maxN];
int flag = 0;
const int mod = 1e9 + 7;

void pre(){
    // sieve of eratosthenes
    flag = 1;
    prime[1] = 1;
    for(int i = 2; i < maxN; i++) {
        if(prime[i] == 0) {
            for(int j = 2 * i; j < maxN; j += i) {
                prime[j] = 1;
            }
        }
    }
}

int power(long long x, long long y){
    // modular exponentiation
    long long res = 1;
    while(y) {
        if(y % 2) {
            res = (x * res) % mod;
        }
        y /= 2;
        x = (x * x) % mod;
    }
    return res;
}

int Solution::solve(vector<int> &A) {
    if(flag == 0)
        pre();
    int n = A.size();
    sort(A.begin(), A.end());
    vector<int> v;
    // stores all the prime numbers
    for(int i = 2; i <= A[n - 1]; i++) {
        if(prime[i] == 0){
            v.push_back(i);
        }
    }
    long long ans = 0;
    int j = 0, i = 0;
    while(i < n && j < v.size()) {
        // find the count of elements with same set of non-empty prime factors
        int cnt = 0;
        if(A[i] == 1){
            i++;
            continue;
        }
        while(i < n && A[i] < v[j]) {
            i++;
            cnt++;
        }
        long long temp = power(2, cnt) - 1;
        ans = (ans + temp) % mod;
        j++;
    }
    if(i < n) {
        long long temp = power(2, n - i) -1;
        ans = (ans + temp) % mod;
    }
    return ans;
}
```

