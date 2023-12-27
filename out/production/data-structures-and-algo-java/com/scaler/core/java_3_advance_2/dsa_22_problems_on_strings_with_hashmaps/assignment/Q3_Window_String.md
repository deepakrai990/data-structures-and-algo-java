### Q3. Window String
#### Problem Description
```text
Given a string A and a string B, find the window with minimum 
length in A, which will contain all the characters in B in 
linear time complexity.

Note that when the count of a character c in B is x, then the 
count of c in the minimum window in A should be at least x.

Note:

    * If there is no such window in A that covers all characters 
      in B, return the empty string.
    * If there are multiple such windows, return the first 
      occurring minimum window ( with minimum start index and length )
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= size(A), size(B) &lt;= 10<sup>6</sup><br></p>
</div>

```text
1 <= size(A), size(B) <= 10^6
```
#### Input Format
```text
The first argument is a string A.
The second argument is a string B.
```
#### Output Format
```text
Return a string denoting the minimum window.
```
#### Example Input
```text
Input 1:
 A = "ADOBECODEBANC"
 B = "ABC"

Input 2:
 A = "Aa91b"
 B = "ab"
```
#### Example Output
```text
Output 1:
 "BANC"

Output 2:
 "a91b"
```
#### Example Explanation
```text
Explanation 1:
 "BANC" is a substring of A which contains all characters of B.

Explanation 2:
 "a91b" is the substring of A which contains all characters of B.
```
### Hints
* Hint 1
```text
Think two pointers and hashing.

How can you move left and right pointers to fit all the characters of B?
```
* Solution Approach
```text
Essentially you have a start and end pointer starting from 
the beginning of the string.

You keep moving the end pointer and including more characters 
until you have all B characters included.

At this point, you start moving start pointer and popping out 
characters until you still have all the characters of B included. 
Update your answer and keep repeating the process.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String minWindow(String A, String B) {
        if (A.length() < B.length())
            return "";
        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
        for (int i = 0; i < B.length(); i++) {
            if (counts.get(B.charAt(i)) == null) {
                counts.put(B.charAt(i), 1);
            } else {
                counts.put(B.charAt(i), counts.get(B.charAt(i)) + 1);
            }
        }
        int start = 0;
        int length = 0;
        int total = 0;
        for (int head = 0, tail = 0; tail < A.length(); tail++) {
            if (counts.get(A.charAt(tail)) == null) {
                // If this character is not present in B at all, 
                // we don't care about this character. 
                continue;
            }
            counts.put(A.charAt(tail), counts.get(A.charAt(tail)) - 1);
            // We check if the current character represented by tail caused
            // a character to be included which is relevant to B and is still
            // in deficit. 
            // For example, if B has 3 As, then the first 3 A are relevant to us
            // but the 4th one is not. 
            if (counts.get(A.charAt(tail)) >= 0) {
                total++;
            }
            // check if we have all characters in B covered. 
            if (total == B.length()) {
                // Now move the head pointer till popping out those characters 
                // still makes sure that all characters in B are covered. 
                while (counts.get(A.charAt(head)) == null || counts.get(A.charAt(head)) < 0) {
                    if (counts.get(A.charAt(head)) != null) counts.put(A.charAt(head), counts.get(A.charAt(head)) + 1);
                    ;
                    head++;
                }
                // Now [head - 1, tail] is a valid substring. Update the answer. 
                if (length == 0 || tail - head + 1 < length) {
                    length = tail - head + 1;
                    start = head;
                }
            }
        }
        return A.substring(start, start + length);
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : string
    //param B : string
    //return a strings
    minWindow: function (A, B) {
        let m = new Map(),
            cnt = B.length,
            beg = 0,
            end = 0,
            minLen = A.length + 1,
            ind = 0;
        B.split('').forEach(val => {
            if (m.has(val)) {
                m.set(val, m.get(val) + 1)
            } else {
                m.set(val, 1)
            }
        })
        while (end < A.length) {
            if (m.has(A[end])) {
                // We check if the current character represented by end caused a character 
                // to be included which is relevant to B and is still in deficit.
                if (m.get(A[end]) > 0) {
                    cnt--;
                }
                m.set(A[end], m.get(A[end]) - 1);
            } else {
                m.set(A[end], -1);
            }
            end++;
            // check if we have all characters in B covered
            while (cnt == 0) {
                if (end - beg < minLen) {
                    minLen = end - beg;
                    ind = beg;
                }
                m.set(A[beg], m.get(A[beg]) + 1)
                if (m.get(A[beg]) > 0) {
                    cnt++;
                }
                beg++;
            }
        }
        if (minLen < A.length + 1) {
            return A.slice(ind, ind + minLen);
        }
        return '';
    }
};
```
* * Solution in C++
```cpp
string Solution::minWindow(string A, string B) {
    if (A.length() < B.length())
        return "";
    unordered_map < char, int > counts;
    for (int i = 0; i < B.length(); i++) {
        if (counts.find(B[i]) == counts.end()) {
            counts[B[i]] = 1;
        } else {
            counts[B[i]]++;
        }
    }
    int start = 0;
    int length = 0;
    int total = 0;
    for (int head = 0, tail = 0; tail < A.length(); tail++) {
        auto itTail = counts.find(A[tail]);
        if (counts.find(A[tail]) == counts.end()) {
            // If this character is not present in B at all, 
            // we don't care about this character. 
            continue;
        }
        counts[A[tail]]--;
        // We check if the current character represented by tail caused
        // a character to be included which is relevant to B and is still
        // in deficit. 
        // For example, if B has 3 As, then the first 3 A are relevant to us
        // but the 4th one is not. 
        if (counts[A[tail]] >= 0) {
            total++;
        }
        // check if we have all characters in B covered. 
        if (total == B.size()) {
            // Now move the head pointer till popping out those characters 
            // still makes sure that all characters in B are covered. 
            while (counts.find(A[head]) == counts.end() || counts[A[head]] < 0) {
                if (counts.find(A[head]) != counts.end()) counts[A[head]]++;
                head++;
            }
            // Now [head - 1, tail] is a valid substring. Update the answer. 
            if (length == 0 || tail - head + 1 < length) {
                length = tail - head + 1;
                start = head;
            }
        }
    }
    return A.substr(start, length);
}
```

