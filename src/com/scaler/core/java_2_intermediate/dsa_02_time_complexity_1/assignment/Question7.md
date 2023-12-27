### Q7. Find Time Complexity - 8
#### Problem Description
```text
What is the time complexity of the following code snippet

for(int i = 1 ; i <= n ; i *= 2) {
    for(int j = 1 ; j <= n ; j++){
        print(i + j);
    }
}
```
#### Options
```text
1. O(n^2)
2. O(n log n)
3. O(n)
4. O(1)
```

* Complete Solution
```text
The outer loop runs logn times while the inner loop runs n times.
So, the time complexity is O(n log n)
```

