### Q4. GCD_CMPL
#### Problem Description
```text
In the following C++ function, let n >= m.
```
```cpp
int gcd(int n, int m) {
    if (n%m ==0) return m;
    if (n < m) swap(n, m);
    while (m > 0) {
        n = n%m;
        swap(n, m);
    }
    return n;
}
```
```text
What is the time complexity of the above function assuming n > m?.
Θ symbol represents theta notation and Ω symbol represents omega notation.
```
#### Problem Constraints
```text

```
#### Input Format
```text

```
#### Output Format
```text

```
#### Example Input
```text

```
#### Example Output
```text

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

```text
Let us say n = fibonacci(N) and m = fibonacci(N - 1)

fibonacci(N) = fibonacci(N-1) + fibonacci(N-2)

OR n = m + k where k < m. 

Therefore the step 

    n = n % m will make n = k

    swap(n, m) will result in

    n = fibonacci(N-1)

    m = k = fibonacci(N-2)

So, it will take N steps before m becomes 0.

This means, in the worst case, this algorithm can take N step 
if **n** is Nth fibonacci number. 

**Think of whats the relation between N and n**. 


```

```java

```
* * Solution in Javascript
```javascript

```
* * Solution in C++
```cpp

```

