### Q2. Add One To Number
#### Problem Description
```text
Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :
```

* Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
* A: For the purpose of this question, YES
* Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
* A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

#### Problem Constraints
```text
1 <= size of the array <= 1000000
```
#### Input Format
```text
First argument is an array of digits.
```
#### Output Format
```text
Return the array of digits after adding one.
```
#### Example Input
```text
Input 1:
[1, 2, 3]
```
#### Example Output
```text
Output 1:
[1, 2, 4]
```
#### Example Explanation
```text
Explanation 1:

Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.
```
### Hints
* Hint 1
```text
First, convince yourself that constructing numbers and then adding 1 will not work.
The number of digits can be really high ( Imagine 1000 - 10000 digits ).

Now, let’s look at how we will add 1.
Try to think of how you would add 1 on paper. Start from the last digit, and maintain carry.
```
* Hint 2
```text
There are 2 cases with adding one.
```
#### Case 1:
```text
The number of digits after adding 1 remains the same.

This is the easy case. Simulate the mathematical process of adding 
one maintaining carry from the digit.
```
#### Case 2
```text
The number of digits increases by 1 when adding.

This causes some complications as you would have to shift all digits 
by 1 to make space for the new digit in the most significant position.
```
* Tip:
```text
Try reversing the digits for the addition. Reverse them back after getting the result.
```
* Solution Approach
```text
Reverse the digits of the number to make your life easier.

Maintain a carry which is initialized to 1 ( Denoting that we need to add one to the number ).
Run a loop on the digit array ( which is now reversed ), and add carry to the current digit. If the digit D exceeds 10 on doing so, store the last digit in current position ( D % 10 ), and make carry = rest of the digits ( D / 10 ). Continue the process till you have covered all the digits.
Now if at the end, carry = 0, we are done, and we can return the array.

If not, we need to add one more digit, with carry in it.
```
* * Solution in Java
```java
public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int carry = 1;
        int num;
        int size = A.size();
        // traversing the digits of the number in reverse order
        for (int i = size - 1; i >= 0; i--) {
            num = A.get(i);
            num += carry;
            carry = 0;
            if (num == 10) {
                num = 0;
                carry = 1;
            }
            A.set(i, num);
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (carry == 1) 
            res.add(1);
        for (int x : A) {
            if (x == 0 && res.size() == 0) 
                continue;
            res.add(x);
        }
        return res;
    }
}
```
* * Solution in Javascript
```javascript
module.exports = { 
    //param a : array of integers
    //return a list of integers
	plusOne : function(a){
	    var b = [];
	    a.forEach( function( i ) { if( i ) b.push( i ); } );
	    var i = a.length;
	    var carry = 1;
	    
	    // traversing the digits of the number in reverse order
	    while( --i >= 0 ) {
	        var prev = +a[i];
	        b[i] = +a[i] + carry;
	        b[i] = b[i] % 10;
	        if( b[i] < prev )
	            carry = 1;
	        else 
	            carry = 0;
	    }
	    
	    if( carry )
	        b.unshift( 1 );
	    while( b[0] === 0 ) b.shift();
	    
	    return b;
	}
};
```

* * Solution in C++
```cpp
vector<int> Solution::plusOne(vector<int> &A) {
    // reversing the digits of the number
    reverse(A.begin(), A.end());
    vector<int> ans;
    int carry = 1;
    // traverse each digit of the number
    for (int i = 0; i < A.size(); i++) {
        int sum = A[i] + carry;
        ans.push_back(sum % 10);
        carry = sum / 10;
    }
    while (carry) {
        ans.push_back(carry % 10);
        carry /= 10;
    }
    while (ans[ans.size() - 1] == 0 && ans.size() > 1) {
        // removing leading zeroes from the final answer
        ans.pop_back();
    }
    reverse(ans.begin(), ans.end());
    return ans;
}
```

* * Solution in Javascript
```javascript
```

* * Solution in C++
```cpp
```
