### Q7. Rotate Matrix
#### Problem Description
```text
You are given a n x n 2D matrix A representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note: If you end up using an additional array, you will 
only receive partial score.
```
#### Problem Constraints
```text
1 <= n <= 1000
```
#### Input Format
```text
First argument is a 2D matrix A of integers
```
#### Output Format
```text
Return the 2D rotated matrix.
```
#### Example Input
```text
Input 1:

 [
    [1, 2],
    [3, 4]
 ]

Input 2:

 [
    [1]
 ]
```
#### Example Output
```text
Output 1:

 [
    [3, 1],
    [4, 2]
 ]

Output 2:

 [
    [1]
 ]

```
#### Example Explanation
```text
Explanation 1:

     After rotating the matrix by 90 degree:
     1 goes to 2, 2 goes to 4
     4 goes to 3, 3 goes to 1

Explanation 2:

     2D array remains the ssame as there is only element.
```
### Hints
* Hint 1
```text
Let’s say our matrix is,

        * * * ^ * * *
        * * * | * * *
        * * * | * * *
        * * * | * * *

After rotating right, it appears (observe arrow direction)

        * * * *
        * * * *
        * * * *
        -- - - >
        * * * *
        * * * *
        * * * *

The idea is simple. Transform each row of the source matrix 
into the required column of the final matrix.

From the above picture, we can observe that.

first row of source ------> last column of destination
second row of source ------> last but-one column of destination
so ... on
last row of source ------> first column of destination

Thus, if we were allowed extra memory, the solution should be easy.

    result[j][matrix.size() - i - 1] = matrix[i][j];

Now that you know the basic relation, can you do it in 
place ( without using extra memory )?
```
* Solution Approach
```text
Doing things in place can be slightly trickier.

Note that if you create a graph with each cell as the vertex 
with an edge from the source cell to the destination cell, the 
graph ends up with cycles of length 4.

This means something like this should work:

Divide the array into 4 along the diagonals

Place each element in the top quadrant into the slot 90 degrees clockwise

Place the old 90 in 180 degrees clockwise

Place the old 180 in 270 degrees

Lastly, place the old 270 in the original place

It might be easier to understand the solution if a few examples 
are tried out by hand.

Let me elaborate on a 3x3 example. You can try more examples of other sizes.

Let’s say the array is

[ 
1 2 3
4 5 6
7 8 9 
]

After rotation by 90 degrees, it should be

[
7 4 1
8 5 2
9 6 3
]

Let’s say you were allowed extra space and not required to do things in place.

Easier approach:

If you notice, if you read out the column ‘i’ in reverse order, 
it corresponds to the new row ‘i’ in the resulting array. So, 
column 0 in the original array read out in reverse order is 7 4 1, 
which is row 0 in answer. And so on. So you just simulate this 
approach and keep creating the result in another 2 D array.

However, this approach requires additional space of O(n^2) 
where n = number of rows in a 2D array.

Now let’s say we have to do things in place ( no extra 
space allowed ). This implies that we have to make things 
work by just moving elements around with constant extra memory.

So, let’s try to observe where elements need to end up in the result array.

* 7 needs to end up in 1's position. 

* If 7 goes to 1's position, then we need to check where 1 needs 
  to go otherwise, value 1 will be lost. 1 needs to go to 3's position. 

* 3 needs to go to 9's position. 

* 9 needs to go to 7's position. 

* We already have placed 7 in 1's position. 
So when we move these 4 elements, all 4 elements are in their correct position.

Let’s look at 4 now.

4 -> 2 -> 6 -> 8. 

Again, a group of 4. So, we can move these elements group by group 
without requiring creating a copy of the array.

You can try a few more examples to convince yourself.

The code just tries to simulate what’s being discussed here.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public void solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
	    if (A == null || n == 0)
	        return;
	    int layers = n;
	    for (int layer = 0; layer < layers / 2; layer++) {
	        int first = layer;
	        int last = n - layer - 1;
	        for (int i = first; i < last; i++) {
	            // swapping the four elements cyclically
	            int offset = i - layer;
	            int top = A.get(first).get(i);
	            A.get(first).set(i, A.get(last - offset).get(first));
	            A.get(last - offset).set(first, A.get(last).get(last - offset));
	            A.get(last).set(last - offset, A.get(i).get(last));
	            A.get(i).set(last, top);
	        }
	    }
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of array of integers 
    //return nothing 
    solve: function (A) {
        // flip the matrix vertically
        A = A.reverse();
        // transpose the matrix
        for (let i = 0; i < A.length; i++) {
            for (let j = 0; j < i; j++) {
                let temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
    }
};
```
* * Solution in C++
```cpp
void Solution::solve(vector<vector<int> > &matrix) {
    int len = matrix.size();
    for (int i = 0; i < len / 2; i++) {
        for (int j = i; j < len - i - 1; j++) {
            // swapping the four elements cyclically
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[len - j - 1][i];
            matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
            matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
            matrix[j][len - i - 1] = tmp;
        }
    }
}
```

