### Q9. Time-Complexity-5
#### Problem Description
```text
What is the time complexity of following code:
 
int a = 0, i = N; 
while (i > 0) { 
    a += i; 
    i /= 2; 
}
```
#### Options
```text
1. O(N)
2. O(sqrt(N))
3. O(N/2)
4. O(log N)
```

* Complete Solution
```text
We have to find the smallest x such that N / 2^x N
x = log(N)
```

