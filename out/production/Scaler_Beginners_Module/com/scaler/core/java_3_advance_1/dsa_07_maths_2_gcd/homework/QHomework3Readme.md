### Q3. All GCD Pair
#### Problem Description
```text
Given an array of integers A of size N containing GCD of every possible 
pair of elements of another array.

Find and return the original numbers used to calculate the GCD array in 
any order. For example, if original numbers are {2, 8, 10} then the given 
array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.
```
#### Problem Constraints
* <p>1 &lt;= N &lt;= 10000</p>
* <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
```text
1 <= N <= 10000

1 <= A[i] <= 10^9
```
#### Input Format
```text
The first and only argument given is the integer array A.
```
#### Output Format
```text
Find and return the original numbers which are used to calculate 
the GCD array in any order.
```
#### Example Input
```text
Input 1:
 A = [2, 2, 2, 2, 8, 2, 2, 2, 10]

Input 2:
 A = [5, 5, 5, 15]
```
#### Example Output
```text
Output 1:
 [2, 8, 10]
 
Output 2:
 [5, 15]
```
#### Example Explanation
```text
Explanation 1:

 Initially, array A = [2, 2, 2, 2, 8, 2, 2, 2, 10].
 2 is the gcd between 2 and 8, 2 and 10.
 8 and 10 are the gcds pair with itself.
 Therefore, [2, 8, 10] is the original array.


Explanation 2:

 Initially, array A = [5, 5, 5, 15].
 5 is the gcd between 5 and 15.
 15 is the gcds pair with itself.
 Therefore, [5, 15] is the original array.
```
### Hints
* Hint 1
```text
Think of the number which will always be a part of the original 
array. Take use of its gcd to find other numbers.
Will it not be the largest number in the given array?
```
* Solution Approach
```text
    1. Sort the array in decreasing order.
    2. Highest element will always be one of the original numbers. 
       Keep that number and remove it from the array.
    3. Compute GCD of the element taken in the previous step with 
       the current element starting from the greatest and discard 
       the GCD value from the given array.
```
* Complete Solution
```java
public class Solution {
    public int gcd(int A, int B) {
        if (A == 0)
            return B;
        return gcd(B % A, A);
    }
    public ArrayList < Integer > solve(ArrayList < Integer > A) {
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        Collections.sort(A, Collections.reverseOrder());
        HashMap < Integer, Integer > mp = new HashMap < Integer, Integer > ();
        // mp stores the count of A[i]'s that are to be deleted from the array
        for (int i = 0; i < A.size(); i++) {
            int x = A.get(i);
            if (mp.containsKey(x) && mp.get(x) > 0)
                mp.put(x, mp.get(x) - 1);
            else {
                for (int j = 0; j < ans.size(); j++) {
                    int g = gcd(ans.get(j), x);

                    if (mp.containsKey(g))
                        mp.put(g, mp.get(g) + 2);
                    else
                        mp.put(g, 2);
                        
                    // we are adding 2 to the mp as there will 2 pairs gcd(ans[j],A[i]) and gcd(A[i],ans[j])
                }
                ans.add(x);
            }
        }
        return ans;
    }
}
```

```javascript
function gcd(a, b) {
  return b ? gcd(b, a % b) : a;
}

module.exports = {
  solve: function (A) {
    A.sort((a, b) => -a + b);
    let cur = [];
    let mp = new Map();
    // mp stores the count of A[i]'s that are to be deleted from the array
    A.forEach((ele) => {
        if(mp.get(ele) != undefined && mp.get(ele) > 0){
            mp.set(ele, mp.get(ele) - 1);
        }
        else{
            cur.forEach((pre) => {
                let now = gcd(pre, ele);
                if(mp.get(now) != undefined){
                    mp.set(now, mp.get(now) + 2);
                }
                else{
                    mp.set(now, 2);
                }
                // we are adding 2 to the mp as there will 2 pairs gcd(pre, ele) and gcd(ele, pre)
            });
            cur.push(ele);
        }
    });
    return cur;
  },
};
```

```cpp
vector < int > Solution::solve(vector < int > & A) {
    sort(A.begin(), A.end());
    reverse(A.begin(), A.end());
    
    unordered_map < int, int > cnt; //cnt stores the count of A[i]'s that are to be deleted from the array
    vector < int > vec;
    
    for (int i = 0; i < A.size(); i++) {
        if (cnt[A[i]] > 0) {
            cnt[A[i]]--;
        } else {
            for (int j = 0; j < vec.size(); j++) {
                int gcd = __gcd(vec[j], A[i]);
                cnt[gcd] += 2;
                // we are adding 2 to the cnt as there will 2 pairs gcd(vec[j],A[i]) and gcd(A[i],vec[j])
            }
            vec.push_back(A[i]);
        }
    }
    return vec;
}
```
