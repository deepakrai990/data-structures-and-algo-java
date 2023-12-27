### Q4. Leaders in an array
#### Problem Description
```text
Given an integer array A containing N distinct integers, you 
have to find all the leaders in array A. An element is a 
leader if it is strictly greater than all the elements 
to its right side.

NOTE: The rightmost element is always a leader.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= N &lt;= 10<sup>5</sup><br>
    1 &lt;= A[i] &lt;= 10<sup>8</sup>
</div>

```text
1 <= N <= 10^5
1 <= A[i] <= 10^8
```
#### Input Format
```text
There is a single input argument which a integer array A
```
#### Output Format
```text
Return an integer array denoting all the **leader elements** of the array.

NOTE: Ordering in the output doesn't matter.
```
#### Example Input
```text
A = [16, 17, 4, 3, 5, 2]
```
#### Example Output
```text
 [17, 2, 5]
```
#### Example Explanation
```text
Element 17 is strictly greater than all the elements on the 
right side to it.

Element 2 is strictly greater than all the elements on the 
right side to it.

Element 5 is strictly greater than all the elements on the 
right side to it.

So we will return this three elements i.e [17, 2, 5], we can 
also return [2, 5, 17] or [5, 2, 17] or any other ordering.
```
### Hints
* Hint 1
```text
A leader element must be greater than all the elements on the right 
to it simply means the leader element must be greater than the 
maximum of all the elements on the right side of it.

Try to use the above fact and find a solution to the problem.
```
* Solution Approach
```text
Method 1: (Simple)

Use two loops. The outer loop runs from 0 to size – 1 and, one by one, 
picks all elements from left to the right. The inner loop compares 
the picked element to all the elements to its right side. If the 
picked element is greater than all the elements to its right side, 
then the picked element is the leader.

Time Complexity: O(N2)

Method 2: (Scan from right) Optimized Approach

Note that for an element to be greater than all the elements towards 
its right , it just needs to be greater than the maximum element 
towards its right.

Keep a variable ‘mx’ which stores the maximum till now and initialize 
it with the last element of the array and also add the last element 
to our answer array. Iterate from n-2 to 0 , at every index we check 
if that number is greater than the variable mx. If it is we add the 
element to our answer array and change mx to that variable.

Time Complexity: O(N)
Space Complexity: O(1)
```
* Complete Solution
```text
Solution approach:
Method 1: (Simple)

Use two loops. The outer loop runs from 0 to size – 1 and, one by one, 
picks all elements from left to the right. The inner loop compares 
the picked element to all the elements to its right side. If the 
picked element is greater than all the elements to its right side, 
then the picked element is the leader.
Time Complexity: O(N2)

Method 2: (Scan from right) Optimized Approach

Note that for an element to be greater than all the elements towards 
its right , it just needs to be greater than the maximum element 
towards its right.

Keep a variable ‘mx’ which stores the maximum till now and initialize 
it with the last element of the array and also add the last element 
to our answer array. Iterate from n-2 to 0 , at every index we check 
if that number is greater than the variable mx. If it is we add the 
element to our answer array and change mx to that variable.

Time Complexity: O(N)
Space Complexity: O(1)

Code:

def printLeaders(arr): 

    size=len(arr)
    ans=[]
    max_from_right = arr[size-1]    
    ans.append(max_from_right)     
    for i in range( size-2, -1, -1):         
        if max_from_right < arr[i]:             
            ans.append(arr[i])
            max_from_right = arr[i]
    return ans
```
