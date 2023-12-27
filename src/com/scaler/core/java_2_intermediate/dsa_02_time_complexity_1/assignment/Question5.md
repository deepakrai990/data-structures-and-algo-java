### Q5. Find Time Complexity - 6
#### Problem Description
```text
What is the time complexity of the following code snippet

for(int i = 1 ; i <= 100 ; i *= 2){
    for(int j = 1 ; j <= n ; j++){
        print(i + j);
    }
}
```
#### Options
```text
1. O(n^2)
2. O(n)
3. O(n log n)
4. O(1)
```

* Complete Solution
```text
The outer loop runs for a constant time. 
The inner loop runs n times.
Thus the answer is O(n)
```

