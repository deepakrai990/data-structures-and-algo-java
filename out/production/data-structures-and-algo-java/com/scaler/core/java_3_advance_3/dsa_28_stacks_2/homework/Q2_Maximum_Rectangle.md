### Q2. Maximum Rectangle
#### Problem Description
```text
Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.

Find the largest rectangle containing only 1's and return its area.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.
```
#### Problem Constraints
```text
1 <= N, M <= 1000
0 <= A[i] <= 1
```
#### Input Format
```text
The only argument given is the integer matrix A.
```
#### Output Format
```text
Return the area of the largest rectangle containing only 1's.
```
#### Example Input
```text
Input 1:
    A = [   [0, 0, 1]
            [0, 1, 1]
            [1, 1, 1]   ]
            
Input 2:
    A = [   [0, 1, 0, 1]
            [1, 0, 1, 0]    ]
```
#### Example Output
```text
Output 1:
    4
    
Output 2:
    1
```
#### Example Explanation
```text

```
### Hints
* Hint 1
```text

```
* Solution Approach
```text

```
* Complete Solution
* * Solution in Java
```java
public class Solution {
	public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
	    
	    if (A == null || A.size() == 0)
	        return 0;
	    
	    int m, n;
	    int i, j;
	    
	    m = A.size();
	    n = A.get(0).size();
	    
	    int count[][];
	    count = new int[m][n];
	    
	    for (i = 0; i < m; i++) {
	        for (j = 0; j < n; j++) {
	            if (i == 0) {
	                count[i][j] = A.get(i).get(j);
	            } else {
	                count[i][j] = A.get(i).get(j) == 0 ? 0 : count[i - 1][j] + 1;
	            }
	        }
	    }
	    int res = 0;
	    for (i = 0; i < m; i++) {
	        res = Math.max(res, maxRect(count[i]));
	    }
	    return res;
	}
	
	public int maxRect(int [] histogram) {
	    int n;
	    int res = 0;
	    int prevMin[];
	    int nextMin[];
	    int num;
	    Stack<Integer> stack;
	    
	    n = histogram.length;
	    prevMin = new int[n];
	    nextMin = new int[n];
	    
	    stack = new Stack<Integer>();
	    
	    prevMin[0] = -1;
	    stack.push(0);
	    for (int i = 1; i < n; i++) {
	        num = histogram[i];
	        while (!stack.isEmpty() && num <= histogram[stack.peek()]) {
	            stack.pop();
	        }
	        prevMin[i] = -1;
	        if (!stack.isEmpty()) {
	            prevMin[i] = stack.peek();
	        }
	        stack.push(i);
	    }
        
	    nextMin[n - 1] = n;
	    stack.clear();
	    stack.push(n - 1);
	    for (int i = n - 2; i >= 0; i--) {
	        num = histogram[i];
	        while (!stack.isEmpty() && num <= histogram[stack.peek()]) {
	            stack.pop();
	        }
	        nextMin[i] = n;
	        if (!stack.isEmpty())
	            nextMin[i] = stack.peek();
	        stack.push(i);
	    }
	    for (int i = 0; i < n; i++) {
	        int left = prevMin[i] + 1;
	        int right = nextMin[i] - 1;
	        res = Math.max(res, histogram[i] * (right - left + 1));
	    }
	    return res;
	}
}
```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp
int largest_rectangle(vector<int>hist)
    {
        //print_hist(hist);
        int top, max_area =-1, area,i;
        stack<int>st;//store index
        for(i = 0; i < hist.size(); i++)
        {
            if(st.empty() || hist[st.top()] <= hist[i])
                st.push(i);
            else
            {//upto stack becomes empty or current value >= stack top value
                while(!st.empty() && hist[i] < hist[st.top()])
                {
                    top = st.top();
                    st.pop();
                    if(st.empty())
                        area = hist[top] * i;//when stack empty
                    else
                        area = hist[top] * (i - st.top() -1);
                    max_area = max_area > area ? max_area : area ;
                }
                st.push(i); //current index
            }

        }
        //same as above code
        while(!st.empty())
        {
            top = st.top();
            st.pop();
            if(st.empty())
                area = hist[top] * i;
            else
                area = hist[top] * (i - st.top() -1);
            max_area = max_area > area ? max_area : area;
        }
        //cout<<max_area<<endl;
        return max_area;
    }

int maximalRectangle(vector<vector<int>>& matrix) {
        if(matrix.size() == 0)
            return 0;
        int row = matrix.size(),col=matrix[0].size(),flag=0;
        //cout<<row<<" "<<col<<endl;
        if(row > col)
        {
            swap(row,col);
            flag=1;
        }
        //cout<<row<<" "<<col<<endl;
        int i,j,max_area=0;
        vector<int>hist(col,0);
        for(i = 0; i < row; i++)
        {
            for(j = 0; j < col; j++)
            {
                char c;
                if(flag)
                    c= matrix[j][i]; //if row > col
                else
                    c = matrix[i][j];
                //cout<<c<<' ';
                hist[j] = (c ==0) ? 0 : hist[j]+1;
            }
            //cout<<endl;
            max_area = max(max_area, largest_rectangle(hist));
//            print_hist(hist);
        }
        return max_area;
    }

int Solution::solve(vector<vector<int> > &A) {
    return maximalRectangle(A);
}
```

