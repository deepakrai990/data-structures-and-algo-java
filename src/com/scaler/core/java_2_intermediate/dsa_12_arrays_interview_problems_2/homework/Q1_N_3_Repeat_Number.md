### Q1. N/3 Repeat Number
#### Problem Description
```text
You're given a read-only array of N integers. Find out if any 
integer occurs more than N/3 times in the array in linear time 
and constant additional space.

If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    1 &lt;= N &lt;= 7*10<sup>5</sup><br>
    1 &lt;= A[i] &lt;= 10<sup>9</sup>
</div>

```text
1 <= N <= 7*10^5
1 <= A[i] <= 10^9
```
#### Input Format
```text
The only argument is an integer array A.
```
#### Output Format
```text
Return an integer.
```
#### Example Input
```text
Input 1:
 [1 2 3 1 1]
```
#### Example Output
```text
Output 1:
 1
```
#### Example Explanation
```text
Explanation 1:
    1 occurs 3 times which is more than 5/3 times.
```
### Hints
* Hint 1
```text
It works to simply pick all elements one by one. For every picked 
element, count its occurrences by traversing the array.

If the count becomes more than n/3, then print the element. 
Time Complexity of this method would be O(n^2).

A better solution is to use sorting.

First, sort all elements using an O(n Log n) algorithm. All required 
elements in a linear array scan can be found once the array is sorted.

So overall, time complexity of this method 
is O(n Log n) + O(n) which is O(n Log n).

However, a linear solution is needed here.

Note: if at any instance, you have three distinct elements 
from the array, if you remove them from the array, your answer 
does not change.

Try to base your solution idea on the above fact.

Would it help to maintain two elements from the array with their 
count as you traversed the array?
```
* Solution Approach
```text
It is important to note that if at a given time, you have 3 
distinct element from the array, if you remove them from 
the array, your answer does not change.

Assume that we maintain 2 elements’ counts as we traverse 
along the array.

When we encounter a new element, there are 3 cases possible :

    * We don’t have 2 elements yet. So add this to the list with count as 1.

    * This element is different from the existing 2 elements. As we 
      said before, we have 3 distinct numbers now. Removing them does 
      not change the answer. So decrement 1 from count of 2 existing 
      elements. If their count falls to 0, obviously its not a part 
      of 2 elements anymore.

    * The new element is same as one of the 2 elements. Increment 
      the count of that element.

Consequently, the answer will be one of the 2 elements left 
behind. If they are not the answer, there is no element with count > N / 3.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int repeatedNumber(int[] A) {
        int n = A.length;
        int count1 = 0, count2 = 0;
        int first =  Integer.MIN_VALUE;
        int second = Integer.MAX_VALUE;
     
        for (int i = 0; i < n; i++) {
            if (first == A[i])
                count1++;
            else if (second == A[i])
                count2++;
            else if (count1 == 0) {
                count1++;
                first = A[i];
            }
            else if (count2 == 0) {
                count2++;
                second = A[i];
            } else {
                count1--;
                count2--;
            }
        }
     
        count1 = 0;
        count2 = 0;
     
        for (int i = 0; i < n; i++) {
            if (A[i] == first)
                count1++;
            else if (A[i] == second)
                count2++;
        }
     
        if (count1 > n / 3)
            return first;
     
        if (count2 > n / 3)
            return second;
     
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
        let num = 0;
        let temp = [...A]
    	let n = temp.length;
        temp.sort();
        for (let i = 0; i < n;) {
            let freq = 0;
            num = temp[i];
            while (i < n && temp[i] === num) {
                freq += 1
                i += 1
            }
            if (freq * 3 > n)
                return num;
            
        }
        return -1;
    }
};
```
* * Solution in C++
```cpp
int Solution::repeatedNumber(const vector < int > & A) {
    if (A.size() == 0) 
        return -1;
    vector<pair<int, int>>temp(2);
    temp[0].second = temp[1].second = 0;
    for (int i = 0; i < A.size(); i++) {
        int j;
        if (temp[0].first == A[i] || temp[1].first == A[i]) {
            if (temp[0].first == A[i]) temp[0].second += 1;
            else temp[1].second += 1;
        } else {
            int l;
            if (temp[0].second == 0 || temp[1].second == 0) {
                int index = (temp[0].second == 0) ? 0 : 1;
                temp[index].first = A[i];
                temp[index].second = 1;
            } else {
                temp[0].second -= 1;
                temp[1].second -= 1;
            }
        }
    }
    for (int i = 0; i < 2; i++) {
        int ac = 0; // actual count
        for (int j = 0; j < A.size(); j++)
            if (A[j] == temp[i].first)
                ac++;
        if (ac > A.size() / 3) return temp[i].first;
    }
    return -1;
}
```

