### Q2. Change character
#### Problem Description
```text
You are given a string A of size N consisting of lowercase alphabets.

You can change at most B characters in the given string to any 
other lowercase alphabet such that the number of distinct characters 
in the string is minimized.

Find the minimum number of distinct characters in the 
resulting string.
```
#### Problem Constraints
```text
1 <= N <= 100000

0 <= B < N
```
#### Input Format
```text
The first argument is a string A.

The second argument is an integer B.
```
#### Output Format
```text
Return an integer denoting the minimum number of distinct 
characters in the string.
```
#### Example Input
```text
Input 1:
 A = "abcabbccd"
 B = 3
```
#### Example Output
```text
Output 1:
 2
```
#### Example Explanation
```text
Explanation 1:
    We can change both 'a' and one 'd' into 'b'.So the new 
    string becomes "bbcbbbccb".
    
    So the minimum number of distinct character will be 2.
```
### Hints
* Hint 1
```text
Try changing characters to a character which have the highest frequency.
Think, you can change at most B characters.
```
* Solution Approach
```text
Since there are 26 characters we can find frequency of each character.

Sort them in ascending order. Since we have to minimize the number 
of distinct characters, we will change characters whose frequency 
is less into the character which has the highest frequency.

We will check the maximum number of distinct characters we 
can successfully change.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(String A, int B) {
        int cnt[] = new int[26];
        for (int i = 0; i < A.length(); ++i) {
            ++cnt[A.charAt(i) - 'a'];
        }
        ArrayList<Integer> C = new ArrayList<Integer>();
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] > 0) {
                C.add(cnt[i]);
            }
        }
        Collections.sort(C);
        for (int i = 0; i < C.size(); ++i) {
            B -= C.get(i);
            if (B < 0) {
                return C.size() - i;
            }
        }
        return 1;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
    //param A : string
    //param B : integer
    //return an integer
	solve : function(A, B){
	    let arr = new Array(26).fill(0);
	    let n = A.length;
	    let ans = 0;
	    
	    for(let i = 0; i < n; i++) {
	         arr[A.charCodeAt(i) - 97]++;
	         
	         if(arr[A.charCodeAt(i) - 97] == 1)
	            ans++;
	    }
	    arr.sort( (a,b) => {return a - b});
	    
	    for(let i = 0; i < arr.length; i++) {
	        if(B-arr[i] >= 0 && arr[i]!=0) {
	            ans--;
	            B -= arr[i];
	        }
	    }
	    ans = Math.max(ans, 1)
	    return ans;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(string A, int B) {
  int n=A.size();
  int arr[26];
  memset(arr,0,sizeof(arr));
  int ans=0;
  for(int i=0;i<n;i++)
  {
    arr[A[i]-'a']++;
    if(arr[A[i]-'a']==1)
    {
      ans++;
    }
  }
   sort(arr,arr+26);
  for(int i=0;i<26;i++)
  {
    if(B-arr[i]>=0 && arr[i]!=0)
    {
      ans--;
      B-=arr[i];
    }
  }
  ans = max(ans, 1);
  return ans;
}
```

