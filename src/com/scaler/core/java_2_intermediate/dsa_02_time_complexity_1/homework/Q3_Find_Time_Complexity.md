### Q3. Find Time Complexity
#### Problem Description
```text
What will be the time complexity of the above function where n is 
a positive integer?
```
<pre>public void function (int n) {
    while (n &gt; 0) {
        n++;
        n -= 2;
    }
}
</pre>

#### Options
```text
1. Infinite loop
2. O(n)
3. O(n log n)
4. O(log n)
5. None of the above
```

* Complete Solution
```text
What is the number of operations in the while loop?

Overall, in each iteration, the value of n decreases by 1. So, 
there would be a total of n operations.

Hence, the time complexity is O(n).
```

