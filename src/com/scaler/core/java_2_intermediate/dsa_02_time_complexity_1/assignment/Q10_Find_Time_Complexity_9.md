### Q10. Find Time Complexity - 9
#### Problem Description
```text
What is the time complexity of the following code snippet

for(int i = 1 ; i <= n ; i++) {
    for(int j = 1 ; j <= 3^i ; j++) {
        print(i + j);
    }
}
```
#### Options
```text
1. O(n^2)
2. O(n log n)
3. O(2^n)
4. O(3^n)
```

* Complete Solution
```text
The print statement executes for (3^1 + 3^2 + 3^3 + .. + 3^n) times 
which is (3^n - 1)/2

So, time complexity is O(3^n).
```

