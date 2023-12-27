### Q2. Rabin Karp
#### Problem Description
```text
Given two string A and B of length N and M respectively 
consisting of lowercase letters. Find the number of 
occurrences of B in A.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= M &lt;= N &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= M <= N <= 10^5
```
#### Input Format
```text
Two argument A and B are strings
```
#### Output Format
```text
Return an integer denoting the number of occurrences of B in A
```
#### Example Input
```text
Input 1:
 A = "acbac"
 B = "ac"

Input 2:
 A = "aaaa"
 B = "aa"
```
#### Example Output
```text
Output 1:
 2

Output 2:
 3
```
#### Example Explanation
```text
For Input 1:
    The string "ac" occurs twice in "acbac".

For Input 2:
    The string "aa" occurs thrice in "aaaa".
```
### Hints
* Hint 1
```text
In the naive approach we can consider every index as the
starting point in A and check if it matches B.

How to form a better solution?
```
* Solution Approach
```text
We will use the Rabin Karp algorithm. We compare the hash 
values of the pattern and the corresponding substring of the 
string A of length equal to that of B. 

If the hash value matches, then we increment our count.

As the Rabin Karp algorithm is depending on the hash 
values, we need to calculate the hash value very carefully 
so that we can minimize the collision.

Time Complexity : O(N + M)
Space Complexity : O(N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A, String B) {
        int n = A.length();
        int m = B.length();    
        int prime = 31;
        int mod = (int)(1e9 + 7);
        
        long[] p_pow = new long[n];
        p_pow[0] = 1; 
        for (int i = 1; i < n; i++) {
            p_pow[i] = (p_pow[i - 1] * prime) % mod;
        }
           
        long[] h = new long[n + 1]; 
        for (int i = 0; i < n; i++){
            h[i + 1] = (h[i] + (A.charAt(i) - 'a' + 1) * p_pow[i]) % mod;
        }
        
        long hash_B = 0; 
        for (int i = 0; i < m; i++) {
            hash_B = (hash_B + (B.charAt(i) - 'a' + 1) * p_pow[i]) % mod; 
        }
        
        int ans = 0;
        for (int i = 0; i + m - 1 < n; i++) { 
            long curr_hash = (h[i + m] + mod - h[i]) % mod; 
            if (curr_hash == hash_B * p_pow[i] % mod)
                ans += 1;
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::solve(string A, string B) {
    int n = A.size();
    int m = B.size();    
    int prime = 31;
    int mod = 1e9 + 7;
    
    vector<long long> p_pow(n);
    p_pow[0] = 1; 
    for (int i = 1; i < n; i++) {
        p_pow[i] = (p_pow[i - 1] * prime) % mod;
    }
       
    vector<long long> h(n + 1, 0); 
    for (int i = 0; i < n; i++){
        h[i + 1] = (h[i] + (A[i] - 'a' + 1) * p_pow[i]) % mod;
    }
    
    long long hash_B = 0; 
    for (int i = 0; i < m; i++) {
        hash_B = (hash_B + (B[i] - 'a' + 1) * p_pow[i]) % mod; 
    }
    
    int ans = 0;
    for (int i = 0; i + m - 1 < n; i++) { 
        long long curr_hash = (h[i + m] + mod - h[i]) % mod; 
        if (curr_hash == hash_B * p_pow[i] % mod)
            ans += 1;
    }
    
    return ans;
}
```

