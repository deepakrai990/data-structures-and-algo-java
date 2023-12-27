### Q3. Count Sub-arrays
#### Problem Description
```text
Misha likes finding all Sub-arrays of an Array. Now she gives you 
an array A of N elements and told you to find the number 
of sub-arrays of A, that have unique elements.
```
<p> 
    Since the number of sub-arrays could be large, return 
    <strong>value % 10<sup>9</sup> +7</strong>.
</p>

#### Problem Constraints
* <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
* <p>1 &lt;= A[i] &lt;= 10<sup>6</sup></p>
```text
1 <= N <= 10^5

1 <= A[i] <= 10^6
```
#### Input Format
```text
The only argument given is an Array A, having N integers.
```
#### Output Format
```text
Return the number of sub-arrays of A, that have unique elements.
```
#### Example Input
```text
Input 1:
 A = [1, 1, 3]

Input 2:
 A = [2, 1, 2]
```
#### Example Output
```text
Output 1:
 4

Output 1:
 5
```
#### Example Explanation
```text
Explanation 1:
     Sub-arrays of A that have unique elements only:
     [1], [1], [1, 3], [3]

Explanation 2:
     Sub-arrays of A that have unique elements only:
     [2], [1], [2, 1], [1, 2], [2]
```
### Hints
* Hint 1
```text
You need to find all sub-arrays having unique elements.
Is there any way that hashing can help?
```
* Solution Approach
```text
You can find all sub-arrays having unique elements using 
Two Pointers and Hashing.

Maintain two pointer l and r. Store all the elements in the 
current window in a set.

If the element A[j] is already present in the window, then 
we keep removing elements from the left till the window 
has only unique elements. 

Now the we can have sub-arrays with unique elements ending 
at r with any starting index i
in the range l <= i <= r. So the number of sub-arrays ending 
at r is given by (r - l + 1).

Add this contribution for all the indices of the array.


Time Complexity : O(NlogN)
Space Complexity : O(N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        HashSet<Integer> hs = new HashSet<>();
        long ans = 0;
        int N = A.length, l = 0;
        for(int r = 0; r < N; r++) {
            // check if A[r] is already there in the present window
            while(hs.contains(A[r])) {
                hs.remove(A[l]);
                l++;
            }
            // add the subarrays ending at position r
            ans += r - l + 1;
            hs.add(A[r]);
        }
        return (int)(ans % (long)(1e9 + 7));
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of integers
 //return an integer
	solve : function(A){
        let se = new Set();
        let ans = 0;
        let N = A.length, l = 0;
        for(let r = 0; r < N; r++) {
            // check if A[r] is already there in the present window
            while(se.has(A[r])) {
                se.delete(A[l]);
                l++;
            }
            // add the subarrays ending at position r
            ans += r - l + 1;
            se.add(A[r]);
        }
        return (ans % (1e9 + 7));
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A) {
    set<int> se;
    long ans = 0;
    int N = A.size(), l = 0;
    for(int r = 0; r < N; r++) {
        // check if A[r] is already there in the present window
        while(se.find(A[r]) != se.end()) {
            se.erase(A[l]);
            l++;
        }
        // add the subarrays ending at position r
        ans += r - l + 1;
        se.insert(A[r]);
    }
    return (int)(ans % (long)(1e9 + 7));
}
```

