### Q6. B Closest Points to Origin
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>We have a list <strong>A</strong> of points <strong>(x, y)</strong> 
    on the plane. Find the <strong>B</strong> closest points to the origin 
    <strong>(0, 0)</strong>.</p>
    <p>Here, the distance between two points on a plane is the <strong>Euclidean 
    distance</strong>.</p>
    <p>You may return the answer in any order. The answer is guaranteed to 
    be unique (except for the order that it is in.)</p>
    <p><strong>NOTE:</strong> Euclidean distance between two points 
    <strong>P1(x1, y1)</strong> and <strong>P2(x2, y2)</strong> is 
    <strong>sqrt( (x1-x2)<sup>2</sup> + (y1-y2)<sup>2</sup> )</strong>.</p>
</div>

```text
We have a list A of points (x, y) on the plane. Find the B closest points to 
the origin (0, 0).

Here, the distance between two points on a plane is the Euclidean distance.

You may return the answer in any order. The answer is guaranteed to be 
unique (except for the order that it is in.)

NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is 
      sqrt( (x1-x2)^2 + (y1-y2)^2 ).
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= B &lt;= length of the list A &lt;= 10<sup>5</sup><br> 
    -10<sup>5</sup> &lt;= A[i][0] &lt;= 10<sup>5</sup><br> 
    -10<sup>5</sup> &lt;= A[i][1] &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= B <= length of the list A <= 10^5
-105 <= A[i][0] <= 10^5
-105 <= A[i][1] <= 105
```
#### Input Format
```text
The argument given is list A and an integer B.
```
#### Output Format
```text
Return the B closest points to the origin (0, 0) in any order.
```
#### Example Input
```text
Input 1:
 A = [ 
       [1, 3],
       [-2, 2] 
     ]
 B = 1

Input 2:
 A = [
       [1, -1],
       [2, -1]
     ] 
 B = 1
```
#### Example Output
```text
Output 1:
 [ [-2, 2] ]

Output 2:
 [ [1, -1] ]
```
#### Example Explanation
```text
Explanation 1:
    The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
    So one closest point will be [-2,2].

Explanation 2:
    The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
    So one closest point will be [1,-1].
```
### Hints
* Hint 1
```text
Think of calculating the Euclidean distance and storing it efficiently.
```
* Solution Approach
```text
Sort the list of these points with respect to the distance from the origin. 

We can do this with the help of a comparator function, which takes two elements 
of the array as input and returns which one will be smaller than the other. So 
basically, it takes care of the comparison process.

After the list is sorted, take the first B elements from the list and create a new 
list and return it. 

Think of calculating the Euclidean distance and storing it efficiently.

Time Complexity - O(N log N)
Space Complexity - O(N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        // sorts the list based on euclidean distance from origin
        Collections.sort(A, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                long d1 = (long) a.get(0) * a.get(0) + (long) a.get(1) * a.get(1);
                long d2 = (long) b.get(0) * b.get(0) + (long) b.get(1) * b.get(1);
                if (d1 < d2) return -1;
                else if (d2 < d1) return 1;
                else return 0;
            }
        });
        for (int i = 0; i < B; i++) {
            ans.add(A.get(i));
        }
        return ans;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
 //param A : array of array of integers
 //param B : integer
 //return a array of array of integers
	solve : function(A, B){
	    let ans = [];
	    
	    // sorts the list based on euclidean distance from origin
	    A.sort(function(a,b) {
	
	        let x1 = a[0];
	        let y1 = a[1];
	        let x2 = b[0];
	        let y2 = b[1];
	        
	        let dis1 = x1*x1 + y1*y1;
	        let dis2 = x2*x2 + y2*y2;
	        
	        return dis1 - dis2;
	    });
	    
	    for(let i = 0; i < B; i++) {
	        ans.push(A[i]);
	    }
	    return ans;
	}
};
```
* * Solution in C++
```cpp
bool cmp(vector < int > & a, vector < int > & b) {
    long d1 = (long) a[0] * a[0] + (long) a[1] * a[1];
    long d2 = (long) b[0] * b[0] + (long) b[1] * b[1];
    if (d1 < d2) 
        return true;
    return false;
}
vector < vector < int > > Solution::solve(vector < vector < int > > & A, int B) {
    vector < vector < int >> ans;
    // sorts the list based on euclidean distance from origin
    sort(A.begin(), A.end(), cmp);
    for (int i = 0; i < B; i++)
        ans.push_back(A[i]);
    return ans;
}
```

