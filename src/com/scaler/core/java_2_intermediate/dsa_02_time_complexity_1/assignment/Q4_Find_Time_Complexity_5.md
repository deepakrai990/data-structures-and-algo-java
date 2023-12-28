### Q4. Find Time Complexity - 5
#### Problem Description
```text
What is the time complexity of the following code snippet

int func(int n) {
    int s = 0;
    for(int i = 0 ; i < n ; i = i * 2){
        s = s + i;
    }
    return s;
}
```
 
#### Options
```text
1. O(n)
2. O(n^(1/2)))
3. O(log n)
4. O(∞)
```

* Complete Solution
```text
The answer is O(∞).
The loop is an infinite loop as the value of i initialized with 0 doesn't 
change on multiplication by 2
```

