### Q3. Perfect Numbers
#### Problem Description
```text
Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.

The number of digits in a Perfect number is even.

It is a palindrome number.

For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 
782, 1 are not.
```
#### Problem Constraints
```text
1 <= A <= 100000
```
#### Input Format
```text
The only argument given is an integer A.
```
#### Output Format
```text
Return a string that denotes the Ath Perfect Number.
```
#### Example Input
```text
Input 1:
 A = 2

Input 2:
 A = 3
```
#### Example Output
```text
Output 1:
 22

Output 2:
 1111
```
#### Example Explanation
```text
Explanation 1:
    First four perfect numbers are:
    1. 11
    2. 22
    3. 1111
    4. 1221

Explanation 2:
    First four perfect numbers are:
    1. 11
    2. 22
    3. 1111
    4. 1221
```
### Hints
* Hint 1
```text
How can precomputation help?
Can you precompute the answer of all times and
then answer as the queries come in??
```
* Solution Approach
```text
Can you precompute the answer of all times and
then answer as the queries come in??
It appears that we can use Queue and precompute for 100000 Perfect numbers.
First insert “1” and “2” and then use s -> s+’1’
and s -> s+’2’
to fill up the queue.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public String solve(int A) {
        Queue <String> q = new LinkedList <String> ();
        if (A == 1)
            return "11";
        else if (A == 2)
            return "22";
        q.add("1");
        q.add("2");
        int cur = 2;
        String ans = new String();
        while (q.size() < A) {
            StringBuilder sb = new StringBuilder(q.peek());
            q.remove();
            sb.append("1");
            q.add(sb.toString());
            cur++;
            if (cur == A)
                ans = sb.toString();
            sb.deleteCharAt(sb.length() - 1);
            sb.append("2");
            cur++;
            if (cur == A)
                ans = sb.toString();
            q.add(sb.toString());
        }
        // ans has the first half of our final answer
        StringBuilder sb = new StringBuilder(ans);
        return ans + sb.reverse().toString();
    }
}
```
* * Solution in Javascript
```javascript
let s = Array(100005).fill("");

function ReverseString(str) {
    const revArray = [];
    const length = str.length - 1;
    for (let i = length; i >= 0; i--) {
        revArray.push(str[i]);
    }
    return revArray.join('');
}

module.exports = {
    //param A : integer
    //return a strings
    solve: function (A) {
        s[1] = "1";
        s[2] = "2";
        let q = [];
        q.push(s[1]);
        q.push(s[2]);
        let idx = 2;
        while (idx <= A) {
            let ss = q[0];
            q.shift();
            idx += 1;
            s[idx] = ss + "1";
            q.push(ss + "1");
            idx += 1;
            s[idx] = ss + "2";
            q.push(ss + "2");

        }
        // s[A] has the first half of our final answer
        let ans = s[A];
        let anss = ans;
        ans = ReverseString(ans);
        let ret = anss + ans;
        return ret;
    }
};
```
* * Solution in C++
```cpp
string s[100005];
string Solution::solve(int A) {
    s[1] = "1";
    s[2] = "2";
    queue < string > q;
    q.push(s[1]);
    q.push(s[2]);
    int idx = 3;
    while (idx < A + 3) {
        string ss = q.front();
        q.pop();
        s[idx++] = ss + "1";
        q.push(ss + "1");
        s[idx++] = ss + "2";
        q.push(ss + "2");

    }
    // s[A] has the first half of our final answer
    string ans = s[A];
    string anss = ans;
    reverse(ans.begin(), ans.end());
    return anss + ans;
}
```

