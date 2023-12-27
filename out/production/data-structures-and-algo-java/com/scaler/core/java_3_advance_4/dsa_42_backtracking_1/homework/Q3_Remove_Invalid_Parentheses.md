### Q3. Remove Invalid Parentheses
#### Problem Description
```text
Given a string A consisting of lowercase English alphabets and 
parentheses '(' and ')'. Remove the minimum number of invalid parentheses in order to 
make the input string valid.

Return all possible results.

You can return the results in any order.
```
#### Problem Constraints
```text
1 <= length of the string <= 20
```
#### Input Format
```text
The only argument given is string A.
```
#### Output Format
```text
Return all possible strings after removing the minimum number of invalid parentheses.
```
#### Example Input
```text
Input 1:
 A = "()())()"

Input 2:
 A = "(a)())()"
```
#### Example Output
```text
Output 1:
 ["()()()", "(())()"]

Output 2:
 ["(a)()()", "(a())()"]
```
#### Example Explanation
```text
Explanation 1:
    By removing 1 parentheses we can make the string valid.
        1. Remove the parentheses at index 4 then string becomes : "()()()"
        2. Remove the parentheses at index 2 then string becomes : "(())()"

Explanation 2:
    By removing 1 parentheses we can make the string valid.
        1. Remove the parentheses at index 5 then string becomes : "(a)()()"
        2. Remove the parentheses at index 2 then string becomes : "(a())()"
```
### Hints
* Hint 1
```text
Try to think recursively.

First find minimum number of invalid parenthesis to remove, then recursively find 
all those valid strings which have minimum number of invalid parenthesis removed.
```
* Solution Approach
```text
The state of the recursion is now defined by seven different variables:

    1. idx which represents the current character that we have to process in the original 
       string.
    
    2. s which represents the original string.
    
    3. curr_str which represents the current string till idx that we have to formed by 
       deleting invalid parenthesis from the original string.
    
    4. off_left is the number of left parentheses that are not valid and need to 
       be removed..
    
    5. off_right represents the number of right parentheses that are not valid and need 
       to be removed.
    
    6. res_set is the result set of output strings.
    
    7. balance represents the difference between the left opening brackets and right 
       opening brackets in the curr_str.we cannot move forward if balance is negative.

In the base condition we need to check whether(off_left==0 and off_right==0).
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    Set<String> result = new HashSet<String>();

    public ArrayList<String> solve(String A) {
        int left = 0;
        int right = 0;
        // First, we find out the number of misplaced left and right parentheses.
        for (int i = 0; i < A.length(); i++) {
            // Simply record the left one.
            if (A.charAt(i) == '(') {
                left += 1;
            } else if (A.charAt(i) == ')') {
                // If we don't have a matching left, then this is a misplaced right, record it.
                if (left == 0) right += 1;
                // Decrement count of left parentheses because we have found a right
                // which CAN be a matching one for a left.
                if (left > 0) left -= 1;
            }
        }
        List<Character> expr = new ArrayList<>();
        // Now, the left and right variables tell us the number of misplaced left and
        // right parentheses and that greatly helps pruning the recursion.
        recurse(A, 0, 0, 0, left, right, expr);
        ArrayList<String> ans = new ArrayList<String>();
        for (String x : result) {
            ans.add(x);
        }
        return ans;
    }

    public void recurse(String s, int index, int left_count, int right_count, int left_rem, int right_rem, List<Character> expr) {
        // If we reached the end of the string, just check if the resulting expression is
        // valid or not and also if we have removed the total number of left and right
        // parentheses that we should have removed.
        if (index == s.length()) {
            if (left_rem == 0 && right_rem == 0) {
                String tmp = new String();
                for (Character x : expr) tmp += x;
                result.add(tmp);
            }
        } else {
            // The discard case. Note that here we have our pruning condition.
            // We don't recurse if the remaining count for that parenthesis is == 0.
            int f1 = 0, f2 = 0;
            if ((s.charAt(index) == '('))
                f1 = 1;
            if ((s.charAt(index) == ')'))
                f2 = 1;
            if ((s.charAt(index) == '(' && left_rem > 0) || (s.charAt(index) == ')' && right_rem > 0)) {
                recurse(s, index + 1, left_count, right_count, left_rem - f1, right_rem - f2, expr);
            }
            expr.add(s.charAt(index));
            // Simply recurse one step further if the current character is not a parenthesis.
            if (s.charAt(index) != '(' && s.charAt(index) != ')') {
                recurse(s, index + 1, left_count, right_count, left_rem, right_rem, expr);
            } else if (s.charAt(index) == '(') {
                // Consider an opening bracket.
                recurse(s, index + 1, left_count + 1, right_count, left_rem, right_rem, expr);
            } else if (s.charAt(index) == ')' && left_count > right_count) {
                // Consider a closing bracket.
                recurse(s, index + 1, left_count, right_count + 1, left_rem, right_rem, expr);
            }
            // Pop for backtracking.
            expr.remove(expr.size() - 1);
        }
    }
}
```
* * Solution in Javascript
```javascript
var isValid = (string) => {
  let open = 0;
  for (const c of string) {
    if (c === "(") open++;
    else if (c === ")") {
      if (open === 0) return false;
      open--;
    }
  }
  return open === 0;
};

module.exports = {
  solve: function (s) {
    if (!s || s.length === 0) return [""];
    const queue = [s],
      seen = new Set(),
      result = [];
    seen.add(s);

    let validFound = false;

    while (queue.length > 0) {
      let expression = queue.shift();

      if (isValid(expression)) {
        result.push(expression);
        validFound = true;
      }

      if (validFound) continue;

      for (let i = 0; i < expression.length; i++) {
        if (expression[i] !== "(" && expression[i] !== ")") {
          continue;
        }
        let next = expression.substring(0, i) + expression.substring(i + 1);
        if (!seen.has(next)) {
          seen.add(next);
          queue.push(next);
        }
      }
    }
    return result;
  },
};
```
* * Solution in C++
```cpp
void rec(int idx, string & s, string curr_str, int off_left, int off_right, set < string > & res_set, int balance) {
    // If we reached the end of the string, just check if the resulting expression is valid or not and 
    // also if we have removed the total number of left and right parentheses that we should have removed.
    if (idx == s.length()) {
        if (off_left == 0 && off_right == 0) {
            res_set.insert(curr_str);
        }
    } else if (balance >= 0) {
        if (s[idx] == '(' && off_left > 0) {
            rec(idx + 1, s, curr_str, off_left - 1, off_right, res_set, balance);
        }
        if (s[idx] == ')' && off_right > 0) {
            rec(idx + 1, s, curr_str, off_left, off_right - 1, res_set, balance);
        }
        int diff = 0;
        if (s[idx] == ')') {
            diff = -1;
        }
        if (s[idx] == '(') {
            diff = 1;
        }
        rec(idx + 1, s, curr_str + s[idx], off_left, off_right, res_set, balance + diff);
    }
}

void set_off_counts(int & off_left, int & off_right, string & s) {
    for (char c: s) {
        if (c == '(')
            off_left++;
        if (c == ')') {
            if (off_left > 0) {
                off_left--;
            } else {
                off_right++;
            }
        }
    }
}

vector < string > removeInvalidParentheses(string s) {
    int off_left = 0, off_right = 0;
    // we find out the number of misplaced left and right parentheses
    set_off_counts(off_left, off_right, s);
    set < string > res_set;
    rec(0, s, "", off_left, off_right, res_set, 0);
    vector < string > res;
    for (string val: res_set)
        res.push_back(val);
    return res;
}

vector < string > Solution::solve(string A) {
    vector < string > ans = removeInvalidParentheses(A);
    return ans;
}
```

