### Q2. Sudoku
#### Problem Description
```text
Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are 
indicated by the character '.' You may assume that there will be only one unique solution.
```
![alt text](Q2_Sudoku_1.png)
```text
A sudoku puzzle,
```
![alt text](Q2_Sudoku_2.png)
```text
and its solution numbers marked in red.
```
#### Problem Constraints
```text
N = 9
```
#### Input Format
```text
First argument is an array of array of characters representing the Sudoku puzzle.
```
#### Output Format
```text
Modify the given input to the required answer.
```
#### Example Input
```text
Input 1:
 A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
```
#### Example Output
```text
Output 1:
 [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
```
#### Example Explanation
```text
Explanation 1:
    Look at the diagrams given in the question.
```
### Hints
* Hint 1
```text
Think about the most naive solution.

You can try filling any available position with any valid character and check if 
sudoku now can be solved.
```
* Solution Approach
```text
Classic backtrack problem.

Everytime you place an element x on row,col, you need to check if its still valid to 
put x on that position by double checking if x occurs more than once in the row or 
column or in its block. If not, you proceed by placing x, and call forward to check 
if a correct solution is possible with x in position row, col.

If a solution is possible, you return the current configuration and you are done. 
Otherwise you try other values.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    private int n;
    private ArrayList < ArrayList < Character >> A;
    private HashSet < Character > hashSet;
    public void solveSudoku(ArrayList < ArrayList < Character >> A) {
        n = A.size();
        this.A = A;
        hashSet = new HashSet < > ();
        backtrack(0, 0);
    }
    public boolean backtrack(int row, int col) {
        if (row == n)
            return true;
        char c = A.get(row).get(col);
        int rr, cc;
        rr = row;
        cc = col + 1;
        if (cc == n) {
            rr++;
            cc = 0;
        }
        if (c == '.') {
            for (char ch = '1'; ch <= '9'; ch++) {
                // Include ch in the solution 
                A.get(row).set(col, ch);
                if (isValid(row, col)) {
                    boolean status = backtrack(rr, cc);
                    if (status)
                        return true;
                }
                // Reset
                A.get(row).set(col, '.');
            }
        } else {
            return backtrack(rr, cc);
        }
        return false;
    }
    public boolean isValid(int row, int col) {
        hashSet.clear();
        char c;
        for (int i = 0; i < n; i++) {
            c = A.get(row).get(i);
            if (hashSet.contains(c))
                return false;
            if (c != '.')
                hashSet.add(c);
        }
        hashSet.clear();
        for (int i = 0; i < n; i++) {
            c = A.get(i).get(col);
            if (hashSet.contains(c))
                return false;
            if (c != '.')
                hashSet.add(c);
        }
        int sRow = (row / 3) * 3;
        int sCol = (col / 3) * 3;
        hashSet.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int rr = sRow + i;
                int cc = sCol + j;
                c = A.get(rr).get(cc);

                if (hashSet.contains(c))
                    return false;
                if (c != '.')
                    hashSet.add(c);
            }
        }
        return true;
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
int rowhash[9][9], colhash[9][9], blockhash[3][3][9];
bool solve(vector < vector < char > > & board, int position) {
    if (position >= 9 * 9) {
        return true;
    }
    int row = position / 9, col = position % 9;
    if (board[row][col] != '.') {
        return solve(board, position + 1);
    }
    for (int num = 0; num < 9; num++) {
        if (rowhash[row][num] != 1 && colhash[col][num] != 1 && blockhash[row / 3][col / 3][num] != 1) {
            // Include num in the solution 
            board[row][col] = '1' + num;
            rowhash[row][num] = 1;
            colhash[col][num] = 1;
            blockhash[row / 3][col / 3][num] = 1;
            if (solve(board, position + 1)) return true;
            // Reset
            board[row][col] = '.';
            rowhash[row][num] = 0;
            colhash[col][num] = 0;
            blockhash[row / 3][col / 3][num] = 0;
        }
    }
    return false;
}

void Solution::solveSudoku(vector<vector<char> > &A) {
    memset(rowhash, 0, sizeof(rowhash));
    memset(colhash, 0, sizeof(colhash));
    memset(blockhash, 0, sizeof(blockhash));
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (A[i][j] != '.') {
                int num = A[i][j] - '1';
                rowhash[i][num] = 1;
                colhash[j][num] = 1;
                blockhash[i / 3][j / 3][num] = 1;
            }
        }
    }
    solve(A, 0);
}
```

