### Q1. Noble Integer
#### Problem Description
```text
Given an integer array A, find if an integer p exists in the array 
such that the number of integers greater than p in 
the array equals p.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= |A| &lt;= 2*10<sup>5</sup><br>
    -10<sup>8</sup> &lt;= A[i] &lt;= 10<sup>8</sup>
</div>

```text
1 <= |A| <= 2*10^5
-10^8 <= A[i] <= 10^8
```
#### Input Format
```text
First and only argument is an integer array A.
```
#### Output Format
```text
Return 1 if any such integer p is present else, return -1.
```
#### Example Input
```text
Input 1:
 A = [3, 2, 1, 3]

Input 2:
 A = [1, 1, 3, 3]
```
#### Example Output
```text
Output 1:
 1

Output 2:
 -1
```
#### Example Explanation
```text
Explanation 1:
    For integer 2, there are 2 greater elements in the array..

Explanation 2:
    There exist no integer satisfying the required conditions.
```
### Hints
* Hint 1
```text
The straightforward approach is to for every element find how many 
integers are greater than that.

And if that matches our given statement, then we have our answer.

Will sorting the array help?
```
* Solution Approach
```text
First, we sort the input array.

Now, all we have to do is to traverse through each element of the 
array and check whether it matches our given statement. 

Since the array is sorted, we directly know how many elements are 
greater than that number in the array.

**Note: Please take care of cases when a certain element 
repeats many times.**
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int size = A.size();
        for(int i = 0; i < size; i++){
        	while(i+1<size && A.get(i)==A.get(i+1))
        		i++;
        	if(A.get(i) == size-1-i)
        		return 1;
        }
        return -1;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of integers
 //return an integer
	solve : function(A){
	    A.sort();
	    let n = A.length;
	    for(let i = 0; i < n; i++ ) {
	        let j = i;
	        while(A[j] == A[i]) j++;
	        if(A[i] == n-j)
	            return 1;
	        i = j-1;
	    }
	    return -1;
	}
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A) {
	sort(A.begin(), A.end()) ;
	int size = A.size();
	for(int i = 0; i < size; i++){
		while(i+1<size && A[i]==A[i+1])
			i++;
		if(A[i] == size-1-i)
			return 1;
	}
	return -1;
}
```

