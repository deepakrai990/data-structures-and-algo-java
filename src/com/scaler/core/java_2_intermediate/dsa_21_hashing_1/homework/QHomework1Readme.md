### Q1. Count unique elements
#### Problem Description
```text
You are given an array A of N integers. Return the count of 
elements with frequency 1 in the given array.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= N &lt;= 10<sup>5</sup><br>
    1 &lt;= A[i] &lt;= 10<sup>9</sup>
</div>

```text
1 <= N <= 10^5
1 <= A[i] <= 10^9
```
#### Input Format
```text
First argument A is an array of integers.
```
#### Output Format
```text
Return an integer.
```
#### Example Input
```text
Input 1:
 A = [3, 4, 3, 6, 6]

Input 2:
 A = [3, 3, 3, 9, 0, 1, 0]
```
#### Example Output
```text
Output 1:
 1

Output 2:
 2
```
#### Example Explanation
```text
For Input 1:
    Only the element 4 has a frequency 1.

For Input 2:
    The elements 9 and 1 has a frequency 1.
```
### Hints
* Hint 1
```text
Hashing can be used to store the frequencies of elements in the list.
```
* Solution Approach
```text
We will use a hash-map to store the frequency of all the 
elements of the array. A hash-map stores key-value pair.

We take the element of the array as key and its frequency 
as value.

Finally we traverse the hash-map and count the number of 
elements with frequency 1.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (freq.containsKey(A[i])) {
                freq.put(A[i], freq.get(A[i]) + 1);
            } else {
                freq.put(A[i], 1);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
            }
        }
        return count;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A) {
	map<int,int> freq;
	for(int i = 0 ; i < A.size() ; i++){
		freq[A[i]]++;
	}
	int count = 0;
	for(auto it : freq){
		if(it.second == 1){
			count++;
		}
	}
	return count;
}
```

