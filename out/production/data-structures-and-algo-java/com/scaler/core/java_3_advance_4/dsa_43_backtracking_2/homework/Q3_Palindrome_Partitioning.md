### Q3. Palindrome Partitioning
#### Problem Description
```text
Given a string A, partition A such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of A.

Ordering the results in the answer : Entry i will come before Entry j if :
    1. len(Entryi[0]) < len(Entryj[0]) OR
    2. (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
    3. (len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))
```
#### Problem Constraints
```text
1 <= len(A) <= 15
```
#### Input Format
```text
First argument is a string A of lowercase characters.
```
#### Output Format
```text
Return a list of all possible palindrome partitioning of s.
```
#### Example Input
```text
Input 1:
 A = "aab"

Input 2:
 A = "a"
```
#### Example Output
```text
Output 1:
 [
    ["a","a","b"]
    ["aa","b"],
  ]

Output 2:
 [
    ["a"]
  ]
```
#### Example Explanation
```text
Explanation 1:
    In the given example, ["a", "a", "b"] 
    comes before ["aa", "b"] because len("a") < len("aa").

Explanation 2:
    In the given example, only partition possible is "a" .
```
### Hints
* Hint 1
```text
Since, we are listing out all the partitions ( and not counting them), we need 
to do brute force here.

Think of recursion.
```
* Solution Approach
```text
We can use recursion to generate all possible palindrome partitioning of s.

When on index i, you incrementally check all substring starting from i for being 
palindromic. If found, you recursively solve the problem for the remaining string 
and add it to your solution. Start this recursion from starting position of the string.

PS: You can optimize your solution by not computing the answer for same index multiple 
times using Dynamic Programming.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    private int isPalin[][];
    private int N;
    private ArrayList < ArrayList < String >> mRes;
    private String mString;
    public ArrayList < ArrayList < String >> partition(String A) {
        mRes = new ArrayList < > ();
        N = A.length();
        if (N == 0)
            return null;
        mString = A;
        isPalin = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(isPalin[i], -1);
        }
        ArrayList < String > str = new ArrayList < > ();
        rec(str, 0);
        return mRes;
    }
    public void rec(ArrayList < String > str, int index) {
        if (index == N) {
            // we reached the end of the string and valid sequence of strings found.
            mRes.add(new ArrayList(str));
            return;
        }
        for (int i = index; i < N; i++) {
            // check if the substring str[index..i] is a palindrome
            if (isPalindrome(index, i)) {
                str.add(mString.substring(index, i + 1));
                rec(str, i + 1);
                str.remove(str.size() - 1);
            }
        }
    }
    public boolean isPalindrome(int start, int end) {
        if (start < 0 || start >= N || end < 0 || end >= N)
            return false;
        if (isPalin[start][end] != -1)
            return isPalin[start][end] == 1;
        int i, j;
        for (i = start, j = end; i < j; i++, j--) {
            if (mString.charAt(i) != mString.charAt(j)) {
                isPalin[start][end] = 0;
                return false;
            }
        }
        isPalin[start][end] = 1;
        return true;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
    //param A : string 
    //return a array of array of integers 
    partition : function(A){ 
        const result = []; 
        const isPalindrome = (left, right) => { 
            while (left < right) { 
                if (A[left] !== A[right]) 
                return false; 
                left++; 
                right--; 
            } 
            return true; 
        }; 
        const partitionlist = (len, list) => { 
            if (len === A.length) { 
                // we reached the end of the string and valid sequence of strings found.
                result.push(list); 
                
            } else { 
                for (let r = len; r < A.length; r++) { 
                    // check if the substring A[len..r] is a palindrome
                    if (isPalindrome(len, r)) { 
                        partitionlist(r + 1, [...list, A.slice(len, r + 1)]); 
                    } 
                } 
            } 
        }; 
        partitionlist(0, []); 
        return result; 
    } 
};
```
* * Solution in C++
```cpp
bool isPalindrome(string & str, int s, int e) {
    while (s < e) {
        if (str[s] != str[e])
            return false;
        s++;
        e--;
    }
    return true;
}

void partitionHelper(int i, vector < string > & current, string & s, vector < vector < string > > & ans) {
    if (i == s.length()) {
        // we reached the end of the string and valid sequence of strings found.
        ans.push_back(current);
        return;
    }
    for (int j = i; j < s.length(); ++j) {
        // check if the substring s[i..j] is a palindrome
        if (isPalindrome(s, i, j)) {
            current.push_back(s.substr(i, j - i + 1));
            partitionHelper(j + 1, current, s, ans);
            current.pop_back();
        }
    }
}
vector < vector < string > > Solution::partition(string A) {
    vector < vector < string > > ans;
    vector < string > current;
    partitionHelper(0, current, A, ans);
    return ans;
}
```

