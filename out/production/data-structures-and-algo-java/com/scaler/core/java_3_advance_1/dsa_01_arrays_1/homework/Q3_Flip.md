### Q3. Flip
#### Problem Description
```text
You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.

If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
```
#### Problem Constraints
```text
1 <= size of string <= 100000
```
#### Input Format
```text
First and only argument is a string A.
```
#### Output Format
```text
Return an array of integers denoting the answer.
```
#### Example Input
```text
Input 1:
A = "010"

Input 2:
A = "111"
```
#### Example Output
```text
Output 1:
[1, 1]

Output 2:
[]
```
#### Example Explanation
```text
Explanation 1:

A = "010"

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | "110"
[1 2]          | "100"
[1 3]          | "101"
[2 2]          | "000"
[2 3]          | "001"

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
Explanation 2:

No operation can give us more than three 1s in final string. So, we return empty array [].
```
### Hints
* Hint 1
```text
Note the net change in the number of 1s in string S when we flip bits of string S.
Say it has A 0s and B 1s. Eventually, there are B 0s and A 1s.
```
* Solution Approach
```text
Note the net change in the number of 1s in string S when we flip bits of string S.
Say it has A 0s and B 1s. Eventually, there are B 0s and A 1s.

So, the number of 1s increased by A - B. We want to choose a subarray that maximizes this. Note that if we change 1s to -1, the sum of values will give us A - B. Then, we have to find a subarray with the maximum sum, which can be done via Kadane’s Algorithm.
```
* Complete Solution
```java
public class Solution {
    public ArrayList<Integer> flip(String A) {
        int cur = 0;
        int maxx = 0, l = 0, r = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(-1);
        ans.add(-1);
        //basic kadane's algorithm implementation
        for (int i = 0 ; i < A.length() ; i++) {
            if(A.charAt(i) == '1')
                cur--;
            else
                cur++;
            if (cur > maxx) {
                ans.set(0, l+1);
                ans.set(1, r+1);
                maxx = cur;
            }
            if (cur < 0) {
                cur = 0;
                l = i+1;
                r = i+1;
            } else
                r++;
        }
        if(maxx == 0){
            return new ArrayList<Integer>();
        }
        else return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
  flip: function (A) {
    A = [...A].map((ele) => (+ele == 1 ? -1 : 1));
	let a = -1, b = 0, sum = 0, cur = 0, s = 0;
    // basic kadane's algorithm implementation
	for(let i = 0; i < A.length; i++){
		sum += A[i];
		if(sum > cur){
			cur = sum;
			a = s;
			b = i;
		}
		else if(sum < 0){
			sum = 0;
			s = i + 1;
		}
	}
	if(a == -1)return [];
	else return [a + 1, b + 1];
  },
};
```
* * Solution in C++
```cpp
vector < int > build(string &A){
    int n = A.length();
    vector < int > ar(n);
    for (int i = 0; i < n; i++) {
        if (A[i] == '1')
            ar[i] = -1;
        else
            ar[i] = 1;
    }
    return ar;
}
vector < int > Solution::flip(string A) {
    int n = A.length();
    
    //build new array of 1s and -1s
    vector < int > ar = build(A);
    
    //pair storing the answer
    pair < int, int > ans = make_pair(INT_MAX, INT_MAX);
    
    //basic kadane's algorithm implementation
    //we also storing the begin point for best till now
    int best_till_now = 0, best_ending_here = 0, l = 0;
    for (int i = 0; i < n; i++) {
        if (best_ending_here + ar[i] < 0) {
            l = i + 1;
            best_ending_here = 0;
        } else {
            best_ending_here += ar[i];
        }
        if (best_ending_here > best_till_now) {
            best_till_now = best_ending_here;
            ans.first = l;
            ans.second = i;
        }
    }
    
    //if no valid subarray found
    if (ans.first == INT_MAX)
        return vector < int > ();
    return vector < int > { ans.first + 1, ans.second + 1};
}
```

