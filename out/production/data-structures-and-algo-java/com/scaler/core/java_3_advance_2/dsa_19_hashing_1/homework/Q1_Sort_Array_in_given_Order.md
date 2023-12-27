### Q1. Sort Array in given Order
#### Problem Description
```text
Given two arrays of integers A and B, Sort A in such a way that 
the relative order among the elements will be the same as 
those are in B.

For the elements not present in B, append them at last in sorted order.

Return the array A after sorting from the above method.

NOTE: Elements of B are unique.
```
#### Problem Constraints
* <p>1 <= length of the array A <= 100000</p>
* <p>1 <= length of the array B <= 100000</p>
* <p>-10<sup>9</sup> &lt;= A[i] 10<sup>9</sup></p>
```text
1 <= length of the array A <= 100000

1 <= length of the array B <= 100000

-10^9 <= A[i] <= 10^9
```
#### Input Format
```text
The first argument given is the integer array A.

The second argument given is the integer array B.
```
#### Output Format
```text
Return the array A after sorting as described.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 3, 4, 5]
 B = [5, 4, 2]

Input 2:
 A = [5, 17, 100, 11]
 B = [1, 100]
```
#### Example Output
```text
Output 1:
 [5, 4, 2, 1, 3]
Output 2:
 [100, 5, 11, 17]
```
#### Example Explanation
```text
Explanation 1:
    Simply sort as described.

Explanation 2:
    Simply sort as described.
```
### Hints
* Hint 1
```text
It would help if you kept counts of
elements in A and B.
Why not use hashmap for the same.
```
* Solution Approach
```text
1. Loop through A, store the count of every number in a 
    HashMap (key: number, value: count of number).

2. Loop through B, check if it is present in HashMap, put in the 
    output array as many times in A, and remove the number 
    from HashMap.

3. Sort the rest of the numbers in HashMap and put them in 
the output array.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList < Integer > solve(ArrayList < Integer > A, ArrayList < Integer > B) {
        TreeMap < Integer, Integer > mp = new TreeMap < Integer, Integer > ();
        // stores the frequency of the elements of A
        for (int i = 0; i < A.size(); i++) {
            int x = A.get(i);
            if (mp.get(x) == null) {
                mp.put(x, 1);
            } else {
                mp.put(x, mp.get(x) + 1);
            }
        }
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        for (int i = 0; i < B.size(); i++) {
            int y = B.get(i);
            // checks if y exists in A
            if (mp.get(y) != null) {
                while (mp.get(y) > 0) {
                    ans.add(y);
                    mp.put(y, mp.get(y) - 1);
                }
            }
        }
        Set < Integer > keys = mp.keySet();
        // append the elements that are not present in B
        for (Integer key: keys) {
            int t = mp.get(key);
            while (t > 0) {
                ans.add(key);
                t--;
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //param B : array of integers
    //return a array of integers
    solve: function (A, B) {
        let uncommonElements = [];
        let commonElements = [];
        let result = [];
        let i = 0;
        for (var c of A) {
            if (!B.includes(c)) {
                // uncommonElements stores the elements present only in A
                uncommonElements.push(c);
            } else {
                // commonElements stores the elements present in both arrays
                commonElements.push(c);
            }
        }
        uncommonElements.sort((a, b) => a - b);
        while (i < B.length) {
            for (var d of commonElements) {
                if (d === B[i]) {
                    result.push(d);
                }
            }
            i++;
        }
        return result.concat(uncommonElements);
    }
};
```
* * Solution in C++
```cpp
vector < int > Solution::solve(vector < int > & A, vector < int > & B) {
    map < int, int > mp;
    // stores the frequency of the elements of A
    for (int i = 0; i < A.size(); i++) {
        mp[A[i]] += 1;
    }
    A.clear();
    for (int i = 0; i < B.size(); i++) {
        // checks if B[i] exists in A
        if (mp[B[i]] >= 1) {
            while (mp[B[i]]--) {
                A.push_back(B[i]);
            }
            mp.erase(B[i]);
        }
    }
    for (auto i: mp) {
        // append the elements that are not present in B
        if (i.second > 0) {
            int t = i.second;
            while (t--) {
                A.push_back(i.first);
            }
        }
    }
    return A;
}
```

