### Q4. Count Sort
#### Problem Description
```text
Given an array A. Sort this array using Count Sort Algorithm 
and return the sorted array.
```
#### Problem Constraints

<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= |A| &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i] &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= |A| <= 10^5
1 <= A[i] <= 10^5
```
#### Input Format
```text
The first argument is an integer array A.
```
#### Output Format
```text
Return an integer array that is the sorted array A.
```
#### Example Input
```text
Input 1:
 A = [1, 3, 1]

Input 2:
 A = [4, 2, 1, 3]
```
#### Example Output
```text
Output 1:
 [1, 1, 3]

Output 2:
 [1, 2, 3, 4]
```
#### Example Explanation
```text
For Input 1:
    The array in sorted order is [1, 1, 3].

For Input 2:
    The array in sorted order is [1, 2, 3, 4].
```
### Hints
* Hint 1
```text
We can count the frequency of each of
the elements of the array.
```
* Solution Approach
```text
We will keep the count of frequency of each of the
elements of the array using a frequency array. Then
we will move from 1 to size of the the frequency array
and insert them in our final sorted array.

Time Complexity : O(N + K)

Space Complexity : O(K)
where N is the size and K is the maximum 
value of the given array
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] A) {
        int n = A.length;
        int mx = -1;
        for(int i = 0 ; i < n ; i++){
            mx = Math.max(mx, A[i]);
        }
        int[] freq = new int[mx + 1];
        for(int i = 0 ; i < n ; i++){
            freq[A[i]] += 1;
        }
        int k = 0;
        for(int i = 0 ; i <= mx ; i++){
            for(int j = 0 ; j < freq[i] ; j++){
                A[k] = i;
                k++;
            }
        }
        return A;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
vector<int> Solution::solve(vector<int> &A) {
	int mx = *max_element(A.begin(), A.end());
	int freq[mx + 1] = {0};
	for(auto x : A){
		freq[x]++;
	}
	vector<int>ans;
	for(int i = 0 ; i <= mx ; i++){
		for(int j = 0 ; j < freq[i] ; j++){
			ans.push_back(i);
		}
	}
	return ans;
}
```

