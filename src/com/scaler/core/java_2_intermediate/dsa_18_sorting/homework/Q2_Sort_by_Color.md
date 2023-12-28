### Q2. Sort by Color
#### Problem Description
```text
Given an array with N objects colored red, white, or blue, sort 
them so that objects of the same color are adjacent, with the 
colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent red, white, 
and blue, respectively.

Note: Using the library sort function is not allowed.
```
#### Problem Constraints
```text
1 <= N <= 1000000
0 <= A[i] <= 2
```
#### Input Format
```text
First and only argument of input contains an integer array A.
```
#### Output Format
```text
Return an integer array in asked order
```
#### Example Input
```text
Input 1 :
 A = [0 1 2 0 1 2]

Input 2:
 A = [0]
```
#### Example Output
```text
Output 1:
 [0 0 1 1 2 2]

Output 2:
 [0]
```
#### Example Explanation
```text
Explanation 1:
    [0 0 1 1 2 2] is the required order.
```
### Hints
* Hint 1
```text
Numbers in the array can only be 0, 1, or 2. How can this be helpful?
```
* Solution Approach
```text
There are multiple approaches possible here. We need to make sure 
we do not allocate extra memory.

Approach 1:

Count the number of red, white, and blue balls.

Then, in another pass, set the initial redCount number of 
cells as 0, next whiteCount cell as 1, and 
next blueCount cells as 2.

Requires two passes of the array.

Approach 2:

Swap the 0s to the start of the array maintaining a pointer, and 2s to 
the end of the array.

1s will automatically be in their right position.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        int zero = 0;
        int two = A.size() - 1;

        for (int i = 0; i <= two; ) {
            if (A.get(i) == 0) {
                int temp = A.get(zero);
                A.set(zero, 0);
                A.set(i, temp);
                zero++;
                i++;
            } else if (A.get(i) == 2) {
                int temp = A.get(two);
                A.set(two, 2);
                A.set(i, temp);
                two--;
            } else {
                i++;
            }
        }
        return A;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers 
    //return a array of integers 
    sortColors: function (A) {
        let one = 0;
        let two = 0;
        let zero = 0;
        let counter = 0;
        for (const iterator of A) {
            if (iterator == 0) {
                zero++;

            } else if (iterator == 1) {
                one++;

            } else {
                two++;

            }
        }
        while (zero) {
            A[counter] = 0;
            counter++;
            zero--;
        }
        while (one) {
            A[counter] = 1;
            counter++;
            one--;
        }
        while (two) {
            A[counter] = 2;
            counter++;
            two--;
        }
        return A;
    }
};
```
* * Solution in C++
```cpp
vector<int> Solution::sortColors(vector<int> &A)  {     
    int n = A.size(); 
    int k = n - 1;
    int i = 0;
    for (; i < n; ++i)
    {
        if (A[i] != 0)
        {
            break;
        }
    }

    int j = i;
    for (; i <= k; ++i)
    {
        if (A[i] == 0)
        {
            swap(A[j++], A[i]);
        }
        else if (A[i] == 2)
        {
            swap(A[i--], A[k--]);
        }
    }
    return A;
}
```

