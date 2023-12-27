### Q3. Rearrange Array
#### Problem Description
```text
Given an array A of size N. Rearrange the given array 
so that A[i] becomes A[A[i]] with O(1) extra space.
```
#### Problem Constraints
* <p>1 &lt;= N &lt;= 5×10<sup>4</sup></p>
* <p>0 &lt;= A[i] &lt;= N - 1</p>
```text
1 <= N <= 5×10^4

0 <= A[i] <= N - 1

The elements of A are distinct
```
#### Input Format
```text
The argument A is an array of integers
```
#### Output Format
```text

```
#### Example Input
```text
Input 1
 [1, 0]

Input 2
[0, 2, 1, 3]
```
#### Example Output
```text
Output 1 
 [0, 1]

Output 2
 [0, 1, 2, 3]
```
#### Example Explanation
```text

```
### Hints
* Hint 1
```text
You will need a copy of older version but you 
cant use extra space.

Can you think of something so that we can extract more 
than one entries from existing numbers.

Encoding two numbers into one?
```
* Solution Approach
```text
If you had extra space to do it, the problem will be very easy.
Store a copy of Arr in B.

And then for every element, do Arr[i] = B[B[i]]

Lets restate what we just said for extra space :

If we could somehow store 2 numbers in every index ( that 
is, Arr[i] can contain the old value and the new 
value somehow ), then the problem becomes very easy.

NewValue of Arr[i] = OldValue of Arr[OldValue of Arr[i]]

Now, we will do a slight trick to encode 2 numbers in one index.
This trick assumes that N * N does not overflow.

1) Increase every Array element Arr[i] by (Arr[Arr[i]] % n)*n.
2) Divide every element by N.
Given a number as

   A = B + C * N   if ( B, C < N )
   A % N = B
   A / N = C
We use this fact to encode 2 numbers into each element of Arr.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
	public void arrange(ArrayList<Integer> A) {
   	    int n = A.size();
	    for (int i = 0; i < n; i++) A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n );
	    for (int i = 0; i < n; i++) A.set(i, A.get(i) / n);
	}
}
```
* * Solution in Javascript
```javascript
module.exports = { 
    //param a : array of integers
    // return nothing
	arrange : function(a){
        var len = a.length;
        for(var i= 0;i < len;i++){
          a[i] = parseInt(a[i]) + (a[a[i]] % len) * len;
        }
        
        for(var j = 0; j < len ; j++){
          a[j] = Math.floor(a[j]/ len);
        }
        
	}
};
```
* * Solution in C++
```cpp
void Solution::arrange(vector<int> &A) {
    int N = A.size();
    for(int i = 0; i < N; ++i) {
        A[i] = A[i] + (A[A[i]] % N) * N;
    }
    for(int i = 0; i < N; ++i) {
        A[i] = A[i] / N;
    }
}
```

