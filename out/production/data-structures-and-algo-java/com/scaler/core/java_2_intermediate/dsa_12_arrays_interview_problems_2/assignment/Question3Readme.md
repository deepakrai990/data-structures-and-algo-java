### Q3. Majority Element
#### Problem Description
```text
Given an array of size N, find the majority element. The majority 
element is the element that appears more than floor(n/2) times.

You may assume that the array is non-empty and the majority element 
always exists in the array.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= N &lt;= 5*10<sup>5</sup><br>
    1 &lt;= num[i] &lt;= 10<sup>9</sup>
</div>

```text
1 <= N <= 5*10^5
1 <= num[i] <= 10^9
```
#### Input Format
```text
Only argument is an integer array.
```
#### Output Format
```text
Return an integer.
```
#### Example Input
```text
Input 1:
 [2, 1, 2]
```
#### Example Output
```text
Output 1:
 2
```
#### Example Explanation
```text
Explanation 1:
    2 occurs 2 times which is greater than 3/2.
```
### Hints
* Hint 1
```text
You find two elements x,and y, which are different in the array.
If you removed those two elements, would the majority element change?
```
* Solution Approach
```text
If we cancel out each occurrence of an element X with all the 
other elements that are different from X, then X will exist till 
the end if it is a majority element.

Loop through each element and maintain a count of the element 
that has the potential of being the majority element.

If the next element is the same, then increments the 
count, otherwise decrements the count.

If the count reaches 0, then update the potential index to the 
current element and reset the count to 1.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
	public int majorityElement(final List<Integer> A) {
	    if (A == null)
	        return -1;
	    int maj = A.get(0);
	    int count = 1;
	    int n = A.size();
	    for (int i = 1; i < n; i++) {
	        if (A.get(i) == maj) {
	            count++;
	        } else if (count == 1) {
	            maj = A.get(i);
	        } else {
	            count--;
	        }
	    }
	    count = 0;
	    for (int i = 0; i < n; i++) {
	        if (A.get(i) == maj)
	            count++;
	    }
	    if (count > n / 2)
	        return maj;
	    return -1;
	}
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of integers
 //return an integer
	majorityElement : function(A){
	    
	    let count = 1, majorityindex = 0;
	    
	    for(let i = 1; i<A.length; i++) {
	        if(A[majorityindex] == A[i])
	            count++;
	        else
	            count--;
	        if(count == 0) {
	            count = 1;
	            majorityindex = i;
	        }
	    }
	    
	    return Number(A[majorityindex]);

	}
};
```
* * Solution in C++
```cpp
int Solution::majorityElement(const vector<int> &num) {
    int majorityIndex = 0;
    for (int count = 1, i = 1; i < num.size(); i++) {
        num[majorityIndex] == num[i] ? count++ : count--;
        if (count == 0) {
            majorityIndex = i;
            count = 1;
        }
    }
    return num[majorityIndex];
}
```

