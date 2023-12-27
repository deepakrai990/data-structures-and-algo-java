### Q1. First non-repeating character
#### Problem Description
```text
Given a string A denoting a stream of lowercase alphabets, you have 
to make a new string B.

B is formed such that we have to find the first non-repeating 
character each time a character is inserted to the stream and 
append it at the end to B. If no non-repeating character is 
found, append '#' at the end of B.
```
#### Problem Constraints
```text
1 <= |A| <= 100000
```
#### Input Format
```text
The only argument given is string A.
```
#### Output Format
```text
Return a string B after processing the stream of lowercase alphabets A.
```
#### Example Input
```text
Input 1:
 A = "abadbc"

Input 2:
 A = "abcabc"
```
#### Example Output
```text
Output 1:
 "aabbdd"

Output 2:
 "aaabc#"
```
#### Example Explanation
```text
Explanation 1:
    "a"      -   first non repeating character 'a'
    "ab"     -   first non repeating character 'a'
    "aba"    -   first non repeating character 'b'
    "abad"   -   first non repeating character 'b'
    "abadb"  -   first non repeating character 'd'
    "abadbc" -   first non repeating character 'd'

Explanation 2:
    "a"      -   first non repeating character 'a'
    "ab"     -   first non repeating character 'a'
    "abc"    -   first non repeating character 'a'
    "abca"   -   first non repeating character 'b'
    "abcab"  -   first non repeating character 'c'
    "abcabc" -   no non repeating character so '#'
```
### Hints
* Hint 1
```text
Think of how you can maintain information for this stream
to get the required answer.
```
* Solution Approach
```text
You need to maintain a map for each character of the stream.
After that, you can also maintain a queue for the extraction of information.
Each character is inserted and removed from the queue at most once; 
hence time complexity is O(n).

Code looks something like

for (auto c : A) {
    mp[c]++;
    q.push(c);
    while (!q.empty() && mp[q.front()] > 1) q.pop();
    if (!q.empty()) ans.push_back(q.front());
    else ans.push_back(‘#’);
}
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String solve(String A) {
        Queue<Character> q = new LinkedList<Character>();
        // mp stores the frequency of each character
        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            Character c = A.charAt(i);
            if (mp.get(c) != null) {
                mp.put(c, 2);
            } else {
                q.add(c);
                mp.put(c, 1);
            }
            // remove from queue if the character repeats
            while (q.size() > 0 && mp.get(q.peek()) > 1) {
                q.remove();
            }
            if (q.size() > 0)
                sb.append(q.peek());
            else
                sb.append('#');
        }
        return sb.toString();
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : string
    //return a strings
    solve: function (A) {
        // mp stores the frequency of each character
        let mp = new Map();
        let q = [];
        let ans = "";
        for (let i = 0; i < A.length; ++i) {
            mp[A[i]] = (mp[A[i]] || 0) + 1;
            q.push(A[i]);
            // remove from queue if the character repeats
            while (q.length > 0 && (mp[q[0]] || 0) > 1) {
                q.shift();
            }
            if (q.length > 0) {
                ans += q[0];
            } else {
                ans += "#";
            }
        }
        return ans;
    }
};
```
* * Solution in C++
```cpp
string Solution::solve(string A) {
    unordered_map < char, int > mp;
    queue < char > q;
    string ans;
    for (auto c: A) {
        // mp stores the frequency of each character
        mp[c]++;
        q.push(c);
        // remove from queue if the character repeats
        while (!q.empty() && mp[q.front()] > 1)
            q.pop();
        if (!q.empty())
            ans.push_back(q.front());
        else
            ans.push_back('#');
    }
    return ans;
}
```

