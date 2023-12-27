### Q1. Frequency of element query
#### Problem Description
```text
Given an array A. You have some integers given in the array B.

For the i-th number, find the frequency of B[i] in the 
array A and return a list containing all the frequencies.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= |A| &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= |B| &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i] &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= B[i] &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= |A| <= 10^5

1 <= |B| <= 10^5

1 <= A[i] <= 10^5

1 <= B[i] <= 10^5
```
#### Input Format
```text
First argument A is an array of integers.

Second argument B is an array of integers denoting the queries.
```
#### Output Format
```text
Return an array of integers containing frequency of the 
each element in B.
```
#### Example Input
```text
Input 1:
 A = [1, 2, 1, 1]
 B = [1, 2]

Input 2:
 A = [2, 5, 9, 2, 8]
 B = [3, 2]
```
#### Example Output
```text
Output 1:
 [3, 1]

Output 2:
 [0, 2]
```
#### Example Explanation
```text
For Input 1:
    The frequency of 1 in the array A is 3.
    The frequency of 2 in the array A is 1.

For Input 2:
    The frequency of 3 in the array A is 0.
    The frequency of 2 in the array A is 2.
```
### Hints
* Hint 1
```text
Dictionaries in python are key: value pair where the keys 
are always unique.
```
* Solution Approach
```text
Initialize an empty dictionary and loop over the elements in A.

If the element in present in A then increase its 
frequency by 1. If it is not present then initialize a 
new key containing that element with a value of 1.

Now loop over B and extract frquency of each element from the dictionary.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (freq.containsKey(A[i])) {
                freq.put(A[i], freq.get(A[i]) + 1);
            } else {
                freq.put(A[i], 1);
            }
        }
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            if (freq.containsKey(B[i])) {
                ans[i] = freq.get(B[i]);
            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
vector<int> Solution::solve(vector<int> &A, vector<int> &B) {
	unordered_map<int,int> freq;
	vector<int> ans;
	for(auto x : A){
		freq[x]++;
	}
	for(auto y : B){
		ans.push_back(freq[y]);
	}
	return ans;
}
```

