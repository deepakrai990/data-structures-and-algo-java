### Q2. Time Complexity - 7

What is the time complexity of the following code snippet?

* C++
* Java
* Python

```java
int function(int n){
   if(n % 2 == 0){
      return 0;
   }
   return function(n-1) + function(floor(n/2));
}
```
```java
int function(int n){
   if(n % 2 == 0){
      return 0;
   }
   return function(n-1) + function(Math.floor(n/2));
}
```
```java
def function(self, n):
    if n%2 == 0:
        return 0

    return function(n-1) + function(math.floor(n/2))
```

### Solution Approach
```text
Observe the base case and floor of odd numbers of the 
recursive function.
```

### Complete Solution
```text
The floor function will always result an odd number if the 
number is 2^k-1 .Hence the time complexity will be o(logn)
```
