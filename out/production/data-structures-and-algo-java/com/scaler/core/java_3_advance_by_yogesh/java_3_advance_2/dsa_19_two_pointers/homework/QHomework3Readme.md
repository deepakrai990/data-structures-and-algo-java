### Q3. Max Continuous Series of 1s
#### Problem Description
```text
Given a binary array A, find the maximum sequence of continuous 1's that 
can be formed by replacing at-most B zeroes.

For this problem, return the indices of maximum continuous 
series of 1s in order.

If there are multiple possible solutions, return the sequence which 
has the minimum start index.
```
#### Problem Constraints
* <p> 0 &lt;= B &lt;= 10<sup>5</sup></p>
* <p> 1 &lt;= size(A) &lt;= 10<sup>5</sup></p>
* <p> 0 &lt;= A[i] &lt;= 1</p>
```text
0 <= B <= 10^5

1 <= size(A) <= 10^5

0 <= A[i] <= 1
```
#### Input Format
```text
First argument is an binary array A.

Second argument is an integer B.
```
#### Output Format
```text
Return an array of integers denoting the indices(0-based) of 1's in 
the maximum continuous series.
```
#### Example Input
```text
Input 1:
 A = [1 1 0 1 1 0 0 1 1 1 ]
 B = 1

Input 2:
 A = [1, 0, 0, 0, 1, 0, 1]
 B = 2
```
#### Example Output
```text
Output 1:
 [0, 1, 2, 3, 4]

Output 2:
 [3, 4, 5, 6]
```
#### Example Explanation
```text
Explanation 1:

    Flipping 0 present at index 2 gives us the longest continuous series 
    of 1's i.e subarray [0:4].

Explanation 2:
    Flipping 0 present at index 3 and index 5 gives us the longest 
    continuous series of 1's i.e subarray [3:6].
```
### Hints
* Hint 1
```text
Hint : Think in terms of 2 pointers.

Would it help if you maintained the number of 0s in the current 
range ? When would you range become invalid ?
```
* Solution Approach
```text
Lets take an example:

N : 4
lis : 1 0 1 0 
M : 2

pointer i and j 
i = j = 0
iterate till i < N:
        if(Number_of_Zeros_in_Current_range > M) :
                increment j and reduce range till Number_of_Zeros_in_current_range < M
        else :
                add element in range and update all variables
Happy Coding
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
	public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
	    ArrayList<Integer> zeroPos = new ArrayList<>();
	    ArrayList<Integer> res = new ArrayList<>();
	    if (A == null)
	        return res;
	    int n = A.size();
	    // store the index of all the 0's
	    for (int i = 0; i < n ; i++) {
	        int num = A.get(i);
	        if (num == 0)
	            zeroPos.add(i);
	    }
	    if (B >= zeroPos.size()) {
	        for (int i = 0; i < n; i++)
	            res.add(i);
	        return res;
	    }
	    int i = 0;
	    int j = B;
	    int maxSize = 0;
	    int start, end;
	    start = 0;
	   // find the longest segment by removing B 0's
	    while (j <= zeroPos.size()) {
	        if (j == zeroPos.size())
    	        end = n - 1;
    	    else
    	        end = zeroPos.get(j) - 1;
	        
	        int size = end - start + 1;
	        
	        if (size > maxSize) {
	            maxSize = size;
	            res.clear();
	            res.add(start);
	            res.add(end);
	        }
	        
	        if (j == zeroPos.size())
	            break;
	        
	        start = zeroPos.get(i) + 1;
	        i++;
	        j++;
	    }
	    start = res.get(0);
	    end = res.get(1);
	    res.clear();
	    for (i = start; i <= end; i++)
	        res.add(i);
	    return res;
	}
}
```
* * Solution in Javascript
```javascript
module.exports = {
  maxone: function (A, B) {
    let zeroPos = [];
    let res = [];
    if (A == null) return res;
    let n = A.length;
    
    // store the index of all the 0's
    for (let i = 0; i < n; i++) {
      let num = A[i];
      if (num == 0) zeroPos.push(i);
    }

    if (B >= zeroPos.length) {
      for (let i = 0; i < n; i++) res.push(i);
      return res;
    }

    let i = 0;
    let j = B;
    let maxSize = 0;
    let start, end;
    start = 0;
    
    // find the longest segment by removing B 0's
    while (j <= zeroPos.length) {
      if (j == zeroPos.length) end = n - 1;
      else end = zeroPos[j] - 1;

      let size = end - start + 1;

      if (size > maxSize) {
        maxSize = size;
        res = [];
        res.push(start);
        res.push(end);
      }
      if (j == zeroPos.length) break;
      start = zeroPos[i] + 1;
      i++;
      j++;
    }
    start = res[0];
    end = res[1];
    res = [];
    for (i = start; i <= end; i++) res.push(i);
    return res;
  },
};
```
* * Solution in C++
```cpp
vector<int> Solution::maxone(vector<int> &A, int B) {
    int N = A.size();
    int max_len = 0;
    int cnt = 0;
    vector < int > ans;

    int ans_start = 0;
    int ans_end = 0;

    int i = 0, j = 0;
    while (j < N) {
        // check the no of 0's in the current segment
        if (cnt + (A[j] == 0) > B) {
            int temp_len = (j - i);
            if (temp_len > max_len) {
                max_len = temp_len;
                ans_start = i;
                ans_end = j - 1;
            }
            // keep removing elements till number of 0's > B
            while (j >= i && cnt + (A[j] == 0) > B) {
                cnt -= (A[i] == 0);
                i++;
            }
            cnt += (A[j] == 0);
        } else {
            cnt += (A[j] == 0);
        }
        j++;
    }

    int temp_len = (j - i);
    if (temp_len > max_len) {
        temp_len = max_len;
        ans_start = i;
        ans_end = j - 1;
    }

    for (int ele = ans_start; ele <= ans_end; ele++) {
        ans.push_back(ele);
    }
    return ans;
}
```

