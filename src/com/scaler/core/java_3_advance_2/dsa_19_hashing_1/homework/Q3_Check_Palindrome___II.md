### Q3. Check Palindrome - II
#### Problem Description
```text
Given a string A consisting of lowercase characters.

Check if characters of the given string can be rearranged to form a palindrome.

Return 1 if it is possible to rearrange the characters of the string A such that it 
becomes a palindrome else return 0.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= |A| &lt;= 10<sup>5</sup></p>
    <p>A consists only of lower-case characters.</p>
</div>

```text
1 <= |A| <= 10^5

A consists only of lower-case characters.
```
#### Input Format
```text
First argument is an string A.
```
#### Output Format
```text
Return 1 if it is possible to rearrange the characters of the string A such that 
it becomes a palindrome else return 0.
```
#### Example Input
```text
Input 1:
 A = "abcde"

Input 2:
 A = "abbaee"
```
#### Example Output
```text
Output 1:
 0

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
    No possible rearrangement to make the string palindrome.
Explanation 2:
    Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.
```
### Hints
* Hint 1
```text
A set of characters can form a palindrome if at most one character occurs odd number 
of times and all characters occur even number of times.

Use this fact and try to think of solution.
```
* Solution Approach
```text
A set of characters can form a palindrome if at most one character occurs odd 
number of times and all characters occur even number of times.

We can do it in O(|A|) time using a count array.
Following are detailed steps.

    1. Create a count array of alphabet size which is typically 26. Initialize 
       all values of count array as 0.
    
    2. Traverse the given string and increment count of every character.
    
    3. Traverse the count array and if the count array has more than one odd 
       values, return false. Otherwise return true.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A) {
        int[] freq = new int[26];
        for (int i = 0; i < A.length(); i++)
            freq[A.charAt(i) - 97]++;
        int odd = 0;
        for (int a: freq)
            if (a % 2 == 1)
                odd++;
        if (odd > 1)
            return 0;
        return 1;
    }
}
```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp
int Solution::solve(string A) {
  int hashMap[26] = {0};
  for (char a: A)
    hashMap[a - 'a']++;
  int odd = 0;
  for (int a: hashMap)
    if (a % 2)
      odd++;
  if (odd > 1)
    return 0;
  return 1;
}
```

