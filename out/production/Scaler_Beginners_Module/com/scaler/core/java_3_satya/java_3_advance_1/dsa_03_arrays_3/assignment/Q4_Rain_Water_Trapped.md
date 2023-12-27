### Q4. Rain Water Trapped
#### Problem Description
```text
Given a vector A of non-negative integers representing 
an elevation map where the width of each bar is 1, compute 
how much water it is able to trap after raining.
```
#### Problem Constraints
```text
1 <= |A| <= 100000
```
#### Input Format
```text
First and only argument is the vector A
```
#### Output Format
```text
Return one integer, the answer to the question
```
#### Example Input
```text
Input 1:
 A = [0, 1, 0, 2]

Input 2:
A = [1, 2]
```
#### Example Output
```text
Output 1:
 1

Output 2:
 0
```
#### Example Explanation
```text
Explanation 1:
 1 unit is trapped on top of the 3rd element.

Explanation 2:
 No water is trapped.
```
### Hints
* Hint 1
```text
Take a close look at any particular bin. How high can 
this hold water? If you can compute the answer to 
the above question for every bin, you are done.

Every bin will store water which will depend on 
some prefix and suffix quantity. Can you 
figure it out now?
```
* Solution Approach
```text
Instead of calculating area by height*width, we can think it 
in a cumulative way.
In other words, we can sum the water amount of each bin(width=1).

Approach 1

We can keep 2 arrays ‘pre’ and ‘suf’. pre[i] is the maximum 
height for all i from 0 to i and suf[i] is the maximum 
height for all i from i to n-1.
Now for each i from 1 to n-2 (as no water can be stored at 
indexes 0 and 1) just add the maximum amount water that 
can be stored. The maximum amount of water that can be 
stored is the minimum of(max height towards left of i, max 
height towards right of i)-A[i]

i.e. min(pre[i-1],suf[i+1])-A[i]. 
But if min(pre[i-1],suf[i+1])-A[i] < 0 
we dont add anything. (i.e we add 0)

Time Complexity : O(n)
Auxiliary Space : O(n)

Can we do better than this? Is there way by which we can 
improve its auxiliary space?

Approach 2 (Most Efficient)

We can use the concept of two pointers.
Search from left to right and maintain a max height of left 
and right separately, which is like a one-side wall of a 
partial container. Fix the higher one and flow water
from the lower part. For example, if the current height 
of the left is lower, we fill water in the left bin. Until 
the left meets right, we filled the whole container.

We will follow the below steps:

1) Maintain two variables ‘left’ and ‘right’ (‘left’ denotes 
    the left pointer and ‘right’ denotes the right pointer) 
    and initialize it to 0 and n-1 respectively.

2) Also maintain two variables ‘left-max’ 
    and ‘right-max’ (‘left-max’ denotes the maximum 
    height till ‘left’ ( i.e. from 0 to left) 
    and ‘right-max’ denotes the maximum height 
    till ‘right’(i.e. from right to n-1) ) and 
    initialize both of them to 0.

3) while left <= right we have two possible conditions
```
```text
Condition 1: left-max <= right-max
For the element at index left , we have already traversed 
from 0 to left , therefore left-max is known. 
But right-max of left'th index is not known. We only know 
the right-max for right.

But we know that right-max can only get bigger from right 
to left,and we already know that left-max <= right-max,  
therefore left-max of left <= right-max of left. 
Now we can simply add left-max-A[left] , if this quantity is positive
otherwise change left-max to A[left].
Increment left.

Condition 2: left-max > right-max
For the element at index right , we have already traversed 
from n-1 to right , therefore right-max is known. 
But left-max of right'th index is not known. We only know 
the left-max for left.

But we know that left-max can only get bigger from left 
to right, and we already know that left-max >right-max,  
therefore right-max of right < left-max of right. 
Now we can simply add right-max-A[right] , if this quantity 
is positive otherwise change right-max to A[right].
decrement right
```
```text
Time Complexity : O(n)
Auxiliary Spcae : O(1)
```
* Complete Solution
```java
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {
        int n = A.length;
        int left = 0; 
        int right = n - 1;
        int res = 0;
        int maxleft = 0, maxright = 0;
        while(left <= right){ 
            // When height of left side is lower, calculate height of water trapped in left bin else calculate for right bin
            if(A[left] <= A[right]){
                if(A[left] >= maxleft) 
                    maxleft = A[left]; //This index wont store any water as there is no index towards the left whose height is greater than this.
                else 
                    res += maxleft - A[left];
                left++;
            }
            else{
                if(A[right] >= maxright) 
                    maxright = A[right]; //This index wont store any water as there is no index towards the right whose height is greater than this.
                else 
                    res += maxright - A[right];
                right--;
            }
        }
        return res;
    }
}
```

```javascript
module.exports = { 
 //param A : array of integers
 //return an integer
	trap : function(A){
        let n = A.length;
        let left = 0, right = n - 1;
        let res = 0;
        let maxleft = 0, maxright = 0;
        while(left <= right){ 
            // When height of left side is lower, calculate height of water trapped in left bin else calculate for right bin
            if(A[left] <= A[right]){
                if(A[left] >= maxleft) 
                    maxleft = A[left]; //This index wont store any water as there is no index towards the left whose height is greater than this.
                else 
                    res += maxleft - A[left];
                left++;
            }
            else{
                if(A[right] >= maxright) 
                    maxright = A[right]; //This index wont store any water as there is no index towards the right whose height is greater than this.
                else 
                    res += maxright - A[right];
                right--;
            }
        }
        return res;
	}
};
```

```cpp
int Solution::trap(const vector < int > & A) {
    int n = A.size();
    int left = 0;
    int right = n - 1;
    int res = 0;
    int maxleft = 0, maxright = 0;
    while (left <= right) {
        if (A[left] <= A[right]) {
            if (A[left] >= maxleft)
                maxleft = A[left]; //This index wont store any water as there is no index towards the left whose height is greater than this.
            else
                res += maxleft - A[left];
            left++;
        } else {
            if (A[right] >= maxright)
                maxright = A[right]; //This index wont store any water as there is no index towards the right whose height is greater than this.
            else
                res += maxright - A[right];
            right--;
        }
    }
    return res;
}
```

