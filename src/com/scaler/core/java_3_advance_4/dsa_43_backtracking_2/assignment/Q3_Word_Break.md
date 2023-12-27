### Q3. Word Break
#### Problem Description
```text
Given a string A and a dictionary of words B, determine if A can be segmented 
into a space-separated sequence of one or more dictionary words.
```
#### Problem Constraints
```text
1 <= len(A) <= 6500
1 <= len(B) <= 10000
1 <= len(B[i]) <= 20
```
#### Input Format
```text
The first argument is a string, A.
The second argument is an array of strings, B.
```
#### Output Format
```text
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
```
#### Example Input
```text
Input 1:
    A = "myinterviewtrainer",
    B = ["trainer", "my", "interview"]
    
Input 2:
    A = "a"
    B = ["aaa"]
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
    Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented 
    as "my interview trainer".
    
Explanation 2:
    Return 0 ( corresponding to false ) because "a" cannot be segmented as "aaa".
```
### Hints
* Hint 1
```text
Can you calculate the answer if you know which all substring of the given string are 
there in the dictionary?

Think of DP.
```
* Solution Approach
```text
Lets again look at the bruteforce solution.
You start exploring every substring from the start of the string, and check if its in 
the dictionary. If it is, then you check if it is possible to form rest of the string 
using the dictionary words. If yes, my answer is true. If none of the substrings 
qualify, then our answer is false.

So something like this :

    bool wordBreak(int index, string &s, unordered_set<string> &dict) {
                    // BASE CASES

        bool result = false;
        // try to construct all substrings.
        for (int i = index; i < s.length(); i++) {
            substring = *the substring s[index..i] with i inclusive*
            if (dict contains substring) {
                result |= wordBreak(i + 1, s, dict); // If this is true, we are done. 
            }
        }
        return result;
    }

This solution itself is exponential. However, do note that we are doing a lot of 
repetitive work.
Do note, that index in the wordBreak function call can only take s.length() number 
of values [0, s.length]. What if we stored the result of the function somehow and 
did not process it everytime the function is called ?
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int wordBreak(String s, ArrayList<String> B) {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true; // set first to be true, why?
        // Because we need initial state
        Set<String> dict = new HashSet<>(B);
        for (int i = 0; i < s.length(); i++) {
            // should continue from match position
            if (!t[i])
                continue;

            for (String a : dict) {
                int len = a.length();
                int end = i + len;
                if (end > s.length())
                    continue;

                if (t[end]) continue;

                if (s.substring(i, end).equals(a)) {
                    t[end] = true;
                }
            }
        }

        return t[s.length()] ? 1 : 0;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : string
    //param B : array of strings
    //return an integer
    wordBreak: function (s, wordDict) {
        let stack = [1];
        for (let i = 0; i < s.length; i++) {
            stack.push(0);
            for (let j = i; j >= 0; j--) {
                if (stack[j] && wordDict.includes(s.slice(j, i + 1))) {
                    stack[i + 1] = 1;
                    break;
                }
            }
        }
        return stack[s.length];
    }
};
```
* * Solution in C++
```cpp
short memoize[100001];
bool helper(int index, string &s, unordered_set<string> &dict) {
    if (index >= s.length()) return true;
    if (memoize[index] != -1) return memoize[index];
    bool result = false;
    // try to construct all substrings. 
    string substring = "";
    for (int i = index; i < s.length() && result == false; i++) {
        substring.push_back(s[i]);
        if (dict.find(substring) != dict.end()) {
            result |= helper(i + 1, s, dict);
        }
    }
    return memoize[index] = result;
}    

int Solution::wordBreak(string A, vector<string> &B) {
    memset(memoize, -1, sizeof(int) * A.length());
    unordered_set<string> dictSet(B.begin(), B.end());
    return helper(0, A, dictSet);
}
```

