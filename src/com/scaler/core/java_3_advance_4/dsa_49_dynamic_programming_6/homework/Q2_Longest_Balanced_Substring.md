### Q2. Longest Balanced Substring
#### Problem Description
```text
Given a string A made up of multiple brackets of type "[]" , "()" and "{}" find the 
length of the longest substring which forms a balanced string .

Conditions for a string to be balanced :

    * Blank string is balanced ( However blank string will not be provided as a test case ).
    * If B is balanced : (B) , [B] and {B} are also balanced.
    * If B1 and B2 are balanced then B1B2 i.e the string formed by concatenating B1 
      and B2 is also balanced.
```
#### Problem Constraints
```text
0 <= |A| <= 10^6
```
#### Input Format
```text
First and only argument is an string A.
```
#### Output Format
```text
Return an single integer denoting the length of the longest balanced substring.
```
#### Example Input
```text
Input 1:
 A = "[()]"

Input 2:
 A = "[(])"
```
#### Example Output
```text
Output 1:
 4

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
    Substring [1:4] i.e "[()]" is the longest balanced substring of length 4.

Explanation 2:
    None of the substring is balanced so answer is 0.
```
### Hints
* Hint 1
```text
Try to think in terms of dynamic programming.
Use DP[i] to store the longest length of valid parantheses which end at i
For example:
if A[i]==”)” and A[i-1]==”(“ then dp[i]=dp[i-2]+2;
Think of more such cases and form a recurrence relation.
```
* Solution Approach
```text
The solution uses DP. The main idea is as follows:
1) Construct an array longest[] . For any index i, longest[i] stores the longest length 
   of valid parentheses which ends at i.

And the DP idea for any string s is :

2) If s[i] is any opening bracket, set longest[i] to 0, because any string ending with 
   an opening bracket cannot be balanced.
3) If s[i] is a closing bracket and s[i-1] is it’s opening balancing bracket then, 
   longest[i] = longest[i-2] + 2
4) If s[i] is a closing bracket and s[i-longest[i-1]-1] is it’s opening balancing 
   bracket then, longest[i] = longest[i-1] + 2 + longest[i-longest[i-1]-2]
5) Rest all the cases when s[i] is a closing bracket, longest[i] will be equal to 0.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
  public int LBSlength(final String A) {
    char[] s = A.toCharArray();
    if (s.length <= 1) return 0;
    int curMax = 0;
    int[] longest = new int[s.length];
    Arrays.fill(longest, 0);
    for (int i = 1; i < s.length; i++) {
      if (s[i] == '>' || s[i] == ')' || s[i] == ']' || s[i] == '}') {
        if ((s[i] == '>' && s[i - 1] == '<') ||
          (s[i] == ')' && s[i - 1] == '(') ||
          (s[i] == ']' && s[i - 1] == '[') ||
          (s[i] == '}' && s[i - 1] == '{')) {
          longest[i] = (i - 2) >= 0 ? (longest[i - 2] + 2) : 2;
          curMax = Math.max(longest[i], curMax);
        } else {
          if (i - longest[i - 1] - 1 >= 0 && (
              (s[i] == '>' && s[i - longest[i - 1] - 1] == '<') ||
              (s[i] == ')' && s[i - longest[i - 1] - 1] == '(') ||
              (s[i] == ']' && s[i - longest[i - 1] - 1] == '[') ||
              (s[i] == '}' && s[i - longest[i - 1] - 1] == '{'))) {
            longest[i] = longest[i - 1] + 2 + ((i - longest[i - 1] - 2 >= 0) ? longest[i - longest[i - 1] - 2] : 0);
            curMax = Math.max(longest[i], curMax);
          }
        }
      }
      //if s[i] == '<' or '(' or '[' or '{', skip it, because longest[i] must be 0
    }
    return curMax;
  }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    LBSlength: function (s) {
        if (s.length <= 1) return 0;
        let curMax = 0;
        let longest = new Array(s.length).fill(0);
        for (let i = 1; i < s.length; i++) {
            if (s[i] == ">" || s[i] == ")" || s[i] == "]" || s[i] == "}") {
                if (
                    (s[i] == ">" && s[i - 1] == "<") ||
                    (s[i] == ")" && s[i - 1] == "(") ||
                    (s[i] == "]" && s[i - 1] == "[") ||
                    (s[i] == "}" && s[i - 1] == "{")
                ) {
                    longest[i] = i - 2 >= 0 ? longest[i - 2] + 2 : 2;
                    curMax = Math.max(longest[i], curMax);
                } else {
                    if (
                        i - longest[i - 1] - 1 >= 0 &&
                        ((s[i] == ">" && s[i - longest[i - 1] - 1] == "<") ||
                            (s[i] == ")" && s[i - longest[i - 1] - 1] == "(") ||
                            (s[i] == "]" && s[i - longest[i - 1] - 1] == "[") ||
                            (s[i] == "}" && s[i - longest[i - 1] - 1] == "{"))
                    ) {
                        longest[i] =
                            longest[i - 1] +
                            2 +
                            (i - longest[i - 1] - 2 >= 0
                                ? longest[i - longest[i - 1] - 2]
                                : 0);
                        curMax = Math.max(longest[i], curMax);
                    }
                }
            }
        }
        return curMax;
    },
};
```
* * Solution in C++
```cpp
int Solution::LBSlength(const string s) {
  if (s.length() <= 1) return 0;
  int curMax = 0;
  vector < int > longest(s.size(), 0);
  for (int i = 1; i < s.length(); i++) {
    if (s[i] == '>' || s[i] == ')' || s[i] == ']' || s[i] == '}') {
      if ((s[i] == '>' && s[i - 1] == '<') ||
        (s[i] == ')' && s[i - 1] == '(') ||
        (s[i] == ']' && s[i - 1] == '[') ||
        (s[i] == '}' && s[i - 1] == '{')) {
        longest[i] = (i - 2) >= 0 ? (longest[i - 2] + 2) : 2;
        curMax = max(longest[i], curMax);
      } else {
        if (i - longest[i - 1] - 1 >= 0 && (
            (s[i] == '>' && s[i - longest[i - 1] - 1] == '<') ||
            (s[i] == ')' && s[i - longest[i - 1] - 1] == '(') ||
            (s[i] == ']' && s[i - longest[i - 1] - 1] == '[') ||
            (s[i] == '}' && s[i - longest[i - 1] - 1] == '{'))) {
          longest[i] = longest[i - 1] + 2 + ((i - longest[i - 1] - 2 >= 0) ? longest[i - longest[i - 1] - 2] : 0);
          curMax = max(longest[i], curMax);
        }
      }
    }
    //if s[i] == '<' or '(' or '[' or '{', skip it, because longest[i] must be 0
  }
  return curMax;
}
```

