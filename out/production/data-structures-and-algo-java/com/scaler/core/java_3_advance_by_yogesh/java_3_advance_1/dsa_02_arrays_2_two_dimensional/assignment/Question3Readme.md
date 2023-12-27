### Q3. Search in a row wise and column wise sorted matrix
#### Problem Description
```text
Given a matrix of integers A of size N x M and an integer B.
In the given matrix every row and column is sorted in non-decreasing order. Find and return the position of B in the matrix in the given form:
    
    If A[i][j] = B then return (i * 1009 + j)
    
    If B is not present return -1.
    
Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
Note 3: Expected time complexity is linear
Note 4: Use 1-based indexing
```
#### Problem Constraints
```text
1 <= N, M <= 1000
-100000 <= A[i] <= 100000
-100000 <= B <= 100000
```
#### Input Format
```text
The first argument given is the integer matrix A.
The second argument given is the integer B.
```
#### Output Format
```text
Return the position of B and if it is not present in A return -1 instead.
```
#### Example Input
```text
Input 1:-
A = [[1, 2, 3]
     [4, 5, 6]
     [7, 8, 9]]
B = 2

Input 2:-
A = [[1, 2]
     [3, 3]]
B = 3
```
#### Example Output
```text
Output 1:-
 1011

Output 2:-
 2019
```
#### Example Explanation
```text
Expanation 1:-
 
 A[1][2] = 2
 1 * 1009 + 2 = 1011

Explanation 2:-
 A[2][1] = 3
 2 * 1009 + 1 = 2019
 A[2][2] = 3
 2 * 1009 + 2 = 2020
 The minimum value is 2019
```
### Hints
* Hint 1
```text
For a cell, all cells to its right or bottom are greater than
or equal to the value of that cell and all cells to the top or
left are less than or equal to that cell value.
```
* Solution Approach
```text
We search traversing from the top right corner of the matrix.
1) Check if the current element is greater than B,
then exclude the current column and move to the left column.
2) Check if the current element is less than B, then exclude the 
current row and move to the bottom row.
3) If the current element if equal to B, then the final answer will
be due to the leftmost occurence of B in the current row.

Time Complexity : O(N + M)
Space Complexity : O(1)
```
* Complete Solution
```java
```

