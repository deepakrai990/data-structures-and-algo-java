### Q4. Longest Common Prefix
#### Problem Description
```text
Given the array of strings A, you need to find the longest 
string S, which is the prefix of ALL the strings in the array.

The longest common prefix for a pair of strings S1 and S2 is 
the longest string S which is the prefix of both S1 and S2.

Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".
```
#### Problem Constraints
```text
0 <= sum of length of all strings <= 1000000
```
#### Input Format
```text
The only argument given is an array of strings A.
```
#### Output Format
```text
Return the longest common prefix of all strings in A.
```
#### Example Input
```text
Input 1:
 A = ["abcdefgh", "aefghijk", "abcefgh"]

Input 2:
 A = ["abab", "ab", "abcd"];
```
#### Example Output
```text
Output 1:
 "a"

Output 2:
 "ab"
```
#### Example Explanation
```text
Explanation 1:
    Longest common prefix of all the strings is "a".

Explanation 2:
    Longest common prefix of all the strings is "ab".
```
### Hints
* Hint 1
```text
How about comparing two strings at a time to get their common prefix?
Can this thing be used to generalize for all the strings?
```
* Solution Approach
```text
Note: the prefix has to be the prefix of ALL the strings.

So, you can pick any random string from the array and start 
checking its characters from the beginning to see if they 
can be a part of the common substring.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String longestCommonPrefix(ArrayList < String > A) {
        if (A.size() == 0)
            return "";
        String str;
        String res = "";
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            min = Math.min(min, A.get(i).length());
        }
        for (int i = 0; i < min; i++) {
            char c = A.get(0).charAt(i);
            // check if c character is same in every string or not    
            for (int j = 1; j < A.size(); j++) {

                if (c != A.get(j).charAt(i))
                    return res;
            }
            res += c;
        }
        return res;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    longestCommonPrefix: function (s) {
        if (!s.length) return "";
        var prefix = s[0].length;
        for (var k = 0; k < s.length - 1; k++) {
            var i = 0,
                j = 0;
            var maxi = Math.min(s[k].length, prefix);
            var maxj = Math.min(s[k + 1].length, prefix);
            // finds the longest common prefix between A[i] and current prefix
            while (i < maxi && j < maxj && s[k][i] === s[k + 1][j]) {
                i++;
                j++;
            }
            prefix = i;
            if (!i) break;
        }
        return s[0].slice(0, prefix);
    },
};
```
* * Solution in C++
```cpp
string Solution::longestCommonPrefix(vector < string > & strs) {
    if (strs.size() == 0) return "";
    string ans = "";
    for (int i = 0; i < strs[0].length(); i++) {
        // checking if character i qualifies to be in the answer. 
        bool isQualified = true;
        for (int j = 1; j < strs.size(); j++) {
            if (i >= strs[j].length() || strs[j][i] != strs[0][i]) {
                isQualified = false;
                break;
            }
        }
        if (!isQualified) break;
        ans.push_back(strs[0][i]);
    }
    return ans;
}
```

