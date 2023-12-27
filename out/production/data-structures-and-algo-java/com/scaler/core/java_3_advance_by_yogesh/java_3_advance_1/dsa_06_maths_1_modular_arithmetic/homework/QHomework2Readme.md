### Q2. Mod Sum
#### Problem Description

<p>Given an array of integers <strong>A</strong>, calculate 
the <strong>sum</strong> of <strong>A [ i ] % A [ j ]</strong> 
for all possible <strong>i, j</strong> pairs. 
Return <strong>sum % (10<sup>9</sup> + 7)</strong> 
as an output.</p>

```text
Given an array of integers A, calculate the sum 
of A [ i ] % A [ j ] for all possible i, j pairs. Return 
sum % (10^9 + 7) as an output.
```
#### Problem Constraints
* <p>1 &lt;= length of the array <strong>A</strong> &lt;= 10<sup>5</sup></p>
* <p>1 &lt;= A[i] &lt;= 10<sup>3</sup></p>
```text
1 <= length of the array A <= 10^5

1 <= A[i] <= 10^3
```
#### Input Format
```text
The only argument given is the integer array A.
```
#### Output Format

<p>Return a single integer denoting 
<strong>sum % (10<sup>9</sup> + 7)</strong>.</p>

```text
Return a single integer denoting sum % (10^9 + 7).
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3]

Input 2:
 A = [17, 100, 11]
```
#### Example Output
```text
Output 1:
 5

Output 2:
 61
```
#### Example Explanation
```text
Explanation 1:
    (1 % 1) + (1 % 2) + (1 % 3) + (2 % 1) + (2 % 2) 
    + (2 % 3) + (3 % 1) + (3 % 2) + (3 % 3) = 5
```
### Hints
* Hint 1
```text
Use the smaller constraints of values of array i.e. 1 <= A[i] <= 1000.
```
* Solution Approach
```text
Calculate the frequency of all the elements from 1 to 1000.
For all values i from 1 to 1000 calculate sum i as sum 
of i % A[j] , where 1 <= j <= n
Sum of all such ((sum i) * (frequency of i)) would 
be the final answer.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(ArrayList<Integer> A) {
        
        int n = A.size(), mod = 1000 * 1000 * 1000 + 7;
        
        // To store the frequency of each element
        int[] cnt = new int[1009];
        
        // Store the frequency of each element
        for(int a: A)    
            cnt[a]++;
            
        // To store the required answer
        int ans = 0;
        
        // For all valid pairs
        for(int i = 1; i <= 1000; i++){
            if(cnt[i] == 0)    
                continue;
            for(int j = 1; j <= 1000; j++){
                if(cnt[j] == 0)    
                    continue;
                // Update the count
                int val = j % i;
                int temp = cnt[i] * cnt[j] * val;
                ans = ((ans % mod) + (temp % mod)) % mod;
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
	solve : function(A){
	    const mod = 1e9 + 7;
        let n = A.length;
        
        // To store the frequency of each element
        let ct = new Array(1009).fill(0);
        
        // Store the frequency of each element
        A.forEach(a => ct[a]++);
        
        // To store the required answer
        let ans = 0;
        
        // For all valid pairs
        for(let i = 1; i <= 1000; i++){
            if(ct[i] == 0)  
                continue;
            for(let j = 1; j <= 1000; j++){
                if(ct[j] == 0)  
                    continue;
                // Update the count
                let val = j % i;
                let temp = ct[i] * ct[j] * val;
                ans = ((ans % mod) + (temp % mod)) % mod;
            }
        }
        return ans;
	}
};
```
* * Solution in C++
```cpp
const int mod = 1e9 + 7;
int Solution::solve(vector<int> &a) {
    int n = a.size(); 
    int max = *max_element(a.begin(), a.end());
 
    // To store the frequency of each element
    int cnt[max + 1] = { 0 };
 
    // Store the frequency of each element
    for (int i = 0; i < n; i++)
        cnt[a[i]]++;
 
    // To store the required answer
    long long ans = 0;
 
    // For all valid pairs
    for (int i = 1; i <= max; i++) {
        for (int j = 1; j <= max; j++) {
            // Update the count
            ans = ans + cnt[i] * cnt[j] * (i % j);
            ans = ans % mod;
        }
    }
 
    return (int)(ans);
}
```

