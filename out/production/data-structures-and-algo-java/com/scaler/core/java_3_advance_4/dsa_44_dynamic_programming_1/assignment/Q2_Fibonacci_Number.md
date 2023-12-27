### Q2. Fibonacci Number
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given a positive integer <strong>A</strong>, write a program to find the 
    <strong>A<sup>th</sup></strong> Fibonacci number.</p>
    <p>In a Fibonacci series, each term is the sum of the previous two terms and the 
    first two terms of the series are <strong>0</strong> and <strong>1</strong>. i.e. 
    <strong>f(0) = 0</strong> and <strong>f(1) = 1</strong>. Hence, 
    <strong>f(2) = 1, f(3) = 2, f(4) = 3</strong> and so on.</p>
    <p><strong>NOTE:</strong> 0<sup>th</sup> term is 0. 1<sup>th</sup> term is 1 
    and so on.</p>
</div>

```text
Given a positive integer A, write a program to find the A^th Fibonacci number.

In a Fibonacci series, each term is the sum of the previous two terms and the first 
two terms of the series are 0 and 1. 
i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.

NOTE: 0^th term is 0. 1^th term is 1 and so on.
```
#### Problem Constraints
```text
0 <= A <= 44
```
#### Input Format
```text
First and only argument is an integer A.
```
#### Output Format
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Return an integer denoting the <strong>A<sup>th</sup></strong> 
    Fibonacci number.</p>
</div>

```text
Return an integer denoting the A^th Fibonacci number.
```
#### Example Input
```text
Input 1:
 A = 4

Input 2:
 A = 6
```
#### Example Output
```text
Output 1:
 3

Output 2:
 8
```
#### Example Explanation
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p> Explanation 1:</p>
    <pre> Terms of Fibonacci series are: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
    0<sup>th</sup> term is 0 So, 4<sup>th</sup> term of Fibonacci series is 3. </pre>
    <p> Explanation 2:</p>
    <pre> 6<sup>th</sup> term of Fibonacci series is 8.</pre>
</div>

```text
Explanation 1:
     Terms of Fibonacci series are: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
     0^th term is 0 So, 4^th term of Fibonacci series is 3. 

Explanation 2:
    6^th term of Fibonacci series is 8.
```
### Hints
* Hint 1
```text
Relation between terms of Fibonacci series if given. Use that to generate the series.
```
* Solution Approach
```text
Approach 1:

A simple approach is to use the recursive implementation of the recursive relation given.

For ex: Calculate 4th term.

               fib(4)   
             /        \     
         fib(3)      fib(2)
        /    \       /    \     
  fib(2)   fib(1)  fib(1) fib(0)
  /     \
fib(1) fib(0)
We can see that the 2nd term is calculated multiple times.

If we try to find large Fibonacci numbers, there will be more and more repetitions that are bad.

Time complexity of above: T(n) = T(n-1) + T(n-2) is exponential.

To avoid this, try to store the term which is calculated once and before calculating any other term check if it is already calculated or not.

If we already have that term use that. This will save us a lot of repetitions.

In this we are only calculating each term once, So, time complexity will be linear.

Approach 2

We can easily generate the Fibonacci series iteratively in linear time.

Initialise: fib[0] = 0, fib[1] = 1

for i from 2 to A.
    fib[i] = fib[i-1] + fib[i-2].
fib[A] will be our answer.

Try to write a solution without using any extra memory.
```
* Complete Solution
* * Solution in Java
```java
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fib = new int[n + 1]; //  fib[i] denotes the i'th fibonacci number
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++)
            fib[i] = fib[i - 1] + fib[i - 2];
        System.out.println(fib[n]);
    }
}
```
* * Solution in Javascript
```javascript
process.stdin.resume();
process.stdin.setEncoding("utf8");
var arr = "";
process.stdin.on("data", function (chunk) {
  arr += chunk;
});
process.stdin.on("end", function () {
  let st = +arr;
  if (st <= 1) {
    console.log(st);
    return;
  }
  let a = 0,
    b = 1;
  for (let i = 2; i <= st; i++) {
    let tp = b;
    b += a;
    a = tp;
  }
  console.log(b);
});
```
* * Solution in C++
```cpp
#include<iostream>

using namespace std;

int main() {
  int A;
  cin >> A;
  int fib[A + 1]; // fib[i] denotes the i'th fibonacci number
  fib[0] = 0;
  fib[1] = 1;

  for (int i = 2; i < A + 1; i++) {
    fib[i] = fib[i - 1] + fib[i - 2];
  }

  cout << fib[A];
  return 0;
}
```

