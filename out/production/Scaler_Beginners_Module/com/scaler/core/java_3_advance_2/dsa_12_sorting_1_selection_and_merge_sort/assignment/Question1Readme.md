### Q1. Merge Two Sorted Arrays
#### Problem Description
```text
Given two sorted integer arrays A and B, merge B and A as 
one sorted array and return it as an output.
```
#### Problem Constraints
* <p>-10<sup>10</sup> &lt;= A[i], B[i] &lt;= 10<sup>10</sup></p>
```text
-10^10 <= A[i], B[i] <= 10^10
```
#### Input Format
```text
First Argument is a 1-D array representing A.

Second Argument is also a 1-D array representing B.
```
#### Output Format
```text
Return a 1-D vector which you got after merging A and B.
```
#### Example Input
```text
Input 1:
 A = [4, 7, 9 ]
 B = [2, 11, 19 ]

Input 2:
 A = [1]
 B = [2]
```
#### Example Output
```text
Output 1:
 [2, 4, 7, 9, 11, 19]

Output 2:
 [1, 2]
```
#### Example Explanation
```text
Explanation 1:
    Merging A and B produces the output as described above.

Explanation 2:
    Merging A and B produces the output as described above.
```
### Hints
* Hint 1
```text
Use of additional space is allowed. So, maybe you should 
try collecting the output in a separate array.

Note: You need two pointers at the head of each array, and 
you need to compare the values at the head of the arrays to 
get the current minimum.
```

<ul>
    <li>Since A is sorted, all values after the pointer are 
        going to be bigger.</li>
    <li>Since B is sorted, all values after the pointer are 
        going to be bigger.</li>
</ul>

```text
All values before the pointer have already been put in the result array.
So, all you need to do is to choose the smaller value from the 
two heads and move on.
```

* Solution Approach
```text
Use of additional space is allowed. So, maybe you should try 
collecting the output in a separate array.

Note: You need two pointers at the head of each array, and you 
need to compare the values at the head of the arrays to get 
the current minimum.
```

<ul>
    <li>Since A is sorted, all values after the pointer are 
        going to be bigger.</li>
    <li>Since B is sorted, all values after the pointer are 
        going to be bigger.</li>
</ul>

```text
All values before the pointer have already been put in the result array.

Corner cases:
```

<ul>
    <li>What if pointer 1 reaches the end of the array first?</li>
    <li>What if pointer 2 reaches the end of the array first?</li>
</ul>

```text
If pointer 1 reaches the end we can just keep on putting the 
elements from B in the result array while the pointer 2 does 
not reach the end.

The same process goes for if pointer 2 reaches the end.
```

* Complete Solution
* * Solution in Java
```java
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList < Integer > solve(final List < Integer > A, final List < Integer > B) {
        int m = A.size(), n = B.size();
        ArrayList < Integer > res = new ArrayList < Integer > ();
        if (A == null && B == null)
            return null;
        if (A == null) {
            for (int i = 0; i < n; i++)
                res.add(B.get(i));
            return res;
        }
        if (B == null) {
            for (int i = 0; i < m; i++)
                res.add(A.get(i));
            return res;
        }
        int i, j;
        int k = 0;
        // i and j points to the elements of A and B respectively
        for (i = 0, j = 0; k < m + n; k++) {
            if (i >= m)
                res.add(B.get(j++));
            else if (j >= n)
                res.add(A.get(i++));
            else if (A.get(i) <= B.get(j))
                res.add(A.get(i++));
            else
                res.add(B.get(j++));
        }
        return res;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A, B) {
        let ret = [];
        let i = 0;  // points to the first element of A
        let j = 0;  // points to the first element of B
        while (i < A.length && j < B.length) {
            ret.push(Math.min(A[i], B[j]));
            if (A[i] < B[j]) 
                i++;
            else 
                j++;
        }
        // if pointer 1 (i.e. i) has not reached the end
        while (i < A.length) 
            ret.push(A[i++]);
        // if pointer 2 (i.e. j) has not reached the end 
        while (j < B.length) 
            ret.push(B[j++]);
        return ret;
    },
};
```
* * Solution in C++
```cpp
vector < int > Solution::solve(const vector < int > & A,
    const vector < int > & B) {
    vector < int > res;
    int i = 0; // points to the first element of A
    int j = 0; // points to the first element of B
    while (i < A.size() && j < B.size()) {
        if (A[i] <= B[j]) {
            res.push_back(A[i]);
            i++;
        } else {
            res.push_back(B[j]);
            j++;
        }
    }
    // if pointer 1 (i.e. i) has not reached the end
    while (i < A.size()) {
        res.push_back(A[i]);
        i++;
    }
    // if pointer 2 (i.e. j) has not reached the end 
    while (j < B.size()) {
        res.push_back(B[j]);
        j++;
    }
    return res;
}
```

