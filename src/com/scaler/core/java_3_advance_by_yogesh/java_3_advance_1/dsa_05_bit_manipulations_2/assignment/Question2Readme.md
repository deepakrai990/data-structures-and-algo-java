### Q2. Maximum AND Pair
#### Problem Description
```text
Given an array A. For every pair of indices i and j (i != j), 
find the maximum A[i] & A[j].
```
#### Problem Constraints

* <p>1 &lt;= len(A) &lt;= 10<sup>5</sup></p> 
* <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>

```text
1 <= len(A) <= 10^5
1 <= A[i] <= 10^9
```
#### Input Format
```text
The first argument is an integer array A.
```
#### Output Format
```text
Return a single integer that is the maximum A[i] & A[j].
```
#### Example Input
```text
Input 1:-
 A = [53, 39, 88]

Input 2:-
 A = [38, 44, 84, 12] 
```
#### Example Output
```text
Output 1:-
 37

Output 2:-
 36
```
#### Example Explanation
```text
Explanation 1:-
    53 & 39 = 37
    39 & 88 = 0
    53 & 88 = 16
    Maximum among all these pairs is 37

Explanation 2:-
    Maximum bitwise and among all pairs is (38, 44) = 36
```
### Hints
* Hint 1
```text
2^i is larger than sum of all 2^j for j in range(0,i-1). 

So try to greedily include the largest bits in the final 
answer and minimize the array.
```
* Solution Approach
```text
2^i is larger than sum of all 2^j for j in range(0,i-1). 
So try to greedily include the largest bits in the final 
answer and minimize the array.

Iterate from the largest possible bit to smallest bit 0. Create 
another empty set of numbers say st.
Iterate over the current set of numbers, if the number has the 
current bit set then include this number in st.
If size of st is greater than 1 that is at least one pair is 
possible then replace current set with st. 
Else continue to next bit.
Finally after and of any two elements in the current set 
will have the largest ands as we have removed the lower and pairs.

Time Complexity - O(32 * N). Since there can be upto 32 bits, 
we iterate and 
create new sets 32 times reducing the set everytime.

Space Complexity - O(N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(ArrayList < Integer > A) {
        ArrayList < Integer > v = new ArrayList < Integer > ();
        for (int it : A) 
            v.add(it);
        for (int i = 29; i >= 0; i--) {
            // create a set of elements with the i-th bit set
            ArrayList < Integer > v2 = new ArrayList < Integer > ();
            for (int it : v)
                if ((it & (1 << i)) != 0) 
                    v2.add(it);
            if (v2.size() >= 2) {
                v.clear();
                for (int it: v2) 
                    v.add(it);
            }
        }
        return (int)(v.get(0) & v.get(1));
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of integers
 //return an integer
	solve : function(A){
	    let v = [];
	    let n = A.length;
	    for(let i = 0; i < n; i++) {
	        v.push(A[i]);
	    }
        for(let i = 29; i >= 0; i--) {
            // create a set of elements with the i-th bit set
            let v2 = [];
            let m = v.length;
            for(let j = 0; j < m; j++) {
                if(v[j] & BigInt(1 << i) )
                    v2.push(v[j]);
            }
            if(v2.length >= 2)
                v = v2;
        }
        return Number(v[0] & v[1]);
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(vector < int > & A) {
    assert(2 <= A.size() && A.size() <= 1e5);
    for (auto it: A) assert(it >= 1 && it <= 1e9);
    vector < int > v;
    for (auto it: A) 
        v.push_back(it);
    for (int i = 29; i >= 0; i--) {
        // create a set of elements with the i-th bit set
        vector < int > v2;
        for (auto it : v)
            if (it & (1 << i)) 
                v2.push_back(it);
        if (v2.size() >= 2) 
            v = v2;
    }
    return v[0] & v[1];
}
```

