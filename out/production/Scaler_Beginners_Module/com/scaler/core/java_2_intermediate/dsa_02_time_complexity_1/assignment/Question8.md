### Q8. Find Time Complexity - 10
#### Problem Description
```text
What is the time complexity of the following code snippet

int j = 0;

for(int i = 0 ; i < n ; i++){
    while(j <= i){
        print(i + j);
        j++;
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
The print statement executes once for every outer for loop iteration. 
So the time complexity is O(n)
```

