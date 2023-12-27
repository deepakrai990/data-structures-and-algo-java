### Q7. Find Armstrong Numbers
#### Problem Description
```text
You are given an integer A. You need to print all the Armstrong 
Numbers between 1 to A.

If sum of cubes of each digit of the number is equal to the 
number itself, then the number is called an Armstrong number.

For example, 153 = ( 1 * 1 * 1 ) + ( 5 * 5 * 5 ) + ( 3 * 3 * 3 ).
```
#### Problem Constraints
```text
1 <= N <= 500
```
#### Input Format
```text
First and only argument is an integer A.
```
#### Output Format
```text
Return an integer array of all the Armstrong numbers in range [1,A].
```
#### Example Input
```text
Input 1:
 5

Input 2:
 200
```
#### Example Output
```text
Output 1:
 1

Output 2:
 [1, 153]
```
#### Example Explanation
```text
Explanation 1:
    1 is an armstrong number.

Explanation 2:
    1 and 153 are armstrong number under 200.
```
### Hints
* Hint 1
```text
Given range is very small so we can iterate for each number
in range and check whether it is armstrong or not.
```
* Solution Approach
```text
Given range is very small so we can iterate for each number in range 
and check whether it is armstrong or not.

For each number in range we can find sum of cube of its digits and 
can check whether it is armstrong or not.

Time Complexity : O(A)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList<Integer> solve(int A) {
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        for(int i = 1 ; i <= A ; i++){
            int temp = i, sum = 0;
            while(temp > 0){
                int dig = temp % 10;
                sum += (dig * dig * dig);
                temp /= 10;
            }
            if(sum == i){
                ans.add(i);
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
vector<int> Solution::solve(int A) {
    vector<int> ans;
	for(int i = 1 ; i <= A ; i++){
		int temp = i, sum = 0;
		while(temp > 0){
			int dig = temp % 10;
			sum += (dig * dig * dig);
			temp /= 10;
		}
		if(sum == i){
			ans.push_back(i);
		}
	}
	return ans;
}
```

