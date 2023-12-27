### Q3. Find All Primes
#### Problem Description
```text
Given an integer A. Find the list of all prime numbers in the range [1, A].
```
#### Problem Constraints
* <p>1 &lt;= A &lt;= 10<sup>6</sup></p>
```text
1 <= A <= 10^6
```
#### Input Format
```text
Only argument A is an integer.
```
#### Output Format
```text
Return a sorted array of prime number in the range [1, A].
```
#### Example Input
```text
Input 1:
 A = 7

Input 2:
 A = 12
```
#### Example Output
```text
Output 1:
 
 [2, 3, 5, 7]

Output 2:
 
 [2, 3, 5, 7, 11]
```
#### Example Explanation
```text
For Input 1:
 
 The prime numbers from 1 to 7 are 2, 3, 5 and 7.


For Input 2:
 
 The prime numbers from 1 to 12 are 2, 3, 5, 7 and 11.
```
### Hints
* Hint 1
```text
Try using Sieve of Eratosthenes to find
all prime numbers till A
```
* Solution Approach
```text
We use the method of sieve of eratosthenes to find all prime numbers till A.
In this method we iterate from 2 to sqrt(A) and whenever we encounter a prime
number, we mark all multiples of that number as non-prime numbers.
Then we loop from 1 to A and add all the prime number to our final array.

Time Complexity : O(A log log A)
Space Complexity : O(A)

```
* Complete Solution
```java
public class Solution {
    public int[] sieve(int n){
        // sieve of eratosthenes
        int[] prime = new int[n + 1];
        for(int i = 2; i * i <= n; i++){
            if(prime[i] == 0){
                for(int j = i * i; j <= n; j += i){
                    prime[j] = 1;
                }
            }
        }
        return prime;
    }
    public int[] solve(int A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int[] prime = sieve(A);
        for(int i = 2; i <= A; i++){
            if(prime[i] == 0){
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
```

```cpp
vector<int> sieve(int n){
    // sieve of eratosthenes
    vector<int> prime(n + 1, 0);
    for(int i = 2; i * i <= n; i++){
        if(prime[i] == 0){
            for(int j = i * i; j <= n; j += i){
                prime[j] = 1;
            }
        }
    }
    return prime;
}

vector<int> Solution::solve(int A) {
    assert(1 <= A and A <= 1e6);
    vector<int> ans;
    vector<int> prime = sieve(A);
    for(int i = 2; i <= A; i++){
        if(prime[i] == 0){
            ans.push_back(i);
        }
    }
    return ans;
}
```

