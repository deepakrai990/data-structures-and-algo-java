### Q6. Check anagrams
#### Problem Description
```text
You are given two lowercase strings A and B each of length N. 
Return 1 if they are anagrams to each other and 0 if not.

Note : Two strings A and B are called anagrams to each other 
       if A can be formed after rearranging the letters of B.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= N &lt;= 10<sup>5</sup><br>
    A and B are lowercase strings
</div>

```text
1 <= N <= 10^5
A and B are lowercase strings
```
#### Input Format
```text
Both arguments A and B are a string.
```
#### Output Format
```text
Return 1 if they are anagrams and 0 if not
```
#### Example Input
```text
Input 1:
 A = "cat"
 B = "bat"

Input 2:
 A = "secure"
 B = "rescue"
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
For Input 1:
    The words cannot be rearranged to form the same word. So, 
    they are not anagrams.

For Input 2:
    They are an anagram.
```
### Hints
* Hint 1
```text
Can we calculate the frequency of each character in both the words ?
```
* Solution Approach
```text
If the two string A and B are anagrams, then the frequency of each
character in both the strings must be same. So we can keep an 
array of size 26 to calculate the frequency of each characters 
for each of the strings.

Finally, we will compare the two frequency arrays. If they are 
equal, then the strings are anagrams.

Time Complexity : O(N)
Space Complexity : O(26)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A, String B) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i = 0 ; i < A.length() ; i++){
            freq1[A.charAt(i) - 'a']++;
            freq2[B.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < 26 ; i++){
            if(freq1[i] != freq2[i]){
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
int Solution::solve(string A, string B) {
    int freq1[26] = {0} , freq2[26] = {0};
	for(int i = 0 ; i < A.size() ; i++){
		freq1[A[i] - 'a']++;
		freq2[B[i] - 'a']++;
	}
	for(int i = 0 ; i < 26 ; i++){
		if(freq1[i] != freq2[i]){
			return 0;
		}
	}
	return 1;
}
```

