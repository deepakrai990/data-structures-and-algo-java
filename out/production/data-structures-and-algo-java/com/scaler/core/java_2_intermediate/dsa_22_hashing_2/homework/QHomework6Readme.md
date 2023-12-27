### Q6. Is Dictionary?
#### Problem Description
```text
Surprisingly, in an alien language, they also use English 
lowercase letters, but possibly in a different order. The 
order of the alphabet is some permutation of lowercase letters.

Given an array of words A of size N written in the alien 
language, and the order of the alphabet denoted by 
string B of size 26, return 1 if and only if the given 
words are sorted lexicographically in this alien 
language else, return 0.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N, length of each word &lt;= 10<sup>5</sup></p>
    <p>Sum of the length of all words &lt;= 2 * 10<sup>6</sup></p>
</div>

```text
1 <= N, length of each word <= 10^5

Sum of the length of all words <= 2 * 10^6
```
#### Input Format
```text
The first argument is a string array A of size N.

The second argument is a string B of size 26, denoting the order.
```
#### Output Format
```text
Return 1 if and only if the given words are sorted 
lexicographically in this alien language else, return 0.
```
#### Example Input
```text
Input 1:
 A = ["hello", "scaler", "interviewbit"]
 B = "adhbcfegskjlponmirqtxwuvzy"

Input 2:
 A = ["fine", "none", "no"]
 B = "qwertyuiopasdfghjklzxcvbnm"
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
    The order shown in string B is: h < s < i for the given 
    words. So return 1.

Explanation 2:
    "none" should be present after "no". Return 0.
```
### Hints
* Hint 1
```text
The words are sorted lexicographically if and only if 
adjacent words are. 

This is because order is transitive: a <= b and b <= c implies a <= c.
```
* Solution Approach
```text
Let’s check whether all adjacent words a and b have a <= b.

To check whether a <= b for two adjacent words, a and b, we 
can find their first difference.

For example, “applying” and “apples” have the first 
difference of y and e.

After, we compare these characters to the index in order.

Care must be taken to deal with the blank character effectively.

If, for example, we are comparing “app” to “apply”, the 
first difference is between (null) and “l”.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(ArrayList<String> A, String B) {
        int id[] = new int[26];
        for(int i = 0; i < B.length(); ++i){
            id[B.charAt(i)-'a'] = i;
        }
        for(int i = 0; i+1 < A.size(); ++i){
            String x = A.get(i);
            String y = A.get(i+1);
            int n = Math.min(x.length(), y.length());
            int fl = 0;
            for(int j = 0; j < n; ++j){
                int c1 = x.charAt(j)-'a';
                int c2 = y.charAt(j)-'a';
                if(c1 == c2){
                    continue;
                }
                if(id[c1] < id[c2]){
                    fl = 1;
                    break;
                }
                return 0;
            }
            if(fl == 0 && x.length() > y.length()){
                return 0;
            }
        }
        return 1;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::solve(vector<string> &A, string B) {
    int n = A.size();
    int index[26];
    for(int i = 0; i < B.size(); i++){
        index[B[i] - 'a'] = i;
    }
    for(int i = 0; i < A.size()-1; i++){
        string word1 = A[i], word2 = A[i+1];
        int flag = 0;
        for(int k = 0; k < min(word1.length(), word2.length()); k++){
            if(word1[k] != word2[k]){
                if(index[word1[k] - 'a'] > index[word2[k] - 'a'])
                    return 0;
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            if(word1.size() > word2.size()){
                return 0;
            }
        }
    }
    return 1;
}
```

