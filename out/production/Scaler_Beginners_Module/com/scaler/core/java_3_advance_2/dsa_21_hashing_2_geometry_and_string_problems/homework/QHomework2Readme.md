### Q2. Isomorphic Strings
#### Problem Description
```text
Given two strings A and B, determine if they are isomorphic.

A and B are called isomorphic strings if all occurrences of 
each character in A can be replaced with another character 
to get B and vice-versa.
```
#### Problem Constraints
```text
1 <= |A| <= 100000

1 <= |B| <= 100000

A and B contain only lowercase characters.
```
#### Input Format
```text
The first Argument is string A.

The second Argument is string B.
```
#### Output Format
```text
Return 1 if strings are isomorphic, 0 otherwise.
```
#### Example Input
```text
Input 1:
 A = "aba"
 B = "xyx"

Input 2:
 A = "cvv"
 B = "xyx"
```
#### Example Output
```text
Output 1:
 1

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    Replace 'a' with 'x', 'b' with 'y'.

Explanation 2:
    A cannot be converted to B.
```
### Hints
* Hint 1
```text
We can observe that each character of A needs to go to the 
same character in B.

Also, the lengths of the string need to be equal to be isomorphic.
```
* Solution Approach
```text
You can use hashing to solve this question.

For each character in A, store the corresponding character in B.

If there is a contradiction in the mapping, then you can 
directly return the value 0.

If the character was not already present, then insert it 
into the character map.

Also, the lengths of the string need to be equal to be isomorphic.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A, String B) {
        if (isIsomorphic(A, B))
            return 1;
        else
            return 0;
    }

    public Boolean isIsomorphic(String X, String Y) {
        // if X and Y have different lengths, they cannot be Isomorphic
        if (X.length() != Y.length())
            return false;
        // use map to store mapping from characters of string X to string Y
        int map[] = new int[26];
        for (int i = 0; i < 26; i++)
            map[i] = -1;
        // to store if i is mapped or not
        int isMap[] = new int[26];
        for (int i = 0; i < 26; i++)
            isMap[i] = -1;
        for (int i = 0; i < X.length(); i++) {
            char x = X.charAt(i), y = Y.charAt(i);
            // if x is seen before
            if (map[x - 'a'] != -1) {
                // return false if first occurrence of x is mapped to
                // different character
                if (map[x - 'a'] != y - 'a')
                    return false;
            }
            // if x is seen for the first time (i.e. it is not mapped yet)
            else {
                // return false if y is already mapped to some other char in X
                if (isMap[y - 'a'] != -1)
                    return false;
                // map y to x and mark it mapped
                map[x - 'a'] = y - 'a';
                isMap[y - 'a'] = 1;
            }
        }
        return true;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : string
    //param B : string
    //return an integer
    solve: function (A, B) {
        // if A and B have different lengths, they cannot be Isomorphic
        if (A.length !== B.length) {
            return 0;
        }
        // use map to store mapping from characters of string A to string B
        let m = new Map();
        for (let i = 0; i < A.length; i++) {
            // if A[i] is seen before
            if (m.has(A[i]) && m.get(A[i]) !== B[i]) {
                // return 0 if first occurrence of A[i] is mapped to different character
                return 0;
            } 
            // if A[i] is seen for the first time (i.e. it is not mapped yet)
            else {
                // map B[i] to A[i]
                m.set(A[i], B[i]);
            }
        }
        // checks if all the values in the map are distinct
        if (new Set([...m.values()]).size === m.size) {
            return 1;
        }
        return 0;
    }
};
```
* * Solution in C++
```cpp
bool isIsomorphic(string X, string Y) {
    // if X and Y have different lengths, they cannot be Isomorphic
    if (X.length() != Y.length())
        return false;
    // use map to store mapping from characters of string X to string Y
    unordered_map < char, char > map;
    // use set to store pool of already mapped characters
    unordered_set < char > set;
    for (int i = 0; i < X.length(); i++) {
        char x = X[i], y = Y[i];
        // if x is seen before
        if (map.find(x) != map.end()) {
            // return false if first occurrence of x is mapped to
            // different character
            if (map[x] != y)
                return false;
        }
        // if x is seen for the first time (i.e. it is not mapped yet)
        else {
            // return false if y is already mapped to some other char in X
            if (set.find(y) != set.end())
                return false;
            // map y to x and mark it mapped
            map[x] = y;
            set.insert(y);
        }
    }
    return true;
}
int Solution::solve(string A, string B) {
    if (isIsomorphic(A, B))
        return 1;
    else
        return 0;
}
```

