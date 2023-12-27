### Q2. Prime Sum
#### Problem Description
```text
Given an even number A ( greater than 2 ), return two prime 
numbers whose sum will be equal to the given number.

If there is more than one solution possible, return 
the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c,d] is another 
solution with c <= d, then 
[a, b] < [c, d], If a < c OR a==c AND b < d. 

NOTE: A solution will always exist. Read Goldbach's conjecture.
```
#### Problem Constraints
* <p>4 &lt;= A &lt;= 2*10<sup>7</sup></p>
```text
4 <= A <= 2*10^7
```
#### Input Format
```text
First and only argument of input is an even number A.
```
#### Output Format
```text
Return a integer array of size 2 containing primes whose 
sum will be equal to given number.
```
#### Example Input
```text
Input 1:
 4
```
#### Example Output
```text
Output 1:
 [2, 2]
```
#### Example Explanation
```text
There is only 1 solution for A = 4.
```
### Hints
* Hint 1
```text
This problem’s solution is straightforward.
Generate prime numbers less than N, and hash them in a list.
Then iterate on the whole list, and for every prime P, 
check if N-P is also prime. If you find such a pair, 
you are done :)

In other words

generate prime numbers, then put them into Hash-Table 
iterate whole prime numbers list using i:
    if  i is prime and N - i is prime, check using Hash-Table:
        update global solution
End Loop

Return global solution 

Now the job reduces to generating all the prime numbers efficiently.
```
* Solution Approach
```text
Read hint 1 if you have not already.

Now, coming to the problem of generating prime numbers 
quickly, we already have a problem SIEVE where we did it.

However, re-iterating, there are multiple ways of 
doing it. Probably the easiest way is Sieve of Eratosthenes.

Look at the following video to get a detailed idea 
about the approach :
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] sieve(int N){
        // Generate isPrime List less equal than N
        int[] isPrime = new int[N + 1];
        isPrime[0] = 0;
        isPrime[1] = 0;
        for(int i = 2; i <= N; i++){
            isPrime[i] = 1;
        }
        // Sieve of Erastothenes
        for(int i = 2; i <= N; i++) {
            if (isPrime[i] == 0)
                continue;
            if (i > N / i) 
                break;
            for (int j = i * i; j <= N; j += i) 
                isPrime[j] = 0;
        }
        return isPrime;
    }
    public int[] primesum(int A) {
        int[] isPrime = sieve(A);
        int[] ans = new int[2];
        for(int i = 2; i <= A; ++i) {
            if(isPrime[i] == 1 && isPrime[A - i] == 1) {
                ans[0] = i;
                ans[1] = A - i;
                return ans;
            }
        } 
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
const maxn = 2e7 + 10;
let done = false;
let prime = new Array(maxn).fill(1);
module.exports = {
    primesum: function (A) {
        if (!done) {
            for (let i = 2; i < maxn; i++) {
                if (!prime[i]) continue;
                for (let j = i * i; j < maxn; j += i) {
                    prime[j] = 0;
                }
            }
            done = true;
        }
        for (let i = 2; i <= A; i++) {
            if (prime[i] && prime[A - i]) {
                return [i, A - i];
            }
        }
    },
};
```
* * Solution in C++
```cpp
vector<bool> sieve(int N){
    // Generate isPrime List less equal than N
    vector<bool> isPrime(N + 1, true);
    isPrime[0] = false;
    isPrime[1] = false;
    
    // Sieve of Erastothenes
    for(int i = 2; i <= N; i++) {
        if (!isPrime[i]) continue;
        if (i > N / i) break;
        for (int j = i * i; j <= N; j += i) isPrime[j] = false;
    }
    return isPrime;
}
vector<int> Solution::primesum(int A) {
    vector<bool> isPrime = sieve(A);
    for(int i = 2; i <= A; ++i) {
        if(isPrime[i] && isPrime[A - i]) {
            vector<int> ans;
            ans.push_back(i);
            ans.push_back(A - i);
            return ans;
        }
    } 
    vector<int> ans; 
    return ans;
}
```

