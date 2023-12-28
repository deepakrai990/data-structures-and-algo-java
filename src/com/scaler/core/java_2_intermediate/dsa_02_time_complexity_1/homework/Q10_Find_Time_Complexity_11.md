### Q10. Find Time Complexity - 11
#### Problem Description
```text
What is the time complexity of the following code snippet

    for(int i = 1 , j = 1 ; j <= n ; i++) {
        print(i + j);
        if(i % n == 0) {
            j++;
        }
    }
```
#### Options
```text
1. O(n^3)
2. O(n^2)
3. O(n)
4. O(log n)
```

* Complete Solution
```text
The loop runs till j <= n.

The value of j gets incremented after every n-iterations 
when i % n = 0

So, the time complexity is O(n^2).
```

