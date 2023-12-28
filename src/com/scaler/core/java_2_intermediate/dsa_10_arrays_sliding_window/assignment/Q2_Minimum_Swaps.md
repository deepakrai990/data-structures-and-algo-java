### Q2. Minimum Swaps
#### Problem Description
```text
Given an array of integers A and an integer B, find and return 
the minimum number of swaps required to bring all the numbers 
less than or equal to B together.

Note: It is possible to swap any two elements, not necessarily 
consecutive.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= length of the array &lt;= 100000<br>
    -10<sup>9</sup> &lt;= A[i], B &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= length of the array <= 100000
-10^9 <= A[i], B <= 10^9
```
#### Input Format
```text
The first argument given is the integer array A.
The second argument given is the integer B.
```
#### Output Format
```text
Return the minimum number of swaps.
```
#### Example Input
```text
Input 1:
 A = [1, 12, 10, 3, 14, 10, 5]
 B = 8

Input 2:
 A = [5, 17, 100, 11]
 B = 20
```
#### Example Output
```text
Output 1:
 2

Output 2:
 1
```
#### Example Explanation
```text
Explanation 1:
     A = [1, 12, 10, 3, 14, 10, 5]
     
     After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
     
     After swapping  the first occurrence of 10 
     and 5, A => [1, 3, 5, 12, 14, 10, 10].
     
     Now, all elements less than or equal to 8 are together.

Explanation 2:
     A = [5, 17, 100, 11]
     
     After swapping 100 and 11, A => [5, 17, 11, 100].
     
     Now, all elements less than or equal to 20 are together.
```
### Hints
* Hint 1
```text
Can you find the minimum number of swaps required to 
make all elements <= B together irrespective of 
the position of elements?
```
* Solution Approach
```text
First, we will find the number of elements that are less than 
or equal to B. Let the count comes out to be X.

We know that we need at most X-1 swaps to make all X elements 
to be consecutive.

Maintain a window of X and check how many elements we need 
to swap so that all X elements come in that window.

We store the minimum of all that and return that.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int cnt = 0;
        // count number of elements <= B
        for(int x : A)  
            if(x <= B)  
                cnt++;
        // If there is only one element, No need to swap
        if(cnt <= 1)    
            return 0;
        else {
            int l = 0, r = 0, x = 0;
            // Find the count of elements <= B in every window of length cnt using two
            //pointer approach
            while(r < cnt) {
                if(A[r] > B)    
                    x++;
                r++;
            }
            int ans = x;
            while(r < n) {
                if(A[r] > B)   
                    x++;
                if(A[l] > B)    
                    x--;
                ans = Math.min(ans, x);
                r++;    
                l++;
            }
            return ans;
        }
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    solve: function (A, B) {
        let n = A.length;
        let cnt = 0;
        // count number of elements <= B
        A.forEach((x) => {
          cnt += x <= B;
        });
        if (cnt <= 1) return 0;
        else {
            let l = 0, r = 0, x = 0;
            // find the number of swaps required for each window of size cnt
            while (r < cnt) {
                if (A[r] > B) 
                    x++;
                r++;
            }
            let ans = x;
            while (r < n) {
                if (A[r] > B) 
                    x++;
                if (A[l] > B) 
                    x--;
                ans = Math.min(ans, x);
                r++;
                l++;
            }
            return ans;
        }
    },
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A, int B) {
    int n = A.size();
    int cnt = 0;
    // count of elements less than or equal to B
    for(int x : A){
        if(x <= B)
            cnt++;
    }        
    if(cnt <= 1)
        return 0;
    else{
        int l = 0, r = 0, x = 0;
        while(r < cnt) {
            if(A[r] > B)
                x++;
            r++;
        }
        int ans = x;
        // find the number of swaps required for each window of size cnt
        while(r < n) {
            if(A[r] > B)    
                x++;
            if(A[l] > B)    
                x--;
            ans = min(ans, x);
            r++;   
            l++;
        }
        return ans;
    }
}
```

