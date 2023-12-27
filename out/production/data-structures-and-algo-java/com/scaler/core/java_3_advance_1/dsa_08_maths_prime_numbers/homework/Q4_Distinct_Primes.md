### Q4. Distinct Primes
#### Problem Description
```text
You have given an array A having N integers. Let say G is the product of all elements of A.

You have to find the number of distinct prime divisors of G.
```
#### Problem Constraints
```text
1 <= N <= 1e5
1 <= A[i] <= 1e5
```
#### Input Format
```text
The first argument given is an Array A, having N integers.
```
#### Output Format
```text
Return an Integer, i.e number of distinct prime divisors of G.
```
#### Example Input
```text
Input:
    A = [1, 2, 3, 4]
```
#### Example Output
```text
Output:
     2
```
#### Example Explanation
```text
Explanation:
    here G = 1 * 2 * 3 * 4 = 24
    and distinct prime divisors of G are [2, 3]
```
### Hints
* Hint 1
```text
Think how you can find prime divisors of a product of elements of an array without 
actually multiplying them.
```
* Solution Approach
```text
You just have to find the prime divisors of each element of an array and count the 
distinct prime divisors.

You can use any data structure like set to store distinct elements.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int temp = A[i];
            for (int j = 2; j * j <= temp; j++) {
                if (temp % j == 0) {
                    set.add(j);
                    while (temp % j == 0)
                        temp /= j;
                }
            }
            if (temp > 1)
                set.add(temp);
        }
        return set.size();
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
#define ll long long int
const int mn = 1e5 + 5;
vector<int> primes[mn];

void pre_compute() {
    if(!primes[2].empty()) return;
    for(ll i = 2; i < mn; i += 1) {
        if(primes[i].empty()) {
            primes[i].push_back((int)i);
            for(ll j = i+i; j < mn; j += i) {
                primes[j].push_back((int)i);
            }
        }
    }
}

int Solution::solve(vector<int> &A) {
    pre_compute();
    set<int> G;
    for(auto &a : A) {
        for(auto &p : primes[a]) {
            G.insert(p);
        }
    }
    return G.size();
}
```

