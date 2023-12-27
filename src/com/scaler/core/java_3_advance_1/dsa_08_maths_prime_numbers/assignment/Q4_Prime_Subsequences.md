### Q4. Prime Subsequences
#### Problem Description
```text
Given an array A having N positive numbers. You have to find the number of Prime 
subsequences of A.

A Prime subsequence is one that has only prime numbers, for example [2, 3], [5] are 
the Prime subsequences where [2, 4] and [1, 2, 3, 4] are not.
```
#### Problem Constraints
```text
1 <= N <= 1e3
1 <= A[i] <= 1e6
```
#### Input Format
```text
The first argument given is an Array A, having N integers.
```
#### Output Format
```text
Return an integer X, i.e number of Prime subsequences. 
As X can be very large print X % (1000000007), here % is modulus operator.
```
#### Example Input
```text
Input:
    A = [1, 2, 3]
```
#### Example Output
```text
Output:
     3
```
#### Example Explanation
```text
Explanation:
    no. Subsequences      Prime subsequences
    1.  [1]                     No
    2.  [1, 2]                  No
    3.  [1, 3]                  No
    4.  [1, 2, 3]               No
    5.  [2]                     Yes
    6.  [2, 3]                  Yes
    7.  [3]                     Yes
    8.  []                      No

    here we have 3 subsequences(5, 6, 7) those have only prime number(s)
```
### Hints
* Hint 1
```text
Is there really a need of generating all subsequences?
Can you find the answer if you know the number of prime integers in an array?
```
* Solution Approach
```text
Let M be the number of prime integers in an array, then the number of Prime 
Subsequences will be ((2 ^ M) - 1).

Can you prove this?
```
* Complete Solution
* * Solution in Java
```java
/** Not available **/
```
* * Solution in Javascript
```javascript
/** Not avaialble **/
```
* * Solution in C++
```cpp
#define ll long long int

const int mn = 1e6 + 5;
const ll mod = 1e9+7;

bool prime[mn];

ll fpow(ll a, ll g) {
    ll ag = 1;
    while(g) {
        if(g & 1) ag = (ag * a) % mod;
        a = (a * a) % mod;
        g >>= 1;
    }
    return ag;
}

void sieve() {
    if(prime[0]) return;
    prime[0] = prime[1] = 1;
    int n = sqrt(mn);
    for(int i = 2; i < n; i += 1) {
        if(!prime[i]) {
            for(int j = i*i; j < mn; j += i) {
                prime[j] = 1;
            }
        }
    }
}

int Solution::solve(vector<int> &A) {
    sieve();
    ll a = 0;
    for(auto &i : A) {
        a += !prime[i];
    }
    return (fpow(2ll, a) - 1 + mod) % mod;
}
```

