### Q6. Reverse Bits
#### Problem Description
```text
Reverse the bits of an 32 bit unsigned integer A.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>0 &lt;= A &lt;= 2<sup>32</sup></p>
</div>

```text
0 <= A <= 2^32
```
#### Input Format
```text
First and only argument of input contains an integer A.
```
#### Output Format
```text
Return a single unsigned integer denoting the decimal value 
of reversed bits.
```
#### Example Input
```text
Input 1:
 0

Input 2:
 3
```
#### Example Output
```text
Output 1:
 0

Output 2:
 3221225472
```
#### Example Explanation
```text
Explanation 1:
        00000000000000000000000000000000    
=>      00000000000000000000000000000000

Explanation 2:
        00000000000000000000000000000011    
=>      11000000000000000000000000000000
```
### Hints
* Hint 1
```text
How do you swap the ‘i’th bit with the ‘j’th bit?

Try to figure out if you could use the XOR operation to do it.
```
* Solution Approach
```text
Reversing bits could be done by swapping the n/2 least significant 
bits with its most significant bits.

The trick is to implement a function called swapBits(i, j), which 
swaps the ‘i’th bit with the ‘j’th bit.

If you still remember how XOR operation works:

0 ^ 0 == 0, 
1 ^ 1 == 0, 
0 ^ 1 == 1, and 
1 ^ 0 == 1.

We only need to perform the swap when the ‘i’th bit and 
the ‘j’th bit are different.

To test if two bits are different, we could use the XOR 
operation. Then, we need to toggle both ‘i’th and ‘j’th bits.

We could apply the XOR operation again.

By XOR-ing the ‘i’th and ‘j’th bit with 1, both bits are toggled.

Bonus approach (The divide and conquer approach):

Remember how merge sort works? Let us use an 
example of n == 8 (one byte) to see how this works:


              01101001

             /        \

           0110       1001

          /   \       /   \

         01    10    10    01

        /\     /\    /\     /\

       0  1   1  0  1  0   0  1

The first step is to swap all odd and even bits. After that swap 
consecutive pairs of bits, and so on …

Therefore, only a total of log(n) operations are necessary.

Example:

For the first step, you would do:

    x = ((x & 0x55555555) << 1) | ((x & 0xAAAAAAAA) >> 1);
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
	public long reverse(long A) {
	    long rev = 0;
	    for (int i = 0; i < 32; i++) {
	        rev <<= 1;
	        if ((A & (1 << i)) != 0)
	            rev |= 1;
	    }
	    return rev;
	}
}
```
* * Solution in Javascript
```javascript
module.exports = { 
   //param a : integer
    //return an integer
	reverse : function(num){
          var revnum = 0;
          for( var i = 0; i < 32; i++ ) {
            if( num&1<<i)
              revnum |= 1<<(31-i);
          }
          return revnum>>>0;
	}
};
```
* * Solution in C++
```cpp
unsigned int swapBits(unsigned int x, unsigned int i, unsigned int j) {
    unsigned int lo = ((x >> i) & 1);
    unsigned int hi = ((x >> j) & 1);
    if (lo ^ hi) {
        x ^= ((1U << i) | (1U << j));
    }
    return x;
}

unsigned int Solution::reverse(unsigned int x) {
    unsigned int n = sizeof(x) * 8;
    for (unsigned int i = 0; i < n/2; i++) {
        x = swapBits(x, i, n-i-1);
    }
    return x;
}
```

