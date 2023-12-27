### Q1. Count of divisors
#### Problem Description
```text
Given an array of integers A, find and return the count of divisors of 
each element of the array.

NOTE: The order of the resultant array should be the same as the input 
array.
```
#### Problem Constraints
* <p>1 &lt;= length of the array &lt;= 100000 <br>
* 1 &lt;= A[i] &lt;= 10<sup>6</sup></p>
```text
1 <= length of the array <= 100000
1 <= A[i] <= 10^6
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format
```text
Return the count of divisors of each element of the array in the 
form of an array.
```
#### Example Input
```text
Input 1:
 A = [2, 3, 4, 5]

Input 2:
 A = [8, 9, 10]
```
#### Example Output
```text
Output 1:
 [2, 2, 3, 2]

Output 1:
 [4, 3, 4]
```
#### Example Explanation
```text
Explanation 1:

 The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 So the count will be [2, 2, 3, 2].


Explanation 2:

 The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 So the count will be [4, 3, 4].
```
### Hints
* Hint 1
```text
Think what information in the seive can be stored to determine the total 
factors of a no in (log n) time complexity.

How can you find the total factors by knowing all the prime factors of 
a no?
```
* Solution Approach
  * <div><p>Using seive, we can store the smallest prime factor for all the numbers upto the maximum no (here it is 10<sup>6</sup>).<br>
  * This above information helps in determining the prime factors for any no in O(log n) time-complexity for each query.</p>
  * <p>We take each no in the input array. Then prime factorise it to count the powers of each prime factors in a number.</p>
  * <p>        N = (p1<sup>n1</sup>) * (p2<sup>n2</sup>) * (p3<sup>n3</sup>).</p>
  * <p>        Here, N can be represented as p1 prime raised to the power n1 muliply p2 prime raised to n2 multiply p3 raised to n3.</p>
  * <p>        So, total factors of N  will be (n1 + 1) * (n2 + 1) * (n3 + 1).</p>
  * <p>For eg: 18 = (2<sup>1</sup>) * (3<sup>2</sup>).</p>
  * <p>So, total factors = 2*3 = 6.</p></div>

```text
Using seive, we can store the smallest prime factor for all the numbers upto the maximum no (here it is 10^6).
This above information helps in determining the prime factors for any no in O(log n) time-complexity for each query.

We take each no in the input array. Then prime factorise it to count the powers of each prime factors in a number.

N = (p1^n1) * (p2^n2) * (p3^n3).

Here, N can be represented as p1 prime raised to the power n1 muliply p2 prime raised to n2 multiply p3 raised to n3.

So, total factors of N will be (n1 + 1) * (n2 + 1) * (n3 + 1).

For eg: 18 = (2^1) * (3^2).

So, total factors = 2*3 = 6.
```
* Complete Solution
```java
public class Solution {
    
    // S[x] = the smallest prime factor of x
    int S[], SZ, NP = 1001001;
    
    void sieve() {
        int n = NP;
        S = new int[n];
        for(int i = 1; i < n; i++) 
            S[i] = i;
        for(int i = 2; i * i <= n; i++) {
            if( S[i] != i )
                continue;
            for(int j = i * i; j < n; j += i) {
                if(S[j] == j)
                    S[j] = i;
            }
        }
    }
    
    int countDivisors(int x) {
        // Using prime factorization to get the number of divisors for every integer
        int ans = 1;
        while(S[x] > 1) {
            int cnt = 1, u = S[x];
            while(S[x] == u) {
                cnt++;
                x /= u;
            }
            ans *= cnt;
        }
        return ans;    
    }
    
    public int[] solve(int[] a) {
        sieve();
        int n = a.length;
        int ans[] = new int[n];
        for(int i = 0; i < n; i++)
            ans[i] = countDivisors(a[i]);
        return ans;
    }
}
```

```javascript
function sieve(){
    let N = 1000005;
    let spf = new Array(N);     // spf[x] = smallest prime factor of x
    for(let i = 0; i < N; ++i) {
        spf[i] = i;
    }
    for(let i = 2; i * i < N; ++i) {
        if(spf[i] == i) {
            for(let j = i * i ; j < N; j += i) {
                if(spf[j] == j) 
                  spf[j] = i;
            }
        }
    }
    return spf;
}
module.exports = {
    solve: function (A) {
        let spf = sieve();
        // Using prime factorization to get the number of divisors for every integer
        let sol = [];
        A.forEach((ele)=> {
          let temp = ele;
          let ans = 1;
          while(temp != 1) {
              let cnt = 1;
              let pf = spf[temp];
              while(temp != 1 && temp % pf == 0) {
                  cnt += 1;
                  temp = temp / pf;
              }
              ans = ans * cnt;
          }
          sol.push(ans);
        });
        return sol;
    },
};
```

```cpp
int spf[1000005]; // spf[x] = smallest prime factor of x
void sieve(){
    for(int i = 1; i <= 1000000; ++i) {
        spf[i] = i;
    }
    for(int i = 2; i * i <= 1000000; ++i) {
        if(spf[i] == i) {
            for(int j = i * i ; j <= 1000000; j += i) {
                if(spf[j] == j) 
                   spf[j] = i;
            }
        }
    }
}
vector<int> Solution::solve(vector<int> &A) {
    sieve();
    // Using prime factorization to get the number of divisors for every integer
    vector<int> sol;
    for(int i = 0; i < A.size(); ++i) {
        int temp = A[i];
        int ans = 1;
        while(temp != 1) {
            int cnt = 1;
            int d = spf[temp];
            while(temp != 1 and temp % d == 0) {
                cnt++;
                temp = temp / d;
            }
            ans = ans * cnt;
        }
        sol.push_back(ans);
    }
    return sol;
}
```

