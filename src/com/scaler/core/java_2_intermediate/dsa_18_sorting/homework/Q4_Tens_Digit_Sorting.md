### Q4. Tens Digit Sorting
#### Problem Description
```text
Given an array A of N integers. Sort the array in increasing 
order of the value at the tens place digit of every number.

    * If a number has no tens digit, we can assume value to be 0.
    
    * If 2 numbers have same tens digit, in that case number with 
      max value will come first
    
    * Solution should be based on comparator.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i] &lt;= 10<sup>9</sup></p>
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
Return the array after sorting
```
#### Example Input
```text
Input 1:
 A = [15, 11, 7, 19]

Input 2:
 A = [2, 24, 22, 19]
```
#### Example Output
```text
Output 1:
 [7, 19, 15, 11]

Output 2:
 [2, 19, 24, 22]
```
#### Example Explanation
```text
For Input 1:
    The sorted order is [7, 19, 15, 11]. The tens digit of 7 is 0, 
    and that of 19, 15 and 11 is 1.

For Input 2:
    The sorted order is [2, 19, 24, 22]. The tens digit of 2 is 0, 
    that of 19 is 1 and that of 22 and 24 is 2.
```
### Hints
* Hint 1
```text
We can find the tens digit of each element by dividing by 10 and
then finding the mod of 10 of that value.

Then we will sort based on that.
```
* Solution Approach
```text
We will find the tens digit of each element by dividing by 
10 and then finding the mod of 10 of that value.

Then we will sort the array using comparator function.

In the comparator function we will first find the tens digit
of the two numbers. If this digit is equal, then the larger number 
will come first. Otherwise, the number with the least tens digit 
will come first.

Time Complexity : O(N*logN)
Space Complexity : O(1)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A, new Comparator< Integer >() {
            @Override
            public int compare(Integer val1, Integer val2) {
                Integer tens_digit1 = (val1 / 10) % 10;
                Integer tens_digit2 = (val2 / 10) % 10;
                if (tens_digit1 == tens_digit2) {
                    return val2 - val1;
            	}
                return tens_digit1 - tens_digit2;
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
bool compare(int val1, int val2){
	int tens_digit1 = (val1 / 10 ) % 10;
	int tens_digit2 = (val2 / 10 ) % 10;

    if (tens_digit1 == tens_digit2){
        return val1 >= val2;
	}

    return tens_digit1 < tens_digit2;
}
vector<int> Solution::solve(vector<int> &A) {
	sort(A.begin() , A.end() , compare);
	return A;
}

```

