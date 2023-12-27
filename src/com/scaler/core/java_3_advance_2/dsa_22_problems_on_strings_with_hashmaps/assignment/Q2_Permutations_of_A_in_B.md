### Q2. Permutations of A in B
#### Problem Description
```text
You are given two strings, A and B, of size N and M, respectively.

You have to find the count of all permutations of A present in B as 
a substring. You can assume a string will have only lowercase letters.
```
#### Problem Constraints
```text
1 <= N < M <= 10^5
```
#### Input Format
```text
Given two arguments, A and B of type String.
```
#### Output Format
```text
Return a single integer, i.e., number of permutations of A present 
in B as a substring.
```
#### Example Input
```text
Input 1:
 A = "abc"
 B = "abcbacabc"

Input 2:
 A = "aca"
 B = "acaa"
```
#### Example Output
```text
Output 1:
 5

Output 2:
 2
```
#### Example Explanation
```text
Explanation 1:
     Permutations of A that are present in B as substring are:
        1. abc
        2. cba
        3. bac
        4. cab
        5. abc
        So ans is 5.

Explanation 2:
     Permutations of A that are present in B as substring are:
        1. aca
        2. caa 
```
### Hints
* Hint 1
```text
The aim is to find the count of all permutations of 
string X present in Y as a substring.

Can Hashing help us to find all the permutations?
```
* Solution Approach
```text
Hashing and Sliding Window can easily solve this problem.

The main observation required to solve this problem is every 
permutation of a string will have the same number of characters, 
and the frequency of each character in every permutation 
will be identical.

So first, we can create a hash map of size 26 to count the 
frequency of each character in A.

After that, we can create another hash map of size 26 to count 
the frequency of each character in the first window of 
size N (length of A) in B, then slide through all windows, 
and when both hashes are identical, we can say we found 
a permutation of A in B as a substring.

Alternate Solution:

We can also keep track of how many alphabets have different 
frequencies in A and in windows of B. This way, we can solve the 
problem in O(N) instead of O(26 * N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A, String B) {
        int n = A.length();
        int m = B.length();
        int hash1[] = new int[26];
        int hash2[] = new int[26];
        int count = 0;
        // count frequency of each char in A 
        for (int i = 0; i < n; i += 1) {
            hash1[A.charAt(i) - 'a'] += 1;
        }
        // count frequency of each char in first window of size n in B
        for (int i = 0; i < n; i += 1) {
            hash2[B.charAt(i) - 'a'] += 1;
        }
        count += same(hash1, hash2);
        // move current window 1 step ahead
        for (int i = n, j = 0; i < m; i += 1, j += 1) {
            hash2[B.charAt(j) - 'a'] -= 1;
            hash2[B.charAt(i) - 'a'] += 1;
            count += same(hash1, hash2);
        }
        return count;
    }

    public int same(int[] hash1, int[] hash2) {
        for (int i = 0; i < 26; i += 1) {
            if (hash1[i] != hash2[i])
                return 0; // not a permutation of A
        }
        return 1; // got a permutation of A in B
    }
}
```
* * Solution in Javascript
```javascript
function same(hash1, hash2) {
    for (var i = 0; i < 26; i += 1) {
        if (hash1[i] != hash2[i]) {
            return 0;   // not a permutation of A
        }
    }
    return 1;   // got a permutation of A in B
}

module.exports = {
    //param A : string
    //param B : string
    //return an integer
    solve: function (A, B) {
        var n = A.length;
        var m = B.length;
        var a = "a";
        var hash1 = Array(26).fill(0);
        var hash2 = Array(26).fill(0);
        var count = 0;
        // count frequency of each char in A 
        for (var i = 0; i < n; i += 1) {
            hash1[A.charCodeAt(i) - a.charCodeAt(0)] += 1;
        }
        // count frequency of each char in first window of size n in B
        for (var i = 0; i < n; i += 1) {
            hash2[B.charCodeAt(i) - a.charCodeAt(0)] += 1;
        }
        count += same(hash1, hash2);
        // move current window 1 step ahead
        for (var i = n, j = 0; i < m; i += 1) {
            hash2[B.charCodeAt(j) - a.charCodeAt(0)] -= 1;
            hash2[B.charCodeAt(i) - a.charCodeAt(0)] += 1;
            count += same(hash1, hash2);
            j += 1;
        }
        return count;
    }
};
```
* * Solution in C++
```cpp
int same(int * , int * );
int Solution::solve(string A, string B) {
    int n = A.size();
    int m = B.size();
    int hash1[26], hash2[26];
    int count = 0;
    // Reset hash maps
    for (int i = 0; i < 26; i += 1) {
        hash1[i] = hash2[i] = 0;
    }
    // count frequency of each char in A 
    for (int i = 0; i < n; i += 1) {
        hash1[A[i] - 'a'] += 1;
    }
    // count frequency of each char in first window of size n in B
    for (int i = 0; i < n; i += 1) {
        hash2[B[i] - 'a'] += 1;
    }
    count += same(hash1, hash2);
    // move current window 1 step ahead
    for (int i = n, j = 0; i < m; i += 1, j += 1) {
        hash2[B[j] - 'a'] -= 1;
        hash2[B[i] - 'a'] += 1;
        count += same(hash1, hash2);
    }
    return count;
}

int same(int * hash1, int * hash2) {
    for (int i = 0; i < 26; i += 1) {
        if (hash1[i] != hash2[i])
            return 0; // not a permutation of A
    }
    return 1; // got a permutation of A in B
}
```

