### Q2. Factors sort
#### Problem Description
```text
You are given an array A of N elements. Sort the given array 
in increasing order of number of distinct factors of each 
element, i.e., element having the least number of factors 
should be the first to be displayed and the number having 
highest number of factors should be the last one. If 2 elements 
have same number of factors, then number with less value 
should come first.

Note: You cannot use any extra space
```
#### Problem Constraints
```text
1 <= N <= 10^4
1 <= A[i] <= 10^4
```
#### Input Format
```text
First argument A is an array of integers.
```
#### Output Format
```text
Return an array of integers.
```
#### Example Input
```text
Input 1:
 A = [6, 8, 9]

Input 2:
 A = [2, 4, 7]
```
#### Example Output
```text
Output 1:
 [9, 6, 8]

Output 2:
 [2, 7, 4]
```
#### Example Explanation
```text
For Input 1:
    The number 9 has 3 factors, 6 has 4 factors and 8 has 4 factors.

For Input 2:
    The number 2 has 2 factors, 7 has 2 factors and 4 has 3 factors.
```
### Hints
* Hint 1
```text
We can count the distinct number of factors of each element.
Then we will sort based on that
```
* Solution Approach
```text
We will count the distinct number of factors of each element.

Then we will sort the array using comparator function.

In the comparator function we will first calculate the number
of factors if each of the two numbers. If this count is equal, 
then the smaller number will come first. Otherwise, the number
with the least number of factors will come first.

Time Complexity : O(N*logN*√A[i])
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    Integer countFactors(Integer n){
        Integer count = 0;
        for(Integer i = 1 ; i * i <= n ; i++){
    		if(n % i == 0){
    			count++;
    			if(i * i != n){
    				count++;
    			}
    		}
    	}
        return count;
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A, new Comparator< Integer >(){
            @Override
            public int compare(Integer val1, Integer val2) {
                Integer count1 = countFactors(val1);
                Integer count2 = countFactors(val2);
                if(count1 == count2){
                    return val1 - val2;
                }
                return count1 - count2;
            }    
        });
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
int countFactors(int n){
    int count = 0;
    for(int i = 1 ; i * i <= n ; i++){
		if(n % i == 0){
			count++;
			if(i * i != n){
				count++;
			}
		}
	}
    return count;
}
bool compare(int val1, int val2){
	int count1 = countFactors(val1);
	int count2 = countFactors(val2);
    if (count1 == count2){
        return val1 <= val2;
	}
    return count1 < count2;
}
vector<int> Solution::solve(vector<int> &A) {
	sort(A.begin() , A.end() , compare);
	return A;
}
```

