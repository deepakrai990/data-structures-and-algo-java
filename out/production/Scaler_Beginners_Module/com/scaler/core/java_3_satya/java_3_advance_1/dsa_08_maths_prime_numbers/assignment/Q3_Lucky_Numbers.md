### Q3. Lucky Numbers
#### Problem Description
```text
A lucky number is a number that has exactly 2 distinct 
prime divisors.

You are given a number A, and you need to determine the 
count of lucky numbers between the range 1 to A (both inclusive).
```
#### Problem Constraints
```text
1 <= A <= 50000
```
#### Input Format
```text
The first and only argument is an integer A.
```
#### Output Format
```text
Return an integer i.e the count of lucky numbers 
between 1 and A, both inclusive.
```
#### Example Input
```text
Input 1:
 A = 8

Input 2:
 A = 12
```
#### Example Output
```text
Output 1:
 1

Output 2:
 3
```
#### Example Explanation
```text
Explanation 1:
    Between [1, 8] there is only 1 lucky number i.e 6.
    6 has 2 distinct prime factors i.e 2 and 3.

Explanation 2:
    Between [1, 12] there are 3 lucky number: 6, 10 and 12.
```
### Hints
* Hint 1
```text
This problem is very trivial and can be solved by simply 
calculating the number of factors for every number.
```
* Solution Approach
```text
Firstly, create an array, let’s say isPrime where isPrime[i] 
denotes true or false if number i is prime or not.

Now, for every number in the range [1, A], calculate the 
number of prime divisors, and if the count of distinct 
prime factors for a number is 2, increment the answer.

This can be easily done in O(N * sqrt(N)).

The solution can further be optimised to run 
in O(N * log(N)). The idea is to use a sieve and in place of 
marking a number of non-prime in the array, while using 
sieve, just add 1 to it for each prime you iterate. In the 
end, you will have the number of prime factors of each
number. Then the rest is a cakewalk. There are other kinds 
of sieves as well that you should check out. These are quite 
fast in terms of processing.

Link to a blog of sieves:- https://codeforces.com/blog/entry/22229
```
* Complete Solution
* * Solution in Java

```java
public class Solution {
    private boolean[] isPrime = new boolean[50001];

    public int solve(int A) {
        sieve();
        int[] cnt = new int[50001];
        for (int i = 0; i < 50001; i++)
            cnt[i] = 0;
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j * j <= i; j++) {
                // Check to increment count of distinct primes
                if (i % j == 0) {
                    if (isprime[j]) {
                        cnt[i]++;
                    }
                    if ((i / j) != j && isprime[i / j]) {
                        cnt[i]++;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= A; i++) {
            // Increment count for every lucky num
            if (cnt[i] == 2) {
                ans++;
            }
        }
        return ans;
    }

    public void sieve() {
        //Sieve of Eratosthenes
        for (int i = 0; i < 50001; i++)
            isprime[i] = true;
        isprime[1] = false;
        for (long i = 2; i <= 50000; i++) {
            if (isprime[(int) i]) {
                for (long j = i * i; j <= 50000; j += i) {
                    isprime[(int) j] = false;
                }
            }
        }
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A) {
        let isprime = new Array(A + 1).fill(1);
        isprime[1] = 0;
        // Sieve of Eratosthenes
        for (let i = 2; i <= A; i++) {
            if (isprime[i] == 1) {
                for (let j = i * i; j <= A; j += i) {
                    isprime[j] = 0;
                }
            }
        }
        
        let cnt = new Array(A + 1).fill(0);
        for (let i = 1 ; i <= A ; i++){
            let j = 1;
            while(j * j <= i){
                // Check to increment count of distinct primes
                if(i % j == 0){
                    if(isprime[j] == 1){
                        cnt[i] += 1
                    }
                    if((i / j) != j && isprime[i / j] == 1){
                        cnt[i] += 1
                    }
                }
                j += 1        
            }
        }
        
        let ans = 0;
        for (let i = 1 ; i <= A ; i++){
            // Increment count for every lucky num
            if(cnt[i] == 2){
                ans += 1
            }
        }
        return ans;
    },
};
```
* * Solution in C++
```cpp
bool isprime[50001];

void sieve() {
    // Sieve of Eratosthenes
    memset(isprime, true, sizeof(isprime));
    isprime[1] = false;
    for (long long i = 2; i <= 50000; i++) {
        if (isprime[i]) {
            for (long long j = i * i; j <= 50000; j += i) {
                isprime[j] = false;
            }
        }
    }
}

int Solution::solve(int A) {
    sieve();
    int cnt[50001];
    memset(cnt, 0, sizeof(cnt));
    for (int i = 1; i <= A; i++) {
        for (int j = 1; j * j <= i; j++) {
            // Check to increment count of distinct primes
            if (i % j == 0) {
                if (isprime[j]) {
                    cnt[i]++;
                }
                if ((i / j) != j && isprime[i / j]) {
                    cnt[i]++;
                }
            }
        }
    }
    int ans = 0;
    for (int i = 1; i <= A; i++) {
        // Increment count for every lucky num
        if (cnt[i] == 2) {
            ans++;
        }
    }
    return ans;
}
```

