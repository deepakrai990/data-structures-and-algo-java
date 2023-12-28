## Q2. Time and Space Complexity - I
#### Problem Description 
```text
What is the time and space complexity for printing the 
sum of each subarray?
```

```java
public class Solution {
    public static void printSums(int ar[]) {
        int n = ar.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + ar[j];
                print(sum);
            }
        }
    }
}
```
### Options
```text
1. TC = O(N) , SC = O(1)
2. TC = O(N^2) , SC = O(1)
3. TC = O(N) , SC = O(N)
4. TC = O(N^2) , SC = O(N)
```

* Complete Solution
```text
The time complexity for the given code is O(N^2)
while the space complexity is O(1).
```